# Mybatis-plus

## 简介

MyBatis-Plus （简称 MP）是一个 MyBatis (opens new window)的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。

## 特性

- **无侵入**：只做增强不做改变，引入它不会对现有工程产生影响，如丝般顺滑
- **损耗小**：启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作
- **强大的 CRUD 操作**：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作，更有强大的条件构造器，满足各类使用需求
- **支持 Lambda 形式调用**：通过 Lambda 表达式，方便的编写各类查询条件，无需再担心字段写错
- **支持主键自动生成**：支持多达 4 种主键策略（内含分布式唯一 ID 生成器 - Sequence），可自由配置，完美解决主键问题
- **支持 ActiveRecord 模式**：支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作
- **支持自定义全局通用操作**：支持全局通用方法注入（ Write once, use anywhere ）
- **内置代码生成器**：采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、 Controller 层代码，支持模板引擎，更有超多自定义配置等您来使用
- **内置分页插件**：基于 MyBatis 物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于普通 List 查询
- **分页插件支持多种数据库**：支持 MySQL、MariaDB、Oracle、DB2、H2、HSQL、SQLite、Postgre、SQLServer 等多种数据库
- **内置性能分析插件**：可输出 SQL 语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询
- **内置全局拦截插件**：提供全表 delete 、 update 操作智能分析阻断，也可自定义拦截规则，预防误操作

## 使用

### 1、创建springBoot项目

### 2、导入依赖

~~~xml
<!--引入mybatis-plus-->
<dependency>
  <groupId>com.baomidou</groupId>
  <artifactId>mybatis-plus-boot-starter</artifactId>
  <version>3.5.1</version>
</dependency>

<!-- mysql服务 -->
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>8.0.26</version>
</dependency>
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
</dependency>
~~~

### 3、spring配置文件中连接数据库

~~~properties
#服务访问端口
server.port=8081

#mysql8配置（和mysql5的区别是url后要跟时区，driver上要加cj）
spring.datasource.url=jdbc:mysql://localhost:3306/mp?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
~~~

### 4、创建好数据库

~~~sql
CREATE TABLE user
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);
INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');
~~~

### 5、创建实体类

~~~java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
~~~

### 6、实体类接口

```java
public interface UserMapper extends BaseMapper<User> {
}
```

7、在启动文件中加入扫描mapper的注解

~~~java
@MapperScan("com.zhang.mybatisplus.mapper")
~~~

### 8、配置日志

~~~properties
#配置日志，方便调错，在上线时去掉（会影响性能），默认的控制台输出日志
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
~~~

### 9、测试使用

~~~java
@Autowired
private UserMapper userMapper;

@Test
void test(){
  List<User> users = userMapper.selectList(null);
  for (User user : users) {
    System.out.println(user);
  }
}
~~~

### 10、插入操作

~~~java
@Test
void testInsert(){
  User user = new User();
  user.setAge(3);
  user.setName("张三");
  user.setEmail("127@qq.com");
  //我们并没有设置id，mybatis-plus会帮我们自动填充id
  int insert = userMapper.insert(user);
  System.out.println(insert);
}
~~~

![1645275677461](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1645275677461.png)

### 11、主键生成策略

> 数据库插入的默认也是全局唯一id

> 默认 ID_WORKER 全局唯一id

#### 雪花算法

Twitter使用scala语言开源了一种分布式 id 生成算法——SnowFlake算法，被翻译成了雪花算法。

![1645276125684](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1645276125684.png)

**组成部分（64bit）**

**1.第一位** 占用1bit，其值始终是0，没有实际作用。 **2.时间戳** 占用41bit，精确到毫秒，总共可以容纳约69年的时间。 **3.工作机器id** 占用10bit，其中高位5bit是数据中心ID，低位5bit是工作节点ID，做多可以容纳1024个节点。 **4.序列号** 占用12bit，每个节点每毫秒0开始不断累加，最多可以累加到4095，一共可以产生4096个ID。

SnowFlake算法在同一毫秒内最多可以生成多少个全局唯一ID呢：： **同一毫秒的ID数量 = 1024 X 4096 = 4194304**

#### 主键自增

就是在我们没有设置id属性的情况下会自动增加1后插入数据库

1、在实体类主键属性上加注解

~~~java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(type = IdType.AUTO) //主键自增
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
~~~

2、数据库中字段必须设置自增

3、测试插入



### 12、更新操作

~~~java
@Test
void testUpdate(){
  User user = new User();
  //通过条件自动拼接动态sql
  user.setId(5L);
  user.setName("李四");
  user.setAge(999);
  user.setEmail("123");
  //参数是一个对象
  userMapper.updateById(user);
}
~~~

### 13、自动填充

创建时间，修改时间！这些字段一般都是自动化完成的，不希望手动更新。

阿里巴巴开发手册：所有的数据库表都应该包含两个字段：gmt_create、gmt_modified（方便追踪数据修改和创建时间）需要自动化。

1、数据库字段

![1645278190665](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1645278190665.png)

2、实体类字段属性上要加

~~~java
@TableField(fill = FieldFill.INSERT)
private Date createTime;
@TableField(fill = FieldFill.INSERT_UPDATE)
private Date updateTime;
~~~

~~~java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
~~~

3、编写处理器处理注解

~~~java
//需要识别就要加到SpringBoot里面用这个注解
//把这个处理器加入到IOC容器中
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
  //    插入时的填充策略
  @Override
  public void insertFill(MetaObject metaObject) {
    //setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
    this.setFieldValByName("createTime",new Date(),metaObject);
    this.setFieldValByName("updateTime",new Date(),metaObject);
  }
  //    修改时的填充策略
  @Override
  public void updateFill(MetaObject metaObject) {
    this.setFieldValByName("updateTime",new Date(),metaObject);
  }
}
~~~

4、测试插入和更新，观察时间

~~~java
@Test
void testInsert(){
  User user = new User();
  user.setAge(3);
  user.setName("张三");
  user.setEmail("127@qq.com");
  //        我们并没有设置id，mybatis-plus会帮我们自动填充id
  int insert = userMapper.insert(user);
  System.out.println(insert);
}

@Test
void testUpdate(){
  User user = new User();
  user.setId(5L);
  user.setName("李四");
  user.setAge(999);
  user.setEmail("123");
  userMapper.updateById(user);
}
~~~

### 14、乐观锁

> 多线程下一定要加锁

### 15、查询操作

~~~java
@Test
void selectById(){
  User user = userMapper.selectById(1L);
  System.out.println(user);
}

@Test
//根据id批量查询用户
void selectBatchIds(){
  List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
  for (User user : users) {
    System.out.println(user);
  }
}

@Test
//条件查询之一 map
void testSelectByMap(){
  Map<String, Object> map = new HashMap<String, Object>();
  //自定义要查询的条件
  map.put("name","张三");
  //自动拼接
  map.put("age",3);
  List<User> users = userMapper.selectByMap(map);
  for (User user : users) {
    System.out.println(user);
  }
}
~~~

### 16、分页查询

> MP内置了分页插件，如何使用！

1、配置插件主体

~~~java
//这里配置了MapperScan注解，启动类中就不用加MapperScan注解了
@MapperScan("com.zhang.mybatisplus.mapper")
//加到SpringBoot配置中去
@Configuration
public class MybatisPlusConfig {
  private List<InnerInterceptor> interceptors = new ArrayList<>();

  /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    // 向MyBatis-Plus的过滤器链中添加分页拦截器，需要设置数据库类型（主要用于分页方言）
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
    return interceptor;
  }

}
~~~

测试

~~~java
@Test
//分页查询
void testSelectPage(){
  Page<User> page = new Page<User>(1,3);
  Page<User> userPage = userMapper.selectPage(page,null);
  List<User> userList = userPage.getRecords();
  for (User user : userList) {
    System.out.println(user);
  }
}
~~~

### 17、删除操作

~~~java
//通过id删除
@Test
void deleteById(){
  userMapper.deleteById(5L);
}

//通过map删除
@Test
void deleteByMap(){
  HashMap<String, Object> map = new HashMap<>();
  map.put("name","Tom");
  userMapper.deleteByMap(map);
}
~~~

### 18、逻辑删除

- 逻辑删除：文件没有被真正的删除，**通常这种删除操作是可逆的**，就是说用适当的工具或软件可以把删除的文件恢复出来。
- 物理删除：指文件存储所用到的存储区域被真正的擦除或清零，**这样删除的文件是不可以恢复的**，物理删除是计算机处理数据时的一个概念。

例如：

- 删除: `update user set deleted=1 where id = 1 and deleted=0`
- 查找: `select id,name,deleted from user where deleted=0`

1、数据库中增加字段 默认为0

![1645286156445](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1645286156445.png)

2、实体类中增加字段加注解

~~~java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @TableId(type = IdType.AUTO)
  private Long id;
  private String name;
  private Integer age;
  private String email;

  @TableLogic //逻辑删除注解
  private Integer deleted;

  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
}
~~~

3、配置

~~~properties
#配置逻辑删除
# 逻辑已删除值(默认为 1)
mybatis-plus.global-config.db-config.logic-delete-value:1
# 逻辑未删除值(默认为 0)
mybatis-plus.global-config.db-config.logic-not-delete-value:0
~~~

### 19、条件构造器（Wrapper）

它要传入一个Wrapper就  new 一个 QueryWrapper<T> 传入进去

#### QueryWrapper条件方法

~~~java
eq:等于 =
例:eq("name", "老王")--->name = '老王'
  
ne:不等于 <>
例: ne("name", "老王")--->name <> '老王'
  
qt:大于 >
例: gt("age", 18)--->age > 18
  
ge:大于等于 >=
例: ge("age", 18)--->age >= 18
  
it:小于 <
例: lt("age", 18)--->age < 18
  
le:小于等于 <=
例: le("age", 18)--->age <= 18
  
between:BETWEEN 值1 AND 值2
例: between("age", 18, 30)--->age between 18 and 30
  
notBetween:NOT BETWEEN 值1 AND 值2
例: notBetween("age", 18, 30)--->age not between 18 and 30
  
like:LIKE '%值%'
例: like("name", "王")--->name like '%王%'
  
notlike:NOT LIKE '%值%'
例: notLike("name", "王")--->name not like '%王%'
  
likeLeft:LIKE '%值'
例: likeLeft("name", "王")--->name like '%王'
  
likeRight:LIKE '值%'
例: likeRight("name", "王")--->name like '王%'
  
isNull:字段 IS NULL
例: isNull("name")--->name is null
  
isNotNull:字段 IS NOT NULL
例: isNotNull("name")--->name is not null
  
in:字段 IN (v0, v1, ...)
例: in("age", 1, 2, 3)--->age in (1,2,3)
  
notIn:字段 NOT IN (v0, v1, ...)
例: notIn("age", 1, 2, 3)--->age not in (1,2,3)
  
inSql:字段 IN ( sql语句 )
例: inSql("age", "1,2,3,4,5,6")--->age in (1,2,3,4,5,6)
例: inSql("id", "select id from table where id < 3")--->id in (select id from table where id < 3)
  
notInSql:字段 NOT IN ( sql语句 )
例: notInSql("age", "1,2,3,4,5,6")--->age not in (1,2,3,4,5,6)
例: notInSql("id", "select id from table where id < 3")--->id not in (select id from table where id < 3)
  
groupBy:分组：GROUP BY 字段, ...
例: groupBy("id", "name")--->group by id,name

orderByAsc:排序：ORDER BY 字段, ... ASC
例: orderByAsc("id", "name")--->order by id ASC,name ASC

orderByDesc:排序：ORDER BY 字段, ... DESC
例: orderByDesc("id", "name")--->order by id DESC,name DESC

orederBy:排序：ORDER BY 字段, ...
例: orderBy(true, true, "id", "name")--->order by id ASC,name ASC

having:HAVING ( sql语句 )
例: having("sum(age) > 10")--->having sum(age) > 10
例: having("sum(age) > {0}", 11)--->having sum(age) > 11
  
or:主动调用or表示紧接着下一个方法不是用and连接!(不调用or则默认为使用and连接)
  
and:默认使用and连接条件

apply:拼接sql  apply("date_format(dateColumn,'%Y-%m-%d') = {0}", "2008-08-08")--->date_format(dateColumn,'%Y-%m-%d') = '2008-08-08'")（有sql注入风险）
  
last:无视优化规则直接拼接到sql最后，多次调用以最后一次为准，last("limit 1")（有sql注入风险） 
~~~

#### UpdateWrapper

~~~java
setSql:设置 SET 部分 SQL
例: setSql("name = '老李头'")
~~~

#### 使用wrapper自定义sql

> 注解方式
>
> ```java
> @Select("select * from mysql_data ${ew.customSqlSegment}")
> List<MysqlData> getAll(@Param(Constants.WRAPPER) Wrapper wrapper);
> //传入一个Wrapper类型变量，要用@Param(Constants.WRAPPER)声明变量类型 使用${ew.customSqlSegment}获取条件拼接
> ```

> 用xml
>
> ```java
> List<MysqlData> getAll(Wrapper ew);
> ```
>
> ```xml
> <select id="getAll" resultType="MysqlData">
> 	SELECT * FROM mysql_data ${ew.customSqlSegment}
> </select>
> ```

测试

~~~java
@Test
void testWrapperSelect(){
  QueryWrapper<User> wrapper = new QueryWrapper<User>();
  wrapper
    .isNotNull("name")
    .isNotNull("email")
    .ge("age",12);
  List<User> users = userMapper.selectList(wrapper);
  for (User user : users) {
    System.out.println(user);
  }
}
~~~

测试

~~~java
@Test
//查询名字中没有张字的，并且email中包含com的
void testWrapperLike(){
  QueryWrapper<User> wrapper = new QueryWrapper<>();
  wrapper.notLike("name","张")
    .like("email","com");
  List<User> users = userMapper.selectList(wrapper);
  for (User user : users) {
    System.out.println(user);
  }
}
~~~

![1645351288827](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1645351288827.png)



### 20、代码自动生成器



