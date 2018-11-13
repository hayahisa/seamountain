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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
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
		<nav> <!-- ヘッダー  -->

  		<ul id="slide-out" class="sidenav">　<!-- サイドメニュー -->
    		<li><div class="user-view">
      		<div class="background">
      		</div>
      		<a href="#name"><span class="white-text name">John Doe</span></a>
      		<a href="#email"><span class="white-text email">jdandturk@gmail.com</span></a>
    		</div></li>
    		<li><a href="#!"><i class="material-icons">cloud</i>First Link With Icon</a></li>
    		<li><a href="#!">メニュー</a></li>
    		<li><div class="divider"></div></li>
    		<li><a class="subheader">Subheader</a></li>
    		<li><a class="waves-effect" href="#!">Third Link With Waves</a></li>
				<li><a class="時間割作成" href="#!"></a></li>
				<li><a class="時間割一覧" href="#!"></a></li>
				<li><a class="" href="#!"></a></li>
				<li><a class="logout" href="#!">ログアウト</a></li>
  		</ul>

  		<a href="#" data-target="slide-out" class="sidenav-trigger">
				<i class="material-icons">menu</i>
			</a>

		</nav>　
	</header><!-- ヘッダー終了  -->

<div class="row"> <!-- 表示範囲の設定 -->
	<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->

	<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
		<!-- ここから書いて -->
<br><br><br><br><br><br><br>

 <div class="row">
    <div class="input-field col s12">
    <form action="Admin_ky_change">
      <input value="" id="first_name2" type="text" class="validate" name="Ky_change">
      <label class="active" for="first_name2"><%=request.getParameter("Ky_name")%><input type="hidden" name="Ky_id" value=<%=request.getParameter("Ky_id")%>></label>
    </div>
  </div>
        <br><br>
        
<div class="row">
    <div class="right-align col s11">
       <a class="waves-effect waves-light btn-large"> <input type="submit" value="変更"></a>
    </div>
    <div class="col s1"></div>

             

  
   <!-- ここまで -->
    </div>
	<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
</div> <!-- div row　終了 -->

<!-- SCRIPT -->
      <script type="text/javascript">

	  document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems);
  });

  // Or with jQuery

  $(document).ready(function(){
    $('select').formSelect();
  });


	  // Initialize collapsible (uncomment the lines below if you use the dropdown variation)
	  // var collapsibleElem = document.querySelector('.collapsible');
	  // var collapsibleInstance = M.Collapsible.init(collapsibleElem, options);

	  // Or with jQuery
          
        
          
          

	   </script>

</body>
</html>
