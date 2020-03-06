package com.cmbchina.web.controller;

import com.cmbchina.enums.RespCodeEnum;
import com.cmbchina.exception.BaseBusinessException;
import com.cmbchina.response.BaseResponse;
import com.cmbchina.util.WrapperResponseUtil;
import com.cmbchina.web.request.DemoRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2020/3/4
 */
@RestController
public class NinjaController {

    public static ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/test/valid")
    public ResponseEntity<BaseResponse> validTest(@Valid @RequestBody DemoRequest demoRequest
            , BindingResult bindingResult) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            throw new BaseBusinessException(RespCodeEnum.PARAM_ERROR.getRespCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(objectMapper.writeValueAsString(demoRequest));
        return ResponseEntity.ok(WrapperResponseUtil.ok(RespCodeEnum.SUCCESS.getRespCode()));
    }
}
