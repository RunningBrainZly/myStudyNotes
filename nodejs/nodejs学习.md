# nodejs学习

​	在文件夹中按住shift再鼠标右击，可以直接进入当前文件夹的命令行



###  下载

​	下载好后就带有npm

​	下载cnpm命令

```
npm install -g cnpm --registry=https://registry.npm.taobao.org
```

![1642246742270](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1642246742270.png)



​	-g全局安装  

​	--save本地安装

###  核心模块

​	引入 const  fs = require("fs");

​	操作文件模块 fs

​	操作路径模块path,使用path.join(路径，路径，路径)  拼接

​	搭建静态服务器模块http

![1642305657113](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1642305657113.png)

 

###  下载koa框架

​	koa中的use方法，可以引入中间插件，插件即是一个里面有方法的函数（在响应之前执行）

​	cnpm install --save koa   (--save是在当前项目下载，不是全局)

​	cnpm install nodemon   (node后台热更新) 

​	cnpm install --save koa-router

​	![1642307119782](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1642307119782.png)

​	



​	_ _dirname是node的全局变量通过__dirname可以获取到当前项目的绝对路径

​	cnpm install --save koa-static

![1642308135508](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1642308135508.png)

​	

![1642247352128](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1642247352128.png)



![1642247506166](C:\Users\ZLY\AppData\Roaming\Typora\typora-user-images\1642247506166.png)