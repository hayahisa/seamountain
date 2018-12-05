<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"
		import="model.CourseBean"
 %>
<%
	String sysYear = (new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()));
	int isysYear = Integer.parseInt(sysYear);
%>
<% 
	ArrayList<CourseBean> courseArray = new ArrayList<CourseBean>();
	courseArray = (ArrayList<CourseBean>)session.getAttribute("courseArray");
%>
<%
	String noflg = (String) request.getAttribute("noflg");
	String mailflg = (String) request.getAttribute("mailflg");
	String nomsg = "";
	String mailmsg = "";

	//request変数に値が入っていたらエラーメッセージを格納
	if (noflg != null) {
		nomsg = "学籍番号が重複しています。";
	}
	
	if(mailflg != null){
		mailmsg = "メールアドレスが重複しています。";
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
<title>新規登録</title> <!--画面名-->

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
						<label style="color:red"><%=nomsg %></label>
	        			<div class="input-field col s12  ">
	          				<input id="gakuseki" type="text" class="validate" name="number" maxlength="7" required>
	          				<label for="gakuseki">学籍番号</label>
	        			</div>
	      			</div>
	      			
	      			
	      			<p>学科</p>
	      			<div class="row">
						<div class="input-field col s12">
							<select name="course" required>
								<% for(int count=0;count<courseArray.size();count++){ %>
									<option value=<%=courseArray.get(count).getCourse_id()%>><%=courseArray.get(count).getCourse_name()%></option>
								<%} %>								
							</select>
						</div>
					</div>
					
					<p>入学年</p>
					<div class="row">
						<div class="input-field col s12">
							<select name="useryear" required>
								<% for(int year=isysYear-5;year<=isysYear;year++){ %>
								<option value=<%=year%>><%=year%>年</option>
								<%} %>
							</select>
						</div>
					</div>
	      			
	      			<div class="row">
	        			<div class="input-field col s12">
	          				<input id="username" type="text" class="validate" name="username" maxlength="32" required>
	          				<label for="username">ユーザーネーム</label>
	        			</div>
	      			</div>
					<div class="row">
						<label style="color:red"><%=mailmsg %></label>
	        			<div class="input-field col s12">
	          				<input id="email" type="email" class="validate" name="mail" maxlength="64" required>
	          				<label for="email">メールアドレス</label>
	        			</div>
	        		</div>
	      			<div class="row">
	        			<div class="input-field col s12">
	          				<input id="pass" type="password" class="validate" name="pass" required>
	          				<label for="password">パスワード</label>
	        			</div>
	      			</div>
	              	<div class="row">
	        			<div class="input-field col s12">
							<input id="pass2" type="password" class="validate" name="pass2" required>
							<label for="password2">パスワード確認</label>
	        			</div>
	      			</div>
	      			<div class="row right-align">
						<br>
						<div class="col-md-12">
							<button type="button" class="waves-effect grey btn" style="margin:0px 5px 0px 0px" onclick="history.back()">戻る</button>
							<input type="submit" value="確認" class="waves-effect blue lighten-1 btn" onClick="return passcheck();">
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
		
		function passcheck() {
		    var pass = document.getElementById('pass').value;
		    var pass2 = document.getElementById('pass2').value;
		    
		    
		    // パスワードの一致確認
		    if (pass != pass2){
		    	
		      alert("パスワードと確認用パスワードが一致しません"); // 一致していなかったら、エラーメッセージを表示する
		      return false;
		    }else{
		      return true;
		    }
		};
		
		/* ログインのエラー確認 */
	    function numberCheck(){
	    	var number = document.getElementById('gakuseki').value;

	    	if(isNaN(number) == true){
	    		alert('数字で入力してください');
	    		return false;
	    	}else{
	    		return true;
	    	}
	    }

	   </script>

</body>
</html>
