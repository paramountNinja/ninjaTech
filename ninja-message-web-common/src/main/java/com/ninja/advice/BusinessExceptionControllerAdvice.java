package com.ninja.advice;


import com.ninja.enums.RespCodeEnum;
import com.ninja.exception.BaseBusinessException;
import com.ninja.response.BaseResponse;
import com.ninja.util.WrapperResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by o2o724 on 2017/11/22.
 */
@Slf4j
@ControllerAdvice
public class BusinessExceptionControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(BusinessExceptionControllerAdvice.class);

    @Autowired
    private ObjectMapper objectMapper;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> processBaseBusinessException(HttpServletRequest request, Exception exception) {
        BaseResponse baseResponse = null;
        try {
            if (exception instanceof BaseBusinessException) {
                BaseBusinessException baseBusinessException = (BaseBusinessException) exception;
                baseResponse = WrapperResponseUtil.failed(baseBusinessException.getExceptionCode(), baseBusinessException.getExceptionMessage());
            } else {
                log.error("{} request happen business Exception", request.getRequestURI(), exception);
                baseResponse = WrapperResponseUtil.failed(RespCodeEnum.SYS_ERROR);
            }
            log.error("{} request happen business Exception:{}", request.getRequestURI(), objectMapper.writeValueAsString(baseResponse));
        } catch (Exception e) {
            baseResponse = WrapperResponseUtil.retryLater(RespCodeEnum.SYS_ERROR.getRespCode());
        }
        return ResponseEntity.ok(baseResponse);
    }
}
