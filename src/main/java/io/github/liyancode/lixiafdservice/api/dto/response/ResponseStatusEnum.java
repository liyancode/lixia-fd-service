package io.github.liyancode.lixiafdservice.api.dto.response;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */
public enum ResponseStatusEnum {
    /**
     * Response Success
     */
    SUCCESS,
    /**
     * Duplicate Request
     */
    DUPLICATE,
    /**
     * Timeout Request
     */
    TIMEOUT,
    /**
     * Response Fail
     */
    FAIL,
    ;
}
