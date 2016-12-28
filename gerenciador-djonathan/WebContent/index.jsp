<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${usuarioLogado != null}">
Você está logado como ${usuarioLogado.email}<br/>
</c:if>

<form action="controller" method="post">
	Nome: <input type="text" name="nome"/>
	<input type="hidden" name="tarefa" value="NovaEmpresa"/>
	<input type="submit" value="Salvar"/>
</form>

<form action="login" method="post">
	Email: <input type="email" name="email"/>
	Senha: <input type="password" name="senha"/>
	<input type="submit" value="Entrar"/>
</form>

<form action="controller" method="post">
	<input type="hidden" name="tarefa" value="Logout">
	<input type="submit" value="Deslogar"/>
</form>
</body>
</html>