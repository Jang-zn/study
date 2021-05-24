<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> js를 이용한 ajax 통신</h2>
	<button onclick="ajaxTestGet();">get 통신</button>
	<button onclick="ajaxTestPost();">post 통신</button><br>
	<input type="text" id="name" placeholder="이름"><br>
	<input type="number" id="age" placeholder="나이">
	<div id="container">
	
	</div>
	<script>
		const ajaxTestGet = ()=>{
			/* 1. 통신을 위한 XMLHttpRequest 객체 생성 */
			const xhr = new XMLHttpRequest();
			/*open 함수로 요청방식 / 요청주소 / 동기, 비동기 설정  */
			/*얘는 주소값 안바뀌니까 get으로 보내도 알수가 없음  */
			xhr.open("get", "<%=request.getContextPath()%>/ajaxGetTest.do?name=장우영");
			/*2. 요청에 대한 서버 응답처리 함수 지정  
			  이벤트 방식으로 처리함 -> onreadystatechange 속성에 설정*/
			/* readyState : 전송상태 관리 (0~4) 4가 완료  
			   statust : 서버의 응답 결과 - 코드 :200 404 505 ...*/
			xhr.onreadystatechange=()=>{
				/* 서버로부터 응답을 받았을 때 처리되는 로직을 구현함 
				   status 변동이 있을때마다 실행됨
				   readyStatus 4 : 전송완료 / status 200 : 정상 작동*/
			 if(xhr.readyState==4){
				 if(xhr.status==200){
					 alert("전송완료");
					 /* 서버에서 응답된 데이터는 responseText 속성에 자동으로 저장됨 */
					 console.log(xhr.responseText);
					 document.getElementById("container").innerHTML=xhr.responseText;
				 }
			 }
			}
			/*3. 설정한대로 전송 요청 : send() */
			xhr.send();
		}
		
		const ajaxTestPost = ()=>{
			const xhr = new XMLHttpRequest();
			xhr.open("post", "<%=request.getContextPath()%>/ajaxGetTest.do");
			/* 원래는 post는 쿼리스트링으로 안보내지는데 이거 되네? */
			xhr.onreadystatechange=()=>{
			 if(xhr.readyState==4){
				 if(xhr.status==200){
					 alert("전송완료");
					 console.log(xhr.responseText);
					 document.getElementById("container").innerHTML=xhr.responseText;
				 }
			 }
			}
			/* 보낼 데이터 있으면 send 함수에 넣어서 보낸다 
			   전송전에 header의 Content-Type 변경 필요*/
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			const name = document.querySelector("#name").value;
			const age = document.querySelector("#age").value;
			xhr.send("name="+name+"&age="+age);
			
		}
		
		
	
	</script>
</body>
</html>