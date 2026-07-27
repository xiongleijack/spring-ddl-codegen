CREATE TABLE `bond_info_safe_xzcf_data` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `com_chi_name` varchar(200) DEFAULT NULL COMMENT '涉及对象',
  `oss_url` varchar(500) DEFAULT NULL COMMENT '附件',
  `document_num` varchar(100) DEFAULT NULL COMMENT '文号',
  `penalty_decision_dt` date DEFAULT NULL COMMENT '处罚决定日期',
  `publish_time` timestamp NULL DEFAULT NULL COMMENT '发布时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='外汇管理局处罚信息表';
