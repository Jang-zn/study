<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.notice.model.vo.*" %>
<%@ include file = "../common/header.jsp" %>
<%
	Notice n = (Notice)request.getAttribute("notice");
%>
    
<div id="notice-container">
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><%=n.getNoticeTitle() %></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><%=n.getNoticeWriter() %></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td>
           	<%if(n.getFilepath()!=null){ %>
           		<a href="<%=request.getContextPath() %>/fileDownload?fileName='<%=n.getFilepath()%>'">
            		 <img src="<%=request.getContextPath() %>/src/imgs/file.png" width="16px">
            	</a>
            <%} %>
            </td>
        </tr>
        <tr>
            <th>내 용</th>
            <td><%=n.getNoticeContent() %></td>
        </tr>
        <tr>
            <th colspan="2">
            	<input type="button" value="목록으로" onclick="location.assign('<%=request.getContextPath() %>/notice/List')">
                <input type="button" value="수정하기" onclick="fn_update();">
                <input type="button" value="삭제하기" onclick="fn_delete();">
            </th>
        </tr>
    </table>
    </div>
    <script>
		const fn_update=()=>{
			location.assign("<%=request.getContextPath()%>/notice/updateNotice?no=<%=n.getNoticeNo()%>");
		}
		const fn_delete=()=>{
			if(confirm("정말로 삭제하시겠습니까?")){
				location.replace("<%=request.getContextPath()%>/notice/deleteNotice?no=<%=n.getNoticeNo()%>&filepath=<%=n.getFilepath()%>");
			}
		} 
	</script>
     <style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    
    </style>
<%@ include file = "../common/footer.jsp" %>
    
    