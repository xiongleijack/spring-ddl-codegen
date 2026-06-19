package com.example.spider.service;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.example.spider.model.dto.BondInfoCsrcFndAnnDetailDTO;
import com.example.spider.model.dto.request.BondInfoCsrcFndAnnQueryDTO;
import com.example.spider.model.dto.response.BondInfoCsrcFndAnnPageDTO;
import com.example.spider.model.entity.spider.BondInfoCsrcFndAnnDO;

import java.util.Collection;

/**
 * 中国证券监督管理委员会基金公告-补充表Service层 {@link BondInfoCsrcFndAnnDO}
 *
 * @author xionglei
 */
public interface BondInfoCsrcFndAnnService {

    /**
     * 新增数据处理
     *
     * @param userId              用户id
     * @param bondInfoCsrcFndAnnDetailDTO 用户请求对象
     */
    void insertBondInfoCsrcFndAnn(Long userId, BondInfoCsrcFndAnnDetailDTO bondInfoCsrcFndAnnDetailDTO);

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
     * @param bondInfoCsrcFndAnnDetailDTO 请求对象
     */
    void updateBondInfoCsrcFndAnn(Long userId, BondInfoCsrcFndAnnDetailDTO bondInfoCsrcFndAnnDetailDTO);

    /**
     * 根据主键获取数据
     *
     * @param id 主键
     * @return 数据
     */
    BondInfoCsrcFndAnnDetailDTO getBondInfoCsrcFndAnnById(Long id);

    /**
     * 分页查询
     *
     * @param bondInfoCsrcFndAnnQueryDTO 查询条件
     * @param pageSize             每页大小
     * @param pageNum              当前页
     * @param sortProperty         排序字段
     * @param sortDirection        排序方向
     * @return 分页结果
     */
    NormPagingResult<BondInfoCsrcFndAnnPageDTO> pageQuery(
            BondInfoCsrcFndAnnQueryDTO bondInfoCsrcFndAnnQueryDTO, Integer pageSize,
            Integer pageNum, String sortProperty, SortDirection sortDirection);
}
