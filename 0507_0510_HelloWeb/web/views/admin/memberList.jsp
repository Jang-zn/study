<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jsp" %>
<%@ page import="java.util.*" %>
<% List<Member> list = (List<Member>)request.getAttribute("memberList"); %>

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
    
    <section id="memberList-container">
        <h2>회원관리</h2>
	    <div id = "search-container">
	        	검색타입 : 
	        	<select id="searchType">
	        		<option value="userId" <%= request.getParameter("searchType")!=null&&request.getParameter("searchType").equals("userId")? "selected" : ""%>>아이디</option>
	        		<option value="userName" <%= request.getParameter("searchType")!=null&&request.getParameter("searchType").equals("userName")? "selected" : ""%>>회원이름</option>
	        		<option value="gender" <%= request.getParameter("searchType")!=null&&request.getParameter("searchType").equals("gender")? "selected" : ""%>>성별</option>
	        	</select>
	       	<div id = "search-userId">
	       		<form action="<%=request.getContextPath() %>/admin/searchMemberList" method="post">
	       			<input type="text" name="searchKeyword" size="25" placeholder="검색할 아이디를 입력해주세요" 
	       			 value="<%=request.getParameter("searchKeyword")!=null&&request.getParameter("searchType").equals("userId")?request.getParameter("searchKeyword"):""%>">
	       			<input type="hidden" name="searchType" value="userId">
	       			<button type="submit">조회</button>
	       		</form>
	       	</div>
	       	<div id = "search-userName">
	       		<form action="<%=request.getContextPath() %>/admin/searchMemberList" method="post">
	       			<input type="text" name="searchKeyword" size="25" placeholder="검색할 이름을 입력해주세요"
	       			 value="<%=request.getParameter("searchKeyword")!=null&&request.getParameter("searchType").equals("userName")?request.getParameter("searchKeyword"):""%>">
	       			<input type="hidden" name="searchType" value="userName">
	       			<button type="submit">조회</button>
	       		</form>
	       	</div>
	       	<div id = "search-gender">
	       		<form action="<%=request.getContextPath() %>/admin/searchMemberList" method="post">
	       			<label><input type="radio" name="searchKeyword" value="M" <%=request.getParameter("searchKeyword")!=null&&request.getParameter("searchType").equals("gender")&&request.getParameter("searchKeyword").equals("M")?"checked":""%>>남</label>
	       			<label><input type="radio" name="searchKeyword" value="F" <%=request.getParameter("searchKeyword")!=null&&request.getParameter("searchType").equals("gender")&&request.getParameter("searchKeyword").equals("F")?"checked":""%>>여</label>
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
       		<%if(list.size()==0){ %>
       			<tr>
       			<td colspan="9" style="color:red;">조회된 결과가 없습니다.</td>
       			</tr>
       		<%}else{%>
       			<% for(Member m : list){%>
       				<tr>
       				<td><%=m.getUserId() %></td>
		    		<td><%=m.getUserName() %></td>
		    		<td><%=m.getGender() %></td>
		    		<td><%=m.getAge() %></td>
		    		<td><%=m.getEmail() %></td>
		    		<td><%=m.getPhone() %></td>
		    		<td><%=m.getAddress() %></td>
		    		<td><%=m.getHobby() %></td>
		    		<td><%=m.getEnrollDate() %></td>
       				</tr>
       			<%} %>
       		<%} %>
            </tbody>
        </table>
        <div id="pageBar">
        	<%=request.getAttribute("pageBar") %>
        </div>
    </section>
    <script>
    
    	$(function(){
			$(#"serachType").change();
		});
    	
		
		$("#searchType").change(e=>{
			let sort = $("#searchType").val();
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