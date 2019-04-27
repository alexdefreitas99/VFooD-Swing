package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
	private String nome;
	private String telefone;
	private String email;
	private String descricao;
	private String tempoEntrega;
	private String horarioAbertura;
	private String horarioFechamento;
	private int id;
	private List<Produto> produtos = new ArrayList<>();

	public String getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(String horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public String getHorarioFechamento() {
		return horarioFechamento;
	}

	public void setHorarioFechamento(String horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTempoEntrega() {
		return tempoEntrega;
	}

	public void setTempoEntrega(String tempoEntrega) {
		this.tempoEntrega = tempoEntrega;
	}

	@Override
	public String toString() {
		return id + " - " + nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
