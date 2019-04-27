package model;

public class Produto {
	private String nome;
	private double preco;
	private double tempoPreparo;
	private Categoria categoria;
	private Restaurante Restaurante;
	private int id;

	public Restaurante getRestaurante() {
		return Restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		Restaurante = restaurante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(double tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return nome;
	}

}
