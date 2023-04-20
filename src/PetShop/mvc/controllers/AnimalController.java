package PetShop.mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PetShop.mvc.DB;
import PetShop.mvc.models.Animal;
import PetShop.mvc.models.CaoModel;
import PetShop.mvc.models.GatoModel;
import PetShop.mvc.models.PassaroModel;
import PetShop.mvc.models.ProprietarioModel;
import PetShop.mvc.views.CadastroAnimalView;
import PetShop.mvc.views.TabelaAnimaisView;
import PetShop.mvc.views.TabelaProprietariosView;

public class AnimalController {
	
	CadastroAnimalView cav;
	TabelaAnimaisView tav;
	TabelaProprietariosView tpv;
	
	public AnimalController(CadastroAnimalView cav, TabelaAnimaisView tav, TabelaProprietariosView tpv) {
		this.cav = cav;
		this.tav = tav;
		this.tpv = tpv;
		this.cav.setBotaoAnimal(new BotaoAnimal());
	}
	
	class BotaoAnimal implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(cav.getTextIdAnimal().isBlank() || cav.getTextNomeAnimal().isBlank() 
					|| cav.getTextCorAnimal().isBlank() || cav.getTextRacaAnimal().isBlank() 
					|| cav.getTextIdadeAnimal().isBlank() || cav.getTextSexoAnimal().isBlank()) {
				cav.exibirMensagem("Preencha todos os campos!");
				return;
			}
			
			Integer idadeMaxima = 25;
			
			if(cav.getTextEspecieAnimal().equals("Passaro")) {
				idadeMaxima = 80;
				if(cav.getTextNumeroAnilhaAnimal().isBlank()) {
					cav.exibirMensagem("Preencha todos os campos!");
					return;
				}
			} else {
				if(cav.getTextPesoAnimal().isBlank() || cav.getTextPorteAnimal().isBlank()) {
					cav.exibirMensagem("Preencha todos os campos!");
					return;
				}
			}
			
			ProprietarioModel proprietario = cav.getProprietarioSelecionado();
			
			if(proprietario == null) {
				cav.exibirMensagem("Nenhum proprietário selecionado!\nFaça o cadastro do proprietário primeiro!");
				return;
			}
			
			Integer ID = null;
			Integer idade = null;
			
			try {
				ID = Integer.parseInt(cav.getTextIdAnimal());
				idade = Integer.parseInt(cav.getTextIdadeAnimal());
				if(ID < 0) {
					cav.exibirMensagem("O ID não pode ser negativo!");
					return;
				}
				if(idade < 0 || idade > idadeMaxima) {
					cav.exibirMensagem("Idade Inválida!");
					return;
				}
			} catch (Exception ex) {
				cav.exibirMensagem("O ID e idade do animal precisam ser númericos!");
				return;
			}
			
			Double peso = null;
			
			if(!cav.getTextEspecieAnimal().equals("Passaro")) {
				try {
					peso = Double.parseDouble(cav.getTextPesoAnimal().replace(",", "."));
					if(peso < 0) {
						cav.exibirMensagem("O peso não pode ser negativo!");
						return;
					}
				} catch (Exception ex) {
					cav.exibirMensagem("O peso do animal precisa ser númerico!");
					return;
				}
			}
			
			String nome = cav.getTextNomeAnimal();
			String raca = cav.getTextRacaAnimal();
			String sexo = cav.getTextSexoAnimal();
			String cor = cav.getTextCorAnimal();
			String numeroAnilha = cav.getTextNumeroAnilhaAnimal();
			String porte = cav.getTextPorteAnimal();
			
			if(DB.existeAnimal(ID)) {
				cav.exibirMensagem("Já existe um animal cadastrado com o ID '" + ID + "'");
				return;
			}
			
			Animal animal;
			String especie = "Passaro";
			
			if(cav.getTextEspecieAnimal().equals("Passaro")) {

				if(DB.existeAnimal(numeroAnilha)) {
					cav.exibirMensagem("Já existe um pássaro cadastrado com a anilha '" + numeroAnilha + "'");
					return;
				}
				
				animal = new PassaroModel(ID, nome, idade, raca, cor, sexo, proprietario, numeroAnilha);
			} else if(cav.getTextEspecieAnimal().equals("Cao")) {
				especie = "Cachorro";
				animal = new CaoModel(ID, nome, idade, raca, cor, sexo, proprietario, porte, peso);
			} else {
				especie = "Gato";
				animal = new GatoModel(ID, nome, idade, raca, cor, sexo, proprietario, porte, peso);
			}
			
			proprietario.adicionarAnimal(animal);
			
			proprietario.getAnimais().sort((a, b) -> {
				return a.getIdade().compareTo(b.getIdade());
			});
			
			animal.setProprietario(proprietario);
			DB.animais.add(animal);
			
			cav.exibirMensagem(especie + " cadastrado com sucesso!");
			
			DB.animais.sort((a, b) -> {
				return a.getIdade().compareTo(b.getIdade());
			});
			
			cav.limparCamposAnimal();
			tav.renderizarAnimais(DB.animais);
			tpv.renderizarProprietarios(DB.proprietarios);
			
		}
		
	}

}
