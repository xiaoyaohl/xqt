package com.dream.xqt.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xinxiaoyao
 * @date 2022/11/6 12:49
 */
@Data
public class UserInfoVO {
    /**
     * 昵称
     */
    private  String nickName;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * qq号码
     */
    private String qq;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 学号
     */
    private String studentId;

    /**
     * 学校信息
     */
    private UniversityVO universityVO;

    /**
     * 班级信息
     */
    private ClassVO classVO;

    /**
     * 头像
     */
    private String faceImg;

    /**
     * qq open id
     */
    private String qqOpenId;

    /**
     * qq union id
     */
    private String qqUnionId;

    /**
     * open id
     */
    private String openId;

    /**
     * union_id
     */
    private String unionId;

    /**
     * 积分
     */
    private BigDecimal point;

    /**
     * 余额
     */
    private BigDecimal amount;

    /**
     * 专业信息
     */
    private SpecialtyVO specialtyVO;
}
