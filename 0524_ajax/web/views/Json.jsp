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
	<h2>JSON 이용</h2>
	<button id="getPerson">실행하기</button>
	<div id="container"></div>
	<input type="text" id="id"><button id="userId">찾기</button>
	<script>
	$("#getPerson").click(e=>{
		$.ajax({
			url:"<%=request.getContextPath()%>/ajax/jsonTest.do",
			dataType:"json",
			success:data=>{
				const ul = $("<ul>");
				const li1 = $("<li>").html(data["name"]);
				const li2 = $("<li>").html(data["phone"]);
				const li3 = $("<li>").html(data["profile"]);
				const li4 = $("<li>").html(data["age"]);
				const li5 = $("<li>").html(data["height"]);
				ul.append(li1).append(li2).append(li3).append(li4).append(li5)
				$("#container").after(ul);
			},
		});
	});
	$("#userId").click(e=>{
		$.ajax({
			url:"<%=request.getContextPath()%>/ajax/searchId",
			data:{keyword:$("#id").val()},
			success:data=>{
				console.log(data);
				const table=$("<table>");
				const head=$("<tr>").html("<th>아이디</th><th>이름</th><th>성별</th><th>나이</th><th>이메일</th>");
				
				/* let body=$("<tr>");
				let id = $("<td>").html(data["userId"]);
				let name = $("<td>").html(data["userName"]);
				let gender = $("<td>").html(data["gender"]);
				let age = $("<td>").html(data["age"]);
				let email = $("<td>").html(data["email"]);
				body.append(id).append(name).append(gender).append(age).append(email); */
				
				table.append(head);
				$.each(data,(i,v)=>{
					let body=$("<tr>");
					let id = $("<td>").html(v["userId"]);
					let name = $("<td>").html(v["userName"]);
					let gender = $("<td>").html(v["gender"]);
					let age = $("<td>").html(v["age"]);
					let email = $("<td>").html(v["email"]);
					body.append(id).append(name).append(gender).append(age).append(email);
					table.append(body);
				});
				$("#container").html(table);
			}
		});
	});
	
	</script>
</body>
</html>