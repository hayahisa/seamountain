<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sysYear = (new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()));
	int isysYear = Integer.parseInt(sysYear);
%>
<%
	String msgflg = (String) request.getAttribute("msgflg");
	String msg = "";

	//request変数に値が入っていたらエラーメッセージを格納
	if (msgflg != null) {
		msg = "学籍番号が重複しています。";

	}
%>
<!DOCTYPE html>
<html>
<head>

<!-- Optional theme -->
<meta charset="UTF-8">
<meta name="viewport"content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />

<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet" />

<link rel="stylesheet" href="css/default.css" >

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
<script src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/materialize.min.css" >
<title>新規会員登録</title> <!--画面名-->

</head>
<body>

<nav></nav>

	<div class="row"> <!-- 表示範囲の設定 -->
		<div class="left col-lg-1 col-md-1 col-xs-0">
		</div> <!-- 左側余白 -->
		<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->

	        <br>
	        <br>
			<div class="container">
	    		<h5 class="left-align valign-wrapper"><i class="material-icons medium ">person</i>新規会員登録</h5>
	  		</div>
	        <br>
	        <br>
	        <div class="row container">
	        
	    		<form class="col s12" action="UserRegistration" method="post">
					<div class="row">
	        			<div class="input-field col s12  ">
	          				<input id="gakuseki" type="text" class="validate" name="number">
	          				<label for="gakuseki">学籍番号</label>
	        			</div>
	      			</div>
	      			
	      			<p>学科</p>
	      			<div class="row">
						<div class="input-field col s12">
							<select name="course">
								<option value="1">情報システム科</option>
								<option value="2">情報システム専攻科</option>
								<option value="3">情報工学科</option>
								<option value="4">ネットワーク科</option>
							</select>
						</div>
					</div>
					
					<p>入学年</p>
					<div class="row">
						<div class="input-field col s12">
							<select name="useryear" required>
								<% for(int year=isysYear-7;year<=isysYear;year++){ %>
								<option value=<%=year%>><%=year%>年</option>
								<%} %>
							</select>
						</div>
					</div>
	      			
	      			<div class="row">
	        			<div class="input-field col s12">
	          				<input id="username" type="text" class="validate" name="username">
	          				<label for="username">ユーザーネーム</label>
	        			</div>
	      			</div>
					<div class="row">
	        			<div class="input-field col s12">
	          				<input id="email" type="email" class="validate" name="mail">
	          				<label for="email">メールアドレス</label>
	        			</div>
	        		</div>
	        		<div class="row">
	        			<div class="input-field col s12">
	        				<input id="email2" type="email" class="validate">
	        				<label for="email2">メールアドレス確認</label>
						</div>
	      			</div>
	      			<div class="row">
	        			<div class="input-field col s12">
	          				<input id="password" type="password" class="validate" name="pass">
	          				<label for="password">パスワード</label>
	        			</div>
	      			</div>
	              	<div class="row">
	        			<div class="input-field col s12">
							<input id="password2" type="password" class="validate" name="pass2">
							<label for="password2">パスワード確認</label>
	        			</div>
	      			</div>
	      			<div class="row container">
	      				<div class="col s12 right-align">
	      					<button type="button" class="left-align btn waves-effect waves-light green lighten-1" onclick="history.back()">戻る</button>
	    					<button class="right-align btn waves-effect waves-light blue lighten-1" type="submit" name="action" onclick="return errorcheck()">確認
							<i class="material-icons right">send</i>
							</button>
						</div>
	    			</div>
	      			
	    		</form>
	  		</div>
	
			
		</div>

		<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
	</div> <!-- div row　終了 -->

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
		document.addEventListener('DOMContentLoaded', function() {
    	var elems = document.querySelectorAll('select');
    	var instances = M.FormSelect.init(elems);
 		});

  // Or with jQuery

		$(document).ready(function(){
			$('select').formSelect();
		});
	   </script>

</body>
</html>
