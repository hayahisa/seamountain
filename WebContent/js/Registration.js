function errorcheck() {
    var pass = document.getElementById('pass').value;
    var pass2 = document.getElementById('pass2').value;
    
    
    // パスワードの一致確認
    if (pass != pass2){
    	
    	console.log(pass + 'aaaa' + pass2);
      alert("パスワードと確認用パスワードが一致しません"); // 一致していなかったら、エラーメッセージを表示する
      return false;
    }else{
      return true;
    }
};
