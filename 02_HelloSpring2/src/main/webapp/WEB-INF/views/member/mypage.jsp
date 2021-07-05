<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="Hello Srping"/>
</jsp:include>
<section id="content">
		<style>
		div#enroll-container{width:400px; margin:0 auto; text-align:center;}
		div#enroll-container input, div#enroll-container select {margin-bottom:10px;}
		</style>
<div id="enroll-container">
			<form name="memberEnrollFrm" action="${path}/member/updateMember.do" method="post">
				<input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="userId" id="userId_" value="${login.userId}" readonly>
				<input type="text" class="form-control" placeholder="이름" name="userName" id="userName" value="${login.userName}">
				<input type="number" class="form-control" placeholder="나이" name="age" id="age" value="${login.age}">
				<input type="email" class="form-control" placeholder="이메일" name="email" id="email" value="${login.email}">
				<input type="tel" class="form-control" placeholder="전화번호 (예:01012345678)" name="phone" id="phone" maxlength="11" value="${login.phone}">
				<input type="text" class="form-control" placeholder="주소" name="address" id="address" value="${login.address}">
				<select class="form-control" name="gender">
					<option value="" disabled>성별</option>
					<c:choose>
						<c:when test="${login.gender eq M }">
							<option value="M" selected>남</option>
							<option value="F">여</option>
						</c:when>
						<c:otherwise>
							<option value="M">남</option>
							<option value="F" selected>여</option>
						</c:otherwise>
					</c:choose>
				</select>
				<div class="form-check-inline form-check">
					취미 : &nbsp; 
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby0" value="운동"
						<c:forEach var="h" items="${login.hobby}">
							<c:if test="${h eq '운동'}">
							checked
							</c:if>
						</c:forEach>
					><label for="hobby0" class="form-check-label">운동</label>&nbsp;
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby1" value="등산"
					<c:forEach var="h" items="${login.hobby}">
							<c:if test="${h eq '등산'}">
							<c:out value='checked'/>
							</c:if>
						</c:forEach>><label for="hobby1" class="form-check-label">등산</label>&nbsp;
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby2" value="독서"
					<c:forEach var="h" items="${login.hobby}">
							<c:if test="${h eq '독서'}">
							<c:out value='checked'/>
							</c:if>
						</c:forEach>><label for="hobby2" class="form-check-label">독서</label>&nbsp;
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby3" value="게임"
					<c:forEach var="h" items="${login.hobby}">
							<c:if test="${h eq '게임'}">
							<c:out value='checked'/>
							</c:if>
						</c:forEach>
					><label for="hobby3" class="form-check-label">게임</label>&nbsp;
					<input type="checkbox" class="form-check-input" name="hobby" id="hobby4" value="여행"
					<c:forEach var="h" items="${login.hobby}">
							<c:if test="${h eq '여행'}">
							<c:out value='checked'/>
							</c:if>
						</c:forEach>
					><label for="hobby4" class="form-check-label">여행</label>&nbsp;
				</div>
				<br/>
				<br>
				
				<input type="submit" class="btn btn-outline-success" value="개인정보 수정" >&nbsp;
				<input type="button" class="btn btn-outline-success" onclick="" value="비밀번호 변경" >&nbsp;
				<input type="button" class="btn btn-outline-success" onclick="deleteMember();" value="탈퇴하기">
			</form>
		</div>
	<script>
		const deleteMember=()=>{
			
		}
		
		const updatePassword=()=>{
			
		}
		
	</script>


</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
