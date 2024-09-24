<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>

<body>

	<!-- Pre-loader start -->
	<jsp:include page="theme-loader.jsp"></jsp:include>

	<!-- Pre-loader end -->
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<jsp:include page="navbar.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">

					<jsp:include page="navbarmainmenu.jsp"></jsp:include>

					<div class="pcoded-content">
						<!-- Page-header start -->
						<jsp:include page="page-header.jsp"></jsp:include>
						<!-- Page-header end -->
						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">
								<div class="page-wrapper">
									<!-- Page-body start -->
									<div class="page-body">



										<div class="row">
											<div class="col-sm-12">
												<!-- Basic Form Inputs card start -->
												<div class="card">

													<div class="card-block">
														<h4 class="sub-title">Cadastro de Usuarios</h4>

														<form class="form-material"
															action="<%=request.getContextPath()%>/ServletUsuarioController"
															method="post" id="formUser">

															<input type="hidden" name="acao" id="acao" value="">

															<div class="form-group form-default form-static-label">
																<input type="text" name="id" id="id"
																	class="form-control" readonly="readonly"
																	value="${modelLogin.id}"> <span
																	class="form-bar"></span> <label class="float-label">ID</label>
															</div>
															<div class="form-group form-default">
																<input type="text" name="nome" id="nome"
																	class="form-control" required="required"
																	value="${modelLogin.nome}"> <span
																	class="form-bar"></span> <label class="float-label">Nome
																	completo</label>
															</div>
															<div class="form-group form-default">
																<input type="text" name="login" id="login"
																	class="form-control" required="required"
																	autocomplete="off" value="${modelLogin.login}">
																<span class="form-bar"></span> <label
																	class="float-label">Login</label>
															</div>
															<div class="form-group form-default">
																<input type="email" name="email" id="email"
																	class="form-control" required="required"
																	autocomplete="off" value="${modelLogin.email}">
																<span class="form-bar"></span> <label
																	class="float-label">Email</label>
															</div>
															<div class="form-group form-default">
																<input type="password" name="senha" id="senha"
																	class="form-control" required="required"
																	autocomplete="off" value="${modelLogin.senha}">
																<span class="form-bar"></span> <label
																	class="float-label">Senha</label>
															</div>
															<button type="button"
																class="btn btn-primary waves-effect waves-light"
																onclick="limparForm();">Novo</button>
															<button class="btn btn-sucess waves-effect waves-light">Salvar</button>
															<button type="button"
																class="btn btn-info waves-effect waves-light"
																onclick="criaDeleteComAjax();">Excluir</button>

															<button type="button" class="btn btn-secondary"
																data-toggle="modal" data-target=#usuarioModal>Consultar</button>

														</form>
													</div>
												</div>

											</div>
										</div>
										<span>${msg}</span>
										<div style="height: 300px; overflow: scroll;">
											<table class="table" id="tabelaResultadoviews">
												<thead>
													<tr>
														<th scope="col">Id</th>
														<th scope="col">Nome</th>
														<th scope="col">Ver</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items='${modelLogins}' var='ml'>
														<tr>
															<td><c:out value="${ml.id}"></c:out></td>
															<td><c:out value="${ml.nome}"></c:out></td>
															<td><a class="btn btn-success"
																href="<%= request.getContextPath() %>/ServletUsuarioController?acao=buscarEditar&id=${ml.id}">Ver</a></td>
														</tr>
													</c:forEach>

												</tbody>
											</table>
										</div>

									</div>
									<!-- Page-body end -->
								</div>
								<div id="styleSelector"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Required Jquery -->

	<div class="modal fade" id="usuarioModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Consulta de
						cadastro</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Nome"
							id="nomeBusca" aria-label="Usuario"
							aria-describedby="basic-addon2">
						<div class="input-group-append">
							<button class="btn btn-success" type="button"
								onclick="buscarUsuario()">Buscar</button>
						</div>
					</div>
					<div style="height: 300px; overflow: scroll;">
						<table class="table" id="tabelaResultado">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Nome</th>
									<th scope="col">Ver</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
					<span id="totalresultado"></span>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Fechar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="javascriptfile.jsp"></jsp:include>
	<script type="text/javascript">
	function verEditar(id) {
	    var urlAction = document.getElementById('formUser').action;
	    window.location.href = urlAction + '?acao=buscarEditar&id=' + id;
	}

	function buscarUsuario() {
	    var nomeBusca = document.getElementById("nomeBusca").value;

	    if (nomeBusca != null && nomeBusca != '' && nomeBusca.trim() != '') {//Verifica se o nome nao esta vazio, existe um valor para ele

		var urlAction = document.getElementById('formUser').action;

		$
			.ajax(
				{
				    method : "get",
				    url : urlAction,
				    data : "nomeBusca=" + nomeBusca
					    + "&acao=buscarUsuarioAjax",
				    success : function(response) {

					var json = JSON.parse(response);
					$('#tabelaResultado > tbody > tr')
						.remove();
					for (var p = 0; p < json.length; p++) {
					    $('#tabelaResultado > tbody')
						    .append(
							    '<tr><td>'
								    + json[p].id
								    + '</td><td>'
								    + json[p].nome
								    + '</td><td><button type="button" onclick="verEditar('
								    + json[p].id
								    + ')" class="btn btn-info">Ver</button></td></tr>');
					}
					document
						.getElementById('totalresultado').textContent = 'Resultados: '
						+ json.length;
				    }
				}).fail(
				function(xhr, status, errorThrown) {
				    alert('Erro ao buscar o usuário por nome: '
					    + xhr.responseText);
				});
	    }
	}

	function criaDeleteComAjax() {
	    if (confirm('Deseja realmente excluir os dados?')) {
		var urlAction = document.getElementById('formUser').action;
		var idUser = document.getElementById('id').value;

		$.ajax({
		    method : "get",
		    url : urlAction,
		    data : "id=" + idUser + "&acao=deletarajax",
		    success : function(response) {
			limparForm()
			alert(response);
		    }
		}).fail(
			function(xhr, status, errorThrown) {
			    alert('Erro ao deletar o usuário por id: '
				    + xhr.responseText);
			});
	    }
	}

	function criarDelete() {

	    if (confirm('Deseja realmente excluir os dados?')) {

		document.getElementById("acao").value = 'deletar';
		document.getElementById("formUser").method = 'get';
		document.getElementById("formUser").submit();
	    }
	}

	function limparForm() {
	    var elementos = document.getElementById("formUser").elements;/*Retorna os elementos html dentro do form*/
	    for (p = 0; p < elementos.length; p++) {
		elementos[p].value = '';
	    }
	}
    </script>
</body>

</html>
