/**
 * Created by sa on 16-06-2014.
 */

var h = Java.type("org.wingsource.closeloop.http.HttpServer");
var http = http || {};
http.createServer = function(port,func) {
    h.create(port,{"func":func});
};
