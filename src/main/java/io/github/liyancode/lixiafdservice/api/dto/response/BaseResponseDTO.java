package io.github.liyancode.lixiafdservice.api.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class BaseResponseDTO<T> implements Serializable {
    /**
     * requestId from request
     */
    private String requestId= UUID.randomUUID().toString();
    /**
     * response DateTime
     */
    private Date responseDateTime = new Date();
    /**
     * response Status
     */
    private ResponseStatusEnum responseStatus = ResponseStatusEnum.SUCCESS;
    /**
     * response error code
     */
    private String responseErrorCode;
    /**
     * response error message
     */
    private String responseErrorMsg;
    /**
     * result
     */
    private T results;

    public static BaseResponseDTO buildFailureResp(String errCode, String errMsg, String requestId) {
        BaseResponseDTO resp = new BaseResponseDTO();
        resp.setResponseDateTime(new Date());
        resp.setResponseStatus(ResponseStatusEnum.FAIL);
        resp.setResponseErrorCode(errCode);
        resp.setResponseErrorMsg(errMsg);
        resp.setRequestId(requestId);
        return resp;
    }
}

