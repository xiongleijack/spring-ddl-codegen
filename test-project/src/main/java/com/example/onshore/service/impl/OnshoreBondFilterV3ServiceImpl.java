package com.example.onshore.service.impl;

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

import com.example.onshore.service.OnshoreBondFilterV3Service;
import com.example.onshore.model.bo.OnshoreBondFilterV3QueryBO;
import com.example.onshore.model.dto.OnshoreBondFilterV3DetailDTO;
import com.example.onshore.model.dto.request.OnshoreBondFilterV3QueryDTO;
import com.example.onshore.model.dto.response.OnshoreBondFilterV3PageDTO;
import com.example.onshore.model.entity.bondbasic.OnshoreBondFilterV3DO;
import com.example.onshore.dao.bondbasic.OnshoreBondFilterV3DAO;

/**
 * 表Service实现层 {@link OnshoreBondFilterV3DO}
 *
 * @author xionglei
 */
@Service
public class OnshoreBondFilterV3ServiceImpl implements OnshoreBondFilterV3Service {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private OnshoreBondFilterV3DAO onshoreBondFilterV3DAO;

    @Override
    public void insertOnshoreBondFilterV3(Long userId, OnshoreBondFilterV3DetailDTO onshoreBondFilterV3DetailDTO) {
        OnshoreBondFilterV3DO onshoreBondFilterV3DO =
                BeanCopyUtils.copyProperties(onshoreBondFilterV3DetailDTO, OnshoreBondFilterV3DO.class);
        checkOnshoreBondFilterV3Exist(onshoreBondFilterV3DO);
        onshoreBondFilterV3DO.setCreateBy(userId);
        onshoreBondFilterV3DO.setUpdateBy(userId);
        onshoreBondFilterV3DO.setDeleted(0);
        onshoreBondFilterV3DAO.insertBatchOnshoreBondFilterV3DOs(userId, Lists.newArrayList(onshoreBondFilterV3DO));
    }

    @Override
    public void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted) {
        onshoreBondFilterV3DAO.updateDeletedByIds(userId, ids, deleted);
    }

    @Override
    public void updateOnshoreBondFilterV3(Long userId, OnshoreBondFilterV3DetailDTO onshoreBondFilterV3DetailDTO) {
        OnshoreBondFilterV3DO onshoreBondFilterV3DO =
                BeanCopyUtils.copyProperties(onshoreBondFilterV3DetailDTO, OnshoreBondFilterV3DO.class);
        checkOnshoreBondFilterV3Exist(onshoreBondFilterV3DO);
        onshoreBondFilterV3DO.setUpdateBy(userId);
        onshoreBondFilterV3DAO.updateBatchOnshoreBondFilterV3DOsByPrimaryKey(userId, Lists.newArrayList(onshoreBondFilterV3DO));
    }

    private void checkOnshoreBondFilterV3Exist(OnshoreBondFilterV3DO onshoreBondFilterV3DO) {
        Map<String, Long> businessKeyToIdMap = onshoreBondFilterV3DAO.getBusinessKeyToIdMap(Lists.newArrayList(onshoreBondFilterV3DO));
        String businessKey = onshoreBondFilterV3DAO.getBusinessKey(onshoreBondFilterV3DO);
        Long existId = businessKeyToIdMap.get(businessKey);
        if (!(Objects.isNull(businessKeyToIdMap.get(businessKey)) || Objects.equals(existId, onshoreBondFilterV3DO.getId()))) {
            throw new RuntimeException("业务主键数据重复,请检查数据!");
        }
    }

    @Override
    public OnshoreBondFilterV3DetailDTO getOnshoreBondFilterV3ById(Long id) {
        return onshoreBondFilterV3DAO.getOnshoreBondFilterV3DOById(id)
                .map(onshoreBondFilterV3DO -> BeanCopyUtils.copyProperties(onshoreBondFilterV3DO, OnshoreBondFilterV3DetailDTO.class))
                .orElseGet(() -> {
                    logger.warn("db data not found by id: {}", id);
                    return null;
                });
    }

    @Override
    public NormPagingResult<OnshoreBondFilterV3PageDTO> pageQuery(
            OnshoreBondFilterV3QueryDTO onshoreBondFilterV3QueryDTO, Integer pageSize,
            Integer pageNum, String sortProperty, SortDirection sortDirection) {
        OnshoreBondFilterV3QueryBO onshoreBondFilterV3QueryBO =
                BeanCopyUtils.copyProperties(onshoreBondFilterV3QueryDTO, OnshoreBondFilterV3QueryBO.class);
        NormPagingResult<OnshoreBondFilterV3DO> pagingResult =
                onshoreBondFilterV3DAO.pageQuery(onshoreBondFilterV3QueryBO, pageSize, pageNum, sortProperty, sortDirection);
        List<OnshoreBondFilterV3PageDTO> pageDTOList = pagingResult.getList().stream()
                .map(onshoreBondFilterV3DO -> {
                    OnshoreBondFilterV3PageDTO onshoreBondFilterV3PageDTO =
                            BeanCopyUtils.copyProperties(onshoreBondFilterV3DO, OnshoreBondFilterV3PageDTO.class);
                    return onshoreBondFilterV3PageDTO;
                })
                .collect(Collectors.toList());
        NormPagingResult<OnshoreBondFilterV3PageDTO> normPagingResult = new NormPagingResult<>();
        BeanCopyUtils.copyProperties(pagingResult, normPagingResult);
        normPagingResult.setList(pageDTOList);
        return normPagingResult;
    }
}
