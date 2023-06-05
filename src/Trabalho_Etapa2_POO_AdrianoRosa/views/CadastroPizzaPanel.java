package Trabalho_Etapa2_POO_AdrianoRosa.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import Trabalho_Etapa2_POO_AdrianoRosa.controllers.PizzaController;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Molho;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Recheio;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

public class CadastroPizzaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnSalvarCadPizza;

	private JLabel lblRecheios;
	private JLabel lblMolhos;
	private JLabel lblRecheioDaBorda;
	private JLabel lblBorda;
	private JLabel lblTituloCadPizzas;
	private JLabel lblNome;
	private JLabel lblMensErroNome;
	private JLabel lblMensErroRecheios;
	private JLabel lblDValidade;
	private JLabel lblMensErroDValidade;
	private JLabel lblPreco;
	private JLabel lblMensErroPreco;
	private JLabel lblPeso;
	private JLabel lblMensErroPeso;

	private static JPanel painelConteudoRecheios;

	private JScrollPane scrollPaneRecheios;

	private JTextField textNome;
	private JFormattedTextField textDValid;
	private JFormattedTextField textPreco;
	private JFormattedTextField textPeso;

	private JComboBox<Molho> comboMolho;
	private JComboBox<Recheio> comboBorda;

	private ButtonGroup grupoRecheioBorda;

	private JRadioButton rdbtnTradicional;
	private JRadioButton rdbtnRecheada;

	private static String textTipoBorda = "Tradicional";

	public CadastroPizzaPanel() {
		setVisible(false);
		setDoubleBuffered(false);
		setFocusable(false);
		setBackground(new Color(255, 255, 240));
		setBounds(0, 0, 819, 575);
		setLayout(null);

		NumberFormat dinherio = NumberFormat.getCurrencyInstance();
		dinherio.setMinimumFractionDigits(2);
		dinherio.setMaximumFractionDigits(2);

		NumberFormatter mascaraDinheiro = new NumberFormatter(dinherio);
		mascaraDinheiro.setValueClass(Double.class);
		mascaraDinheiro.setMinimum(0.0);
		mascaraDinheiro.setMaximum(300.0);
		mascaraDinheiro.setAllowsInvalid(false);
		mascaraDinheiro.setCommitsOnValidEdit(false);

		DecimalFormat pesoKg = new DecimalFormat("###0.000 kg");
		pesoKg.setMinimumFractionDigits(3);
		pesoKg.setMaximumFractionDigits(3);

		NumberFormatter mascaraPeso = new NumberFormatter(pesoKg);
		mascaraPeso.setValueClass(Double.class);
		mascaraPeso.setMinimum(0.0);
		mascaraPeso.setMaximum(10.0);
		mascaraPeso.setAllowsInvalid(false);
		mascaraPeso.setCommitsOnValidEdit(false);

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		lblTituloCadPizzas = new JLabel("CADASTRO DE PIZZAS");
		lblTituloCadPizzas.setForeground(new Color(47, 79, 79));
		lblTituloCadPizzas.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTituloCadPizzas.setBounds(29, 30, 233, 21);
		add(lblTituloCadPizzas);

		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(270, 108, 219, 19);
		add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(270, 129, 196, 28);
		add(textNome);
		textNome.setColumns(10);
		add(textNome);

		lblDValidade = new JLabel("Data de Validade:");
		lblDValidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDValidade.setBounds(270, 203, 180, 19);
		add(lblDValidade);

		textDValid = new JFormattedTextField(mascaraData);
		textDValid.setColumns(10);
		textDValid.setBounds(270, 224, 196, 28);
		add(textDValid);

		lblPreco = new JLabel("Preço de Venda:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(270, 291, 180, 19);
		add(lblPreco);

		textPreco = new JFormattedTextField(mascaraDinheiro);
		textPreco.setValue(0.0);
		textPreco.setBounds(270, 313, 196, 28);
		add(textPreco);

		lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPeso.setBounds(270, 380, 219, 19);
		add(lblPeso);

		textPeso = new JFormattedTextField(mascaraPeso);
		textPeso.setValue(0.0);
		textPeso.setBounds(270, 404, 196, 28);
		add(textPeso);

		lblRecheios = new JLabel("Recheios:");
		lblRecheios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRecheios.setBounds(29, 108, 196, 19);
		add(lblRecheios);

		scrollPaneRecheios = new JScrollPane();
		scrollPaneRecheios.setBounds(29, 135, 196, 379);
		scrollPaneRecheios.getVerticalScrollBar().setPreferredSize(new Dimension(10, HEIGHT));
		add(scrollPaneRecheios);

		painelConteudoRecheios = new JPanel();
		painelConteudoRecheios.setBackground(new Color(245, 245, 245));
		painelConteudoRecheios.setLayout(null);

		scrollPaneRecheios.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneRecheios.setViewportView(painelConteudoRecheios);

		lblMolhos = new JLabel("Molho:");
		lblMolhos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMolhos.setBounds(511, 108, 180, 19);
		add(lblMolhos);

		comboMolho = new JComboBox<>();
		comboMolho.setFocusable(false);
		comboMolho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboMolho.setBorder(null);
		comboMolho.setBackground(new Color(255, 255, 255));
		comboMolho.setMaximumRowCount(4);
		comboMolho.setVerifyInputWhenFocusTarget(false);
		comboMolho.setBounds(511, 133, 180, 51);
		comboMolho.setRenderer(new RenderizacaoCustomizada());
		add(comboMolho);

		lblBorda = new JLabel("Borda:");
		lblBorda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBorda.setBounds(511, 203, 180, 19);
		add(lblBorda);

		grupoRecheioBorda = new ButtonGroup();

		rdbtnTradicional = new JRadioButton("Tradicional");
		rdbtnTradicional.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnTradicional.setFocusable(false);
		rdbtnTradicional.setContentAreaFilled(false);
		rdbtnTradicional.setBounds(511, 224, 97, 23);
		rdbtnTradicional.setSelected(true);
		add(rdbtnTradicional);
		grupoRecheioBorda.add(rdbtnTradicional);

		rdbtnRecheada = new JRadioButton("Recheada");
		rdbtnRecheada.setFocusable(false);
		rdbtnRecheada.setContentAreaFilled(false);
		rdbtnRecheada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnRecheada.setBounds(511, 250, 97, 23);
		add(rdbtnRecheada);
		grupoRecheioBorda.add(rdbtnRecheada);

		// Criar o ActionListener para os botões de rádio
		ActionListener radioListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnTradicional.isSelected()) {
					lblRecheioDaBorda.setVisible(false);
					comboBorda.setVisible(false);
					textTipoBorda = "Tradicional";
				} else if (rdbtnRecheada.isSelected()) {
					lblRecheioDaBorda.setVisible(true);
					comboBorda.setVisible(true);
					textTipoBorda = "Recheada";
				}
			}
		};

		rdbtnRecheada.addActionListener(radioListener);
		rdbtnTradicional.addActionListener(radioListener);

		lblRecheioDaBorda = new JLabel("Recheio da borda:");
		lblRecheioDaBorda.setBounds(511, 291, 180, 19);
		lblRecheioDaBorda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRecheioDaBorda.setVisible(false);
		add(lblRecheioDaBorda);

		comboBorda = new JComboBox<Recheio>();
		comboBorda.setBounds(511, 318, 180, 51);
		comboBorda.setFocusable(false);
		comboBorda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBorda.setBorder(null);
		comboBorda.setBackground(new Color(255, 255, 255));
		comboBorda.setMaximumRowCount(4);
		comboBorda.setVerifyInputWhenFocusTarget(false);
		comboBorda.setVisible(false);
		comboBorda.setRenderer(new RenderizacaoCustomizada());
		add(comboBorda);

		btnSalvarCadPizza = new JButton("SALVAR");
		btnSalvarCadPizza.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvarCadPizza.setBorderPainted(false);
		btnSalvarCadPizza.setRolloverEnabled(false);
		btnSalvarCadPizza.setRequestFocusEnabled(false);
		btnSalvarCadPizza.setBackground(new Color(255, 69, 0));
		btnSalvarCadPizza.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvarCadPizza.setForeground(new Color(255, 255, 240));
		btnSalvarCadPizza.setBounds(594, 489, 97, 25);
		add(btnSalvarCadPizza);

		lblMensErroNome = new JLabel("Mensagem erro nome");
		lblMensErroNome.setVisible(false);
		lblMensErroNome.setForeground(new Color(255, 0, 0));
		lblMensErroNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroNome.setBounds(270, 157, 196, 14);
		add(lblMensErroNome);

		lblMensErroRecheios = new JLabel("Mensagem erro recheios");
		lblMensErroRecheios.setBounds(29, 519, 196, 14);
		add(lblMensErroRecheios);
		lblMensErroRecheios.setVisible(false);
		lblMensErroRecheios.setForeground(new Color(255, 0, 0));
		lblMensErroRecheios.setFont(new Font("Tahoma", Font.PLAIN, 11));

		lblMensErroDValidade = new JLabel("Mensagem data validade");
		lblMensErroDValidade.setVisible(false);
		lblMensErroDValidade.setForeground(Color.RED);
		lblMensErroDValidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroDValidade.setBounds(270, 252, 196, 14);
		add(lblMensErroDValidade);

		lblMensErroPreco = new JLabel("Mensagem preco venda");
		lblMensErroPreco.setVisible(false);
		lblMensErroPreco.setForeground(Color.RED);
		lblMensErroPreco.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroPreco.setBounds(270, 341, 196, 14);
		add(lblMensErroPreco);

		lblMensErroPeso = new JLabel("Mensagem peso");
		lblMensErroPeso.setVisible(false);
		lblMensErroPeso.setForeground(Color.RED);
		lblMensErroPeso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroPeso.setBounds(270, 432, 196, 14);
		add(lblMensErroPeso);

	}

	private static JPanel criarPainelItem(Recheio recheio) {

		JPanel panelItem = new JPanel();
		panelItem.setBackground(new Color(255, 255, 255));
		panelItem.setLayout(null);

		JPanel borda = new JPanel();
		borda.setBackground(new Color(255, 220, 130));
		borda.setBounds(0, 50, 172, 3);
		panelItem.add(borda);

		JCheckBox checkBox = new JCheckBox();
		JLabel lblNome = new JLabel(recheio.getNome());
		JLabel lblValor = new JLabel("R$" + recheio.getValor().toString());

		lblValor.setForeground(new Color(0, 0, 70));
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 13));

		checkBox.setBorder(null);
		checkBox.setContentAreaFilled(false);
		checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblNome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNome.setForeground(new Color(0, 0, 50));

		checkBox.addItemListener(e -> {
			boolean isSelected = checkBox.isSelected();
			if (!isSelected) {
				PizzaController.recheiosUsados.remove(recheio);
				borda.setBackground(new Color(255, 220, 130));
			} else {
				PizzaController.recheiosUsados.add(recheio);
				borda.setBackground(new Color(255, 90, 90));
			}
		});

		lblNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkBox.setSelected(!checkBox.isSelected());
			}
		});

		checkBox.setBounds(7, 5, 20, 20);
		lblNome.setBounds(25, 0, 170, 30);
		lblValor.setBounds(7, 27, 95, 19);

		panelItem.add(checkBox);
		panelItem.add(lblNome);
		panelItem.add(lblValor);

		return panelItem;

	}
	
	public void resetarCampos() {
		lblMensErroNome.setVisible(false);
		lblMensErroDValidade.setVisible(false);
		lblMensErroPeso.setVisible(false);
		lblMensErroPreco.setVisible(false);
		lblMensErroRecheios.setVisible(false);
		
		rdbtnTradicional.setSelected(true);
		lblRecheioDaBorda.setVisible(false);
		comboBorda.setVisible(false);
		textTipoBorda = "Tradicional";

		textDValid.setValue("");
		textNome.setText("");
		textPeso.setValue(0.0);
		textPreco.setValue(0.0);
	}
	
	public void setPainelConteudoRecheiosSize(Integer totalRecheios) {
		painelConteudoRecheios.setPreferredSize(new Dimension(0, totalRecheios * 59));
	}

	public void carregarPainelRecheios(ArrayList<Recheio> recheios) {
		painelConteudoRecheios.removeAll();
		int i = 0;
		for (Recheio r : recheios) {
			JPanel panelItem = criarPainelItem(r);
			panelItem.setBounds(5, 5 + (i++ * 58), 172, 53);
			painelConteudoRecheios.add(panelItem);
		}
	}

	public void tornarVisivel() {
		setVisible(true);
	}

	public void tornarInvisivel() {
		setVisible(false);
	}

	public void setEventoBotaoSalvarPizza(ActionListener actionListener) {
		btnSalvarCadPizza.addActionListener(actionListener);
	}

	public void setComboMolhoModel(ArrayList<Molho> molhos) {
		comboMolho.setModel(new DefaultComboBoxModel<Molho>(molhos.toArray(new Molho[0])));
	}

	public void setComboRecheiosBordaModel(ArrayList<Recheio> recheios) {
		comboBorda.setModel(new DefaultComboBoxModel<Recheio>(recheios.toArray(new Recheio[0])));
	}

	public Molho getMolhoSelecionado() {
		return (Molho) comboMolho.getSelectedItem();
	}

	public Recheio getRecheioBordaSelecionado() {
		return (Recheio) comboBorda.getSelectedItem();
	}

	public String getTipoBorda() {
		return textTipoBorda;
	}

	public String getTextNome() {
		return textNome.getText();
	}

	public String getDValidade() {
		return textDValid.getText();
	}

	public String getTextPreco() {
		return textPreco.getText();
	}

	public String getTextPeso() {
		return textPeso.getText();
	}

	public void exibirErroNome(String msg, boolean exibir) {
		lblMensErroNome.setText(msg);
		lblMensErroNome.setVisible(exibir);
	}

	public void exibirErroDValidade(String msg, boolean exibir) {
		lblMensErroDValidade.setText(msg);
		lblMensErroDValidade.setVisible(exibir);
	}

	public void exibirErroPreco(String msg, boolean exibir) {
		lblMensErroPreco.setText(msg);
		lblMensErroPreco.setVisible(exibir);
	}

	public void exibirErroRecheios(String msg, boolean exibir) {
		lblMensErroRecheios.setText(msg);
		lblMensErroRecheios.setVisible(exibir);
	}

	public void exibirErroPeso(String msg, boolean exibir) {
		lblMensErroPeso.setText(msg);
		lblMensErroPeso.setVisible(exibir);
	}

	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}

}
