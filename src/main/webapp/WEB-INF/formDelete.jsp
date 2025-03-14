<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="pt-br">


    <head>
        <meta charset="UTF-8">
        <title>Remover Tarefinha</title>
    </head>


    <body>
        <h1>Remover Tarefa</h1>
        <p>Deseja mesmo EXCLUIR ${tarefa.descricao} ?</p>
        <form action="/tarefas/delete" method="post">
            <input type="hidden" name="id" value="${tarefa.id}" />
            <button type="submit">Deletar</button>
        </form>
    </body>


    </html>