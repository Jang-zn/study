<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="today" value="<%=new java.util.Date() %>"/>
	<c:out value="${today }"/>
	<h2>날짜 표현</h2>
	<p>
		fmt:formatDate 태그 이용<br>
		type : date(날짜), time(시간), both(둘다)<br>
	</p>
	<h3>시간 출력</h3>
	<h4>기본 : <fmt:formatDate type="time" value="${today }"/></h4>
	<h3>날짜 출력</h3>
	<h4>기본 : <fmt:formatDate type="date" value="${today }"/></h4>
	<h3>둘다 출력</h3>
	<h4>기본 : <fmt:formatDate type="both" value="${today }"/></h4>
	<hr>
	<h2>정해진 패턴으로 출력</h2>
	<p>dateStyle 속성 이용 : default, short, long, full</p>
	<h3>default</h3>
	<h4><fmt:formatDate value="${today }" dateStyle="default"/></h4>
	<h3>short - 연도가 2자리 표기됨</h3>
	<h4><fmt:formatDate value="${today }" dateStyle="short"/></h4>
	<h3>long - 연/월/일 표시해줌</h3>
	<h4><fmt:formatDate value="${today }" dateStyle="long"/></h4>
	<h3>full - 연/월/일/요일 표시</h3>
	<h4><fmt:formatDate value="${today }" dateStyle="full"/></h4>
	<hr>
	<h2>시간 패턴 출력</h2>
	<p>timeStyle 속성 이용 : short, medium, long, full</p>
	<h3>short - 시/분</h3>
	<h4><fmt:formatDate value="${today }" timeStyle="short" type="time"/></h4>
	<h3>medium - 시/분/초</h3>
	<h4><fmt:formatDate value="${today }" timeStyle="medium" type="time"/></h4>
	<h3>long - 시/분/초 locale</h3>
	<h4><fmt:formatDate value="${today }" timeStyle="long" type="time"/></h4>
	<h3>full - 시/분/초 locale</h3>
	<h4><fmt:formatDate value="${today }" timeStyle="full" type="time"/></h4>
	<hr>
	<h2>같이 출력 - type=both</h2>
	<h3>short short</h3>
	<h4><fmt:formatDate value="${today }" dateStyle="short" timeStyle="short" type="both"/></h4>
	<h3>short medium</h3>
	<h4><fmt:formatDate value="${today }" dateStyle="short" timeStyle="medium" type="both"/></h4>
	<h3>long long</h3>
	<h4><fmt:formatDate value="${today }" dateStyle="long" timeStyle="long" type="both"/></h4>
	<h3>full full</h3>
	<h4><fmt:formatDate value="${today }" dateStyle="full" timeStyle="full" type="both"/></h4>
	<hr>
	<h2>패턴으로 날짜표현</h2>
	<p>
		SimpleDateFormat에서 사용한거랑 똑같음<br>
		pattern 속성에 주면 됨<br>
		yyyy / MM / dd E요일,  hh :mm:ss:sss 
	</p>
	<h3>pattern : yy/MM/dd E</h3>
	<h4><fmt:formatDate value="${today }" pattern="yy/MM/dd E"/></h4>
	<h3>pattern : hh:mm:ss</h3>
	<h4><fmt:formatDate value="${today }" pattern="hh:mm:ss"/></h4>
	<hr>
	<h2>timezone 설정</h2>
	<p>
		<fmt:timeZone value="GMT">
			런던 : <fmt:formatDate value="${today }" type="time" timeStyle="full"/>
		</fmt:timeZone><br>
		<fmt:timeZone value="GMT+9">
			서울 : <fmt:formatDate value="${today }" type="time" timeStyle="full"/>
		</fmt:timeZone><br>
		<fmt:timeZone value="GMT+18">
			워싱턴? : <fmt:formatDate value="${today }" type="time" timeStyle="full"/>
		</fmt:timeZone>
	</p>
	<hr>
	<h2>locale 변경 : setLocale</h2>
	<fmt:setLocale value="ja_JP"/>
	<fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full"/>
	<h3> type:currency : <fmt:formatNumber value="1000000" type="currency"/></h3>
	<fmt:setLocale value="en_US"/>
	<fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full"/>
	<h3> type:currency : <fmt:formatNumber value="1000000" type="currency"/></h3>
	<fmt:setLocale value="sv_SE"/>
	<fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full"/>
	<h3> type:currency : <fmt:formatNumber value="1000000" type="currency"/></h3>
</body>
</html>