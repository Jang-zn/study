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
	<h2>html파일 가져오기</h2>
	<button id="btn">가져오기</button>
	<div id="container"></div>
	<script>
		$("#btn").click(e=>{
			$.ajax({
				url:"<%=request.getContextPath()%>/ajax/htmltest.do",
				type:"get",
				dataType:"html",
				success:data=>{
					console.log(data);
					$("#container").html(data);
				}
				
			})
		});
	</script>
	
</body>
</html>