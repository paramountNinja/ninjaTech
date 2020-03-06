package com.cmbchina.util;

import com.cmbchina.enums.RespCodeEnum;
import com.cmbchina.response.BaseResponse;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.cmbchina.enums.RespCodeEnum.SUCCESS;

/**
 * @Author by AA2668 on 2019/8/30.
 */
public class WrapperResponseUtil {

    public static <E extends Object> BaseResponse<E> ok(E o) {
        return ok(SUCCESS, o);
    }

    public static <E extends Integer> BaseResponse<E> ok(E o) {
        return ok(SUCCESS, o);
    }

    public static <E extends String> BaseResponse<E> ok(E o) {
        return ok(SUCCESS, o);
    }

    public static <E extends List> BaseResponse<E> ok(E o) {
        return ok(SUCCESS, o);
    }

    public static <E extends Boolean> BaseResponse<E> ok(E o) {
        return ok(SUCCESS, o);
    }

    public static <E> BaseResponse<E> ok(RespCodeEnum respCodeEnum, E o) {
        return new BaseResponse<E>(respCodeEnum.getRespCode(), respCodeEnum.getRespMsg(), o);
    }

    public static <E> BaseResponse<E> failed(RespCodeEnum respCodeEnum) {
        return new BaseResponse<E>(respCodeEnum.getRespCode(), respCodeEnum.getRespMsg(),null);
    }

    public static <E> BaseResponse<E> failed(RespCodeEnum respCodeEnum, E o) {
        return new BaseResponse<E>(respCodeEnum.getRespCode(), respCodeEnum.getRespMsg(), o);
    }

    public static <E> BaseResponse<E> failed(String respCode, String respMsg, E o) {
        return new BaseResponse<E>(respCode, respMsg, o);
    }

    public static <E> BaseResponse<E> failed(String respCode, String respMsg) {
        return new BaseResponse<E>(respCode, respMsg, null);
    }

    public static <E> BaseResponse<E> retryLater(String respCode) {
        return failed(RespCodeEnum.SYS_ERROR_RETRY_LATER.getRespCode()
                , StringUtils.replace(RespCodeEnum.SYS_ERROR_RETRY_LATER.getRespMsg(),"{}",respCode));
    }
}
