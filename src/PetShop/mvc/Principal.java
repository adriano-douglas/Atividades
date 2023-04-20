package PetShop.mvc;

import PetShop.mvc.controllers.AnimalController;
import PetShop.mvc.controllers.ProprietarioController;
import PetShop.mvc.views.CadastroAnimalView;
import PetShop.mvc.views.CadastroProprietarioView;
import PetShop.mvc.views.TabelaAnimaisView;
import PetShop.mvc.views.TabelaProprietariosView;
import PetShop.mvc.views.TelaInicialView;

public class Principal {

	public static void main(String[] args) {
		CadastroProprietarioView cpv = new CadastroProprietarioView();
		CadastroAnimalView cav = new CadastroAnimalView();
		TabelaAnimaisView tav = new TabelaAnimaisView();
		TabelaProprietariosView tpv = new TabelaProprietariosView();
		
		new AnimalController(cav, tav, tpv);
		new ProprietarioController(cpv, cav, tpv);
		
		new TelaInicialView(cpv, cav, tav, tpv);
	}

}
