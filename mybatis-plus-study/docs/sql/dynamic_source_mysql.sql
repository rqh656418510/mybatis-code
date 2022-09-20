--- 第 13 章节使用到的数据库表信息


--- 创建数据库一

CREATE DATABASE `mybatis_plus_database_1` DEFAULT CHARACTER SET utf8mb4;

USE `mybatis_plus_database_1`;

CREATE TABLE `t_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t_employee(id, last_name, gender, email, age) values(1, 'Jim','1', 'jim@gmail.com', 26), (2, 'Peter','1', 'peter@gmail.com', 29);


--- 创建数据库二

CREATE DATABASE `mybatis_plus_database_2` DEFAULT CHARACTER SET utf8mb4;

USE `mybatis_plus_database_2`;

CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `deleted` int DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t_department(id, name, deleted) values(1, '开发部门', 0), (2, '测试部门', 0), (3, '产品部', 0);
