package Biblioteca.MVC.models;

import java.util.ArrayList;

public class LivroModel {
	
	private Integer ID;
	private String nome;
	private String autor;
	private Integer anoPublicacao;
	private ArrayList<CategoriaModel> categorias;
	
	public LivroModel() {
		super();
		this.categorias = new ArrayList<>();
	}

	public LivroModel(Integer iD, String nome, String autor, Integer anoPublicacao) {
		super();
		ID = iD;
		this.nome = nome;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;
		this.categorias = new ArrayList<>();
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Integer anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public ArrayList<CategoriaModel> getCategorias() {
		return categorias;
	}
	
	public void adicionarCategoria(CategoriaModel categoria) {
		this.getCategorias().add(categoria);
	}

	@Override
	public String toString() {
		return ID + " - " + nome;
	}

}
