<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/header.jsp" %> 
	
	<div align="center">
		<div id="container" align="left">
			<h1>Novo Usuário</h1>
			<c:url var="form_url" value="/usuario/novo" />
			<form  action="${form_url}" method="post">
				<label for="login">Login</label>
				<input type="text" name="usuario.login" id="login" value="${usuario.login}" />
				<label for="senha">Senha</label>
				<input type="password" name="usuario.senha" id="senha" />
				<label for="senha">Re-senha</label>
				<input type="password" name="reSenha"  id="senha" />
				<label for="email">E-Mail</label>
				<input type="text" name="usuario.email" id="email" value="${usuario.email}"/>
				<br clear="all" />
				<div align="right">
					<c:url var="list_url" value="/usuario"/>
					<a href="${list_url}">Voltar</a>
					<button type="submit" id="submit">Salvar</button>
				</div>
			</form>
		</div>
	</div>
	
<%@ include file="/footer.jsp" %> 