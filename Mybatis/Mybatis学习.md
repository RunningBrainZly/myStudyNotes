# Mybatis学习

## 1.通过maven构建项目

```java
    <dependencies>
        <!--mybatis依赖-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.9</version>
        </dependency>
        <!--mysql驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.28</version>
        </dependency>
        <!--junit-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
    </dependencies>
```

![1644712130876](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1644712130876.png)

要把这里改一下，改称自己的maven路径，不然会默认把依赖下载到c盘



## 2.核心配置文件中构建 SqlSessionFactory

### 2.1.创建mybatis-config.xml核心配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  
      <!--数据表中字段以下划线分割就要开启驼峰，不然就获取到为空-->
    <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/xyll?useUnicode=true&amp;characterEncoding=utf-8&amp;useSSL=false&amp;serverTimezone=Asia/Shanghai"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>


    <!--<mappers>-->
        <!--<mapper resource="org/mybatis/example/BlogMapper.xml"/>-->
    <!--</mappers>-->
</configuration>
```

### 2.2.创建类获取SqlSessionFactory实例

```java
String resource = "org/mybatis/example/mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
```

### 2.3.从 SqlSessionFactory 中获取 SqlSession

```java
try (SqlSession session = sqlSessionFactory.openSession()) {
  BlogMapper mapper = session.getMapper(BlogMapper.class);
  Blog blog = mapper.selectBlog(101);
}
```

```java
package com.zhang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        try {
//            获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//            获取SqlSession对象
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}

```

### 2.4.实体类

### 2.5.接口 实现类

接口

```java
package com.zhang.dao;

import com.zhang.pojo.SchoolTable;

import java.util.List;

public interface SchoolTableDao  {
    List<SchoolTable> getSchoolList();
}
```

原来的接口实现类

```java
package com.zhang.dao.impl;

import com.zhang.dao.SchoolTableDao;
import com.zhang.pojo.SchoolTable;
import com.zhang.utils.MybatisSqlSessionFactory;

import java.util.List;

public class SchoolTableDaoImpl implements SchoolTableDao {
    private static MybatisSqlSessionFactory mybatisSqlSessionFactory;
//    在mapper.xml中写sql
    public List<SchoolTable> getSchoolList() {
      	//写操作数据库的代码了，用mybatis后在mapper.xml中写sql代码
        return null;
    }
}
```

### 2.6.Mapper.xml

mybatis中的实现类由原来的变为Mapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace=绑定的一个dao/mapper接口-->
<mapper namespace="com.zhang.dao.SchoolTableDao">
    <!--id:dao/mapper接口中的方法名，必须对应-->
  <!-- resultType返回的类型 -->
    <select id="getSchoolList" resultType="com.zhang.pojo.SchoolTable" >
    select * from xyll.school_table
  </select>
</mapper>
```

### 2.7.测试

​	junit

```java
package com.zhang.dao;

import com.zhang.pojo.SchoolTable;
import com.zhang.utils.MybatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SchoolTableDaoTest {
    private static SqlSession sqlSession;

    @Test
    public void test(){

        try{
            //        获取sqlSession对象
            sqlSession = MybatisSqlSessionFactory.getSqlSession();
//        执行sql
            SchoolTableDao mapper = sqlSession.getMapper(SchoolTableDao.class);
            List<SchoolTable> schoolList = mapper.getSchoolList();
            for(SchoolTable schoolTable: schoolList){
                System.out.print(schoolTable);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //        关闭sqlSession
            sqlSession.close();
        }
    }
}

```

遇见这个报错：org.apache.ibatis.binding.BindingException: Type interface com.zhang.dao.SchoolTableDao is not known to the MapperRegistry.

 解决：在mybatis核心配置文件中注册每一个mapper.xml

​		mapper.xml中namespace写错也会报这个错



### maven资源过滤问题：（如果没有报错就别加，加上还报错）

```xml
<!--在build中配置resources，防止资源导出失败问题-->
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
</build>
```



## CRUD（增删改需要添加事务才能成功）

### #{}中的变量要和pojo中的变量名相同

### 1.namespace:接口路径

​	（要和接口名一致）

### 2.id：接口方法名

​	（要和接口中方法名一致）

### 3.result：返回类型

​	（一般是实体类）

### 4.parameterType：参数类型

### 5.select

​	查询语句

​	5.1 在mapper中定义接口方法

```java
package com.zhang.mapper;

import com.zhang.pojo.SchoolTable;

import java.util.List;

public interface SchoolTableMapper {
//    根据id查询用户
    SchoolTable selectSchoolById(int id);
}
```



​	5.2 在对应的mapper.xml中定义对应的sql语句

```xml
    <select id="selectSchoolById" resultType="com.zhang.pojo.SchoolTable" parameterType="int">
        select * from xyll.school_table where school_id = #{id}
    </select>
```

​	5.3 使用

```java
        try{
            //        获取sqlSession对象
            sqlSession = MybatisSqlSessionFactory.getSqlSession();
//        执行sql
            SchoolTableMapper mapper = sqlSession.getMapper(SchoolTableMapper.class);
            SchoolTable schoolList = mapper.selectSchoolById(1);

            System.out.println(schoolList);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //        关闭sqlSession
            sqlSession.close();
        }
```

### 6.insert

​	插入语句

​	6.1 在mapper接口中定义方法（和查询一样）

​	6.2 在对应的mapper.xml中写插入语句

```xml
    <insert id="insertSchool" parameterType="com.zhang.pojo.SchoolTable">
      	<!-- 这里的值要和pojo字段对应 -->
        insert into xyll.school_table values(#{schoolId},#{schoolName});
    </insert>
```

​	6.3 使用

```java
sqlSession = MybatisSqlSessionFactory.getSqlSession();
        SchoolTableMapper mapper = sqlSession.getMapper(SchoolTableMapper.class);
        int res = mapper.insertSchool(new SchoolTable(4, "太原理工"));
        if(res > 0){
            //        提交事务
            sqlSession.commit();
        }
        sqlSession.close();
```

### 7.事务

```java
sqlSession.commit();
```

### 8.update

​	修改语句

​	8.1 在mapper接口中定义方法（和查询一样）

​	8.2 在对应的mapper.xml中写插入语句

```xml
    <update id="updateSchool" parameterType="com.zhang.pojo.SchoolTable">
        update xyll.school_table set school_name = #{schoolName} where school_id = #{schoolId};
    </update>
```

​	8.3 使用（和插入一样）

### 9.delete

​	删除语句

​	9.1 在mapper接口中定义方法（和查询一样）

​	9.2 在对应的mapper.xml中写插入语句

```xml
    <delete id="deleteSchoolById" parameterType="int">
        delete from xyll.school_table where school_id = #{schoolId}
    </delete>
```

​	9.3 使用



### 10.万能Map

假设，我们的实体类，或者数据库中的表，字段或者参数过多，我们应当考虑用Map！

​	10.1 接口定义

```java
//    Map插入
    int insertSchool2(Map<String,Object> map);
```

​	10.2 对应mapper.xml

```xml
<insert id="insertSchool2" parameterType="map">
    insert into xyll.school_table values(#{id},#{schoolname});
</insert>
```

​	10.3 使用

```java
sqlSession = MybatisSqlSessionFactory.getSqlSession();
        SchoolTableMapper mapper = sqlSession.getMapper(SchoolTableMapper.class);

        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("id",4);
        map.put("schoolname","太原理工");
        int i = mapper.insertSchool2(map);
        if(i > 0){
            sqlSession.commit();
        }
        sqlSession.close();
```



Map传递参数，直接在sql中取出key即可！

Pojo对象传递参数，直接在sql中取对象的属性！

多个参数用Map，**或者注解！**



### 11.模糊查询

​	11.1 接口定义

```java
//    模糊查询
    List<SchoolTable> selectSchoolLike(String schoolName);
```

​	11.2 mapper.xml

```xml
<select id="selectSchoolLike" resultType="com.zhang.pojo.SchoolTable" parameterType="String">
    select * from xyll.school_table where school_name like #{value}
</select>
```

​	11.3 使用

```java
sqlSession = MybatisSqlSessionFactory.getSqlSession();
SchoolTableMapper mapper = sqlSession.getMapper(SchoolTableMapper.class);
String name = "警察";
List<SchoolTable> schoolTableList = mapper.selectSchoolLike("%" + name + "%");
for (SchoolTable schoolTable : schoolTableList) {
    System.out.println(schoolTable);
}

sqlSession.close();
```





## mybatis配置

### mybatis-config.xml

### property（属性）

db.properties

~~~properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/xyll?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai
username=root
password=123456
~~~

mybaits-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

  <properties resource="db.properties">

  </properties>
  <!--数据表中字段以下划线分割就要开启驼峰，不然就获取到为空-->
  <settings>
    <setting name="mapUnderscoreToCamelCase" value="true"/>
  </settings>

  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
  </environments>



  <!--每一个Mapper.xml都需要在mybatis的核心配置文件中注册-->
  <mappers>
    <mapper resource="mapper/SchoolTableMapper.xml"/>
  </mappers>
</configuration>
```

- 可以直接引入外部配置文件
- 可以在其中增加一些属性配置
- 如果两个文件有同一个字段，优先使用外部配置文件中的属性！
- xml中的属性有一定的顺序，顺序不对会报错



### typealiases（别名）

​	可以帮助我们设置返回类型重复写包名

​	可以给一个类起别名或者一个包（mybatis会自动扫描包中类，别名为类名首字母小写）

```xml
    <typeAliases>
        <typeAlias type="com.zhang.pojo.SchoolTable" alias="SchoolTable"/>
      <package name="com.zhang.mapper"/>
    </typeAliases>
```

​	也可以用注解给类起别名

```java
import org.apache.ibatis.type.Alias;
@Alias("别名")
```

### 返回类型

​	resultType="_int" 如果要用基本数据类型前面加个  _

​	resultType="map" Map

### settings（设置）

常用的设置

```xml
<settings>
  
  <!--驼峰命名-->
  <setting name="mapUnderscoreToCamelCase" value="true"/>
  <!--日志实现-->
  <!--开启缓存-->
  <!--开启懒加载-->
</settings>
```



### mapper（映射器）

每一个mapper.xml文件都要在核心配置文件的mappers中注册

方式一：使用resource绑定

```xml
<!--每一个Mapper.xml都需要在mybatis的核心配置文件中注册-->
<mappers>
  <mapper resource="mapper/SchoolTableMapper.xml"/>
  <!--可以用*号做通配-->
  <mapper resource="mapper/*Mapper.xml"/>
</mappers>
```

方式二：使用class绑定

~~~xml
<!--每一个Mapper.xml都需要在mybatis的核心配置文件中注册-->
<mappers>
  <mapper class="mapper.SchoolTableMapper.xml"/>
</mappers>
~~~

注意点：

- 接口和他的Mapper配置文件必须同名！
- 接口和他的Mapper配置文件必须在同一个包下！



方式三：使用扫描包绑定

```xml
<!--每一个Mapper.xml都需要在mybatis的核心配置文件中注册-->
<mappers>
  <package name="mapper"/>
</mappers>
```

注意点：

- 接口和他的Mapper配置文件必须同名！

- 接口和他的Mapper配置文件必须在同一个包下！


## ResultMap

### 解决实体类中属性名和数据库字段名不一致的问题

问题：

例如，数据库中有字段id，name，pwd

​	    实体类为id，name，password

​	查出来的字段值为空

因为mybatis有类型处理器，他会自动把实体类中属性名放到查询语句的查询字段处id,name,pwd

```sql
select * from user where id = #{id}
```

mybatis类型处理器会自动把实体类中属性放到*号处

```sql
select id，name，password from user where id = #{id}
```

和数据库中字段对应不上就会为空



### 使用ResultMap解决

```xml
<!--结果集映射-->
<!--type为你映射的哪个实体类-->
<resultMap id="SchoolTableMap" type="SchoolTable">
  <!--column就是数据库中的字段    property是实体类中的属性名-->
  <result column="id" property="id"/>
  <result column="name" property="name"/>
  <result column="pwd" property="password"/>
</resultMap>

<!--这里的resultMap要和上面的id相同-->
<select id="getSchoolList" resultMap="SchoolTableMap">
  select * from xyll.school_table
</select>
```

### 使用结果集映射解决一对多，多对一问题

**如果想对返回结果进行处理，就要写对应的返回模型，就是对应的实体类**

### 环境搭建

​	设计一个一对多，多对一的数据库

### 按照查询嵌套处理

#### ofType和javaType

​	javaType:实体类中属性的类型；

​	ofType:实体类中属性如果是泛型的话就要加ofType对泛型类型中的约束类型进行说明！

#### 多对一按照查询嵌套处理

1.接口

~~~java
//    查询建筑列表
List<JianzhuTable> getJianzhuList();
~~~

2.mapper.xml

~~~xml
<mapper namespace="com.zhang.mapper.JianzhuMapper">
  <!--
        复杂查询查询建筑，多表联查
        思路：根据建筑表中的用户id查询出所对应的用户
    -->
  <!--查询建筑-->
  <select id="getJianzhuList" resultMap="JianzhuUserList">
    select * from jianzhu_table
  </select>

  <!--用resultMap把这两个查询连接起来-->
  <resultMap id="JianzhuUserList" type="JianzhuTable">
    <result property="jianzhuId" column="jianzhu_id"/>
    <result property="jianzhuName" column="jianzhu_name"/>
    <result property="jianzhuText" column="jianzhu_text"/>
    <result property="uploadDate" column="upload_date"/>
    <result property="jianzhuImage" column="jianzhu_image"/>
    <!--复杂的属性需要单独处理（例如两表关联）
            如果是对象就要用association
            如果是集合就要用collection
        -->
    <!--
            javaType是给这个实体类属性赋一个类型
            再给这个属性嵌套一个查询
        -->
    <association property="user" column="user_id" javaType="UserTable" select="getUserList"/>
  </resultMap>

  <!--查询用户-->
  <select id="getUserList" resultType="UserTable">
    select user_id,user_name from xyll.user_table where user_id = #{userId}
  </select>

</mapper>
~~~

3.测试使用

~~~java
@Test
public void getJianzhuList(){
  sqlSession = MybatisSqlSessionFactory.getSqlSession();
  JianzhuMapper mapper = sqlSession.getMapper(JianzhuMapper.class);
  List<JianzhuTable> jianzhuList = mapper.getJianzhuList();
  for (JianzhuTable jianzhuTable : jianzhuList) {
    System.out.println(jianzhuTable);
  }
  sqlSession.close();
}
~~~

#### 一对多按照查询嵌套处理

1.接口

~~~java
//    获取指定学校的所有建筑信息（根据学校id查出该学校下的所有建筑信息）
SchoolTable getSchoolJianzhuList(@Param("schoolId") int schoolId);
~~~

2.mapper.xml

~~~xml
<!--
        一对多按照查询嵌套处理
        思路：
            先是根据学校id查出学校，再根据学校id查出所有建筑信息
    -->
<!--根据学校id查出学校-->
<select id="getSchoolJianzhuList" resultMap="SchoolJianzhuList">
  select * from xyll.school_table where school_id = #{schoolId};
</select>
<!--用resultMap联系起来-->
<resultMap id="SchoolJianzhuList" type="SchoolTable">
  <result property="schoolId" column="school_id"/>
  <result property="schoolName" column="school_name"/>
  <!--对集合的处理用collection-->
  <collection property="jianzhus" column="school_id" javaType="ArrayList" select="getJianzhuSchoolList" ofType="JianzhuTable">

  </collection>
</resultMap>
<!--根据学校id查出所有建筑信息-->
<select id="getJianzhuSchoolList" resultType="JianzhuTable">
  select * from xyll.jianzhu_table where school_id = #{schoolId};
</select>
~~~

3.测试

~~~java
@Test
public void getSchoolJianzhuList(){
  sqlSession = MybatisSqlSessionFactory.getSqlSession();
  SchoolMapper mapper = sqlSession.getMapper(SchoolMapper.class);
  SchoolTable schoolJianzhu = mapper.getSchoolJianzhuList(1);
  System.out.println(schoolJianzhu);
  sqlSession.close();
}
~~~



### 按照结果嵌套处理

#### 多对一按照结果嵌套处理

1.接口

```java
//    获取建筑列表，并关联用户表
List<JianzhuTable> getJianzhuList2();
```

2.mapper.xml

```xml
<!--
  按照结果嵌套处理
    -->
<!--
        查询建筑和建筑对应的用户
    -->
<select id="getJianzhuList2" resultMap="jianzhuUserTable2">
  SELECT * from jianzhu_table j,user_table u where j.user_id = u.user_id;
</select>
<resultMap id="jianzhuUserTable2" type="JianzhuTable">
  <result property="jianzhuId" column="jianzhu_id"/>
  <result property="jianzhuName" column="jianzhu_name"/>
  <result property="jianzhuText" column="jianzhu_text"/>
  <result property="jianzhuImage" column="jianzhu_image"/>
  <result property="uploadDate" column="upload_date"/>
  <association property="user" javaType="UserTable">
    <result property="userId" column="user_id"/>
    <result property="userName" column="user_name"/>
  </association>
</resultMap>
```

3.测试

```java
@Test
public void getJianzhuList2(){
  sqlSession = MybatisSqlSessionFactory.getSqlSession();
  JianzhuMapper mapper = sqlSession.getMapper(JianzhuMapper.class);
  List<JianzhuTable> jianzhuList = mapper.getJianzhuList2();
  for (JianzhuTable jianzhuTable : jianzhuList) {
    System.out.println(jianzhuTable);
  }
  sqlSession.close();
}
```



#### 一对多按照结果嵌套处理

​	一对多，一个学校对应很多建筑

1.修改学校实体类

原来的

~~~java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolTable implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer schoolId;

  private String schoolName;
}
~~~

修改后

~~~java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolTable implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer schoolId;

  private String schoolName;
  //    给返回模型中增加对应的建筑列表返回（一个学校对应很多建筑）
  private List<JianzhuTable> jianzhus;
}

~~~

2.接口

~~~java
//    获取指定学校的所有建筑信息（根据学校id查出该学校下的所有建筑信息）
SchoolTable getSchoolJianzhuList2(@Param("schoolId") int schoolId);
~~~

3.mapper.xml

~~~xml
<!--根据结果嵌套查询-->
<select id="getSchoolJianzhuList2" resultMap="SchoolJianzhuList2">
  select * from school_table s,jianzhu_table j where s.school_id = j.school_id and j.school_id = #{schoolId}
</select>
<resultMap id="SchoolJianzhuList2" type="SchoolTable">
  <result property="schoolId" column="school_id"/>
  <result property="schoolName" column="school_name"/>
  <!--返回结果是个集合用collection-->
  <collection property="jianzhus" ofType="JianzhuTable">
    <result property="jianzhuId" column="jianzhu_id"/>
    <result property="jianzhuName" column="jianzhu_name"/>
    <result property="jianzhuText" column="jianzhu_text"/>
    <result property="jianzhuImage" column="jianzhu_image"/>
    <result property="uploadDate" column="upload_date"/>
  </collection>
</resultMap>
~~~

4.测试

~~~java
@Test
public void getSchoolJianzhuList2(){
  sqlSession = MybatisSqlSessionFactory.getSqlSession();
  SchoolMapper mapper = sqlSession.getMapper(SchoolMapper.class);
  SchoolTable schoolJianzhu = mapper.getSchoolJianzhuList2(2);
  System.out.println(schoolJianzhu);
  sqlSession.close();
}
~~~



## 日志

### 日志工厂

如果一个数据库操作出现了一场，我们需要排错。日志就是最好的助手！也可以帮助我们记录用户的每一个sql操作

曾经：debug

现在：日志工厂

### log4j使用（2021年出现重大漏洞）

​	1.先导包/配置依赖

​	2.增加log4j.properties配置文件

​	3.在项目中配置log4j为项目的日志实现

​	4.测试运行

**简单使用**

​	1.在要使用的类中导入包

​	2.编写日志配置文件

​	3.在项目中使用



## 分页

为什么要分页？

​	减少数据的处理量。

```sql
#从第0个开始查，每页显示两个
select * from user limit 0,2;
#如果只给定一个参数，默认是从0开始查到n
select * from user limit 3;
```

### 使用mybatis实现分页

​	1.接口

```java
//    分页查询
    List<SchoolTable> selectSchoolLimit(Map<String,Object> map);
```

​	2.mapper.xml

```xml
<!--分页查询-->
<select id="selectSchoolLimit" parameterType="map" resultType="SchoolTable">
  select * from xyll.school_table limit #{startIndex},#{pageMaxSize}
</select>
```

​	3.使用

```java
sqlSession = MybatisSqlSessionFactory.getSqlSession();
SchoolTableMapper mapper = sqlSession.getMapper(SchoolTableMapper.class);
HashMap<String,Object> map =  new HashMap<String, Object>();
map.put("startIndex",2);
map.put("pageMaxSize",2);
List<SchoolTable> schoolTables = mapper.selectSchoolLimit(map);
for (SchoolTable schoolTable : schoolTables) {
  System.out.println(schoolTable);
}

        sqlSession.close();
```



## 使用注解开发

### 什么是面向接口编程

​	根本原因：**解耦**

### 注解开发

直接在接口中用注解写sql语句，不用再写mapper.xml文件；

简单的语句可以用注解方式，复杂的语句注解就很难做到了；

​	1.注解在接口上实现

```java
//    注解开发
@Select("select * from xyll.school_table")
List<SchoolTable> getSchoolAllList();
```

​	2.在核心配置文件绑定接口

```xml
<mappers>
  <mapper class="com.zhang.mapper.SchoolTableMapper"/>
</mappers>
```

​	3.使用

```java
@Test
public void getSchoolAllList(){
  sqlSession = MybatisSqlSessionFactory.getSqlSession();
  SchoolTableMapper mapper = sqlSession.getMapper(SchoolTableMapper.class);
  List<SchoolTable> schoolAllList = mapper.getSchoolAllList();
  for (SchoolTable schoolTable : schoolAllList) {
    System.out.println(schoolTable);
  }
  sqlSession.close();
    }
```



### 注解开发方式传参

使用@Param("id")方式传参

接口

```java
//    根据id查询值注解方式
@Select("select * from xyll.school_table where school_id = #{schoolId}")
SchoolTable getSchoolByIdZhujie(@Param("schoolId") int schoolId);
```

测试

```java
@Test
public void getSchoolByIdZhujie(){
  sqlSession = MybatisSqlSessionFactory.getSqlSession();
  SchoolTableMapper mapper = sqlSession.getMapper(SchoolTableMapper.class);
  SchoolTable schoolTable = mapper.getSchoolByIdZhujie(2);
  System.out.println(schoolTable);

  sqlSession.close();
}
```

可以在工具类中openSession中设置自动提交事务！（一般不要设置自动提交，如果代码有问题也会被提交上去！）

```java
//            获取SqlSession对象
public static SqlSession getSqlSession(){
  return sqlSessionFactory.openSession(true);
}
```

### 插入

引用对象不需要加@Param("");

接口

```java
//    注解插入
@Insert("insert into xyll.school_table (school_id,school_name) values (#{schoolId},#{schoolName})")
int insertSchoolZhujie(SchoolTable schoolTable);
```

测试

```java
@Test
public void insertSchoolZhujie(){
  sqlSession = MybatisSqlSessionFactory.getSqlSession();
  SchoolTableMapper mapper = sqlSession.getMapper(SchoolTableMapper.class);
  int res = mapper.insertSchoolZhujie(new SchoolTable(5, "山西财经"));

  sqlSession.close();
}
```

### 修改

接口

```java
//    注解修改
@Update("update xyll.school_table set school_name = #{schoolName} where school_id = #{schoolId}")
int updateSchoolZhujie(SchoolTable schoolTable);
```

测试

~~~java
@Test
public void updateSchoolZhujie(){
  sqlSession = MybatisSqlSessionFactory.getSqlSession();
  SchoolTableMapper mapper = sqlSession.getMapper(SchoolTableMapper.class);
  int res = mapper.updateSchoolZhujie(new SchoolTable(5, "aaa"));
  sqlSession.close();
}
~~~

### 删除

接口

~~~java
//    注解删除
@Delete("delete from xyll.school_table where school_id = #{schoolId}")
int deleteSchoolZhujie(@Param("schoolId") int id);
~~~

测试

~~~java
@Test
public void deleteSchoolZhujie(){
  sqlSession = MybatisSqlSessionFactory.getSqlSession();
  SchoolTableMapper mapper = sqlSession.getMapper(SchoolTableMapper.class);
  int res = mapper.deleteSchoolZhujie(5);
  sqlSession.close();
}
~~~

**使用注解来映射简单语句会使代码显得更加简洁，但对于稍微复杂一点的语句，Java 注解不仅力不从心，还会让你本就复杂的 SQL 语句更加混乱不堪。 因此，如果你需要做一些很复杂的操作，最好用 XML 来映射语句。**

### @Param()注解

- 基本类型或者String类型的参数需要加上！
- 引用类型不需要加！
- 我们在sql中引用的就是我们@Param()中设定的属性名！

### Mybatis中使用${}和使用#{}

1.#{}将传入的数据都当成一个字符串，会对自动传入的数据加一个双引号。如：order by #{user_id}，如果传入的值是111,那么解析成sql时的值为order by “111”, 如果传入的值是id，则解析成的sql为order by “id”.
2.将传入的数据直接显示生成在sql中。如：order by ${user_id}，如果传入的值是111,那么解析成sql时的值为order by user_id, 如果传入的值是id，则解析成的sql为order by id.
3.#{}方式能够很大程度防止sql注入，而${}方式无法防止Sql注入。
4.${}方式一般用于传入数据库对象，例如传入表名，order by后的列名。
5.一般能用#的就别用$。
MyBatis排序时使用order by 动态参数时需要注意，用${}而不是#{}。



## Lombok插件

什么是Lombok？

Lombok是一个Java库，能自动插入编辑器并构建工具，简化Java开发。通过添加注解的方式，不需要为类编写getter或eques方法，同时可以自动化日志变量。

简而言之：Lombok能以简单的注解形式来简化java代码，提高开发人员的开发效率。

### 使用

1.在idea上安装插件

![1644892089736](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1644892089736.png)



2.导入项目依赖

~~~xml
<!--lombok依赖-->
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>1.18.20</version>
</dependency>
~~~

3.测试使用（在实体类上加注解即可）

~~~java
//get/set方法
@Getter and @Setter
@FieldNameConstants
  //toString方法
@ToString
@EqualsAndHashCode
  //构造器
@AllArgsConstructor, @RequiredArgsConstructor and @NoArgsConstructor
@Log, @Log4j, @Log4j2, @Slf4j, @XSlf4j, @CommonsLog, @JBossLog, @Flogger, @CustomLog
  //数据
@Data：包含无参构造，get,set,toString,hashcode,equals
@Builder
@SuperBuilder
@Singular
@Delegate
@Value
@Accessors
@Wither
@With
@SneakyThrows
@val
@var
@UtilityClass
~~~

```java
@Data：包含无参构造，get,set,toString,hashcode,equals
@AllArgsConstructor：有参
@NoArgsConstructor：无参
```



## mybatis动态sql

**什么是动态sql：动态sql就是指根据不同的条件生成不同的sql语句**



### 环境搭建



### 动态sql语句

if

where：帮助我们再查询时后面的条件拼接（在sql中where 第一个条件加上and 会报错，where标签会帮助我们自动舍去，会自动前置where）

set：帮助我们再修改update时set条件拼接（在sql语句中set最后一个条件加上,是会报错的，set标签会自动舍去无关逗号，会自动前置set）

trim：可以自定义前缀，后缀

choose，when，otherwise（相当于java中的switch，case，default）

foreach：

~~~xml
<select id="selectPostIn" resultType="domain.blog.Post">
  SELECT *
  FROM POST P
  WHERE ID in
  <foreach item="item" index="index" collection="list"
      open="(" separator="," close=")">
        #{item}
  </foreach>
</select>	
~~~

### SQL片段

**sql片段能帮我们在mapper.xml中抽取一些相同的代码，要用的时候include导入就好了**



### 小结

**动态SQL就是在拼接SQL语句，我们只要保证SQL的正确性，按照SQL语句的格式去排列就可以了**





## 缓存（减少和数据库交互的次数）

### 简介

~~~java
例如：查询：  连接数据数据库，耗资源
			一次查询的结果，给他暂存在一个可以直接取到的地方，下次再用这个查询就不用再连接数据库了。（缓存）
~~~

什么样的数据能使用缓存？

​	经常查询并且不经常改变的数据。（可以使用缓存）

### mybatis缓存

#### 一级缓存

（sqlSession）级别的默认开启的

1.开启日志（才能清晰的看到sql执行了几次）

2.写接口

3.mapper.xml

4.测试



什么情况一级缓存会失效：

​	1.缓存个数超过缓存池大小

​	2.增删改会刷新缓存

​	3.缓存会使用最近最少使用的算法（LRU）来清除不需要的缓存

​	4.缓存会不定时进行刷新（没有刷新时间）

​	5.查询不同的东西

​	6.查询不同的Mapper.xml

​	7.手动清理缓存

#### 小结：

​	一级缓存默认开启，只在一次SqlSession中有效，也就是拿到连接到关闭连接这个区间。

​		

#### 二级缓存

也是默认开启的，但是我们要在mapper.xml配置一下才能生效

sqlSession会话关闭后，一级缓存就没有了，开启二级缓存就能在会话关闭后将数据保存在二级缓存中；

1.先在mybatis核心配置文件settings中开启缓存

~~~xml
<!--开启缓存-->
<setting name="cacheEnabled" value="true"/>
~~~

2.启用二级缓存要再mapper.xml映射文件中加一个<cache/>标签

~~~xml
<!--在当前mapper.xml中使用二级缓存-->
<cache/>
~~~

这个cache可以定义一些属性；

~~~xml
<cache
  eviction="FIFO"
  flushInterval="60000"
  size="512"
  readOnly="true"/>
~~~

这个更高级的配置创建了一个 FIFO 缓存，每隔 60 秒刷新，最多可以存储结果对象或列表的 512 个引用，而且返回的对象被认为是只读的，因此对它们进行修改可能会在不同线程中的调用者产生冲突。

可以设置哪个语句不使用缓存：（useCache="false"）

~~~xml
<select id="getSchoolJianzhuList" resultMap="SchoolJianzhuList" useCache="false">
  select * from xyll.school_table where school_id = #{schoolId};
</select>
~~~



可用的清除策略有：

- `LRU` – 最近最少使用：移除最长时间不被使用的对象。
- `FIFO` – 先进先出：按对象进入缓存的顺序来移除它们。
- `SOFT` – 软引用：基于垃圾回收器状态和软引用规则移除对象。
- `WEAK` – 弱引用：更积极地基于垃圾收集器状态和弱引用规则移除对象。

默认的清除策略是 LRU。

flushInterval（刷新间隔）属性可以被设置为任意的正整数，设置的值应该是一个以毫秒为单位的合理时间量。 默认情况是不设置，也就是没有刷新间隔，缓存仅仅会在调用语句时刷新。

size（引用数目）属性可以被设置为任意正整数，要注意欲缓存对象的大小和运行环境中可用的内存资源。默认值是 1024。

readOnly（只读）属性可以被设置为 true 或 false。只读的缓存会给所有调用者返回缓存对象的相同实例。 因此这些对象不能被修改。这就提供了可观的性能提升。而可读写的缓存会（通过序列化）返回缓存对象的拷贝。 速度上会慢一些，但是更安全，因此默认值是 false。



#### 小结：

​	1.只要开启二级缓存，在同一个mapper下有效

​	2.所有的数据都会先放在一级缓存中

​	3.只有当会话提交，或者关闭的时候，才会提交到二级缓存中！



### 缓存顺序

​	第一次查询先看二级缓存，没有再去一级缓存，没有再去查数据库

​	数据库返回的数据先存到一级缓存中，会话关闭后放入二级缓存



### 自定义缓存

使用redis做缓存

1.导包

2.引入使用

~~~xml
<cache type="缓存包"/>
这个缓存可以自定义配置一些东西
~~~





















