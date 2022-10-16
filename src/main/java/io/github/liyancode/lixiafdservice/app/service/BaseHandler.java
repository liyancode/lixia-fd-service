package io.github.liyancode.lixiafdservice.app.service;

import io.github.liyancode.lixiafdservice.api.dto.response.BaseResponseDTO;
import io.github.liyancode.lixiafdservice.api.dto.response.RespErrorCodeEnum;
import io.github.liyancode.lixiafdservice.api.dto.response.ResponseStatusEnum;
import io.github.liyancode.lixiafdservice.infra.persistant.util.SnowflakeIdUtils;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */
public class BaseHandler {
    protected SnowflakeIdUtils snowflakeIdUtils = new SnowflakeIdUtils(11L, 10L);

    protected BaseResponseDTO respBizDataError(String errorMsg) {
        return respError(ResponseStatusEnum.FAIL, RespErrorCodeEnum.BIZ_DATA_ERROR, errorMsg);
    }

    protected BaseResponseDTO respDBOprError(String errorMsg) {
        return respError(ResponseStatusEnum.FAIL, RespErrorCodeEnum.DB_OPR_ERROR, errorMsg);
    }

    protected BaseResponseDTO respExceptionCatch(String errorMsg) {
        return respError(ResponseStatusEnum.FAIL, RespErrorCodeEnum.EXCEPTION_CATCH, errorMsg);
    }

    protected BaseResponseDTO respError(ResponseStatusEnum responseStatus, RespErrorCodeEnum respErrorCode, String errorMsg) {
        BaseResponseDTO resDTO = new BaseResponseDTO<>();
        resDTO.setResponseStatus(responseStatus);
        resDTO.setResponseErrorCode(respErrorCode.toString());
        resDTO.setResponseErrorMsg(errorMsg);
        return resDTO;
    }
}
