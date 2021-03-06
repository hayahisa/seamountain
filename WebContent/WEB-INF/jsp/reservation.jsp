<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.UserBean" %>
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

<%
UserBean user = new UserBean();
user = (UserBean) session.getAttribute("userBean");
String roleFlg = String.valueOf(user.getRoleFlg());
%>

<%if(roleFlg.equals("S")){ %>
	<%@ include file="header.jsp"%>
<%}else{%>
	<%@ include file="header2.jsp"%>
<%} %>>


<div class="row"> <!-- 表示範囲の設定 -->
	<div class="left col-lg-1 col-md-1 col-xs-0"></div> <!-- 左側余白 -->

	<div class="middle col-lg-10 col-md-10 col-xs-12"> <!-- 中央表示 -->
		<!-- ここから書いて -->
        <br>

        <table>

        <thead>
            <tr>
                <th class="center-align">月</th>
                <th class="center-align">火</th>
                <th class="center-align">水</th>
                <th class="center-align">木</th>
                <th class="center-align">金</th>
            </tr>
        </thead>

        <tbody>

        <!-- 時間割の中身 -->
<!-- ***********************1限目********************************* -->
            <tr>
                <td>  <!-- 月曜１限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 火曜1限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 水曜1限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>

                <td>  <!-- 木曜1限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 金曜1限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>
            </tr>

<!-- ***********************2限目********************************* -->
            <tr>

                <td>  <!-- 月曜2限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 火曜2限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 水曜2限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 木曜2限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 金曜2限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>
            </tr>

<!-- ***********************3限目********************************* -->
            <tr>

                <td>  <!-- 月曜3限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>

                <td>  <!-- 火曜3限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 水曜3限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 木曜3限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 金曜3限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>
            </tr>

<!-- ***********************4限目********************************* -->
            <tr>

                <td>  <!-- 月曜4限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 火曜4限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 水曜4限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 木曜4限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>

                <td>  <!-- 金曜4限目　-->
                    <div class="center-align">
                        <p class="waves-effect waves-light btn">使用</p>
                    </div>
                    <div></div>
                </td>
            </tr>

            <!--　時間割内容終了　-->

        </tbody>
    </table>
        <br>


    <div class="row right-align">
        <br>
            <div>
                <a class="waves-effect grey btn" style="margin:0px 5px 0px 0px">キャンセル</a>
                <a class="waves-effect blue lighten-1 btn">&nbsp;&nbsp;&nbsp;&nbsp;変更&nbsp;&nbsp;&nbsp;&nbsp;</a></div>
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
    <script>
                document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems);
  });

  // Or with jQuery

  $(document).ready(function(){
    $('select').formSelect();
  });</script>

</body>
</html>
