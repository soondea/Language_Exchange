<%@page import="java.util.List"%>
<%@page import="vo.member.Member"%>
<%@page import="dao.member.MemberDao"%>
<%@page import="utils.manager.DatabaseManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입하기</title>
</head>
<body>
<%

%>

	<form action="" method="post">

		<p>
			아이디 : <br />
			<input type="text" name="id" value="${param.id}">
		</p>
		<p>
		<p>
			이름 : <br />
			<input type="text" name="name" value="${param.name}">
		</p>
		<p>
		<p>
			비밀번호: <br />
			<input type="password" name="password">
		</p>
		<p>
			비밀번호확인 : <br />
			<input type="password" name="confirmPassword">
		</p>
		<p>
			이메일 : <br />
			<input type="text" name="email" >
		</p>
		<p>
			모국어 : <br />
			<input type="text" name="motherlanguage" >
			
		</p>
		<p>
			배울언어 : <br />
			<input type="text" name="targetlanguage" >

		</p>
		<p>
		<p>
			소개말 : <br />
			<input type="text" name="intro" >

		</p>
		<p>
			<p>
			자격증 : <br /><input type="text" name="ability">

		</p>
<p>
<input type="submit" value="가입">
		
	</form>
</body>
</html>