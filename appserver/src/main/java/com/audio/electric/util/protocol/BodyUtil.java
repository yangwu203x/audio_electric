package com.audio.electric.util.protocol;

import com.audio.electric.util.enums.DataType;
import com.audio.electric.util.enums.RetCode;

/**
 * Created by yangwu on 2017/3/28 0028.
 */
public class BodyUtil {


    public static Body result(int result){
        if (result > 0){
            return success();
        }else{
            return error(RetCode.UNKNOWN_ERROR);
        }
    }
    /**
     * 成功
     * @param object
     * @param dataType
     * @return
     */
    public static Body sucess(Object object , DataType dataType){
        Body body = new Body();
        body.setResponseCode(RetCode.SUCCESS.getCode());
        body.setResponseMessage(RetCode.SUCCESS.getMsg());
        body.setDataType(dataType.getType());
        body.setResponseData(object);
        return body;
    }

    public static Body success(){
        return sucess(null,DataType.Constant);
    }

    /**
     * 异常返回
     * @param code
     * @param message
     * @return
     */
    public static Body exception(Integer code,String message){
        Body body = new Body();
        body.setResponseCode(code);
        body.setResponseMessage(message);
        body.setDataType(DataType.Object.getType());
        body.setResponseData(null);
        return body;
    }


    /**
     * 失败
     * @param retCode
     * @return
     */
    public static Body error(RetCode retCode){
        Body body = new Body();
        body.setResponseCode(retCode.getCode());
        body.setResponseMessage(retCode.getMsg());
        body.setDataType(DataType.Object.getType());
        body.setResponseData(null);
        return body;
    }
}
