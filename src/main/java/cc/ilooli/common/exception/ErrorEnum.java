package cc.ilooli.common.exception;

/**
 * 错误枚举
 *
 * @author OVO
 * @date 2021/11/15
 */
public enum ErrorEnum {
    //
    CODE_200(200, "成功"),
    CODE_400(400,"错误的参数请求"),
    CODE_401(401, "未登录系统，无权限执行"),
    CODE_403(403, "已登录系统，但无权限执行"),
    CODE_404(404, "资源未找到，请重试"),

    CODE_1001(1001, "获取产品信息失败，请检查输入信息或等待物料数据同步至MES"),
    CODE_1002(1002, "获取本体信息失败，请检查本体物料是否存在"),
    CODE_1003(1003, "获取到多个本体物料，请删除多余本体物料并等待MES数据库同步后重试"),
    CODE_1004(1004, "获取附件信息失败，请检查附件信息后重试"),
    CODE_1005(1005, "获取到多个附件物料，请删除多余附件物料并等待MES数据库同步后重试")
    ;
    private final Integer code;
    private final String message;

    ErrorEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
