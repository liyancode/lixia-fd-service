package io.github.liyancode.lixiafdservice.api.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BaseRequestDTO implements Serializable {
    /**
     * requestId
     */
    private String requestId;
    /**
     * request DateTime
     */
    private Date requestDateTime = new Date();

}
