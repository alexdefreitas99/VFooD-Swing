package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionMySQL;
import model.Perfil;

final class DaoPerfil implements DaoBase<Perfil> {

	@Override
	public void insert(Perfil object) {
		String query = " insert into perfil (nome)" + " values (?)";
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
	public void update(Perfil object) {
		String query = "update perfil set nome = ? where id = ?";
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
	public void delete(Perfil object) {
		String query = "DELETE FROM perfil WHERE id = ?";
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
	public Perfil findById(int id) {
		String query = "select * from perfil where id =?";
		Perfil perfil = null;
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				perfil = new Perfil();
				perfil.setId(rs.getInt("id"));
				perfil.setNome(rs.getString("nome"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return perfil;
	}

	@Override
	public List<Perfil> findAll() {
		String query = "select * from perfil";
		List<Perfil> perfils = new ArrayList<Perfil>();

		Statement statment = null;
		try {
			statment = ConnectionMySQL.getConn().createStatement();
			ResultSet rs = statment.executeQuery(query);
			while (rs.next()) {
				Perfil perfil = new Perfil();
				perfil.setId(rs.getInt("id"));
				perfil.setNome(rs.getString("nome"));
				perfils.add(perfil);
			}
			statment.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return perfils;
	}
}