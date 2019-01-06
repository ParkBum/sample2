<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<!-- /webapp/WEB-INF/jsp/masterLogin.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>관리자 로그인 화면</title>
</head>
<body>
	<div align="center" class="body">
		<h2>관리자 로그인 화면</h2>
		<c:if test="${not empty param.login_error}">
			<font color="red">${SPRING_SECURITY_LAST_EXCEPTION.message}</font>
		</c:if>
		<form action="j_spring_security_check" method="post"><!-- j_spring_security_check(약속임) -->
			<table>
				<tr height="40px"><th>유저ID</th>
					<td><input type="text" class="userId" name="j_username" size="20"></td><!-- (약속)j_username 3.ver에선... -->
				</tr>
				<tr height="40px"><th>패스워드</th>
					<td><input type="password" class="password" name="j_password" size="20"></td>
				</tr>
				<tr><td colspan="2" align="center"></td></tr>
			</table>
			<table>
				<tr><td align="center"><input type="submit" value="로그인"></td></tr>
			</table>
		</form>
	</div>
</body>
</html>