<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jsp" %>
<%
	Member m = (Member)session.getAttribute("login");
%>

<div id="notice-container">
    <form action="<%=request.getContextPath() %>/notice/writeEnd" method="post">
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><input type="text" id="title" name="title" placeholder="제목을 작성해주세요" size="25" required></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" id="writer" name="writer" size="25" readonly value="<%=m.getUserId() %>"></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td><input type="file" id="file" name="file" size="25"></td>
        </tr>
        <tr>
            <th>내 용</th>
            <td> <textarea id="content" name="content" cols="40" rows="8" required ></textarea></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="등록하기" onclick="">
            </th>
        </tr>
    </table>
    </form>
    </div>
    
<%@ include file = "../common/footer.jsp" %>

