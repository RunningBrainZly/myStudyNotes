hr/水平线
br/空行
tr  td  th
frame控制围绕表格的边框
标签中加上class定义类名，id给标签定义唯一id(id对大小写敏感)
css中用. 类名的方式来更改样式，可以为相同的类设置同样的样式，用#加id名的方式更改这个id的样式（id是唯一的）
iframe内联框架（在页面内嵌套网页）



class(给标签定义类名 .class调用)

id(给标签定义唯一id，#id名调用)

外部样式

<head>
    <link rel="stylesheet" type="text/css" href="文件地址">
</head>

内部样式

<head>
    <style type="text/css">
        body{
            background-color:blue;
        }
    </style>
</head>

内联样式

<div style="color:red;margin-left:20px">
    aaaaa
</div>

alt替换图片属性（在图片加载不出来的时候显示）

<img src="地址" alt="photo">





##### 标签调用script方法，用onclick属性=“方法名（）”

<script>
document.getElementById("demo").innerHTML = "Hello JavaScript!";
</script>

```
document.getElementById("demo").style.fontSize = "25px";
document.getElementById("demo").style.color = "red";
document.getElementById("demo").style.backgroundColor = "yellow";
document.getElementById("image").src = "picture.gif";
```

```
<noscript>抱歉，您的浏览器不支持 JavaScript！</noscript>
```

### 

### 文件路径

| <img src="picture.jpg">         | picture.jpg 位于与当前网页相同的文件夹       |
| ------------------------------- | -------------------------------------------- |
| <img src="images/picture.jpg">  | picture.jpg 位于当前文件夹的 images 文件夹中 |
| <img src="/images/picture.jpg"> | picture.jpg 当前站点根目录的 images 文件夹中 |
| <img src="../picture.jpg">      | picture.jpg 位于当前文件夹的上一级文件夹中   |



## 绝对文件路径

绝对文件路径是指向一个因特网文件的完整 URL：

### 实例

```
<img src="https://www.w3school.com.cn/images/picture.jpg" alt="flower">
```



<meta>元素在<head>标签中使用，不会显示在页面中，提供给搜索引擎（浏览器）来以<meta>标签中的信息作为关键字来更快的搜索网页。



### HTML5 新加标签

| header  | 定义文档或节的页眉             |
| ------- | ------------------------------ |
| nav     | 定义导航链接的容器             |
| section | 定义文档中的节                 |
| article | 定义独立的自包含文章           |
| aside   | 定义内容之外的内容（比如侧栏） |
| footer  | 定义文档或节的页脚             |
| details | 定义额外的细节                 |
| summary | 定义 details 元素的标题        |



### 选择table中的元素

表格类名为 lamp

```
<style>
table.lamp {
    width:100%;
    border:1px solid #d4d4d4;
}
table.lamp th, td {
    padding:10px;
}
table.lamp td {
    width:40px;
}
</style>
```





## 什么是响应式 Web 设计？

- RWD 指的是响应式 Web 设计（Responsive Web Design）
- RWD 能够以可变尺寸传递网页
- RWD 对于平板和移动设备是必需的



*<kbd>* 元素表示键盘输入的字体样式

*<samp>* 元素表示计算机输出字体样式

<code> 元素表示编程代码字体样式，如果显示的代码换行显示要加<pre>标签

*<var>* 元素定义*数学变量*字体样式



## HTML5 中的语义元素

下面列出了以字母顺序排列的 HTML5 新语义元素。

这些链接指向完整的 HTML 参考手册。

| 标签         | 描述                                               |
| ------------ | -------------------------------------------------- |
| <article>    | 定义文章。                                         |
| <aside>      | 定义页面内容以外的内容。                           |
| <details>    | 定义用户能够查看或隐藏的额外细节。                 |
| <figcaption> | 定义 <figure> 元素的标题。                         |
| <figure>     | 规定自包含内容，比如图示、图表、照片、代码清单等。 |
| <footer>     | 定义文档或节的页脚。                               |
| <header>     | 规定文档或节的页眉。                               |
| <main>       | 规定文档的主内容。                                 |
| <mark>       | 定义重要的或强调的文本。                           |
| <nav>        | 定义导航链接。                                     |
| <section>    | 定义文档中的节。                                   |
| <summary>    | 定义 <details> 元素的可见标题。                    |
| <time>       | 定义日期/时间。                                    |



## HTML 中有用的字符实体

注释：实体名称对大小写敏感！

| 显示结果 | 描述              | 实体名称          | 实体编号 |
| -------- | ----------------- | ----------------- | -------- |
|          | 空格              | &nbsp;            | &#160;   |
| <        | 小于号            | &lt;              | &#60;    |
| >        | 大于号            | &gt;              | &#62;    |
| &        | 和号              | &amp;             | &#38;    |
| "        | 引号              | &quot;            | &#34;    |
| '        | 撇号              | &apos; (IE不支持) | &#39;    |
| ￠       | 分（cent）        | &cent;            | &#162;   |
| £        | 镑（pound）       | &pound;           | &#163;   |
| ¥        | 元（yen）         | &yen;             | &#165;   |
| €        | 欧元（euro）      | &euro;            | &#8364;  |
| §        | 小节              | &sect;            | &#167;   |
| ©        | 版权（copyright） | &copy;            | &#169;   |
| ®        | 注册商标          | &reg;             | &#174;   |
| ™        | 商标              | &trade;           | &#8482;  |
| ×        | 乘号              | &times;           | &#215;   |
| ÷        | 除号              | &divide;          | &#247;   |





# HTML 统一资源定位器

URL 也被称为网址。

URL 可以由单词组成，比如 “w3school.com.cn”，或者是因特网协议（IP）地址：192.168.1.253。大多数人在网上冲浪时，会键入网址的域名，因为名称比数字容易记忆

### 规则

```
scheme://host.domain:port/path/filename
```

解释：

- scheme - 定义因特网服务的类型。最常见的类型是 http
- host - 定义域主机（http 的默认主机是 www）
- domain - 定义因特网域名，比如 w3school.com.cn
- :port - 定义主机上的端口号（http 的默认端口号是 80）
- path - 定义服务器上的路径（如果省略，则文档必须位于网站的根目录中）。
- filename - 定义文档/资源的名称

### URL Schemes

以下是其中一些最流行的 scheme：

| Scheme | 访问               | 用于...                             |
| ------ | ------------------ | ----------------------------------- |
| http   | 超文本传输协议     | 以 http:// 开头的普通网页。不加密。 |
| https  | 安全超文本传输协议 | 安全网页。加密所有信息交换。        |
| ftp    | 文件传输协议       | 用于将文件下载或上传至网站。        |
| file   |                    | 您计算机上的文件。                  |





### 框架标签

- 框架结构标签（<frameset>）定义如何将窗口分割为框架

- 每个 frameset 定义了一系列行*或*列

- rows/columns 的值规定了每行或每列占据屏幕的面积

  ### 注意：

  假如一个框架有可见边框，用户可以拖动边框来改变它的大小。为了避免这种情况发生，可以在 <frame> 标签中加入：noresize="noresize"。

  为不支持框架的浏览器添加 <noframes> 标签。

  重要提示：不能将 <body></body> 标签与 <frameset></frameset> 标签同时使用！不过，假如你添加包含一段文本的 <noframes> 标签，就必须将这段文字嵌套于 <body></body> 标签内。（在下面的第一个实例中，可以查看它是如何实现的。）

  <frameset cols="25%,50%,25%">
    <frame src="/example/html/frame_a.html">
    <frame src="/example/html/frame_b.html">
    <frame src="/example/html/frame_c.html">

  <noframes>
  <body>您的浏览器无法处理框架！</body>
  </noframes>

  </frameset>

```
<frameset cols="25%,75%">
   <frame src="frame_a.htm">
   <frame src="frame_b.htm">
</frameset>
```





## 表单中get  post

下面是 <form> 属性的列表：

| 属性           | 描述                                                       |
| -------------- | ---------------------------------------------------------- |
| accept-charset | 规定在被提交表单中使用的字符集（默认：页面字符集）。       |
| action         | 规定向何处提交表单的地址（URL）（提交页面）。              |
| autocomplete   | 规定浏览器应该自动完成表单（默认：开启）。                 |
| enctype        | 规定被提交数据的编码（默认：url-encoded）。                |
| method         | 规定在提交表单时所用的 HTTP 方法（默认：GET）。            |
| name           | 规定识别表单的名称（对于 DOM 使用：document.forms.name）。 |
| novalidate     | 规定浏览器不验证表单。                                     |
| target         | 规定 action 属性中地址的目标（默认：_self）。              |

### 何时使用 GET？

您能够使用 GET（默认方法）：

如果表单提交是被动的（比如搜索引擎查询），并且没有敏感信息。

当您使用 GET 时，表单数据在页面地址栏中是可见的：

```
action_page.php?firstname=Mickey&lastname=Mouse
```

注释：GET 最适合少量数据的提交。浏览器会设定容量限制。

### 何时使用 POST？

您应该使用 POST：

如果表单正在更新数据，或者包含敏感信息（例如密码）。

POST 的安全性更加，因为在页面地址栏中被提交的数据是不可见的。



#### input中type类型

HTML5 增加了多个新的输入类型：

- color
- date
- datetime
- datetime-local
- email
- month
- number
- range（ "range" 可显示为滑动控件）
- search（搜索框）
- tel（电话）
- time
- url
- week
- *number*

注释：老式 web 浏览器不支持的输入类型，会被视为输入类型 text。

#### 输入限制

这里列出了一些常用的输入限制（其中一些是 HTML5 中新增的）：

| 属性      | 描述                               |
| --------- | ---------------------------------- |
| disabled  | 规定输入字段应该被禁用。           |
| max       | 规定输入字段的最大值。             |
| maxlength | 规定输入字段的最大字符数。         |
| min       | 规定输入字段的最小值。             |
| pattern   | 规定通过其检查输入值的正则表达式。 |
| readonly  | 规定输入字段为只读（无法修改）。   |
| required  | 规定输入字段是必需的（必需填写）。 |
| size      | 规定输入字段的宽度（以字符计）。   |
| step      | 规定输入字段的合法数字间隔。       |
| value     | 规定输入字段的默认值。             |



## Canvas标签

```
<script type="text/javascript">
var c=document.getElementById("myCanvas");
var cxt=c.getContext("2d");
cxt.fillStyle="#FF0000";
cxt.fillRect(0,0,150,75);
</script>
```

JavaScript 使用 id 来寻找 canvas 元素：

```
var c=document.getElementById("myCanvas");
```

然后，创建 context 对象：

```
var cxt=c.getContext("2d"); 
```

getContext("2d") 对象是内建的 HTML5 对象，拥有多种绘制路径、矩形、圆形、字符以及添加图像的方法。

下面的两行代码绘制一个红色的矩形：

```
cxt.fillStyle="#FF0000";
cxt.fillRect(0,0,150,75); //坐标
```

fillStyle 方法将其染成红色，fillRect 方法规定了形状、位置和尺寸。（用到了再百度）

## 什么是SVG（图形）？

- SVG 指可伸缩矢量图形 (Scalable Vector Graphics)
- SVG 用于定义用于网络的基于矢量的图形
- SVG 使用 XML 格式定义图形
- SVG 图像在放大或改变尺寸的情况下其图形质量不会有损失
- SVG 是万维网联盟的标准

### 实例

```
<!DOCTYPE html>
<html>
<body>

<svg xmlns="http://www.w3.org/2000/svg" version="1.1" height="190">
  <polygon points="100,10 40,180 190,60 10,60 160,180"
  style="fill:lime;stroke:purple;stroke-width:5;fill-rule:evenodd;" />
</svg>

</body>
</html>
```





### 把元素设为可拖放（用到了再百度）

<img draggable="true">



## HTML 本地存储对象

HTML 本地存储提供了两个在客户端存储数据的对象：

- window.localStorage - 存储没有截止日期的数据
- window.sessionStorage - 针对一个 session 来存储数据（当关闭浏览器标签页时数据会丢失）

### localStorage 对象

localStorage 对象存储的是没有截止日期的数据。当浏览器被关闭时数据不会被删除，在下一天、周或年中，都是可用的。

### 实例

```
// 存储
localStorage.setItem("lastname", "Gates");
// 取回
document.getElementById("result").innerHTML = localStorage.getItem("lastname");
localStorage.removeItem("lastname");//删除
```



### XHTML

XHTML 是新的 HTML 。