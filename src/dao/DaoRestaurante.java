package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionMySQL;
import model.Restaurante;

final class DaoRestaurante implements DaoBase<Restaurante> {

	@Override
	public void insert(Restaurante object) {
		String query = " insert into restaurante (nome,telefone,email,descricao,tempoEntrega,horarioAbertura,horarioFechamento)"
				+ " values (?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			preparedStmt.setString(1, object.getNome());
			preparedStmt.setString(2, object.getTelefone());
			preparedStmt.setString(3, object.getEmail());
			preparedStmt.setString(4, object.getDescricao());
			preparedStmt.setString(5, object.getTempoEntrega());
			preparedStmt.setString(6, object.getHorarioAbertura());
			preparedStmt.setString(7, object.getHorarioFechamento());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Restaurante object) {
		String query = "update restaurante set status = 0 where id = ?";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			preparedStmt.setInt(1, object.getId());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Restaurante object) {
		String query = "DELETE FROM restaurante WHERE id = ?";
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
	public Restaurante findById(int id) {
		String query = "select * from restaurante where id =?";
		Restaurante restaurante = null;
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				restaurante = new Restaurante();
				restaurante.setId(rs.getInt("id"));
				restaurante.setNome(rs.getString("nome"));
				restaurante.setProdutos(new DaoProduto().getByIdRestaurante(restaurante.getId()));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurante;
	}

	@Override
	public List<Restaurante> findAll() {
		String query = "select * from restaurante where status=true";
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();

		Statement statment = null;
		try {
			statment = ConnectionMySQL.getConn().createStatement();
			ResultSet rs = statment.executeQuery(query);
			while (rs.next()) {
				Restaurante restaurante = new Restaurante();
				restaurante.setId(rs.getInt("id"));
				restaurante.setNome(rs.getString("nome"));
				restaurantes.add(restaurante);
			}
			statment.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurantes;
	}

}
