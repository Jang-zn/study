<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="Hello Srping"/>
</jsp:include>
<section id="board-container" class="container">
        <p>총 ${totalContents }건의 게시물이 있습니다.</p>
        
        <table id="tbl-board" class="table table-striped table-hover">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>첨부파일</th>
                <th>조회수</th>
            </tr>
            <c:choose>
            <c:when test="${list!=null}">
	            <c:forEach var="l" items="${list}">
		            <tr>
		                <td><c:out value="${l.boardNo}"/></td>
		                <td><c:out value="${l.boardTitle}"/></td>
		                <td><c:out value="${l.boardWriter}"/></td>
		                <td><fmt:formatDate type="date" value="${l.boardDate}"/></td>
		                	<td>
			                	<c:if test="${l.attachments!=null}">
				                	<c:forEach var="a" items="${l.attachments}" varStatus="as">
				                		${a}
				                		<c:if test="${as!=last}">
				                		, 
				                		</c:if>
				                	</c:forEach>
			                	</c:if>
		                	</td>
		                <td><c:out value="${l.boardReadcount}"/></td>
		            </tr>	
	            </c:forEach>
            </c:when>
            <c:otherwise>
            <tr>
            	<td colspan="6">조회할 데이터가 없습니다.</td>
            </tr>
            </c:otherwise>
            </c:choose>
        </table> 
        <div class="pageBar">
        	${pageBar}
        </div>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
