# jQuery

jQuery 由 John Resig 于 2006 年创建。它旨在处理浏览器不兼容性并简化 HTML DOM 操作、事件处理、动画和 Ajax。

十多年来，jQuery 一直是世界上最受欢迎的 JavaScript 库。

但是，在 JavaScript Version 5（2009）之后，大多数 jQuery 实用程序都可以通过几行标准 JavaScript 来解决。



使用方法：

<script type="text/javascript">
$(document).ready(function(){
  $("p").click(function(){
  $(this).hide();
  });
});
</script>
**1.导入jQuery包**

**2.在script标签中**

**$(document).ready(function() { / /jQuery代码;  });这个方法中使用jQuery**



### jQuery 属性选择器

jQuery 使用 XPath 表达式来选择带有给定属性的元素。

$("[href]") 选取所有带有 href 属性的元素。

$("[href='#']") 选取所有带有 href 值等于 "#" 的元素。

$("[href!='#']") 选取所有带有 href 值不等于 "#" 的元素。

$("[href$='.jpg']") 选取所有 href 值以 ".jpg" 结尾的元素。



### jQuery 名称冲突

jQuery 使用 $ 符号作为 jQuery 的简介方式。

某些其他 JavaScript 库中的函数（比如 Prototype）同样使用 $ 符号。

jQuery 使用名为 noConflict() 的方法来解决该问题。

*var jq=jQuery.noConflict()*，帮助您使用自己的名称（比如 jq）来代替 $ 符号。



### jQuery效果

```
$(selector).hide(speed,callback);
$(selector).show(speed,callback);
jQuery toggle()
通过 jQuery，您可以使用 toggle() 方法来切换 hide() 和 show() 方法。
$(selector).fadeIn(speed,callback);//淡入淡出
$(selector).fadeOut(speed,callback);
$(selector).fadeToggle(speed,callback);
jQuery fadeTo() 方法
jQuery fadeTo() 方法允许渐变为给定的不透明度（值介于 0 与 1 之间）。
$(selector).fadeTo(speed,opacity,callback);
```

```
$(selector).slideDown(speed,callback);//上下滑动
$(selector).slideUp(speed,callback);
$(selector).slideToggle(speed,callback);
```

可选的 speed 参数规定隐藏/显示的速度，可以取以下值："slow"、"fast" 或毫秒。

可选的 callback 参数是隐藏或显示完成后所执行的函数名称。（如果您希望在一个涉及动画的函数之后来执行语句，请使用 callback 函数）

#### 动画

```
$(selector).slideUp(speed,callback);
$("button").click(function(){
  $("div").animate({
    left:'250px',
    opacity:'0.5',
    height:'150px',
    width:'150px'
  });
}); 
//jQuery animate() - 使用队列功能（按顺序执行）
$("button").click(function(){
  var div=$("div");
  div.animate({height:'300px',opacity:'0.4'},"slow");
  div.animate({width:'300px',opacity:'0.8'},"slow");
  div.animate({height:'100px',opacity:'0.4'},"slow");
  div.animate({width:'100px',opacity:'0.8'},"slow");
});
```

也可以定义相对值（该值相对于元素的当前值）。需要在值的前面加上 += 或 -=：

必需的 params 参数定义形成动画的 CSS 属性。





### jQuery获取

获取文本值：$("#test").text()

获取html值：$("#test").html()

获取输入字段的值：$("#test").val()

获取属性值：$("#w3s").attr("href")



### jQuery设置

- text() - 设置或返回所选元素的文本内容
- html() - 设置或返回所选元素的内容（包括 HTML 标记）
- val() - 设置或返回表单字段的值
- attr()-设置属性值

attr回调函数

```
$("button").click(function(){
  $("#w3s").attr("href", function(i,origValue){
    return origValue + "/jquery";
  });
});
```



### jQuery 和 js  DOM(原生js)的区别：

##### 用元素id获取元素：

jQurey  :  var myElement = $("#id01");

js  DOM:  var myElement = document.getElementById("id01");

##### 用标签名获取元素：

jQurey  :  var myElements = $("p");

js  DOM:  var myElements = document.getElementsByTagName("p");

##### 用类名获取元素：

jQurey  :  var myElements = $(".intro");

js  DOM:  var myElements = document.getElementsByClassName("intro");

##### 用css选择器获取元素：

jQurey  :  var myElements = $("p.intro");

js  DOM:  var myElements = document.querySelectorAll("p.intro");



##### 设置元素内容：

jQurey  : myElement.text("Hello China!");

jQurey  : var content = myElement.html();

js  DOM:  myElement.innerText = "Hello China!";

##### 获取元素内部文本：

jQurey  : var myText = myElement.text();

js  DOM:  var myText = myElement.innerText;



##### 隐藏元素：

jQurey  : myElement.hide();

js  DOM: myElement.style.display = "none";

##### 显示元素：

jQurey  : myElement.show();

js  DOM: myElement.style.display = "";

##### 修改css样式：

jQurey  : myElement.css("font-size","35px");

js  DOM: myElement.style.fontSize = "35px";

##### 删除元素：

jQurey  : $("#id").remove();

js  DOM:  element.parentNode.removeChild(element);

##### 获取父元素：

jQurey  : var myParent = myElement.parent();

js  DOM: var myParent = myElement.parentNode;