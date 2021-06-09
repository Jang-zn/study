<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
	#tbl, #tbl td{border:1px red solid; text-align:center}
</style>    

<table id='tbl'>
<tr>
	<th>이름</th>
	<th>나이</th>
	<th>성별</th>
</tr>
<%for(int i=0;i<10;i++){ %>
<tr>
	<td>장우영<%=i%></td>
	<td>30</td>
	<td>M</td>
</tr>
<%} %>

</table>
