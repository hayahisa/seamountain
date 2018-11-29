<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.RoomBean"  import="java.util.ArrayList"%>
<%@ page import="model.UserBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>reservation_top</title> <!--画面名-->


</head>

<body>
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

<div class="row"> <!-- 表示範囲の設定 -->
	<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->

	<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
		<!-- ここから書いて -->

<!--
      <div class="left-align">
        <label class="badge green" style="padding:10px 20px 10px 20px;font-size: 20px;">教室予約</label>
      </div>
 -->
<!-- 予約top -->
 	<h5>教室予約</h5>

 	<br>

      <form class="" action="Next_reservation_list" method="post">
      	<div>
	      	<select name="room">
	      	<option value="0" selected>教室選択</option>
		      	<c:forEach var="obj" items="${roomList}" varStatus="status">
			      <option value="${obj.room_id }"><p>${obj.room_name}</p></option>
				</c:forEach>
	      	</select>
      	</div>

		<div>
			<select name="day">
			<option value="0" selected>曜日選択</option>
			<option value="monday">月曜日</option>
			<option value="tuesday">火曜日</option>
			<option value="wednesday">水曜日</option>
			<option value="thursday">木曜日</option>
			<option value="friday">金曜日</option>
			</select>
			<select name="time">
			<option value="0" selected>時間選択</option>
			<option value="1">1限目</option>
			<option value="2">2限目</option>
			<option value="3">3限目</option>
			<option value="4">4限目</option>
			</select>
		</div>
		<br>
		<div class="row right-align">
			<a href="Next_main" onclick="document.main.submit();return false;" class="waves-effect grey btn" style="margin:0px 5px 0px 0px">　戻る　</a>
			<input type="submit" name="" value="　検索　" class="waves-effect blue btn">
 		</div>
		</form>
		<div>

	<form action="Next_main" name="main" method="post"></form>	<!-- mainに戻る -->

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
	        var instances = M.FormSelect.init(elems);
	      });

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
