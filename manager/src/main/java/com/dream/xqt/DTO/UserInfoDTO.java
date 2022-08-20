package com.dream.xqt.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xinxiaoyao
 * @date 2022/7/27 00:52
 */
@Data
@TableName("user_info")
public class UserInfoDTO {
    /**
     * 主键id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 用户姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * qq号码
     */
    @TableField(value = "qq")
    private String qq;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 学号
     */
    @TableField(value = "student_id")
    private String student_id;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 学校id
     */
    @TableField(value = "university_id")
    private Integer universityId;

    /**
     * 专业id
     */
    @TableField(value = "specialty_id")
    private Integer specialtyId;

    /**
     * 班级id
     */
    @TableField(value = "class_id")
    private Integer classId;

    /**
     * 头像链接
     */
    @TableField(value = "face_img")
    private String faceImg;

    /**
     * qq open id
     */
    @TableField(value = "qq_open_id")
    private String qqOpenId;

    /**
     * qq union id
     */
    @TableField(value = "qq_union_id")
    private String qqUnionId;

    /**
     * open id
     */
    @TableField(value = "open_id")
    private String openId;

    /**
     * union_id
     */
    @TableField(value = "union_id")
    private String unionId;

    /**
     * 积分
     */
    @TableField(value = "point")
    private BigDecimal point;

    /**
     * 余额
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 扩展字段
     */
    @TableField(value = "extend_str")
    private String extendStr;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

}
