<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.TimeTableBean" %>
<%
TimeTableBean monday = (TimeTableBean)session.getAttribute("monday");
TimeTableBean tuesday = (TimeTableBean)session.getAttribute("tuesday");
TimeTableBean wednesday = (TimeTableBean)session.getAttribute("wednesday");
TimeTableBean thursday = (TimeTableBean)session.getAttribute("thursday");
TimeTableBean friday = (TimeTableBean)session.getAttribute("friday");
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
<%@ include file="header.jsp"%>

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
                            <label><%=monday.getOne_subject_name() %></label>
                            <p><%=monday.getOne_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 火曜1限目　-->
                        <div class="center-align">
                            <label><%=tuesday.getOne_subject_name() %></label>
                            <p><%=tuesday.getOne_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 水曜1限目　-->
                        <div class="center-align">
                            <label><%=wednesday.getOne_subject_name() %></label>
                            <p><%=wednesday.getOne_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 木曜1限目　-->
                        <div class="center-align">
                            <label><%=thursday.getOne_subject_name() %></label>
                            <p><%=thursday.getOne_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 金曜1限目　-->
                        <div class="center-align">
                            <label><%=friday.getOne_subject_name() %></label>
                            <p><%=friday.getOne_room_name() %></p>
                        </div>
                        <div></div>
                    </td>
                </tr>

    <!-- ***********************2限目********************************* -->
                <tr>

                    <td>  <!-- 月曜2限目　-->
                        <div class="center-align">
                            <label><%=monday.getTwo_subject_name() %></label>
                            <p><%=monday.getTwo_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 火曜2限目　-->
                        <div class="center-align">
                            <label><%=tuesday.getTwo_subject_name() %></label>
                            <p><%=tuesday.getTwo_subject_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 水曜2限目　-->
                        <div class="center-align">
                            <label><%=wednesday.getTwo_subject_name() %></label>
                            <p><%=wednesday.getTwo_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 木曜2限目　-->
                        <div class="center-align">
                            <label><%=thursday.getTwo_subject_name() %></label>
                            <p><%=thursday.getTwo_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 金曜2限目　-->
                        <div class="center-align">
                            <label><%=friday.getTwo_subject_name() %></label>
                            <p><%=friday.getTwo_room_name() %></p>
                        </div>
                        <div></div>
                    </td>
                </tr>

    <!-- ***********************3限目********************************* -->
                <tr>

                    <td>  <!-- 月曜3限目　-->
                        <div class="center-align">
                            <label><%=monday.getThree_subject_name() %></label>
                            <p><%=monday.getThree_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 火曜3限目　-->
                        <div class="center-align">
                            <label><%=tuesday.getThree_subject_name() %></label>
                            <p><%=tuesday.getThree_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 水曜3限目　-->
                        <div class="center-align">
                            <label><%=wednesday.getThree_subject_name() %></label>
                            <p><%=wednesday.getThree_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 木曜3限目　-->
                        <div class="center-align">
                            <label><%=thursday.getThree_subject_name() %></label>
                            <p><%=thursday.getThree_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 金曜3限目　-->
                        <div class="center-align">
                            <label><%=friday.getThree_subject_name() %></label>
                            <p><%=friday.getThree_room_name() %></p>
                        </div>
                        <div></div>
                    </td>
                </tr>

    <!-- ***********************4限目********************************* -->
                <tr>

                    <td>  <!-- 月曜4限目　-->
                        <div class="center-align">
                            <label><%=monday.getFour_subject_name() %></label>
                            <p><%=monday.getFour_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 火曜4限目　-->
                        <div class="center-align">
                            <label><%=tuesday.getFour_subject_name() %></label>
                            <p><%=tuesday.getFour_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 水曜4限目　-->
                        <div class="center-align">
                            <label><%=wednesday.getFour_subject_name() %></label>
                            <p><%=wednesday.getFour_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 木曜4限目　-->
                        <div class="center-align">
                            <label><%=thursday.getFour_subject_name() %></label>
                            <p><%=thursday.getThree_room_name() %></p>
                        </div>
                        <div></div>
                    </td>

                    <td>  <!-- 金曜4限目　-->
                        <div class="center-align">
                            <label><%=friday.getFour_subject_name() %></label>
                            <p><%=friday.getFour_room_name() %></p>
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
           		<a href="Next_main" onclick="document.main.submit();return false;" class="waves-effect grey btn" style="margin:0px 5px 0px 0px">　戻る　</a>
            	<a href="Next_time_change" onclick="document.change.submit();return false;" class="waves-effect blue lighten-1 btn">&nbsp;&nbsp;&nbsp;&nbsp;変更&nbsp;&nbsp;&nbsp;&nbsp;</a>
            </div>
        </div>




	<form action="Next_main" name="main" method="post"></form>	<!-- mainに戻る -->
	<form action="Next_time_change" name="change" method="post"></form>	<!-- 変更画面へ -->

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
