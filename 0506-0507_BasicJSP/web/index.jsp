
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 위에 있는 내용 없으면 jsp가 아니라 그냥 html임; --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hi, this is my first JSP page</h1>
	<p> JSP Elements는 html문서에 자바 코드를 사용할 수 있게 만들어주는 태그임</p>
	<h2> &lt;%  %&gt; : Scriptlet Tag</h2>
	<p> 태그에 %가 붙으면 자바코드로 해석함</p>
	<p> 기본 코드 작성시 Scriptlet tag 사용 : 메소드 내부에서 사용하는 코드 다 사용 가능</p>
	<h2>&lt;%!  %&gt; : 선언문(Declaration tag) : 클래스 선언부{}라고 보면 됨. 멤버변수, 생성자, 메소드정의..</h2>
	<br><br><hr>
	<h2>선언문(Declaration) 태그 사용</h2>
	<%!
		//멤버변수 선언
		private String name = "장우영";
		//메소드 선언
		public String printTest(){
			return "쉬는시간";
		};
	%>
	<%-- 선언문에 선언해놓은건 Scriptlet에서 갖다 쓰거나 <%= %> 이용해서 가져와야됨 --%>
	<h2> 이름 : <%=name%></h2> <%-- <%= %>태그가 PrintWirter의 write, print 역할임  --%>
	<h3> msg : <%=printTest()%></h3>
	<br><br><hr>
	<h2>Scriptlet Tag 이용</h2>
	<%
		String address = "신길동";
	if(name.equals("장우영")){
		System.out.println("dddddd");
		
	}
	for(int i=0;i<10;i++){
		System.out.println(i);
	}
	System.out.println(printTest());
	String[] dinner = {"라면","컵라면","비빔면","짜파게티"};
	%>
	<br><br><hr>
	<h2>페이지 출력시 JSP태그 이용</h2>
	<% if(name.equals("장우영")){ %>
	 	<h2> 대기업 가려면 공부해야지?</h2>		
	<%}else{%>
		<h2> else문 걍 출력해봄</h2>
	<%} %>
	<h3>저녁 메뉴 </h3>
	<ul>
		<% for(String i:dinner){ %>
			<li><%=  i %></li>
		<%} %>
	</ul>
	<br><hr>
	<h2>내장객체 활용</h2>
	<p> Scriptlet 내부에서 활용</p>
	<%
		String[] hobby = (String[])request.getAttribute("hobby");
		session.setAttribute("userId", "admin");
		application.setAttribute("email", "asd@asd.com");
		//걍 다 갖다 쓸수 있다.
	%>
	<h3>request : <%= request %></h3>
	<h3>session : <%= session %></h3>
	<h3>application : <%= application %></h3>
	
	
	<h4><a href="views/innerObj.jsp">내장객체 확인</a></h4>
	<h4>반환된 내장객체 데이터 출력</h4>
	<ul>
		<li> request : <%= request.getAttribute("request") %></li>
		<li> session : <%= session.getAttribute("session") %></li>
		<li> application : <%= application.getAttribute("application") %></li>
	</ul>
	<h3> 취미 </h3>
	<ul>
	<% if(hobby!=null){ %>
		<% for(String i : hobby){ %>
		<li><%= i %></li>
		<%}
	}%>
	</ul>	
	
	<br><br><hr>
	<h2> jsp로 controller(servlet) 기능 하기</h2>
	<h3><a href="<%=request.getContextPath()%>/views/memberSearch.jsp">회원조회</a></h3>
	
	<h2> 지시자 page 이용</h2>
	<p> jsp 파일에 대한 설정 태그 / 파일 첫줄에 선언됨 : language / contentType / pageEncoding 세개는 기본</p>
	<ul>
	<li>import : 페이지에 다른 패키지 클래스를 가져올 때 사용 (import="")<br>
	<h3><a href="<%= request.getContextPath() %>/views/importTest.jsp"> import</a></h3>
	</li>
	<li>에러페이지 이동 : 에러코드에 의한 에러(404, 500, 403,...) / Exception에 의한 에러(500) 두가지 방법 있음<br>
		1. web.xml 태그 이용<br>
		2. jsp 지시자 태그 : errorPage 속성 이용<br>
		<a href="<%= request.getContextPath() %>/views/errorTest.jsp">errorPage</a></li>
		
	<li>※ 에러페이지 안만들면 오류창에서 내부Code 다 띄워주니까 꼭 만들어줘야됨 <a href="ddd.jsp">404</a></li>
	</ul>
	<br><br><hr>
	<h2> include 지시자 이용</h2>
	<p> 외부로부터 jsp파일(page)을 가져와서 쓰는것</p>
	<h3> <a href="<%=request.getContextPath() %>/views/main.jsp">메인으로</a></h3>
		
	
</body>
</html>