package com.mrlanwx.springbootshirodemo.common.exception;

import com.mrlanwx.springbootshirodemo.common.enums.CodeEnum;

/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 11:14
 * @Description:
 */
public class ItcljException extends RuntimeException {
    private int code;
    private String message;

    public ItcljException(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public ItcljException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ItcljException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
