package com.jdbc;
import java.sql.*;
import java.util.Collection;
import com.pojo.Emp;
public class DataBaseConnection{


	//连接信息	
	private static String userName = "root";//这里是你最开始刚下载mysql是输入的账号
		private static String password = "123456";//这里是你最开始mysql设置的密码，
		private static String url = "jdbc:mysql://localhost:3306/classdatabase"
				+" ";
		private Connection connection;
	//数据库连接信息，
	//第一个是java连接数据库协议，中间的是要连接的ip地址和端口号，localhost是本地ip，后面的是你要连接的数据库的名字，我要连接数据库的名字叫testdatabase
		public DataBaseConnection() {
			// TODO Auto-generated constructor stub
			try {
				this.connection =  DriverManager.getConnection(url, userName, password);//把上面的三个属性传过来，应该就连接成功了，不成功的话应该就是你的账号密码不正确
				System.out.println("数据库连接成功！");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接失败！");
			}
			
		}
		public void closeConnection(){
				
				if(connection != null){
					try {
						 connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		
			

}