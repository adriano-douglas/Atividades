package Biblioteca.MVC.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Biblioteca.MVC.DB;
import Biblioteca.MVC.models.CategoriaModel;
import Biblioteca.MVC.views.CadastroCategoriaView;
import Biblioteca.MVC.views.LivroCategoriaView;
import Biblioteca.MVC.views.TabelaCategoriasView;

public class CategoriaController {
	
	CategoriaModel categoriaModel;
	CadastroCategoriaView ccView;
	TabelaCategoriasView tcView;
	LivroCategoriaView lcView;

	public CategoriaController(CategoriaModel CModel, CadastroCategoriaView _ccView, TabelaCategoriasView _tcView, LivroCategoriaView _lcView){
		categoriaModel = CModel;
	    ccView = _ccView;
	    tcView = _tcView;
	    lcView = _lcView;
	    ccView.setBotaoCategoria(new BotaoCategoria());
	    
	    tcView.renderizarCategorias(DB.categorias);
    }
	
	class BotaoCategoria implements ActionListener{

	    @Override
	    public void actionPerformed(ActionEvent e) {
	      
		  Integer idCategoria = null;
		  
		  if(!ccView.getTextIdCategoria().isBlank()){
			  try {
				  idCategoria = Integer.parseInt(ccView.getTextIdCategoria());
			  } catch (Exception ex) {
				  ccView.exibirMensagem("ID da categoria precisa ser númerico!");
				  return;
			  }
		  }
		  
		  String nomeCategoria = ccView.getTextNomeCategoria();
		
		  if(!nomeCategoria.isBlank() && idCategoria instanceof Integer) {
			  
			  if(DB.existeCategoriaPorId(idCategoria)) {
				  ccView.exibirMensagem("Já existe uma categoria cadastrada com o ID '" + idCategoria + "'");
				  return;
			  }
			  
			  categoriaModel = new CategoriaModel();
			  categoriaModel.setID(idCategoria);
			  categoriaModel.setNome(nomeCategoria);
			  
			  DB.adicionarCategoria(categoriaModel);
			  
			  tcView.renderizarCategorias(DB.categorias);
			  lcView.setComboCategorias(DB.categorias);
			  ccView.exibirMensagem("Categoria cadastrada com sucesso!");
		        
			  ccView.limparCamposCategoria();
			  
		  } else {
			  ccView.exibirMensagem("Preencha todos os campos!\n");
		  }

	    }

	  }

}
