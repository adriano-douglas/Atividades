package Trabalho_Etapa3_POO_AdrianoRosa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import Trabalho_Etapa3_POO_AdrianoRosa.dao.PizzaDao;
import Trabalho_Etapa3_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Borda;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Molho;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pizza;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Recheio;
import Trabalho_Etapa3_POO_AdrianoRosa.views.MontarPizzaPersonalizada;

public class PizzaPersonalizadaController {

	private static MontarPizzaPersonalizada pizzaPersonalizadaView;

	public static ArrayList<Recheio> recheiosUsados = new ArrayList<>();
	public static ArrayList<Pizza> pizzasPersonalizadas = new ArrayList<Pizza>();

	public PizzaPersonalizadaController(MontarPizzaPersonalizada _pizzaPersonalizadaView) {

		pizzaPersonalizadaView = _pizzaPersonalizadaView;

		carregarElementosPizzaPersonalizada();
		pizzaPersonalizadaView.setEventoBotaoOk(okEvento);
		pizzaPersonalizadaView.setEventoBotaoCancelar(cancelarEvento);

	}

	ActionListener okEvento = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			String tipoBorda = pizzaPersonalizadaView.getTipoBorda();
			Recheio recheioBorda = pizzaPersonalizadaView.getRecheioBordaSelecionado();
			Molho molho = pizzaPersonalizadaView.getMolhoSelecionado();

			boolean erroRecheios = false;
			String msgErroRecheios = "";

			if (recheiosUsados.isEmpty()) {
				erroRecheios = true;
				msgErroRecheios = "Selecione pelo menos um recheio.";
				pizzaPersonalizadaView.exibirMensagem(msgErroRecheios);
				return;
			}

			if (!erroRecheios) {

				recheioBorda = tipoBorda.equals("Tradicional") ? null : recheioBorda;
				Double precoBorda = tipoBorda.equals("Tradicional") ? 0.0 : 2.0;
				String nomeBorda = "Recheada com ";
				nomeBorda += recheioBorda != null ? recheioBorda.getNome() : "";
				Borda borda = new Borda(0, nomeBorda, precoBorda, recheioBorda);

				Pizza pizza = new Pizza(0, "Pizza Personalizada", 0.0,
						LocalDate.now(), 0.0, molho, recheiosUsados, borda);
				pizza.calcularPreco();
				
				int idPizza = PizzaDao.cadastrarPizza(pizza, true);
				if (idPizza == 0) {
					pizzaPersonalizadaView.exibirMensagem("Erro ao cadastrar a pizza personalizada no banco!");
					return;
				}
				pizza.setId(idPizza);
				DB.pizzasPersonalizadas.add(pizza);
				pizzasPersonalizadas.add(pizza);

				pizzaPersonalizadaView.exibirMensagem("Pizza montada com sucesso!");

				PedidoController.itensConsumidos.removeAll(PedidoController.pizzas);

				PedidoController.carregarElementosPizzas(pizzasPersonalizadas);

				pizzaPersonalizadaView.dispose();

			}

		}
	};

	ActionListener cancelarEvento = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			pizzaPersonalizadaView.dispose();
		}
	};

	public static void carregarElementosPizzaPersonalizada() {
		pizzaPersonalizadaView.setPainelConteudoRecheiosSize(DB.recheiosPizza.size());
		pizzaPersonalizadaView.carregarPainelRecheios(DB.recheiosPizza);
		pizzaPersonalizadaView.setComboMolhoModel(DB.molhosPizza);
		pizzaPersonalizadaView.setComboRecheiosBordaModel(DB.recheiosBordaPizza);
	}

}
