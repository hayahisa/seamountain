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
<meta http-equiv="refresh" content="30; URL=Next_class_list">

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
<title>クラス一覧</title> <!--画面名-->

</head>

<body>

<%
UserBean user = new UserBean();
user = (UserBean) session.getAttribute("userBean");
String roleFlg = String.valueOf(user.getRoleFlg());
ArrayList<RoomBean> roomArray = new ArrayList<RoomBean>();
roomArray = (ArrayList<RoomBean>)session.getAttribute("roomList");
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
<!-- 	<div class="nav-wrapper">
      <form>
        <div class="input-field" style="border-bottom: solid 1px #000000">
          <input id="search" type="search" name="search" required>
          <label class="label-icon" for="search"><i class="material-icons">search</i></label>
          <i class="material-icons">close</i>
        </div>
      </form>
    </div> -->

    <!-- 教室一覧 -->
    <h5>鍵状態一覧</h5>
    <br>
    <form>
		<c:forEach var="obj" items="${roomList}" varStatus="status">
			<div class="panel panel-default panel-size">
					<div class="panel-body">教室名：${obj.room_name}
						<c:choose>
							<c:when test="${obj.ky_state_name == '貸出途中'}">
								<span class="badge green">
									<span class="white-text text-darken-2">${obj.ky_state_name}</span>
								</span>
							</c:when>
							<c:when test="${obj.ky_state_name == '貸出中'}">
								<span class="badge red">
									<span class="white-text text-darken-2">${obj.ky_state_name}</span>
								</span>
							</c:when>
							<c:when test="${obj.ky_state_name == '教務室'}">
								<span class="badge blue">
									<span class="white-text text-darken-2">${obj.ky_state_name}</span>
	    						</span>
	    					</c:when>
						</c:choose>
					</div>
			</div>
		</c:forEach>
	</form>

	<br>

	<div class="row right-align">
		<div>
		<a href="Next_main" onclick="document.main.submit();return false;" class="waves-effect grey btn" style="margin:0px 5px 0px 0px">　戻る　</a>
		</div>
	</div>

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
    var instances = M.FormSelect.init(elems, options);
  });

	  // Initialize collapsible (uncomment the lines below if you use the dropdown variation)
	  // var collapsibleElem = document.querySelector('.collapsible');
	  // var collapsibleInstance = M.Collapsible.init(collapsibleElem, options);

	  // Or with jQuery


	  </script>

</body>
</html>
