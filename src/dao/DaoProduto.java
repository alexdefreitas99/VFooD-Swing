package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionMySQL;
import model.Produto;

final class DaoProduto implements DaoBase<Produto> {

	@Override
	public void insert(Produto object) {
		String query = " insert into produto (nome,preco,tempoPreparo,IdCategoria,IdRestaurante)"
				+ " values (?,?,?,?,?)";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			preparedStmt.setString(1, object.getNome());
			preparedStmt.setDouble(2, object.getPreco());
			preparedStmt.setDouble(3, object.getTempoPreparo());
			preparedStmt.setInt(4, object.getCategoria().getId());
			preparedStmt.setInt(5, object.getRestaurante().getId());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Produto object) {
		String query = "update produto set status = 0 where id = ?";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			// preparedStmt.setString(1, object.getNome());
			preparedStmt.setInt(1, object.getId());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Produto object) {
		String query = "DELETE FROM produto WHERE id = ?";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			preparedStmt.setInt(1, object.getId());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	@Override
	public Produto findById(int id) {
		String query = "select * from produto where id =?";
		Produto produto = null;
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			if (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setCategoria(DaoSupplier.getDaoCategoria().findById(rs.getInt("IdCategoria")));
				//produto.setRestaurante(DaoSupplier.getDaoRestaurante().findById(rs.getInt("IdRestaurante")));
				produto.setTempoPreparo(rs.getDouble("tempoPreparo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}

	@Override
	public List<Produto> findAll() {
		String query = "select * from produto where status=true;";
		List<Produto> produtos = new ArrayList<Produto>();

		Statement statment = null;
		try {
			statment = ConnectionMySQL.getConn().createStatement();
			ResultSet rs = statment.executeQuery(query);
			while (rs.next()) {
				Produto produto = findById(rs.getInt("id"));
				produtos.add(produto);
			}
			statment.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	public List<Produto> getByIdRestaurante(int id) {
		String query = "select * from produto where IdRestaurante = ?";
		List<Produto> produtos = new ArrayList<Produto>();

		PreparedStatement statment = null;
		try {
			statment = ConnectionMySQL.getConn().prepareStatement(query);
			statment.setInt(1, id);
			ResultSet rs = statment.executeQuery();
			while (rs.next()) {
				Produto produto = findById(rs.getInt("id"));
				produtos.add(produto);
			}
			statment.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

}
