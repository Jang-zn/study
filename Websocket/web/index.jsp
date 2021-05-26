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
	보내는 사람<input type="text" id="sendman" size="8"><br>
	받는 사람<input type="text" id="receiveman" size="8"><br>
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
			if($("#sendman").val()==data[0]){
				tag = $("<p>").text(data[0]+" : "+data[2]).css({
					"text-align":"right",
					"background-color":"yellowgreen"
				}); //jsp는 `` 안먹음..	
			}else{
				tag = $("<p>").text(data[0]+" : "+data[2]).css({
					"text-align":"left",
						"background-color":"gold"
				}); //jsp는 `` 안먹음..
			}
			
			$("#container").append(tag);
		}
		
		socket.onclose=(e)=>{
			console.log(e);
		}
		
		$("#sendmsg").click(e=>{
			const msg = new Message($("#sendman").val(),$("#receiveman").val(),$("#msg").val())
			socket.send(msg);
		})
		
		//생성자 함수 : 함수를 java class 생성자처럼 만들어서 갖다 쓰는것
		function Message(sender, receiver, msg){
			this.sender=sender;
			this.receiver=receiver;
			this.msg=msg;
		}
	</script>
</body>
</html>