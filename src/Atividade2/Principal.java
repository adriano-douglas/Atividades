package Atividade2;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Livro> livros = new ArrayList<Livro>();
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		ArrayList<LivroCategoria> livrosCategorias = new ArrayList<LivroCategoria>();
		
		livros.add(new Livro("livro 1", "autor 1", 1, 2000));
		livros.add(new Livro("livro 2", "autor 2", 2, 2001));
		livros.add(new Livro("livro 3", "autor 3", 3, 2002));
		livros.add(new Livro("livro 4", "autor 4", 4, 2003));
		livros.add(new Livro("livro 5", "autor 5", 5, 2004));
		livros.add(new Livro("livro 6", "autor 6", 6, 2005));
		livros.add(new Livro("livro 7", "autor 7", 7, 2006));
		livros.add(new Livro("livro 8", "autor 8", 8, 2007));
		livros.add(new Livro("livro 9", "autor 9", 9, 2008));
		livros.add(new Livro("livro 10", "autor 10", 10, 2009));
		
		categorias.add(new Categoria(1, "Categoria 1"));
		categorias.add(new Categoria(2, "Categoria 2"));
		categorias.add(new Categoria(3, "Categoria 3"));
		categorias.add(new Categoria(4, "Categoria 4"));
		
		livrosCategorias.add(new LivroCategoria(1, 1));
		livrosCategorias.add(new LivroCategoria(2, 2));
		livrosCategorias.add(new LivroCategoria(3, 3));
		livrosCategorias.add(new LivroCategoria(4, 4));
		livrosCategorias.add(new LivroCategoria(5, 1));
		livrosCategorias.add(new LivroCategoria(6, 2));
		livrosCategorias.add(new LivroCategoria(7, 3));
		livrosCategorias.add(new LivroCategoria(8, 4));
		livrosCategorias.add(new LivroCategoria(9, 1));
		livrosCategorias.add(new LivroCategoria(10, 2));
		livrosCategorias.add(new LivroCategoria(1, 3));
		livrosCategorias.add(new LivroCategoria(5, 4));
		livrosCategorias.add(new LivroCategoria(2, 3));
		livrosCategorias.add(new LivroCategoria(6, 1));
		livrosCategorias.add(new LivroCategoria(10, 4));
		livrosCategorias.add(new LivroCategoria(2, 4));
		livrosCategorias.add(new LivroCategoria(8, 3));
		livrosCategorias.add(new LivroCategoria(8, 1));
		
		LivroCategoria livroCategoria = new LivroCategoria();
		
		livroCategoria.imprimirCategoriasLivros(livros, categorias, livrosCategorias);
		
	}

}
