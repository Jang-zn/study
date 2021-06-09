<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "jquery-3.6.0.min.js"></script>
</head>
<body>
	<h2> jquery 방식 ajax 처리</h2>
	<button id="btn-ajax">실행</button>
	<button id="btn">servlet 호출</button>
	<div id="container"></div>
	<script>
		$("#btn").click(e=>{
			$.ajax({
				url:"<%=request.getContextPath()%>/ajaxGetTest.do",
				data:{name:"장우영", age:20},
				success:data=>{
					console.log(data);
					$("#container").html(data);
				}
			})
		})
	
	
		$("#btn-ajax").click(e=>{
			$.ajax({
				/*속성 설정  */
				url:"sample.txt",   /* 불러올 file명을 적는다. */ 
				type:"get",
				//data:             /* 서버에 전송할 데이터 (객체형식 {key:value, ...})  */
				dataType:"text",    /* 응답받는 데이터 형식 지정 : text, html, json, xml.. 안쓰면 자동으로 js가 처리*/
				success:data=>{     /* 통신 정상완료시의 로직 지정 (함수), 매개변수는 서버에서 응답한 데이터  */
					console.log("완료");
				},
				error:(r,m,s)=>{	/* 에러발생시 로직 매개변수 3개 필요 근데 안써도 됨 */
					console.log(r,m,s);
				}
				//complete:()=>{}	/* finally같은거임 */
			})
		})
	
	</script>
</body>
</html>