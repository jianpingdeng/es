#create database
drop database if exists es_db;
create database es_db;
use es_db;

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_mysql_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_mysql_user`;
CREATE TABLE `t_mysql_user` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `username` varchar(50) default '',
  `password` varchar(100) default '',
  `salt` varchar(50) default 'djp_es_salt',
  `status` int(2) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t_mysql_user(username,password) values('admin','123456');

DROP TABLE IF EXISTS `t_mysql_roles`;
CREATE TABLE `t_mysql_roles` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `role` varchar(50) default NULL,
  `role_desc` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mysql_roles
-- ----------------------------
INSERT INTO t_mysql_roles VALUES ('1', 'admin', '管理员');
INSERT INTO t_mysql_roles VALUES ('2', 'superadmin', '超级管理员');
INSERT INTO t_mysql_roles VALUES ('3', 'ceo', 'CEO');
INSERT INTO t_mysql_roles VALUES ('4', 'programer', '程序员');
INSERT INTO t_mysql_roles VALUES ('5', 'programleader', '项目经理');

DROP TABLE IF EXISTS `t_mysql_user_role`;
CREATE TABLE `t_mysql_user_role` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mysql_user_role
-- ----------------------------
INSERT INTO t_mysql_user_role VALUES ('1', '1', '1');
INSERT INTO t_mysql_user_role VALUES ('2', '1', '2');
INSERT INTO t_mysql_user_role VALUES ('3', '1', '4');

DROP TABLE IF EXISTS `t_mysql_permission`;
CREATE TABLE `t_mysql_permission` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `permission` varchar(50) default NULL,
  `permission_desc` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mysql_permission
-- ----------------------------
INSERT INTO t_mysql_permission VALUES ('1', 'user_query', '查看用户列表权限');
INSERT INTO t_mysql_permission VALUES ('2', 'user_modify', '更新用户信息权限');
INSERT INTO t_mysql_permission VALUES ('3', 'user_insert', '添加用户权限');
INSERT INTO t_mysql_permission VALUES ('4', 'user_delete', '删除用户权限');
INSERT INTO t_mysql_permission VALUES ('5', 'role_query', '查看角色权限');
INSERT INTO t_mysql_permission VALUES ('6', 'role_modify', '修改角色权限');
INSERT INTO t_mysql_permission VALUES ('7', 'role_insert', '添加角色权限');
INSERT INTO t_mysql_permission VALUES ('8', 'role_delete', '删除角色权限');

DROP TABLE IF EXISTS `t_mysql_role_permission`;
CREATE TABLE `t_mysql_role_permission` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `role_id` int(11) default NULL,
  `permission_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mysql_role_permission
-- ----------------------------
INSERT INTO t_mysql_role_permission VALUES ('1', '1', '1');
INSERT INTO t_mysql_role_permission VALUES ('2', '1', '2');
INSERT INTO t_mysql_role_permission VALUES ('3', '1', '3');
INSERT INTO t_mysql_role_permission VALUES ('4', '1', '4');
INSERT INTO t_mysql_role_permission VALUES ('5', '1', '5');
INSERT INTO t_mysql_role_permission VALUES ('6', '1', '6');
INSERT INTO t_mysql_role_permission VALUES ('7', '1', '7');
INSERT INTO t_mysql_role_permission VALUES ('8', '1', '8');