# JSON



JSON.stringify(Js对象)，把js对象转换成json格式

```
var myObj = { name:"Bill Gates",  age:62, city:"Seattle" };
var myJSON =  JSON.stringify(myObj);
window.location = "demo_json.php?x=" + myJSON;
```

JSON.parse(json数据)，把json格式数据转换成js对象形式

```
var myJSON = '{ "name":"Bill Gates",  "age":62, "city":"Seattle" }';
var myObj =  JSON.parse(myJSON);
document.getElementById("demo").innerHTML = myObj.name;
```

**json数据格式：**

**花括号括起来，名称要用双引号，名称后跟冒号，然后是值，数据间用逗号分开。**

**js对象中的属性则不用双引号。**

```
var myJSON = '{ "name":"Bill Gates",  "age":62, "city":"Seattle" ,' +
        '"employees":[' +
        '{ "firstName":"Bill", "lastName":"Gates" },' +
        '{ "firstName":"Steve", "lastName":"Jobs" },' +
        '{ "firstName":"Elon", "lastName":"Musk" }]}';
        //换行要加单引号和加号，但在数据传输时不需要加
```



### JSON 类似 XML，因为:

- JSON 和 XML 都是“自描述的”（人类可读的）
- JSON 和 XML 都是分级的（值中有值）
- JSON 和 XML 都能被大量编程语言解析和使用
- JSON 和 XML 都能被 XMLHttpRequest 读取

### JSON 与 XML 的差异在于：

- JSON 不使用标签
- JSON 更短
- JSON 的读写速度更快
- JSON 可使用数组

最大的不同在于：

XML 必须使用 XML 解析器进行解析。而 JSON 可通过标准的 JavaScript 函数进行解析。



### 对于 AJAX 应用程序，JSON 比 XML 更快更易用：

使用 XML

- 读取 XML 文档
- 使用 XML DOM 遍历文档
- 提取变量中存储的值

使用 JSON

- 读取 JSON 字符串
- **JSON.Parse JSON 字符串(转为对象格式之后更方便调用)**



### JSON中允许的数据格式

在 JSON 中，值必须是以下数据类型之一：

- 字符串

- 数字（数字必须是整数或浮点数）

- 对象（JSON 对象）

  - ```
    {
    "employee":{ "name":"Bill Gates", "age":62, "city":"Seattle" }
    }
    ```

- 数组

  - ```
    {
    "employees":[ "Bill", "Steve", "David" ]
    }
    ```

- 布尔

- Null

JSON 的值*不可以*是以下数据类型之一：

- 函数
- 日期
- undefined

### AJAX   JSON实例

请使用 XMLHttpRequest 从服务器获取数据：

```
var xmlhttp = new XMLHttpRequest();
xmlhttp.onreadystatechange = function()  {
    if (this.readyState == 4 && this.status == 200) {
        myObj =  JSON.parse(this.responseText);
        document.getElementById("demo").innerHTML  = myObj.name;
    }
};
xmlhttp.open("GET", "json_demo.txt", true);
xmlhttp.send();
```



json中如果要传送日期格式的数据首先要存储为字符串格式，再利用JSON.parse()函数中的第二个参数

称为 *reviver*，这个 *reviver* 参数是函数，在返回值之前，它会检查每个属性。



### 删除json对象属性

```
delete myObj.cars.car1;
```





### php json 实例：

```
obj = { "table":"customers", "limit":20 };
dbParam = JSON.stringify(obj);
xmlhttp = new XMLHttpRequest();
xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4  && this.status == 200) {
        myObj = JSON.parse(this.responseText);
         txt += "<table border='1'>"
        for (x in myObj) {
             txt += "<tr><td>" + myObj[x].name + "</td></tr>";
        }
        txt += "</table>" 
        document.getElementById("demo").innerHTML  = txt;
    }
}
xmlhttp.open("POST", "json_demo_db_post.php", true);
xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xmlhttp.send("x=" + dbParam);
```