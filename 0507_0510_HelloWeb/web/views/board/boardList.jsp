<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.board.model.vo.*" %>
<%@ page import="com.member.model.vo.*" %>
<%
	List<Board> list = (List<Board>)request.getAttribute("boardList");
	Member m = (Member)session.getAttribute("login");
%>
<style>
	section#board-container{width:600px; margin:0 auto; text-align:center;}
	section#board-container h2{margin:10px 0;}
	table#tbl-board{width:100%; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
	table#tbl-board th, table#tbl-board td {border:1px solid; padding: 5px 0; text-align:center;} 
	/*글쓰기버튼*/
	input#btn-add{float:right; margin: 0 0 15px;}
	/*페이지바*/
	div#pageBar{margin-top:10px; text-align:center; background-color:rgba(0, 188, 212, 0.3);}
	div#pageBar span.cPage{color: #0066ff;}
	</style>
	<section id="board-container">
		<h2>게시판 </h2>
		<%if(m!=null){%>
			<input type="button" id="btn-add" value="글쓰기" onclick="fn_write_board();">
		<%} %>
		<table id="tbl-board">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>첨부파일</th>
				<th>조회수</th>
			</tr>
			<% if(list.size()!=0){ %>
				<%for(Board b:list){ %>
					<tr>
						<td><%=b.getBoardNo() %></td>
						<td>
							<a href="<%=request.getContextPath()%>/board/content?boardNo=<%=b.getBoardNo()%>"><%=b.getBoardTitle() %></a>
						</td>
						<td>
							<%=b.getBoardWriter() %>
						</td>
						<td>
							<%=b.getBoardDate() %>
						</td>
						<td>
							<%if(b.getBoardRenamedFileName()!=null){%>
								<img src="<%=request.getContextPath() %>/src/imgs/file.png" width="16px">
							<%} %>
						</td>
						<td>
							<%= b.getBoardReadCount() %>
						</td>
					</tr>
				<%} %>
			<%}else{%>
				<tr>
				<td colspan="6">게시글이 없습니다</td>
				</tr>
			<%} %>
		</table>

		<div id="pageBar">
			<%=request.getAttribute("pageBar")%>
		</div>
	</section>
	<script>
		const fn_write_board=()=>{
			location.assign("<%=request.getContextPath()%>/board/write");
		}
	
	</script>
<%@ include file="/views/common/footer.jsp"%>