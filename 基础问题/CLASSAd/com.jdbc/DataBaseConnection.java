package com.jdbc;
import java.sql.*;
import java.util.Collection;
import com.pojo.Emp;
public class DataBaseConnection{


	//������Ϣ	
	private static String userName = "root";//���������ʼ������mysql��������˺�
		private static String password = "123456";//���������ʼmysql���õ����룬
		private static String url = "jdbc:mysql://localhost:3306/classdatabase"
				+" ";
		private Connection connection;
	//���ݿ�������Ϣ��
	//��һ����java�������ݿ�Э�飬�м����Ҫ���ӵ�ip��ַ�Ͷ˿ںţ�localhost�Ǳ���ip�����������Ҫ���ӵ����ݿ�����֣���Ҫ�������ݿ�����ֽ�testdatabase
		public DataBaseConnection() {
			// TODO Auto-generated constructor stub
			try {
				this.connection =  DriverManager.getConnection(url, userName, password);//��������������Դ�������Ӧ�þ����ӳɹ��ˣ����ɹ��Ļ�Ӧ�þ�������˺����벻��ȷ
				System.out.println("���ݿ����ӳɹ���");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("����ʧ�ܣ�");
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