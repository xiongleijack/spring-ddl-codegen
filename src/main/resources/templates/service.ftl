<#-- Service接口模板 - 对齐 tmpl.json 风格 -->
package ${basePackage}.service;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import ${basePackage}.model.dto.${table.className}DetailDTO;
import ${basePackage}.model.dto.request.${table.className}QueryDTO;
import ${basePackage}.model.dto.response.${table.className}PageDTO;
import ${basePackage}.model.entity.${table.className}DO;

import java.util.Collection;

/**
 * ${table.comment!table.className}表Service层 {@link ${table.className}DO}
 *
 * @author ${author}
 */
public interface ${table.className}Service {

    /**
     * 新增数据处理
     *
     * @param userId              用户id
     * @param ${table.variableName}DetailDTO 用户请求对象
     */
    void insert${table.className}(Long userId, ${table.className}DetailDTO ${table.variableName}DetailDTO);

    /**
     * 更新deleted字段
     *
     * @param userId  用户id
     * @param ids     主键集合
     * @param deleted 删除状态
     */
    void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted);

    /**
     * 更新数据
     *
     * @param userId              用户id
     * @param ${table.variableName}DetailDTO 请求对象
     */
    void update${table.className}(Long userId, ${table.className}DetailDTO ${table.variableName}DetailDTO);

    /**
     * 根据主键获取数据
     *
     * @param id 主键
     * @return 数据
     */
    ${table.className}DetailDTO get${table.className}ById(Long id);

    /**
     * 分页查询
     *
     * @param ${table.variableName}QueryDTO 查询条件
     * @param pageSize             每页大小
     * @param pageNum              当前页
     * @param sortProperty         排序字段
     * @param sortDirection        排序方向
     * @return 分页结果
     */
    NormPagingResult<${table.className}PageDTO> pageQuery(
            ${table.className}QueryDTO ${table.variableName}QueryDTO, Integer pageSize,
            Integer pageNum, String sortProperty, SortDirection sortDirection);
}
