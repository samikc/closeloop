var fileIO = Java.type("org.wingsource.closeloop.fs.FileIO");
var fs = fs || {};

fs.readFile = function(fileName, callback) {
    fileIO.read(fileName,{"call":callback});
};
