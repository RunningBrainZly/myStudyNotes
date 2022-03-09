const fs = require("fs");

	fs.readFile("hello.txt",(err,data) => {
		if(err){
			console.log(err);
		}
		console.log(data.toString());
	})