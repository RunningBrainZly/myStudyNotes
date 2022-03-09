# JS

JavaScript中用//单行注释，/*  */多行注释

反斜杠转义

JavaScript 对象无法进行比较

console.log() 在控制台显示信息

alert()在页面中弹出提示框

所有编程语言，包括 JavaScript，都存在处理浮点值的困难

**注意数值和字符串比较时的转换**



### getElementById()

getElementById() 是多个 JavaScript HTML 方法之一。

document.getElementById('demo').innerHTML = Date()；//获取id为demo的元素，改变其内容为date（）日期

document.getElementById('demo').src=''图片地址''；//改变图片地址

document.getElementById("demo").style.fontSize = "25px";//改变其css样式

```
<p id='demo'></p>
<button onclick="document.getElementById('demo').innerHTML = Date()；"></button>
```



### Js放置位置

习惯性把script写在body元素底部，因为放在开头会影响页面的加载速度。

1.head标签中

2.body标签中

3.外部脚本(后缀为js的文件)，外部脚本不能包含 <script> 标签。

```
<script src='地址'></script>
```

**外部 JavaScript 的优势**

- 分离了 HTML 和代码
- 使 HTML 和 JavaScript 更易于阅读和维护
- 已缓存的 JavaScript 文件可加速页面加载





### JavaScript 输出

**JavaScript 显示方案**

- 使用 window.alert() 写入警告框
- 使用 document.write() 写入 HTML 输出
  - 在 HTML 文档完全加载后使用 document.write() 将*删除所有已有的 HTML* 
  - document.write() 方法仅用于测试。
- 使用 innerHTML 写入 HTML 元素
- 使用 console.log() 写入浏览器控制台



**JavaScript中分号结束语句不是必需的，但我们仍然强烈建议您这么做。**

**JavaScript 会忽略多个空格，您可以向脚本添加空格，以增强可读性，在运算符旁边（ = + - * / ）添加空格是个好习惯。**

**在 HTML 中，JavaScript 程序由 web 浏览器执行。**





### JavaScript 变量

先声明后使用变量。

**变量命名规则**：数字、字母、下划线。数字不能开头。

**JavaScript对大小写敏感。**

等于是‘==’双等号，单=是赋值；

字符串拼接直接用等号拼接。





### JavaScript 数据类型

##### JavaScript 数据类型

JavaScript 变量能够保存多种*数据类型*：数值、字符串值、数组、对象等等：

```
var length = 7;                             // 数字
var lastName = "Gates";                      // 字符串
var cars = ["Porsche", "Volvo", "BMW"];         // 数组
var x = {firstName:"Bill", lastName:"Gates"};    // 对象 
```

**可使用 JavaScript 的 typeof 来确定 JavaScript 变量的类型。**

**任何变量均可通过设置值为 undefined 进行清空。其类型也将是 undefined。**

```
var person = undefined;     // 值是 undefined，类型是 undefined
```

**可以通过设置值为 null 清空对象：**

```
var person = null;           // 值是 null，但是类型仍然是对象
```





### JavaScript 函数

```
function myFunction(p1, p2) {
    return p1 * p2;              // 该函数返回 p1 和 p2 的乘积
}
```





### JavaScript 对象

```
var car = {
    name:"",
    color:"",
    width:"",
    height:"",
    forname :function () {   //属性也可以是函数
        return this.name;
    }
}
在函数定义中，this 引用该函数的“拥有者”。
在上面的例子中，this 指的是“拥有” forname 函数的 car 对象。
换言之，this.name 的意思是当前对象的name属性值。
```

#### 访问对象属性以两种方式访问属性：

**objectName.propertyName** ：car.name;

或者

**objectName["propertyName"]**:car["name"];

#### 访问对象方法

**objectName.methodName()**:car.forname();





### 常见的 HTML 事件

下面是一些常见的 HTML 事件：

| 事件        | 描述                         |
| ----------- | ---------------------------- |
| onchange    | HTML 元素已被改变            |
| onclick     | 用户点击了 HTML 元素         |
| onmouseover | 用户把鼠标移动到 HTML 元素上 |
| onmouseout  | 用户把鼠标移开 HTML 元素     |
| onkeydown   | 用户按下键盘按键             |
| onload      | 浏览器已经完成页面加载       |





### JS字符串方法

0 是字符串中的第一个位置，1 是第二个，2 是第三个 ...

**indexOf()** 方法返回字符串中指定文本*首次*出现的索引（位置）

**lastIndexOf()** 方法返回指定文本在字符串中*最后*一次出现的索引

如果未找到文本， indexOf() 和 lastIndexOf() 均返回 -1

两种方法都接受作为检索起始位置的第二个参数

例如：

```
var str = "The full name of China is the People's Republic of China.";
var pos = str.indexOf("China", 18);//从第18个字符开始检索
```



**search()** 方法搜索特定值的字符串，并返回匹配的位置。（search方法无法设置第二个参数）

##### 提取部分字符串

有三种提取部分字符串的方法：

- slice(*start*, *end*)：包含开始，不含结束，负数从结尾往回数，省略第二个参数就截取后面全部字符
- substring(*start*, *end*)：与slice用法相同，但无法接收负数。
- substr(*start*, *length*)：与slice用法相同，不同之处在于第二个参数规定被提取部分的长度，如果为负数则从结尾开始计数，开始截取，第二个参数不能为负数，因为他定义的是长度。



##### 替换字符串内容

replace() 方法用另一个值替换在字符串中指定的值：

```
str = "Please visit Microsoft!";
var n = str.replace("Microsoft", "W3School");
```

**replace() 方法不会改变调用它的字符串，它返回的是新字符串。**

replace() 对大小写敏感：

```
str = "Please visit Microsoft!";
var n = str.replace("MICROSOFT", "W3School");//其中的Microsoft不会被替换

//使用正则表达式 /i（大小写不敏感）
var n = str.replace(/MICROSOFT/i, "W3School");
//默认地，replace() 只替换首个匹配
//如需替换所有匹配，请使用正则表达式的 g 标志
var n = str.replace(/Microsoft/g, "W3School");
```

toUpperCase() 把字符串转换为大写

toLowerCase() 把字符串转换为小写

concat() 连接两个或多个字符串(和用加号连接是一样的)

trim() 方法删除字符串两端的空白符

charAt() 方法返回字符串中指定下标（位置）的字符串

split() 将字符串转换为数组

```
txt.split(",");          // 用逗号分隔
txt.split(" ");          // 用空格分隔
txt.split("|");          // 用竖线分隔
```



### JS数值

非数值值为：NaN

可以用isNaN()方法来检测变量是否为数值





### JS数组

数组索引从 0 开始

var cars = ["white","baoma","X"];

访问数组元素：cars[0]

访问完整数组：cars

数组中可以存放不同类型的变量：

```
myArray[0] = Date.now;
myArray[1] = myFunction;
myArray[2] = myCars;
```

##### 数组属性和方法

```
var x = cars.length;   // length 属性返回元素的数量
var y = cars.sort();   // sort() 方法对数组进行排序
//访问最后一个元素
fruits = ["Banana", "Orange", "Apple", "Mango"];
var last = fruits[fruits.length - 1];
```

##### 使用for循环遍历数组元素

```
var fruits, text, fLen, i;
fruits = ["Banana", "Orange", "Apple", "Mango"];
fLen = fruits.length;
text = "<ul>";
for (i = 0; i < fLen; i++) {
     text += "<li>" + fruits[i] + "</li>";
} 
```

##### 用push()方法添加新元素：

##### pop() 方法删除最后一个元素：

```
var fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.push("lemon");
fruits.pop();
//shift() 方法会删除首个数组元素，并把所有其他元素“位移”到更低的索引。
fruits.shift();  //删除第一个元素
//unshift() 方法（在开头）向数组添加新元素，并“反向位移”旧元素
fruits.unshift("Lemon"); //在数组开头添加新元素
```

##### 数组方法

toString() 把数组转换为逗号分隔的字符串。

join() 方法也可将所有数组元素转换为字符串，和toString()不同的是可以规定分隔符：

```
var fruits = ["Banana", "Orange","Apple", "Mango"];
document.getElementById("demo").innerHTML = fruits.join(" * "); 
//结果为：Banana * Orange * Apple * Mango
```

concat() 方法通过合并（连接）现有数组来创建一个新数组：

```
var myGirls = ["Cecilie", "Lone"];
var myBoys = ["Emil", "Tobias", "Linus"];
var myChildren = myGirls.concat(myBoys);   // 连接 myGirls 和 myBoys
var myChildren1 = myGirls.concat(myBoys，myBoys);//concat() 方法可以使用任意数量的数组参数。
```

concat() 方法不会更改现有数组，返回一个新数组。

reverse() 方法反转数组中的元素。





### 获取/设置时间方法

| 方法                  | 描述                                         |
| --------------------- | -------------------------------------------- |
| set/getDate()         | 以数值返回天（1-31）                         |
| set/getDay()          | 以数值获取周名（0-6）                        |
| set/getFullYear()     | 获取四位的年（yyyy）                         |
| set/getHours()        | 获取小时（0-23）                             |
| set/getMilliseconds() | 获取毫秒（0-999）                            |
| set/getMinutes()      | 获取分（0-59）                               |
| set/getMonth()        | 获取月（0-11）                               |
| set/getSeconds()      | 获取秒（0-59）                               |
| set/getTime()         | 获取时间（从 1970 年 1 月 1 日至今的毫秒数） |

在 JavaScript 中，一周的第一天（0）表示“星期日”，即使世界上的一些国家认为周的第一天是“星期一”。





### JS数学函数

Math.PI;            // 返回 3.141592653589793

Math.round(x) 的返回值是 x 四舍五入为最接近的整数

Math.pow(x, y) 的返回值是 x 的 y 次幂

Math.sqrt(x) 返回 x 的平方根

Math.abs(x) 返回 x 的绝对（正）值

Math.ceil(x) 的返回值是 x *上舍入*最接近的整数

```
Math.ceil(6.4);     // 返回 7
```

Math.floor(x) 的返回值是 x *下舍入*最接近的整数

```
Math.floor(2.7);    // 返回 2
```

Math.sin(x) 返回角 x（以弧度计）的正弦（介于 -1 与 1 之间的值）

Math.cos(x) 返回角 x（以弧度计）的余弦（介于 -1 与 1 之间的值

Math.tan(x) 返回角x的正切

Math.min() 和 Math.max() 可用于查找参数列表中的最低或最高值

```
Math.min(0, 450, 35, 10, -8, -300, -78);  // 返回 -300
```

Math.random() 返回介于 0（包括） 与 1（不包括） 之间的随机数

用下舍入和随机函数来随机取整数：

```
Math.floor(Math.random() * 11);		// 返回 0 至 10 之间的数
```

 



### 三目运算符

JS中也包含三目运算符：

```
//语法
variablename = (condition) ? value1:value2;
var voteable = (age < 18) ? "太年轻":"足够成熟";
```





### JS中的if   else if  else和switch

```
if（条件表达式）{
	语句；
}else if(条件表达式){
	语句；
}else{
	语句；
}
```

```
switch(表达式){									
	case 表达式1:
		语句1；
		break;
	case 表达式2:
		语句2；
		break;
	case 表达式3:
		语句3；
		break;
.....
	default:
		默认代码块;
		break;
}
```





### JS循环（for,while,do while）

```
for(语句1;条件语句;使条件发生变化){
	循环执行的语句;
}
```

```
while(条件表达式){
	//条件表达式为真时执行，为假时不执行
	循环执行的语句;
}
```

```
do{
	//先执行一次后再判断条件是否为真
	循环执行的语句;
}while(条件表达式);
```

break跳出当前循环，continue跳出本次循环；





### JavaScript 正则表达式

##### 什么是正则表达式？

正则表达式是构成搜索模式的字符序列。

正则表达式可用于执行所有类型的文本搜索和文本替换操作。

正则表达式可以使搜索更强大。

使用字符串方法和正则表达式语法在数据量大的情况下找到所需要的字符的位置。

##### 正则表达式修饰符

| 修饰符 | 描述                                                     |
| ------ | -------------------------------------------------------- |
| i      | 执行对大小写不敏感的匹配。                               |
| g      | 执行全局匹配（查找所有匹配而非在找到第一个匹配后停止）。 |
| m      | 执行多行匹配。                                           |

##### 正则表达式模式

| 表达式 | 描述                       |
| ------ | -------------------------- |
| [abc]  | 查找方括号之间的任何字符。 |
| [0-9]  | 查找任何从 0 至 9 的数字。 |
| (x\|y) | 查找由 \| 分隔的任何选项。 |

*元字符是拥有特殊含义的字符：

| 元字符 | 描述                                        |
| ------ | ------------------------------------------- |
| \d     | 查找数字。                                  |
| \s     | 查找空白字符。                              |
| \b     | 匹配单词边界。                              |
| \uxxxx | 查找以十六进制数 xxxx 规定的 Unicode 字符。 |

*Quantifiers* 定义量词：

| 量词 | 描述                                |                                                              |
| ---- | ----------------------------------- | ------------------------------------------------------------ |
| n+   | 匹配任何包含至少一个 n 的字符串。   | [试一试](https://www.w3school.com.cn/tiy/t.asp?f=js_regexp_n_1) |
| n*   | 匹配任何包含零个或多个 n 的字符串。 | [试一试](https://www.w3school.com.cn/tiy/t.asp?f=js_regexp_n_2) |
| n?   | 匹配任何包含零个或一个 n 的字符串。 | [试一试](https://www.w3school.com.cn/tiy/t.asp?f=js_regexp_n_3) |

##### 使用字符串方法

在 JavaScript 中，正则表达式常用于两个*字符串方法*：search() 和 replace()。

search() 方法使用表达式来搜索匹配，然后返回匹配的位置。

```
var str = "Visit W3School!";
var n = str.search("W3School"); //直接匹配字符串
var n = str.search(/w3school/i); //使用正则表达式来匹配，/w3school/i是一个正则表达式，i是修饰符（搜索w3school对大小写不敏感）
```

replace() 方法返回模式被替换处修改后的字符串。

```
var str = "Visit Microsoft!";
var res = str.replace("Microsoft", "W3School"); 
var res = str.replace(/microsoft/i, "W3School"); 
```

**使用str.match(正则表达式)来显示匹配到的字符。**

#### 正则表达式的方法

**test()** 它通过模式来搜索字符串，然后根据结果返回 true 或 false。

```
/e/.test("The best things in life are free!");//这串字符串中有e则返回true，反之为false
```

**exec()** 它通过指定的模式（pattern）搜索字符串，并返回已找到的文本。

如果未找到匹配，则返回 null。





### 异常

**try 语句使您能够测试代码块中的错误。**

**catch 语句允许您处理错误。**

**throw 语句允许您创建自定义错误。**

​	不抛出异常的话error中自带两个属性：

​		error.name设置或返回错误名

​		error.message设置或返回错误消息（一条字符串）

**finally 使您能够执行代码，在 try 和 catch 之后，无论结果如何。**

```
<!DOCTYPE html>
<html>
<body>

<p>请输入 5 - 10 之间的数字：</p>

<input id="demo" type="text">
<button type="button" onclick="myFunction()">测试输入</button>
<p id="message"></p>

<script>
function myFunction() {
    var message, x;
    message = document.getElementById("message");
    message.innerHTML = "";
    x = document.getElementById("demo").value;
    try { 
        if(x == "") throw "空的"; //抛出的异常相当于把赋值给catch的error
         if(isNaN(x)) throw "不是数字";
         x = Number(x);
        if(x < 5) throw  "太小";
        if(x > 10) throw "太大";
    }
    catch(error) {
        message.innerHTML = "输入是 " + error;
    }finally {
     		//无论 try / catch 结果如何都执行的代码块
     		document.getElementById("demo").value = "";
		}
}
</script>

</body>
</html> 
```





### this关键字

JavaScript this 关键词指的是它所属的对象。

它拥有不同的值，具体取决于它的使用位置：

- 在方法中，this 指的是所有者对象。

- ```
  var person = {
    firstName: "Bill",
    lastName : "Gates",
    id     : 678,
    fullName : function() {
      return this.firstName + " " + this.lastName;
    }
  };
  ```

- 单独的情况下，this 指的是全局对象。

- 在函数中，this 指的是全局对象。

- 在函数中，严格模式下，this 是 undefined。

- ```
  "use strict";
  function myFunction() {
    return this;
  }
  ```

- 在事件中，this 指的是接收事件的元素。

- ```
  <button onclick="this.style.display='none'">
    点击来删除我！
  </button>
  ```

  call() 和 apply() 这样的方法可以将 this 引用到任何对象。





### JavaScript Let 与const(了解一下就行，能不用就不用)

ES2015 引入了两个重要的 JavaScript 新关键词：let 和 const。

这两个关键字在 JavaScript 中提供了块作用域（*Block Scope*）变量（和常量）。

在 ES2015 之前，JavaScript 只有两种类型的作用域：**全局作用域**和**函数作用域**。

块作用域：

```
{
	var x = 10;
}
//之后的所有代码都可以访问到x
let x = 6;//允许
let x = 10;//不允许
{
	let x = 10;
}
//之后的代码访问不到x
```

通过 const 定义的变量与 let 变量类似，但不能重新赋值（在声明时必须给变量赋值）：

```
const PI = 3.141592653589793;
PI = 3.14;      // 会出错
PI = PI + 10;   // 也会出错
var x = 10;
// 此处，x 为 10
{ 
  const x = 6;
  // 此处，x 为 6
}
// 此处，x 为 10
```





### JavaScript 性能

**如何加速您的 JavaScript 代码。**

1.减少循环中的活动

编程经常会用到循环。

循环每迭代一次，循环中的每条语句，包括 for 语句，都会被执行。

2.减少 DOM 访问

与其他 JavaScript 相比，访问 HTML DOM 非常缓慢。

```
var obj;
obj = document.getElementById("demo");
obj.innerHTML = "Hello"; 
```

3.缩减 DOM 规模

4.避免不必要的变量

5.延迟 JavaScript 加载

6.不要使用with变量（严格模式中*不允许* with 关键词）





### JavaScript 版本

JavaScript 由 Brendan Eich 于 1995 年发明，并于 1997 年成为 ECMA 标准。

ECMAScript 是该语言的官方名称。

从 2015 年起，ECMAScript 按年命名（ECMAScript 2015）。

| 版本 | 官方名称                     | 描述                                                         |
| ---- | ---------------------------- | ------------------------------------------------------------ |
| 5    | ECMAScript 5 (2009)  JS  ES5 | 添加了“严格模式”。添加了 JSON 支持。添加了 String.trim()。添加了 Array.isArray()。添加了数组迭代方法。 |
| 5.1  | ECMAScript 5.1 (2011)        | 编辑改变。                                                   |
| 6    | ECMAScript 2015 JS  ES6      | 添加了 let 和 const添加了默认参数值添加了 Array.find()添加了 Array.findIndex() |
| 7    | ECMAScript 2016              | 添加了指数运算符（**）。添加了 Array.prototype.includes。    |
| 8    | ECMAScript 2017              | 添加了字符串填充。添加了新的 Object 属性。添加了异步功能。添加了共享内存。 |
| 9    | ECMAScript 2018              | 添加了 rest / spread 属性。添加了异步迭代。添加了 Promise.finally()。增加 RegExp。 |

所有现代浏览器都完全支持 ECMAScript 5。

##### ES5新特性：

严格模式：“use strict” 

函数 JSON.parse() 用于将文本转换为 JavaScript 对象：

```
var obj = JSON.parse('{"name":"Bill", "age":62, "city":"Seatle"}');
```

函数 JSON.stringify() 将其转换为字符串：

```
var myJSON = JSON.stringify(obj);
```

isArray() 方法检查对象是否为数组

Array.indexOf()检索数组中的某个元素值并返回其位置

charAt() 方法返回字符串中指定索引（位置）的字符

##### ES6新特性：

- 幂 (\**)：x ** y 的结果与 Math.pow(x,y) 相同



### JavaScript JSON

数据互通的作用，规定格式转换。

##### JSON 语法规则

- 数据是名称/值对（名称/值对由（双引号中的）字段名构成，其后是冒号，再其后是值）

  - ```
    "firstName":"Bill"
    ```

- 数据由逗号分隔

- 花括号保存对象

  - ```
    {"firstName":"Bill", "lastName":"Gates"} 
    ```

- 方括号保存数组

  - ```
    "employees":[
        {"firstName":"Bill", "lastName":"Gates"}, 
        {"firstName":"Steve", "lastName":"Jobs"}, 
        {"firstName":"Alan", "lastName":"Turing"}
    ]
    ```

函数 JSON.parse() 用于将文本转换为 JavaScript 对象





### JS对象

##### 对象属性：

for ... in

```
var person = {fname:"Bill", lname:"Gates", age:62}; 

for (x in person) {
    txt += person[x];
}
//person中的每个属性都执行一次
//添加新属性
person.nationality = "English";
//删除属性
delete person.age; 
//delete 关键词不会删除被继承的属性，但是如果您删除了某个原型属性，则将影响到所有从原型继承的对象
```

##### 对象方法(对象中可以包含函数)

```
var person = {
	fname:"bill",
	lname:"gates",
	age:50,
	fullName : function(){
		return this.fname  + " " + this.lname;
	}
};
//访问
preson.fullName();
```







### JavaScript 闭包

**JavaScript 变量属于本地或全局作用域。**

**全局变量能够通过闭包实现局部（私有）。**

不通过关键词 var 创建的变量总是全局的，即使它们在函数中创建。

在网页中，全局变量属于 window 对象。

全局变量能够被页面中（以及窗口中）的所有脚本使用和修改。



#### 闭包计数器（自调用函数）

```
var add = (function () {
    var counter = 0;
    return function () {return counter += 1;}
})();

add();
add();
add();
// 计数器目前是 3 
```

变量 add 的赋值是自调用函数的返回值。

这个自调用函数只运行一次。它设置计数器为零（0），并返回函数表达式。

这样 add 成为了函数。最“精彩的”部分是它能够访问父作用域中的计数器。

这被称为 JavaScript *闭包*。它使函数拥有“*私有*”变量成为可能。

计数器被这个匿名函数的作用域保护，并且只能使用 add 函数来修改。

闭包指的是有权访问父作用域的函数，即使在父函数关闭之后。





### JavaScript HTML DOM

```
<html>
<body>

<p id="demo"></p>

<script>
document.getElementById("demo").innerHTML = "Hello World!";
</script>

</body>
</html>
```

getElementById 是*方法*，而 innerHTML 是*属性*

##### getElementById 方法

访问 HTML 元素最常用的方法是使用元素的 id。

在上面的例子中，getElementById 方法使用 id="demo" 来查找元素。

##### innerHTML 属性

获取元素内容最简单的方法是使用 innerHTML 属性。

innerHTML 属性可用于获取或替换 HTML 元素的内容。

innerHTML 属性可用于获取或改变任何 HTML 元素，包括 <html> 和 <body>。



**HTML DOM 文档对象是您的网页中所有其他对象的拥有者。**

查找 HTML 元素:

| 方法                                    | 描述                   |
| --------------------------------------- | ---------------------- |
| document.getElementById(*id*)           | 通过元素 id 来查找元素 |
| document.getElementsByTagName(*name*)   | 通过标签名来查找元素   |
| document.getElementsByClassName(*name*) | 通过类名来查找元素     |

改变 HTML 元素:

| 方法                                       | 描述                   |
| ------------------------------------------ | ---------------------- |
| element.innerHTML = *new html content*     | 改变元素的 inner HTML  |
| element.attribute = *new value*            | 改变 HTML 元素的属性值 |
| element.setAttribute(*attribute*, *value*) | 改变 HTML 元素的属性值 |
| element.style.property = *new style*       | 改变 HTML 元素的样式   |





### JavaScript HTML DOM 事件

HTML 事件的例子：

- 当用户点击鼠标时
- 当网页加载后
- 当图像加载后
- 当鼠标移至元素上时
- 当输入字段被改变时
- 当 HTML 表单被提交时
- 当用户敲击按键时

**onclick事件**

**onload 和 onunload 事件**

当用户进入后及离开页面时，会触发 onload 和 onunload 事件。

onload 事件可用于检测访问者的浏览器类型和浏览器版本，然后基于该信息加载网页的恰当版本。

onload 和 onunload 事件可用于处理 cookie。

**onchange 事件**经常与输入字段验证结合使用。

**onmouseover 和 onmouseout 事件**

onmouseover 和 onmouseout 事件可用于当用户将鼠标移至 HTML 元素上或移出时触发某个函数

**onmousedown, onmouseup 以及 onclick 事件**

onmousedown, onmouseup 以及 onclick 事件构成了完整的鼠标点击事件。

首先当鼠标按钮被点击时，onmousedown 事件被触发；然后当鼠标按钮被释放时，onmouseup 事件被触发；最后，当鼠标点击完成后，onclick 事件被触发

**onfocus事件**

当输入字段获得焦点时改变其背景色。







### JS  事件监听

```
document.getElementById("myBtn").addEventListener("click", displayDate);
```

**addEventListener() 方法为指定元素指定事件处理程序**。

addEventListener() 方法为元素附加事件处理程序而不会覆盖已有的事件处理程序。

**您能够向一个元素添加多个事件处理程序。**

您能够向一个元素添加多个相同类型的事件处理程序，例如两个 "click" 事件。

addEventListener() 方法使我们更容易控制事件如何对冒泡作出反应。

您能够向任何 DOM 对象添加事件处理程序而非仅仅 HTML 元素，例如 window 对象。

当使用 addEventListener() 方法时，JavaScript 与 HTML 标记是分隔的，已达到更佳的可读性；即使在不控制 HTML 标记时也允许您添加事件监听器。

您能够通过**使用 removeEventListener() 方法轻松地删除事件监听器**。

```
element.removeEventListener("mousemove", myFunction);
```

##### 语法

```
element.addEventListener(event, function, useCapture);
```

第一个参数是事件的类型（比如 "click" 或 "mousedown"）。

第二个参数是当事件发生时我们需要调用的函数。

第三个参数是布尔值，指定使用事件冒泡还是事件捕获。此参数是可选的。

**注意**：请勿对事件使用 "on" 前缀；请使用 "click" 代替 "onclick"。

##### 传递参数

当传递参数值时，请以参数形式使用调用指定函数的“匿名函数”：

```
element.addEventListener("click", function(){ myFunction(p1, p2); });
```

#### 事件冒泡和事件捕获

假如有一个div里面有一个p标签，用户点击这个p是先处理p元素的点击事件还是先处理div的点击事件？

**在冒泡中**，最内侧元素的事件会首先被处理，然后是更外侧的：首先处理 <p> 元素的点击事件，然后是 <div> 元素的点击事件。

**在捕获中**，最外侧元素的事件会首先被处理，然后是更内侧的：首先处理 <div> 元素的点击事件，然后是 <p> 元素的点击事件。

在 addEventListener() 方法中，你能够通过使用“useCapture”参数来规定传播类型：

```
addEventListener(event, function, useCapture);
```

默认值是 false，将使用冒泡传播，如果该值设置为 true，则事件使用捕获传播。



### JavaScript HTML DOM 集合（获取标签集合）

```
var x = document.getElementsByTagName("p");//返回所有p标签元素
y = x[1]; //类似数组的形式访问
```

length 属性定义了 HTMLCollection 中元素的数量

##### HTMLCollection 并非数组！不能使用数组方法。





### JavaScript Window - 浏览器对象模型

所有浏览器都支持 *window* 对象。它代表浏览器的窗口。

所有全局 JavaScript 对象，函数和变量自动成为 window 对象的成员。

全局变量是 window 对象的属性。

全局函数是 window 对象的方法。

document 对象也是 window 对象属性

```
window.document.getElementById("header");
```

一些其他方法：

- window.open() - 打开新窗口
- window.close() - 关闭当前窗口
- window.moveTo() -移动当前窗口
- window.resizeTo() -重新调整当前窗口

#### Window Screen（window.screen 对象包含用户屏幕的信息）

#### Window Location（对象可用于获取当前页面地址（URL）并把浏览器重定向到新页面）

- window.location.href 返回当前页面的 href (URL)
- window.location.hostname 返回 web 主机的域名
- window.location.pathname 返回当前页面的路径或文件名
- window.location.protocol 返回使用的 web 协议（http: 或 https:）
- window.location.assign 加载新文档

```
window.location.assign("baidu.com")
```

#### Window History(window.history 对象包含浏览器历史)

## Window History

window.history 对象可不带 window 书写。

为了保护用户的隐私，JavaScript 访问此对象存在限制。

- history.back() - 等同于在浏览器点击后退按钮
- history.forward() - 等同于在浏览器中点击前进按钮





### JavaScript 弹出框

**JavaScript 有三种类型的弹出框：警告框、确认框和提示框。**

警告框：

```
alert("我是一个警告框！");
```

确认框：

当确认框弹出时，用户将不得不单击“确定”或“取消”来继续进行。

如果用户单击“确定”，该框返回 true。如果用户单击“取消”，该框返回 false。

```
confirm("请按按钮");
```

提示框：

如果您希望用户在进入页面前输入值，通常会使用提示框。

当提示框弹出时，用户将不得不输入值后单击“确定”或点击“取消”来继续进行。

如果用户单击“确定”，该框返回输入值。如果用户单击“取消”，该框返回 NULL。

```
var person = prompt("请输入您的姓名", "比尔盖茨");//可以用一个变量来保存用户输入的值
```





### JavaScript Timing 事件

有两个重要函数：

setTimeout(*function*, *milliseconds*)：**第一个参数是要执行的函数。第二个参数指示执行之前的毫秒数。**

在等待指定的毫秒数后执行函数。

setInterval(*function*, *milliseconds*)**第二个参数指示执行函数之间的间隔时间。**

等同于 setTimeout()，但持续重复执行该函数。

clearTimeout() 方法停止执行 setTimeout() 中规定的函数，必须在读秒之前完成。



### Cookies

##### 什么是 cookie？

Cookie 是在您的计算机上存储在小的文本文件中的数据。

当 web 服务器向浏览器发送网页后，连接被关闭，服务器会忘记用户的一切。

Cookie 是为了解决“如何记住用户信息”而发明的：

- 当用户访问网页时，他的名字可以存储在 cookie 中。
- 下次用户访问该页面时，cookie 会“记住”他的名字。

当浏览器从服务器请求一个网页时，将属于该页的 cookie 添加到该请求中。这样服务器就获得了必要的数据来“记住”用户的信息。

如果浏览器已关闭本地 cookie 支持，则无法使用。

**创建cookies：**

```
document.cookie = "username=Bill Gates,expires=Sun, 31 Dec 2017 12:00:00 UTC; path=/";
```

**其中各个键值对之间用分号隔开。**

通过 path 参数，您可以告诉浏览器 cookie 属于什么路径。默认情况下，cookie 属于当前页。

```
document.cookie = "username=Bill Gates; expires=Sun, 31 Dec 2017 12:00:00 UTC; path=/";
```