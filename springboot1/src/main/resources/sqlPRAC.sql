/* 创建部门表 */
CREATE TABLE `dept` (
  `deptno` int() NOT NULL,
  `dname` varchar(50) DEFAULT NULL,
  `loc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 创建雇员表 */
CREATE TABLE `emp` (
  `empno` int() NOT NULL,
  `ename` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `mgr` int() DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `COMM` decimal(7,2) DEFAULT NULL,
  `deptno` int() DEFAULT NULL,
  PRIMARY KEY (`empno`),
  KEY `fk_emp` (`mgr`),
  CONSTRAINT `fk_emp` FOREIGN KEY (`mgr`) REFERENCES `emp` (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 创建工资等级表 */
CREATE TABLE `salgrade` (
  `grade` int() NOT NULL,
  `losal` int() DEFAULT NULL,
  `hisal` int() DEFAULT NULL,
  PRIMARY KEY (`grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 创建学生表 */
CREATE TABLE `stu` (
  `sid` int() NOT NULL,
  `sname` varchar(50) DEFAULT NULL,
  `age` int() DEFAULT NULL,
  `gander` varchar(10) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `tuition` int() DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/插入dept表数据/
INSERT INTO dept values (10, '教研部', '北京');
INSERT INTO dept values (20, '学工部', '上海');
INSERT INTO dept values (30, '销售部', '广州');
INSERT INTO dept values (40, '财务部', '武汉');

/插入emp表数据/
 INSERT INTO emp VALUES (1009, '曾阿牛', '董事长', NULL, '2001-11-17', 50000, NULL, 10);
 INSERT INTO emp VALUES (1004, '刘备', '经理', 1009, '2001-04-02', 29750, NULL, 20);
 INSERT INTO emp VALUES (1006, '关羽', '经理', 1009, '2001-05-01', 28500, NULL, 30);
 INSERT INTO emp VALUES (1007, '张飞', '经理', 1009, '2001-09-01', 24500, NULL, 10);
 INSERT INTO emp VALUES (1008, '诸葛亮', '分析师', 1004, '2007-04-19', 30000, NULL, 20);
 INSERT INTO emp VALUES (1013, '庞统', '分析师', 1004, '2001-12-03', 30000, NULL, 20);
 INSERT INTO emp VALUES (1002, '黛绮丝', '销售员', 1006, '2001-02-20', 16000, 3000, 30);
 INSERT INTO emp VALUES (1003, '殷天正', '销售员', 1006, '2001-02-22', 12500, 5000, 30);
 INSERT INTO emp VALUES (1005, '谢逊', '销售员', 1006, '2001-09-28', 12500, 14000, 30);
 INSERT INTO emp VALUES (1010, '韦一笑', '销售员', 1006, '2001-09-08', 15000, 0, 30);
 INSERT INTO emp VALUES (1012, '程普', '文员', 1006, '2001-12-03', 9500, NULL, 30);
 INSERT INTO emp VALUES (1014, '黄盖', '文员', 1007, '2002-01-23', 13000, NULL, 10);
 INSERT INTO emp VALUES (1011, '周泰', '文员', 1008, '2007-05-23', 11000, NULL, 20);
 INSERT INTO emp VALUES (1001, '甘宁', '文员', 1013, '2000-12-17', 8000, NULL, 20);
 INSERT INTO emp VALUES (1015, '张三', '保洁员', 1009, '2001-09-01', 24500, 50000, 50);

  /插入salgrade表数据/
 INSERT INTO salgrade values (1, 7000, 12000);
 INSERT INTO salgrade values (2, 120, 14000);
 INSERT INTO salgrade values (3, 140, 20000);
 INSERT INTO salgrade values (4, 200, 30000);
 INSERT INTO salgrade values (5, 300, 99990);
 
  /插入stu表数据/
 insert into stu values ('1', '王永', '23', '男', '北京', '1500');
 insert into stu values ('2', '张雷', '25', '男', '辽宁', '2500');
 insert into stu values ('3', '李强', '22', '男', '北京', '3500');
 insert into stu values ('4', '宋永合', '25', '男', '北京', '1500');
 insert into stu values ('5', '叙美丽', '23', '女', '北京', '1000');
 insert into stu values ('6', '陈宁', '22', '女', '山东', '2500');
 insert into stu values ('7', '王丽', '22', '女', '北京', '1600');
 insert into stu values ('8', '李永', '23', '男', '北京', '3500');
 insert into stu values ('9', '张玲', '23', '女', '广州', '2500');
 insert into stu values ('10', '啊历', '18', '男', '山西', '3500');
 insert into stu values ('11', '王刚', '23', '男', '湖北', '4500');
 insert into stu values ('12', '陈永', '24', '男', '北京', '1500');
 insert into stu values ('13', '李雷', '24', '男', '辽宁', '2500');
 insert into stu values ('14', '李沿', '22', '男', '北京', '3500');
 insert into stu values ('15', '王小明', '25', '男', '北京', '1500');
 insert into stu values ('16', '王小丽', '23', '女', '北京', '1000');
 insert into stu values ('17', '唐宁', '22', '女', '山东', '2500');
 insert into stu values ('18', '唐丽', '22', '女', '北京', '1600');
 insert into stu values ('19', '啊永', '23', '男', '北京', '3500');
 insert into stu values ('20', '唐玲', '23', '女', '广州', '2500');
 insert into stu values ('21', '叙刚', '18', '男', '山西', '3500');
 insert into stu values ('22', '王累', '23', '男', '湖北', '4500');
 insert into stu values ('23', '赵安', '23', '男', '北京', '1500');
 insert into stu values ('24', '关雷', '25', '男', '辽宁', '2500');
 insert into stu values ('25', '李字', '22', '男', '北京', '3500');
 insert into stu values ('26', '叙安国', '25', '男', '北京', '1500');
 insert into stu values ('27', '陈浩难', '23', '女', '北京', '1000');
 insert into stu values ('28', '陈明', '22', '女', '山东', '2500');
 insert into stu values ('29', '孙丽', '41', '女', '北京', '1600');
 insert into stu values ('30', '李治国', '23', '男', '北京', '3500');
 insert into stu values ('31', '张娜', '23', '女', '广州', '2500');
 insert into stu values ('32', '安强', '18', '男', '山西', '3500');
 insert into stu values ('33', '王欢', '23', '男', '湖北', '4500');
 insert into stu values ('34', '周天乐', '23', '男', '北京', '1500');
 insert into stu values ('35', '关雷', '25', '男', '辽宁', '2500');
 insert into stu values ('36', '吴强', '22', '男', '北京', '3500');
 insert into stu values ('37', '吴合国', '25', '男', '北京', '1500');
 insert into stu values ('38', '正小和', '23', '女', '北京', '1000');
 insert into stu values ('39', '吴丽', '22', '女', '山东', '2500');
 insert into stu values ('40', '冯含', '25', '女', '北京', '1600');
 insert into stu values ('41', '陈冬', '23', '男', '北京', '3500');
 insert into stu values ('42', '关玲', '23', '女', '广州', '2500');
 insert into stu values ('43', '包利', '18', '男', '山西', '3500');
 insert into stu values ('44', '威刚', '23', '男', '湖北', '4500');
 insert into stu values ('45', '李永', '23', '男', '北京', '1500');
 insert into stu values ('46', '张关雷', '25', '男', '辽宁', '2500');
 insert into stu values ('47', '送小强', '22', '男', '北京', '3500');
 insert into stu values ('48', '关动林', '25', '男', '北京', '1500');
 insert into stu values ('49', '苏小哑', '23', '女', '北京', '1000');
 insert into stu values ('50', '赵宁', '22', '女', '山东', '2500');
 insert into stu values ('51', '陈丽', '12', '女', '北京', '1600');
 insert into stu values ('52', '钱小刚', '23', '男', '北京', '3500');
 insert into stu values ('53', '艾林', '23', '女', '广州', '2500');
 insert into stu values ('54', '郭林', '18', '男', '山西', '3500');
 insert into stu values ('55', '周制强', '23', '男', '湖北', '4500');