--- 第 16 章节使用到的 Oracle 数据表信息

CREATE TABLE t_employee(id number(11) primary key, last_name varchar(255) DEFAULT NULL, gender char(1) DEFAULT NULL, email varchar(255) DEFAULT NULL, age number DEFAULT NULL);

create sequence seq_employee start with 100 increment by  2;

insert into t_employee(id, last_name, gender, email, age) values(1, 'Jim','1', 'jim@gmail.com', 26);
