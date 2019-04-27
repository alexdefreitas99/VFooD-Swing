package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionMySQL;
import model.Usuario;

final class DaoUsuario implements DaoBase<Usuario> {

	@Override
	public void insert(Usuario object) {
		String query = " insert into usuario (nome,idPerfil)" + " values (?,?)";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			preparedStmt.setString(1, object.getNome());
			preparedStmt.setInt(2, object.getPerfil().getId());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Usuario object) {
		String query = "update usuario set status = 0 where id = ?";
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
	public void delete(Usuario object) {
		String query = "DELETE FROM usuario WHERE id = ?";
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
	public Usuario findById(int id) {
		String query = "select * from usuario where id =?";
		Usuario usuario = null;
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySQL.getConn().prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));

				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public List<Usuario> findAll() {
		String query = "select * from usuario where status=true;";
		List<Usuario> usuarios = new ArrayList<Usuario>();

		Statement statment = null;
		try {
			statment = ConnectionMySQL.getConn().createStatement();
			ResultSet rs = statment.executeQuery(query);
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPerfil(DaoSupplier.getDaoPerfil().findById(rs.getInt("IdPerfil")));
				usuarios.add(usuario);
			}
			statment.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

}
