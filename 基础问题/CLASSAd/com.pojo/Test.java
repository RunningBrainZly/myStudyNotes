package com.pojo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.DataBaseConnection;


public class Test {



	public static void main(String[] args) {


		DataBaseConnection dbs = null;

	try{

		//�����������ݿ������

		dbs = new DataBaseConnection();

		//������ı�����󣬱���������������pojo�е��࣬��ű����ֶε��࣬�����ҵ���ΪEmp

		//�����е����Ը�ֵ
	//select  *  from  emp;

		Emp emp = new Emp("ͳһ��ģ","������","����612"); 
		        

		//������д��insert�࣬���������󴫽�ȥ

		 dbs.insert(emp);

	}finally{

	//�£����ˣ�Ϊ�˷�ֹ��Դ�˷ѣ����������ִûִ�гɹ����㶼����ر����ݿ�

		//��Ҫ�������������дһ���ر����ݿ�ķ���

		//����Ĵ���������������ˣ��Ͳ�����д��

		dbs.closeConnection();

	}
	}

}
