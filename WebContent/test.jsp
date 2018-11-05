<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form">
<table>
  <label>
  <tr><td>
    <input type="checkbox" name="all" onClick="AllChecked();" />全て選択
    </td></tr>
  </label>
  <p>
    <label>
      <input type="checkbox" name="test" value="TEST1" onClick="DisChecked();" />TEST1
    </label>
    <label>
      <input type="checkbox" name="test" value="TEST2" onClick="DisChecked();" />TEST2
    </label>
    <label>
      <input type="checkbox" name="test" value="TEST3" onClick="DisChecked();" />TEST3
    </label>
    <label>
      <input type="checkbox" name="test" value="TEST4" onClick="DisChecked();" />TEST4
    </label>
  </p>
  </table>
</form>


<script language="JavaScript" type="text/javascript">

  // 「全て選択」チェックで全てにチェック付く
  function AllChecked(){
    var all = document.form.all.checked;
    alert(all);
    for (var i=0; i<document.form.test.length; i++){
      document.form.test[i].checked = all;
    }
  }

  // 一つでもチェックを外すと「全て選択」のチェック外れる
  function　DisChecked(){
    var checks = document.form.test;
    var checksCount = 0;
    for (var i=0; i<checks.length; i++){
      if(checks[i].checked == false){
        document.form.all.checked = false;
      }else{
        checksCount += 1;
        if(checksCount == checks.length){
          document.form.all.checked = true;
        }
      }
    }
  }

</script>
</body>
</html>