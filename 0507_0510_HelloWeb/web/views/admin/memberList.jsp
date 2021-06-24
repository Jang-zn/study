<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jsp" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style type="text/css">
    section#memberList-container {text-align:center;}
    
    section#memberList-container table#tbl-member {width:100%; border:1px solid gray; border-collapse:collapse;}
    section#memberList-container table#tbl-member th, table#tbl-member td {border:1px solid gray; padding:10px; }
    div#search-container {margin:0 0 10px 0; padding:3px; 
    background-color: rgba(0, 188, 212, 0.3);}
    div#numPerpage-container{float:right;}
    form#numperPageFrm{display:inline;}
    #pageBar *{
    	text-decoration:none;
    	color : black;
    }
    </style>
    <c:set var="path" value="${pageContext.request.contextPath }"/>
    <section id="memberList-container">
        <h2>회원관리</h2>
	    <div id = "search-container">
	        	검색타입 : 
	        	<select id="searchType">
	        		<option value="userId" <c:out value="${param.searchType!=null&&param.searchType eq 'userId'?'selected':''}"/>>아이디</option>
	        		<option value="userName" <c:out value="${param.searchType!=null&&param.searchType eq 'userName'?'selected':''}"/>>회원이름</option>
	        		<option value="gender" <c:out value="${param.searchType!=null&&param.searchType eq 'gender'?'selected':''}"/>>성별</option>
	        	</select>
	       	<div id = "search-userId">
	       		<form action="<c:out value='${path}/admin/searchMemberList'/> method="post">
	       			<input type="text" name="searchKeyword" size="25" placeholder="검색할 아이디를 입력해주세요"
	       			 value="<c:out value="${param.searchKeyword!=null&&param.searchType eq 'userId' ? '${param.searchKeyword}':''}"/>"> 
	       			<input type="hidden" name="searchType" value="userId">
	       			<button type="submit">조회</button>
	       		</form>
	       	</div>
	       	<div id = "search-userName">
	       		<form action="<c:out value='${path}/admin/searchMemberList'/> method="post">
	       			<input type="text" name="searchKeyword" size="25" placeholder="검색할 이름을 입력해주세요"
	       			 value="<c:out value="${param.searchKeyword!=null&&param.searchType eq 'userName' ? '${param.searchKeyword}':''}"/>">
	       			<input type="hidden" name="searchType" value="userName">
	       			<button type="submit">조회</button>
	       		</form>
	       	</div>
	       	<div id = "search-gender">
	       		<form action="<c:out value='${path}/admin/searchMemberList'/> method="post">
	       			<label><input type="radio" name="searchKeyword" value="M" <c:out value="${param.searchKeyword!=null&&param.searchType eq 'gender' && param.searchKeyword eq 'M'? 'checked':''}"/>>남</label>
	       			<label><input type="radio" name="searchKeyword" value="F" <c:out value="${param.searchKeyword!=null&&param.searchType eq 'gender' && param.searchKeyword eq 'F'? 'checked':''}"/>>여</label>
	       			<input type="hidden" name="searchType" value="gender">
	       			<button type="submit">조회</button>
	       		</form>
	       	</div>
       	</div>
       	<div id="numPerpage-container">
       		페이지당 회원수 : 
       		<form id="numPerFrm" action="">
       			<select name="numPerpage" id="numPerpage">
       				<option value="10">10</option>
       				<option value="5" selected>5</option>
       				<option value="3">3</option>
       			</select>
       		</form>
       		<!-- 글쓰기는 관리자만 등록 (완) / 상세보기 로그인체크 / 멤버리스트 출력수 조정 -->
       	</div>
        <table id="tbl-member">
            <thead>
                <tr>
                    <th>아이디</th>
		    <th>이름</th>
		    <th>성별</th>
		    <th>나이</th>
		    <th>이메일</th>
		    <th>전화번호</th>
		    <th>주소</th>
		    <th>취미</th>
		    <th>가입날짜</th>
                </tr>
            </thead>
            <tbody>
            <c:if test="${list.size()==0}">
	            <tr>
    	   			<td colspan="9" style="color:red;">조회된 결과가 없습니다.</td>
       			</tr>
            </c:if>
       		<c:if test="${list.size()!=0}">
       			<c:forEach var="m" items="${memberList}">
	            	<tr>
    	   			<td><c:out value="${m.userId }"/></td>
    	   			<td><c:out value="${m.userName }"/></td>
    	   			<td><c:out value="${m.gender }"/></td>
    	   			<td><c:out value="${m.age }"/></td>
    	   			<td><c:out value="${m.email }"/></td>
    	   			<td><c:out value="${m.phone }"/></td>
    	   			<td><c:out value="${m.address }"/></td>
    	   			<td><c:out value="${m.hobby }"/></td>
    	   			<td><c:out value="${m.enrollDate }"/></td>
	       			</tr>
	       		</c:forEach>
            </c:if>
            </tbody>
        </table>
        <div id="pageBar">
        	<c:out value="${pageBar}" escapeXml="false"/>
        </div>
    </section>
    <script>
    
    	$(function(){
			$("#serachType").change();
		});
    	
		
		$("#searchType").change(e=>{
			let sort = $("#searchType").val();
			console.log(sort);
    		switch(sort){
    			case "userId" : $("#search-userId").css("display","inline-block");
    							$("#search-userName").css("display","none");
    							$("#search-gender").css("display","none"); break; 
    			case "userName" : $("#search-userId").css("display","none");
    							  $("#search-userName").css("display","inline-block");
    							  $("#search-gender").css("display","none"); break;
    			case "gender" : $("#search-userId").css("display","none");
    							$("#search-userName").css("display","none");
    							$("#search-gender").css("display","inline-block"); break;
    		}
		});
		
    </script>
<%@ include file = "../common/footer.jsp" %>