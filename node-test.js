console = {};
console.log = print;
console.log("Before setTimeout");
setTimeout(function(){
	console.log("Hello ... ");
},5000);
console.log("After setTimeout");

