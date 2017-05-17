package br.com.ifpe.estoque.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.ifpe.estoque.model.Produto;
import br.com.ifpe.estoque.model.ProdutoDao;
import br.com.ifpe.estoque.util.Util;

@Controller
public class ProdutoController {

	@RequestMapping("/exibirIncluirProduto")
	public String exibirIncluirProduto() {

		return "produto/incluirProduto";
	}

	@RequestMapping("incluirProduto")
	public String incluirProduto(@Valid Produto produto, BindingResult result, @RequestParam("file") MultipartFile imagem, Model model) {

		if (result.hasErrors()) {
			return "forward:exibirIncluirProduto";
			}
		
		
		if (Util.fazerUploadImagem(imagem)) {
			produto.setImagem(Calendar.getInstance().getTime() + " - " + imagem.getOriginalFilename());
		}
		
		

		ProdutoDao dao = new ProdutoDao();
		dao.salvar(produto);
		
		model.addAttribute("mensagem", "Produto INCLUIDO com sucesso!!!");
		

		return "produto/incluirProduto";
		//return "produto/incluirProdutoSucesso"; //

	}

	// ---------------------------------------------------------//

	@RequestMapping("/listarProduto")
	public String listarProduto(Model model) {

		ProdutoDao dao = new ProdutoDao();

		List<Produto> listaProduto = dao.listar();

		model.addAttribute("listaProduto", listaProduto);

		return "produto/pesquisarProduto";

		/*
		 * public ModelAndView listarProduto() {
		 * 
		 * ProdutoDao dao = new ProdutoDao();
		 * 
		 * List<Produto> listaProduto = dao.listar();
		 * 
		 * ModelAndView mv = new ModelAndView("produto/pesquisarProduto" );
		 * mv.addObject("listaProduto", listaProduto);
		 * 
		 * return mv;
		 */

		// --------------------------------------------------------//
	}

	@RequestMapping("removerProduto")
	public String removerProduto(Produto produto, Model model) {

		ProdutoDao dao = new ProdutoDao();
		dao.remover(produto);

		model.addAttribute("mensagem", "Produto REMOVIDO com sucesso!!!");

		return "forward:listarProduto";
	}

	// --------------------------------------------------------//

	@RequestMapping("alterarProduto")
	public String alterarProduto(Produto produto, Model model) {

		ProdutoDao dao = new ProdutoDao();
		produto = dao.buscarPorId(produto.getId());

		model.addAttribute("produto", produto);

		return "produto/alterandoProduto";
	}

	@RequestMapping("alterandoProduto")
	public String alterandoProduto(Produto produto, Model model) {

		ProdutoDao dao = new ProdutoDao();
		dao.alterar(produto);

		model.addAttribute("msgm", "Produto ALTERADO com sucesso!!!");

		return "forward:listarProduto";

	}
	
	@RequestMapping("/pesquisarProduto")
	public @ResponseBody String pesquisarProduto(@RequestParam String descricao, 
		    HttpServletResponse response) {
		
	
	ProdutoDao dao = new ProdutoDao();
	List<Produto> listaProduto = dao.pesquisar(descricao);
	
	StringBuilder st = new StringBuilder();

	st.append("<tr style='background-color: #E6E6E6; font-weight: bold;'>");
	
	st.append("<td> CÓDIGO </td>");
	st.append("<td> DESCRIÇÃO </td>");
	st.append("<td> PREÇO DE CUSTO </td>");
	st.append("<td> PREÇO DE VENDA </td>");
	st.append("<td> GARANTIA </td>");
	st.append("<td> QUANTIDADE </td>");
	st.append("<td> IMAGEM </td>");
	st.append("<td> # </td>");
	st.append("</tr>");

	for (Produto produto : listaProduto) {
	    st.append("<tr>");
	    
	    st.append("<td> " + produto.getCodigo() + " </td>");
	    st.append("<td> " + produto.getDescricao() + " </td>");
	    st.append("<td> " + produto.getPrecoCusto() + " </td>");
	    st.append("<td> " + produto.getPrecoVenda() + " </td>");
	    st.append("<td> " + produto.getGarantia() + " </td>");
	    st.append("<td> " + produto.getQuantidade() + " </td>");
	    st.append("<td> <img alt='' src='view/img/"+produto.getImagem()+ "' style='width: 30%;'> </td>");
	    st.append("<td>");
	    
	    st.append("<a href='removerProduto?id=" + produto.getId() + "'>Remover</a> &nbsp;");
	    st.append("<a href='alterarProduto?id=" + produto.getId() + "'>Alterar</a> ");
	    st.append("</td>");
	    st.append("</tr>");
	}

	response.setStatus(200);
	return st.toString();
	
	}

	
	

}
