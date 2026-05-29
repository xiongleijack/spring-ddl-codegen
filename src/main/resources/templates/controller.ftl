<#-- ============================================================
     Controller控制器模板
     生成 {ClassName}Controller.java，提供RESTful API接口。
     接口包括: 分页查询、详情查询、新增、更新、删除。
     入参使用QueryDTO/DetailDTO，出参使用PageDTO/DetailDTO。
     可选: Swagger @Tag/@Operation/@Parameter 注解。
     ============================================================ -->
package ${basePackage}.api.controller;

import ${basePackage}.api.dto.${table.className}DetailDTO;
import ${basePackage}.api.dto.${table.className}PageDTO;
import ${basePackage}.api.dto.${table.className}QueryDTO;
import ${basePackage}.application.service.${table.className}Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
<#if config.stack.swagger>
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
</#if>
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * ${table.comment!table.className}表控制器
 *
 * @author ${author}
 */
<#if config.stack.swagger>
@Tag(name = "${table.comment!table.className}")
</#if>
@RestController
@RequestMapping("/api/${table.variableName}")
public class ${table.className}Controller {

    @Resource
    private ${table.className}Service ${table.variableName}Service;

<#if config.stack.swagger>
    @Operation(summary = "分页查询")
</#if>
    @PostMapping("/page")
    public Page<${table.className}PageDTO> pageQuery(
            @RequestBody ${table.className}QueryDTO queryDTO,
<#if config.stack.swagger>
            @Parameter(description = "页码") @RequestParam(defaultValue = "1") Integer pageNum,
            @Parameter(description = "每页条数") @RequestParam(defaultValue = "10") Integer pageSize) {
<#else>
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
</#if>
        return ${table.variableName}Service.pageQuery(queryDTO, pageNum, pageSize);
    }

<#if config.stack.swagger>
    @Operation(summary = "根据主键查询详情")
</#if>
    @GetMapping("/{id}")
    public ${table.className}DetailDTO getDetail(@PathVariable ${util.simpleType(pk.javaType)} id) {
        return ${table.variableName}Service.getDetail(id);
    }

<#if config.stack.swagger>
    @Operation(summary = "新增")
</#if>
    @PostMapping
    public void create(@RequestBody ${table.className}DetailDTO detailDTO) {
        ${table.variableName}Service.create(detailDTO);
    }

<#if config.stack.swagger>
    @Operation(summary = "更新")
</#if>
    @PutMapping("/{id}")
    public void update(@PathVariable ${util.simpleType(pk.javaType)} id, @RequestBody ${table.className}DetailDTO detailDTO) {
        ${table.variableName}Service.update(id, detailDTO);
    }

<#if config.stack.swagger>
    @Operation(summary = "删除")
</#if>
    @DeleteMapping("/{id}")
    public void delete(@PathVariable ${util.simpleType(pk.javaType)} id) {
        ${table.variableName}Service.delete(id);
    }
}
