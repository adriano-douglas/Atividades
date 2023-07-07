package Trabalho_Etapa3_POO_AdrianoRosa.models;

import java.time.LocalDate;

public class Prato {
	
	private Integer id;
	private String nome;
	private Double precoVenda;
	private LocalDate dataValidade;
	private Double peso;
	
	public Prato() {
		super();
	}

	public Prato(Integer id, String nome, Double precoVenda, LocalDate dataValidade, Double peso) {
		super();
		this.id = id;
		this.nome = nome;
		this.precoVenda = precoVenda;
		this.dataValidade = dataValidade;
		this.peso = peso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
}

