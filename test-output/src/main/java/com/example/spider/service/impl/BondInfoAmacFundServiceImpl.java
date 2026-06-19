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

import com.example.spider.service.BondInfoAmacFundService;
import com.example.spider.model.bo.BondInfoAmacFundQueryBO;
import com.example.spider.model.dto.BondInfoAmacFundDetailDTO;
import com.example.spider.model.dto.request.BondInfoAmacFundQueryDTO;
import com.example.spider.model.dto.response.BondInfoAmacFundPageDTO;
import com.example.spider.model.entity.spider.BondInfoAmacFundDO;
import com.example.spider.dao.spider.BondInfoAmacFundDAO;

/**
 * 中国证券投资基金业协会基金表Service实现层 {@link BondInfoAmacFundDO}
 *
 * @author xionglei
 */
@Service
public class BondInfoAmacFundServiceImpl implements BondInfoAmacFundService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private BondInfoAmacFundDAO bondInfoAmacFundDAO;

    @Override
    public void insertBondInfoAmacFund(Long userId, BondInfoAmacFundDetailDTO bondInfoAmacFundDetailDTO) {
        BondInfoAmacFundDO bondInfoAmacFundDO =
                BeanCopyUtils.copyProperties(bondInfoAmacFundDetailDTO, BondInfoAmacFundDO.class);
        checkBondInfoAmacFundExist(bondInfoAmacFundDO);
        bondInfoAmacFundDO.setCreateBy(userId);
        bondInfoAmacFundDO.setUpdateBy(userId);
        bondInfoAmacFundDO.setDeleted(0);
        bondInfoAmacFundDAO.insertBatchBondInfoAmacFundDOs(userId, Lists.newArrayList(bondInfoAmacFundDO));
    }

    @Override
    public void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted) {
        bondInfoAmacFundDAO.updateDeletedByIds(userId, ids, deleted);
    }

    @Override
    public void updateBondInfoAmacFund(Long userId, BondInfoAmacFundDetailDTO bondInfoAmacFundDetailDTO) {
        BondInfoAmacFundDO bondInfoAmacFundDO =
                BeanCopyUtils.copyProperties(bondInfoAmacFundDetailDTO, BondInfoAmacFundDO.class);
        checkBondInfoAmacFundExist(bondInfoAmacFundDO);
        bondInfoAmacFundDO.setUpdateBy(userId);
        bondInfoAmacFundDAO.updateBatchBondInfoAmacFundDOsByPrimaryKey(userId, Lists.newArrayList(bondInfoAmacFundDO));
    }

    private void checkBondInfoAmacFundExist(BondInfoAmacFundDO bondInfoAmacFundDO) {
        Map<String, Long> businessKeyToIdMap = bondInfoAmacFundDAO.getBusinessKeyToIdMap(Lists.newArrayList(bondInfoAmacFundDO));
        String businessKey = bondInfoAmacFundDAO.getBusinessKey(bondInfoAmacFundDO);
        Long existId = businessKeyToIdMap.get(businessKey);
        if (!(Objects.isNull(businessKeyToIdMap.get(businessKey)) || Objects.equals(existId, bondInfoAmacFundDO.getId()))) {
            throw new RuntimeException("业务主键数据重复,请检查数据!");
        }
    }

    @Override
    public BondInfoAmacFundDetailDTO getBondInfoAmacFundById(Long id) {
        return bondInfoAmacFundDAO.getBondInfoAmacFundDOById(id)
                .map(bondInfoAmacFundDO -> BeanCopyUtils.copyProperties(bondInfoAmacFundDO, BondInfoAmacFundDetailDTO.class))
                .orElseGet(() -> {
                    logger.warn("db data not found by id: {}", id);
                    return null;
                });
    }

    @Override
    public NormPagingResult<BondInfoAmacFundPageDTO> pageQuery(
            BondInfoAmacFundQueryDTO bondInfoAmacFundQueryDTO, Integer pageSize,
            Integer pageNum, String sortProperty, SortDirection sortDirection) {
        BondInfoAmacFundQueryBO bondInfoAmacFundQueryBO =
                BeanCopyUtils.copyProperties(bondInfoAmacFundQueryDTO, BondInfoAmacFundQueryBO.class);
        NormPagingResult<BondInfoAmacFundDO> pagingResult =
                bondInfoAmacFundDAO.pageQuery(bondInfoAmacFundQueryBO, pageSize, pageNum, sortProperty, sortDirection);
        List<BondInfoAmacFundPageDTO> pageDTOList = pagingResult.getList().stream()
                .map(bondInfoAmacFundDO -> {
                    BondInfoAmacFundPageDTO bondInfoAmacFundPageDTO =
                            BeanCopyUtils.copyProperties(bondInfoAmacFundDO, BondInfoAmacFundPageDTO.class);
                    return bondInfoAmacFundPageDTO;
                })
                .collect(Collectors.toList());
        NormPagingResult<BondInfoAmacFundPageDTO> normPagingResult = new NormPagingResult<>();
        BeanCopyUtils.copyProperties(pagingResult, normPagingResult);
        normPagingResult.setList(pageDTOList);
        return normPagingResult;
    }
}
