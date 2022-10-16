package io.github.liyancode.lixiafdservice.domain.module;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */
@Getter
@Setter
public class BaseDO {

    private String creator = "system";

    private Date createTime = new Date();

    private String operator = "system";

    private Date lastUpdateTime = new Date();

    private Integer version = 0;

    private Integer deleteFlag = 0;

    private Integer enableFlag = 1;
}
