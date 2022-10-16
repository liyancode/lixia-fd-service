package io.github.liyancode.lixiafdservice.infra.persistant.object;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liyancode
 * @date 2022/10/14
 * @description
 */
@Getter
@Setter
public class BasePO implements Serializable {

    private String creator = "system";

    private Date createTime = new Date();

    private String operator = "system";

    private Date lastUpdateTime = new Date();

    private int version = 0;

    private Integer deleteFlag = 0;

    private Integer enableFlag = 1;
}
