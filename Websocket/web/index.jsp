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
	<input type="text" id="nick" size="8">
	<input type="text" id="msg">
	<button id="sendmsg">전송</button>
	<div id="container"></div>
	<script>
		const socket=new WebSocket("ws://localhost:9090/<%=request.getContextPath()%>/chat");
		//주소작성 : ws://주소 (http)|| wss://주소 (https)
		
		//이벤트 속성 설정
		socket.onopen=(e)=>{
			console.log(e);
		}
		
		socket.onmessage=(e)=>{
			let data = e.data.split(",");
			let tag="";
			if($("#nick").val()==data[0]){
				tag = $("<p>").text(data[0]+" : "+data[1]).css({
					"text-align":"left"
				}); //jsp는 `` 안먹음..	
			}else{
				tag = $("<p>").text(data[0]+" : "+data[1]).css({
					"text-align":"right"
				}); //jsp는 `` 안먹음..
			}
			
			$("#container").append(tag);
		}
		
		socket.onclose=(e)=>{
			console.log(e);
		}
		
		$("#sendmsg").click(e=>{
			socket.send($("#nick").val()+","+$("#msg").val());
		})
	</script>
</body>
</html>