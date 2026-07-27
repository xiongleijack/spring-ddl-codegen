package com.codegen.generator;

import com.codegen.model.ColumnDefinition;
import com.codegen.model.TableDefinition;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 为 spiderAnnouncement* 模板构建 {@code SpiderAnnouncementEntity} 契约方法模型。
 * <p>
 * 表中存在同名 Java 字段则委托；否则生成 {@code return null} / 空 setter stub。
 * {@code java.sql.Date} 映射到 Timestamp 契约时自动转换。
 */
public final class SpiderAnnouncementContractBuilder {

    private SpiderAnnouncementContractBuilder() {
    }

    public static Map<String, Object> buildExtras(TableDefinition table) {
        Map<String, ColumnDefinition> byJavaName = indexByJavaName(table);
        List<ContractMethod> methods = new ArrayList<ContractMethod>();

        addStringGetterSetter(methods, byJavaName, "bulletinTitle");
        addStringGetterSetter(methods, byJavaName, "attachmentTitle");
        addTimestampGetter(methods, byJavaName, "bulletinDate");
        addTimestampGetter(methods, byJavaName, "attachmentDate");
        addTimestampGetter(methods, byJavaName, "publishTime");
        addStringGetter(methods, byJavaName, "bondCode");
        addStringGetter(methods, byJavaName, "comChiName");
        addStringGetter(methods, byJavaName, "ossUrl");
        // create/update 走契约 getter，避免 Date 列与接口 Timestamp 签名冲突
        addTimestampGetter(methods, byJavaName, "createTime");
        addTimestampGetter(methods, byJavaName, "updateTime");

        List<String> contractFieldNames = new ArrayList<String>();
        contractFieldNames.add("bulletinTitle");
        contractFieldNames.add("attachmentTitle");
        contractFieldNames.add("bulletinDate");
        contractFieldNames.add("attachmentDate");
        contractFieldNames.add("publishTime");
        contractFieldNames.add("bondCode");
        contractFieldNames.add("comChiName");
        contractFieldNames.add("ossUrl");
        contractFieldNames.add("createTime");
        contractFieldNames.add("updateTime");

        Map<String, Object> extras = new LinkedHashMap<String, Object>();
        extras.put("spiderContractMethods", methods);
        extras.put("spiderContractFieldNames", contractFieldNames);
        extras.put("spiderNeedsTimestampImport", Boolean.TRUE);
        extras.put("spiderNeedsObjectsImport", needsObjectsImport(methods, byJavaName));
        return extras;
    }

    private static Map<String, ColumnDefinition> indexByJavaName(TableDefinition table) {
        Map<String, ColumnDefinition> map = new LinkedHashMap<String, ColumnDefinition>();
        if (table.getColumns() == null) {
            return map;
        }
        for (ColumnDefinition column : table.getColumns()) {
            if (column.getJavaName() != null) {
                map.put(column.getJavaName(), column);
            }
        }
        return map;
    }

    private static void addStringGetterSetter(List<ContractMethod> methods,
                                              Map<String, ColumnDefinition> byJavaName,
                                              String fieldName) {
        addStringGetter(methods, byJavaName, fieldName);
        ColumnDefinition column = byJavaName.get(fieldName);
        if (column != null && isStringType(column.getJavaType())) {
            // setter 由字段循环生成（带 @Override），此处不重复
            return;
        }
        ContractMethod setter = new ContractMethod();
        setter.setKind("setter");
        setter.setMethodName("set" + TemplateUtilsStatic.firstUpper(fieldName));
        setter.setParamType("String");
        setter.setParamName(fieldName);
        setter.setMode("noop");
        methods.add(setter);
    }

    private static void addStringGetter(List<ContractMethod> methods,
                                        Map<String, ColumnDefinition> byJavaName,
                                        String fieldName) {
        ContractMethod getter = new ContractMethod();
        getter.setKind("getter");
        getter.setMethodName("get" + TemplateUtilsStatic.firstUpper(fieldName));
        getter.setReturnType("String");
        ColumnDefinition column = byJavaName.get(fieldName);
        if (column != null && isStringType(column.getJavaType())) {
            getter.setFieldName(fieldName);
            getter.setMode("delegate");
        } else {
            getter.setMode("null");
        }
        methods.add(getter);
    }

    private static void addTimestampGetter(List<ContractMethod> methods,
                                           Map<String, ColumnDefinition> byJavaName,
                                           String fieldName) {
        ContractMethod getter = new ContractMethod();
        getter.setKind("getter");
        getter.setMethodName("get" + TemplateUtilsStatic.firstUpper(fieldName));
        getter.setReturnType("Timestamp");
        ColumnDefinition column = byJavaName.get(fieldName);
        if (column == null) {
            getter.setMode("null");
        } else if (isTimestampType(column.getJavaType())) {
            getter.setFieldName(fieldName);
            getter.setMode("timestampCopy");
        } else if (isSqlDateType(column.getJavaType())) {
            getter.setFieldName(fieldName);
            getter.setMode("dateToTimestamp");
        } else {
            getter.setMode("null");
        }
        methods.add(getter);
    }

    private static boolean needsObjectsImport(List<ContractMethod> methods,
                                              Map<String, ColumnDefinition> byJavaName) {
        for (ContractMethod method : methods) {
            if ("timestampCopy".equals(method.getMode()) || "dateToTimestamp".equals(method.getMode())) {
                return true;
            }
        }
        ColumnDefinition createTime = byJavaName.get("createTime");
        ColumnDefinition updateTime = byJavaName.get("updateTime");
        return (createTime != null && isTimestampType(createTime.getJavaType()))
                || (updateTime != null && isTimestampType(updateTime.getJavaType()));
    }

    private static boolean isStringType(String javaType) {
        return javaType != null && (javaType.equals("String") || javaType.endsWith(".String"));
    }

    private static boolean isTimestampType(String javaType) {
        return javaType != null && (javaType.equals("Timestamp")
                || javaType.equals("java.sql.Timestamp")
                || javaType.endsWith(".Timestamp"));
    }

    private static boolean isSqlDateType(String javaType) {
        if (javaType == null) {
            return false;
        }
        if (javaType.equals("java.sql.Date") || javaType.endsWith(".sql.Date")) {
            return true;
        }
        // 裸 Date 在 TypeMapper 里通常是 java.sql.Date
        return "Date".equals(javaType);
    }

    /** FreeMarker / 模板使用的契约方法描述 */
    public static final class ContractMethod {
        private String kind;
        private String methodName;
        private String returnType;
        private String paramType;
        private String paramName;
        private String fieldName;
        /** delegate | null | assign | noop | timestampCopy | dateToTimestamp */
        private String mode;

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        public String getReturnType() {
            return returnType;
        }

        public void setReturnType(String returnType) {
            this.returnType = returnType;
        }

        public String getParamType() {
            return paramType;
        }

        public void setParamType(String paramType) {
            this.paramType = paramType;
        }

        public String getParamName() {
            return paramName;
        }

        public void setParamName(String paramName) {
            this.paramName = paramName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }
    }

    /** 避免与实例 TemplateUtils 循环依赖的静态小工具 */
    private static final class TemplateUtilsStatic {
        private static String firstUpper(String value) {
            if (value == null || value.isEmpty()) {
                return value;
            }
            return Character.toUpperCase(value.charAt(0)) + value.substring(1);
        }
    }
}
