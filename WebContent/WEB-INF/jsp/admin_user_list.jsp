<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.AdminBean"
	import="java.util.ArrayList"
 %>
<%
	ArrayList<AdminBean> adminArray = new ArrayList<AdminBean>();
	adminArray = (ArrayList<AdminBean>)session.getAttribute("adminArray");
	
	String notResult = (String)request.getAttribute("notResult");
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
        
        <br><br>
        <h6 class="left-align valign-wrapper"><i class="material-icons medium ">person</i>管理者一覧</h6>
        <br>
        
        <% if(notResult != null){%>
				<h5><%=notResult %></h5>
		<% }else{ %>
        
		<form action="Admin_user_delete" method="post" name="form">
			<table>
				<tbody>
					<thead>
						<tr>
							<td>
								<label>
									<input type="checkbox" name="all" id="all">
									<span></span>
								</label>
							</td>
							<th>管理者ID</th>
							<th>管理者名</th>
						</tr>
					</thead>
					<% for(int count=0;count<adminArray.size();count++){%>
						
						<tr>
							<td>
								<label>
									<input type="checkbox" class="test" name="user" value="<%=adminArray.get(count).getAdmin_id()%>">
									<span></span>
								</label>
							</td>
							<td><a href="AdminUserDetail?user_no=<%=adminArray.get(count).getAdmin_id() %>"><%=adminArray.get(count).getAdmin_id() %></a></td>
							<td><%=adminArray.get(count).getAdmin_name() %></td>
						</tr>
					<%} 
					}%>
				</tbody>
			</table>
			<br>
			<br>
			<div class="right-align">
    	<button type="button" class="waves-effect grey btn" style="margin:0px 5px 0px 0px" onclick="history.back()">戻る</button>
		<input type="submit" value="削　除" class="waves-effect red lighten-1 btn" onClick="return check()">
    </div>
		</form>
		
   <!-- ここまで -->
    </div>
	<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
</div> <!-- div row　終了 -->

<!-- SCRIPT -->
    
    
	<script type="text/javascript">
	$(function(){
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

		$('#all').on('click', function() {
			if($("#all:checked").val()) {
				$('.test').prop('checked', true); //アイテムを全部checkedにする
			}else{
				$('.test').prop('checked', false); //アイテムを全部checkedにする
			}
		});
		// 一つでもチェックを外すと「全て選択」のチェック外れる
		$('.test').on('click', function() {
			$('#all').prop('checked', false); //アイテムを全部checkedにする
		});
	});
	
	function check(){
 		if(window.confirm('選択されたユーザーを削除しますか？')){
 			return true;
 		}else{
 			window.alert('キャンセルされました'); // 警告ダイアログを表示
 			return false;
 		}
 	}
	   </script>

</body>
</html>