package Biblioteca.MVC;

import Biblioteca.MVC.controllers.CategoriaController;
import Biblioteca.MVC.controllers.LivroCategoriaController;
import Biblioteca.MVC.controllers.LivroController;
import Biblioteca.MVC.models.CategoriaModel;
import Biblioteca.MVC.models.LivroModel;
import Biblioteca.MVC.views.CadastroCategoriaView;
import Biblioteca.MVC.views.CadastroLivroView;
import Biblioteca.MVC.views.LivroCategoriaView;
import Biblioteca.MVC.views.TelaInicialView;
import Biblioteca.MVC.views.TabelaCategoriasView;
import Biblioteca.MVC.views.TabelaLivrosView;

public class Principal {

	public static void main(String[] args) {
		CategoriaModel cModel = new CategoriaModel();
		LivroModel lModel = new LivroModel();
	    CadastroLivroView clView = new CadastroLivroView();
	    CadastroCategoriaView ccView = new CadastroCategoriaView();
	    LivroCategoriaView lcView = new LivroCategoriaView();
	    TabelaLivrosView tlView = new TabelaLivrosView();
	    TabelaCategoriasView tcView = new TabelaCategoriasView();
	    
	    DB.carregarDados();
	    
	    new LivroController(lModel, clView, tlView, lcView);
	    new CategoriaController(cModel, ccView, tcView, lcView);
	    new LivroCategoriaController(lcView, tcView, tlView);
	    
	    new TelaInicialView(ccView, clView, lcView, tcView, tlView);
	}

}
