package com.example.onshore.service;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.example.onshore.model.dto.OnshoreBondFilterV3DetailDTO;
import com.example.onshore.model.dto.request.OnshoreBondFilterV3QueryDTO;
import com.example.onshore.model.dto.response.OnshoreBondFilterV3PageDTO;
import com.example.onshore.model.entity.bondbasic.OnshoreBondFilterV3DO;

import java.util.Collection;

/**
 * 表Service层 {@link OnshoreBondFilterV3DO}
 *
 * @author xionglei
 */
public interface OnshoreBondFilterV3Service {

    /**
     * 新增数据处理
     *
     * @param userId              用户id
     * @param onshoreBondFilterV3DetailDTO 用户请求对象
     */
    void insertOnshoreBondFilterV3(Long userId, OnshoreBondFilterV3DetailDTO onshoreBondFilterV3DetailDTO);

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
     * @param onshoreBondFilterV3DetailDTO 请求对象
     */
    void updateOnshoreBondFilterV3(Long userId, OnshoreBondFilterV3DetailDTO onshoreBondFilterV3DetailDTO);

    /**
     * 根据主键获取数据
     *
     * @param id 主键
     * @return 数据
     */
    OnshoreBondFilterV3DetailDTO getOnshoreBondFilterV3ById(Long id);

    /**
     * 分页查询
     *
     * @param onshoreBondFilterV3QueryDTO 查询条件
     * @param pageSize             每页大小
     * @param pageNum              当前页
     * @param sortProperty         排序字段
     * @param sortDirection        排序方向
     * @return 分页结果
     */
    NormPagingResult<OnshoreBondFilterV3PageDTO> pageQuery(
            OnshoreBondFilterV3QueryDTO onshoreBondFilterV3QueryDTO, Integer pageSize,
            Integer pageNum, String sortProperty, SortDirection sortDirection);
}
