package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionMySQL;
import model.Categoria;

final class DaoCategoria implements DaoBase<Categoria> {

	@Override
	public void insert(Categoria object) {
		String query = " insert into categoria (nome)" + " values (?)";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			preparedStmt.setString(1, object.getNome());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Categoria object) {
		String query = "update categoria set nome = ? where id = ?";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			preparedStmt.setString(1, object.getNome());
			preparedStmt.setInt(2, object.getId());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Categoria object) {
		String query = "DELETE FROM categoria WHERE id = ?";
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
	public Categoria findById(int id) {
		String query = "select * from categoria where IdCategoria =?";
		Categoria categoria = null;
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				categoria = new Categoria();
				categoria.setId(rs.getInt("IdCategoria"));
				categoria.setNome(rs.getString("nome"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoria;
	}

	@Override
	public List<Categoria> findAll() {
		String query = "select * from categoria";
		List<Categoria> categorias = new ArrayList<Categoria>();

		Statement statment = null;
		try {
			statment = ConnectionMySQL.getConn().createStatement();
			ResultSet rs = statment.executeQuery(query);
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("IdCategoria"));
				categoria.setNome(rs.getString("nome"));
				categorias.add(categoria);
			}
			statment.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}

}
