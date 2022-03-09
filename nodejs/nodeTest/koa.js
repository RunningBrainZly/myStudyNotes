//引入的是koa的构造函数，要通过new来创建实例
const Koa = require("koa");
//引入路由，实现通过url来访问指定的网页
//koa-router 引入是一个函数，我们需要再调用一次这个函数
const router = require("koa-router")();
const static = require("koa-static");
const views = require("koa-views");
const nunjuncks = require("koa-nunjuncks")
const app = new Koa();


app.use(static(__dirname + "/static"))
app.use(router.routes());
// app.use(async (ctx) => {
// 	ctx.body = "hello koa!"
// })

router.get("/",async (ctx) => {
	ctx.body = "home page"
})

router.get("/doc", async (ctx) => {
	ctx.body = `
		<head>
			<link rel="stylesheet" href="/css/base.css">
		</head>
		<h1>标题</h1>
		<p>段落</p>
		<img src="/image/image.jpg" alt="">
		
	`
})

app.listen(3000,() => {
	console.log("server is running!")
});