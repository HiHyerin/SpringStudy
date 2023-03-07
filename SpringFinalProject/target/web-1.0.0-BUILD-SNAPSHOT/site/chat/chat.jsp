<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}

.row{
	width: 800px;
	margin: 0px auto;
}

.h1{
	text-align: center;
}

#chatArea{
	height: 450px;
	overflow-y:auto;
	border: 1px solid black; 
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script type="text/javascript">
let websocket;
function connection(){
	// 웹소켓 생성
	websocket = new WebSocket("ws://localhost:8080/site/chat/chat-ws")
	websocket.onopen = onOpen;
	websocket.onclose = onClose;
	websocket.onmessage = onMessage;
	
}
function onOpen(event){
	alert("채팅 서버에 접속되었습니다.!")
}
function onClose(event){
	alert("채팅 서버와 연결 종료되었습니다.!")
}
function onMessage(event){
	let data = event.data;
	if(data.substring(0,4)=="msg:"){ // 
		appendMessage(data.substring(4));
	}
}
function disConnection(){
	websocket.close();
}
// 서버로 채팅 문자열 전송
function send(){
	let msg = $('#sendMsg').val()
	if(msg.trim()==""){
		$('#sendMsg').focus();
		return
	}
	// 서버로 전송
	websocket.send("msg:"+msg); // onMessage
	$('#sendMsg').val("");
	$('#sendMsg').focus();
}
// 서버로부터 채팅 문자열을 받았을 때 처리
function appendMessage(msg){
	$('#recvMsg').append(msg+"<br>")
	let ch = $('#chatArea').height()
	let m = $('#recvMsg').height()-ch;
	$('#chatArea').scrollTop(m);
}

// 제어
$(function(){
	$('#startBtn').click(function(){
		
	})
	$('#endBtn').click(function(){
		
	})
	$('#sendBtn').click(function(){
		
	})
	$('#sendMsg').click(function(key){ /* 채팅치고 엔터(keycode==13) 쳤을 때 보내라는 의미 */
		if(key.keyCode==13){
			send()
		}
	})
})
</script>
</head>
<body>
	<div class="container">
	  <h1>WebSocket 채팅</h1>
	  <div class="row">
	  	<table class="table">
	  	  <tr>
	  	  	<td class="text-right">
	  	  		<input type="button" id="startBtn" value="입장" class="btn btn-sm btn-danger">
	  	  		<input type="button" id="endBtn" value="퇴장" class="btn btn-sm btn-primary">
	  	  		<a href="../main/main.do" class="btn btn-sm btn-warning">메인</a>
	  	  	</td>
	  	  </tr>
	  	  <tr>
	  	  	<td>
	  	  	  <div id="chatArea">
	  	  	  	<div id="recvMsg"> <!-- 채팅영역 -->
	  	  	  	
	  	  	  	</div>
	  	  	  </div>
	  	  	</td>
	  	  </tr>
	  	  <tr>
	  	  	<td>
	  	  		<input type="text" id="sendMsg" size=80 class="input-sm">
	  	  		<input type="button" id="sendBtn" vlaue="전송" class="btn btn-sm btn-success">
	  	  	</td>
	  	  </tr>
	  	</table>
	  </div>
	</div>
</body>
</html>