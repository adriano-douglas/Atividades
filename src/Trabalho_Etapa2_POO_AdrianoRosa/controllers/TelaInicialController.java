package Trabalho_Etapa2_POO_AdrianoRosa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Trabalho_Etapa2_POO_AdrianoRosa.views.CadastroClientePanel;
import Trabalho_Etapa2_POO_AdrianoRosa.views.CadastroFuncionarioPanel;
import Trabalho_Etapa2_POO_AdrianoRosa.views.CadastroItensPizzaPanel;
import Trabalho_Etapa2_POO_AdrianoRosa.views.CadastroLanchePanel;
import Trabalho_Etapa2_POO_AdrianoRosa.views.CadastroPizzaPanel;
import Trabalho_Etapa2_POO_AdrianoRosa.views.CadastroSalgadinhoPanel;
import Trabalho_Etapa2_POO_AdrianoRosa.views.CriarPedido1;
import Trabalho_Etapa2_POO_AdrianoRosa.views.CriarPedido2;
import Trabalho_Etapa2_POO_AdrianoRosa.views.ListaPedidosPanel;
import Trabalho_Etapa2_POO_AdrianoRosa.views.TelaInicial;

public class TelaInicialController {

	private static TelaInicial telaInicialView;
	private static CadastroFuncionarioPanel cadastroFuncionarioView;
	private static CadastroClientePanel cadastroClienteView;
	private static CadastroSalgadinhoPanel cadastroSalgadinhoPanel;
	private static CadastroLanchePanel cadastroLanchePanel;
	private static CadastroPizzaPanel cadastroPizzaPanel;
	private static CadastroItensPizzaPanel cadastroItensPizzaPanel;
	private static CriarPedido1 criarPedido1View;
	private static CriarPedido2 criarPedido2;
	private static ListaPedidosPanel listaPedidosPanel;

	public TelaInicialController(TelaInicial _telaInicialView, CadastroFuncionarioPanel _cadastroFuncionarioPanel,
			CadastroClientePanel _cadastroClientePanel, CriarPedido1 _criarPedido1,
			CadastroSalgadinhoPanel _cadastroSalgadinhoPanel, CadastroLanchePanel _cadastroLanchePanel,
			CadastroPizzaPanel _cadastroPizzaPanel, CadastroItensPizzaPanel _cadastroItensPizzaPanel,
			CriarPedido2 _criarPedido2, ListaPedidosPanel _listaPedidosPanel) {

		telaInicialView = _telaInicialView;
		cadastroFuncionarioView = _cadastroFuncionarioPanel;
		cadastroClienteView = _cadastroClientePanel;
		cadastroSalgadinhoPanel = _cadastroSalgadinhoPanel;
		cadastroLanchePanel = _cadastroLanchePanel;
		cadastroPizzaPanel = _cadastroPizzaPanel;
		cadastroItensPizzaPanel = _cadastroItensPizzaPanel;

		criarPedido1View = _criarPedido1;
		criarPedido2 = _criarPedido2;
		listaPedidosPanel = _listaPedidosPanel;

		criarPedido1View.tornarVisivel();
		telaInicialView.setEventoBotaoNovoFuncionario(novoFuncionario);
		telaInicialView.setEventoBotaoNovoCliente(novoCliente);
		telaInicialView.setEventoBotaoNovoPedido(novoPedido);
		telaInicialView.setEventoBotaoNovoSalgadinho(novoSalgadinho);
		telaInicialView.setEventoBotaoNovoLanche(novoLanche);
		telaInicialView.setEventoBotaoNovaPizza(novaPizza);
		telaInicialView.setEventoBotaoNovosItensPizza(novosItensPizza);
		telaInicialView.setEventoBotaoVisualizarPedidos(visualizarPedidos);
	}

	ActionListener novoFuncionario = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			exibirTela(true, false, false, false, false, false, false, false, false);
		}
	};

	ActionListener novoCliente = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			exibirTela(false, true, false, false, false, false, false, false, false);
		}
	};

	ActionListener novoSalgadinho = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			exibirTela(false, false, true, false, false, false, false, false, false);
		}
	};

	ActionListener novoLanche = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			exibirTela(false, false, false, true, false, false, false, false, false);
		}
	};

	ActionListener novaPizza = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			PizzaController.resetarCampos();
			exibirTela(false, false, false, false, true, false, false, false, false);
		}
	};

	ActionListener novosItensPizza = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			exibirTela(false, false, false, false, false, true, false, false, false);
		}
	};

	ActionListener novoPedido = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			PedidoController.carregarElementosPedido();
			PizzaPersonalizadaController.pizzasPersonalizadas.clear();
			PedidoController.itensConsumidos.clear();
			PedidoController.quantidades.clear();
			exibirTela(false, false, false, false, false, false, true, false, false);
		}
	};

	ActionListener visualizarPedidos = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			exibirTela(false, false, false, false, false, false, false, false, true);
		}
	};

	public static void exibirTela(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f, boolean g,
			boolean h, boolean i) {
		cadastroFuncionarioView.setVisible(a);
		cadastroClienteView.setVisible(b);
		cadastroSalgadinhoPanel.setVisible(c);
		cadastroLanchePanel.setVisible(d);
		cadastroPizzaPanel.setVisible(e);
		cadastroItensPizzaPanel.setVisible(f);
		criarPedido1View.setVisible(g);
		criarPedido2.setVisible(h);
		listaPedidosPanel.setVisible(i);
	}

}
