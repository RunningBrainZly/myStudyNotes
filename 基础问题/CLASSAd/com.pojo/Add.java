package com.pojo;
import java.sql.*;
import com.pojo.Emp;
import com.jdbc.DataBaseConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Add {
	  Connection connection ;
	//这里传一个类对象参数Emp emp，就相当于String str 差不多
			//都是引用数据类型，类，数组，接口
			public void insert(Emp emp){
					//1.写sql语句
					String str = "INSERT emp VALUES (?,?,?)";
	
					PreparedStatement ps = null;
					//2.获取操作数据库句柄
					try {
						//把操作数据库返回的结果保存到ps中

						ps = connection.prepareStatement(str);
					//3.设置参数
					ps.setString(1, emp.getClassname());
					ps.setString(2, emp.getTeacher());
					ps.setString(3, emp.getLocation());
					
					
					//4.执行sql语句
					int len = ps.executeUpdate();
					System.out.println("修改成功，共影响了"+ len +"行！");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(ps != null){
						try {
							ps.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} 
}
