package Trabalho_Etapa3_POO_AdrianoRosa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Trabalho_Etapa3_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pedido;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pizza;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Prato;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CriarPedido1;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CriarPedido2;
import Trabalho_Etapa3_POO_AdrianoRosa.views.TelaInicial;

public class PedidoController {

	public static Pedido pedido = new Pedido();

	public static ArrayList<Prato> itensConsumidos = new ArrayList<>();
	public static Map<Prato, Integer> quantidades = new HashMap<>();

	public static ArrayList<Pizza> pizzas = new ArrayList<>();

	private TelaInicial telaInicialView;
	private static CriarPedido1 criarPedido1;
	private static CriarPedido2 criarPedido2;

	public PedidoController(TelaInicial _telaInicialView, CriarPedido1 _criarPedido1, CriarPedido2 _criarPedido2) {

		telaInicialView = _telaInicialView;
		criarPedido1 = _criarPedido1;
		criarPedido2 = _criarPedido2;

		carregarElementosPedido();

		criarPedido1.setEventoBotaoPersonalizarPizza(montarPizzaPesonalizada);
		criarPedido1.setEventoBotaoContinuarPedido(continuarPedido);
	}

	ActionListener continuarPedido = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (itensConsumidos.isEmpty()) {
				criarPedido1.exibirMensagem("Selecione no mínimo um prato.");
				return;
			}

			ArrayList<Integer> qdtItens = new ArrayList<>();
			ArrayList<Prato> pratos = new ArrayList<>();
			pratos.addAll(itensConsumidos);
			for (Prato p : pratos) {
				qdtItens.add(quantidades.get(p));
			}

			pedido = new Pedido();
			pedido.setItensConsumidos(pratos);
			pedido.setQuantidades(qdtItens);
			pedido.setTaxaServico(10.0);
			pedido.calcularTotal();

			String textAreaItens = "\n";
			textAreaItens += "  Taxa de serviço: R$" + getPedido().getTaxaServico() + "\n\n";
			int i = 0;
			for (Prato p : pratos) {
				textAreaItens += "  Nome do prato: " + p.getNome() + "\n";
				textAreaItens += "  Valor: R$" + p.getPrecoVenda() + "\n";
				textAreaItens += "  Quantidade: " + qdtItens.get(i) + "\n\n";
				i++;
			}

			criarPedido2.setValorTotal(getPedido().getValorTotal());
			criarPedido2.setValorIndividual(getPedido().divideValor(criarPedido2.getTotalPessoas()));
			criarPedido2.setTextAreaItens(textAreaItens);

			criarPedido1.tornarInvisivel();
			criarPedido2.tornarVisivel();
		}
	};

	MouseAdapter montarPizzaPesonalizada = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			PizzaPersonalizadaController.recheiosUsados.clear();
			PizzaPersonalizadaController.carregarElementosPizzaPersonalizada();
			telaInicialView.exibirDialogMontarPizza(telaInicialView);
		}
	};

	public static Pedido getPedido() {
		Pedido p = new Pedido();
		p.setItensConsumidos(pedido.getItensConsumidos());
		p.setQuantidades(pedido.getQuantidades());
		p.setTaxaServico(pedido.getTaxaServico());
		p.calcularTotal();
		return p;
	}

	public static int totalLanches() {
		return DB.lanches.size();
	}

	public static int totalSalgadinhos() {
		return DB.salgadinhos.size();
	}

	public static int totalPizzas() {
		return DB.pizzas.size();
	}

	public static void carregarElementosPedido() {
		atualizarPizzas(new ArrayList<Pizza>());
		criarPedido1.setPainelConteudoPizzasSize(pizzas.size());
		criarPedido1.setPainelConteudoSalgadinhosSize(DB.salgadinhos.size());
		criarPedido1.setPainelConteudoLanchesSize(DB.lanches.size());
		criarPedido1.carregarPainelPizzas(pizzas);
		criarPedido1.carregarPainelSalgadinhos(DB.salgadinhos);
		criarPedido1.carregarPainelLanches(DB.lanches);
		criarPedido1.tornarInvisivel();
		criarPedido1.tornarVisivel();
	}

	public static void carregarElementosPizzas(ArrayList<Pizza> temp) {
		atualizarPizzas(temp);
		criarPedido1.setPainelConteudoPizzasSize(pizzas.size());
		criarPedido1.carregarPainelPizzas(pizzas);
		criarPedido1.tornarInvisivel();
		criarPedido1.tornarVisivel();
	}

	public static void atualizarPizzas(ArrayList<Pizza> temp) {
		pizzas.clear();
		pizzas.addAll(temp);
		pizzas.addAll(DB.pizzas);
	}

}
