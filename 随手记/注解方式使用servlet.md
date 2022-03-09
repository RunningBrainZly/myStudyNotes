导入Httpservlet所有相关的包

再导入import javax.servlet.annotation.WebServlet;

![2021-05-16_211021](D:\截图\2021-05-16_211021.png)

然后添加注解@WebServlet("/自己定义的名字")，要与你html/jsp页面中form中action属性中定义的名字相同

例如![2021-05-16_211550](D:\截图\2021-05-16_211550.png)![2021-05-16_211550](D:\截图\2021-05-16_211513.png)

名字要相同



图片中我使用了el表达式所以可以用${pageContext.request.contextPath}/加 你定义的名字  的方式来访问

如果要使用el表达式必须是jsp页面，

```
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
```

jsp页面中html标签上方加这两行代码

![2021-05-16_212129](D:\截图\2021-05-16_212129.png)