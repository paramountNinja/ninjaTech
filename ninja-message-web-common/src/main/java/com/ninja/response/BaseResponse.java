package com.ninja.response;

import com.ninja.enums.RespCodeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T> implements Serializable {

    protected String respCode;
    protected String respMsg;
    protected T respData;

    public BaseResponse() {
    }

    public BaseResponse(String respCode, String respMsg, T respData) {
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.respData = respData;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public T getRespData() {
        return respData;
    }

    public void setRespData(T respData) {
        this.respData = respData;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return RespCodeEnum.SUCCESS.getRespCode().equals(this.respCode);
    }
}
