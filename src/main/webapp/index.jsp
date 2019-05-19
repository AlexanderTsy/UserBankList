<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%-- previous line should be on every page to solve encoding issue --%>
<html>
<head>
    <title>User Bank List - Главная</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type"  content="text/html; charset=UTF-8">
</head>
<style>
    label {
      display: inline-block;
      width: 140px;
      text-align: right;
    }​
</style>
<body>
<h2>Вас приветствует User Bank List!</h2>
<label>Richest user:</label>
<input id="richest_user" value="richest user"/>
<button onclick="loadMessage('richest_user','/ubl?richest_user')">get</button></br>
<label>Accounts sum:</label>
<input id="accounts_sum" value="accounts sum"/>
<button onclick="loadMessage('accounts_sum','/ubl?accounts_sum')">get</button></br>
</body>
<script>
    function loadMessage(inputId, requestUri) {
      var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          document.getElementById(inputId).value =
          this.responseText;
        }
      };
      xhttp.open("GET", requestUri, true);
      xhttp.send();
    }
</script>
</html>
