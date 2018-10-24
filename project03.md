## <center>目录</center>
 - ### 1. 模块清单
- [<h4 id="module-project03-from">1.1. project03</h4>](#module-project03 "project03")
	- [<h5 id="module-project03-relation}-from">1.1.1. 关联关系</h5>](#module-project03-relation "关联关系")
	- [<h5 id="module-project03-tableList-from">1.1.2. 表清单</h5>](#module-project03-tableList "表清单")
	- [<h5 id="module-project03-tableColumnList-from">1.1.3. 表列清单</h5>](#module-project03-tableColumnList "表列清单")
		- [<h6 id="module-project03-tableColumnList-TelInfo-from">1.1.3.1 TelInfo【手机号信息表】</h6>](#module-project03-tableColumnList-TelInfo "TelInfo")
		- [<h6 id="module-project03-tableColumnList-LevelRole-from">1.1.3.2 LevelRole【角色级别】</h6>](#module-project03-tableColumnList-LevelRole "LevelRole")
		- [<h6 id="module-project03-tableColumnList-DepartmentInfo-from">1.1.3.3 DepartmentInfo【部门信息】</h6>](#module-project03-tableColumnList-DepartmentInfo "DepartmentInfo")
		- [<h6 id="module-project03-tableColumnList-Selection-from">1.1.3.4 Selection【部门选项信息】</h6>](#module-project03-tableColumnList-Selection "Selection")
		- [<h6 id="module-project03-tableColumnList-SelectedDetail-from">1.1.3.5 SelectedDetail【选择信息表】</h6>](#module-project03-tableColumnList-SelectedDetail "SelectedDetail")
  ---

### 1. 模块清单
 - [<h4 id="module-project03">1.1. project03</h4>](#module-project03-from)
 - [<h5 id="module-project03-relation">1.1.1 关联关系</h5>](#module-project03-relation-from)
 ---


![project03-关系图](./project03_files/project03-image.png)

 ---

 - [<h5 id="module-project03-tableList">1.1.2 表清单</h5>](#module-project03-tableList-from)

 ---

| 名称 | 代码 |
| ------------ | ------------ |
| 手机号信息表 | TelInfo |
| 角色级别 | LevelRole |
| 部门信息 | DepartmentInfo |
| 部门选项信息 | Selection |
| 选择信息表 | SelectedDetail |

 ---

 - [<h5 id="module-project03-tableColumnList">1.1.3 表列清单</h5>](#module-project03-tableColumnList-from)

 ---

 - [<h6 id="module-project03-tableColumnList-TelInfo">TelInfo【手机号信息表】</h6>](#module-project03-tableColumnList-TelInfo-from)

| 代码 | 名称 | 数据类型(Java/MySQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| id | 主键 | Integer/INT | √ |  |
| telno | 电话号码 | String/VARCHAR(32) |  |  |
| levelid | 级别角色 | Integer/INT |  |  |
| REVISION | 乐观锁 | Integer/INT |  |  |

 ---

 - [<h6 id="module-project03-tableColumnList-LevelRole">LevelRole【角色级别】</h6>](#module-project03-tableColumnList-LevelRole-from)

| 代码 | 名称 | 数据类型(Java/MySQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| id | 主键 | Integer/INT | √ |  |
| name | 角色名称 | String/VARCHAR(32) |  |  |
| level | 角色级别 | String/VARCHAR(32) |  |  |
| REVISION | 乐观锁 | Integer/INT |  |  |

 ---

 - [<h6 id="module-project03-tableColumnList-DepartmentInfo">DepartmentInfo【部门信息】</h6>](#module-project03-tableColumnList-DepartmentInfo-from)

| 代码 | 名称 | 数据类型(Java/MySQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| id | 主键 | Integer/INT | √ |  |
| name | 部门名称 | String/VARCHAR(32) |  |  |
| REVISION | 乐观锁 | Integer/INT |  |  |

 ---

 - [<h6 id="module-project03-tableColumnList-Selection">Selection【部门选项信息】</h6>](#module-project03-tableColumnList-Selection-from)

| 代码 | 名称 | 数据类型(Java/MySQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| id | 主键 | Integer/INT | √ |  |
| deptid | 部门ID | Integer/INT |  |  |
| titletext | 选项题目 | String/VARCHAR(32) |  |  |
| sort | 排序 | Integer/INT |  |  |
| REVISION | 乐观锁 | Integer/INT |  |  |

 ---

 - [<h6 id="module-project03-tableColumnList-SelectedDetail">SelectedDetail【选择信息表】</h6>](#module-project03-tableColumnList-SelectedDetail-from)

| 代码 | 名称 | 数据类型(Java/MySQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| id | 主键 | Integer/INT | √ |  |
| telid | 手机信息ID | Integer/INT |  |  |
| selectid | 选项信息ID | Integer/INT |  |  |
| score | 得分 | Integer/INT |  |  |
| REVISION | 乐观锁 | Integer/INT |  |  |
| CREATED_BY | 创建人 | String/VARCHAR(32) |  | 存储session对象名称：手机号 |
| CREATED_TIME | 创建时间 | Date/DateTime |  |  |

 ---

