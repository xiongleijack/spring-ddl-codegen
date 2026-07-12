package com.example.spider.mapper.dwdbond;

import com.github.wz2cool.dynamic.mybatis.mapper.DynamicQueryMapper;
import com.example.spider.model.entity.dwdbond.OnshoreBondFilterV5DO;

/**
 * 境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标表DynamicQueryMapper层 {@link OnshoreBondFilterV5DO}
 *
 * @author xionglei
 */
public interface OnshoreBondFilterV5Mapper extends DynamicQueryMapper<OnshoreBondFilterV5DO> {

}