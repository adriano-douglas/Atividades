package Biblioteca.MVC.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import Biblioteca.MVC.DB;
import Biblioteca.MVC.models.LivroModel;
import Biblioteca.MVC.views.CadastroLivroView;
import Biblioteca.MVC.views.LivroCategoriaView;
import Biblioteca.MVC.views.TabelaLivrosView;

public class LivroController {
	
	LivroModel livroModel;
	CadastroLivroView clView;
	TabelaLivrosView tlView;
	LivroCategoriaView lcView;
	
	public LivroController(LivroModel LModel, CadastroLivroView _clView, TabelaLivrosView _tlView, LivroCategoriaView _lcView){
		livroModel = LModel;
		clView = _clView;
	    tlView = _tlView;
	    lcView = _lcView;
	    clView.setBotaoLivro(new BotaoLivro());
	    
	    tlView.renderizarLivros(DB.livros);
    }
	
	class BotaoLivro implements ActionListener{

	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	
	    	Integer idLivro = null;
	    	Integer anoLivro = null;
	    	
	    	if(!clView.getTextIdLivro().isBlank() && !clView.getTextAnoLivro().isBlank()) {
	    		try {
		    		idLivro = Integer.parseInt(clView.getTextIdLivro());
		        	anoLivro = Integer.parseInt(clView.getTextAnoLivro());
		    	} catch (Exception ex) {
		    		clView.exibirMensagem("ID e ano do livro precisam ser númericos!");
		    		return;
		    	}
	    	}
	    	
	    	String nomeLivro = clView.getTextNomeLivro();
	        String autorLivro = clView.getTextAutorLivro();
	    	
	    	if(!nomeLivro.isBlank() && !autorLivro.isBlank() && idLivro instanceof Integer && anoLivro instanceof Integer) {
	    		
	    		if(!anoValido(anoLivro)) {
		    		clView.exibirMensagem("O ano informado é inválido!");
		    		return;
		    	}
	    		
	    		if(DB.existeLivroPorId(idLivro)) {
	    			clView.exibirMensagem("Já existe um livro cadastrado com o ID '" + idLivro + "'");
	    			return;
	    		}
	    		
	            livroModel = new LivroModel();
	            livroModel.setID(idLivro);
	            livroModel.setNome(nomeLivro);
	            livroModel.setAutor(autorLivro);
	            livroModel.setAnoPublicacao(anoLivro);
	            
	            DB.adicionarLivro(livroModel);
	            
	            tlView.renderizarLivros(DB.livros);
	            lcView.setComboLivros(DB.livros);
	            clView.exibirMensagem("Livro cadastrado com sucesso!");
	            
	            clView.limparCamposLivro();
	            
	    	} else {
	    		clView.exibirMensagem("Preencha todos os campos!\n");
	    	}
	    	
	    }

	}
	
	public static boolean anoValido(Integer ano) {
        return ano >= 1455 && ano <= LocalDate.now().getYear();
    }

}
