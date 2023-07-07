package Trabalho_Etapa3_POO_AdrianoRosa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Trabalho_Etapa3_POO_AdrianoRosa.dao.ItensPizzaDao;
import Trabalho_Etapa3_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Molho;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Recheio;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CadastroItensPizzaPanel;

public class ItensPizzaController {

	private CadastroItensPizzaPanel cadastroItensPizzaPanel;

	public ItensPizzaController(CadastroItensPizzaPanel _cadastroItensPizzaPanel) {

		cadastroItensPizzaPanel = _cadastroItensPizzaPanel;

		cadastroItensPizzaPanel.setEventoBtnSalvarMolho(salvarMolho);
		cadastroItensPizzaPanel.setEventoBtnSalvarRecheioP(salvarRecheioP);
		cadastroItensPizzaPanel.setEventoBtnSalvarRecheioB(salvarRecheioB);

	}

	ActionListener salvarMolho = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = cadastroItensPizzaPanel.getTextNomeMolho().strip();
			String preco = cadastroItensPizzaPanel.getTextPrecoMolho().strip();

			boolean erroNomeMolho = false;
			String msgErroNomeMolho = "";

			if (nome.isBlank()) {
				erroNomeMolho = true;
				msgErroNomeMolho = "O nome é obrigatório.";
			} else if (nome.length() > 30) {
				erroNomeMolho = true;
				msgErroNomeMolho = "O nome não pode ultrapassar 30 caracteres.";
			}

			boolean erroPrecoMolho = false;
			String msgErroPrecoMolho = "";
			Double precoD = Double.parseDouble(preco.replaceAll("[R$.]", "").substring(1).replace(",", "."));

			if (precoD < 1.0 || precoD > 50.0) {
				erroPrecoMolho = true;
				msgErroPrecoMolho = "Faixa de valor inválida. (1 ~ 50)";
			}

			cadastroItensPizzaPanel.exibirErroNomeMolho(msgErroNomeMolho, erroNomeMolho);
			cadastroItensPizzaPanel.exibirErroPrecoMolho(msgErroPrecoMolho, erroPrecoMolho);

			if (!erroNomeMolho && !erroPrecoMolho) {

				if (DB.existeMolhoPorNome(nome)) {
					cadastroItensPizzaPanel.exibirErroNomeMolho("Já existe um molho com este nome.", !erroNomeMolho);
					return;
				}

				Molho molho = new Molho(0, nome, precoD);
				
				int idMolho = ItensPizzaDao.cadastrarMolhoPizza(molho);
				if(idMolho == 0) {
					cadastroItensPizzaPanel.exibirMensagem("Erro ao cadastrar o molho no banco!");
					return;
				}
				molho.setId(idMolho);
				DB.molhosPizza.add(molho);

				cadastroItensPizzaPanel.exibirMensagem("Molho cadastrado com sucesso!");
				cadastroItensPizzaPanel.resetarCampos();

				for (Molho s : DB.molhosPizza) {
					System.out.println(s.getId() + "  " + s.getNome());
				}
			}

		}
	};

	ActionListener salvarRecheioP = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = cadastroItensPizzaPanel.getTextNomeRecheioP().strip();
			String preco = cadastroItensPizzaPanel.getTextPrecoRecheioP().strip();

			boolean erroNomeRecheioP = false;
			String msgErroNomeRecheioP = "";

			if (nome.isBlank()) {
				erroNomeRecheioP = true;
				msgErroNomeRecheioP = "O nome é obrigatório.";
			} else if (nome.length() > 30) {
				erroNomeRecheioP = true;
				msgErroNomeRecheioP = "O nome não pode ultrapassar 30 caracteres.";
			}

			boolean erroPrecoRecheioP = false;
			String msgErroPrecoRecheioP = "";
			Double precoD = Double.parseDouble(preco.replaceAll("[R$.]", "").substring(1).replace(",", "."));

			if (precoD < 1.0 || precoD > 50.0) {
				erroPrecoRecheioP = true;
				msgErroPrecoRecheioP = "Faixa de valor inválida. (1 ~ 50)";
			}

			cadastroItensPizzaPanel.exibirErroNomeRecheioP(msgErroNomeRecheioP, erroNomeRecheioP);
			cadastroItensPizzaPanel.exibirErroPrecoRecheioP(msgErroPrecoRecheioP, erroPrecoRecheioP);

			if (!erroNomeRecheioP && !erroPrecoRecheioP) {

				if (DB.existeRecheioPPorNome(nome)) {
					cadastroItensPizzaPanel.exibirErroNomeRecheioP("Já existe um recheio com este nome.",
							!erroNomeRecheioP);
					return;
				}

				Recheio recheio = new Recheio(0, nome, precoD);
				
				int idRecheioPizza = ItensPizzaDao.cadastrarRecheioPizza(recheio);
				if(idRecheioPizza == 0) {
					cadastroItensPizzaPanel.exibirMensagem("Erro ao cadastrar o recheio no banco!");
					return;
				}
				recheio.setId(idRecheioPizza);
				DB.recheiosPizza.add(recheio);

				cadastroItensPizzaPanel.exibirMensagem("Recheio cadastrado com sucesso!");
				cadastroItensPizzaPanel.resetarCampos();

				for (Recheio s : DB.recheiosPizza) {
					System.out.println(s.getId() + "  " + s.getNome());
				}
			}

		}
	};

	ActionListener salvarRecheioB = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = cadastroItensPizzaPanel.getTextNomeRecheioB().strip();
			String preco = cadastroItensPizzaPanel.getTextPrecoRecheioB().strip();

			boolean erroNomeRecheioB = false;
			String msgErroNomeRecheioB = "";

			if (nome.isBlank()) {
				erroNomeRecheioB = true;
				msgErroNomeRecheioB = "O nome é obrigatório.";
			} else if (nome.length() > 30) {
				erroNomeRecheioB = true;
				msgErroNomeRecheioB = "O nome não pode ultrapassar 30 caracteres.";
			}

			boolean erroPrecoRecheioB = false;
			String msgErroPrecoRecheioB = "";
			Double precoD = Double.parseDouble(preco.replaceAll("[R$.]", "").substring(1).replace(",", "."));

			if (precoD < 1.0 || precoD > 50.0) {
				erroPrecoRecheioB = true;
				msgErroPrecoRecheioB = "Faixa de valor inválida. (1 ~ 50)";
			}

			cadastroItensPizzaPanel.exibirErroNomeRecheioB(msgErroNomeRecheioB, erroNomeRecheioB);
			cadastroItensPizzaPanel.exibirErroPrecoRecheioB(msgErroPrecoRecheioB, erroPrecoRecheioB);

			if (!erroNomeRecheioB && !erroPrecoRecheioB) {

				if (DB.existeRecheioBPPorNome(nome)) {
					cadastroItensPizzaPanel.exibirErroNomeRecheioB("Já existe um recheio de borda com este nome.",
							!erroNomeRecheioB);
					return;
				}

				Recheio recheio = new Recheio(0, nome, precoD);
				
				int idRecheioBordaPizza = ItensPizzaDao.cadastrarRecheioBordaPizza(recheio);
				if(idRecheioBordaPizza == 0) {
					cadastroItensPizzaPanel.exibirMensagem("Erro ao cadastrar o recheio de borda no banco!");
					return;
				}
				recheio.setId(idRecheioBordaPizza);
				DB.recheiosBordaPizza.add(recheio);

				cadastroItensPizzaPanel.exibirMensagem("Recheio de borda cadastrado com sucesso!");
				cadastroItensPizzaPanel.resetarCampos();

				for (Recheio s : DB.recheiosBordaPizza) {
					System.out.println(s.getId() + "  " + s.getNome());
				}
			}

		}
	};

}
