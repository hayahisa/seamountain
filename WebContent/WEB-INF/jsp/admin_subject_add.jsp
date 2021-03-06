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

<title>科目追加</title> <!--画面名-->


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
<h5 class="left-align valign-wrapper"><i class="material-icons medium">place</i>科目追加</h5>
<br>

<div class="row">
    <form class="col s12" method="post" action="SubjectAdd">
        <div class="row">
            <div class="input-field col s12">
                <input placeholder="科目名" id="first_name" type="text" class="validate" name="subjectname">
                <label for="first_name">科目名</label>
            </div>
        </div>
        <div class="row">
    		<div class="right-align col s11">
    			<a href="Next_admin_top" class="waves-effect grey btn" style="margin:0px 5px 0px 0px" onclick="document.main.submit();return false;">戻る</a>
    			<input type="submit" class="waves-effect blue lighten-1 btn" value="追　加">
    		</div>
    	</div>
    </form>
    <div class="col s1"></div>
</div>

   <!-- ここまで -->
    </div>
	<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
</div> <!-- div row　終了 -->
<form action="Next_admin_top" name="main" method="post"></form> <!-- mainに戻る -->
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
