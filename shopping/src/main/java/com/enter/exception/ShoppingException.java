package com.enter.exception;

import com.enter.util.enums.RetCode;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/17 0017 10:37
 */
public class ShoppingException extends RuntimeException {
    private Integer code;

    public ShoppingException(RetCode retCode) {
        super(retCode.getMsg());
        this.code = retCode.getCode();
    }

    public ShoppingException(RetCode retCode,String msg) {
        super(msg);
        this.code = retCode.getCode();
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
