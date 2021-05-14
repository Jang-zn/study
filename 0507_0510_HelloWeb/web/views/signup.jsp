<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../views/common/header.jsp" %>
<% 
	String checkOK = request.getParameter("checkOK");
	String checkedId = "";
	if(checkOK!=null){
		checkedId = request.getParameter("checkedId");
	}

%>
<section id=enroll-container>
        <h2>회원 가입 정보 입력</h2>
        <form action="<%=request.getContextPath()%>/signup" method="post" onsubmit="return fn_invalidate2();" >
        <table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" placeholder="4글자이상" name="userId" id="userId_" value="<%=checkedId %>">
					<input type="button" onclick="fn_duplicate();" value="중복확인">
				</td>
			</tr>
			<!-- form 안에 button태그 넣으면 Event 발생해서 submit처리됨 input type=button 줘야됨 -->
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" name="password" id="password_" ><br>
				</td>
			</tr>
			<tr>
				<th>패스워드확인</th>
				<td>	
					<input type="password" id="password_2" ><br>
				</td>
			</tr>  
			<tr>
				<th>이름</th>
				<td>	
				<input type="text"  name="userName" id="userName" required><br>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>	
				<input type="number" name="age" id="age" required><br>
				</td>
			</tr> 
			<tr>
				<th>이메일</th>
				<td>	
					<input type="email" placeholder="abc@xyz.com" name="email" id="email" required><br>
				</td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td>	
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" required><br>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>	
					<input type="text" placeholder="" name="address" id="address" required><br>
				</td>
			</tr>
			<tr>
				<th>성별 </th>
				<td>
					<input type="radio" name="gender" id="gender0" value="M"  >
					<label for="gender0">남</label>
					<input type="radio" name="gender" id="gender1" value="F">
					<label for="gender1">여</label>
				</td>
			</tr>
			<tr>
				<th>취미 </th>
				<td>
					<input type="checkbox" name="hobby" id="hobby0" value="운동"><label for="hobby0" >운동</label>
					<input type="checkbox" name="hobby" id="hobby1" value="등산"><label for="hobby1" >등산</label>
					<input type="checkbox" name="hobby" id="hobby2" value="독서"><label for="hobby2" >독서</label><br />
					<input type="checkbox" name="hobby" id="hobby3" value="게임"><label for="hobby3" >게임</label>
					<input type="checkbox" name="hobby" id="hobby4" value="여행"><label for="hobby4" >여행</label><br />
				</td>
			</tr>
		</table>
		<input type="submit" value="가입" >
		<input type="reset" value="취소">
        </form>
        <form name="duplicateFrm" action="" method="post">
        	<input type="hidden" name="userId">
        </form>
        <!-- form에 name 주면 js에서 직접접근 가능 -->
    </section>
    
    <script>
    $("#password_2").blur(e=>{
    	const pw=$("#password_").val();
    	const pwck = $(e.target).val();
    	if(pw!=pwck){
    		alert("password가 일치하지 않습니다.");
    		$("#password_").focus();
    	}
    });
    const fn_invalidate2=()=>{
				const userId=$("#userId_").val();
				const pw = $("#password_").val();
				if(userId.trim().length<4){
					alert("아이디를 4글자 이상 입력하세요");
					$("#userId_").focus();
					return false;
				}
				if(pw.trim().length==0){
					alert("패스워드를 입력하세요");
					$("#password_").focus();
					return false;
				}
				return true;
	}
    const fn_duplicate=()=>{
    	const status = "width=300px, height=200px, left=500px, top=100px;";
    	const title = "duplicateId";
    	const url = "<%= request.getContextPath()%>/checkDuplicate";
    	if($("#userId_").val()!=""){
    	open("",title,status);
    	duplicateFrm.userId.value= $("#userId_").val();
    	duplicateFrm.target=title;
    	/* target으로 지정된 title을 가진 새 창으로 form이 전송됨 */
    	duplicateFrm.action=url;
    	
    		duplicateFrm.submit();
    	}else{
    		alert("아이디를 입력하세요");
    	}
    };
  
   
    </script>
<%@ include file = "../views/common/footer.jsp" %>