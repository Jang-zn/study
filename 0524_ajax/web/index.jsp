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
	<script>
		const ajaxTextGet = ()=>{
			/* 1. 통신을 위한 XMLHttpRequest 객체 생성 */
			const xhr = new XMLHttpRequest();
			/*open 함수로 요청방식 / 요청주소 / 동기, 비동기 설정  */
			xhr.open("get", "<%=request.getContextPath()%>/ajaxGetTest.do");
			/*2. 요청에 대한 서버 응답처리 함수 지정  
			  이벤트 방식으로 처리함*/
			
			
			
		}
		
	
	</script>
</body>
</html>