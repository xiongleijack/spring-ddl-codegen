package com.codegen.generator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 模板工具类，在FreeMarker模板中通过 ${util.xxx()} 调用。
 * 提供命名转换、类型简化、审计字段判断等辅助方法。
 */
public class TemplateUtils {

    /**
     * 审计字段集合，这些字段在生成DTO/BO时会被自动排除。
     * 包含常见的创建人、创建时间、更新人、更新时间、逻辑删除字段。
     */
    private static final Set<String> AUDIT_FIELDS = new HashSet<>(Arrays.asList(
            "createBy", "createTime", "updateBy", "updateTime", "deleted",
            "createdBy", "createdTime", "updatedBy", "updatedTime", "isDeleted"
    ));

    /**
     * 返回包后缀（直接透传，用于模板中拼接包名）
     *
     * @param suffix 包后缀字符串
     * @return 原样返回
     */
    public String packageSuffix(String suffix) {
        return suffix;
    }

    /**
     * 将字符串首字母转为小写（用于生成变量名）
     * 例如: "OrderInfo" -> "orderInfo"
     *
     * @param value 原始字符串
     * @return 首字母小写后的字符串
     */
    public String firstLower(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }
        return Character.toLowerCase(value.charAt(0)) + value.substring(1);
    }

    /**
     * 将字符串首字母转为大写（用于生成类名、方法名）
     * 例如: "orderNo" -> "OrderNo"
     *
     * @param value 原始字符串
     * @return 首字母大写后的字符串
     */
    public String firstUpper(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }
        return Character.toUpperCase(value.charAt(0)) + value.substring(1);
    }

    /**
     * 将全限定类型名转为简单类型名
     * 例如: "java.time.LocalDateTime" -> "LocalDateTime"
     *
     * @param fullType 全限定Java类型
     * @return 简单类型名
     */
    public String simpleType(String fullType) {
        return TypeMapper.simpleJavaType(fullType);
    }

    /**
     * 判断字段是否为审计字段（创建人/时间、更新人/时间、逻辑删除）。
     * 审计字段在生成DTO和BO时会被自动排除。
     *
     * @param javaName 字段的Java驼峰命名
     * @return true表示是审计字段
     */
    public boolean isAuditField(String javaName) {
        return AUDIT_FIELDS.contains(javaName);
    }
}
