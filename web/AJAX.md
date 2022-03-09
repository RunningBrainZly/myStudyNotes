## AJAX

AJAX 能够：

- 不刷新页面更新网页
- 在页面加载后从服务器请求数据
- 在页面加载后从服务器接收数据
- 在后台向服务器发送数据



AJAX执行过程：

![ajax](D:\studys\web\ajax.gif)

1. 网页中发生一个事件（页面加载、按钮点击）
2. 由 JavaScript 创建 XMLHttpRequest 对象
3. XMLHttpRequest 对象向 web 服务器发送请求
4. 服务器处理该请求
5. 服务器将响应发送回网页
6. 由 JavaScript 读取响应
7. 由 JavaScript 执行正确的动作（比如更新页面）

##### 核心是XMLHttpRequest 对象

创建 XMLHttpRequest 的语法是：

```
var xhttp = new XMLHttpRequest();
```

出于安全原因，现代浏览器不允许跨域访问。

这意味着尝试加载的网页和 XML 文件都必须位于相同服务器上。

实例：

<script>
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "/example/js/ajax_info.txt", true);
  xhttp.send();
}
</script>

### XMLHttpRequest 对象方法

| 方法                                          | 描述                                                         |
| --------------------------------------------- | ------------------------------------------------------------ |
| new XMLHttpRequest()                          | 创建新的 XMLHttpRequest 对象                                 |
| abort()                                       | 取消当前请求                                                 |
| getAllResponseHeaders()                       | 返回头部信息                                                 |
| getResponseHeader()                           | 返回特定的头部信息                                           |
| open(*method*, *url*, *async*, *user*, *psw*) | 规定请求    method：请求类型 GET 或 POST                         url：文件位置async：true（异步）或 false（同步）                     user：可选的用户名称psw：可选的密码 |
| send()                                        | 将请求发送到服务器，用于 GET 请求（使用get请求时可以直接再open中用问好传值） |
| send(*string*)                                | 将请求发送到服务器，用于 POST 请求(其中的string是你要向后台传的数据) |
| setRequestHeader()                            | 向要发送的报头添加标签/值对                                  |

### XMLHttpRequest 对象属性

| 属性               | 描述                                                         |
| ------------------ | ------------------------------------------------------------ |
| onreadystatechange | 定义当 readyState 属性发生变化时被调用的函数                 |
| readyState         | 保存 XMLHttpRequest 的状态。0：请求未初始化      1：服务器连接已建立           2：请求已收到            3：正在处理请求             4：请求已完成且响应已就绪 |
| responseText       | 以字符串返回响应数据                                         |
| responseXML        | 以 XML 数据返回响应数据                                      |
| status             | 返回请求的状态号200: "OK"     403: "Forbidden"     404: "Not Found" |
| statusText         | 返回状态文本（比如 "OK" 或 "Not Found"）                     |

通过异步发送，JavaScript 不必等待服务器响应，而是可以：(同步 XMLHttpRequest 正在从 Web 标准中移除，但是这个过程可能需要很多年。)

- 在等待服务器响应时执行其他脚本
- 当响应就绪时处理响应



**用问号传参**

简单的用法：

通过open(*method*, *url*, *async*)函数像告诉服务器要请求的url地址

然后通过responseText 以字符串返回响应数据



实例：

<!DOCTYPE html>
<html>
<body>

<div id='showMUSIC'></div>
<input type="button" onclick="previous()" value="<<">
<input type="button" onclick="next()" value=">>">

<script>
var i = 0, len;
displayMUSIC(0);

function displayMUSIC(i) {
  var xmlhttp = new XMLHttpRequest();
  xmlhttp.onreadystatechange = function() {
​    if (this.readyState == 4 && this.status == 200) {
​      myFunction(this, i);
​    }
  };
  xmlhttp.open("GET", "/demo/music_list.xml", true);
  xmlhttp.send();
}

function myFunction(xml, i) {
  var xmlDoc = xml.responseXML; 
  x = xmlDoc.getElementsByTagName("TRACK");
  len = x.length;
  document.getElementById("showMUSIC").innerHTML =
  "<ul>" + 
  "<li>曲目：" +
  x[i].getElementsByTagName("TITLE")[0].childNodes[0].nodeValue + "</li>" +
  "<li>艺术家：" +
  x[i].getElementsByTagName("ARTIST")[0].childNodes[0].nodeValue + "</li>" +
  "<li>专辑：" +
  x[i].getElementsByTagName("ALBUM")[0].childNodes[0].nodeValue + "</li>" +
  "<li>国家：" +
  x[i].getElementsByTagName("COUNTRY")[0].childNodes[0].nodeValue + "</li>" +
  "<li>公司：" +
  x[i].getElementsByTagName("COMPANY")[0].childNodes[0].nodeValue + "</li>" +
  "<li>年份：" + 
  x[i].getElementsByTagName("YEAR")[0].childNodes[0].nodeValue + "</li>" +
  "</ul>";
}


function next() {
  if (i < len-1) {
​    i++;
​    displayMUSIC(i);
  }
}

function previous() {
  if (i > 0) {
​    i--;
​    displayMUSIC(i);
  }
}
</script>

</body>
</html>

