$(function() {

    var websocket;


    // 首先判断是否 支持 WebSocket
    var host = window.location.host;
    if('WebSocket' in window) {
        websocket = new WebSocket("ws://"+host+"/websocket");
    } else if('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://"+host+"/websocket");
    } else {
        websocket = new SockJS("http://"+host+"/sockjs/websocket");
    }

    // 打开时
    websocket.onopen = function(evnt) {
        console.log("  websocket.onopen  ");
    };


    // 处理消息时
    websocket.onmessage = function(evnt) {
        $("#msg").append("<p>" + evnt.data + "</p>");
        console.log("  websocket.onmessage   ");
    };


    websocket.onerror = function(evnt) {
        console.log("  websocket.onerror  ");
    };

    websocket.onclose = function(evnt) {
        console.log("  websocket.onclose  ");
    };


    // 点击了发送消息按钮的响应事件
    $("#TXBTN").click(function(){

        // 获取消息内容
        var text = $("#logPath").val();

        // 判断
        if(text == null || text == ""){
            alert(" content  can not empty!!");
            return false;
        }

        var msg = {
            msgContent: text,
            postsId: 1
        };

        // 发送消息
        websocket.send(JSON.stringify(msg));

    });


});