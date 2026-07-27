package com.innodealing.sentimentdatacenter.dao.spider;

import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.mybatis.mapper.DynamicQueryMapper;
import com.innodealing.sentimentdatacenter.mapper.spider.BondInfoSafeXzcfDataMapper;
import com.innodealing.sentimentdatacenter.model.entity.spider.BondInfoSafeXzcfDataDO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.in;

/**
 * BondInfoSafeXzcfDataDAO（公告爬虫同步）
 *
 * @author xionglei
 */
@Repository
public class BondInfoSafeXzcfDataDAO implements SpiderAnnouncementLongPrimaryEntitySync<BondInfoSafeXzcfDataDO> {

    @Resource
    private BondInfoSafeXzcfDataMapper bondInfoSafeXzcfDataMapper;

    @Override
    public DynamicQueryMapper<BondInfoSafeXzcfDataDO> getEntityMapper() {
        return bondInfoSafeXzcfDataMapper;
    }

    @Override
    public Class<BondInfoSafeXzcfDataDO> getEntityClass() {
        return BondInfoSafeXzcfDataDO.class;
    }

    /**
     * 根据主键批量查询
     *
     * @param dataIds 爬虫表主键
     * @return DO 列表
     */
    public List<BondInfoSafeXzcfDataDO> listByIds(Collection<Long> dataIds) {
        if (CollectionUtils.isEmpty(dataIds)) {
            return Collections.emptyList();
        }
        DynamicQuery<BondInfoSafeXzcfDataDO> query = DynamicQuery.createQuery(BondInfoSafeXzcfDataDO.class)
                .and(BondInfoSafeXzcfDataDO::getId, in(dataIds));
        return bondInfoSafeXzcfDataMapper.selectByDynamicQuery(query);
    }
}
