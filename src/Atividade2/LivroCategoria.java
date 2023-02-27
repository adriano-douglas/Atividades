package Atividade2;

import java.util.ArrayList;

public class LivroCategoria {
	
	private Integer idLivro;
	private Integer idCategoria;
	
	public LivroCategoria() {
		super();
	}
	
	public LivroCategoria(Integer idLivro, Integer idCategoria) {
		super();
		this.idLivro = idLivro;
		this.idCategoria = idCategoria;
	}
	
	public Integer getIdLivro() {
		return idLivro;
	}
	
	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	// Método responsável por imprimir as categorias de cada um dos livros cadastrados 
	public void imprimirCategoriasLivros(ArrayList<Livro> livros, ArrayList<Categoria> categorias, ArrayList<LivroCategoria> livrosCategorias) {
		for(Livro l : livros) {
			System.out.print("\n\nNome do livro:  " + l.getNome() + "\nCategorias:\t");
			for(LivroCategoria lc : livrosCategorias) {
				if(l.getIdLivro() == lc.getIdLivro()) {
					for(Categoria c : categorias) {
						if(lc.getIdCategoria() == c.getIdCategoria()) {
							System.out.print(c.getNome() + "; ");
						}
					}
				}
			}
		}
	}
	
}
