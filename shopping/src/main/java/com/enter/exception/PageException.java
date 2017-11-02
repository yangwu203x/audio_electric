package com.enter.exception;

import com.enter.util.enums.RetCode;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/10/18 0018 10:04
 */
public class PageException extends RuntimeException {
    private Integer code;

    public PageException(RetCode retCode) {
        super(retCode.getMsg());
        this.code = retCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
