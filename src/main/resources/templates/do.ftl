<#-- ============================================================
     DO实体类模板
     生成 {ClassName}DO.java，对应数据库表的Java实体对象。
     使用 MyBatis-Plus 注解映射表名和字段。
     可选: @Data(Lombok)、@Schema(Swagger)
     ============================================================ -->
package ${basePackage}.domain.entity;

<#-- 条件导入: 启用Lombok时使用@Data替代getter/setter -->
<#if config.stack.lombok>
import lombok.Data;
</#if>
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
<#-- 条件导入: 启用Swagger时添加Schema注解 -->
<#if config.stack.swagger>
import io.swagger.v3.oas.annotations.media.Schema;
</#if>
<#-- 动态导入: 根据字段类型自动导入(如LocalDateTime、BigDecimal等) -->
<#list importTypes as importType>
import ${importType};
</#list>

/**
 * ${table.comment!table.className}表实体对象
 *
 * @author ${author}
 */
<#if config.stack.lombok>
@Data
</#if>
@TableName("${table.tableName}")
public class ${table.className}DO {

<#-- 遍历所有字段，生成属性定义 -->
<#list table.columns as column>
<#if config.stack.swagger>
    @Schema(description = "${column.comment!column.name}")
</#if>
<#-- 主键字段使用@TableId，普通字段使用@TableField -->
<#if column.primaryKey>
    @TableId(value = "${column.name}", type = IdType.AUTO)
<#else>
    @TableField("${column.name}")
</#if>
    private ${util.simpleType(column.javaType)} ${column.javaName};

</#list>
<#-- 未启用Lombok时，手动生成getter/setter方法 -->
<#if !config.stack.lombok>
<#list table.columns as column>
    public ${util.simpleType(column.javaType)} get${util.firstUpper(column.javaName)}() {
        return ${column.javaName};
    }

    public void set${util.firstUpper(column.javaName)}(${util.simpleType(column.javaType)} ${column.javaName}) {
        this.${column.javaName} = ${column.javaName};
    }

</#list>
</#if>
}
