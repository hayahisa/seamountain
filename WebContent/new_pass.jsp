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
<title>new_pass</title> <!--画面名-->

<nav class="header">鍵管理システム</nav>

</head>

<body>


<div class="row"> <!-- 表示範囲の設定 -->
	<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->

	<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
	<!-- ここから書いて -->

	<br>
	<br>

    <div class="container">
        <h5 class="left-align valign-wrapper">パスワード再登録</h5>
    </div>

    <div class="row container">
        <form class="col s12" action="Re_pass_regist" method="post">

        	<br>
        	<br>

        	<div class="row">
			    <div class="input-field col s12  ">
				    <input id="number" type="number" class="validate" name="number" required>
					<label for="number">学籍番号</label>
				</div>
			</div>

        	<div class="row">
			    <div class="input-field col s12  ">
				    <input id="email" type="email" class="validate" name="mail" required>
					<label for="mail">メールアドレス</label>
				</div>
			</div>

        	<br>

		    <div class="row">
			    <div class="input-field col s12  ">
				    <input id="pass" type="password" class="validate" name="pass" required>
					<label for="pass">パスワード</label>
				</div>
			</div>

			<br>

		    <div class="row">
		        <div class="input-field col s12">
				    <input id="repass" type="password" class="validate" name="repass" required>
	         		<label for="repass">パスワード再入力</label>
				</div>
			</div>

   		    <div class="col s12 right-align">
   		    	<input type="submit" class="waves-effect blue btn" style="margin:0px 5px 0px 0px" value="再登録">
   		    </div>

        </form>

    </div>


  	<!-- ここまで -->
  	</div>
	<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
</div> <!-- div row　終了 -->

<!-- SCRIPT -->
<script type="text/javascript">

	    document.addEventListener('DOMContentLoaded', function() {
	    var elems = document.querySelectorAll('.sidenav');
	    var instances = M.Sidenav.init(elems);
	  });
            document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems, options);
  });

	  </script>

</body>
</html>
