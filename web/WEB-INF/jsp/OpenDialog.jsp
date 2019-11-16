<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.05.2019
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Открыть Диалог</title>
</head>
<body>
<p>Пользователь с ид:${user2.id}, его юзернейм:${user2.username}, имя:${user2.name}, фамилия:${user2.surname}, email:${user2.email}</p>
<form method="post" action="OpenDialog">
    <input type="submit" value="Открыть диалог">
</form>
<p><a href="FindUser">Назад</a></p>
</body>
</html>
