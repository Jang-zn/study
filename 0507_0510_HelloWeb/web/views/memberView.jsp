<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../views/common/header.jsp" %>
<%
	Member m = (Member)request.getAttribute("Member");
	String g = m.getGender();
	/* String[] hobby = m.getHobby().split(",");
	String[] checkHobby=new String[5];
	for(String s : hobby){
		switch(s){
		case "운동" : checkHobby[0]=s; break;
		case "등산" : checkHobby[1]=s; break;
		case "독서" : checkHobby[2]=s; break;
		case "게임" : checkHobby[3]=s; break;
		case "여행" : checkHobby[4]=s; break;
		}
	} */
%>
<section id=enroll-container>
		<h2>회원 정보 수정</h2>
		<form id="memberFrm" method="post" >
			<table>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="userId" id="userId_" value="<%=m.getUserId()%>" readonly>
						<!-- disable 처리하면 나중에 데이터 못넘겨서 안됨 readonly 사용 -->
					</td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td>
						<input type="password" name="password" id="password_" >
					</td>
				</tr>
				<tr>
					<th>패스워드확인</th>
					<td>	
						<input type="password" id="password_2"><br>
					</td>
				</tr>  
				<tr>
					<th>이름</th>
					<td>	
					<input type="text"  name="userName" id="userName" required value="<%=m.getUserName()%>"><br>
					</td>
				</tr>
				<tr>
					<th>나이</th>
					<td>	
					<input type="number" name="age" id="age" value="<%=m.getAge()%>"><br>
					</td>
				</tr> 
				<tr>
					<th>이메일</th>
					<td>	
						<input type="email" placeholder="abc@xyz.com" name="email" id="email" value="<%=m.getEmail()%>"><br>
					</td>
				</tr>
				<tr>
					<th>휴대폰</th>
					<td>	
						<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" value="<%=m.getPhone()%>"><br>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>	
						<input type="text" placeholder="" name="address" id="address" value="<%=m.getAddress()%>"><br>
					</td>
				</tr>
				<tr>
					<th>성별 </th>
					<td>
							<input type="radio" name="gender" id="gender0" value="M" <%=m.getGender().equals("M")?"checked":""%>>
							<label for="gender0">남</label>
							<input type="radio" name="gender" id="gender1" value="F" <%=m.getGender().equals("F")?"checked":""%>>
							<label for="gender1">여</label>
						
						
					</td>
				</tr>
				<tr>
					<th>취미 </th>
					<td>
						<%-- <input type="checkbox" name="hobby" id="hobby0" value="운동" ><label for="hobby0" <%=checkHobby[0]!=null?"checked":"" %>>운동</label>
						<input type="checkbox" name="hobby" id="hobby1" value="등산" ><label for="hobby1" <%=checkHobby[1]!=null?"checked":"" %>>등산</label>
						<input type="checkbox" name="hobby" id="hobby2" value="독서" ><label for="hobby2" <%=checkHobby[2]!=null?"checked":"" %>>독서</label><br />
						<input type="checkbox" name="hobby" id="hobby3" value="게임" ><label for="hobby3" <%=checkHobby[3]!=null?"checked":"" %>>게임</label>
						<input type="checkbox" name="hobby" id="hobby4" value="여행" ><label for="hobby4" <%=checkHobby[4]!=null?"checked":"" %>>여행</label><br /> --%>
						<input type="checkbox" name="hobby" id="hobby0" value="운동" ><label for="hobby0" <%=m.getHobby().contains("운동")?"checked":"" %>>운동</label>
						<input type="checkbox" name="hobby" id="hobby1" value="등산" ><label for="hobby1" <%=m.getHobby().contains("등산")?"checked":"" %>>등산</label>
						<input type="checkbox" name="hobby" id="hobby2" value="독서" ><label for="hobby2" <%=m.getHobby().contains("독서")?"checked":"" %>>독서</label><br />
						<input type="checkbox" name="hobby" id="hobby3" value="게임" ><label for="hobby3" <%=m.getHobby().contains("게임")?"checked":"" %>>게임</label>
						<input type="checkbox" name="hobby" id="hobby4" value="여행" ><label for="hobby4" <%=m.getHobby().contains("여행")?"checked":"" %>>여행</label><br />
						

					</td>
				</tr>
			</table>
			<input type="button" value="정보수정"/>
			<input type="button" value="탈퇴" onclick="fn_deleteMember()">
		</form>
	</section>
	<script>
		const fn_deleteMember=()=>{
			let yn = confirm("탈퇴하시겠습니까?");
			if(yn){
				location.assign("<%=request.getContextPath()%>/delete.do");
			}
		}
	
	</script>
<%@ include file = "../views/common/footer.jsp" %>		