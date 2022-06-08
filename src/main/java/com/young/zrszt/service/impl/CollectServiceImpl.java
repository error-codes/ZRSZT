package com.young.zrszt.service.impl;

import com.young.zrszt.entity.Collect;
import com.young.zrszt.mapper.CollectMapper;
import com.young.zrszt.service.CollectService;
import com.young.zrszt.util.DateTimeUtils;
import com.young.zrszt.util.SnowFlakeUtils;
import com.young.zrszt.vo.CollectVo;
import com.young.zrszt.vo.CommonIdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author error-codes【BayMax】
 * @see <a href="www.error-codes.xyz">BayMax Blog</a>
 * @since 2022/5/19 18:11
 */
@Service("collectService")
public class CollectServiceImpl implements CollectService {

    private final CollectMapper collectMapper;

    @Autowired
    public CollectServiceImpl(CollectMapper collectMapper) {
        this.collectMapper = collectMapper;
    }

    @Override
    public Long collect(CollectVo collectVo) {
        Long collectId = collectMapper.selectCollect(collectVo.getEntityId(), collectVo.getUserId(), collectVo.getCategory().getCategory());
        if (collectId == null) {
            collectId = SnowFlakeUtils.getSnowFlakeId();
            Collect collect = new Collect(collectId,
                    collectVo.getEntityId(),
                    collectVo.getUserId(),
                    DateTimeUtils.getCurrentDateTime(),
                    collectVo.getCategory().getCategory());

            Integer result = collectMapper.collect(collect);
            if (result == 1) {
                return collectId;
            }
            return null;
        }
        return -1L;
    }

    @Override
    public Integer unCollect(CommonIdVo commonIdVo) {
        return collectMapper.unCollect(commonIdVo.getId());
    }

    @Override
    public Long selectCollect(CollectVo collectVo) {
        return collectMapper.selectCollect(collectVo.getEntityId(), collectVo.getUserId(), collectVo.getCategory().getCategory());
    }
}
