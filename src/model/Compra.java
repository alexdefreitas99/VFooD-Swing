package model;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	@Override
	public String toString() {
		return "Compra id:" + id;
	}

	private int id;
	private Usuario IdUsuario;
	private Restaurante IdRestaurante;
	private List<Produto> produtos = new ArrayList<>();

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		IdUsuario = idUsuario;
	}

	public Restaurante getIdRestaurante() {
		return IdRestaurante;
	}

	public void setIdRestaurante(Restaurante idRestaurante) {
		IdRestaurante = idRestaurante;
	}
	
	public double getValorTotal() {
		double vl = 0;
		for (Produto produto : produtos) {
			vl += produto.getPreco();
		}
		return vl;
	}
}
