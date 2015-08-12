#create database
drop database if exists es_db;
create database es_db;
use es_db;
create table USER_STATUS(user_status enum('1','0'));

DROP TABLE if EXISTS t_mysql_user;
create table `t_mysql_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL DEFAULT '',
  `password` VARCHAR(100) NOT NULL DEFAULT '',
  `salt` VARCHAR (10) NOT NULL DEFAULT 'djp_es_salt',
  `status` ENUM('1','0') NOT NULL DEFAULT '1'
);ENGINE=MyISAM  DEFAULT CHARSET=utf8;

