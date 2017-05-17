<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterando Produto</title>
</head>
<body>


	<c:import url="/view/comum/menu.jsp" />



	<hr>
	<h3>Alterando Produto</h3>
	<hr>
	<form action="alterandoProduto" method="post" enctype="multipart/form-data">
	
	
	
	
		<p>
			<br /> <input type="hidden" name="id" value="${produto.id}" maxlength="5" />
		</p>
	
		<p>
			Código: <br /> <input type="text" name="codigo" value="${produto.codigo}" maxlength="5" />
		</p>
		
		<p>
			Descrição: <br /> <input type="text" name="descricao" value="${produto.descricao}"/>
		</p>


		<p>
			Preço de Custo: <br /> <input type="text" name="precoCusto" value="${produto.precoCusto}" />
		</p>


		<p>
			Preço de Venda: <br /> <input type="text" name="precoVenda" value="${produto.precoVenda}" />
		</p>

		<p>
			Tempo de Garantia: <br /> <input type="text" name="garantia" value="<fmt:formatDate value='${produto.garantia}' pattern='dd/MM/yyyy'/>" />
		</p>

		<p>
			Quantidade: <br /> <input type="text" name="quantidade" value="${produto.quantidade}" />
		</p>


		



		<p>
			<input type="submit" value="Alterar">
		</p>
	</form>
	
	
	
	<!-- <a href="index.jsp">MENU</a> -->
	

</body>
</html>