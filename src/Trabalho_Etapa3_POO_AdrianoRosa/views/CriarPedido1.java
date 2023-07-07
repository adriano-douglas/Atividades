package Trabalho_Etapa3_POO_AdrianoRosa.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Trabalho_Etapa3_POO_AdrianoRosa.controllers.PedidoController;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Lanche;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pizza;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Prato;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Salgadinho;

public class CriarPedido1 extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblTituloCardapio;
	private JLabel lblLanches;
	private JLabel lblPizzas;
	private JLabel lblSalgadinhos;
	private JLabel lblBtnPersonalizar;

	private JScrollPane scrollPanePizzas;
	private JScrollPane scrollPaneLanches;
	private JScrollPane scrollPaneSalgadinhos;

	private static JPanel painelConteudoLanches;
	private static JPanel painelConteudoPizzas;
	private static JPanel painelConteudoSalgadinhos;

	private JButton btnFinalizarPedido;

	public CriarPedido1() {
		setVisible(false);

		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setVerifyInputWhenFocusTarget(false);
		setRequestFocusEnabled(false);
		setFocusTraversalKeysEnabled(false);
		setLayout(null);
		setFocusable(false);
		setDoubleBuffered(false);
		setBackground(new Color(255, 255, 240));
		setBounds(0, 0, 819, 575);

		lblTituloCardapio = new JLabel("CARDÁPIO");
		lblTituloCardapio.setForeground(new Color(255, 128, 64));
		lblTituloCardapio.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTituloCardapio.setBounds(10, 11, 104, 25);
		add(lblTituloCardapio);

		lblPizzas = new JLabel("Pizzas");
		lblPizzas.setForeground(new Color(105, 105, 105));
		lblPizzas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPizzas.setBounds(10, 57, 83, 19);
		add(lblPizzas);

		lblLanches = new JLabel("Lanches");
		lblLanches.setForeground(new Color(105, 105, 105));
		lblLanches.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLanches.setBounds(280, 57, 83, 19);
		add(lblLanches);

		lblSalgadinhos = new JLabel("Salgadinhos");
		lblSalgadinhos.setForeground(new Color(105, 105, 105));
		lblSalgadinhos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalgadinhos.setBounds(551, 57, 104, 19);
		add(lblSalgadinhos);

		lblBtnPersonalizar = new JLabel("");
		lblBtnPersonalizar.setToolTipText("Montar Pizza Personalizada");
		lblBtnPersonalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBtnPersonalizar.setIcon(new ImageIcon("D:\\Adriano Douglas\\Downloads\\add.png"));
		lblBtnPersonalizar.setBounds(243, 56, 24, 24);
		add(lblBtnPersonalizar);

		// Pizzas
		scrollPanePizzas = new JScrollPane();
		scrollPanePizzas.setBounds(10, 85, 258, 479);
		scrollPanePizzas.getVerticalScrollBar().setPreferredSize(new Dimension(10, HEIGHT));
		add(scrollPanePizzas);

		painelConteudoPizzas = new JPanel();
		painelConteudoPizzas.setBackground(new Color(245, 245, 245));
		painelConteudoPizzas.setLayout(null);

		scrollPanePizzas.getVerticalScrollBar().setUnitIncrement(10);
		scrollPanePizzas.setViewportView(painelConteudoPizzas);

		// Lanches
		scrollPaneLanches = new JScrollPane();
		scrollPaneLanches.setBounds(280, 85, 258, 479);
		scrollPaneLanches.getVerticalScrollBar().setPreferredSize(new Dimension(10, HEIGHT));
		add(scrollPaneLanches);

		painelConteudoLanches = new JPanel();
		painelConteudoLanches.setBackground(new Color(245, 245, 245));
		painelConteudoLanches.setLayout(null);

		scrollPaneLanches.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneLanches.setViewportView(painelConteudoLanches);

		// Salgadinhos
		scrollPaneSalgadinhos = new JScrollPane();
		scrollPaneSalgadinhos.setBounds(551, 85, 258, 479);
		scrollPaneSalgadinhos.getVerticalScrollBar().setPreferredSize(new Dimension(10, HEIGHT));
		add(scrollPaneSalgadinhos);

		painelConteudoSalgadinhos = new JPanel();
		painelConteudoSalgadinhos.setBackground(new Color(245, 245, 245));
		painelConteudoSalgadinhos.setLayout(null);

		scrollPaneSalgadinhos.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneSalgadinhos.setViewportView(painelConteudoSalgadinhos);

		// Continuar Pedido
		btnFinalizarPedido = new JButton("CONTINUAR PEDIDO");
		btnFinalizarPedido.setBorderPainted(false);
		btnFinalizarPedido.setFocusable(false);
		btnFinalizarPedido.setFocusTraversalKeysEnabled(false);
		btnFinalizarPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFinalizarPedido.setRolloverEnabled(false);
		btnFinalizarPedido.setRequestFocusEnabled(false);
		btnFinalizarPedido.setBackground(new Color(255, 128, 64));
		btnFinalizarPedido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFinalizarPedido.setForeground(new Color(255, 255, 240));
		btnFinalizarPedido.setBounds(626, 9, 183, 31);
		add(btnFinalizarPedido);

	}

	private static JPanel criarPainelItem(Prato prato) {

		JPanel panelItem = new JPanel();
		panelItem.setBackground(new Color(255, 255, 255));
		panelItem.setLayout(null);

		JPanel borda = new JPanel();
		borda.setBounds(0, 50, 245, 3);
		borda.setBackground(new Color(255, 220, 130));
		panelItem.add(borda);

		JCheckBox checkBox = new JCheckBox();
		JLabel lblNome = new JLabel(prato.getNome());
		JSpinner spnQuantidade = new JSpinner();
		JLabel lblValor = new JLabel("R$" + prato.getPrecoVenda().toString());

		lblValor.setForeground(new Color(0, 0, 70));
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 13));

		checkBox.setBorder(null);
		checkBox.setContentAreaFilled(false);
		checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblNome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNome.setForeground(new Color(0, 0, 50));

		spnQuantidade.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		spnQuantidade.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		spnQuantidade.setBounds(147, 31, 44, 25);
		spnQuantidade.setEnabled(checkBox.isSelected());

		checkBox.addItemListener(e -> {
			boolean isSelected = checkBox.isSelected();
			spnQuantidade.setEnabled(isSelected);
			if (!isSelected) {
				spnQuantidade.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
				PedidoController.itensConsumidos.remove(prato);
				PedidoController.quantidades.remove(prato);
				borda.setBackground(new Color(255, 220, 130));
			} else {
				spnQuantidade.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
				PedidoController.itensConsumidos.add(prato);
				PedidoController.quantidades.put(prato, 1);
				borda.setBackground(new Color(144, 238, 144));
			}
		});

		lblNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkBox.setSelected(!checkBox.isSelected());
			}
		});

		spnQuantidade.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				PedidoController.quantidades.put(prato, (Integer) spnQuantidade.getValue());
			}
		});

		checkBox.setBounds(7, 5, 20, 20);
		lblNome.setBounds(25, 0, 160, 30);
		spnQuantidade.setBounds(195, 8, 40, 25);
		lblValor.setBounds(7, 27, 95, 19);

		panelItem.add(checkBox);
		panelItem.add(lblNome);
		panelItem.add(spnQuantidade);
		panelItem.add(lblValor);

		return panelItem;
	}

	public void carregarPainelLanches(ArrayList<Lanche> lanches) {
		painelConteudoLanches.removeAll();
		int i = 0;
		for (Lanche l : lanches) {
			JPanel panelItem = criarPainelItem(l);
			panelItem.setBounds(5, 5 + (i++ * 58), 245, 53);
			painelConteudoLanches.add(panelItem);
		}
	}

	public void carregarPainelPizzas(ArrayList<Pizza> pizzas) {
		painelConteudoPizzas.removeAll();
		int i = 0;
		for (Pizza p : pizzas) {
			JPanel panelItem = criarPainelItem(p);
			panelItem.setBounds(5, 5 + (i++ * 58), 245, 53);
			painelConteudoPizzas.add(panelItem);
		}
	}

	public void carregarPainelSalgadinhos(ArrayList<Salgadinho> salgadinhos) {
		painelConteudoSalgadinhos.removeAll();
		int i = 0;
		for (Salgadinho s : salgadinhos) {
			JPanel panelItem = criarPainelItem(s);
			panelItem.setBounds(5, 5 + (i++ * 58), 245, 53);
			painelConteudoSalgadinhos.add(panelItem);
		}
	}

	public void tornarVisivel() {
		setVisible(true);
	}

	public void tornarInvisivel() {
		setVisible(false);
	}

	public void setPainelConteudoPizzasSize(Integer totalPizzas) {
		painelConteudoPizzas.setPreferredSize(new Dimension(0, totalPizzas * 59));
	}

	public void setPainelConteudoLanchesSize(Integer totalLanches) {
		painelConteudoLanches.setPreferredSize(new Dimension(0, totalLanches * 59));
	}

	public void setPainelConteudoSalgadinhosSize(Integer totalSalgadinhos) {
		painelConteudoSalgadinhos.setPreferredSize(new Dimension(0, totalSalgadinhos * 59));
	}

	public void setEventoBotaoContinuarPedido(ActionListener actionListener) {
		btnFinalizarPedido.addActionListener(actionListener);
	}

	public void setEventoBotaoPersonalizarPizza(MouseAdapter mouseListener) {
		lblBtnPersonalizar.addMouseListener(mouseListener);
	}
	
	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}

}
