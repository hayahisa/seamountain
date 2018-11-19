<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"
		import="model.SubjectBean"
%>
<%
	ArrayList<SubjectBean> subjectArray = new ArrayList<SubjectBean>();
	subjectArray = (ArrayList<SubjectBean>)request.getAttribute("subjectArray");
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

<title>科目一覧・削除</title> <!--画面名-->

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
<form action="Admin_subject_delete" name="form">
    <table>
        <tbody>
            <thead>
                <tr>
                	<th>学科名</th>
                    <th></th>
                </tr>
            </thead>
            <%for(int count=0;count<subjectArray.size();count++){%>
            	<tr>
                	<td>
                		<a href="Next_subject_change?subjectid=<%=subjectArray.get(count).getSub_id() %>"><%=subjectArray.get(count).getSub_name() %></a>
                	</td>
                	<td>
                		<input type="hidden" value="<%=subjectArray.get(count).getSub_id() %>" name="subjectid">
                    	<input type="submit" value="削　除" class="waves-effect red lighten-1 btn" onClick="return check()">
                	</td>
            	</tr>
            <% }%>
        </tbody>
    </table>
</form>
        <br><br>
		<div class="right-align">
			<button type="button" class="waves-effect grey btn" style="margin:0px 5px 0px 0px" onclick="history.back()">戻　る</button>
		</div>
             

  
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
</script>

</body>
</html>
