<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%session.invalidate(); %>

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
<title>ログイン画面</title> <!--画面名-->

<nav class="header">　鍵管理システム</nav>

</head>
<body>

<div class="row"> <!-- 表示範囲の設定 -->
	<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->

	<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
		<!-- ここから書いて -->
	<br>
	<br>

	<div class="container">
    	<h5 class="left-align valign-wrapper"><i class="material-icons small ">input</i>ログイン</h5>
    </div>

    <br>
     <!-- エラーメッセージ -->
     <div class="center-align" style="color:red;">
     <c:out value="${msg}" />
     </div>

    <br>

		<div class="row container">
			<form class="col s12" action="Login" method="post" onsubmit="return login()">
				<div class="row">
					<div class="input-field col s12  ">
						<input id="gakuseki" type="text" class="validate" name="user_number" required>
						<label for="gakuseki">ユーザ番号</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="password" type="password" class="validate" name="user_pass" required>
	         			<label for="password">パスワード</label>
					</div>
				</div>
				<br>
				<div class="row">
				<div class="col s8 left-align">
					<a href="Next_re_pass" onclick="document.repass.submit();return false;">パスワードを忘れた場合</a>
				</div>
				<div class="col s4 left-align">
					<button class="right-align btn waves-effect waves-light blue lighten-1" type="submit" name="action" onClick="return login()">ログイン</button>
				</div>
				</div>
			</form>

		</div>

  	<div class="row container">
  		<div class="col s9 left-align">
  			<a href="Next_new_regist" onclick="document.newregist.submit();return false;">新規登録</a>
  		</div>
   		<div class="col s3 right-align"></div>
	</div>

	<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->


	<form action="Next_re_pass" name="repass" method="post"></form> <!-- パスワードを忘れた遷移用フォーム -->
   	<form action="Next_new_regist" name="newregist" method="post"></form> <!-- 新規登録遷移 -->

   <!-- ここまで -->
	</div>

	<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->

</div> <!-- div row　終了 -->

<!-- SCRIPT -->
      <script>

      /* ログインのエラー確認 */
	    function login(){
	    	var number = document.getElementById('gakuseki').value;
	    	var pass = document.getElementById('password').value;

	    	if(isNaN(number) == true){
	    		alert('ユーザ番号は数字で入力してください');
	    		return false;
	    	}else{
	    		return true;
	    	}
	    }

	   </script>

</body>
</html>
