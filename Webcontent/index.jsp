<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index jsp</title>
</head>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<br /> 
	<c:if test="${not empty usuarioLogado }">
	Usuário logado:${usuarioLogado.email}
	</c:if>
	
	<form action="executa" method="POST">
	  <input type="hidden" name="tarefa" value="NovaEmpresa" /> 
		Nome: <input type="text" name="nome" /> <input type="submit"
			value="Enviar" />
	</form><br>
	<form action="executa" method="POST">
	  <input type="hidden" name="tarefa" value="Login" /> 
		Email: <input type="email" name="email" /> <br>Senha: <input
			type="password" name="senha" /> <input type="submit" value="Enviar" />
	</form><br>
	
	
	
	<form action="executa" method="post">
	     <input type="hidden" name="tarefa" value="Logout" /> 
		<input type="submit" value="Logout" />
	</form>
</body>
</html>