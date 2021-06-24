<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.action.model.vo.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = "게으름";
		int age = 7;
		request.setAttribute("name",name);
		request.setAttribute("age",age);
		Person p = new Person("장우영","서울",30);
		application.setAttribute("p",p);
		java.util.List<String> list = java.util.List.of("가","나","다","라","마");
		request.setAttribute("list",list);
	%>
	<h3> EL 기본출력</h3>
	<p>EL 출력시 data는 내장객체에 포함되어있어야 한다</p>
	<p>그냥 페이지에 선언된건 출력 안됨</p>
	<h3>${name}, ${age}</h3>
	<h3>${p}</h3>
	<ul>객체의 멤버변수 접근
		<li>${p.getName() }</li>
		<li>${p.name}</li><!-- 이렇게 접근하면 알아서 getter 써서 가져옴 -->
		<li>${p.addr }</li>
		<li>${p.age }</li>
		<li></li>
	</ul>
	<ul>
		<li>list size : ${list.size() }</li>
		<li>list value : ${list.get(0) }</li>
		<li>list value length: ${list.get(0).length() }</li>
	</ul>
	<br>
	<%
		request.setAttribute("a",10);
		request.setAttribute("b",11);
	
	%>
	<h3>EL 연산처리</h3>
	<ul>
		<li>a+b = ${a+b }</li>
		<li>a-b = ${a-b }</li>
		<li>a*b = ${a*b }</li>
		<li>a/b = ${a/b } = ${a div b }</li>
		<li>a%b = ${a%b }</li>
		<li>a+b*20 = ${a+b*20}</li>
		<li>(a+b)*20 = ${(a+b)*20}</li>
	</ul>
	<br>
	<h3>비교/동등/부정연산/논리연산</h3>
	<ul>
		<li>a&lt;b = ${a<b} = ${a lt b}</li>
		<li>a&gt;b = ${a>b} = ${a gt b}</li>
		<li>a&lt;=b = ${a<=b} = ${a le b}</li>
		<li>a&gt;=b = ${a>=b} = ${a ge b}</li>
		<li>가==list.get(0) = ${"가"==list.get(0)} = ${"가" eq list.get(0)}</li><!-- ==으로 문자열 비교 됨 -->
		<li>나!=list.get(0) = ${"나"!=list.get(0)} = ${"나" ne list.get(0)}</li>
		<li>"장우영".contains("장") : ${"장우영".contains("장") }</li>
		<li>list.isEmpty : ${list.isEmpty() } = ${empty list }</li>
	</ul>
	<br>
	<h3>삼항연산자</h3>
	<p>${list.get(1) eq "나" ?"T":"F"}</p>
	<select name="test">
		<option value="귀신">귀신</option>
		<option value="도깨비">도깨비</option>
		<option value="유령" ${list.get(0) eq "가"? "selected":"" }>유령</option>
		<option value="악마">악마</option>
	</select>
	
	<h3>서블릿 저장내용 출력</h3>
	<a href="<%=request.getContextPath() %>/basicEl">서블릿에서 저장</a>
	<a href="${pageContext.request.contextPath }/basicEl">서블릿에서 저장</a><!-- contextPath 이렇게 쓸 수 있다 -->
	<br><br>
	<h3> 파라미터값 전송</h3>
	<form action="${pageContext.request.contextPath }/basicEl">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		취미<br>
		<input type="checkbox" name="hobby" value="게임"> 게임<br>
		<input type="checkbox" name="hobby" value="운동"> 운동<br>
		<input type="checkbox" name="hobby" value="잠"> 잠<br>
		<input type="submit" value="등록">
	</form>
	<br><br>
	<h3>추가 객체 이용 (cookie / header ...)</h3>
	<a href="${pageContext.request.contextPath}/extraData">추가 객체 이용</a>
	<br><br>
	<h3>requestHeader Data 가져오기</h3>
	<h4>${header["User-Agent"]}</h4>
	<h4>이전 페이지(Referer) : ${header["Referer"]}</h4>
</body>
</html>