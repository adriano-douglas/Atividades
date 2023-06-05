package Trabalho_Etapa2_POO_AdrianoRosa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import Trabalho_Etapa2_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Borda;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Molho;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Pizza;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Recheio;
import Trabalho_Etapa2_POO_AdrianoRosa.views.CadastroPizzaPanel;

public class PizzaController {

	private static CadastroPizzaPanel cadastroPizzaPanel;

	public static ArrayList<Recheio> recheiosUsados = new ArrayList<>();

	public PizzaController(CadastroPizzaPanel _cadastroPizzaPanel) {

		cadastroPizzaPanel = _cadastroPizzaPanel;

		cadastroPizzaPanel.setComboMolhoModel(DB.molhosPizza);
		cadastroPizzaPanel.setComboRecheiosBordaModel(DB.recheiosBordaPizza);
		cadastroPizzaPanel.setEventoBotaoSalvarPizza(salvarPizza);

	}

	ActionListener salvarPizza = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = cadastroPizzaPanel.getTextNome().strip();
			String dataValidade = cadastroPizzaPanel.getDValidade().strip();
			String precoVenda = cadastroPizzaPanel.getTextPreco().strip();
			String peso = cadastroPizzaPanel.getTextPeso().strip();
			String tipoBorda = cadastroPizzaPanel.getTipoBorda();
			Recheio recheioBorda = cadastroPizzaPanel.getRecheioBordaSelecionado();
			Molho molho = cadastroPizzaPanel.getMolhoSelecionado();

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

			boolean erroRecheios = false;
			String msgErroRecheios = "";

			if (recheiosUsados.isEmpty()) {
				erroRecheios = true;
				msgErroRecheios = "Selecione pelo menos um recheio.";
			}

			boolean erroPrecoVenda = false;
			String msgErroPrecoVenda = "";
			Double precoVendaD = Double.parseDouble(precoVenda.replaceAll("[R$.]", "").substring(1).replace(",", "."));

			if (precoVendaD < 20.0 || precoVendaD > 200.0) {
				erroPrecoVenda = true;
				msgErroPrecoVenda = "Faixa de valor inválida. (20 ~ 200)";
			}

			boolean erroPeso = false;
			String msgErroPeso = "";
			Double pesoD = Double.parseDouble(peso.replaceAll("[ kg]", "").replace(",", "."));

			if (pesoD < 0.5 || pesoD > 5.0) {
				erroPeso = true;
				msgErroPeso = "Faixa de valor inválida. (0.500 ~ 5)";
			}

			cadastroPizzaPanel.exibirErroNome(msgErroNome, erroNome);
			cadastroPizzaPanel.exibirErroDValidade(msgErroDValidade, erroDValidade);
			cadastroPizzaPanel.exibirErroPeso(msgErroPeso, erroPeso);
			cadastroPizzaPanel.exibirErroPreco(msgErroPrecoVenda, erroPrecoVenda);
			cadastroPizzaPanel.exibirErroRecheios(msgErroRecheios, erroRecheios);

			if (!erroNome && !erroDValidade && !erroPeso && !erroPrecoVenda && !erroRecheios) {

				if (DB.existePizzaPorNome(nome)) {
					cadastroPizzaPanel.exibirErroNome("Já existe uma pizza com este nome.", !erroNome);
					return;
				}

				recheioBorda = tipoBorda.equals("Tradicional") ? null : recheioBorda;
				Double precoBorda = tipoBorda.equals("Tradicional") ? 0.0 : 2.0;
				String nomeBorda = "Recheada com ";
				nomeBorda += recheioBorda != null ? recheioBorda.getNome() : "";
				Borda borda = new Borda(DB.ID_BORDAP++, nomeBorda, precoBorda, recheioBorda);

				Pizza pizza = new Pizza(DB.ID_PIZZA++, nome, precoVendaD, LocalDate.parse(dataValidade, formato), pesoD,
						molho, recheiosUsados, borda);

				DB.pizzas.add(pizza);

				cadastroPizzaPanel.exibirMensagem("Pizza cadastrada com sucesso!");
				resetarCampos();

				for (Pizza s : DB.pizzas) {
					System.out.println(s.getId() + "  " + s.getNome());
				}
			}

		}
	};
	
	public static void carregarRecheios() {
		cadastroPizzaPanel.setPainelConteudoRecheiosSize(DB.recheiosPizza.size());
		cadastroPizzaPanel.carregarPainelRecheios(DB.recheiosPizza);
		cadastroPizzaPanel.tornarInvisivel();
		cadastroPizzaPanel.tornarVisivel();
	}
	
	public static void resetarCampos() {
		cadastroPizzaPanel.resetarCampos();
		cadastroPizzaPanel.setComboMolhoModel(DB.molhosPizza);
		cadastroPizzaPanel.setComboRecheiosBordaModel(DB.recheiosBordaPizza);
		carregarRecheios();
		recheiosUsados.clear();
	}

}
