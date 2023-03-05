package Aula03HerancaAdriano;

import java.util.Date;

public abstract class Pessoa {
	
	private String nome;
	private String cpf;
	private Date dataNascimento;
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(String nome, String cpf, Date dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public double tirarCopias(Integer numeroCopias) {
		return numeroCopias * 0.1;
	}
	
}