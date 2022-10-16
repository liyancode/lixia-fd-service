package io.github.liyancode.lixiafdservice.infra.persistant.object.iprm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.liyancode.lixiafdservice.infra.persistant.object.BasePO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author liyancode
 * @date 2022/10/14
 * @description
 */
@Getter
@Setter
@ToString(callSuper = true)
@TableName("fd_person")
public class PersonPO extends BasePO {
    @TableId
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

    @TableField("phone_no_1")
    private String phoneNo1;

    @TableField("phone_no_2")
    private String phoneNo2;

    @TableField("address_1")
    private String address1;

    @TableField("address_2")
    private String address2;

    private String wechatId;
    private String qqNo;
    private String email;
    private String description;
}
