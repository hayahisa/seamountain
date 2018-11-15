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

</head>
<body>

	<header>
		<%@ include file="admin_header.jsp"%>
	</header><!-- ヘッダー終了  -->

<div class="row"> <!-- 表示範囲の設定 -->
	<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->

	<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
		<!-- ここから書いて -->

<br><br>
  <ul class="collapsible">
    <li>
      <div class="collapsible-header"><i class="material-icons">assignment_ind</i>ユーザー管理</div>
      <div class="collapsible-body">
          <span>
              <div class="center-align"><a href="Next_admin_regist" class="waves-effect waves-light btn-large celter-align">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;　管理者登録　&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></div>
              <p></p>
              <div class="center-align"><a href="Next_user_management" class="waves-effect waves-light btn-large celter-align">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ユーザー管理 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></div>
          </span>
      </div>
    </li>
    <li>
        <div class="collapsible-header"><i class="material-icons">vpn_key</i>鍵管理</div>
        <div class="collapsible-body">
            <span>
                <div class="center-align"><a class="waves-effect waves-light btn-large celter-align" href="Ky_delete">変更・削除</a></div>
                <p></p>
            </span>
        </div>
    </li>
    <li>
        <div class="collapsible-header"><i class="material-icons">dashboard</i>学科管理</div>
        <div class="collapsible-body">
            <span>
                <div class="center-align"><a href="Next_course_add" class="waves-effect waves-light btn-large celter-align">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;追加&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></div>
                <p></p>
                <div class="center-align"><a href="Next_course_management" class="waves-effect waves-light btn-large celter-align">変更・削除</a></div>
                <p></p>
                
            </span>
        </div>
    </li>
    <li>
        <div class="collapsible-header"><i class="material-icons">place</i>授業管理</div>
        <div class="collapsible-body">
            <span>
                <div class="center-align"><a href="Next_subject_add" class="waves-effect waves-light btn-large celter-align">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;追加&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></div>
                <p></p>
           <a href="">
                <div class="center-align"><a href="" class="waves-effect waves-light btn-large celter-align">変更・削除</a></div>
           </a>
                <p></p>
            </span>
        </div>
    </li>
    <li>
        <div class="collapsible-header"><i class="material-icons">school</i>教室管理</div>
        <div class="collapsible-body">
            <span>
                <div class="center-align"><a class="waves-effect waves-light btn-large celter-align">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;追加&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></div>
                <p></p>
                <div class="center-align"><a class="waves-effect waves-light btn-large celter-align">変更・削除</a></div>
                <p></p>
            </span>
        </div>
    </li>
</ul>





   <!-- ここまで -->
	</div>

	<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
</div> <!-- div row　終了 -->

<!-- SCRIPT -->
      <script type="text/javascript">

  document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.collapsible');
    var instances = M.Collapsible.init(elems);
  });

  // Or with jQuery

  $(document).ready(function(){
    $('.collapsible').collapsible();
  });

	   </script>

</body>
</html>
