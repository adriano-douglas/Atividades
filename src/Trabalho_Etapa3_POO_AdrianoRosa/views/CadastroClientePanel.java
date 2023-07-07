package Trabalho_Etapa3_POO_AdrianoRosa.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CadastroClientePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblTituloCadCliente;
	private JLabel lblNomeCadCliente;
	private JLabel lblEnderecoCadCliente;
	private JLabel lblCpfCadCliente;
	private JLabel lblDNascCadCliente;
	private JLabel lblTelefonesCadCliente;

	private JLabel lblMensErroNomeCliente;
	private JLabel lblMensErroCpfCliente;
	private JLabel lblMensErroEnderecoCliente;
	private JLabel lblMensErroDNascCliente;
	private JLabel lblMensErroTelefonesCliente;

	private JTextField textNomeCadCliente;
	private JTextField textEnderecoCadCliente;
	private JFormattedTextField textCpfCadCliente;
	private JFormattedTextField textDNascCadCliente;
	private JFormattedTextField textTelefone1CadCliente;
	private JFormattedTextField textTelefone2CadCliente;

	private JButton btnSalvarCadCliente;

	public CadastroClientePanel() {
		setVisible(false);
		setDoubleBuffered(false);
		setFocusable(false);
		setBackground(new Color(255, 255, 240));
		setBounds(0, 0, 819, 575);
		setLayout(null);

		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		MaskFormatter mascaraTelefone = null;
		try {
			mascaraTelefone = new MaskFormatter("(##)#####-####");
			mascaraTelefone.setPlaceholderCharacter('_');
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		lblTituloCadCliente = new JLabel("CADASTRO DE CLIENTES");
		lblTituloCadCliente.setForeground(new Color(47, 79, 79));
		lblTituloCadCliente.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTituloCadCliente.setBounds(29, 30, 219, 14);
		add(lblTituloCadCliente);

		lblNomeCadCliente = new JLabel("Nome:");
		lblNomeCadCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeCadCliente.setBounds(29, 117, 219, 14);
		add(lblNomeCadCliente);

		textNomeCadCliente = new JTextField();
		textNomeCadCliente.setBounds(29, 138, 219, 28);
		add(textNomeCadCliente);
		textNomeCadCliente.setColumns(10);

		lblEnderecoCadCliente = new JLabel("Endereço:");
		lblEnderecoCadCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnderecoCadCliente.setBounds(29, 191, 219, 19);
		add(lblEnderecoCadCliente);

		textEnderecoCadCliente = new JTextField();
		textEnderecoCadCliente.setColumns(10);
		textEnderecoCadCliente.setBounds(29, 212, 219, 28);
		add(textEnderecoCadCliente);

		lblCpfCadCliente = new JLabel("CPF:");
		lblCpfCadCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCpfCadCliente.setBounds(272, 117, 219, 19);
		add(lblCpfCadCliente);

		textCpfCadCliente = new JFormattedTextField(mascaraCpf);
		textCpfCadCliente.setColumns(10);
		textCpfCadCliente.setBounds(272, 138, 219, 28);
		add(textCpfCadCliente);

		lblDNascCadCliente = new JLabel("Data de Nascimento:");
		lblDNascCadCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDNascCadCliente.setBounds(272, 191, 219, 19);
		add(lblDNascCadCliente);

		textDNascCadCliente = new JFormattedTextField(mascaraData);
		textDNascCadCliente.setColumns(10);
		textDNascCadCliente.setBounds(272, 212, 219, 28);
		add(textDNascCadCliente);

		lblTelefonesCadCliente = new JLabel("Telefones:");
		lblTelefonesCadCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefonesCadCliente.setBounds(29, 261, 219, 19);
		add(lblTelefonesCadCliente);

		textTelefone1CadCliente = new JFormattedTextField(mascaraTelefone);
		textTelefone1CadCliente.setColumns(10);
		textTelefone1CadCliente.setBounds(29, 282, 219, 28);
		add(textTelefone1CadCliente);

		textTelefone2CadCliente = new JFormattedTextField(mascaraTelefone);
		textTelefone2CadCliente.setColumns(10);
		textTelefone2CadCliente.setBounds(29, 321, 219, 28);
		add(textTelefone2CadCliente);

		btnSalvarCadCliente = new JButton("SALVAR");
		btnSalvarCadCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvarCadCliente.setBorderPainted(false);
		btnSalvarCadCliente.setRolloverEnabled(false);
		btnSalvarCadCliente.setRequestFocusEnabled(false);
		btnSalvarCadCliente.setBackground(new Color(255, 69, 0));
		btnSalvarCadCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvarCadCliente.setForeground(new Color(255, 255, 240));
		btnSalvarCadCliente.setBounds(385, 321, 106, 28);
		add(btnSalvarCadCliente);

		lblMensErroNomeCliente = new JLabel("Mensagem erro nome");
		lblMensErroNomeCliente.setVisible(false);
		lblMensErroNomeCliente.setForeground(new Color(255, 0, 0));
		lblMensErroNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroNomeCliente.setBounds(29, 166, 219, 14);
		add(lblMensErroNomeCliente);

		lblMensErroCpfCliente = new JLabel("Mensagem erro cpf");
		lblMensErroCpfCliente.setVisible(false);
		lblMensErroCpfCliente.setForeground(Color.RED);
		lblMensErroCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroCpfCliente.setBounds(272, 166, 219, 14);
		add(lblMensErroCpfCliente);

		lblMensErroEnderecoCliente = new JLabel("Mensagem erro endereço");
		lblMensErroEnderecoCliente.setVisible(false);
		lblMensErroEnderecoCliente.setForeground(Color.RED);
		lblMensErroEnderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroEnderecoCliente.setBounds(29, 239, 219, 14);
		add(lblMensErroEnderecoCliente);

		lblMensErroDNascCliente = new JLabel("Mensagem erro data de nascimento");
		lblMensErroDNascCliente.setVisible(false);
		lblMensErroDNascCliente.setForeground(Color.RED);
		lblMensErroDNascCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroDNascCliente.setBounds(272, 239, 266, 14);
		add(lblMensErroDNascCliente);

		lblMensErroTelefonesCliente = new JLabel("Mensagem erro telefones");
		lblMensErroTelefonesCliente.setVisible(false);
		lblMensErroTelefonesCliente.setForeground(Color.RED);
		lblMensErroTelefonesCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroTelefonesCliente.setBounds(29, 350, 219, 14);
		add(lblMensErroTelefonesCliente);

	}
	
	public void resetarCampos() {
		lblMensErroNomeCliente.setVisible(false);
		lblCpfCadCliente.setVisible(false);
		lblMensErroEnderecoCliente.setVisible(false);
		lblMensErroTelefonesCliente.setVisible(false);
		lblMensErroDNascCliente.setVisible(false);
		
		textNomeCadCliente.setText("");
		textCpfCadCliente.setText("");
		textEnderecoCadCliente.setText("");
		textDNascCadCliente.setText("");
		textTelefone1CadCliente.setText("");
		textTelefone2CadCliente.setText("");
	}

	public void tornarVisivel() {
		setVisible(true);
	}

	public void tornarInvisivel() {
		setVisible(false);
	}

	public void setEventoBtnSalvarCliente(ActionListener actionListener) {
		btnSalvarCadCliente.addActionListener(actionListener);
	}

	public String getTextNome() {
		return textNomeCadCliente.getText();
	}

	public String getTextCpf() {
		return textCpfCadCliente.getText();
	}

	public String getTextEndereco() {
		return textEnderecoCadCliente.getText();
	}

	public String getTextDataNascimento() {
		return textDNascCadCliente.getText();
	}

	public String getTextTelefone1() {
		return textTelefone1CadCliente.getText();
	}

	public String getTextTelefone2() {
		return textTelefone2CadCliente.getText();
	}

	public void exibirErroNome(String msg, boolean exibir) {
		lblMensErroNomeCliente.setText(msg);
		lblMensErroNomeCliente.setVisible(exibir);
	}

	public void exibirErroCpf(String msg, boolean exibir) {
		lblMensErroCpfCliente.setText(msg);
		lblMensErroCpfCliente.setVisible(exibir);
	}

	public void exibirErroEndereco(String msg, boolean exibir) {
		lblMensErroEnderecoCliente.setText(msg);
		lblMensErroEnderecoCliente.setVisible(exibir);
	}

	public void exibirErroDNascimento(String msg, boolean exibir) {
		lblMensErroDNascCliente.setText(msg);
		lblMensErroDNascCliente.setVisible(exibir);
	}

	public void exibirErroTelefones(String msg, boolean exibir) {
		lblMensErroTelefonesCliente.setText(msg);
		lblMensErroTelefonesCliente.setVisible(exibir);
	}
	
	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}

}
