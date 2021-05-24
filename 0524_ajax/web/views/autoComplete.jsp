<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src = "jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>이름검색 자동완성 기능</h2>
	<input type="text" id="nameSearch" name="nameSearch" list="list">
	<datalist id="list">
		
	</datalist>
	
</body>
<script>
	$("#nameSearch").keyup(e=>{
		$.ajax({
			url:"<%=request.getContextPath()%>/ajax/autoComplete.do",
			data:{"keyword":$(e.target).val()},
			success:data=>{
				$("#list").html("");
				const op = data.split(",");
				for(let i=0;i<op.length;i++){
					let option=$("<option>");
					option.val(op[i]);
					option.html(op[i]);
					$("#list").append(option);
				}
			}
		});
	});		
</script>
</html>