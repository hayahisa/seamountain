<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"
	import="model.UserBean"
%>

<%	
	ArrayList<UserBean> userArray = new ArrayList<UserBean>();
	userArray = (ArrayList<UserBean>)request.getAttribute("userArray");
	
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
        
        <% if(notResult != null){%>
				<h5><%=notResult %></h5>
		<% }else{ %>
        
		<form action="AdminManagementDeleteList" method="post" name="form">
			<table>
				<tbody>
					<thead>
						<tr>
							<td>
								<label>
									<input type="checkbox" name="all" id="all" />
									<span></span>
								</label>
							</td>
							<th>学籍番号</th>
							<th>名前</th>
							<th>入学年</th>
						</tr>
					</thead>
					<% for(int count=0;count<userArray.size();count++){%>
						
						<tr>
							<td>
								<label>
									<input type="checkbox" class="test" name="user" value="<%=userArray.get(count).getUserNo()%>">
									<span></span>
								</label>
							</td>
							<td><a href="AdminUserSelect?user_no=<%=userArray.get(count).getUserNo() %>"><%=userArray.get(count).getUserNo() %></a></td>
							<td><%=userArray.get(count).getUserName() %></td>
							<td><%=userArray.get(count).getUserYear() %></td>
						</tr>
					<%} %>
				</tbody>
			</table>
			<br>
			<br>
			<div class="right-align">
    	<button type="button" class="waves-effect grey btn" style="margin:0px 5px 0px 0px" onclick="history.back()">戻　る</button>
		<input type="submit" value="削　除" class="waves-effect red lighten-1 btn" onClick="return check()">
    </div>
		</form>
		
		<%} %>
		<br><br>
		
		<!-- ここまで -->
	</div>
	<div class="right col-lg-1 col-md-1 col-xs-0"></div> <!-- 右側余白 -->
</div> <!-- div row　終了 -->

<!-- SCRIPT -->
    
    
<script language="JavaScript" type="text/javascript">
     $(function(){

/* ここにjQueryのコードを記述 */

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
