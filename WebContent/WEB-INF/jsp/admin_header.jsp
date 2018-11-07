<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
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
    <header> <!-- ヘッダー  -->

    	<nav class="header">

    		<ul id="slide-out" class="sidenav">　<!-- サイドメニュー -->
      			<!-- <li>
      				<div class="user-view">
        				<div class="background"></div>
        				<span class="black-text name"></span>
        					<li><a class="subheader"><i class="material-icons">account_box</i></a></li> ユーザー名
        			</div>
       			</li> -->

      			<li><div class="divider"></div></li>

      			<li><a class="subheader"><i class="material-icons">cloud_queue</i>メニュー</a></li>

  				<li>	<!-- ログアウトへ -->
  					<a class="waves-effect" href="Logout" onclick="document.logout.submit();return false;">
  						<i class="material-icons">directions_bike</i>ログアウト
  					</a>
  				</li>
    		</ul>

    		<!-- ハンバーガーメニュー -->
    		<a href="#" data-target="slide-out" class="sidenav-trigger">
  				<i class="material-icons">menu</i>
  			</a>

  			<a href="Next_admin_top">鍵管理システム</a>

  			<!-- form達 -->
  			<form action="Next_main" name="main" method="post"></form>	<!-- mainに戻る -->
  			<form action="Logout" name="logout" method="post"></form>	<!-- logout -->
  			<form action="Next_mypage" name="mypage" method="post"></form>	<!-- mypageへ -->
  			<form action="Next_create_table" name="create_table" method="post"></form>	<!-- create_tableへ -->
  			<form action="Next_time_table" name="time_table" method="post"></form>	<!-- time_tableへ -->
  			<form action="Next_time_search" name="time_search" method="post"></form>	<!-- time_searchへ -->
  			<form action="Next_reservation" name="reservation" method="post"></form>	<!-- reservation(予約）へ -->


  		</nav>　

	    <!-- 検索バー -->
	  	<!-- <div class="row">
	  		<form class="col s12">
	      		<div class="row">
	            	<div class="input-field col s8">
	              		<input type="text" name="" value="">
	              	</div>
		            <div class="input-field col s4">
		                <a class="waves-effect waves-light btn">教室検索</a>
		            </div>
	          	</div>
	      	</form>
	  	</div> -->

  	</header><!-- ヘッダー終了  -->


    <!-- SCRIPT -->
          <script type="text/javascript">

 			/* navのスクリプト */
    	    document.addEventListener('DOMContentLoaded', function() {
    	    var elems = document.querySelectorAll('.sidenav');
    	    var instances = M.Sidenav.init(elems);
    	  });

    	   </script>

  </body>
</html>
