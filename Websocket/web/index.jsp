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
			/* let data = e.data.split(",");  Gson 쓰면 스플릿 불필요*/
			//js 객체 형식으로 넘어온 문자열은 객체로 변환 가능
			console.log(JSON.parse(e.data));
			const jdata = JSON.parse(e.data);
			let tag="";
			if($("#sendman").val()==jdata.sender){
				tag = $("<p>").text(jdata.sender+" : "+jdata.msg).css({
					"text-align":"right",
					"background-color":"yellowgreen"
				}); //jsp는 `` 안먹음..	
			}else{
				tag = $("<p>").text(jdata.sender+" : "+jdata.msg).css({
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
			const sendmsg = new Message($("#sendman").val(),$("#receiveman").val(),$("#msg").val())
			socket.send(JSON.stringify(sendmsg)); 
			//JSON.stringify() 하면 생성자함수로 생성된 객체가 {키:밸류,....}형식의 String으로 보내짐
			//서버에서 GSON으로 자동 parsing 가능 (생성자 함수와 같은 class를 만들어놓으면 거기다 저장해버릴수 있음)
		});
		
		//생성자 함수 : 함수를 java class 생성자처럼 만들어서 갖다 쓰는것
		function Message(sender, receiver, msg){
			this.sender=sender;
			this.receiver=receiver;
			this.msg=msg;
		}
	</script>
</body>
</html>