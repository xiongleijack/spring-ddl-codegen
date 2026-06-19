package com.example.spider.service.impl;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.google.common.collect.Lists;
import com.innodealing.commons.object.BeanCopyUtils;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.spider.service.BondInfoCsrcFndAnnService;
import com.example.spider.model.bo.BondInfoCsrcFndAnnQueryBO;
import com.example.spider.model.dto.BondInfoCsrcFndAnnDetailDTO;
import com.example.spider.model.dto.request.BondInfoCsrcFndAnnQueryDTO;
import com.example.spider.model.dto.response.BondInfoCsrcFndAnnPageDTO;
import com.example.spider.model.entity.spider.BondInfoCsrcFndAnnDO;
import com.example.spider.dao.spider.BondInfoCsrcFndAnnDAO;

/**
 * 中国证券监督管理委员会基金公告-补充表Service实现层 {@link BondInfoCsrcFndAnnDO}
 *
 * @author xionglei
 */
@Service
public class BondInfoCsrcFndAnnServiceImpl implements BondInfoCsrcFndAnnService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private BondInfoCsrcFndAnnDAO bondInfoCsrcFndAnnDAO;

    @Override
    public void insertBondInfoCsrcFndAnn(Long userId, BondInfoCsrcFndAnnDetailDTO bondInfoCsrcFndAnnDetailDTO) {
        BondInfoCsrcFndAnnDO bondInfoCsrcFndAnnDO =
                BeanCopyUtils.copyProperties(bondInfoCsrcFndAnnDetailDTO, BondInfoCsrcFndAnnDO.class);
        checkBondInfoCsrcFndAnnExist(bondInfoCsrcFndAnnDO);
        bondInfoCsrcFndAnnDO.setCreateBy(userId);
        bondInfoCsrcFndAnnDO.setUpdateBy(userId);
        bondInfoCsrcFndAnnDO.setDeleted(0);
        bondInfoCsrcFndAnnDAO.insertBatchBondInfoCsrcFndAnnDOs(userId, Lists.newArrayList(bondInfoCsrcFndAnnDO));
    }

    @Override
    public void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted) {
        bondInfoCsrcFndAnnDAO.updateDeletedByIds(userId, ids, deleted);
    }

    @Override
    public void updateBondInfoCsrcFndAnn(Long userId, BondInfoCsrcFndAnnDetailDTO bondInfoCsrcFndAnnDetailDTO) {
        BondInfoCsrcFndAnnDO bondInfoCsrcFndAnnDO =
                BeanCopyUtils.copyProperties(bondInfoCsrcFndAnnDetailDTO, BondInfoCsrcFndAnnDO.class);
        checkBondInfoCsrcFndAnnExist(bondInfoCsrcFndAnnDO);
        bondInfoCsrcFndAnnDO.setUpdateBy(userId);
        bondInfoCsrcFndAnnDAO.updateBatchBondInfoCsrcFndAnnDOsByPrimaryKey(userId, Lists.newArrayList(bondInfoCsrcFndAnnDO));
    }

    private void checkBondInfoCsrcFndAnnExist(BondInfoCsrcFndAnnDO bondInfoCsrcFndAnnDO) {
        Map<String, Long> businessKeyToIdMap = bondInfoCsrcFndAnnDAO.getBusinessKeyToIdMap(Lists.newArrayList(bondInfoCsrcFndAnnDO));
        String businessKey = bondInfoCsrcFndAnnDAO.getBusinessKey(bondInfoCsrcFndAnnDO);
        Long existId = businessKeyToIdMap.get(businessKey);
        if (!(Objects.isNull(businessKeyToIdMap.get(businessKey)) || Objects.equals(existId, bondInfoCsrcFndAnnDO.getId()))) {
            throw new RuntimeException("业务主键数据重复,请检查数据!");
        }
    }

    @Override
    public BondInfoCsrcFndAnnDetailDTO getBondInfoCsrcFndAnnById(Long id) {
        return bondInfoCsrcFndAnnDAO.getBondInfoCsrcFndAnnDOById(id)
                .map(bondInfoCsrcFndAnnDO -> BeanCopyUtils.copyProperties(bondInfoCsrcFndAnnDO, BondInfoCsrcFndAnnDetailDTO.class))
                .orElseGet(() -> {
                    logger.warn("db data not found by id: {}", id);
                    return null;
                });
    }

    @Override
    public NormPagingResult<BondInfoCsrcFndAnnPageDTO> pageQuery(
            BondInfoCsrcFndAnnQueryDTO bondInfoCsrcFndAnnQueryDTO, Integer pageSize,
            Integer pageNum, String sortProperty, SortDirection sortDirection) {
        BondInfoCsrcFndAnnQueryBO bondInfoCsrcFndAnnQueryBO =
                BeanCopyUtils.copyProperties(bondInfoCsrcFndAnnQueryDTO, BondInfoCsrcFndAnnQueryBO.class);
        NormPagingResult<BondInfoCsrcFndAnnDO> pagingResult =
                bondInfoCsrcFndAnnDAO.pageQuery(bondInfoCsrcFndAnnQueryBO, pageSize, pageNum, sortProperty, sortDirection);
        List<BondInfoCsrcFndAnnPageDTO> pageDTOList = pagingResult.getList().stream()
                .map(bondInfoCsrcFndAnnDO -> {
                    BondInfoCsrcFndAnnPageDTO bondInfoCsrcFndAnnPageDTO =
                            BeanCopyUtils.copyProperties(bondInfoCsrcFndAnnDO, BondInfoCsrcFndAnnPageDTO.class);
                    return bondInfoCsrcFndAnnPageDTO;
                })
                .collect(Collectors.toList());
        NormPagingResult<BondInfoCsrcFndAnnPageDTO> normPagingResult = new NormPagingResult<>();
        BeanCopyUtils.copyProperties(pagingResult, normPagingResult);
        normPagingResult.setList(pageDTOList);
        return normPagingResult;
    }
}
