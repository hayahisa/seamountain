<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>メール確認</title> <!--画面名-->

</head>
<body>

	<header>
		<nav> <!-- ヘッダー  -->
		</nav>
	</header>

	<div class="row"> <!-- 表示範囲の設定 -->
		<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->
		<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
			<!-- ここから書いて -->
			<br>
			<br>
			<div class="container">
				<h5 class="left-align valign-wrapper"><i class="material-icons medium ">person</i>パスワード再設定</h5>
			</div>
			<div class="row"> <!-- 表示範囲の設定 -->
				<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->
				<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
					<!-- ここから書いて -->
					<br>
					<br>
					<br>
					<br>
					<div class="center-align">
						<h5 class="">メールを送信しました</h5>
						<p>パスワードを設定するためにはメールを確認してください</p>
					</div>
					<br>
					<br>
					<!-- ここまで -->
				</div>
				<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
			</div> <!-- div row　終了 -->
			<!-- ここまで -->
		</div>

		<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
	</div> <!-- div row　終了 -->
	
	<form action="Next_main" name="main" method="post"></form>	<!-- mainに戻る -->

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
