<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 조회</title>
</head>
<body>
<div align="center" class="body">
	<h2>상품 등록</h2>
	<a href="create.shop">상품등록</a>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">상품 ID</th>
			<th align="center" width="320">상품명</th>
			<th align="center" width="100">가격</th>
		</tr>
		<c:forEach items="${itemList}" var="item">
			<tr class="record">
				<td align="center">${item.id }</td>
				<td align="left"><a href="detail.shop?id=${item.id}">${item.name}</a></td>
				<td align="right"><f:formatNumber type="CURRENCY" currencySymbol="" value="${item.price}" minFractionDigits="0"/>원</td>
			</tr>
		</c:forEach>
	</table>
	<br><a href="../j_spring_security_logout">♥ 로그아웃 하기</a>
</div>
</body>
</html>