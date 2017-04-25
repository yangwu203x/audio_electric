package com.audio.electric.util.exception;

import com.audio.electric.util.enums.RetCode;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 15:31
 */
public class PlatException extends RuntimeException {
    private Integer code;

    public PlatException(RetCode retCode) {
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
