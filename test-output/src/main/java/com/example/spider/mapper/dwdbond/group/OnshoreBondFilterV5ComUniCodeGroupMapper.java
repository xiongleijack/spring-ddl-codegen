package com.example.spider.mapper.dwdbond.group;

import com.github.wz2cool.dynamic.mybatis.mapper.SelectByGroupedQueryMapper;
import com.example.spider.model.entity.dwdbond.OnshoreBondFilterV5DO;
import com.example.spider.model.entity.dwdbond.group.OnshoreBondFilterV5ComUniCodeGroupDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 按主体唯一编码分组 GroupMapper
 *
 * @author xionglei
 */
@Mapper
public interface OnshoreBondFilterV5ComUniCodeGroupMapper extends SelectByGroupedQueryMapper<OnshoreBondFilterV5DO, OnshoreBondFilterV5ComUniCodeGroupDO> {
}
