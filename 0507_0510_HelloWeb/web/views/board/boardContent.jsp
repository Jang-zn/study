<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.board.model.vo.*"  %>
<%
	Board b = (Board)request.getAttribute("board");
	Member m = (Member)session.getAttribute("login");
%>
<style>
    section#board-container{width:600px; margin:0 auto; text-align:center;}
    section#board-container h2{margin:10px 0;}
    table#tbl-board{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-board th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-board td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    </style>
   
		<div id="board-container">
		<h2>게시판</h2>
		<table id="tbl-board">
			<tr>
				<th>글번호</th>
				<td><%=b.getBoardNo() %></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><%=b.getBoardTitle() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=b.getBoardWriter() %></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=b.getBoardReadCount() %></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
				 <%if(b.getBoardRenamedFileName()!=null){ %>
           			<a href="<%=request.getContextPath() %>/fileDownload_board?fileName=<%=b.getBoardRenamedFileName()%>">
            		 <img src="<%=request.getContextPath() %>/src/imgs/file.png" width="16px">
            		</a>
           		 <%} %>
				</td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><%=b.getBoardContent() %></td>
			</tr>
			<%--글작성자/관리자인경우 수정삭제 가능 --%>
			<%if(m!=null&&(m.getUserId().equals(b.getBoardWriter())||m.getUserId().equals("admin"))){%>
				<tr>
					<th colspan="2">
						<button onclick="fn_update_board();">수정하기</button>
						<button onclick="fn_delete_board();">삭제하기</button>
					</th>
				</tr>
			<%} %>
		</table>
   
    </div>
    <script>
		const fn_update_board=()=>{
			location.assign("<%=request.getContextPath()%>/board/updateBoard?no=<%=b.getBoardNo()%>");
		}
		const fn_delete_board=()=>{
			if(confirm("정말로 삭제하시겠습니까?")){
				location.replace("<%=request.getContextPath()%>/notice/deleteBoard?no=<%=b.getBoardNo()%>&filepath=<%=b.getBoardRenamedFileName()%>");
			}
		} 
	</script>
<%@ include file="/views/common/footer.jsp"%>