package Trabalho_Etapa3_POO_AdrianoRosa.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.NumberFormatter;

import Trabalho_Etapa3_POO_AdrianoRosa.controllers.PedidoController;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Cliente;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Funcionario;
import Trabalho_Etapa3_POO_AdrianoRosa.models.TipoPagamento;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;

public class CriarPedido2 extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnFinalizarPedido;

	private JLabel lblTotalPedido;
	private JLabel lblTotalIndividual;
	private JLabel lblVP;

	private JSpinner spinnerNPessoas;

	private JTextArea textAreaItensPedido;
	private JFormattedTextField textValorPago;

	private JComboBox<Cliente> comboCliente;
	private JComboBox<Funcionario> comboAtendente;

	private JRadioButton radioDinheiro;
	private JRadioButton radioCredito;
	private JRadioButton radioDebito;

	private static TipoPagamento tipoPagamento = TipoPagamento.DINHEIRO;

	public CriarPedido2() {

		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setVerifyInputWhenFocusTarget(false);
		setRequestFocusEnabled(false);
		setFocusTraversalKeysEnabled(false);
		setLayout(null);
		setFocusable(false);
		setVisible(false);
		setDoubleBuffered(false);
		setBackground(new Color(255, 255, 240));
		setBounds(0, 0, 819, 575);

		NumberFormat dinherio = NumberFormat.getCurrencyInstance();
		dinherio.setMinimumFractionDigits(2);
		dinherio.setMaximumFractionDigits(2);

		NumberFormatter mascaraDinheiro = new NumberFormatter(dinherio);
		mascaraDinheiro.setValueClass(Double.class);
		mascaraDinheiro.setMinimum(0.0);
		mascaraDinheiro.setMaximum(10000.0);
		mascaraDinheiro.setAllowsInvalid(false);
		mascaraDinheiro.setCommitsOnValidEdit(false);

		// Finalizar Pedido
		btnFinalizarPedido = new JButton("FINALIZAR PEDIDO");
		btnFinalizarPedido.setBorderPainted(false);
		btnFinalizarPedido.setFocusable(false);
		btnFinalizarPedido.setFocusTraversalKeysEnabled(false);
		btnFinalizarPedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFinalizarPedido.setRolloverEnabled(false);
		btnFinalizarPedido.setRequestFocusEnabled(false);
		btnFinalizarPedido.setBackground(new Color(255, 128, 64));
		btnFinalizarPedido.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFinalizarPedido.setForeground(new Color(255, 255, 240));
		btnFinalizarPedido.setBounds(626, 521, 183, 31);
		add(btnFinalizarPedido);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 63, 292, 489);
		add(scrollPane);

		textAreaItensPedido = new JTextArea();
		textAreaItensPedido.setFont(new Font("Calibri", Font.BOLD, 14));
		textAreaItensPedido.setEditable(false);
		scrollPane.setViewportView(textAreaItensPedido);

		JLabel lblNewLabel = new JLabel("ITENS DO PEDIDO");
		lblNewLabel.setBounds(20, 19, 292, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Selecione o cliente:");
		lblNewLabel_1.setBounds(402, 63, 127, 14);
		add(lblNewLabel_1);

		comboCliente = new JComboBox<Cliente>();
		comboCliente.setBounds(402, 88, 183, 31);
		add(comboCliente);

		JLabel lblNewLabel_1_1 = new JLabel("Selecione o atendente:");
		lblNewLabel_1_1.setBounds(402, 136, 183, 14);
		add(lblNewLabel_1_1);

		comboAtendente = new JComboBox<Funcionario>();
		comboAtendente.setBounds(402, 161, 183, 31);
		add(comboAtendente);

		JLabel lblNewLabel_2 = new JLabel("Forma de pagamento:");
		lblNewLabel_2.setBounds(402, 214, 183, 14);
		add(lblNewLabel_2);

		ButtonGroup grupoPagamento = new ButtonGroup();

		radioDinheiro = new JRadioButton("Dinheiro");
		radioDinheiro.setBounds(402, 235, 109, 23);
		radioDinheiro.setSelected(true);
		add(radioDinheiro);
		grupoPagamento.add(radioDinheiro);

		radioCredito = new JRadioButton("Crédito");
		radioCredito.setBounds(402, 261, 109, 23);
		add(radioCredito);
		grupoPagamento.add(radioCredito);

		radioDebito = new JRadioButton("Debito");
		radioDebito.setBounds(402, 287, 109, 23);
		add(radioDebito);
		grupoPagamento.add(radioDebito);

		// Criar o ActionListener para os botões de rádio
		ActionListener radioListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioDinheiro.isSelected()) {
					tipoPagamento = TipoPagamento.DINHEIRO;
					lblVP.setVisible(true);
					textValorPago.setVisible(true);
					textValorPago.setValue(0.0);
				} else if (radioCredito.isSelected()) {
					tipoPagamento = TipoPagamento.CREDITO;
					lblVP.setVisible(false);
					textValorPago.setVisible(false);
					textValorPago.setValue(0.0);
				} else if (radioDebito.isSelected()) {
					tipoPagamento = TipoPagamento.DEBITO;
					lblVP.setVisible(false);
					textValorPago.setVisible(false);
					textValorPago.setValue(0.0);
				}
			}
		};

		radioDinheiro.addActionListener(radioListener);
		radioCredito.addActionListener(radioListener);
		radioDebito.addActionListener(radioListener);

		lblVP = new JLabel("Valor pago:");
		lblVP.setBounds(402, 321, 183, 14);
		add(lblVP);

		textValorPago = new JFormattedTextField(mascaraDinheiro);
		textValorPago.setValue(0.0);
		textValorPago.setBounds(402, 346, 183, 31);
		add(textValorPago);

		JLabel lblNewLabel_4 = new JLabel("Total do pedido:");
		lblNewLabel_4.setBounds(672, 63, 109, 14);
		add(lblNewLabel_4);

		lblTotalPedido = new JLabel("R$50,00");
		lblTotalPedido.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTotalPedido.setBounds(672, 84, 109, 21);
		add(lblTotalPedido);

		JLabel lblNewLabel_5 = new JLabel("Total individual:");
		lblNewLabel_5.setBounds(672, 381, 109, 14);
		add(lblNewLabel_5);

		lblTotalIndividual = new JLabel("R$50,00");
		lblTotalIndividual.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalIndividual.setBounds(672, 401, 109, 31);
		add(lblTotalIndividual);

		JLabel lblNewLabel_6 = new JLabel("Número de pessoas:");
		lblNewLabel_6.setBounds(402, 409, 127, 14);
		add(lblNewLabel_6);

		spinnerNPessoas = new JSpinner();
		spinnerNPessoas.setBounds(532, 401, 53, 31);
		spinnerNPessoas.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		spinnerNPessoas.setEnabled(true);
		add(spinnerNPessoas);

		spinnerNPessoas.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				setValorIndividual(PedidoController.pedido.divideValor(getTotalPessoas()));
			}
		});

	}
	
	public void resetarCampos() {
		radioDinheiro.setSelected(true);
		tipoPagamento = TipoPagamento.DINHEIRO;
		lblVP.setVisible(true);
		textValorPago.setVisible(true);
		textValorPago.setValue(0.0);
		spinnerNPessoas.setValue(1);
	}

	public void tornarVisivel() {
		setVisible(true);
	}

	public void tornarInvisivel() {
		setVisible(false);
	}

	public Cliente getClienteSelecionado() {
		return (Cliente) comboCliente.getSelectedItem();
	}

	public Funcionario getAtendenteSelecionado() {
		return (Funcionario) comboAtendente.getSelectedItem();
	}

	public TipoPagamento getFormaPagamento() {
		return tipoPagamento;
	}

	public String getTextValorPago() {
		return textValorPago.getText();
	}
	
	public Integer getTotalPessoas() {
		return (Integer) spinnerNPessoas.getValue();
	}

	public void setValorTotal(Double total) {
		lblTotalPedido.setText("R$" + total.toString().replace(".", ","));
	}

	public void setValorIndividual(Double total) {
		lblTotalIndividual.setText("R$" + total.toString().replace(".", ","));
	}

	public void setComboClientes(ArrayList<Cliente> clientes) {
		comboCliente.setModel(new DefaultComboBoxModel<>(clientes.toArray(new Cliente[0])));
	}

	public void setComboFuncionarios(ArrayList<Funcionario> funcionarios) {
		comboAtendente.setModel(new DefaultComboBoxModel<>(funcionarios.toArray(new Funcionario[0])));
	}
	
	public void setTextAreaItens(String itens) {
		textAreaItensPedido.setText(itens);
	}

	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}
	
	public void adicionarEventoConfirmarPedido(ActionListener actionListener) {
		btnFinalizarPedido.addActionListener(actionListener);
	}

}
