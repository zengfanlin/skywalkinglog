package com.example.provider;


/**
 * 业务异常类
 *
 * @author fanlin.zeng
 * @date 2017/11/10 11:24
 */
public class CustomerException extends BaseException {
    private ResultCodeEnum errorCode;

    public CustomerException() {
        super();
    }

    public CustomerException(Throwable ex) {
        super(ex);
    }

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(String message, Throwable ex) {
        super(message, ex);
    }

    public CustomerException(ResultCodeEnum errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public ResultCodeEnum getCode() {
        return errorCode == null ? ResultCodeEnum.INTERNAL_SERVER_ERROR : errorCode;
    }
}
