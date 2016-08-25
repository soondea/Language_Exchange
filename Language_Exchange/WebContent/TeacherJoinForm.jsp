<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<title>Insert title here</title>
</head>
<body>



	<!-- Page Wrapper -->
	<div id="page-wrapper">

		<!-- Header -->
		<header id="header">
		<h1>
			<a href="index.jsp">Spectral</a>
		</h1>
		<nav id="nav">
		<ul>
			<li class="special"><a href="#menu" class="menuToggle"><span>Menu</span></a>
				<div id="menu">
					<ul>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="generic.jsp">Generic</a></li>
						<li><a href="elements.jsp">Elements</a></li>
						<li><a href="list.jsp">Sign Up</a></li>
						<li><a href="http://hentaku.net/rank/">Log In</a></li>
					</ul>
				</div></li>
		</ul>
		</nav> </header>
		<br>
		<h4>회원가입</h4>

		<section>

		<form name="sipalform" method="post" action="#">

			<div class="6u 12u$(xsmall)">
				<input type="text" name="demo-name" id="demo-name" value=""
					placeholder="Name" />
			</div>
			<br>
			<div class="6u$ 12u$(xsmall)">
				<input type="email" name="demo-email" id="demo-email" value=""
					placeholder="Email" />
			</div>
			<br>
			<div class="6u$ 12u$(xsmall)">
				<input type="password" name="demo-email" id="demo-email" value=""
					placeholder="Password" />
			</div>
			<br>
			<div class="6u$ 12u$(xsmall)">
				<input type="password" name="demo-email" id="demo-email" value=""
					placeholder="PasswordCheck" />
			</div>
			<br>
			<h4>자격증</h4>

			<div class="4u 12u$(small)">
				<input type="radio" id="N1" name="N" checked> 
				<label for="N1">JLPT N1</label>
				<input type="radio" id="N2" name="N">
				<label for="N2">JLPT N2</label>
				<input type="radio" id="N3" name="N">
				<label for="N3">JLPT N3</label>				
			</div><br>

			<h4>모국어</h4>

			<div class="4u 12u$(small)">
				<input type="radio" id="demo-priority-low" name="a" checked>
				<label for="demo-priority-low">한국어</label>
				<input type="radio" id="demo-priority-normal" name="a"> 
				<label for="demo-priority-normal">일본어</label>
			</div><br>

			<h4>소갯말</h4>
			<div class="12u$">
				<textarea name="demo-message" id="demo-message"
					placeholder="Enter your message" rows="6"></textarea>
			</div>
			<br>
			<center>
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="회원가입" class="special" /></li>
						<li><input type="reset" value="다시쓰기" /></li>
					</ul>
				</div>
			</center>




		</form>
		</section>

		<!-- Footer -->
		<footer id="footer">
		<ul class="icons">
			<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
			<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
			<li><a href="#" class="icon fa-instagram"><span
					class="label">Instagram</span></a></li>
			<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
			<li><a href="#" class="icon fa-envelope-o"><span
					class="label">Email</span></a></li>
		</ul>
		<ul class="copyright">
			<li>&copy; Untitled</li>
			<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
		</ul>
		</footer>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>
</body>
</html>