// ----------------------------------------------------------------------
// fake required browser elements

global.XMLHttpRequest = {
    prototype: {
        ajax$core$AjaxImpl$: false,
    }
};
global.React = require("./server_out/react.inc.js");
global.window = {
    attachEvent: function (eventName, callback) {
        return {
            pathname: "/"
        };
    },
    location: {
        pathname: "/"
    }
};
global.document = {
    attachEvent: function (eventName, callback) {
        return {
            pathname: "/"
        };
    },
    location: {
        pathname: "/"
    }
};

require("./server_out/goog/bootstrap/nodejs.js");
require("./server_out/todo_server.js");

goog.require("server.core");
goog.require("cljs.nodejscli");