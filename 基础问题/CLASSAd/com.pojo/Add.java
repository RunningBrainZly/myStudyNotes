package com.pojo;
import java.sql.*;
import com.pojo.Emp;
import com.jdbc.DataBaseConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Add {
	  Connection connection ;
	//���ﴫһ����������Emp emp�����൱��String str ���
			//���������������ͣ��࣬���飬�ӿ�
			public void insert(Emp emp){
					//1.дsql���
					String str = "INSERT emp VALUES (?,?,?)";
	
					PreparedStatement ps = null;
					//2.��ȡ�������ݿ���
					try {
						//�Ѳ������ݿⷵ�صĽ�����浽ps��

						ps = connection.prepareStatement(str);
					//3.���ò���
					ps.setString(1, emp.getClassname());
					ps.setString(2, emp.getTeacher());
					ps.setString(3, emp.getLocation());
					
					
					//4.ִ��sql���
					int len = ps.executeUpdate();
					System.out.println("�޸ĳɹ�����Ӱ����"+ len +"�У�");
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
