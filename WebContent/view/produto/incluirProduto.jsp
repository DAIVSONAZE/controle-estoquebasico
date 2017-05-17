<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
	      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
 <%@ page import="br.com.ifpe.estoque.model.Produto" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incluir Produto</title>
</head>
<body>


	<c:import url="/view/comum/menu.jsp" />

	<!-- CONFIRMACAO DE CADASTRAMENTO -->
	<div style="text-align: center; color: red;"> ${mensagem} </div>

	<hr>
	<h3>Incluir Produto</h3>
	<hr>
	<form action="incluirProduto" method="post" enctype="multipart/form-data">
	
	<!-- VALIDACAO -->
	<form:errors path="produto.codigo" cssStyle="color:red" /><br>
	<form:errors path="produto.descricao" cssStyle="color:red" />
	
	
	
	
		<p>
			Código: <br /> <input type="text" name="codigo"  />
			<!-- maxlength="5"  -->
		</p>
		
		
		<p>
			Descrição: <br /> <input type="text" name="descricao" />
			<!-- maxlength="10"  -->
		</p>


		<p>
			Preço de Custo: <br /> <input type="text" name="precoCusto" />
		</p>


		<p>
			Preço de Venda: <br /> <input type="text" name="precoVenda" />
		</p>

		<p>
			Tempo de Garantia: <br /> <input type="text" name="garantia" />
		</p>

		<p>
			Quantidade: <br /> <input type="text" name="quantidade" />
		</p>


		<p>
			Foto do Produto: <br /> <input type="file" name="file">
		</p>


		



		<p>
			<input type="submit" value="Inserir">
		</p>
	</form>
	
	
	
	<!-- <a href="index.jsp">MENU</a> -->

</body>
</html>