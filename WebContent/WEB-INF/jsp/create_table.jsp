<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.SubjectInfoBean"%>
    <%@ page import="model.SubjectBean"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="model.RoomBean"%>
    
    <%
    ArrayList<RoomBean> room=(ArrayList<RoomBean>)request.getAttribute("room");
ArrayList<SubjectBean> sub=(ArrayList<SubjectBean>)request.getAttribute("getSub");
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
        <form action="Next_re_pass" name="repass" method="post">

              <table>
        <thead>
          <tr>
              <th></th>
              <th class="center-align">月</th>
              <th class="center-align">火</th>
              <th class="center-align">水</th>
              <th class="center-align">木</th>
              <th class="center-align">金</th>
          </tr>
        </thead>

        <tbody>
      <!1------------------------------------------------------>

            <tr>
            <td>1</td>

            <td>

  <div>
    <select name=mon1_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=mon1_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=tues1_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=tues1_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=wed1_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=wed1_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=thu1_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=thu1_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=fry1_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=fry1_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>
        </tr>
      <!2------------------------------------------------------>
            <tr>
            <td>2</td>

                        <td>

  <div>
      <select name=mon2_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=mon2_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=tues2_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=tues2_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=wed2_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=wed2_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=thu2_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=thu2_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=fry2_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=fry2_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>
        </tr>
      <!3------------------------------------------------------>
                        <tr>
            <td>3</td>

                                    <td>

  <div>
    <select name=mon3_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=mon3_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=tues3_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=tues3_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=wed3_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=wed3_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=thu3_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=thu3_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=fry3_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=fry3_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>
        </tr>
      <!4------------------------------------------------------>
                        <tr>
            <td>4</td>

              <td>

  <div>
    <select name=mon4_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=mon4_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=tues4_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=tues4_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=wed4_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=wed4_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=thu4_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=thu4_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>

                            <td>

  <div>
    <select name=fry4_sub>
    <optgroup label="教科名">
     <option value="" disabled selected>教科名</option>
                <% for (SubjectBean bean : sub) {%>
                    <option value=<%=bean.getSub_id()%>><%= bean.getSub_name()%></option>
                <% }%>
                </optgroup>
        </select>
       <div>
    <select name=fry4_room>
      <option value="" disabled selected>教室</option>
          <optgroup label="教室名">
                <% for (RoomBean bean : room) {%>
                    <option value=<%=bean.getRoom_id()%>><%=bean.getRoom_name()%></option>
                <% }%>
                </optgroup>
    </select>
  </div>
                </div>

                </td>
        </tr>
                  </tbody></table>
        <br>


    <div class="row right-align">
        <br>
            <div>
                <a class="waves-effect grey btn" style="margin:0px 5px 0px 0px">キャンセル</a>
                 <a class="waves-effect blue lighten-1 btn"><input type="button" value="保存する"></a></div>
        </div>
</form>





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
