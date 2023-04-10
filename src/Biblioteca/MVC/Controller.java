package Biblioteca.MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	LivroModel livroModel;
	CategoriaModel categoriaModel;
	CadastroView view;
	TabelaLivrosView tlView;
	TabelaCategoriasView tcView;

	public Controller(LivroModel LModel, CategoriaModel CModel, CadastroView aView, TabelaLivrosView _tlView, TabelaCategoriasView _tcView){
		livroModel = LModel;
		categoriaModel = CModel;
	    view = aView;
	    tlView = _tlView;
	    tcView = _tcView;
	    view.setBotaoLivro(new BotaoLivro());
	    view.setBotaoCategoria(new BotaoCategoria());
	    view.setBotaoLC(new BotaoLC());
	    
	    DB.carregarDados();
	    tlView.renderizarLivros(DB.livros);
	    tcView.renderizarCategorias(DB.categorias);
	    
	    view.setComboLivros(DB.livros);
	    view.setComboCategorias(DB.categorias);
    }

	class BotaoLivro implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	Integer idLivro = null;
    	Integer anoLivro = null;
    	
    	try {
    		idLivro = Integer.parseInt(view.getTextIdLivro());
        	anoLivro = Integer.parseInt(view.getTextAnoLivro());
    	} catch (Exception ex) {
    		view.exibirMensagem("ID e ano do livro precisam ser númericos!");
    		return;
    	}
    	
    	String nomeLivro = view.getTextNomeLivro();
        String autorLivro = view.getTextAutorLivro();
    	
    	if(idLivro instanceof Integer && anoLivro instanceof Integer
    			&& nomeLivro.strip().length() > 0 && autorLivro.strip().length() > 0) {	
    		
    		if(DB.existeLivroPorId(idLivro)) {
    			view.exibirMensagem("Já existe um livro cadastrado com o ID '" + idLivro + "'");
    			return;
    		}
    		
            livroModel = new LivroModel();
            livroModel.setID(idLivro);
            livroModel.setNome(nomeLivro);
            livroModel.setAutor(autorLivro);
            livroModel.setAnoPublicacao(anoLivro);
            
            DB.adicionarLivro(livroModel);
            
            tlView.renderizarLivros(DB.livros);
            view.setComboLivros(DB.livros);
            view.exibirMensagem("Livro cadastrado com sucesso!");
            
            view.limparCamposLivro();
            
    	} else {
    		view.exibirMensagem("Preencha todos os campos!\n");
    	}
    	
    }

  }
	
	class BotaoCategoria implements ActionListener{

	    @Override
	    public void actionPerformed(ActionEvent e) {
	      
	      Integer idCategoria = null;
	      
	      try {
	    	  idCategoria = Integer.parseInt(view.getTextIdCategoria());
	      } catch (Exception ex) {
	    	  view.exibirMensagem("ID da categoria precisa ser númerico!");
	    	  return;
	      }
	      
	      String nomeCategoria = view.getTextNomeCategoria();
	    
	      if(idCategoria instanceof Integer && nomeCategoria.strip().length() > 0) {
	    	  
	    	  if(DB.existeCategoriaPorId(idCategoria)) {
	    		  view.exibirMensagem("Já existe uma categoria cadastrada com o ID '" + idCategoria + "'");
	    		  return;
	    	  }
	    	  
	    	  categoriaModel = new CategoriaModel();
	    	  categoriaModel.setID(idCategoria);
	    	  categoriaModel.setNome(nomeCategoria);
	    	  
	    	  DB.adicionarCategoria(categoriaModel);
	    	  
	    	  tcView.renderizarCategorias(DB.categorias);
	    	  view.setComboCategorias(DB.categorias);
	    	  view.exibirMensagem("Categoria cadastrada com sucesso!");
	            
	          view.limparCamposCategoria();
	    	  
	      } else {
	    	  view.exibirMensagem("Preencha todos os campos!\n");
	      }

	    }

	  }
	
	class BotaoLC implements ActionListener{

	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	
	    	LivroModel livro = view.getLivroSelecionado();
	    	CategoriaModel categoria = view.getCategoriaSelecionada();
	    	
	    	if(livro == null) {
	    		view.exibirMensagem("Livro não encontrado no sistema!");
	    		return;
	    	}
	    	
	    	if(categoria == null) {
	    		view.exibirMensagem("Categoria não encontrada no sistema!");
	    		return;
	    	}
	    	
	    	if(livro instanceof LivroModel && categoria instanceof CategoriaModel) {  	
		    	if(!livro.getCategorias().contains(categoria)) {
	    			livro.adicionarCategoria(categoria);
		    		categoria.adicionarLivro(livro);
		    		
		    		tlView.renderizarLivros(DB.livros);
		    		tcView.renderizarCategorias(DB.categorias);
		    		
		    		view.exibirMensagem("Relacionamento realizado com sucesso!\n");
	    		} else {
	    			view.exibirMensagem("O relacionamento informado já existe!\n");
	    		}
	    	}

	    }

	  }
}
