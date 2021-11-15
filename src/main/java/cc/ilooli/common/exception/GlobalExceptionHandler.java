package cc.ilooli.common.exception;

import cc.ilooli.common.result.BaseResult;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理程序
 *
 * @author OVO
 * @date 2021/11/15
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Log logger = LogFactory.get();

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public <T> BaseResult<?> defultExcepitonHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if (e instanceof CustomException customException) {
            logger.error("业务异常：" + e.getMessage());
            return BaseResult.error(customException.getCode(), "\\n" + customException.getMessage());
        }
        //未知错误
        return BaseResult.error(-1, "\\n系统异常: " + e.getMessage());
    }
}
