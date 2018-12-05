<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.http.HttpSession"%>
    <%@ page import="model.UserBean" %>

<!DOCTYPE html>
<html>
<head>

<!-- Optional theme -->
<meta charset="UTF-8">
<meta name="viewport"content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="refresh" content="30; URL=Next_main">

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
<title>トップ</title> <!--画面名-->

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
<%
  String nextsubject=(String)session.getAttribute("nextsubject");
  String nextroom=(String)session.getAttribute("nextroom");
  String ky=(String)session.getAttribute("ky");
  int ky_id = Integer.parseInt(String.valueOf(session.getAttribute("ky_id")));
  int ky_state_id = Integer.parseInt(String.valueOf(session.getAttribute("ky_state_id")));
%>
<div class="row"> <!-- 表示範囲の設定 -->
	<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->

	<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
		<!-- ここから書いて -->

        <div class="center-align">
            <p class="Heading h4">次の授業<i class="material-icons">school</i></p>
        	<label class="btn-large blue"><%=nextsubject%></label>
        </div>

        <div class="center-align">
            <p class="Heading h4">次の教室<i class="material-icons">place</i></p>
        	<label class="btn-large blue"><%=nextroom%></label>
        </div>

        <div class="center-align">
            <p class="Heading h4">鍵の状態<i class="material-icons">vpn_key</i></p>
        	<label class="btn-large blue"><%=ky%></label>
        </div>

        <%if(ky_state_id==2){ %>
        <div class="center-align">
        <form action="KeyState"method="post">
           <input type="hidden" name="ky_id" value=<%=ky_id%>>
           <input type="submit" class="btn-large red" value="鍵を取りに行く">
        </form>
        </div>

        <%-- <%}else if(ky_state_id==4){ %>
        <div class="center-align">
        <form action="KeyState"method="get">
           <input type="hidden" name="ky_id" value=<%=ky_id%>>
           <input type="submit" class="btn-large red" value="キャンセル">
        	</form>
        </div> --%>
        <%} %>
        <br>

        <div class="center-align">
            <a href="Next_time_change" onclick="document.time_change.submit();return false;" class="waves-effect waves-light btn" style="margin:0px 5px 0px 0px">登録・変更</a>
        </div>

        <form action="Next_time_change" name="time_change" method="post"></form>	<!-- 時間割登録 -->

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
