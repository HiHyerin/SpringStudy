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
.row {
  width: 800px;
  margin: 0px auto;
}
h1{
  text-align: center;
}
#chatArea{
  height: 450px;
  overflow-y:auto; /* 스크롤바 */
  border:1px solid black; 
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
<script type="text/javascript">
let websocket;
let name;
function connection() // 연결
{
	 // websocket => 웹에서 연결이 되게 만드는 소프트웨어 
	 websocket=new WebSocket("ws://localhost:8080/web/site/chat/chat-ws");
	 websocket.onopen=onOpen;//callback(시스템 자동으로 호출)
	 websocket.onclose=onClose;
	 websocket.onmessage=onMessage;
	 name = $('#startBtn').attr("data-name")
}
function onOpen(event) // 연결되었을때 처리 
{
	 alert("채팅서버와 연결되었습니다!!");
}
function onClose(event) // 퇴장시 처리 
{
	 alert("채팅서버와 연결 종료되었습니다");
}
// roomin , makeroom , roomout
function onMessage(event) // 채팅 메세지 전송시 
{
	let data=event.data;
	if(data.substring(0,4)=="msg:")
	{
		appendMessage(data.substring(4));
	}
	
}
function disConnection() 
{
	//퇴장 버튼 클릭 
	websocket.close(); // onclose()
}
function send()
{
	let msg=$('#sendMsg').val();
	if(msg.trim()=="")
	{
		$('#sendMsg').focus();
		return;
	}
	
	websocket.send("msg:["+name+"]"+msg); // onMessage
	$('#sendMsg').val("");
	$('#sendMsg').focus();
}
function appendMessage(msg)// 채팅 문자열 추가
{
	$('#recvMsg').append(msg+"<br>");
	let ch=$('#chatArea').height();
    let m=$('#recvMsg').height()-ch;
	$('#chatArea').scrollTop(m);
}
$(function(){
	$('#startBtn').click(function(){
		connection();
	})
	
	$('#endBtn').click(function(){
		disConnection();
    })
    
    $('#sendBtn').click(function(){
	     send();
    })
    
    $('#sendMsg').keydown(function(key){
    	if(key.keyCode==13) /* 엔터치기 */
    	{
    	   send();	
    	}
    })
    
})
</script>
</head>
<body>
  <div class="container">
    <div class="row row1">
      <h1 class="text-center">WebSocket 채팅</h1>
      <table class="table">
       <tr>
        <td>
         <input type=button id="startBtn" value="입장" class="btn btn-sm btn-danger" data-name="${sessionScope.name }">
         <input type=button id="endBtn" value="퇴장" class="btn btn-sm btn-primary">
         <a href="../main/main.do" class="btn btn-sm btn-warning">메인</a>
        </td>
       </tr>
       <tr>
         <td>
	         <div id="chatArea">
	           <div id="recvMsg"></div>
	         </div>
         </td>
       </tr>
       <tr>
         <td>
           <input type="text" id="sendMsg" size=80 class="input-sm">
           <input type=button id="sendBtn" value="전송" class="btn btn-sm btn-success">
         </td>
       </tr>
      </table>
    </div>
  </div>
</body>
</html>