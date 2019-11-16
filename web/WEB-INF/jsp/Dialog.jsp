<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.05.2019
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/css/DialogStyles.css"%></style>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Диалог</title>
</head>
<body>
<span class="date sub-text">
<div class="detailBox">
    <div class="titleBox">
        <label>Диалоговое окно</label>
        <a href="/FindUser">
        <button type="button" class="close" aria-hidden="true" onclick="">&times;</button>
        </a>
    </div>
    <div class="commentBox">
        <p class="taskDescription" style="color:black">  <big><big> Диалог с: ${user2.name}</big></big></p>
    </div>
    <div class="actionBox">
        <ul class="commentList"><li><c:forEach var="ContentInDatabase" items="${ContentInDatabase}" >
                <div class="commentText"><c:if test="${ContentInDatabase.content!=null}">
                    <p class="" style="color:black"><c:if test="${ContentInDatabase.id_from==user.id}">
                        <p style="color:black"><big><big>${user.name}:</big></big></p>
                    <p style="color:black"><big><big> <c:out value="${ContentInDatabase.content}"/></big></big></p><p><small>Отправленно:<c:out value="${ContentInDatabase.date}" /></small></p>
                    </c:if>
                    <c:if test="${ContentInDatabase.id_from==user2.id}">
                    <p style="color:black"><big><big>${user2.name}:</big></big></p>
                        <p style="color:black"><big><big> <c:out value="${ContentInDatabase.content}"/></big></big></p><p><small>Отправленно:<c:out value="${ContentInDatabase.date}" /></small></p>
                    </c:if>
                </c:if>
    </c:forEach>
                    </p> <span class="date sub-text"></span>
                </div>

            </li>
        </ul>
        <form class="form-inline" role="form" action="Dialog" method="post">
            <div class="form-group">
                <input name="massage" class="form-control" type="text" placeholder="Введите сообщение" required/>
            </div>
            <div class="form-group">
                <input type="submit" value="Отправить" class="btn btn-default" />
            </div>
        </form>
    </div>
</div>
    </span>
</body>
</html>
