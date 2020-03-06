package com.cmbchina.enums;

public enum RespCodeEnum {
    SUCCESS("1000", "成功"),

    UNKNOWN_INTERFACE("1001", "接口不存在"),
    SYS_ERROR_RETRY_LATER("9990", "系统繁忙，请稍后重试[{}]"),
    REMOTE_INTERFACE_ERROR("9992", "RPC接口错误"),
    INNER_ERROR("9993", "内部错误"),
    UNKNOWN_ERROR("9994", "未知错误"),
    TOO_MANY_RECORD_TO_BE_UPDATE("9995", "更新数据异常，只被允许更新一条记录"),
    OPERATOR_LOG_VO_NOT_EXISTS("9996", "系统异常，log元数据错误"),
    OPRATION_TOO_MANY("9997", "操作频繁，请稍后重试"),
    PARAM_ERROR("9998", "请求参数错误"),
    SYS_ERROR("9999", "系统异常");

    RespCodeEnum(String code, String message) {
        this.setRespCode(code);
        this.setRespMsg(message);
    }

    private String respCode;
    private String respMsg;

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
}
