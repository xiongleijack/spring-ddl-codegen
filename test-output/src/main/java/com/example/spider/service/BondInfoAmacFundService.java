package com.example.spider.service;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.example.spider.model.dto.BondInfoAmacFundDetailDTO;
import com.example.spider.model.dto.request.BondInfoAmacFundQueryDTO;
import com.example.spider.model.dto.response.BondInfoAmacFundPageDTO;
import com.example.spider.model.entity.spider.BondInfoAmacFundDO;

import java.util.Collection;

/**
 * 中国证券投资基金业协会基金表Service层 {@link BondInfoAmacFundDO}
 *
 * @author xionglei
 */
public interface BondInfoAmacFundService {

    /**
     * 新增数据处理
     *
     * @param userId              用户id
     * @param bondInfoAmacFundDetailDTO 用户请求对象
     */
    void insertBondInfoAmacFund(Long userId, BondInfoAmacFundDetailDTO bondInfoAmacFundDetailDTO);

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
     * @param bondInfoAmacFundDetailDTO 请求对象
     */
    void updateBondInfoAmacFund(Long userId, BondInfoAmacFundDetailDTO bondInfoAmacFundDetailDTO);

    /**
     * 根据主键获取数据
     *
     * @param id 主键
     * @return 数据
     */
    BondInfoAmacFundDetailDTO getBondInfoAmacFundById(Long id);

    /**
     * 分页查询
     *
     * @param bondInfoAmacFundQueryDTO 查询条件
     * @param pageSize             每页大小
     * @param pageNum              当前页
     * @param sortProperty         排序字段
     * @param sortDirection        排序方向
     * @return 分页结果
     */
    NormPagingResult<BondInfoAmacFundPageDTO> pageQuery(
            BondInfoAmacFundQueryDTO bondInfoAmacFundQueryDTO, Integer pageSize,
            Integer pageNum, String sortProperty, SortDirection sortDirection);
}
