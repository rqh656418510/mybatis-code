--- 各章节案例代码中使用到的数据库表信息

CREATE DATABASE `mybatis_plus_lesson` DEFAULT CHARACTER SET utf8mb4;

USE `mybatis_plus_lesson`;

CREATE TABLE `t_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_product`
(
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  name VARCHAR(50) DEFAULT NULL COMMENT '商品名称',
  price DECIMAL(10, 5) DEFAULT 0 COMMENT '价格',
  version BIGINT(20) DEFAULT 0 COMMENT '乐观锁版本号',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `deleted` int DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t_employee(id, last_name, gender, email, age) values(1, 'Jim','1', 'jim@gmail.com', 26), (2, 'Peter','1', 'peter@gmail.com', 29);
insert into t_employee(id, last_name, gender, email, age) values(3, 'David','1', 'david@gmail.com', 28),(4, 'Tom','1', 'tom@gmail.com', 25);
insert into t_department(id, name, deleted) values(1, '开发部门', 0), (2, '测试部门', 0), (3, '产品部', 1);
insert into t_product (id, name, price) values (1, 'C++ Primer Plus', 100);
insert into t_admin(id, name, type) values(1, 'Alex', 1);
