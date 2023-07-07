package Trabalho_Etapa3_POO_AdrianoRosa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import Trabalho_Etapa3_POO_AdrianoRosa.dao.SalgadinhoDao;
import Trabalho_Etapa3_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Salgadinho;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CadastroSalgadinhoPanel;

public class SalgadinhoController {

	private CadastroSalgadinhoPanel cadastroSalgadinhoPanel;

	public SalgadinhoController(CadastroSalgadinhoPanel _cadastroSalgadinhoPanel) {

		cadastroSalgadinhoPanel = _cadastroSalgadinhoPanel;

		cadastroSalgadinhoPanel.setEventoBtnSalvarSalgadinho(salvarSalgadinho);

	}

	ActionListener salvarSalgadinho = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = cadastroSalgadinhoPanel.getTextNome().strip();
			String dataValidade = cadastroSalgadinhoPanel.getTextDataValidade().strip();
			String recheio = cadastroSalgadinhoPanel.getTextRecheio().strip();
			String massa = cadastroSalgadinhoPanel.getTextMassa().strip();
			String tipo = cadastroSalgadinhoPanel.getTextTipo().strip();
			String precoVenda = cadastroSalgadinhoPanel.getTextPrecoVenda().strip();
			String peso = cadastroSalgadinhoPanel.getTextPeso().strip();

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

			boolean erroMassa = false;
			String msgErroMassa = "";

			if (massa.isBlank()) {
				erroMassa = true;
				msgErroMassa = "A massa é obrigatória.";
			}

			boolean erroTipo = false;
			String msgErroTipo = "";

			if (tipo.isBlank()) {
				erroTipo = true;
				msgErroTipo = "O tipo é obrigatório.";
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

			cadastroSalgadinhoPanel.exibirErroNome(msgErroNome, erroNome);
			cadastroSalgadinhoPanel.exibirErroDValidade(msgErroDValidade, erroDValidade);
			cadastroSalgadinhoPanel.exibirErroPeso(msgErroPeso, erroPeso);
			cadastroSalgadinhoPanel.exibirErroPreco(msgErroPrecoVenda, erroPrecoVenda);
			cadastroSalgadinhoPanel.exibirErroRecheio(msgErroRecheio, erroRecheio);
			cadastroSalgadinhoPanel.exibirErroMassa(msgErroMassa, erroMassa);
			cadastroSalgadinhoPanel.exibirErroTipo(msgErroTipo, erroTipo);

			if (!erroNome && !erroDValidade && !erroPeso && !erroPrecoVenda && !erroRecheio && !erroMassa && !erroTipo) {

				if (DB.existeSalgadinhoPorNome(nome)) {
					cadastroSalgadinhoPanel.exibirErroNome("Já existe um salgadinho com este nome.", !erroNome);
					return;
				}

				Salgadinho salgadinho = new Salgadinho(0, nome, precoVendaD,
						LocalDate.parse(dataValidade, formato), pesoD, recheio, massa, tipo);

				int idSalgadinho = SalgadinhoDao.cadastrarSalgadinho(salgadinho);
				if(idSalgadinho == 0) {
					cadastroSalgadinhoPanel.exibirMensagem("Erro ao cadastrar o salgadinho no banco!");
					return;
				}
				salgadinho.setId(idSalgadinho);
				DB.salgadinhos.add(salgadinho);
				
				cadastroSalgadinhoPanel.exibirMensagem("Salgadinho cadastrado com sucesso!");
				cadastroSalgadinhoPanel.resetarCampos();
				
				for(Salgadinho s : DB.salgadinhos) {
					System.out.println(s.getId() + "  " + s.getNome());
				}
			}

		}
	};

}
