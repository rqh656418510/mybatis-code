--- 各章节案例代码中使用到的数据库表信息

CREATE DATABASE `mybatis_lesson` DEFAULT CHARACTER SET utf8mb4;

USE `mybatis_lesson`;

CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` int  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t_department(id, name) values(1, '开发部门'), (2, '测试部门');
insert into t_admin(id, name, email, status) values(1, 'root', 'root@gmail.com', 1);
insert into t_employee(id, last_name, gender, email, dept_id) values(1, 'Jim','1', 'jim@gmail.com', 1), (2, 'Peter','1', 'peter@gmail.com', 1);
