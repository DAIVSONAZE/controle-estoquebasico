package br.com.ifpe.estoque.model;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Produto {
	
	private int id;
	
	@NotEmpty(message="O código deve ser preenchido")
	@Size(min = 5, max = 5, message="O código deve deve ter um tamanho de 5 caracteres")
	private String codigo;
	
	
	@NotEmpty(message="A descrição deve ser preenchida")
	@Size(min = 5, max = 10, message="A descrição deve ter um tamanho máximo de 10 caracteres")
	private String descricao;
	
	private double precoCusto;
	private double precoVenda;
	private Date garantia;
	private Integer quantidade;
	private String imagem;
	
	
	//----------------------
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public Date getGarantia() {
		return garantia;
	}
	public void setGarantia(Date garantia) {
		this.garantia = garantia;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	
	

}
