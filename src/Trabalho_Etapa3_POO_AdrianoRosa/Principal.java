package Trabalho_Etapa3_POO_AdrianoRosa;

import java.awt.EventQueue;

import Trabalho_Etapa3_POO_AdrianoRosa.controllers.ClienteController;
import Trabalho_Etapa3_POO_AdrianoRosa.controllers.FuncionarioController;
import Trabalho_Etapa3_POO_AdrianoRosa.controllers.ItensPizzaController;
import Trabalho_Etapa3_POO_AdrianoRosa.controllers.LancheController;
import Trabalho_Etapa3_POO_AdrianoRosa.controllers.Pedido2Controller;
import Trabalho_Etapa3_POO_AdrianoRosa.controllers.PedidoController;
import Trabalho_Etapa3_POO_AdrianoRosa.controllers.PizzaController;
import Trabalho_Etapa3_POO_AdrianoRosa.controllers.PizzaPersonalizadaController;
import Trabalho_Etapa3_POO_AdrianoRosa.controllers.RelatorioController;
import Trabalho_Etapa3_POO_AdrianoRosa.controllers.SalgadinhoController;
import Trabalho_Etapa3_POO_AdrianoRosa.controllers.TelaInicialController;
import Trabalho_Etapa3_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CadastroClientePanel;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CadastroFuncionarioPanel;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CadastroItensPizzaPanel;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CadastroLanchePanel;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CadastroPizzaPanel;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CadastroSalgadinhoPanel;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CriarPedido1;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CriarPedido2;
import Trabalho_Etapa3_POO_AdrianoRosa.views.ListaPedidosPanel;
import Trabalho_Etapa3_POO_AdrianoRosa.views.MontarPizzaPersonalizada;
import Trabalho_Etapa3_POO_AdrianoRosa.views.TelaInicial;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					DB.carregarDados();

					CadastroClientePanel cadastroClientePanel = new CadastroClientePanel();
					CadastroFuncionarioPanel cadastroFuncionarioPanel = new CadastroFuncionarioPanel();
					CadastroSalgadinhoPanel cadastroSalgadinhoPanel = new CadastroSalgadinhoPanel();
					CadastroLanchePanel cadastroLanchePanel = new CadastroLanchePanel();
					CadastroPizzaPanel cadastroPizzaPanel = new CadastroPizzaPanel();
					CadastroItensPizzaPanel cadastroItensPizzaPanel = new CadastroItensPizzaPanel();
					CriarPedido1 criarPedido1 = new CriarPedido1();
					CriarPedido2 criarPedido2 = new CriarPedido2();
					ListaPedidosPanel listaPedidosPanel = new ListaPedidosPanel();
					MontarPizzaPersonalizada montarPizzaPersonalizada = new MontarPizzaPersonalizada(null);

					TelaInicial telaInicialView = new TelaInicial(cadastroFuncionarioPanel, cadastroClientePanel,
							criarPedido1, montarPizzaPersonalizada, cadastroSalgadinhoPanel, cadastroLanchePanel,
							cadastroPizzaPanel, cadastroItensPizzaPanel, criarPedido2, listaPedidosPanel);

					new TelaInicialController(telaInicialView, cadastroFuncionarioPanel, cadastroClientePanel,
							criarPedido1, cadastroSalgadinhoPanel, cadastroLanchePanel, cadastroPizzaPanel,
							cadastroItensPizzaPanel, criarPedido2, listaPedidosPanel);

					new PedidoController(telaInicialView, criarPedido1, criarPedido2);
					new PizzaPersonalizadaController(montarPizzaPersonalizada);
					new ClienteController(cadastroClientePanel);
					new FuncionarioController(cadastroFuncionarioPanel);
					new SalgadinhoController(cadastroSalgadinhoPanel);
					new LancheController(cadastroLanchePanel);
					new ItensPizzaController(cadastroItensPizzaPanel);
					new PizzaController(cadastroPizzaPanel);
					new Pedido2Controller(criarPedido1, criarPedido2, listaPedidosPanel);
					new RelatorioController(listaPedidosPanel);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
