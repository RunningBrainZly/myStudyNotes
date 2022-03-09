<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.pojo.Add"%>
<%@page import="com.pojo.Emp"%>
<%@page import="com.jdbc.DataBaseConnection"%>
<html>
<%

//接收客户端传递过来的参数

String teachername = request.getParameter("teachername");
String classname = request.getParameter("classname");
String location = request.getParameter("place");
//try{
if(!teachername.trim().equals("王建民")&&!teachername.trim().equals("刘立嘉")&&!teachername.trim().equals("刘丹")&&!teachername.trim().equals("王辉")&&!teachername.trim().equals("杨子光"))
{
   //throw new ClassException("不能输入规定之外的老师名称");
}
else if(!location.trim().startsWith("基教")&&!location.trim().startsWith("一教")&&!location.trim().startsWith("二教")&&!location.trim().startsWith("三教"))
{
  // throw new ClassException("不能输入规定之外的地点名称！");
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