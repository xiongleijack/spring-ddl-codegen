package ${basePackage}.api.controller;

import ${basePackage}.application.service.${table.className}Service;
import ${basePackage}.domain.entity.${table.className};
<#if config.stack.swagger>
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
</#if>
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * ${table.comment!table.className} Import Controller
 *
 * @author ${author}
 */
<#if config.stack.swagger>
@Tag(name = "${table.className} Import")
</#if>
@RestController
@RequestMapping("/api/${table.variableName}s/import")
public class ${table.className}ImportController {

    private final ${table.className}Service ${table.variableName}Service;

    public ${table.className}ImportController(${table.className}Service ${table.variableName}Service) {
        this.${table.variableName}Service = ${table.variableName}Service;
    }

    <#if config.stack.swagger>
    @Operation(summary = "导入${table.comment!table.className}")
    </#if>
    @PostMapping
    public boolean importData(@RequestParam("file") MultipartFile file) {
        // TODO: parse file and convert to entities
        List<${table.className}> records = List.of();
        return ${table.variableName}Service.saveBatch(records);
    }
}
