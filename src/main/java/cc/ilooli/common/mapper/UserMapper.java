package cc.ilooli.common.mapper;

import cc.ilooli.common.pojo.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户映射器
 *
 * @author OVO
 * @date 2021/11/12
 */
@Mapper
public interface UserMapper {
    /**
     * 得到的信息
     * 通过用户名获取用户
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link UserDO}
     */
    UserDO getByInfo(String username, String password);

    /**
     * 保存
     *
     * @param userDO 用户DO
     * @return boolean
     */
    boolean save(UserDO userDO);

    /**
     * 更新
     *
     * @param userDO 用户DO
     * @return boolean
     */
    boolean update(UserDO userDO);

    /**
     * 更新密码
     *
     * @param id       id
     * @param password 密码
     * @return boolean
     */
    boolean updatePassword(Long id, String password);

    /**
     * 删除
     *
     * @param id id
     * @return int
     */
    boolean delete(int id);
}
