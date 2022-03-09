把项目打包成war包放在服务器配置好的tomcat下webapps文件夹下（配置tomcat下载后加环境变量，然后打开bin目录下的startup.bat文件，不闪退就成功，闪退了找错）
服务器配置tomcat会出现的问题解决方法
闪退
1 先在编辑startup.bat 加上pause让它暂停看哪里出问题
2 看环境变量配置了没
3 更改bin目录中setclasspath.bat中的java home 和java jre （看看地址是不是你jdk中两个文件的地址）
4 更改conf目录中server.xml中的端口号 8080改成8081或者其他端口号（更改端口号后外部访问就要用 ip地址：端口号/项目名）

<Connector port="8080" protocol="HTTP/1.1"
​               connectionTimeout="20000"
​               redirectPort="8443" />（8080改成其他没有被占用的端口号）

最后应该就能打开startup.bat文件了
打开后在服务器上输入localhost:端口号  就会出现tomcat页面
最后在外部访问要把防火墙配置一下，要配置通过端口号（阿里云的要在阿里云的网站配置，先把80端口开放，80是http端口）
最后就能在外部访问项目了