<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.KyBean"%>
    <%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

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

<title>鍵一覧</title> <!--画面名-->


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

        <h5 class="left-align valign-wrapper"><i class="material-icons medium ">vpn_key</i>鍵一覧</h5>
        <br>

        <form action="Admin_ky_delete">
			<table>
				<tbody>
					<thead>
						<tr>
							<th>鍵名</th>
							<th></th>
						</tr>
					</thead>
					<% ArrayList<KyBean> KyList = (ArrayList<KyBean>)request.getAttribute("kyall"); %>
         <%for(KyBean bean : KyList){%>

          <tr>
            <td><a href="Admin_ky_changego?Ky_id=<%=bean.getKy_id()%>&Ky_name=<%=bean.getKy_name()%>"><%=bean.getKy_name()%></a></td>
            <td><a href="Admin_ky_delete?Ky_id=<%=bean.getKy_id()%>" class="waves-effect red lighten-1 btn" onClick="return check()">削除</a></td>
          </tr>
          <%} %>
        </tbody>
      </table>

        </form>
        <br><br>
        <div class="right-align">
        	<a href="Next_admin_top" class="waves-effect grey btn" style="margin:0px 5px 0px 0px" onclick="document.main.submit();return false;">戻る</a>
		</div>

		<form action="Next_admin_top" name="main" method="post"></form> <!-- mainに戻る -->

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
  		if(window.confirm('鍵を削除しますか？')){
  			return true;
  		}else{
  			window.alert('キャンセルされました'); // 警告ダイアログを表示
  			return false;
  		}
  	}
</script>

</body>
</html>
