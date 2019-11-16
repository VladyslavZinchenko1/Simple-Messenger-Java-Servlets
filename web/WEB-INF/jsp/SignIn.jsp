<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.05.2019
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/RegStyles.css"%></style>
<html>
  <head>
    <title>Добро Пожаловать</title>
  </head>
  <body>
  <div class="block">
  <form method="post" id="form" action="SignIn"> 
    <!--
    <label for="username">Введите логин
  </label>
    <input type="text" name="username" id="username" class="menu"> <span></span>   <br>
-->
    <label for="username">Логин</label><input type="text" name="username" id="username" class="menu" required placeholder="Введите логин"><span></span><br>

    <label for="password">Пароль</label><input id="password" name="password"   type="password" class="menu" pattern="[0-9]{7,}" required placeholder="Введите пароль"><span></span><br>
    <!--
    <label for="password">Введите пароль
    </label>
      <input type="password" name="password" id="password" class="menu" pattern="[0-9]{7,}"><span></span>   <br>
    -->
    <div class="button">
    <label class="qwe" for="button"><input id="button" form="form" type="submit" >Войти</label>
  </div>
  </form>
  </div>
  <a href="Registration">Нет аккаунта? зарегистрируйтесь </a>
  </body>
</html>
