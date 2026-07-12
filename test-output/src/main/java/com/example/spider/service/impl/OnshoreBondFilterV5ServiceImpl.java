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

import com.example.spider.service.OnshoreBondFilterV5Service;
import com.example.spider.model.bo.OnshoreBondFilterV5QueryBO;
import com.example.spider.model.dto.OnshoreBondFilterV5DetailDTO;
import com.example.spider.model.dto.request.OnshoreBondFilterV5QueryDTO;
import com.example.spider.model.dto.response.OnshoreBondFilterV5PageDTO;
import com.example.spider.model.entity.dwdbond.OnshoreBondFilterV5DO;
import com.example.spider.dao.dwdbond.OnshoreBondFilterV5DAO;

/**
 * 境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标表Service实现层 {@link OnshoreBondFilterV5DO}
 *
 * @author xionglei
 */
@Service
public class OnshoreBondFilterV5ServiceImpl implements OnshoreBondFilterV5Service {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private OnshoreBondFilterV5DAO onshoreBondFilterV5DAO;

    @Override
    public void insertOnshoreBondFilterV5(Long userId, OnshoreBondFilterV5DetailDTO onshoreBondFilterV5DetailDTO) {
        OnshoreBondFilterV5DO onshoreBondFilterV5DO =
                BeanCopyUtils.copyProperties(onshoreBondFilterV5DetailDTO, OnshoreBondFilterV5DO.class);
        checkOnshoreBondFilterV5Exist(onshoreBondFilterV5DO);
        onshoreBondFilterV5DO.setCreateBy(userId);
        onshoreBondFilterV5DO.setUpdateBy(userId);
        onshoreBondFilterV5DO.setDeleted(0);
        onshoreBondFilterV5DAO.insertBatchOnshoreBondFilterV5DOs(userId, Lists.newArrayList(onshoreBondFilterV5DO));
    }

    @Override
    public void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted) {
        onshoreBondFilterV5DAO.updateDeletedByIds(userId, ids, deleted);
    }

    @Override
    public void updateOnshoreBondFilterV5(Long userId, OnshoreBondFilterV5DetailDTO onshoreBondFilterV5DetailDTO) {
        OnshoreBondFilterV5DO onshoreBondFilterV5DO =
                BeanCopyUtils.copyProperties(onshoreBondFilterV5DetailDTO, OnshoreBondFilterV5DO.class);
        checkOnshoreBondFilterV5Exist(onshoreBondFilterV5DO);
        onshoreBondFilterV5DO.setUpdateBy(userId);
        onshoreBondFilterV5DAO.updateBatchOnshoreBondFilterV5DOsByPrimaryKey(userId, Lists.newArrayList(onshoreBondFilterV5DO));
    }

    private void checkOnshoreBondFilterV5Exist(OnshoreBondFilterV5DO onshoreBondFilterV5DO) {
        Map<String, Long> businessKeyToIdMap = onshoreBondFilterV5DAO.getBusinessKeyToIdMap(Lists.newArrayList(onshoreBondFilterV5DO));
        String businessKey = onshoreBondFilterV5DAO.getBusinessKey(onshoreBondFilterV5DO);
        Long existId = businessKeyToIdMap.get(businessKey);
        if (!(Objects.isNull(businessKeyToIdMap.get(businessKey)) || Objects.equals(existId, onshoreBondFilterV5DO.getId()))) {
            throw new RuntimeException("业务主键数据重复,请检查数据!");
        }
    }

    @Override
    public OnshoreBondFilterV5DetailDTO getOnshoreBondFilterV5ById(Long id) {
        return onshoreBondFilterV5DAO.getOnshoreBondFilterV5DOById(id)
                .map(onshoreBondFilterV5DO -> BeanCopyUtils.copyProperties(onshoreBondFilterV5DO, OnshoreBondFilterV5DetailDTO.class))
                .orElseGet(() -> {
                    logger.warn("db data not found by id: {}", id);
                    return null;
                });
    }

    @Override
    public NormPagingResult<OnshoreBondFilterV5PageDTO> pageQuery(
            OnshoreBondFilterV5QueryDTO onshoreBondFilterV5QueryDTO, Integer pageSize,
            Integer pageNum, String sortProperty, SortDirection sortDirection) {
        OnshoreBondFilterV5QueryBO onshoreBondFilterV5QueryBO =
                BeanCopyUtils.copyProperties(onshoreBondFilterV5QueryDTO, OnshoreBondFilterV5QueryBO.class);
        NormPagingResult<OnshoreBondFilterV5DO> pagingResult =
                onshoreBondFilterV5DAO.pageQuery(onshoreBondFilterV5QueryBO, pageSize, pageNum, sortProperty, sortDirection);
        List<OnshoreBondFilterV5PageDTO> pageDTOList = pagingResult.getList().stream()
                .map(onshoreBondFilterV5DO -> {
                    OnshoreBondFilterV5PageDTO onshoreBondFilterV5PageDTO =
                            BeanCopyUtils.copyProperties(onshoreBondFilterV5DO, OnshoreBondFilterV5PageDTO.class);
                    return onshoreBondFilterV5PageDTO;
                })
                .collect(Collectors.toList());
        NormPagingResult<OnshoreBondFilterV5PageDTO> normPagingResult = new NormPagingResult<>();
        BeanCopyUtils.copyProperties(pagingResult, normPagingResult);
        normPagingResult.setList(pageDTOList);
        return normPagingResult;
    }
}
