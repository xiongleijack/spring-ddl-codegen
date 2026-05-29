<#-- ============================================================
     Service实现类模板
     生成 {ClassName}ServiceImpl.java，实现Service接口。
     注入DAO层完成数据操作，使用BeanUtils进行DO与DTO之间的转换。
     ============================================================ -->
package ${basePackage}.application.service.impl;

import ${basePackage}.api.dto.${table.className}DetailDTO;
import ${basePackage}.api.dto.${table.className}PageDTO;
import ${basePackage}.api.dto.${table.className}QueryDTO;
import ${basePackage}.application.service.${table.className}Service;
import ${basePackage}.domain.bo.${table.className}QueryBO;
import ${basePackage}.domain.entity.${table.className}DO;
import ${basePackage}.infrastructure.dao.${table.className}DAO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ${table.comment!table.className}表Service实现层
 *
 * @author ${author}
 */
@Service
public class ${table.className}ServiceImpl implements ${table.className}Service {

    @Resource
    private ${table.className}DAO ${table.variableName}DAO;

    @Override
    public void create(${table.className}DetailDTO detailDTO) {
        // DTO -> DO 转换后插入数据库
        ${table.className}DO entity = new ${table.className}DO();
        BeanUtils.copyProperties(detailDTO, entity);
        ${table.variableName}DAO.insert(entity);
    }

    @Override
    public void update(${util.simpleType(pk.javaType)} id, ${table.className}DetailDTO detailDTO) {
        // DTO -> DO 转换，设置主键后更新
        ${table.className}DO entity = new ${table.className}DO();
        BeanUtils.copyProperties(detailDTO, entity);
        entity.set${util.firstUpper(pk.javaName)}(id);
        ${table.variableName}DAO.updateById(entity);
    }

    @Override
    public void delete(${util.simpleType(pk.javaType)} id) {
        ${table.variableName}DAO.deleteById(id);
    }

    @Override
    public ${table.className}DetailDTO getDetail(${util.simpleType(pk.javaType)} id) {
        // 查询DO并转换为DetailDTO返回，不存在则返回null
        return ${table.variableName}DAO.getById(id)
                .map(entity -> {
                    ${table.className}DetailDTO dto = new ${table.className}DetailDTO();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                })
                .orElse(null);
    }

    @Override
    public Page<${table.className}PageDTO> pageQuery(${table.className}QueryDTO queryDTO, Integer pageNum, Integer pageSize) {
        // 1. QueryDTO -> QueryBO 转换
        ${table.className}QueryBO queryBO = new ${table.className}QueryBO();
        BeanUtils.copyProperties(queryDTO, queryBO);
        // 2. 执行分页查询
        Page<${table.className}DO> page = new Page<>(pageNum, pageSize);
        Page<${table.className}DO> result = ${table.variableName}DAO.pageQuery(page, queryBO);
        // 3. DO列表 -> PageDTO列表 转换
        Page<${table.className}PageDTO> pageResult = new Page<>(result.getCurrent(), result.getSize(), result.getTotal());
        List<${table.className}PageDTO> records = result.getRecords().stream()
                .map(entity -> {
                    ${table.className}PageDTO dto = new ${table.className}PageDTO();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                })
                .collect(Collectors.toList());
        pageResult.setRecords(records);
        return pageResult;
    }
}
