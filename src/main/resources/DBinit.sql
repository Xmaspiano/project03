DROP TABLE TelInfo;

CREATE TABLE TelInfo(
  id INT NOT NULL COMMENT '主键' ,
  telno VARCHAR(32)  COMMENT '电话号码' ,
  levelid INT  COMMENT '级别角色' ,
  REVISION INT  COMMENT '乐观锁' ,
  PRIMARY KEY (id)
) COMMENT = '手机号信息表';

DROP TABLE LevelRole;

CREATE TABLE LevelRole(
  id INT NOT NULL COMMENT '主键' ,
  name VARCHAR(32)  COMMENT '角色名称' ,
  level VARCHAR(32)  COMMENT '角色级别' ,
  REVISION INT  COMMENT '乐观锁' ,
  PRIMARY KEY (id)
) COMMENT = '角色级别';

DROP TABLE DepartmentInfo;

CREATE TABLE DepartmentInfo(
  id INT NOT NULL COMMENT '主键' ,
  name VARCHAR(32)  COMMENT '部门名称' ,
  REVISION INT  COMMENT '乐观锁' ,
  PRIMARY KEY (id)
) COMMENT = '部门信息';

DROP TABLE Selection;

CREATE TABLE Selection(
  id INT NOT NULL COMMENT '主键' ,
  deptid INT  COMMENT '部门ID' ,
  titletext VARCHAR(32)  COMMENT '选项题目' ,
  sort INT  COMMENT '排序' ,
  REVISION INT  COMMENT '乐观锁' ,
  PRIMARY KEY (id)
) COMMENT = '部门选项信息';

DROP TABLE SelectedDetail;

CREATE TABLE SelectedDetail(
  id INT NOT NULL COMMENT '主键' ,
  telid INT  COMMENT '手机信息ID' ,
  selectid INT  COMMENT '选项信息ID' ,
  score INT  COMMENT '得分' ,
  REVISION INT  COMMENT '乐观锁' ,
  CREATED_BY VARCHAR(32)  COMMENT '创建人;存储session对象名称：手机号' ,
  CREATED_TIME DateTime  COMMENT '创建时间' ,
  PRIMARY KEY (id)
) COMMENT = '选择信息表';
