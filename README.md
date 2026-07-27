# spring-ddl-codegen

基于 **DDL + FreeMarker 模板** 的 Spring Boot 代码生成器。从 MySQL 建表语句生成 Entity、Mapper、Service、Controller 等代码，并支持业务主键推断、导入/导出开关。

## 环境要求

- JDK 8+
- Maven 3.6+

## 快速开始

### 1. 打包

```bash
cd D:\my-code\github\spring-ddl-codegen
mvn package
```

产物：`target/spring-ddl-codegen-0.1.0-SNAPSHOT.jar`

建议把 JAR 放到固定目录（如 `D:\tools\spring-ddl-codegen.jar`），**各业务项目只放配置文件，不用拷贝生成器**。

### 2. 在业务项目中添加配置

在项目根目录创建 `codegen.yaml`，参考 [examples/sample-project/codegen.yaml](examples/sample-project/codegen.yaml)：

```yaml
project:
  basePackage: com.example.order
  author: your-name

paths:
  entity: src/main/java/com/example/order/domain/entity
  mapper: src/main/java/com/example/order/infrastructure/mapper
  service: src/main/java/com/example/order/application/service
  serviceImpl: src/main/java/com/example/order/application/service/impl
  controller: src/main/java/com/example/order/api/controller

options:
  enableImport: true      # 是否生成 ImportController
  enableExport: true      # 是否生成 ExportController
  businessKey: auto       # 业务主键：auto / 字段名 / none
  overwrite: false        # 是否覆盖已存在文件

stack:
  orm: mybatis-plus
  lombok: true
  swagger: true
```

### 3. 准备 DDL 文件

例如 `ddl/order.sql`（MySQL 语法）：

```sql
CREATE TABLE `t_order` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_no` varchar(32) NOT NULL COMMENT '订单号',
  `amount` decimal(10, 2) NOT NULL COMMENT '订单金额',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_order_no` (`order_no`)
) ENGINE=InnoDB COMMENT='订单表';
```

### 4. 生成代码

**预览（不写文件）：**

```bash
java -jar spring-ddl-codegen-0.1.0-SNAPSHOT.jar generate ^
  -c D:\your-project\codegen.yaml ^
  -f D:\your-project\ddl\order.sql ^
  --dry-run
```

**写入项目：**

```bash
java -jar spring-ddl-codegen-0.1.0-SNAPSHOT.jar generate ^
  -c D:\your-project\codegen.yaml ^
  -f D:\your-project\ddl\order.sql ^
  --write
```

**指定输出根目录（可选）：**

```bash
java -jar spring-ddl-codegen-0.1.0-SNAPSHOT.jar generate ^
  -c D:\your-project\codegen.yaml ^
  -f D:\your-project\ddl\order.sql ^
  -o D:\your-project ^
  --write
```

未指定 `-o` 时，默认以 `codegen.yaml` 所在目录为项目根目录。

## 命令行参数

| 参数 | 说明 |
|------|------|
| `-c, --config` | 配置文件路径（必填） |
| `-f, --ddl` | DDL 文件路径（必填，支持多个 `CREATE TABLE`） |
| `-o, --output` | 项目根目录（可选） |
| `--dry-run` | 仅打印将生成的文件路径 |
| `--write` | 写入文件（与 `--dry-run` 二选一） |
| `-h, --help` | 帮助 |
| `-V, --version` | 版本 |

查看帮助：

```bash
java -jar target/spring-ddl-codegen-0.1.0-SNAPSHOT.jar --help
```

## 配置说明

### project

| 字段 | 说明 |
|------|------|
| `basePackage` | Java 根包名 |
| `author` | 生成代码 `@author` |

### paths

各层代码相对于项目根目录的输出路径。按你实际包结构修改即可。

### options

| 字段 | 可选值 | 说明 |
|------|--------|------|
| `enableImport` | `true` / `false` | 是否生成 `XxxImportController` |
| `enableExport` | `true` / `false` | 是否生成 `XxxExportController` |
| `businessKey` | `auto` | 自动从**单列 UNIQUE 索引**推断业务主键 |
| | `order_no` 等字段名 | 手动指定业务主键列 |
| | `none` | 不生成业务主键相关接口 |
| `overwrite` | `true` / `false` | 目标文件已存在时是否覆盖 |

**业务主键规则（`auto`）：**

- 查找非主键的单列 `UNIQUE KEY`
- 例如 `UNIQUE KEY uk_order_no (order_no)` → 业务主键为 `order_no`
- 会额外生成 `getByOrderNo` 等 Service / Controller 方法

### stack

| 字段 | 说明 |
|------|------|
| `orm` | 当前模板按 `mybatis-plus` 生成 |
| `lombok` | Entity 是否使用 `@Data` |
| `swagger` | 是否生成 Swagger 注解 |

## 生成内容

每个表默认生成：

| 文件 | 模板 |
|------|------|
| `Xxx.java` | Entity |
| `XxxMapper.java` | Mapper |
| `XxxService.java` | Service 接口 |
| `XxxServiceImpl.java` | Service 实现 |
| `XxxController.java` | REST Controller |

可选：

| 文件 | 条件 |
|------|------|
| `XxxImportController.java` | `enableImport: true` |
| `XxxExportController.java` | `enableExport: true` |

## 公告爬虫模板（sentiment-data-center）

配置名与输出类名分离：yaml 用 `spiderAnnouncement*`，生成文件仍叫 `XxxDO` / `XxxCanalDTO` / `XxxDAO`。

```yaml
templates:
  - spiderAnnouncementDO
  - spiderAnnouncementCanalDTO
  - spiderAnnouncementDAO
  - mapper

options:
  overwrite: true
  # 可选，默认已对齐 sentiment-data-center
  # spiderAnnouncementEntityClass: com.innodealing.sentimentdatacenter.model.entity.spider.SpiderAnnouncementEntity
  # spiderAnnouncementSyncClass: com.innodealing.sentimentdatacenter.dao.spider.SpiderAnnouncementLongPrimaryEntitySync
```

| yaml 配置名 | 输出文件 | 行为 |
|-------------|----------|------|
| `spiderAnnouncementDO` | `XxxDO.java` | `implements SpiderAnnouncementEntity`；同名列委托契约，否则 `return null` |
| `spiderAnnouncementCanalDTO` | `XxxCanalDTO.java` | 同上 + `@JsonProperty` |
| `spiderAnnouncementDAO` | `XxxDAO.java` | `implements SpiderAnnouncementLongPrimaryEntitySync` + `listByIds` |
| `mapper` | `XxxMapper.java` | 与普通表相同 |

**不要**与 `do` / `canalDTO` / `dao` 同时开启（会写同名文件）。标题/时间等业务映射仍需按 mapping 手工或 Agent override。

## 自定义模板

模板位于：

```text
src/main/resources/templates/
├── do.ftl
├── dao.ftl
├── mapper.ftl
├── canalDto.ftl
├── spiderAnnouncementDo.ftl
├── spiderAnnouncementCanalDto.ftl
├── spiderAnnouncementDao.ftl
└── ...
```

修改模板后重新 `mvn package` 即可。模板引擎为 [FreeMarker](https://freemarker.apache.org/)，可用变量包括：

- `config` — 完整配置对象
- `table` — 表定义（列、索引、类名等）
- `pk` — 主键列
- `businessKey` — 业务主键列（可能为空）
- `hasBusinessKey` — 是否有业务主键
- `basePackage` / `author`
- `util` — 命名工具（`firstUpper`、`simpleType` 等）

## 与 AI / Cursor 配合

推荐流程：

1. 在 Cursor 里与 AI 确认表结构，产出 DDL 文件
2. 保存到业务项目的 `ddl/xxx.sql`
3. 执行本工具生成代码
4. 在 IDE 中编译、微调业务逻辑

后续可写 Cursor Skill，在确认 DDL 后自动执行：

```bash
java -jar D:\tools\spring-ddl-codegen.jar generate -c codegen.yaml -f ddl/xxx.sql --write
```

## 示例

仓库内自带完整示例：

```bash
java -jar target/spring-ddl-codegen-0.1.0-SNAPSHOT.jar generate ^
  -c examples/sample-project/codegen.yaml ^
  -f examples/sample-project/ddl/order.sql ^
  --dry-run
```

生成结果见 `examples/sample-project/src/main/java/...`。

## 当前限制（初版）

- 仅支持 MySQL 风格 `CREATE TABLE`
- 不支持存储过程、视图
- 联合唯一索引暂不支持作为 `auto` 业务主键
- Import/Export 仅为骨架，需自行实现文件解析逻辑
- 未生成 Mapper XML

## 常见问题

**Q: 文件已存在，为什么没有覆盖？**  
A: 默认 `overwrite: false`。改为 `true` 或手动删除旧文件。

**Q: 没有生成业务主键接口？**  
A: 检查 DDL 是否有单列 `UNIQUE KEY`，或把 `businessKey` 改为具体字段名。

**Q: 包路径不对？**  
A: 修改 `codegen.yaml` 里的 `paths.*` 和 `project.basePackage`，与项目结构保持一致。

**Q: 多个表怎么生成？**  
A: 在同一个 DDL 文件中写多个 `CREATE TABLE`，一次命令全部生成。
