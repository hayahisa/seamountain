<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@
	page import="java.util.ArrayList"
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
    
<title></title> <!--画面名-->
    

</head>
    
<body>

	<header>
		<%@ include file="admin_header.jsp"%>
	</header><!-- ヘッダー終了  -->

<div class="row"> <!-- 表示範囲の設定 -->
	<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->

	<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
		<!-- ここから書いて -->
        
        <br>
        <h6 class="left-align valign-wrapper"><i class="material-icons medium ">person</i>ユーザ管理</h6>
        <br><br>
        
		<form action="AdminUserSelect" method="post">
			<div class="input-field col s12">
    			<select multiple name="year" required>
					<option value="" disabled selected></option>
						<% for(int year=isysYear-7;year<=isysYear;year++){ %>
							<option value=<%=year%>><%=year%>年</option>
						<%} %>
				</select>
				<label>年度</label>
			</div>
			
			<div class="input-field col s12">
				<select multiple name="course" required>
					<option value="" disabled selected></option>
					<% for(int count=0;count<courseArray.size();count++){ %>
						<option value=<%=courseArray.get(count).getCourse_id()%>><%=courseArray.get(count).getCourse_name()%></option>
					<%} %>
				</select>
    			<label>学科</label>
			</div>
			<div class="row">
				<div class="right-align col s11">
					<button type="button" class="waves-effect grey btn" style="margin:0px 5px 0px 0px" onclick="history.back()">戻る</button>
					<input type="submit" class="waves-effect blue lighten-1 btn" value="検索">
				</div>
				<div class="col s1">
				</div>
			</div>
		</form>
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
