package Grafica;

import java.util.ArrayList;

public abstract class Setor {
	
	private String ID;
	private String nome;
	private Gerente gerente;
	private ArrayList<Empregado> empregados;
	
	public Setor(String ID, String nome) {
		super();
		this.ID = ID;
		this.nome = nome;
		this.empregados = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public ArrayList<Empregado> getEmpregados() {
		return empregados;
	}
	
	public void adicionarEmpregado(Empregado empregado) {
		this.getEmpregados().add(empregado);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}
