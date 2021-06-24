<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- id는 변수명이라고 생각하면 됨 set 해준 키값 넣어줘도 됨-->
<jsp:useBean id="p" class="com.action.model.vo.Person" scope="request"/>
<jsp:getProperty name="p" property="name"/>
<jsp:getProperty name="p" property="addr"/>
<jsp:getProperty name="p" property="age"/>
<br>
<jsp:useBean id="p2" class="com.action.model.vo.Person" scope="request"/>
<jsp:setProperty name="p2" property="name" value="장우영2"/>
<jsp:setProperty name="p2" property="addr" value="서울"/>
<jsp:setProperty name="p2" property="age" value="29"/>
<jsp:getProperty name="p2" property="name"/>
<jsp:getProperty name="p2" property="addr"/>
<jsp:getProperty name="p2" property="age"/>

<jsp:useBean id="p3" class="com.action.model.vo.Person" scope="request"/>
<jsp:setProperty name="p3" property="name" param="name"/>
<jsp:setProperty name="p3" property="addr" param="addr"/>
<jsp:setProperty name="p3" property="age" param="age"/><br>
이름 :<jsp:getProperty name="p3" property="name"/><br>
주소 : <jsp:getProperty name="p3" property="addr"/><br>
나이 : <jsp:getProperty name="p3" property="age"/> 


</body>
</html>