package com.dream.xqt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dream.xqt.DTO.UUIDDTO;
import com.dream.xqt.mapper.UUIDMapper;
import com.dream.xqt.service.UUIDService;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xinxiaoyao
 * @date 2022/7/26 23:24
 */
@Service
public class UUIDServiceImpl implements UUIDService {
    @Resource
    private UUIDMapper uuidMapper;

    public static final Map<Integer, MyUUID> ID_MAP = new ConcurrentHashMap<>();

    @Override
    public Long generateId(Integer bizType) {
        MyUUID myUUID = ID_MAP.get(bizType);
        if (myUUID == null) {
            synchronized (MyUUID.class) {
                myUUID = ID_MAP.get(bizType);
                if (myUUID == null) {
                    LambdaQueryWrapper<UUIDDTO> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.eq(UUIDDTO::getBizType, bizType);
                    UUIDDTO uuidDTO = uuidMapper.selectOne(queryWrapper);

                    LambdaUpdateWrapper<UUIDDTO> updateWrapper = new LambdaUpdateWrapper<>();
                    updateWrapper.set(UUIDDTO::getMaxId, uuidDTO.getMaxId() + uuidDTO.getBizType());
                    updateWrapper.eq(UUIDDTO::getBizType, bizType);
                    uuidMapper.update(uuidDTO, updateWrapper);

                    myUUID = new MyUUID();
                    AtomicLong currentId = new AtomicLong(uuidDTO.getMaxId());
                    AtomicLong maxId = new AtomicLong(uuidDTO.getMaxId() + uuidDTO.getStep());
                    myUUID.setCurrentId(currentId);
                    myUUID.setMaxId(maxId);
                    ID_MAP.put(bizType, myUUID);
                }

                return myUUID.getCurrentId().getAndIncrement();
            }
        } else {
            synchronized (MyUUID.class) {
                myUUID = ID_MAP.get(bizType);
                if (myUUID.getCurrentId().get() == myUUID.getMaxId().get()) {
                    LambdaQueryWrapper<UUIDDTO> queryWrapper = new LambdaQueryWrapper<>();
                    queryWrapper.eq(UUIDDTO::getBizType, bizType);
                    UUIDDTO uuidDTO = uuidMapper.selectOne(queryWrapper);

                    LambdaUpdateWrapper<UUIDDTO> updateWrapper = new LambdaUpdateWrapper<>();
                    updateWrapper.set(UUIDDTO::getMaxId, uuidDTO.getMaxId() + uuidDTO.getBizType());
                    updateWrapper.eq(UUIDDTO::getBizType, bizType);
                    uuidMapper.update(uuidDTO, updateWrapper);

                    myUUID = new MyUUID();
                    AtomicLong currentId = new AtomicLong(uuidDTO.getMaxId());
                    AtomicLong maxId = new AtomicLong(uuidDTO.getMaxId() + uuidDTO.getStep());
                    myUUID.setCurrentId(currentId);
                    myUUID.setMaxId(maxId);
                    ID_MAP.put(bizType, myUUID);
                }

                return myUUID.getCurrentId().getAndIncrement();
            }
        }
    }

    @Data
    class MyUUID {
        /**
         * 当前id
         */
        private AtomicLong currentId;

        /**
         * 最大id
         */
        private AtomicLong maxId;
    }
}
