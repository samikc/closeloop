require("fun1");
print("Hello world!!!");
require("fs");
var callback1 = function(error,data) {
    if (error) {
        print(error.message);
    }
    print(data.toString());
};

//fs.readFile("hello.txt", "callback" );
fs.readFile("hi.txt",function(error,data) {
    if (error) {
        print(error.message);
    }
    print(data.toString());
});
hello(" AFTER FIRST FS CALL world");
fs.readFile("hello.txt",function(error,data) {
    if (error) {
        print(error.message);
    }
    print(data.toString());
});

fs.readFile("hi123.txt",function(error,data) {
    if (error) {
        print(error);
    }
    print(data.toString());
});


fs.readFile("hi.txt", callback1 );

print("I am done testing");

print("Do start a server ... ");
require("http");
http.createServer("9090", function(req,res) {
    var body = res.getPrintStream();
    res.setValue("Content-Type", "text/plain");
    body.println("Hello World");
    body.close();
});

http.createServer("9191", function(req,res) {
    var body = res.getPrintStream();
    res.setValue("Content-Type", "text/plain");
    body.println("Hello World - once more");
    body.close();
});
