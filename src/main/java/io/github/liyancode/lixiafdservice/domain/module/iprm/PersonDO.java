package io.github.liyancode.lixiafdservice.domain.module.iprm;

import io.github.liyancode.lixiafdservice.domain.module.BaseDO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */
@Getter
@Setter
@Accessors(chain = true)
@ToString(callSuper = true)
public class PersonDO extends BaseDO {
    private Long fdPersonId;
    private String personId;
    private String fullName;
    private String fullNameCn;
    private Integer gender;
    private Integer age;
    private Double height;
    private Double weight;
    private Date birthDate;
    private Integer maritalStatus;
    private String hometown;
    private String nationality;
    private String ethnicGroup;
    private String belief;
    private String disposition;
    private String eduLevel;
    private String majorSkill;
    private String occupation;
    private String workPlace;
    private String jobTitle;
    private String employer;
    private String incomeLevel;
    private String livingCity;
    private String phoneNo1;
    private String phoneNo2;
    private String address1;
    private String address2;
    private String wechatId;
    private String qqNo;
    private String email;
    private String description;
}
