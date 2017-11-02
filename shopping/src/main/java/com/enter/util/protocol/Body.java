package com.enter.util.protocol;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * Created by yangwu on 2017/3/21 0021.
 */
public class Body<T>{
    /**
     * 返回代码
     * 参见枚举类RetCode
     */
    private int responseCode;
    private String resultMessage;
    /**
     * 0:常量，1:json对象，2:json对象数组
     */
    private int dataType;
    /**
     * 返回数据
     */
    private T responseData;

    public Body() {
    }


    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }
}
