package PetShop.mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PetShop.mvc.DB;
import PetShop.mvc.models.ProprietarioModel;
import PetShop.mvc.views.CadastroAnimalView;
import PetShop.mvc.views.CadastroProprietarioView;
import PetShop.mvc.views.TabelaProprietariosView;

public class ProprietarioController {
	
	CadastroProprietarioView cpv;
	CadastroAnimalView cav;
	TabelaProprietariosView tpv;
	
	public ProprietarioController(CadastroProprietarioView cpv, CadastroAnimalView cav, TabelaProprietariosView tpv) {
		this.cpv = cpv;
		this.cav = cav;
		this.tpv = tpv;
		this.cpv.setBotaoProprietario(new BotaoProprietario());
	}
	
	class BotaoProprietario implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String cpf = cpv.getTextCpfProprietario();
			
			if(cpv.getTextIdProprietario().isBlank() || cpv.getTextNomeProprietario().isBlank()
					|| cpf.replace("-", "").replace(".", "").replace("_", "").length() == 0
					|| cpv.getTextEnderecoProprietario().isBlank()) {
				cpv.exibirMensagem("Preencha todos os campos!");
				return;
			}
			
			Integer ID = null;
			
			try {
				ID = Integer.parseInt(cpv.getTextIdProprietario());
				if(ID < 0) {
					cpv.exibirMensagem("O ID não pode ser negativo!");
					return;
				}
			} catch (Exception ex) {
				cpv.exibirMensagem("O ID informado precisa ser númerico!");
				return;
			}
			
			String nome = cpv.getTextNomeProprietario();
			String endereco = cpv.getTextEnderecoProprietario();
			
			if(DB.existeProprietario(ID)) {
				cpv.exibirMensagem("Já existe um proprietário cadastrado com o ID '" + ID + "'");
				return;
			}
			
			if(DB.existeProprietario(cpf)) {
				cpv.exibirMensagem("Já existe um proprietário cadastrado com o CPF informado!");
				return;
			}
			
			DB.proprietarios.add(new ProprietarioModel(ID, cpf, nome, endereco));
			cpv.exibirMensagem("Proprietário cadastrado com sucesso!");
			
			cpv.limparCamposProprietario();
			cav.setComboProprietarios(DB.proprietarios);
			tpv.renderizarProprietarios(DB.proprietarios);
		}
		
	}

}
