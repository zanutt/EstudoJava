<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Curso JSP</title>
</head>
<body>

	<h1>Bem vindo ao curso de JSP</h1>



	<form action="ServletLogin" method="post">

		<input type="hidden" value="<%=request.getParameter("url")%>"
			name="url">

		<table>
			<tr>
				<td>Login</td>
				<td><input name="login" type="text"></td>
			</tr>

			<tr>
				<td>Senha</td>
				<td><input name="senha" type="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Enviar" /></td>
			</tr>
		</table>

		<h4>${msg}</h4>

	</form>

</body>
</html>