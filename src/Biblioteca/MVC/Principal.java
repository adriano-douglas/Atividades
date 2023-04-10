package Biblioteca.MVC;

public class Principal {

	public static void main(String[] args) {
		CategoriaModel Cmodel = new CategoriaModel();
		LivroModel Lmodel = new LivroModel();
	    CadastroView view = new CadastroView();
	    TabelaLivrosView tlView = new TabelaLivrosView();
	    TabelaCategoriasView tcView = new TabelaCategoriasView();
	    new Controller(Lmodel, Cmodel, view, tlView, tcView);
	}

}
