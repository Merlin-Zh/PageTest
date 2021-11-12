package cc.ilooli.common.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 用户DO
 *
 * @author OVO
 * @date 2021/11/12
 */
@Data
public class UserDO {
    /** id */
    private Long id;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 许可 */
    private String permission;
    /** 名字 */
    private String name;
    /** 部门 */
    private String dept;
    /** 状态 */
    private Integer status;
    /** 创建时间 */
    private Date createTime;
    /** 修改时间 */
    private Date modifiedTime;
}
