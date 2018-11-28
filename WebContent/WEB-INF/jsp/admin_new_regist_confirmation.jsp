<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.AdminBean"
	import="model.AdminPassBean"
%>
<% 	AdminBean adminbean = (AdminBean)session.getAttribute("adminBean");
	AdminPassBean passbean = (AdminPassBean)session.getAttribute("passBean");
%>
<!DOCTYPE html>
<html>
<head>

<!-- Optional theme -->
<meta charset="UTF-8">
<meta name="viewport"content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />

<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css"> -->
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet" />

<link rel="stylesheet" href="css/default.css" >

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
<script src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/materialize.min.css" >
<title></title> <!--画面名-->

</head>
<body>

	<header>
		<%@ include file="admin_header.jsp"%>
	</header><!-- ヘッダー終了  -->
	<div class="row"> <!-- 表示範囲の設定 -->
		<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->

		<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
			<br>
			<br>
			<div class="container">
			<h5 class="left-align valign-wrapper"><i class="material-icons medium ">assignment_ind</i>確認</h5>
			</div>
			<br>
			<br>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<table border="1" id="registtable">
							<tr>
								<th><p>管理者番号<br><%= adminbean.getAdmin_id()%></p></th>
							</tr>
							<tr>
								<th><p>管理者名<br><%= adminbean.getAdmin_name()%></p></th>
							</tr>
							<tr>
								<th><p>パスワード<br><%=passbean.getKomePass() %></p></th>
							</tr>
						</table>

						<div class="container">
							<div class="row right-align">
								<br>
								<div class="col-md-12">
									<form action="AdminRegistration">
										<button type="button" class="waves-effect grey btn" style="margin:0px 5px 0px 0px" onclick="history.back()">戻る</button>
										<input type="submit" value="登録" class="waves-effect blue lighten-1 btn">
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- SCRIPT -->
      <script type="text/javascript">

	    document.addEventListener('DOMContentLoaded', function() {
	    var elems = document.querySelectorAll('.sidenav');
	    var instances = M.Sidenav.init(elems);
	  });


	  // Initialize collapsible (uncomment the lines below if you use the dropdown variation)
	  // var collapsibleElem = document.querySelector('.collapsible');
	  // var collapsibleInstance = M.Collapsible.init(collapsibleElem, options);

	  // Or with jQuery
	   </script>

</body>
</html>
