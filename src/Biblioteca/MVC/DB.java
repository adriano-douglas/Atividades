package Biblioteca.MVC;

import java.util.ArrayList;

import Biblioteca.MVC.models.CategoriaModel;
import Biblioteca.MVC.models.LivroModel;

public class DB {
	
	public static ArrayList<LivroModel> livros = new ArrayList<LivroModel>();
	public static ArrayList<CategoriaModel> categorias = new ArrayList<CategoriaModel>();
	
	public static void carregarDados() {
		livros.add(new LivroModel(1, "livro 1", "autor 1", 2001));
		livros.add(new LivroModel(2, "livro 2", "autor 2", 2002));
		livros.add(new LivroModel(3, "livro 3", "autor 3", 2003));
		
		categorias.add(new CategoriaModel(1, "categoria 1"));
		categorias.add(new CategoriaModel(2, "categoria 2"));
		categorias.add(new CategoriaModel(3, "categoria 3"));
		categorias.add(new CategoriaModel(4, "categoria 4"));
	}
	
	public static void adicionarLivro(LivroModel livro) {
		livros.add(livro);
	}
	
	public static boolean existeLivroPorId(Integer id) {
		for(LivroModel l : livros) {
			if(id.equals(l.getID())) return true;
		}
		return false;
	}
	
	public static LivroModel buscarLivroPorId(Integer id) {
		for(LivroModel l : livros) {
			if(id.equals(l.getID())) return l;
		}
		return null;
	}
	
	public static void adicionarCategoria(CategoriaModel categoria) {
		categorias.add(categoria);
	}
	
	public static boolean existeCategoriaPorId(Integer id) {
		for(CategoriaModel c : categorias) {
			if(id.equals(c.getID())) return true;
		}
		return false;
	}
	
	public static CategoriaModel buscarCategoriaPorId(Integer id) {
		for(CategoriaModel c : categorias) {
			if(id.equals(c.getID())) return c;
		}
		return null;
	}

}
