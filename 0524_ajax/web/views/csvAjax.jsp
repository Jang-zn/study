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
	<h2>csv 데이터</h2>
	<p>데이터를 구분자로 나눠서 표현한 문자열</p>
	<button id="btn">데이터 가져오기</button>
	<div id="container"></div>
	<script>
	$("#btn").click(e=>{
		$.ajax({
			url:"<%=request.getContextPath()%>/ajax/csvTest.do",
			dataType:"text",
			success:data=>{
				const table = $("<table>");
				const person=data.split("\n");
				for(let i=0;i<person.length;i++){
					let p = person[i].split(",");
					let tr=$("<tr>");
					let name=$("<td>").html(p[0]);
					let phone=$("<td>").html(p[1]);
					let img=$("<td>").append($("<img>").attr({
						"src":"<%=request.getContextPath()%>/resource/imgs/"+p[2],
						"width":"100px",
						"height":"100px"
					}));
					tr.append(name).append(phone).append(img);
					table.append(tr);
					$("#container").append(table);
				}
			}
		});
	});
		
	</script>
</body>
</html>