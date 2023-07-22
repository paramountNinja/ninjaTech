package com.ninja.exception;

import com.ninja.enums.RespCodeEnum;
import com.ninja.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;

public class BaseBusinessException extends RuntimeException {
    @Getter
    private String exceptionCode;

    @Getter
    private String exceptionMessage;

    @Getter
    @Setter
    private Throwable cause;

    public BaseBusinessException(String exceptionCode, String exceptionMessage) {
        super(exceptionMessage);
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }

    public BaseBusinessException(RespCodeEnum respCodeEnum) {
        super(respCodeEnum.getRespMsg());
        this.exceptionCode = respCodeEnum.getRespCode();
        this.exceptionMessage = respCodeEnum.getRespMsg();
    }

    public BaseBusinessException(BaseResponse baseResponse) {
        super(baseResponse.getRespMsg());
        this.exceptionCode = baseResponse.getRespCode();
        this.exceptionMessage = baseResponse.getRespMsg();
    }

    public BaseBusinessException(BaseResponse baseResponse, String exceptionMessage) {
        super(exceptionMessage);
        this.exceptionCode = baseResponse.getRespCode();
        this.exceptionMessage = exceptionMessage;
    }
}
