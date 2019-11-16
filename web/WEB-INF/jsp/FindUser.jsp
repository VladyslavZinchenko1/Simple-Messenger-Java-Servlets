<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.05.2019
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<p>Добро пожаловать ${user.name}! </p>
<p>Ваш ид:${user.id}</p>
<p>Ваш эмаил:${user.email}<p>
<p>Ваш юзернейм:${user.username}<p>
<form method="post" action="FindUser">
<label for="id-label">Введите id пользователя
    <input type="text" name="id" id="id-label" required>
</label>
    <input type="submit" value="Найти пользователя">
</form>


<p><a href="LogOut">Выйти</a></p>
</body>
</html>
