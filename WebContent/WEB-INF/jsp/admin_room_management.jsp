<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Optional theme -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="admin_header.jsp"%>
	
	<div class="row"></div>
	
	<div class="row"> <!-- 表示範囲の設定 -->
		<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->

		<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
			<!-- ここから書いて -->
			
			<div class="row">
				<form class="col s12">
				
					<div class="row">
						<div class="input-field col s6">
							<input placeholder="教室名" id="room_name" type="text" class="validate">
							<label for="room_name">教室名</label>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>