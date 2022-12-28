package com.dream.xqt.vo;

import lombok.Data;

/**
 * @author xinxiaoyao
 * @date 2022/11/7 11:10
 */
@Data
public class SpecialtyVO {
    /**
     * 专业名称
     */
    private String name;

    /**
     * 学校信息
     */
    private UniversityVO universityVO;
}
