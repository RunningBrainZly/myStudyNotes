<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.pojo.Add"%>
<%@page import="com.pojo.Emp"%>
<%@page import="com.jdbc.DataBaseConnection"%>
<html>
<%

//���տͻ��˴��ݹ����Ĳ���

String teachername = request.getParameter("teachername");
String classname = request.getParameter("classname");
String location = request.getParameter("place");
//try{
if(!teachername.trim().equals("������")&&!teachername.trim().equals("������")&&!teachername.trim().equals("����")&&!teachername.trim().equals("����")&&!teachername.trim().equals("���ӹ�"))
{
   //throw new ClassException("��������涨֮�����ʦ����");
}
else if(!location.trim().startsWith("����")&&!location.trim().startsWith("һ��")&&!location.trim().startsWith("����")&&!location.trim().startsWith("����"))
{
  // throw new ClassException("��������涨֮��ĵص����ƣ�");
}
else
{
	 
	try{
		dbs = new DataBaseConnection();
		Emp emp = new Emp(classname,teachername,location);
		 emp.setTeacher(teachername);
		 emp.setClassname(classname);
		 emp.setLocation(location);
		 DataBaseConnection dbs = null;
		 dbs.insert(emp);

	}finally{
		dbs.closeConnection();
	}
}
%>





 
</html>>