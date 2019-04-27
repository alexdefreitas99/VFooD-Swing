package dao;

import model.Categoria;
import model.Perfil;
import model.Produto;
import model.Restaurante;
import model.Usuario;

public class DaoSupplier {
	public static DaoBase<Usuario> getDaoUsuario() {
		return new DaoUsuario();
	}

	public static DaoBase<Perfil> getDaoPerfil() {
		return new DaoPerfil();
	}

	public static DaoBase<Produto> getDaoProduto() {
		return new DaoProduto();
	}

	public static DaoBase<Restaurante> getDaoRestaurante() {
		return new DaoRestaurante();
	}

	public static DaoBase<Categoria> getDaoCategoria() {
		return new DaoCategoria();
	}

	public static DaoCompra getDaoCompra() {
		return new DaoCompra();
	}
}
