<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="Hello Srping"/>
</jsp:include>
<section id="content">
<style>
    div#memo-container{width:60%; margin:0 auto;}
    </style>
    <div id="memo-container">
        <form action="${path}/memo/memoInsert.do" class="form-inline" method="post">
            <input type="text" class="form-control col-sm-6" name="memo" placeholder="메모" required/>&nbsp;
            <input type="password" class="form-control col-sm-2" name="password" maxlength="4" placeholder="비밀번호" required/>&nbsp;
            <button class="btn btn-outline-success" type="submit" >저장</button>
        </form>
    </div>
     <br />
        <!-- 메모목록 -->
        <table class="table">
            <tr>
                <th scope="col">번호</th>
                <th scope="col">메모</th>
                <th scope="col">날짜</th>
                <th scope="col">삭제</th>
            </tr>
            <c:choose>
	            <c:when test="${list!=null}">
	            	<c:forEach var="m" items="${list}">
		            	<tr>
			                <td scope="col" class="no"><c:out value="${m.memoNo}"/></td>
			                <td scope="col"><c:out value="${m.memo}"/></td>
			                <td scope="col"><c:out value="${m.memoDate}"/></td>
			                <td scope="col"><button type="button" class="del_btn btn btn-outline-success my2 my-sm-0">삭제</button></td>
		            	</tr>	
	            	</c:forEach>
	            </c:when>
	            <c:otherwise>
	            	<td colspan="4">등록된 내용이 없습니다.</td>
	            </c:otherwise>
            </c:choose>
        </table>
</section>
<script>
	$(".del_btn").click((e)=>{
		let no = $(e.target).parents().children(".no").text();
		location.assign("${path}/memo/memoDelete.do?no="+no);
	});
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
