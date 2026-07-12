package com.example.spider.dao.dwdbond.group;

import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.GroupByQuery;
import com.github.wz2cool.dynamic.GroupedQuery;
import com.example.spider.mapper.dwdbond.OnshoreBondFilterV5Mapper;
import com.example.spider.mapper.dwdbond.group.OnshoreBondFilterV5ComUniCodeGroupMapper;
import com.example.spider.model.entity.dwdbond.OnshoreBondFilterV5DO;
import com.example.spider.model.entity.dwdbond.group.OnshoreBondFilterV5ComUniCodeGroupDO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.isEqual;

/**
 * 按主体唯一编码分组 分组数据访问层
 *
 * @author xionglei
 */
@Repository
public class OnshoreBondFilterV5ComUniCodeGroupDAO {

    @Resource
    private OnshoreBondFilterV5ComUniCodeGroupMapper onshoreBondFilterV5ComUniCodeGroupMapper;

    @Resource
    private OnshoreBondFilterV5Mapper onshoreBondFilterV5Mapper;

    /**
     * 根据主体唯一编码列表分组查询
     *
     * @param comUniCodes 主体唯一编码列表
     * @return {@link OnshoreBondFilterV5ComUniCodeGroupDO} 集合
     */
    public List<OnshoreBondFilterV5ComUniCodeGroupDO> listGroupByComUniCodes(
            Collection<Long> comUniCodes) {
        if (CollectionUtils.isEmpty(comUniCodes)) {
            return Collections.emptyList();
        }
        GroupedQuery<OnshoreBondFilterV5DO, OnshoreBondFilterV5ComUniCodeGroupDO> groupedQuery =
                GroupByQuery.createQuery(OnshoreBondFilterV5DO.class, OnshoreBondFilterV5ComUniCodeGroupDO.class)
                        .and(OnshoreBondFilterV5DO::getComUniCode,
                                c -> c.in(comUniCodes))
                        .and(OnshoreBondFilterV5DO::getDeleted, isEqual(0))
                        .groupBy(OnshoreBondFilterV5DO::getComUniCode);
        return onshoreBondFilterV5ComUniCodeGroupMapper.selectByGroupedQuery(groupedQuery);
    }

    /**
     * 根据分组结果反查源表记录
     *
     * @param groupDos {@link OnshoreBondFilterV5ComUniCodeGroupDO} 列表
     * @return {@link OnshoreBondFilterV5DO} 集合
     */
    public List<OnshoreBondFilterV5DO> listByGroupDos(Collection<OnshoreBondFilterV5ComUniCodeGroupDO> groupDos) {
        if (CollectionUtils.isEmpty(groupDos)) {
            return Collections.emptyList();
        }
        DynamicQuery<OnshoreBondFilterV5DO> dynamicQuery = DynamicQuery.createQuery(OnshoreBondFilterV5DO.class);
        for (OnshoreBondFilterV5ComUniCodeGroupDO groupDO : groupDos) {
            dynamicQuery.or(g ->
                    g
                            .and(OnshoreBondFilterV5DO::getComUniCode,
                                    isEqual(groupDO.getComUniCode()))
                            .and(OnshoreBondFilterV5DO::getIssueStartDate,
                                    isEqual(groupDO.getMaxIssueStartDate()))
            );
        }
        dynamicQuery.and(OnshoreBondFilterV5DO::getDeleted, isEqual(0));
        return onshoreBondFilterV5Mapper.selectByDynamicQuery(dynamicQuery);
    }
}
