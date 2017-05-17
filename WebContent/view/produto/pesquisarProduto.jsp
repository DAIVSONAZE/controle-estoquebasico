<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>






<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISTAR PRODUTOS</title>
	
	<script type="text/javascript" src="view/js/jquery-2.1.4.js"></script>

<script type="text/javascript" >

	$(document).ready(function() {

		$("#descricao").keyup(function() {

			var texto = $('#descricao').val();
			

			$.post("pesquisarProduto", {
				'descricao' : texto,
				
			}, function(dados) {
				$('#tabelaListaProduto').html(dados);
			});
		});

		
	});
</script>


</head>
<body>

	<c:import url="/view/comum/menu.jsp" />

	<div style="text-align: center; color: red;">${mensagem}</div>
	<div style="text-align: center; color: red;">${msgm}</div>
	
	


	<hr>
	<h3>Pesquisar Produto</h3>
	<hr>
	
	<div>
		
			<p>
				Descrição: <br /> <input type="text" id="descricao"
					name="descricao" value="${produto.descricao}">
			</p>
		
	</div>

			<hr>
			<h3>Listar Produto</h3>
			<hr>

			<table border='1' style='width: 100%;' id="tabelaListaProduto">

				<tr style='background-color: #E6E6E6; font-weight: bold;'>

					<td>ID</td>

					<td>CÓDIGO</td>
					<td>DESCRICAO</td>
					<td>PRECO CUSTO</td>
					<td>PRECO VENDA</td>
					<td>GARANTIA</td>
					<td>QUANTIDADE</td>
					<td>IMAGEM</td>



					<c:forEach var="produto" items="${listaProduto}">
						<tr>
							<td>${produto.id}</td>
							<td>${produto.codigo}</td>
							<td>${produto.descricao}</td>
							<td>${produto.precoCusto}</td>
							<td>${produto.precoVenda}</td>
							<td><fmt:formatDate value="${produto.garantia}" pattern="dd/MM/yyyy" /></td>
							<td>${produto.quantidade}</td>
							<td><img alt="Maquina de Solda" src="view/img/${produto.imagem}" style="width: 30%;"></td>

							<td><a href="removerProduto?id=${produto.id}">REMOVER</a></td>

							<td><a href="alterarProduto?id=${produto.id}">ALTERAR</a></td>
					</c:forEach>
			</table>
			<br>
			<br>

			<!-- <a href="index.jsp">MENU</a> -->
</body>
</html>