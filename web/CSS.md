# CSS

（html中注释用<!--...-->，css和js中注释用  /*  中间为注释内容  */）

### 为何使用 CSS？

CSS 用于定义网页的样式，包括针对不同设备和屏幕尺寸的设计和布局。

## CSS 语法

CSS 规则集（rule-set）由选择器和声明块组成：

h1{

​	color:black;

​	font-size:16;

}

选择器指向您需要设置样式的 HTML 元素。

声明块包含一条或多条用分号分隔的声明。

每条声明都包含一个 CSS 属性名称和一个值，以冒号分隔。

多条 CSS 声明用分号分隔，声明块用花括号括起来。



### css选择器

CSS 选择器分为五类：

- 简单选择器（根据名称、id、类来选取元素）

  - 名称选择器 例如 p{ 属性 }

  - id选择器 例如 #myfrom{ 属性 }

    类选择器 例如 .myfrom{ 属性 }

  - 通用选择器 *{ 属性 }

  - 类名和id名不能以数字开头

- [组合器选择器](https://www.w3school.com.cn/css/css_combinators.asp)（根据它们之间的特定关系来选取元素）

- [伪类选择器](https://www.w3school.com.cn/css/css_pseudo_classes.asp)（根据特定状态选取元素）

- [伪元素选择器](https://www.w3school.com.cn/css/css_pseudo_elements.asp)（选取元素的一部分并设置其样式）

- [属性选择器](https://www.w3school.com.cn/css/css_attribute_selectors.asp)（根据属性或属性值来选取元素）



## 三种使用 CSS 的方法

有三种插入样式表的方法：

- 外部 CSS
- 内部 CSS
- 行内 CSS

行内样式具有最高优先级，外部和内部则看顺序，以最后的样式为准。



### 颜色和透明度：

rgb，rgba , hsl , hsla , hex(十六进制)

rgb(255, 255, 255)white

RGBA 即红色、绿色、蓝色、透明度（英语：Red, Green, Blue、Alpha）。

- **红色（R）**0 到 255 间的整数，代表颜色中的红色成分。。
- **绿色（G）**0 到 255 间的整数，代表颜色中的绿色成分。
- **蓝色（B）**0 到 255 间的整数，代表颜色中的蓝色成分。
- **透明度（A）**取值 0~1 之间， 代表透明度。

HSLA 即色相、饱和度、亮度、透明度（英语：Hue, Saturation, Lightness, Alpha ）。

- **色相（H）**是色彩的基本属性，就是平常所说的颜色名称，如红色、黄色等。
- **饱和度（S）**是指色彩的纯度，越高色彩越纯，低则逐渐变灰，取 0-100% 的数值。
- **亮度（L）** 取 0-100%，增加亮度，颜色会向白色变化；减少亮度，颜色会向黑色变化。
- **透明度（A）** 取值 0~1 之间， 代表透明度。

```
<h1 style="background-color:rgba(255, 99, 71, 0.5);">...</h1>
<h1 style="background-color:hsla(9, 100%, 64%, 0.5);">...</h1>
```





### 背景

- background-color属性指定元素的背景色。
- background-image属性指定用作元素背景的图像。（默认情况下，图像会重复，以覆盖整个元素。）
- 例如：background-image: url("tree.png")；
- background-repeat
  - 在水平方向重复 background-repeat: repeat-x；
  - 垂直重复图像，设置 background-repeat: repeat-y;
  - 只显示一次背景图像：background-repeat: no-repeat；
- background-attachment属性指定背景图像是应该滚动还是固定的（不会随页面的其余部分一起滚动）
  - background-attachment: fixed；固定
  - background-attachment: scroll；滚动
- background-position用于指定背景图像的位置。例如：background-position: right top；
- background-origin 规定在何处放置背景图像。
- background-size规定背景图像的尺寸。







## 边框

**border-color** 属性用于设置四个边框的颜色。设置一到四个值（用于上边框、右边框、下边框和左边框）

​        设置三个属性则是  ：  上、左右、下

​	注：如果未设置 border-color，则它将继承元素的颜色。

**border-width** 属性指定四个边框的宽度。设置一到四个值（用于上边框、右边框、下边框和左边框）

```
border-width: 5px 20px; /* 上下 5px，左右20px */
border-width: 5px 10px 20px;/* 上、左右、下四个方向 */
```

**border-style **属性指定要显示的边框类型。

允许以下值：

- dotted - 定义点线边框
- dashed - 定义虚线边框
- solid - 定义实线边框
- double - 定义双边框
- groove - 定义 3D 坡口边框。效果取决于 border-color 值
- ridge - 定义 3D 脊线边框。效果取决于 border-color 值
- inset - 定义 3D inset 边框。效果取决于 border-color 值
- outset - 定义 3D outset 边框。效果取决于 border-color 值
- none - 定义无边框
- hidden - 定义隐藏边框

border-style 属性可以设置一到四个值（用于上边框、右边框、下边框和左边框）。

##### 还可以指定单个边框，例如：border-bottom: 6px solid red;

**border-radius** 属性用于向元素添加圆角边框。



### 盒子模型

1. CSS处理网页时，它认为每个元素都包含在一个不可见的盒子里。
2. 为什么要想象成盒子呢？因为如果把所有的元素都想象成盒子，那么我们对网页的布局就相当于是摆放盒子。
3. 我们只需要将相应的盒子摆放到网页中相应的位置即可完成网页的布局。

#### 一个盒子由几部分组成

- 内容区(content)
- 内边距(padding)
- 边框(border)
- 外边距(margin)
  - margin-top
  - margin-right
  - margin-bottom
  - margin-left
    - auto - 浏览器来计算外边距
    - *length* - 以 px、pt、cm 等单位指定外边距
    - % - 指定以包含元素宽度的百分比计的外边距
    - inherit - 指定应从父元素继承外边距
    - 可以是负值

![](D:/%E8%BD%AF%E5%B8%9D/Web/%E7%AC%94%E8%AE%B0/2.png)

#### 边距合并

外边距合并指的是，当两个垂直外边距相遇时，它们将形成一个外边距。

合并后的外边距的高度等于两个发生合并的外边距的高度中的较大者。

![margin_collapsing_1](D:\studys\web\margin_collapsing_1.gif)

**注释**：只有普通文档流中块框的垂直外边距才会发生外边距合并。行内框、浮动框或绝对定位之间的外边距不会合并。





#### 内容区

1. 内容区指的是盒子中放置内容的区域，也就是元素中的文本内容，子元素都是存在于内容区中的。
2. 如果没有为元素设置内边距和边框，则内容区大小默认和盒子大小是一致的。
3. 通过width和height两个属性可以设置内容区的大小。
4. width和height属性只适用于块元素。
5. **height 和 width 属性不包括内边距、边框或外边距！它们设置的是元素的内边距、边框和外边距内的区域的高度/宽度！**



#### 内边距(padding)（上右下左）

1. 顾名思义，内边距指的就是元素内容区与边框以内的空间。

2. 默认情况下width和height不包含padding的大小。

3. 使用padding属性来设置元素的内边距。

4. 例如：
   1. padding:10px 20px 30px 40px
   2. 这样会设置元素的上、右、下、左四个方向的内边距

   **如果元素拥有指定的宽度，则添加到该元素的内边距会添加到元素的总宽度中。**

   例如：<div> 元素的宽度为 300px。但是，<div> 元素的实际宽度将是 350px（300px + 左内边距 25px + 右内边距 25px）：

   ```
   div {
     width: 300px;
     padding: 25px;
   }
   ```



#### 外边距（margin）

- 外边距是元素边框与周围元素相距的空间。
- 使用margin属性可以设置外边距。
- 用法和padding类似，同样也提供了四个方向的margin-top/right/bottom/left。
- 当将左右外边距设置为auto时，浏览器会将左右外边距设置为相等，所以这行代码margin:0 auto可以使元素居中。
- 可以为负值

**重要提示：**使用 CSS 设置元素的 width 和 height 属性时，只需设置内容区域的宽度和高度。要计算元素的完整大小，还必须把内边距、边框和外边距加起来。





### CSS 轮廓

轮廓是在元素周围绘制的一条线，在边框之外，以凸显元素。

CSS 拥有如下轮廓属性：

- outline-style
- outline-color
- outline-width
- outline-offset属性在元素的轮廓与边框之间添加空间。元素及其轮廓之间的空间是透明的。
- outline

注意：轮廓与边框不同！不同之处在于：轮廓是在元素边框之外绘制的，并且可能与其他内容重叠。同样，轮廓也不是元素尺寸的一部分；元素的总宽度和高度不受轮廓线宽度的影响。





### CSS文本

text-align 属性用于设置文本的水平对齐方式。

vertical-align 属性设置元素的垂直对齐方式。

text-decoration 属性用于设置或删除文本装饰。

text-decoration: none; 通常用于从链接上删除下划线。

text-transform 属性用于指定文本中的大写和小写字母。

它可用于将所有内容转换为大写或小写字母，或将每个单词的首字母大写。

text-indent 属性用于指定文本第一行的缩进。单位（px）

letter-spacing 属性用于指定文本中字符之间的间距。

line-height 属性用于指定行之间的间距。

word-spacing 属性用于指定文本中单词之间的间距。

white-space 属性指定元素内部空白的处理方式。

text-shadow 属性为文本添加阴影。

最简单的用法是只指定水平阴影（2px）和垂直阴影（2px）模糊阴影（5px）、颜色红色：

```
text-shadow: 2px 2px 5px red;
```



### CSS字体

我们使用 font-family 属性规定文本的字体。

font-style 属性主要用于指定斜体文本。

font-weight 属性指定字体的粗细。

font-variant 属性指定是否以 small-caps 字体（小型大写字母）显示文本。

在 small-caps 字体中，所有小写字母都将转换为大写字母。但是，转换后的大写字母的字体大小小于文本中原始大写字母的字体大小。

font-size 属性设置文本的大小。





### CSS链接

可以根据链接处于什么状态来设置链接的不同样式。

四种链接状态分别是：

- a:link - 正常的，未访问的链接
- a:visited - 用户访问过的链接
- a:hover - 用户将鼠标悬停在链接上时
- a:active - 链接被点击时

如果为多个链接状态设置样式，请遵循如下顺序规则：

- a:hover 必须 a:link 和 a:visited 之后
- a:active 必须在 a:hover 之后

text-decoration 属性主要用于从链接中删除下划线





### CSS列表

在 HTML 中，列表主要有两种类型：

- 无序列表（<ul>）- 列表项用的是**项目符号**标记
- 有序列表（<ol>）- 列表项用的是**数字**或**字母**标记

CSS 列表属性使您可以：

- 为有序列表设置不同的列表项标记
- 为无序列表设置不同的列表项标记
- 将图像设置为列表项标记
- 为列表和列表项添加背景色

list-style-type 属性指定列表项标记的类型。

list-style-image 属性将图像指定为列表项标记：

```
ul {
  list-style-image: url('sqpurple.gif');
}
```

list-style-type:none 属性也可以用于删除标记/项目符号。请注意，列表还拥有默认的外边距和内边距。要删除此内容，请在 <ul> 或 <ol> 中添加 margin:0 和 padding:0 ：

```
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}
```



### CSS表格

在 <tr> 元素上使用 :hover 选择器，以突出显示鼠标悬停时的表格行：tr:hover {background-color: #f5f5f5;}







## 中级

### display

- 我们不能为行内元素设置width、height、margin-top和margin-bottom。
- 我们可以通过修改display来修改元素的性质。
- 可选值：
  - display:block（设置元素为块元素）

  - display:inline（设置元素为行内元素）

  - display:inline-block（设置元素为行内块元素）

  - **display:none（隐藏元素（元素将在页面中完全消失，消失之后不占用空间））(多配合js使用)**

    **visibility:hidden; 也可以隐藏元素。（该元素仍将占用与之前相同的空间。元素将被隐藏，但仍会影响布局）**



### 块级元素

总是从新行开始，并占据可用的全部宽度（尽可能向左和向右伸展）:

块级元素的一些例子：

div,h1-h6,p,form,header,footer,section



### 行内元素（inline element）（内联元素）

内联元素不从新行开始，仅占用所需的宽度。

行内元素例子：

span,a,img



使用 max-width 可以改善浏览器对小窗口的处理。为了使网站在小型设备上可用，（缩小窗口后自动随着窗口缩小）

```
div.ex2 {
  max-width: 500px;
  margin: auto;
  border: 3px solid #73AD21;
}
```





### 定位（position）

- position属性可以控制Web浏览器如何以及在何处显示特定的元素。
- 可选值：
  - static(静态的，静态定位的元素不受 top、bottom、left 和 right 属性的影响。)
  - relative相对定位（元素相对于其正常位置进行定位，不会对其余内容进行调整来适应元素留下的任何空间。）
  - absolute（ 元素相对于最近的定位祖先元素进行定位，如果绝对定位的元素没有祖先，它将使用文档主体body，并随页面滚动一起移动。）
  - fixed（元素是相对于视口定位的，这意味着即使滚动页面，它也始终位于同一位置。）
  - sticky（粘性元素根据滚动位置在相对（relative）和固定（fixed）之间切换。起先它会被相对定位，直到在视口中遇到给定的偏移位置为止 - 然后将其“粘贴”在适当的位置）

  **设置定位后设置top，right，bottom，left属性才有效**

#### 相对定位（relative）

- 每个元素在页面的文档流中都有一个自然位置。相对于这个位置对元素进行移动就称为相对定位。周围的元素完全不受此影响。
- 当将position属性设置为relative时，则开启了元素的相对定位。
- 当开启了相对定位以后，可以使用top、right、bottom、left四个属性对元素进行定位。
- 相对定位的特点
  - 如果不设置元素的偏移量，元素位置不会发生改变。
  - 相对定位不会使元素脱离文本流。元素在文本流中的位置不会改变。
  - 相对定位不会改变元素原来的特性。
  - 相对定位会使元素的层级提升，使元素可以覆盖文本流中的元素。

#### 绝对定位（absolute）

- 绝对定位指使元素相对于html元素或离他最近的祖先定位元素进行定位。
- 当将position属性设置为absolute时，则开启了元素的绝对定位。
- 当开启了绝对定位以后，可以使用top、right、bottom、left四个属性对元素进行定位
- 绝对定位的特点
  - 绝对定位会使元素完全脱离文本流。
  - 绝对定位的块元素的宽度会被其内容撑开。
  - 绝对定位会使行内元素变成块元素。
  - 一般使用绝对定位时会同时为其父元素指定一个相对定位，以确保元素可以相对于父元素进行定位。

#### 固定定位（fixed）

- 固定定位的元素会被锁定在屏幕的某个位置上，当访问者滚动网页时，固定元素会在屏幕上保持不动。
- 当将position属性设置为fixed时，则开启了元素的固定定位。
- 当开启了固定定位以后，可以使用top、right、bottom、left四个属性对元素进行定位。
- 固定定位的其他特性和绝对定位类似。

#### z-index

- 当元素开启定位以后就可以设置z-index这个属性。
- 这个属性可以提升定位元素所在的层级。
- z-index可以指定一个整数作为参数，值越大元素显示的优先级越高，也就是z-index值较大的元素会显示在网页的最上层。





### overflow

- 当相关标签里面的内容超出了样式的宽度和高度是，就会发生一些奇怪的事情，浏览器会让内容溢出盒子。

- 可以通过overflow来控制内容溢出的情况。

- 可选值：

  - visible：默认值
  - scroll：添加滚动条
  - auto：根据需要添加滚动条
  - hidden：隐藏超出盒子的内容

  overflow 属性仅适用于具有指定高度的块元素。

```
 overflow-x: hidden; /* 隐藏水平滚动栏 */
 overflow-y: scroll; /* 添加垂直滚动栏 */
```



### 浮动

- 所谓浮动指的是使元素脱离原来的文本流，在父元素中浮动起来。
- 浮动使用float属性。
- 可选值：
  - none：不浮动
  - left：向左浮动
  - right：向右浮动
  - inherit - 元素继承其父级的 float 值
- 块级元素和行内元素都可以浮动，当一个行内元素浮动以后将会自动变为一个块级元素。
- 当一个块级元素浮动以后，**宽度会默认被内容撑开**，**所以当漂浮一个块级元素时我们都会为其指定一个宽度**。
- 当一个元素浮动以后，其下方的元素会上移。元素中的内容将会围绕在元素的周围。
- 浮动会使元素完全脱离文本流，也就是不再在文档中在占用位置。
- 元素设置浮动以后，会一直向上漂浮直到遇到父元素的边界或者其他浮动元素。
- 元素浮动以后即完全脱离文档流，这时不会再影响父元素的高度。也就是浮动元素不会撑开父元素。
- 浮动元素默认会变为块元素，即使设置display:inline以后其依然是个块元素。

#### 清除浮动

- clear属性可以用于清除元素周围的浮动对元素的影响。
- 也就是元素不会因为上方出现了浮动元素而改变位置。
- 可选值：
  - left：忽略左侧浮动
  - right：忽略右侧浮动
  - both：忽略全部浮动
  - none：不忽略浮动，默认值
  - both - 左侧或右侧均不允许浮动元素
  - inherit - 元素继承其父级的 clear 值

### 什么是 box-sizing？

您可以轻松地并排创建三个浮动框。但是，当您添加一些内容来扩大每个框的宽度（例如，内边距或边框）时，这个框会损坏。 box-sizing 属性允许我们在框的总宽度（和高度）中包括内边距和边框，确保内边距留在框内而不会破裂。

使用浮动的例子：

```
* {
  box-sizing: border-box;
}

.box {
  float: left;
  width: 33.33%; /* 三个框（四框使用 25%，两框使用 50%，以此类推） */
  padding: 50px; /* 如果需要在图片间增加间距 */
}
```

如果把框的高度设为固定值，就失去了弹性，如果可以保证框中始终有相同数量的内容，那是可以的。但是很多时候，内容是不一样的。如果您在手机上尝试上例，则会看到第二个框的内容将显示在框的外部。

Flexbox（它可以自动拉伸框使其与最长的框一样长）

与 display: inline 相比，主要区别在于 display: inline-block 允许在元素上设置宽度和高度。





### CSS 布局 - 水平和垂直对齐

要使块元素**居中对齐用 margin：auto；**（要设其宽度，宽度为100%则对齐无效）

**左和右对齐 - 使用 float**

**垂直对齐使用padding**







### 选择器（配合使用选择某一个或某一类元素）

- **组合器选择器**（根据它们之间的特定关系来选取元素）

  - 后代选择器 (空格)
  - 子选择器 (>)
  - 相邻兄弟选择器 (+)（紧随当前元素后的一个元素）
  - 通用兄弟选择器 (~)（所有与当前元素同级的元素）例如：div ~ p （所有与div同级的p元素）

- **伪类选择器**（伪类用于定义元素的特殊状态。用单引号）

  可以用于：

  - 设置鼠标悬停在元素上时的样式
  - 为已访问和未访问链接设置不同的样式
  - 设置元素获得焦点时的样式

  例子：

  input:checked（选择每个被选中的 input 元素）

  input:focus（选择获得焦点的 input 元素）

  :first-child（匹配作为任何元素的第一个子元素的元素）

- **伪元素选择器**（选取元素的一部分并设置其样式，用双引号）

- ###### 所有 CSS **伪元素**

  | 选择器                                                       | 例子            | 例子描述                      |
  | ------------------------------------------------------------ | --------------- | ----------------------------- |
  | [::after](https://www.w3school.com.cn/cssref/selector_after.asp) | p::after        | 在每个 <p> 元素之后插入内容。 |
  | [::before](https://www.w3school.com.cn/cssref/selector_before.asp) | p::before       | 在每个 <p> 元素之前插入内容。 |
  | [::first-letter](https://www.w3school.com.cn/cssref/selector_first-letter.asp) | p::first-letter | 选择每个 <p> 元素的首字母。   |
  | [::first-line](https://www.w3school.com.cn/cssref/selector_first-line.asp) | p::first-line   | 选择每个 <p> 元素的首行。     |
  | [::selection](https://www.w3school.com.cn/cssref/selector_selection.asp) | p::selection    | 选择用户选择的元素部分。      |

- **属性选择器**（根据属性或属性值来选取元素）

  ​	用法：CSS [attribute] 选择器

  ​		    CSS [attribute="value"] 选择器等等

  ​	例如：选择所有带有 target 属性的 <a> 元素

  ```
  a[target] {
    background-color: yellow;
  }
  ```



#### opacity 属性指定元素的不透明度/透明度（ 属性的取值范围为 0.0-1.0。值越低，越透明）。

使用 opacity 属性为元素的背景添加透明度时，其所有子元素都继承相同的透明度。

如果不希望子元素继承用rgba的方法设置颜色和透明度。





#### 导航栏设置：

- list-style-type: none; - 删除项目符号。导航条不需要列表项标记。
- 设置 margin: 0; 和 padding: 0; 删除浏览器的默认设置。

display: block; - 将链接显示为块元素可以使整个链接区域都可以被单击（而不仅仅是文本），我们还可以指定宽度（如果需要，还可以指定内边距、外边距、高度等）。

width: 60px; - 默认情况下，块元素会占用全部可用宽度。我们需要指定 60 像素的宽度。

text-decoration: none；去除下划线



background-image为元素设置一个或多个背景



### CSS 阴影效果

**text-shadow**（属性为文本添加阴影。）

例如：text-shadow: 2px 2px 3px #FF0000; //水平2px，垂直2px，模糊3px，颜色FF0000 

**box-shadow**（ 属性应用阴影于元素。）

例如：box-shadow: 10px 4px 8px 10px rgba(0,0,0,0.3);水平10px，垂直4px，模糊8px，阴影范围10px，颜色透明度





### CSS文本效果

- text-overflow（溢出之后处理方式，加滚轮还是隐藏）

- word-wrap（使长文字能够被折断并换到下一行）

- word-break（指定换行规则）

- #### writing-mode（规定文本行是水平放置还是垂直放置）



### 响应式图像

响应式图像会自动调整以适合屏幕尺寸。

如果您希望根据需要缩小图像，但需要杜绝放大到大于原始尺寸，请添加如下代码：

##### 实例

```
img {
  max-width: 100%;
  height: auto;
}
```



### 图像滤镜

CSS filter 属性把视觉效果（如模糊和饱和度）添加到元素。

##### 实例

把所有图像的颜色更改为黑白（100％ 灰色）：

```
img {
  filter: grayscale(100%);
}
```





### CSS object-fit 属性的所有值

 object-fit属性用于规定应如何调整 <img> 或 <video> 的大小来适应其容器。

object-fit 属性可接受如下值：

- fill - 默认值。调整替换后的内容大小，以填充元素的内容框。如有必要，将拉伸或挤压物体以适应该对象。
- contain - 缩放替换后的内容以保持其纵横比，同时将其放入元素的内容框。
- cover - 调整替换内容的大小，以在填充元素的整个内容框时保持其长宽比。该对象将被裁剪以适应。
- none - 不对替换的内容调整大小。
- scale-down - 调整内容大小就像没有指定内容或包含内容一样（将导致较小的具体对象尺寸）





**transform（2D转换）**

**transition动画效果的时间**

**使用 transition-duration 属性来确定“悬停”动画效果的时间**

**cursor: not-allowed;鼠标指针放在一个元素边界范围内时所呈现的禁止标志**

**cursor属性：指鼠标指针放在一个元素边界范围内时所呈现的光标形状,它包括问号,小手等形状。** 





### CSS 多列属性

多列属性：

- column-count：规定元素应被划分的列数。
- column-gap：规定列之间的间隔。
- column-rule-style：规定列之间的规则样式。
- column-rule-width：规定列之间的规则宽度。
- column-rule-color：规定列之间的规则的颜色。
- column-rule：是用于设置上面所有 column-rule-* 属性的简写属性。
- column-span：规定元素应跨越多少列。
- column-width：为列指定建议的宽度。



### CSS变量

**:root(可以在整个文档中访问/使用全局变量)声明全局CSS变量，用var(name,value)调用**

例如：

```
:root {
  --blue: #1e90ff;
  --white: #ffffff;
}
body { background-color: var(--blue); }

h2 { border-bottom: 2px solid var(--blue); }

.container {
  color: var(--blue);
  background-color: var(--white);
  padding: 15px;
}
```



##### 用局部变量覆盖全局变量(只能在当前的选择器中使用)

```
:root {
  --blue: #1e90ff;
  --white: #ffffff;
}
button {
  --blue: #0000ff;
  background-color: var(--white);
  color: var(--blue);
  border: 1px solid var(--blue);
  padding: 5px;
}
```



### CSS box-sizing

**box-sizing: border-box;**定义元素宽度和高度的计算方式：它们是否应包含内边距（padding）和边框。





### CSS Flexbox（不用使用定位和悬浮可以布局块元素，弹性内容）

用法：display: flex;（将元素CSS display定义为flex）

以下是 flex 容器属性：

- flex-direction属性定义容器要在哪个方向上堆叠 flex 项目。
  - column 值设置垂直堆叠 flex 项目（从上到下）
  - row 值水平堆叠 flex 项目（从左到右）
- flex-wrap属性规定是否应该对 flex 项目换行。
- flex-flow是用于同时设置 flex-direction 和 flex-wrap 属性的简写属性。
- justify-content用于对齐 flex 项目。
- align-items用于垂直对齐 flex 项目。
- align-content用于对齐弹性线。

用于弹性项目的属性有：

- order规定 flex 项目的顺序。
- flex-grow规定某个 flex 项目相对于其余 flex 项目将增长多少。





如果您**希望根据需要缩小图像，但需要杜绝放大到大于原始尺寸**，请添加如下代码：

#### 实例

img {

  max-width: 100%;

  height: auto;

}



### CSS @media 媒体查询（媒体查询的常见用法是创建弹性布局。）

#### 实例

```
/* 将 body 的背景色设置为棕褐色 */

body {
  background-color: tan;
}
/* 在小于或等于 992 像素的屏幕上，将背景色设置为蓝色 */

@media screen and (max-width: 992px) {
  body {
    background-color: blue;
  }
}
/* 在 600 像素或更小的屏幕上，将背景色设置为橄榄色 */

@media screen and (max-width: 600px) {
  body {
    background-color: olive;
  }
}
```

当达到条件时改变样式

在下面的例子中，我们使用逗号（类似 OR 运算符）将附加的媒体查询添加到已有媒体查询中：

#### 实例

```
/* 当宽度在 600 像素到 900 像素之间或大于 1100 像素时 - 更改 <div> 的外观 */
@media screen and (max-width: 900px) and (min-width: 600px), (min-width: 1100px) {
  div.example {
    font-size: 50px;
    padding: 50px;
    border: 8px solid black;
    background: yellow;
  }
}
```





### 响应式网页设计 - 视口

视口就是屏幕大小。通过meta标签设置视口

##### 设置视口

HTML5 引入了一种方法，使 Web 设计者可以通过 <meta> 标签来控制视口。

您应该在所有网页中包含以下 <meta> 视口元素：

```
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

它为浏览器提供了关于如何控制页面尺寸和缩放比例的指令。

width=device-width 部分将页面的宽度设置为跟随设备的屏幕宽度（视设备而定）。

当浏览器首次加载页面时，initial-scale=1.0 部分设置初始缩放级别。





### 构建响应式网格视图

让我们开始构建响应式网格视图。

首先，确保所有 HTML 元素的 box-sizing 属性设置为 border-box。这样可以确保元素的总宽度和高度中包括内边距（填充）和边框。

请在 CSS 中添加如下代码：

```
* {
  box-sizing: border-box;
}
.menu {
  width: 25%;
  float: left;
}
.main {
  width: 75%;
  float: left;
}
```

这就把页面分为两列，一列25%，一列75%



使用拥有 12 列的响应式网格视图，来更好地控制网页：

首先，我们必须计算一列的百分比：100% / 12 列 = 8.33%。

然后，我们为 12 列中的每一列创建一个类，即 class="col-" 和一个数字，该数字定义此节应跨越的列数：

```

.col-1 {width: 8.33%;}
.col-2 {width: 16.66%;}
.col-3 {width: 25%;}
.col-4 {width: 33.33%;}
.col-5 {width: 41.66%;}
.col-6 {width: 50%;}
.col-7 {width: 58.33%;}
.col-8 {width: 66.66%;}
.col-9 {width: 75%;}
.col-10 {width: 83.33%;}
.col-11 {width: 91.66%;}
.col-12 {width: 100%;}
[class*="col-"] {
  float: left;
  padding: 15px;
  border: 1px solid red;
}

/*当屏幕（浏览器窗口）小于 768px 时，每列的宽度应为 100％：(针对手机屏幕)*/
@media only screen and (max-width: 768px) {
  /* 针对手机： */
  [class*="col-"] {
    width: 100%;
  }
}
```

行内的所有列全部都向左浮动，因此会从页面流中移出，并将放置其他元素，就好像这些列不存在一样。为了防止这种情况，我们会添加清除流的样式：

```
.row::after {
  content: "";
  clear: both;
  display: table;
}
```

如果浏览器窗口是 600px 或更小，则背景颜色为浅蓝色：

```
@media only screen and (max-width: 600px) {
  body {
    background-color: lightblue;
  }
}
```





#### 始终移动优先设计

移动优先（Mobile First）指的是在对台式机或任何其他设备进行设计之前，优先针对移动设备进行设计（这将使页面在较小的设备上显示得更快）。

```
/* 针对手机： */
[class*="col-"] {
  width: 100%;
}

@media only screen and (min-width: 600px) {
  /* 针对平板电脑： */
  .col-s-1 {width: 8.33%;}
  .col-s-2 {width: 16.66%;}
  .col-s-3 {width: 25%;}
  .col-s-4 {width: 33.33%;}
  .col-s-5 {width: 41.66%;}
  .col-s-6 {width: 50%;}
  .col-s-7 {width: 58.33%;}
  .col-s-8 {width: 66.66%;}
  .col-s-9 {width: 75%;}
  .col-s-10 {width: 83.33%;}
  .col-s-11 {width: 91.66%;}
  .col-s-12 {width: 100%;}
}

@media only screen and (min-width: 768px) {
  /* 针对桌面： */
  .col-1 {width: 8.33%;}
  .col-2 {width: 16.66%;}
  .col-3 {width: 25%;}
  .col-4 {width: 33.33%;}
  .col-5 {width: 41.66%;}
  .col-6 {width: 50%;}
  .col-7 {width: 58.33%;}
  .col-8 {width: 66.66%;}
  .col-9 {width: 75%;}
  .col-10 {width: 83.33%;}
  .col-11 {width: 91.66%;}
  .col-12 {width: 100%;}
}
```





### 响应式图像

如果将 max-width 属性设置为 100％，则图像将按需缩小，但绝不会放大到大于其原始大小。

实例：

```
img {
  max-width: 100%;
  height: auto;
}
```

如果将 background-size 属性设置为 "contain"，则背景图像将缩放，并尝试匹配内容区域。不过图像将保持其长宽比（图像宽度与高度之间的比例关系）。

如果将 background-size 属性设置为 "100% 100%"，则背景图像将拉伸以覆盖整个内容区域。

如果 background-size 属性设置为 "cover"，则背景图像将缩放以覆盖整个内容区域。请注意，"cover" 值保持长宽比，且可能会裁剪背景图像的某部分。



可以使用媒体查询在不同的设备上显示不同的图像：

```
/* 针对小于 400 像素的宽度： */
body {
  background-image: url('img_smallflower.jpg'); 
}

/* 针对 400 像素或更大的宽度： */
@media only screen and (min-width: 400px) {
  body { 
    background-image: url('img_flowers.jpg'); 
  }
}
```





### CSS 网格布局模块

当 HTML 元素的 display 属性设置为 `grid` 或 `inline-grid` 时，它就会成为网格容器。

实例

```
.grid-container {
  display: grid;
}
```

可以通过使用以下属性之一来调整间隙（网格列grid-column，网格行grid-row）大小：

- grid-column-gap
- grid-row-gap
- grid-gap：50px 50px;//网格行间距50px，网格列间距50px;



![grid_lines](D:\studys\web\grid_lines.png)

**grid-column实例**

把网格项目放在列线 1，并在列线 3 结束它：

```
.item1 {
  grid-column-start: 1;
  grid-column-end: 3;
}
使 "item1" 从第 1 列开始并在第 5 列之前结束：
.item1 {
  grid-column: 1 / 5;
}
使 "item1" 从第 1 列开始，并跨越 3 列：
.item1 {
  grid-column: 1 / span 3;
}
```

**grid-column** 属性是 grid-column-start 和 grid-column-end 属性的简写属性。



**grid-row实例**

把网格项目放在行线 1，并在行线 3 结束它：

```
.item1 {
  grid-row-start: 1;
  grid-row-end: 3;
}
使 "item1" 在 row-line 1 开始，在 row-line 4 结束：
.item1 {
  grid-row: 1 / 4;
}
使 "item1" 从第 1 行开始并跨越 2 行：
.item1 {
  grid-row: 1 / span 2;
}
```

**grid-row** 属性是 grid-row-start 和 grid-row-end 属性的简写属性。





**grid-area** 属性可以用作 grid-row-start、grid-column-start、grid-row-end 和 grid-column-end 属性的简写属性。

```
使 "item8" 从 row-line 1 和 column-line 2 开始，在 row-line 5 和 column line 6 结束：
.item8 {
  grid-area: 1 / 2 / 5 / 6;
}
使 "item8" 从 row-line 2 和 column-line 开始，并跨越 2 行和 3 列：
.item8 {
  grid-area: 2 / 1 / span 2 / span 3;
}
```







**grid-template-rows** 属性定义每列的高度。

**grid-template-columns** 属性定义网格布局中的列数，并可定义每列的宽度,如果所有列都应当有相同的宽度，则设置为 "auto"。

**justify-content** 属性用于在容器内对齐整个网格。

**align-content** 属性用于垂直对齐容器内的整个网格。