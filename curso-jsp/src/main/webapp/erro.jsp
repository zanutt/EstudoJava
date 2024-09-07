<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tela de Erros</title>
</head>
<body>
<h1>Mensagem de Erro. entre contato com a equipe de suporte do sistema</h1>
<% 
   String mensagem = (String) request.getAttribute("msg");
   if (mensagem != null) {
       out.print(mensagem);
   } else {
       out.print("Erro desconhecido.");
   }
%>
</body>
</html>