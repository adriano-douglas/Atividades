package Lanchonete;

import java.util.Date;

public abstract class Prato {
	
	private String ID;
	private String nome;
	private Double precoVenda;
	private Date dataValidade;
	private Double peso;
	
	public Prato(String ID, String nome, Double precoVenda, Date dataValidade, Double peso) {
		super();
		this.ID = ID;
		this.nome = nome;
		this.precoVenda = precoVenda;
		this.dataValidade = dataValidade;
		this.peso = peso;
	}

	public Prato(String nome, Date dataValidade, Double peso) {
		super();
		this.nome = nome;
		this.dataValidade = dataValidade;
		this.peso = peso;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}
	
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public Date getDataValidade() {
		return dataValidade;
	}
	
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}
