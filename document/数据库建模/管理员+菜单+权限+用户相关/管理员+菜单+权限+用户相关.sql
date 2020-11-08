/* 系统用户表 */
CREATE TABLE `t_sys_admin` (
  `id` int NOT NULL,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员密码',
  `logo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `remark` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` enum('on','off') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'on' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `t_sys_admin_login_log` */

DROP TABLE IF EXISTS `t_sys_admin_login_log`;

/*系统用户登录历史表` */
CREATE TABLE `t_sys_admin_login_log` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `admin_id` int NOT NULL COMMENT 't_ums_admin.id 管理员id',
  `address` varchar(128) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `login_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员登陆历史表';

/*Table structure for table `t_sys_admin_role` */

DROP TABLE IF EXISTS `t_sys_admin_role`;

/*管理员角色关系表` */
CREATE TABLE `t_sys_admin_role` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `admin_id` int unsigned NOT NULL COMMENT 't_sys_admin.id',
  `role_id` int unsigned NOT NULL COMMENT 't_sys_role.id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `t_sys_menu` */

DROP TABLE IF EXISTS `t_sys_menu`;

/*系统菜单表 */
CREATE TABLE `t_sys_menu` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(32) NOT NULL,
  `menu_type` enum('menu','button') DEFAULT NULL COMMENT '菜单类型：菜单导航、按钮',
  `parent_id` int unsigned DEFAULT '0',
  `sort_id` int unsigned NOT NULL DEFAULT '0' COMMENT '排序id',
  `status` enum('on','off') NOT NULL DEFAULT 'on' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `t_sys_role` */

DROP TABLE IF EXISTS `t_sys_role`;

/*角色表` */
CREATE TABLE `t_sys_role` (
  `id` bigint NOT NULL,
  `role_name` varchar(32) NOT NULL,
  `description` varchar(128) DEFAULT NULL,
  `status` enum('on','off') NOT NULL DEFAULT 'on',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sort_id` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `t_sys_role_menu` */

DROP TABLE IF EXISTS `t_sys_role_menu`;

/*角色菜单关系表` */
CREATE TABLE `t_sys_role_menu` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int unsigned NOT NULL COMMENT 't_sys_role.id',
  `menu_id` int unsigned NOT NULL COMMENT 't_sys_menu.id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `t_ums_user` */

DROP TABLE IF EXISTS `t_ums_user`;

/*用户表` */
CREATE TABLE `t_ums_user` (
  `id` bigint NOT NULL,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '别名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机',
  `logo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
  `gender` enum('man','woman','unknown') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'unknown' COMMENT '性别：男、女、未知',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `city` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '城市',
  `integration` int DEFAULT NULL COMMENT '积分',
  `growth` int DEFAULT NULL COMMENT '成长值',
  `level_id` int NOT NULL COMMENT 't_ums_user_level.id 会员等级id',
  `status` enum('on','off') DEFAULT 'on' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `t_ums_user_level` */

DROP TABLE IF EXISTS `t_ums_user_level`;

/*会员等级表` */
CREATE TABLE `t_ums_user_level` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `level_name` varchar(32) NOT NULL,
  `growth_need` int unsigned NOT NULL COMMENT '所需成长值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `t_ums_user_login_log` */

DROP TABLE IF EXISTS `t_ums_user_login_log`;

/*用户登录历史表` */
CREATE TABLE `t_ums_user_login_log` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint unsigned NOT NULL,
  `address` varchar(128) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `login_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `t_ums_user_receive_address` */

DROP TABLE IF EXISTS `t_ums_user_receive_address`;

/*用户收货地址表` */
CREATE TABLE `t_ums_user_receive_address` (
  `id` bigint NOT NULL,
  `user_id` bigint NOT NULL COMMENT 't_ums_user.id',
  `address_tag` varchar(20) NOT NULL COMMENT '地址标签：如 公司、家',
  `mobile` varchar(20) NOT NULL COMMENT '收货人手机',
  `defualt_status` enum('yes','no') NOT NULL DEFAULT 'no' COMMENT '是否设为默认地址',
  `post_code` varchar(20) DEFAULT NULL COMMENT '邮政编码',
  `province` varchar(128) DEFAULT NULL COMMENT '省份',
  `city` varchar(128) DEFAULT NULL COMMENT '城市',
  `region` varchar(128) DEFAULT NULL COMMENT '区/县',
  `detail_address` varchar(128) DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `t_ums_user_statistics` */

DROP TABLE IF EXISTS `t_ums_user_statistics`;

/*用户统计信息` */
CREATE TABLE `t_ums_user_statistics` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint unsigned NOT NULL COMMENT 't_ums_user.id',
  `total_consume_amount` bigint unsigned DEFAULT '0' COMMENT '累计消费金额',
  `total_order_count` int unsigned DEFAULT '0' COMMENT '总下单数量',
  `total_comment_count` int unsigned DEFAULT '0' COMMENT '总评论数量',
  `total_refund_count` int unsigned DEFAULT '0' COMMENT '累计退款次数',
  `total_login_count` int unsigned DEFAULT '0' COMMENT '总登录次数',
  `favorite_product_count` int unsigned DEFAULT '0' COMMENT '喜欢的商品数',
  `recent_order_time` datetime DEFAULT NULL COMMENT '最近下单事件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;