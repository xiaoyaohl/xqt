package com.dream.xqt.DTO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author xinxiaoyao
 * @date 2022/11/9 20:36
 */
@Data
@TableName(value = "university_info")
public class UniversityInfoDTO {
    /**
     * 主键id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 学校名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 官网链接
     */
    @TableField(value = "official_website_url")
    private String officialWebsiteUrl;

    /**
     * 头像
     */
    @TableField(value = "face_url")
    private String faceUrl;

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
