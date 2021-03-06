<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="Hello Srping"/>
</jsp:include>
<section id="content">
 <div id="board-container">
        <input type="text" class="form-control" placeholder="Á¦¸ñ" name="boardTitle" id="boardTitle"  required
        value="${board.boardTitle}">
        <input type="text" class="form-control" name="boardWriter"  readonly required value="${board.boardWriter}">
		<c:if test="${not empty board.attachments }" varStatus="vs">
			<c:forEach var="a" items="${board.attachments}">
				<span><c:out value="${a.originalFilename}"/></span>
            	<button type="button" 
                  class="btn btn-outline-success btn-block"
                  onclick="">
                  다운로드.${vs.count}
            	</button>
            </c:forEach>
        </c:if>
        
        <textarea class="form-control" name="boardContent" placeholder="³»¿ë" required><c:out value="${board.boardContent}"/></textarea>
    </div>

     <style>
    div#board-container{width:400px; margin:0 auto; text-align:center;}
    div#board-container input,div#board-container button{margin-bottom:15px;}
    div#board-container label.custom-file-label{text-align:left;}
    </style>
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
