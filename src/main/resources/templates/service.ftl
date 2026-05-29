<#-- ============================================================
     Service接口模板
     生成 {ClassName}Service.java，定义业务层接口。
     不继承任何框架接口，保持纯净的业务契约。
     入参和出参均使用DTO对象，与实体DO解耦。
     ============================================================ -->
package ${basePackage}.application.service;

import ${basePackage}.api.dto.${table.className}DetailDTO;
import ${basePackage}.api.dto.${table.className}PageDTO;
import ${basePackage}.api.dto.${table.className}QueryDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * ${table.comment!table.className}表Service层
 *
 * @author ${author}
 */
public interface ${table.className}Service {

    /**
     * 新增
     *
     * @param detailDTO 详情对象
     */
    void create(${table.className}DetailDTO detailDTO);

    /**
     * 更新
     *
     * @param id        主键
     * @param detailDTO 详情对象
     */
    void update(${util.simpleType(pk.javaType)} id, ${table.className}DetailDTO detailDTO);

    /**
     * 删除
     *
     * @param id 主键
     */
    void delete(${util.simpleType(pk.javaType)} id);

    /**
     * 根据主键查询详情
     *
     * @param id 主键
     * @return 详情对象
     */
    ${table.className}DetailDTO getDetail(${util.simpleType(pk.javaType)} id);

    /**
     * 分页查询
     *
     * @param queryDTO 查询条件
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @return 分页结果
     */
    Page<${table.className}PageDTO> pageQuery(${table.className}QueryDTO queryDTO, Integer pageNum, Integer pageSize);
}
