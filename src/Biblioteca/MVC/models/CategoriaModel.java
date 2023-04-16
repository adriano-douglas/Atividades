package Biblioteca.MVC.models;

import java.util.ArrayList;

public class CategoriaModel {
	
	private Integer ID;
	private String nome;
	private ArrayList<LivroModel> livros;
	
	public CategoriaModel() {
		super();
		this.livros = new ArrayList<>();
	}

	public CategoriaModel(Integer iD, String nome) {
		super();
		ID = iD;
		this.nome = nome;
		this.livros = new ArrayList<>();
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

	public ArrayList<LivroModel> getLivros() {
		return livros;
	}
	
	public void adicionarLivro(LivroModel livro) {
		this.getLivros().add(livro);
	}

	@Override
	public String toString() {
		return ID + " - " + nome;
	}

}
