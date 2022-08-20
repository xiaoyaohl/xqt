package com.dream.xqt.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author xinxiaoyao
 * @date 2022/7/26 22:57
 */
@Data
@TableName("uuid")
public class UUIDDTO {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 业务类型
     */
    @TableField(value = "biz_type")
    private Integer bizType;

    /**
     * 最大值
     */
    @TableField(value = "max_id")
    private Long maxId;

    /**
     * 步长
     */
    @TableField(value = "step")
    private Integer step;

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
