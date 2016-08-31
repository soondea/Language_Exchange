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


<title>List Jsp Test</title>
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
         <li><a href="pwChangeForm.jsp">비밀번호 수정</a></li>
         <li><a href="myPage.jsp">내 정보 수정</a></li>
         <li><a href="myPage.jsp">친구 목록</a></li>
         <li class="special"><a href="#menu" class="menuToggle"><span>Menu</span></a>
            <div id="menu">
               <ul>
                  <li><a href="index.jsp">Home</a></li>
                  <li><a href="generic.jsp">Generic</a></li>
                  <li><a href="elements.jsp">Elements</a></li>
                  <li><a href="#">Sign Up</a></li>
                  <li><a href="#">Log In</a></li>
               </ul>
            </div></li>
      </ul>
      </nav> </header>

      <!-- Main -->
      <section class="wrapper style5">
      <div class="inner">
      <article id="main">
      <h4>강사 목록</h4>
      <img src="images/src2.JPG" border= "2px" width= "400px" height= "300px">
      <ul class="actions small">
         <li><a href="#" style="WIDTH: 300pt;" class="button small">사진 수정하기</a></li>
      </ul>

      <div class="6u 12u$(xsmall)">
      <input type="text" name="name" placeholder="Name" /><br>
      <input type="email" name="email" placeholder="Email" />
      </div>
      <br>   

      <h4>소갯말</h4>
      <div class="6u 12u$(xsmall)">
         <textarea name="demo-message" id="demo-message"
            placeholder="Enter your message" rows="6" style="overflow-y:hidden;"></textarea>
      </div>
      
      
   
      <br><br>
      <h4>강사 목록</h4>
      <div class="table-wrapper">
         <table>
            <thead>
               <tr>
                  <th>Name</th>
                  <th>Description</th>
                  <th>Price</th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td><img src=images/src2.JPG width="120" height="90"></td>
                  <td>Ante turpis integer aliquet porttitor.</td>
                  <td>29.99</td>
               </tr>
               <tr>
                  <td><img src=images/src2.JPG width="120" height="90"></td>
                  <td>Vis ac commodo adipiscing arcu aliquet.</td>
                  <td>19.99</td>
               </tr>
               <tr>
                  <td><img src=images/src2.JPG width="120" height="90"></td>
                  <td>Morbi faucibus arcu accumsan lorem.</td>
                  <td>29.99</td>
               </tr>
               <tr>
                  <td><img src=images/src2.JPG width="120" height="90"></td>
                  <td>Vitae integer tempus condimentum.</td>
                  <td>19.99</td>
               </tr>
               <tr>
                  <td><img src=images/src2.JPG width="120" height="90"></td>
                  <td>Ante turpis integer aliquet porttitor.</td>
                  <td>29.99</td>
               </tr>
            </tbody>
            <tfoot>
               <tr>
                  <td colspan="2"></td>
                  <td>100.00</td>
               </tr>
            </tfoot>
         </table>
      </div>

      </article>
      </div>
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