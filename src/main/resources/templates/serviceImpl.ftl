<#-- ServiceImpl实现模板 - 对齐 tmpl.json 风格 -->
package ${basePackage}.service.impl;

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

import ${basePackage}.service.${table.className}Service;
import ${basePackage}.model.bo.${table.className}QueryBO;
import ${basePackage}.model.dto.${table.className}DetailDTO;
import ${basePackage}.model.dto.request.${table.className}QueryDTO;
import ${basePackage}.model.dto.response.${table.className}PageDTO;
import ${basePackage}.model.entity.${table.className}DO;
import ${basePackage}.dao.${table.className}DAO;

/**
 * ${table.comment!table.className}表Service实现层 {@link ${table.className}DO}
 *
 * @author ${author}
 */
@Service
public class ${table.className}ServiceImpl implements ${table.className}Service {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ${table.className}DAO ${table.variableName}DAO;

    @Override
    public void insert${table.className}(Long userId, ${table.className}DetailDTO ${table.variableName}DetailDTO) {
        ${table.className}DO ${table.variableName}DO =
                BeanCopyUtils.copyProperties(${table.variableName}DetailDTO, ${table.className}DO.class);
        check${table.className}Exist(${table.variableName}DO);
        ${table.variableName}DO.setCreateBy(userId);
        ${table.variableName}DO.setUpdateBy(userId);
        ${table.variableName}DO.setDeleted(0);
        ${table.variableName}DAO.insertBatch${table.className}DOs(userId, Lists.newArrayList(${table.variableName}DO));
    }

    @Override
    public void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted) {
        ${table.variableName}DAO.updateDeletedByIds(userId, ids, deleted);
    }

    @Override
    public void update${table.className}(Long userId, ${table.className}DetailDTO ${table.variableName}DetailDTO) {
        ${table.className}DO ${table.variableName}DO =
                BeanCopyUtils.copyProperties(${table.variableName}DetailDTO, ${table.className}DO.class);
        check${table.className}Exist(${table.variableName}DO);
        ${table.variableName}DO.setUpdateBy(userId);
        ${table.variableName}DAO.updateBatch${table.className}DOsByPrimaryKey(userId, Lists.newArrayList(${table.variableName}DO));
    }

    private void check${table.className}Exist(${table.className}DO ${table.variableName}DO) {
        Map<String, Long> businessKeyToIdMap = ${table.variableName}DAO.getBusinessKeyToIdMap(Lists.newArrayList(${table.variableName}DO));
        String businessKey = ${table.variableName}DAO.getBusinessKey(${table.variableName}DO);
        Long existId = businessKeyToIdMap.get(businessKey);
        if (!(Objects.isNull(businessKeyToIdMap.get(businessKey)) || Objects.equals(existId, ${table.variableName}DO.getId()))) {
            throw new RuntimeException("业务主键数据重复,请检查数据!");
        }
    }

    @Override
    public ${table.className}DetailDTO get${table.className}ById(Long id) {
        return ${table.variableName}DAO.get${table.className}DOById(id)
                .map(${table.variableName}DO -> BeanCopyUtils.copyProperties(${table.variableName}DO, ${table.className}DetailDTO.class))
                .orElseGet(() -> {
                    logger.warn("db data not found by id: {}", id);
                    return null;
                });
    }

    @Override
    public NormPagingResult<${table.className}PageDTO> pageQuery(
            ${table.className}QueryDTO ${table.variableName}QueryDTO, Integer pageSize,
            Integer pageNum, String sortProperty, SortDirection sortDirection) {
        ${table.className}QueryBO ${table.variableName}QueryBO =
                BeanCopyUtils.copyProperties(${table.variableName}QueryDTO, ${table.className}QueryBO.class);
        NormPagingResult<${table.className}DO> pagingResult =
                ${table.variableName}DAO.pageQuery(${table.variableName}QueryBO, pageSize, pageNum, sortProperty, sortDirection);
        List<${table.className}PageDTO> pageDTOList = pagingResult.getList().stream()
                .map(${table.variableName}DO -> {
                    ${table.className}PageDTO ${table.variableName}PageDTO =
                            BeanCopyUtils.copyProperties(${table.variableName}DO, ${table.className}PageDTO.class);
                    return ${table.variableName}PageDTO;
                })
                .collect(Collectors.toList());
        NormPagingResult<${table.className}PageDTO> normPagingResult = new NormPagingResult<>();
        BeanCopyUtils.copyProperties(pagingResult, normPagingResult);
        normPagingResult.setList(pageDTOList);
        return normPagingResult;
    }
}
