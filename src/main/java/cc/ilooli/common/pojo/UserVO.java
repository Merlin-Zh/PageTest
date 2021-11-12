package cc.ilooli.common.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 用户VO
 *
 * @author OVO
 * @date 2021/11/12
 */
@Data
public class UserVO {
    /** id */
    private Long id;
    /** 用户名 */
    @NotBlank(message = "用户名不能为空")
    private String username;
    /** 密码 */
    @Size(min = 5, max = 20, message = "密码长度需在5~20位之间")
    private String password;
    /** 权限 */
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
