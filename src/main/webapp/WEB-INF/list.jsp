<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tarefas</title>
</head>
<body>
    <h1>Tarefas</h1>
    <ul>
        <c:forEach var="item" items="${tarefas}">
            <li>${item.descricao}</li>
        </c:forEach>
    </ul>
</body>
</html>