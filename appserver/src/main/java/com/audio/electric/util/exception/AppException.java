package com.audio.electric.util.exception;

import com.audio.electric.util.enums.RetCode;

/**
 * Created by yangwu on 2017/3/30 0030.
 */
public class AppException extends RuntimeException {

    private Integer code;

    public AppException(RetCode retCode) {
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
