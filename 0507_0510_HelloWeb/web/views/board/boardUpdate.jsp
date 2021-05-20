<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.member.model.vo.*"%>
<%@ page import="com.board.model.vo.*"%>  
<%
	Member m = (Member)session.getAttribute("login");
	Board b = (Board)request.getAttribute("board");
%>
<style>
	div#board-container
	{
		width:600px;
		margin:0 auto;
		text-align:center;
	}
	div#board-container h2
	{
		margin:10px 0;
	}
	table#tbl-board
	{
		width:500px;
		margin:0 auto;
		border:1px solid black;
		border-collapse:collapse;
	}
	table#tbl-board th
	{
		width:125px;
		border:1px solid;
		padding:5px 0;
		text-align:center;
	}
	table#tbl-board td
	{
		border:1px solid;
		padding:5px 0 5px 10px;
		text-align:left;
	}
	span#fname{position:absolute;left:86px;top:9px;width:285px;
    background-color:skyblue;
    font-size:14px; font-weight:none;}

</style>
<script>
	
</script>

	<div id='board-container'>
		<h2>게시글 수정</h2>
		<form action='<%=request.getContextPath()%>/board/updateEnd' method="post" enctype="multipart/form-data" >
			<table id='tbl-board'>
				<tr>
					<th>제목</th>
					<td><input type="text" id="title" name="title" placeholder="제목을 입력하세요" size="25" required
					     value="<%=b.getBoardTitle() %>"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" id="writer" name="writer" size="25" readonly value="<%=m.getUserId() %>"></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td style="position:relative;">
	           			<%if(b.getBoardOriginalFileName()!=null){ %>
	          				<input type="file" name="up_file">
	          				<span id="fname"><%=b.getBoardOriginalFileName()%></span>
	          				<input type="hidden" name="oldFile" value="<%=b.getBoardRenamedFileName()%>">
	          			<%} else{%>
	          				<input type="file" name="up_file">
	          			<%} %>
	           		</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="50" rows="5" name="content"><%=b.getBoardContent() %></textarea></td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="등록하기">
					</th>
				</tr>
			</table>
		</form>
	</div>
	<script>
		$("input[type=file]").change(e=>{
			if($(e.target).val()==""){
				$("#fname").show();
			}else{
				$("#fname").hide();
			}
		});
	</script>
<%@ include file="/views/common/footer.jsp"%>