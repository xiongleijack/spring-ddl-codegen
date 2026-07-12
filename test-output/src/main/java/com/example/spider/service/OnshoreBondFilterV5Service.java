package com.example.spider.service;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.example.spider.model.dto.OnshoreBondFilterV5DetailDTO;
import com.example.spider.model.dto.request.OnshoreBondFilterV5QueryDTO;
import com.example.spider.model.dto.response.OnshoreBondFilterV5PageDTO;
import com.example.spider.model.entity.dwdbond.OnshoreBondFilterV5DO;

import java.util.Collection;

/**
 * 境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标表Service层 {@link OnshoreBondFilterV5DO}
 *
 * @author xionglei
 */
public interface OnshoreBondFilterV5Service {

    /**
     * 新增数据处理
     *
     * @param userId              用户id
     * @param onshoreBondFilterV5DetailDTO 用户请求对象
     */
    void insertOnshoreBondFilterV5(Long userId, OnshoreBondFilterV5DetailDTO onshoreBondFilterV5DetailDTO);

    /**
     * 更新deleted字段
     *
     * @param userId  用户id
     * @param ids     主键集合
     * @param deleted 删除状态
     */
    void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted);

    /**
     * 更新数据
     *
     * @param userId              用户id
     * @param onshoreBondFilterV5DetailDTO 请求对象
     */
    void updateOnshoreBondFilterV5(Long userId, OnshoreBondFilterV5DetailDTO onshoreBondFilterV5DetailDTO);

    /**
     * 根据主键获取数据
     *
     * @param id 主键
     * @return 数据
     */
    OnshoreBondFilterV5DetailDTO getOnshoreBondFilterV5ById(Long id);

    /**
     * 分页查询
     *
     * @param onshoreBondFilterV5QueryDTO 查询条件
     * @param pageSize             每页大小
     * @param pageNum              当前页
     * @param sortProperty         排序字段
     * @param sortDirection        排序方向
     * @return 分页结果
     */
    NormPagingResult<OnshoreBondFilterV5PageDTO> pageQuery(
            OnshoreBondFilterV5QueryDTO onshoreBondFilterV5QueryDTO, Integer pageSize,
            Integer pageNum, String sortProperty, SortDirection sortDirection);
}
