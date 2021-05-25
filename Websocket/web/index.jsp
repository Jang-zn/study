<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-3.6.0.min.js"></script>
</head>
<body>
	<input type="text" id="msg">
	<button id="sendmsg">전송</button>
	<div id="container"></div>
	<script>
		const socket=new WebSocket("ws://localhost:9090/<%=request.getContextPath()%>/chat");
		//주소작성 : ws://주소 (http)|| wss://주소 (https)
		
		//이벤트 속성 설정
		socket.onopen=(e)=>{
			alert("web socket 접속");
			console.log(e);
		}
		
		socket.onmessage=(e)=>{
			console.log(e);
		}
		
		socket.onclose=(e)=>{
			console.log(e);
		}
		
		$("#sendmsg").click(e=>{
			socket.send($("#msg").val());
		})
	</script>
</body>
</html>