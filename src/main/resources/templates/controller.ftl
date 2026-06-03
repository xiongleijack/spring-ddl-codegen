<#-- Controller控制器模板 - 对齐 tmpl.json MgtController 风格 -->
package ${basePackage}.controller.management;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import ${basePackage}.model.dto.${table.className}DetailDTO;
import ${basePackage}.model.dto.request.${table.className}QueryDTO;
import ${basePackage}.model.dto.response.${table.className}PageDTO;
import ${basePackage}.service.${table.className}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * management ${table.comment!table.className}后台管理
 *
 * @author ${author}
 */
@Api(tags = "(后台管理)${table.comment!table.className}")
@RestController
@RequestMapping("/management/${table.variableName}")
public class Mgt${table.className}Controller {

    @Resource
    private ${table.className}Service ${table.variableName}Service;

    @ApiOperation("新增")
    @PostMapping
    public void insert${table.className}(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody ${table.className}DetailDTO ${table.variableName}DetailDTO) {
        ${table.variableName}Service.insert${table.className}(userId, ${table.variableName}DetailDTO);
    }

    @PutMapping("/deleted")
    public void updateDeletedByIds(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody Collection<Long> ids,
            @RequestParam @ApiParam(value = "是否有效: 0:有效 1:无效") Integer deleted) {
        ${table.variableName}Service.updateDeletedByIds(userId, ids, deleted);
    }

    @PutMapping
    public void update${table.className}(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody ${table.className}DetailDTO ${table.variableName}DetailDTO) {
        ${table.variableName}Service.update${table.className}(userId, ${table.variableName}DetailDTO);
    }

    @GetMapping
    public ${table.className}DetailDTO get${table.className}ById(@RequestParam Long id) {
        return ${table.variableName}Service.get${table.className}ById(id);
    }

    @PostMapping("/page")
    public NormPagingResult<${table.className}PageDTO> pageQuery(
            @RequestBody ${table.className}QueryDTO ${table.variableName}QueryDTO,
            @ApiParam(value = "页码") @RequestParam(defaultValue = "1") Integer pageNum,
            @ApiParam(value = "每页条数") @RequestParam(defaultValue = "50") Integer pageSize,
            @ApiParam(value = "排序字段") @RequestParam(defaultValue = "updateTime") String sortProperty,
            @ApiParam(value = "分页方向") @RequestParam(defaultValue = "DESC") SortDirection sortDirection) {
        return ${table.variableName}Service.pageQuery(
                ${table.variableName}QueryDTO, pageSize, pageNum, sortProperty, sortDirection);
    }
}
