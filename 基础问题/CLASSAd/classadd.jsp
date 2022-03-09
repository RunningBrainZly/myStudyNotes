<%@ page language= "java" contentType= "text/html; charset=GB18030"
     pageEncoding= "GB18030" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>课程添加页面</title>
</head>
<body>
    <form action="back.jsp" method="get">
        <table align="center" border="1" width="500">
            <tr>
                <td>课程名称 : </td>
                <td>
                    <input type="text" name="classname" />
                </td>
            </tr>
                <tr>
                <td>任课教师:</td>
                <td>
                    <input type="text" name="teachername" />
                </td>
            </tr>
            <tr>
                <td>上课地点:</td>
                <td>
                    <input type="text" name="place" />
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="提交" />
                    <input type="reset" value="重置" />
                </td>
            </tr>
           
        </table>
    </form>
</body>
</html>