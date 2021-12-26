CREATE TABLE `alert_log` (
  `id` bigint(20) NOT NULL COMMENT '日志Id',
  `create_date` bigint(20) DEFAULT NULL COMMENT '时间戳',
  `log_data` longtext COMMENT '日志Id',
  `alert_event_name` varchar(64) DEFAULT NULL COMMENT '事件名',
  `thread_id` varchar(64) DEFAULT NULL COMMENT '线程Id',
  `thread_name` varchar(128) DEFAULT NULL COMMENT '线程名',
  `host` varchar(64) DEFAULT NULL COMMENT '应用IP',
  `port` varchar(64) DEFAULT NULL COMMENT '应用端口',
  `url` varchar(256) DEFAULT NULL COMMENT '请求地址',
  `body` text COMMENT '请求体',
  `cookies` text COMMENT 'cookies',
  `requestParams` text COMMENT '请求参数',
  `requestHeader` text COMMENT '请求头',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;