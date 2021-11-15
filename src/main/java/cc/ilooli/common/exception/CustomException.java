package cc.ilooli.common.exception;

import java.io.Serial;
import java.io.Serializable;

/**
 * 自定义异常
 *
 * @author OVO
 * @date 2021/11/15
 */
public class CustomException extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer code;

    public CustomException(){}

    public CustomException(ErrorEnum errorEnum){
        super(errorEnum.getMessage());
        this.code = errorEnum.getCode();
    }

    public CustomException(int code, String messgae){
        super(messgae);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
