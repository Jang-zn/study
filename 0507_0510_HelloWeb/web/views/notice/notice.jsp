<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.notice.model.vo.*" %>
<%@ include file = "../common/header.jsp" %>
<% List<Notice> list = (List<Notice>)request.getAttribute("noticeList"); %>
<% String pageBar = (String)request.getAttribute("pageBar");%>
 <style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse;}
    table#tbl-notice th, table#tbl-notice td {border:1px solid; padding: 5px 0; text-align:center;} 
    a{text-decoration:none;}
</style>
<section id="notice-container">
        <h2>공지사항</h2>
        <table id="tbl-notice">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>첨부파일</th>
                <th>작성일</th>
            </tr>
            <%if(list.isEmpty()){ %>
            	<tr><td colspan="5">등록된 내용이 없습니다.</td></tr>
            <%}else{%>
            <%for(Notice n : list) {%>
            	<tr>
            		<td><%=n.getNoticeNo() %></td>
            		<td><a href="<%=request.getContextPath()%>/notice/content?noticeSrl=<%=n.getNoticeNo()%>"><%=n.getNoticeTitle() %></a></td>
            		<td><%=n.getNoticeWriter() %></td>
            		<td>
            		<%if(n.getFilepath()!=null){ %>
            		 <img src="<%=request.getContextPath() %>/src/imgs/file.png" width="16px">
            		<%} %>
            		</td>
            		<td><%=n.getNoticeDate()%></td>
            	</tr>
            <%}
            }%>
        </table>
        <div id="pageBar">
        	<%=pageBar%>
        </div>
    </section>
<%@ include file = "../common/footer.jsp" %>


