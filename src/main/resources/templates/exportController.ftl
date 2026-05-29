package ${basePackage}.api.controller;

import ${basePackage}.application.service.${table.className}Service;
import ${basePackage}.domain.entity.${table.className};
<#if config.stack.swagger>
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
</#if>
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * ${table.comment!table.className} Export Controller
 *
 * @author ${author}
 */
<#if config.stack.swagger>
@Tag(name = "${table.className} Export")
</#if>
@RestController
@RequestMapping("/api/${table.variableName}s/export")
public class ${table.className}ExportController {

    private final ${table.className}Service ${table.variableName}Service;

    public ${table.className}ExportController(${table.className}Service ${table.variableName}Service) {
        this.${table.variableName}Service = ${table.variableName}Service;
    }

    <#if config.stack.swagger>
    @Operation(summary = "导出${table.comment!table.className}")
    </#if>
    @GetMapping
    public void export(HttpServletResponse response) throws IOException {
        List<${table.className}> records = ${table.variableName}Service.list();
        response.setContentType("text/csv;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=${table.tableName}.csv");
        StringBuilder builder = new StringBuilder();
<#list table.columns as column>
        builder.append("${column.comment!column.name}<#if column_has_next>,</#if>");
</#list>
        builder.append("\n");
        for (${table.className} item : records) {
<#list table.columns as column>
            builder.append(item.get${util.firstUpper(column.javaName)}()).append("<#if column_has_next>,</#if>");
</#list>
            builder.append("\n");
        }
        response.getOutputStream().write(builder.toString().getBytes(StandardCharsets.UTF_8));
    }
}
