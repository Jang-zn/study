<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
	#container{
		width:200px;
		height:200px;
		border:1px solid red;
		background-color:lightblue;
	}
	
</style>

<%-- <%-- <%@ include file="header.jsp" %> --%>
<%-- <jsp:include page="header.jsp"/> --%> <!-- 끝에 / 꼭 해줘야됨 -->

<!-- 아니면 이런식으로 -->
<jsp:include page="header.jsp">
	<jsp:param name="title" value="include page"/>
	
</jsp:include>

<section>
	<h2>본문</h2>
	<div id="container">
		<h3></h3>
	</div>
</section>


</body>
</html>