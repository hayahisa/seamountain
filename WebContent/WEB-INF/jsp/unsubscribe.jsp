<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.UserBean" %>
<%
	String msgflg = (String) request.getAttribute("error");
	String msg = "";

	//request変数に値が入っていたらエラーメッセージを格納
	if (msgflg != null) {
		msg = "正しいパスワードを入力してください。";

	}
%>
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
<%
UserBean user = new UserBean();
user = (UserBean) session.getAttribute("userBean");
String roleFlg = String.valueOf(user.getRoleFlg());
%>

<%if(roleFlg.equals("S")){ %>
	<%@ include file="header.jsp"%>
<%}else{%>
	<%@ include file="header2.jsp"%>
<%} %>
	</header>

	<div class="row"> <!-- 表示範囲の設定 -->
		<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->
		<div class="middle col-lg-10 col-md-10 col-xs-10"> <!-- 中央表示 -->
			<!-- ここから書いて -->
			<br>
			<br>
			<div class="container">
				<div class="row"> <!-- 表示範囲の設定 -->
					<h5 class="center-align valign-wrapper"><i class="material-icons medium ">person</i>退会しますか？</h5>
				</div>
			<div class="row"> <!-- 表示範囲の設定 -->

				<div class="middle col-lg-12 col-md-12 col-xs-12"> <!-- 中央表示 -->
					<div class="center-align">
						<form action="UnSubscribe" method="post" class="col s12">
							<div class="row">
	        					<div class="input-field col s12">
	          						<input id="pass" type="password" name="pass" required>
	          						<label for="password">パスワード</label>
	          						<%= msg%>
	          						<input type="submit" class="waves-effect blue lighten-1 btn" value="送信" onClick="return check()">
	        					</div>
	        				</div>
	        			</form>
	      			</div>
				</div>
			</div>
					<!-- ここまで -->
			</div>
				<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
			</div> <!-- div row　終了 -->
			<!-- ここまで -->
		</div>

		<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
	 <!-- div row　終了 -->
	<script type="text/javascript">
		function check(){

			if(window.confirm('退会しますか？')){
				return true;
			}else{

				window.alert('キャンセルされました'); // 警告ダイアログを表示
				return false;
		}
	}
	</script>

</body>
</html>