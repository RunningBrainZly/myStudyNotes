package com.pojo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.DataBaseConnection;


public class Test {



	public static void main(String[] args) {


		DataBaseConnection dbs = null;

	try{

		//创建连接数据库类对象

		dbs = new DataBaseConnection();

		//创建你的表类对象，表类对象就是你存放在pojo中的类，存放表中字段的类，例如我的类为Emp

		//把类中的属性赋值
	//select  *  from  emp;

		Emp emp = new Emp("统一建模","王建民","基教612"); 
		        

		//调用你写的insert类，里面把类对象传进去

		 dbs.insert(emp);

	}finally{

	//奥，对了，为了防止资源浪费，不管你程序执没执行成功，你都必须关闭数据库

		//需要在你的连接类中写一个关闭数据库的方法

		//上面的代码中我又添加上了，就不用你写了

		dbs.closeConnection();

	}
	}

}
