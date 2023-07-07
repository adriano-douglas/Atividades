package Trabalho_Etapa3_POO_AdrianoRosa.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenuItem mnPedidosNovo;
	private JMenuItem mnCadFunc;
	private JMenuItem mnCadCliente;
	private JMenuItem mnCadPratosSalgadinhos;
	private JMenuItem mnCadPratosLanches;
	private JMenuItem mnCadPizzasNova;
	private JMenuItem mnCadPizzasItens;
	private JMenuItem mnPedidosVisualizar;

	private CadastroFuncionarioPanel cadFuncionarioPanel;
	private CadastroClientePanel cadClientePanel;
	private CadastroSalgadinhoPanel cadSalgadinhoPanel;
	private CadastroLanchePanel cadastroLanchePanel;
	private CadastroPizzaPanel cadastroPizzaPanel;
	private CadastroItensPizzaPanel cadastroItensPizzaPanel;

	private CriarPedido1 criarPedido1;
	private CriarPedido2 criarPedido2;
	private ListaPedidosPanel listaPedidosPanel;

	private MontarPizzaPersonalizada dialogMontarPizza;

	public TelaInicial(CadastroFuncionarioPanel _cadastroFuncionarioPanel, CadastroClientePanel _cadastroClientePanel,
			CriarPedido1 _criarPedido1, MontarPizzaPersonalizada _montarPizzaPersonalizada,
			CadastroSalgadinhoPanel _cadastroSalgadinhoPanel, CadastroLanchePanel _cadastroLanchePanel,
			CadastroPizzaPanel _cadastroPizzaPanel, CadastroItensPizzaPanel _cadastroItensPizzaPanel,
			CriarPedido2 _criarPedido2, ListaPedidosPanel _listaPedidosPanel) {

		cadFuncionarioPanel = _cadastroFuncionarioPanel;
		cadClientePanel = _cadastroClientePanel;
		cadSalgadinhoPanel = _cadastroSalgadinhoPanel;
		cadastroLanchePanel = _cadastroLanchePanel;
		cadastroPizzaPanel = _cadastroPizzaPanel;
		cadastroItensPizzaPanel = _cadastroItensPizzaPanel;

		criarPedido1 = _criarPedido1;
		criarPedido2 = _criarPedido2;
		listaPedidosPanel = _listaPedidosPanel;
		dialogMontarPizza = _montarPizzaPersonalizada;

		setBounds(0, 0, 1100, 650);
		Utilitario.centralizarEmRelacaoTela(this);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		menuBar.setBackground(new Color(144, 238, 144));
		setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros    |");
		mnCadastros.setIcon(new ImageIcon("src\\Trabalho_Etapa3_POO_AdrianoRosa\\imagens\\cadastro.png"));
		mnCadastros.setForeground(new Color(255, 255, 240));
		mnCadastros.setBackground(new Color(144, 238, 144));
		menuBar.add(mnCadastros);

		mnCadFunc = new JMenuItem("Funcionários");
		mnCadFunc.setIcon(new ImageIcon("src\\Trabalho_Etapa3_POO_AdrianoRosa\\imagens\\funcionario.png"));
		mnCadFunc.setForeground(new Color(0, 0, 0));
		mnCadFunc.setBackground(new Color(255, 255, 240));
		mnCadastros.add(mnCadFunc);

		mnCadCliente = new JMenuItem("Clientes");
		mnCadCliente.setIcon(new ImageIcon("src\\Trabalho_Etapa3_POO_AdrianoRosa\\imagens\\cliente.png"));
		mnCadCliente.setForeground(new Color(0, 0, 0));
		mnCadCliente.setBackground(new Color(255, 255, 240));
		mnCadastros.add(mnCadCliente);

		JMenu mnCadPratos = new JMenu("Pratos");
		mnCadastros.add(mnCadPratos);

		mnCadPratosSalgadinhos = new JMenuItem("Salgadinhos");
		mnCadPratos.add(mnCadPratosSalgadinhos);

		mnCadPratosLanches = new JMenuItem("Lanches");
		mnCadPratos.add(mnCadPratosLanches);

		JMenu mnCadPratosPizzas = new JMenu("Pizzas");
		mnCadPratos.add(mnCadPratosPizzas);

		mnCadPizzasNova = new JMenuItem("Nova Pizza");
		mnCadPratosPizzas.add(mnCadPizzasNova);

		mnCadPizzasItens = new JMenuItem("Itens Pizza");
		mnCadPratosPizzas.add(mnCadPizzasItens);

		JMenu mnPedidos = new JMenu("Pedidos    |");
		mnPedidos.setIcon(new ImageIcon("src\\Trabalho_Etapa3_POO_AdrianoRosa\\imagens\\pedido.png"));
		mnPedidos.setBackground(new Color(144, 238, 144));
		mnPedidos.setForeground(new Color(255, 255, 240));
		menuBar.add(mnPedidos);

		mnPedidosNovo = new JMenuItem("Novo");
		mnPedidosNovo.setIcon(new ImageIcon("src\\Trabalho_Etapa3_POO_AdrianoRosa\\imagens\\adicionar.png"));
		mnPedidosNovo.setBackground(new Color(255, 255, 240));
		mnPedidos.add(mnPedidosNovo);

		mnPedidosVisualizar = new JMenuItem("Visualizar");
		mnPedidosVisualizar.setIcon(new ImageIcon("src\\Trabalho_Etapa3_POO_AdrianoRosa\\imagens\\pesquisar-arquivo.png"));
		mnPedidosVisualizar.setBackground(new Color(255, 255, 240));
		mnPedidos.add(mnPedidosVisualizar);

		JMenu mnSair = new JMenu("Sair");
		mnSair.setBackground(new Color(144, 238, 144));
		mnSair.setIcon(new ImageIcon("src\\Trabalho_Etapa3_POO_AdrianoRosa\\imagens\\sair.png"));
		mnSair.setForeground(new Color(255, 255, 240));
		menuBar.add(mnSair);

		mnSair.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();

			}
		});

		////////////////////////////////////

		getContentPane().add(cadFuncionarioPanel);
		getContentPane().add(cadClientePanel);
		getContentPane().add(criarPedido1);
		getContentPane().add(cadSalgadinhoPanel);
		getContentPane().add(cadastroLanchePanel);
		getContentPane().add(cadastroPizzaPanel);
		getContentPane().add(cadastroItensPizzaPanel);
		getContentPane().add(criarPedido2);
		getContentPane().add(listaPedidosPanel);

		////////////////////////////////////

		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(new Color(244, 164, 96));
		panelInfo.setBorder(null);
		panelInfo.setBounds(819, 0, 265, 575);
		getContentPane().add(panelInfo);
		panelInfo.setLayout(null);

		JLabel lblTitulo1Info = new JLabel("LANCHONETE");
		lblTitulo1Info.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo1Info.setForeground(new Color(255, 255, 240));
		lblTitulo1Info.setBounds(76, 80, 122, 25);
		panelInfo.add(lblTitulo1Info);

		JLabel lblTitulo2Info = new JLabel("QUASE TRÊS LANCHES");
		lblTitulo2Info.setForeground(new Color(255, 255, 240));
		lblTitulo2Info.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo2Info.setBounds(28, 147, 202, 25);
		panelInfo.add(lblTitulo2Info);

		JLabel lblImagemInfo = new JLabel("");
		lblImagemInfo.setIcon(new ImageIcon("src\\Trabalho_Etapa3_POO_AdrianoRosa\\imagens\\lanchonete.png"));
		lblImagemInfo.setBounds(85, 289, 100, 100);
		panelInfo.add(lblImagemInfo);

	}

	public void exibirDialogMontarPizza(JFrame frame) {
		Utilitario.centralizarEmRelacaoFrame(frame, dialogMontarPizza);
		dialogMontarPizza.setVisible(true);
	}

	public void setEventoBotaoNovoFuncionario(ActionListener actionListener) {
		mnCadFunc.addActionListener(actionListener);
	}

	public void setEventoBotaoNovoCliente(ActionListener actionListener) {
		mnCadCliente.addActionListener(actionListener);
	}

	public void setEventoBotaoNovoPedido(ActionListener actionListener) {
		mnPedidosNovo.addActionListener(actionListener);
	}

	public void setEventoBotaoNovoSalgadinho(ActionListener actionListener) {
		mnCadPratosSalgadinhos.addActionListener(actionListener);
	}

	public void setEventoBotaoNovoLanche(ActionListener actionListener) {
		mnCadPratosLanches.addActionListener(actionListener);
	}

	public void setEventoBotaoNovaPizza(ActionListener actionListener) {
		mnCadPizzasNova.addActionListener(actionListener);
	}

	public void setEventoBotaoNovosItensPizza(ActionListener actionListener) {
		mnCadPizzasItens.addActionListener(actionListener);
	}

	public void setEventoBotaoVisualizarPedidos(ActionListener actionListener) {
		mnPedidosVisualizar.addActionListener(actionListener);
	}

}
