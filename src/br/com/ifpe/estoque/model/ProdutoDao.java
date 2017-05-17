package br.com.ifpe.estoque.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.estoque.util.ConnectionFactory;

import br.com.ifpe.estoque.model.Produto;

public class ProdutoDao {

	private Connection connection;

	public ProdutoDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

// ================================================================================//
	
	public void salvar(Produto produto) {
		try {
			String sql = "INSERT INTO produto (codigo, descricao, precocusto, precovenda, garantia, quantidade, imagem) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, produto.getCodigo());
			stmt.setString(2, produto.getDescricao());
			stmt.setDouble(3, produto.getPrecoCusto());
			stmt.setDouble(4, produto.getPrecoVenda());
			stmt.setDate(5, new java.sql.Date(produto.getGarantia().getTime()));
			stmt.setInt(6, produto.getQuantidade());
			stmt.setString(7, produto.getImagem());

			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

// ================================================================================//

	public List<Produto> listar() {

		try {
			List<Produto> listaProduto = new ArrayList<Produto>();

			String sql = "SELECT * FROM produto ORDER BY id";
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Produto produto = new Produto();
				
				produto.setId(rs.getInt("id"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPrecoCusto(rs.getDouble("precocusto"));
				produto.setPrecoVenda(rs.getDouble("precovenda"));
				
				
				produto.setGarantia(rs.getDate("garantia"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setImagem(rs.getString("imagem"));

				listaProduto.add(produto);
			}

			rs.close();
			stmt.close();
			connection.close();

			return listaProduto;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	// ================================================================================//

	
	
	public void remover(Produto produto){
		
		try{
			
			String sql= "DELETE FROM produto WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, produto.getId());
			stmt.execute();
			connection.close();
			
		} catch (SQLException e){
			throw new RuntimeException(e);
			
		}
		
		
	}
	
	
	
	// ================================================================================//
	
	
public Produto buscarPorId(int id){
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement("SELECT *FROM produto WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Produto  produto=null;
			
			if(rs.next()){
				produto=montarObjeto(rs);
			}
	
			rs.close();
			stmt.close();
			connection.close();
			
			return produto;
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		
	}

//================================================================================//
	
	
	public void alterar(Produto produto){
		
		try{
			
			String sql = " UPDATE produto SET codigo=?, descricao=?, precocusto=?, precovenda=?, garantia=?, quantidade=?  WHERE id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, produto.getCodigo());
			stmt.setString(2, produto.getDescricao());
			stmt.setDouble(3, produto.getPrecoCusto());
			stmt.setDouble(4, produto.getPrecoVenda());
			stmt.setDate(5, new java.sql.Date(produto.getGarantia().getTime()));
			stmt.setInt(6, produto.getQuantidade());
			//stmt.setString(7, produto.getImagem());
			stmt.setInt(7, produto.getId());
			
			stmt.execute();
			connection.close();
	
	
			
		} catch (SQLException e){
			
			throw new RuntimeException (e);
			
			
		}
		
		
	}
	
	
	public List<Produto> pesquisar(String descricao) {

		try {

			List<Produto> listaProduto = new ArrayList<Produto>();
			PreparedStatement stmt = null;

			if (!descricao.equals("") ) {
				
				stmt = this.connection.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ? ORDER BY descricao");
				stmt.setString(1, "%" + descricao + "%");
				
			
				
			} else {
				
				stmt = this.connection.prepareStatement("SELECT * FROM produto ORDER BY descricao");
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Produto produto2 = new Produto();

				produto2.setId(rs.getInt("id"));
				produto2.setCodigo(rs.getString("codigo"));
				produto2.setDescricao(rs.getString("descricao"));
				produto2.setPrecoCusto(rs.getDouble("precocusto"));
				produto2.setPrecoVenda(rs.getDouble("precovenda"));
				produto2.setGarantia(rs.getDate("garantia"));
				produto2.setQuantidade(rs.getInt("quantidade"));
				produto2.setImagem(rs.getString("imagem"));

				

				listaProduto.add(produto2);
			}

			rs.close();
			stmt.close();
			connection.close();

			return listaProduto;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
private Produto montarObjeto(ResultSet rs) throws SQLException{
		
		Produto produto = new Produto();
		
		produto.setId(rs.getInt("id"));
		produto.setCodigo(rs.getString("codigo"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setPrecoCusto(rs.getDouble("precocusto"));
		produto.setPrecoVenda(rs.getDouble("precovenda"));
		produto.setGarantia(rs.getDate("garantia"));
		produto.setQuantidade(rs.getInt("quantidade"));
			
		return produto;
	}
	
}
