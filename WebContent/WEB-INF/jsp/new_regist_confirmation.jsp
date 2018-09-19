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

	

<div class="row"> <!-- 表示範囲の設定 -->
	<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->

	<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
		<!-- ここから書いて -->
        
        <br>
        <br>
          <div class="container">
    <h5 class="left-align valign-wrapper"><i class="material-icons medium ">person</i>新規会員登録確認</h5>
  </div>
        <br>
        <br>
         
        <div class="row container">
    <form class="col s12">
              <div class="row">
        <div class="input-field col s12  ">
          <input id="gakuseki" type="text" class="validate ">
          <label for="gakuseki">学籍番号</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="username" type="text" class="validate">
          <label for="username">ユーザーネーム</label>
        </div>
      </div>
              <div class="row">
        <div class="input-field col s12">
          <input id="email" type="email" class="validate">
          <label for="email">メールアドレス</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="password" type="password" class="validate">
          <label for="password">パスワード</label>
        </div>
      </div>
      
    </form>
  </div>
        
            <div class="row container">
      <div class="col s12 right-align">
    <button class="right-align btn waves-effect waves-light blue lighten-1" type="submit" name="action">確認
    <i class="material-icons right">send</i>
    </button></div>
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


	  // Initialize collapsible (uncomment the lines below if you use the dropdown variation)
	  // var collapsibleElem = document.querySelector('.collapsible');
	  // var collapsibleInstance = M.Collapsible.init(collapsibleElem, options);

	  // Or with jQuery
	   </script>

</body>
</html>
