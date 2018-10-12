<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<title>退会</title>
</head>
<body>
	
	<header>
		<%@ include file="header.jsp"%>
	</header>
	
	<div class="row"> <!-- 表示範囲の設定 -->
		<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->
		<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
			<!-- ここから書いて -->
			<br>
			<br>
			<div class="container">
				<h5 class="left-align valign-wrapper"><i class="material-icons medium ">person</i>退会しますか？</h5>
			</div>
			<div class="row"> <!-- 表示範囲の設定 -->
				<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->
				<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
					<div class="center-align">
						<form action="UnSubscribe" method="post" class="col s12">
							<div class="row">
	        					<div class="input-field col s12">
	          						<input id="pass" type="password" name="pass" required>
	          						<label for="password">パスワード</label>
	        					</div>
	        				</div>
	        			</form>
	      			</div>
				</div>
			
					<!-- ここまで -->
				</div>
				<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
			</div> <!-- div row　終了 -->
			<!-- ここまで -->
		</div>

		<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
	</div> <!-- div row　終了 -->
	
</body>
</html>