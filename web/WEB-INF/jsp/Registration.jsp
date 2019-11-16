<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.05.2019
  Time: 00:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<style><%@include file="/WEB-INF/css/RegStyles.css"%></style>

<div class="block">
    <form id="form" method="post" action="Registration">
        <label for="name">Имя</label><input id="name" name="name" class="menu" placeholder="Ivan" required><span></span><br>
        <label for="surname">Фамилия</label><input id="surname"  name="surname"  class="menu" placeholder="Ivanov" required><span></span><br>
        <label for="email">Эл. почта</label><input id="email" name="email" type="email" class="menu" placeholder="example@gmail.com" required><span></span><br>
        <label for="username">Логин</label><input id="username" name="username"  class="menu" placeholder="peachygangboy" required><span></span><br>

        <label for="password1">Пароль</label><input id="password1"   type="password" class="menu" pattern="[0-9]{7,}" required placeholder="Введите пароль"><span></span><br>
        <label for="password">Повторите</label><input id="password" name="password" type="password" class="menu" placeholder="Повторите пароль" required pattern="[0-9]{7,}"><span></span><br>
        <!--
        <p>Введите число с картинками</p><br>
        -->

        <label for="number">Введите число с картинками</label>
        <br>
        <label class="pic"></label><input id="number" name="number" type="text" class="picinput" pattern="[0-9]{5}"  placeholder="Введите 5 цифр" required><span lang="ru"></span>

    <div class="button">
        <label class="qwe" for="button"><input id="button" form="form" type="submit">Зарегистрироваться</label>
    </div>
    </form>
    <a href="SignIn">Обратно ко входу</a>
</div>
