const http = require("http");
const server = http.createServer((req,res) => {
	res.end("hello node!");
});
//端口号3000
server.listen(3000,() =>{
	console.log("server is running");
})