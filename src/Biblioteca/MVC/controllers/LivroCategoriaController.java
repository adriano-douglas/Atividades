package Biblioteca.MVC.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Biblioteca.MVC.DB;
import Biblioteca.MVC.models.CategoriaModel;
import Biblioteca.MVC.models.LivroModel;
import Biblioteca.MVC.views.LivroCategoriaView;
import Biblioteca.MVC.views.TabelaCategoriasView;
import Biblioteca.MVC.views.TabelaLivrosView;

public class LivroCategoriaController {
	
	LivroCategoriaView lcView;
	TabelaCategoriasView tcView;
	TabelaLivrosView tlView;
	
	public LivroCategoriaController(LivroCategoriaView _lcView, TabelaCategoriasView _tcView, TabelaLivrosView _tlView) {
		lcView = _lcView;
		tcView = _tcView;
		tlView = _tlView;
		lcView.setBotaoLC(new BotaoLC());
	    
		lcView.setComboLivros(DB.livros);
		lcView.setComboCategorias(DB.categorias);
	}
	
	class BotaoLC implements ActionListener{

	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	
	    	LivroModel livro = lcView.getLivroSelecionado();
	    	CategoriaModel categoria = lcView.getCategoriaSelecionada();
	    	
	    	if(livro == null) {
	    		lcView.exibirMensagem("Livro não encontrado no sistema!");
	    		return;
	    	}
	    	
	    	if(categoria == null) {
	    		lcView.exibirMensagem("Categoria não encontrada no sistema!");
	    		return;
	    	}
	    	
	    	if(livro instanceof LivroModel && categoria instanceof CategoriaModel) {  	
		    	if(!livro.getCategorias().contains(categoria)) {
	    			livro.adicionarCategoria(categoria);
		    		categoria.adicionarLivro(livro);
		    		
		    		tlView.renderizarLivros(DB.livros);
		    		tcView.renderizarCategorias(DB.categorias);
		    		
		    		lcView.exibirMensagem("Relacionamento realizado com sucesso!\n");
	    		} else {
	    			lcView.exibirMensagem("O relacionamento informado já existe!\n");
	    		}
	    	}

	    }

	  }

}
