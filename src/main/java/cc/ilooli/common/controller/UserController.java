package cc.ilooli.common.controller;

import cc.ilooli.common.mapper.UserMapper;
import cc.ilooli.common.result.BaseResult;
import cc.ilooli.common.pojo.UserDO;
import cc.ilooli.common.pojo.UserVO;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户控制器
 *
 * @author OVO
 * @date 2021/11/12
 */
@RestController("/user")
public class UserController {

    private static final Log logger = LogFactory.get();
    private final UserMapper mapper;

    public UserController(UserMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/login")
    public BaseResult<?> login(@RequestBody UserVO userVO, HttpServletRequest request) {
        UserDO userDO = mapper.getByInfo(userVO.getUsername(), userVO.getPassword());
        if (userDO == null) {
            return BaseResult.error(404, "用户名或密码错误，请确认后重试！");
        }
        if (userDO.getStatus() == 0) {
            return BaseResult.error(403, "该用户已被锁定，无法登录，请联系管理员！");
        }

        try {
            StpUtil.login(userDO.getId());
            StpUtil.getSessionByLoginId(userDO.getId()).set("username", userDO.getUsername());
            StpUtil.getSessionByLoginId(userDO.getId()).set("id", userDO.getId());
            logger.info("来自 {} 的用户 {} 登录成功，用户名：{}", request.getRemoteAddr(), userDO.getId(), userDO.getUsername());
            return BaseResult.success();
        } catch (Exception e) {
            return BaseResult.error(500, "登录失败");
        }
    }

    @GetMapping("/login")
    public BaseResult<Boolean> login(HttpServletRequest request) {
        try {
            Boolean loginStatus = StpUtil.isLogin();
            logger.info("来自 {} 的用户请求查询登录状态，结果为：{}", request.getRemoteAddr(), loginStatus);
            return BaseResult.success(loginStatus);
        } catch (Exception e) {
            logger.error("来自 {} 的用户请求查询登录状态，却没有cookies", request.getRemoteAddr());
            return BaseResult.success(false);
        }
    }

    @GetMapping("/logout")
    public BaseResult<Boolean> logout(HttpServletRequest request) {
        try {
            logger.info("用户 {} 注销", StpUtil.getLoginId());
            StpUtil.logout();
            return BaseResult.success();
        } catch (Exception e) {
            logger.error("用户请求注销，但是失败了，可能他/她没有登录吧");
            return BaseResult.error(500, "注销失败");
        }
    }

    @GetMapping("/list")
    @SaCheckLogin
    @SaCheckPermission("admin")
    public BaseResult<List<UserVO>> getList() {
        return BaseResult.success();
    }
}
