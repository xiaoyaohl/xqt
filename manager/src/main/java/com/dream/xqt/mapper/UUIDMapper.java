package com.dream.xqt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dream.xqt.DTO.UUIDDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author xinxiaoyao
 * @date 2022/7/26 23:20
 */
@Repository
public interface UUIDMapper extends BaseMapper<UUIDDTO> {
}
