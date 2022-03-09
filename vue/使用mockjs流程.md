###	使用mockjs流程

1.安装mockjs

npm install mockjs --save



2.创建一个测试数据的js文件，里面写你要测试的数据

例如：

```
import mock from 'mockjs'
//获取随机对象
const Random = mock.Random;
// mock一组数据
const testData = function() {
  let articles = [];
  for (let i = 0; i < 100; i++) {
    let newArticleObject = {
      title: Random.csentence(5, 30), //  Random.csentence( min, max )
      thumbnail_pic_s: Random.dataImage('300x250', 'mock的图片'), // Random.dataImage( size, text ) 生成一段随机的 Base64 图片编码
      author_name: Random.cname(), // Random.cname() 随机生成一个常见的中文姓名
      date: Random.date() + ' ' + Random.time() // Random.date()指示生成的日期字符串的格式,默认为yyyy-MM-dd；Random.time() 返回一个随机的时间字符串
    }
    articles.push(newArticleObject)
  }
  return articles;
}

// Mock.mock( url, post/get , 返回的数据)；
mock.mock('/news/index', 'get', testData);
```



### 常用的MOCK占位符

占用符 解释

Random.cname() 中文人名

Random.id() 身份证id

Random.title() 中文title

Random.city() 中文城市

Random.ip() ip 地址

Random.email() email

Random.url() url地址

Random.csentence(1,5) 生成1到5个字的中文句子

Random.cparagraph() 生成中文段落

Random.string(11) 输出11 个字符长度的字符串

Random.float(0,10) 0 到 10 的浮点数

Random.integer(60,70) 60 到 70 之间的整数

Random.boolean() boolean 类型 true,false

Random.dataImage() 一个随机图片地址  //里面可以传size  长x高



3.使用axios请求数据

没有axios的先安装axios    npm insatll axios --save



#####	这里要注意在哪使用测试数据和axios 先要把这个测试数据的js文件和axios导入到哪里

new axios({

​	method:'get',

​	url:'上面的路径'

}).then(res => {

​	console.log(res)

})





使用mockjs无法根据你传的url获取？后面的值，做不到动态返回数据。