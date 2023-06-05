package Trabalho_Etapa2_POO_AdrianoRosa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import Trabalho_Etapa2_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Lanche;
import Trabalho_Etapa2_POO_AdrianoRosa.views.CadastroLanchePanel;

public class LancheController {

	private CadastroLanchePanel cadastroLanchePanel;

	public LancheController(CadastroLanchePanel _cadastroLanchePanel) {

		cadastroLanchePanel = _cadastroLanchePanel;

		cadastroLanchePanel.setEventoBtnSalvarLanche(salvarLanche);

	}

	ActionListener salvarLanche = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = cadastroLanchePanel.getTextNome().strip();
			String dataValidade = cadastroLanchePanel.getTextDataValidade().strip();
			String recheio = cadastroLanchePanel.getTextRecheio().strip();
			String pao = cadastroLanchePanel.getTextPao().strip();
			String molho = cadastroLanchePanel.getTextMolho().strip();
			String precoVenda = cadastroLanchePanel.getTextPrecoVenda().strip();
			String peso = cadastroLanchePanel.getTextPeso().strip();

			boolean erroNome = false;
			String msgErroNome = "";

			if (nome.isBlank()) {
				erroNome = true;
				msgErroNome = "O nome é obrigatório.";
			} else if (nome.length() > 30) {
				erroNome = true;
				msgErroNome = "O nome não pode ultrapassar 30 caracteres.";
			}

			boolean erroDValidade = false;
			String msgErroDValidade = "";
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			if (dataValidade.replaceAll("[_/]", "").length() != 8) {
				msgErroDValidade = "A data de validade é obrigatória.";
				erroDValidade = true;
			} else {
				try {
					LocalDate dataValidadeFormatada = LocalDate.parse(dataValidade, formato);
					LocalDate dataAtual = LocalDate.now();
					if (dataValidadeFormatada.isBefore(dataAtual)) {
						msgErroDValidade = "A data deve ser posterior à data atual.";
						erroDValidade = true;
					}
				} catch (DateTimeParseException e1) {
					msgErroDValidade = "Data inválida.";
					erroDValidade = true;
				}
			}

			boolean erroRecheio = false;
			String msgErroRecheio = "";

			if (recheio.isBlank()) {
				erroRecheio = true;
				msgErroRecheio = "O recheio é obrigatório.";
			}

			boolean erroPao = false;
			String msgErroPao = "";

			if (pao.isBlank()) {
				erroPao = true;
				msgErroPao = "A pão é obrigatória.";
			}

			boolean erroMolho = false;
			String msgErroMolho = "";

			if (molho.isBlank()) {
				erroMolho = true;
				msgErroMolho = "O molho é obrigatório.";
			}

			boolean erroPrecoVenda = false;
			String msgErroPrecoVenda = "";
			Double precoVendaD = Double.parseDouble(precoVenda.replaceAll("[R$.]", "").substring(1).replace(",", "."));

			if (precoVendaD < 1.0 || precoVendaD > 70.0) {
				erroPrecoVenda = true;
				msgErroPrecoVenda = "Faixa de valor inválida. (1 ~ 70)";
			}

			boolean erroPeso = false;
			String msgErroPeso = "";
			Double pesoD = Double.parseDouble(peso.replaceAll("[ kg]", "").replace(",", "."));

			if (pesoD < 0.05 || pesoD > 5.0) {
				erroPeso = true;
				msgErroPeso = "Faixa de valor inválida. (0.050 ~ 5)";
			}

			cadastroLanchePanel.exibirErroNome(msgErroNome, erroNome);
			cadastroLanchePanel.exibirErroDValidade(msgErroDValidade, erroDValidade);
			cadastroLanchePanel.exibirErroPeso(msgErroPeso, erroPeso);
			cadastroLanchePanel.exibirErroPreco(msgErroPrecoVenda, erroPrecoVenda);
			cadastroLanchePanel.exibirErroRecheio(msgErroRecheio, erroRecheio);
			cadastroLanchePanel.exibirErroPao(msgErroPao, erroPao);
			cadastroLanchePanel.exibirErroMolho(msgErroMolho, erroMolho);

			if (!erroNome && !erroDValidade && !erroPeso && !erroPrecoVenda && !erroRecheio && !erroPao && !erroMolho) {

				if (DB.existeLanchePorNome(nome)) {
					cadastroLanchePanel.exibirErroNome("Já existe um lanche com este nome.", !erroNome);
					return;
				}

				Lanche lache = new Lanche(DB.ID_LANCHES++, nome, precoVendaD,
						LocalDate.parse(dataValidade, formato), pesoD, pao, recheio, molho);

				DB.lanches.add(lache);
				
				cadastroLanchePanel.exibirMensagem("Lanche cadastrado com sucesso!");
				cadastroLanchePanel.resetarCampos();
				
				for(Lanche s : DB.lanches) {
					System.out.println(s.getId() + "  " + s.getNome());
				}
			}

		}
	};

}
