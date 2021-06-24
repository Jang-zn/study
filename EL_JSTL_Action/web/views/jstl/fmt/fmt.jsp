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
	<h2>기본 숫자 표현</h2>
	<c:set var="numtest1" value="123456789.12345"/>
	<c:set var="numtest2" value="987654321.54321"/>
	<c:set var="numtest3" value="1"/>
	<c:set var="numtest4" value="123.56789"/>
	<h3> 출력 : ${numtest1}</h3>
	<h3> 출력 : <c:out value="${numtest1}"/></h3>
	<hr>
	<h2>fmt:formatNumber 이용</h2>
	<h3>fmt : <fmt:formatNumber value="${numtest1}"/></h3>
	<h3> groupingUsed:false : <fmt:formatNumber value="${numtest1}" groupingUsed="false"/></h3>
	<hr>
	<h2>화폐단위 출력</h2>
	<p> type="currency" / locale 속성에 맞는 화폐단위 출력</p>
	<h3>locale : ${pageContext.request.locale}</h3>
	<h3> type:currency : <fmt:formatNumber value="${numtest1}" type="currency"/></h3>
	<h3> currencySymbol - 화폐단위 지정 가능 : <fmt:formatNumber value="${numtest1}" type="currency" currencySymbol="&&&"/></h3>
	<hr>
	<h2>% 출력</h2>
	<p>type="percent"" value="0~1 사이의 값"</p>
	<h3> type:percent : <fmt:formatNumber value="0.3" type="percent"/></h3>
	<h3> type:percent : <fmt:formatNumber value="0.05" type="percent"/></h3>
	<hr>
	<h2>패턴으로 출력하기</h2>
	<p>
		자리수 표현 패턴<br>
		# : 숫자가 있으면 출력 / 없으면 공백<br>
		0 : 숫자가 있으면 출력 / 없으면 0 <br>
	</p>
	<h3> 출력 : <fmt:formatNumber value="${numtest1}" /></h3>
	<h3> 000,000.0000000 : <fmt:formatNumber value="${numtest1}" pattern="000,000.0000000"/></h3>
	<h3> ###,###.####### : <fmt:formatNumber value="${numtest1}" pattern="###,###.#######"/></h3>
	<h3> 000,000 : <fmt:formatNumber value="${numtest1}" pattern="000,000"/></h3>
	<h3> ###,###.0000000 : <fmt:formatNumber value="${numtest1}" pattern="###,###.0000000"/></h3>
	<hr>
	<h2>소수점 제한두기</h2>
	<p>
		minFractionDigits : 최소 소수점 자리수<br>
		maxFractionDigits : 최대 소수점 자리수<br>
	</p>
	<h3> min = 3 출력 : <fmt:formatNumber value="1.2" minFractionDigits="3" /></h3>
	<h3> max = 5 출력 : <fmt:formatNumber value="1.2345678" maxFractionDigits="5" /></h3>
	<hr>
	<h2>정수자리수 제한</h2>
	<p>
		minIntegerDigits : 최소 정수 자리수<br>
		maxIntegerDigits : 최대 정수 자리수<br>
	</p>
	<h3> min = 3 출력 : <fmt:formatNumber value="1.2" minIntegerDigits="3" /></h3>
	<h3> max = 5 출력 : <fmt:formatNumber value="12345678.2345678" maxIntegerDigits="5" /></h3>
</body>
</html>