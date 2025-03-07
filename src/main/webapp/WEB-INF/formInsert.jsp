<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nova Tarefa</title>
</head>
<body>
    <h1>Tarefas</h1>
    <form action="/tarefas/insert" method="post">
        <label>Descrição</label>
        <input type="text" name="descricao" />
        <button type="submit">Salvar</button>
    </form>
</body>
</html>