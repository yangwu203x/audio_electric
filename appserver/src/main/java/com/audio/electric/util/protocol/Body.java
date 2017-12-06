package com.audio.electric.util.protocol;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.audio.electric.util.enums.DataType;
import com.github.pagehelper.Page;

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
    private String responseMessage;
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

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
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
        StringBuffer sb = new StringBuffer();
        sb.append("{\"responseCode\":").append(responseCode);
        sb.append(",\"responseMessage\":\"").append(responseMessage).append("\"");
        sb.append(",\"dataType\":").append(dataType);
        Object res = null;
        if (responseData != null){
            if (DataType.Array.getType()  == dataType){
                //数组
                if (responseData instanceof List ){
                    List list = (List)responseData;
                    long totalNum = ((Page)list).getTotal();
                    int curPage = ((Page)list).getPageNum();
                    int totalPages = ((Page)list).getPages();
                    sb.append(",\"totalNum\":").append(totalNum);
                    sb.append(",\"curPage\":").append(curPage);
                    sb.append(",\"totalPages\":").append(totalPages);
                }
            }
            res = responseData != null ? JSON.toJSONString(responseData, SerializerFeature.WriteMapNullValue).toString() : responseData;
        }
        sb.append(", \"responseData\":").append(res).append("}");
        return sb.toString();
//                "{" +
//                "\"responseCode\":" + responseCode +
//                ", \"responseMessage\":\"" + responseMessage + '\"' +
//                ", \"dataType\":" + dataType +
//                ", \"responseData\":" + res +
//                '}';
    }
}
