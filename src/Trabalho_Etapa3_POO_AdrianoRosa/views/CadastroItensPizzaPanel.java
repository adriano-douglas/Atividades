package Trabalho_Etapa3_POO_AdrianoRosa.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class CadastroItensPizzaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblTituloCadItensPizza;
	private JLabel lblNomeMolho;
	private JLabel lblPrecoMolho;
	private JLabel lblNomeRecheioP;
	private JLabel lblPrecoRecheioP;
	private JLabel lblNomeRecheioB;
	private JLabel lblPrecoRecheioB;

	private JLabel lblMensErroNomeMolho;
	private JLabel lblMensErroPrecoMolho;
	private JLabel lblMensErroNomeRecheioP;
	private JLabel lblMensErroPrecoRecheioP;
	private JLabel lblMensErroNomeRecheioB;
	private JLabel lblMensErroPrecoRecheioB;

	private JTextField textNomeMolho;
	private JTextField textNomeRecheioP;
	private JTextField textNomeRecheioB;
	private JFormattedTextField textPrecoMolho;
	private JFormattedTextField textPrecoRecheioP;
	private JFormattedTextField textPrecoRecheioB;

	private JButton btnSalvarMolho;
	private JButton btnSalvarRecheioP;
	private JButton btnSalvarRecheioB;

	public CadastroItensPizzaPanel() {
		setVisible(false);
		setDoubleBuffered(false);
		setFocusable(false);
		setBackground(new Color(255, 255, 240));
		setBounds(0, 0, 819, 575);
		setLayout(null);

		NumberFormat format = NumberFormat.getCurrencyInstance();
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Double.class);
		formatter.setMinimum(0.0);
		formatter.setMaximum(10000.0);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(false);

		lblTituloCadItensPizza = new JLabel("CADASTRO DE ITENS DA PIZZA");
		lblTituloCadItensPizza.setForeground(new Color(47, 79, 79));
		lblTituloCadItensPizza.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTituloCadItensPizza.setBounds(29, 35, 283, 21);
		add(lblTituloCadItensPizza);

		JLabel lblTituloMolho = new JLabel("MOLHO");
		lblTituloMolho.setForeground(new Color(220, 20, 60));
		lblTituloMolho.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTituloMolho.setBounds(29, 127, 235, 21);
		add(lblTituloMolho);

		lblNomeMolho = new JLabel("Nome:");
		lblNomeMolho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeMolho.setBounds(29, 193, 219, 19);
		add(lblNomeMolho);

		textNomeMolho = new JTextField();
		textNomeMolho.setBounds(29, 214, 219, 28);
		add(textNomeMolho);
		textNomeMolho.setColumns(10);

		lblPrecoMolho = new JLabel("Preço:");
		lblPrecoMolho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecoMolho.setBounds(29, 267, 219, 19);
		add(lblPrecoMolho);

		textPrecoMolho = new JFormattedTextField(formatter);
		textPrecoMolho.setValue(0.0);
		textPrecoMolho.setBounds(29, 289, 219, 28);
		add(textPrecoMolho);

		btnSalvarMolho = new JButton("SALVAR");
		btnSalvarMolho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvarMolho.setBorderPainted(false);
		btnSalvarMolho.setRolloverEnabled(false);
		btnSalvarMolho.setRequestFocusEnabled(false);
		btnSalvarMolho.setBackground(new Color(255, 69, 0));
		btnSalvarMolho.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvarMolho.setForeground(new Color(255, 255, 240));
		btnSalvarMolho.setBounds(142, 373, 106, 28);
		add(btnSalvarMolho);

		JLabel lblTituloRecheioPizza = new JLabel("RECHEIO PIZZA");
		lblTituloRecheioPizza.setForeground(new Color(220, 20, 60));
		lblTituloRecheioPizza.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTituloRecheioPizza.setBounds(297, 127, 235, 21);
		add(lblTituloRecheioPizza);

		lblNomeRecheioP = new JLabel("Nome:");
		lblNomeRecheioP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeRecheioP.setBounds(298, 193, 219, 19);
		add(lblNomeRecheioP);

		textNomeRecheioP = new JTextField();
		textNomeRecheioP.setColumns(10);
		textNomeRecheioP.setBounds(298, 214, 219, 28);
		add(textNomeRecheioP);

		lblPrecoRecheioP = new JLabel("Preço:");
		lblPrecoRecheioP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecoRecheioP.setBounds(298, 267, 219, 19);
		add(lblPrecoRecheioP);

		textPrecoRecheioP = new JFormattedTextField(formatter);
		textPrecoRecheioP.setBounds(298, 289, 219, 28);
		textPrecoRecheioP.setValue(0.0);
		add(textPrecoRecheioP);

		btnSalvarRecheioP = new JButton("SALVAR");
		btnSalvarRecheioP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvarRecheioP.setRolloverEnabled(false);
		btnSalvarRecheioP.setRequestFocusEnabled(false);
		btnSalvarRecheioP.setForeground(new Color(255, 255, 240));
		btnSalvarRecheioP.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvarRecheioP.setBorderPainted(false);
		btnSalvarRecheioP.setBackground(new Color(255, 69, 0));
		btnSalvarRecheioP.setBounds(411, 373, 106, 28);
		add(btnSalvarRecheioP);

		JLabel lblTituloRecheioBorda = new JLabel("RECHEIO BORDA");
		lblTituloRecheioBorda.setForeground(new Color(220, 20, 60));
		lblTituloRecheioBorda.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTituloRecheioBorda.setBounds(568, 127, 235, 21);
		add(lblTituloRecheioBorda);

		lblNomeRecheioB = new JLabel("Nome:");
		lblNomeRecheioB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeRecheioB.setBounds(568, 193, 219, 19);
		add(lblNomeRecheioB);

		textNomeRecheioB = new JTextField();
		textNomeRecheioB.setColumns(10);
		textNomeRecheioB.setBounds(568, 214, 219, 28);
		add(textNomeRecheioB);

		lblPrecoRecheioB = new JLabel("Preço:");
		lblPrecoRecheioB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecoRecheioB.setBounds(568, 267, 219, 19);
		add(lblPrecoRecheioB);

		textPrecoRecheioB = new JFormattedTextField(formatter);
		textPrecoRecheioB.setBounds(568, 289, 219, 28);
		textPrecoRecheioB.setValue(0.0);
		add(textPrecoRecheioB);

		btnSalvarRecheioB = new JButton("SALVAR");
		btnSalvarRecheioB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvarRecheioB.setRolloverEnabled(false);
		btnSalvarRecheioB.setRequestFocusEnabled(false);
		btnSalvarRecheioB.setForeground(new Color(255, 255, 240));
		btnSalvarRecheioB.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvarRecheioB.setBorderPainted(false);
		btnSalvarRecheioB.setBackground(new Color(255, 69, 0));
		btnSalvarRecheioB.setBounds(681, 373, 106, 28);
		add(btnSalvarRecheioB);

		lblMensErroNomeMolho = new JLabel("Mensagem erro nome molho");
		lblMensErroNomeMolho.setVisible(false);
		lblMensErroNomeMolho.setForeground(new Color(255, 0, 0));
		lblMensErroNomeMolho.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroNomeMolho.setBounds(29, 242, 219, 14);
		add(lblMensErroNomeMolho);

		lblMensErroPrecoMolho = new JLabel("Mensagem preco molho");
		lblMensErroPrecoMolho.setVisible(false);
		lblMensErroPrecoMolho.setForeground(Color.RED);
		lblMensErroPrecoMolho.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroPrecoMolho.setBounds(29, 317, 219, 14);
		add(lblMensErroPrecoMolho);

		lblMensErroNomeRecheioP = new JLabel("Mensagem erro nome recheio p");
		lblMensErroNomeRecheioP.setVisible(false);
		lblMensErroNomeRecheioP.setForeground(new Color(255, 0, 0));
		lblMensErroNomeRecheioP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroNomeRecheioP.setBounds(298, 242, 219, 14);
		add(lblMensErroNomeRecheioP);

		lblMensErroPrecoRecheioP = new JLabel("Mensagem preco recheio p");
		lblMensErroPrecoRecheioP.setVisible(false);
		lblMensErroPrecoRecheioP.setForeground(Color.RED);
		lblMensErroPrecoRecheioP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroPrecoRecheioP.setBounds(298, 317, 219, 14);
		add(lblMensErroPrecoRecheioP);

		lblMensErroNomeRecheioB = new JLabel("Mensagem erro nome recheio b");
		lblMensErroNomeRecheioB.setVisible(false);
		lblMensErroNomeRecheioB.setForeground(new Color(255, 0, 0));
		lblMensErroNomeRecheioB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroNomeRecheioB.setBounds(568, 242, 219, 14);
		add(lblMensErroNomeRecheioB);

		lblMensErroPrecoRecheioB = new JLabel("Mensagem preco recheio b");
		lblMensErroPrecoRecheioB.setVisible(false);
		lblMensErroPrecoRecheioB.setForeground(Color.RED);
		lblMensErroPrecoRecheioB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroPrecoRecheioB.setBounds(568, 317, 219, 14);
		add(lblMensErroPrecoRecheioB);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(274, 96, 22, 365);
		add(separator);

		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setBounds(542, 96, 22, 365);
		add(separator2);

	}
	
	public void resetarCampos() {
		lblMensErroNomeMolho.setVisible(false);
		lblMensErroPrecoMolho.setVisible(false);
		lblMensErroNomeRecheioP.setVisible(false);
		lblMensErroPrecoRecheioP.setVisible(false);
		lblMensErroNomeRecheioB.setVisible(false);
		lblMensErroPrecoRecheioB.setVisible(false);
		
		textNomeMolho.setText("");
		textPrecoMolho.setValue(0.0);
		textNomeRecheioP.setText("");
		textPrecoRecheioP.setValue(0.0);
		textNomeRecheioB.setText("");
		textPrecoRecheioB.setValue(0.0);
	}

	public void tornarVisivel() {
		setVisible(true);
	}

	public void tornarInvisivel() {
		setVisible(false);
	}

	public void setEventoBtnSalvarMolho(ActionListener actionListener) {
		btnSalvarMolho.addActionListener(actionListener);
	}

	public void setEventoBtnSalvarRecheioP(ActionListener actionListener) {
		btnSalvarRecheioP.addActionListener(actionListener);
	}

	public void setEventoBtnSalvarRecheioB(ActionListener actionListener) {
		btnSalvarRecheioB.addActionListener(actionListener);
	}

	public String getTextNomeMolho() {
		return textNomeMolho.getText();
	}

	public String getTextPrecoMolho() {
		return textPrecoMolho.getText();
	}

	public String getTextNomeRecheioP() {
		return textNomeRecheioP.getText();
	}

	public String getTextPrecoRecheioP() {
		return textPrecoRecheioP.getText();
	}

	public String getTextNomeRecheioB() {
		return textNomeRecheioB.getText();
	}

	public String getTextPrecoRecheioB() {
		return textPrecoRecheioB.getText();
	}

	public void exibirErroNomeMolho(String msg, boolean exibir) {
		lblMensErroNomeMolho.setText(msg);
		lblMensErroNomeMolho.setVisible(exibir);
	}

	public void exibirErroPrecoMolho(String msg, boolean exibir) {
		lblMensErroPrecoMolho.setText(msg);
		lblMensErroPrecoMolho.setVisible(exibir);
	}

	public void exibirErroNomeRecheioP(String msg, boolean exibir) {
		lblMensErroNomeRecheioP.setText(msg);
		lblMensErroNomeRecheioP.setVisible(exibir);
	}

	public void exibirErroPrecoRecheioP(String msg, boolean exibir) {
		lblMensErroPrecoRecheioP.setText(msg);
		lblMensErroPrecoRecheioP.setVisible(exibir);
	}

	public void exibirErroNomeRecheioB(String msg, boolean exibir) {
		lblMensErroNomeRecheioB.setText(msg);
		lblMensErroNomeRecheioB.setVisible(exibir);
	}

	public void exibirErroPrecoRecheioB(String msg, boolean exibir) {
		lblMensErroPrecoRecheioB.setText(msg);
		lblMensErroPrecoRecheioB.setVisible(exibir);
	}

	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}
}
