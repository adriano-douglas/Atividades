package Trabalho_Etapa2_POO_AdrianoRosa.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class CadastroFuncionarioPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblTituloCadFunc;
	private JLabel lblNomeCadFunc;
	private JLabel lblEnderecoCadFunc;
	private JLabel lblCpfCadFunc;
	private JLabel lblSalarioCadFunc;
	private JLabel lblTelefonesCadFunc;
	private JLabel lblCargoCadFunc;

	private JLabel lblMensErroNomeFunc;
	private JLabel lblMensErroCpfFunc;
	private JLabel lblMensErroEnderecoFunc;
	private JLabel lblMensErroSalarioFunc;
	private JLabel lblMensErroTelefonesFunc;
	private JLabel lblMensErroCargoFunc;

	private JTextField textNomeCadFunc;
	private JTextField textEnderecoCadFunc;
	private JFormattedTextField textCpfCadFunc;
	private JFormattedTextField textSalarioCadFunc;
	private JFormattedTextField textTelefone1CadFunc;
	private JFormattedTextField textTelefone2CadFunc;

	private JComboBox<String> comboCargoCadFunc;

	private JButton btnSalvarCadFunc;
	
	private MaskFormatter mascaraTelefone;

	public CadastroFuncionarioPanel() {
		setVisible(false);

		setVerifyInputWhenFocusTarget(false);
		setRequestFocusEnabled(false);
		setFocusTraversalKeysEnabled(false);
		setLayout(null);
		setFocusable(false);
		setDoubleBuffered(false);
		setBackground(new Color(255, 255, 240));
		setBounds(0, 0, 819, 575);

		NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);

        NumberFormatter mascaraDinheiro = new NumberFormatter(format);
        mascaraDinheiro.setValueClass(Double.class);
        mascaraDinheiro.setMinimum(0.0);
        mascaraDinheiro.setMaximum(10000.0);
        mascaraDinheiro.setAllowsInvalid(false);
        mascaraDinheiro.setCommitsOnValidEdit(false);

		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		mascaraTelefone = null;
		try {
			mascaraTelefone = new MaskFormatter("(##)#####-####");
			mascaraTelefone.setPlaceholderCharacter('_');
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		lblTituloCadFunc = new JLabel("CADASTRO DE FUNCIONÁRIOS");
		lblTituloCadFunc.setForeground(new Color(47, 79, 79));
		lblTituloCadFunc.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTituloCadFunc.setBounds(29, 30, 220, 21);
		add(lblTituloCadFunc);

		lblNomeCadFunc = new JLabel("Nome:");
		lblNomeCadFunc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeCadFunc.setBounds(29, 117, 219, 14);
		add(lblNomeCadFunc);

		textNomeCadFunc = new JTextField();
		textNomeCadFunc.setColumns(10);
		textNomeCadFunc.setBounds(29, 138, 219, 28);
		add(textNomeCadFunc);

		lblEnderecoCadFunc = new JLabel("Endereço:");
		lblEnderecoCadFunc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnderecoCadFunc.setBounds(29, 191, 219, 19);
		add(lblEnderecoCadFunc);

		textEnderecoCadFunc = new JTextField();
		textEnderecoCadFunc.setColumns(10);
		textEnderecoCadFunc.setBounds(29, 212, 219, 28);
		add(textEnderecoCadFunc);

		lblCpfCadFunc = new JLabel("CPF:");
		lblCpfCadFunc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCpfCadFunc.setBounds(272, 117, 219, 19);
		add(lblCpfCadFunc);

		textCpfCadFunc = new JFormattedTextField(mascaraCpf);
		textCpfCadFunc.setColumns(10);
		textCpfCadFunc.setBounds(272, 138, 219, 28);
		add(textCpfCadFunc);

		lblSalarioCadFunc = new JLabel("Salário:");
		lblSalarioCadFunc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalarioCadFunc.setBounds(272, 191, 219, 19);
		add(lblSalarioCadFunc);

		textSalarioCadFunc = new JFormattedTextField(mascaraDinheiro);
		textSalarioCadFunc.setColumns(10);
		textSalarioCadFunc.setValue(0.0);
		textSalarioCadFunc.setBounds(272, 212, 219, 28);
		add(textSalarioCadFunc);

		lblTelefonesCadFunc = new JLabel("Telefones:");
		lblTelefonesCadFunc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefonesCadFunc.setBounds(29, 261, 219, 19);
		add(lblTelefonesCadFunc);

		textTelefone1CadFunc = new JFormattedTextField(mascaraTelefone);
		textTelefone1CadFunc.setColumns(10);
		textTelefone1CadFunc.setBounds(29, 282, 219, 28);
		add(textTelefone1CadFunc);

		textTelefone2CadFunc = new JFormattedTextField(mascaraTelefone);
		textTelefone2CadFunc.setColumns(10);
		textTelefone2CadFunc.setBounds(29, 321, 219, 28);
		add(textTelefone2CadFunc);

		lblCargoCadFunc = new JLabel("Cargo:");
		lblCargoCadFunc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCargoCadFunc.setBounds(272, 261, 219, 19);
		add(lblCargoCadFunc);

		comboCargoCadFunc = new JComboBox<>();
		comboCargoCadFunc.setRequestFocusEnabled(false);
		comboCargoCadFunc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboCargoCadFunc.setBorder(null);
		comboCargoCadFunc.setBackground(new Color(255, 255, 240));
		comboCargoCadFunc.setBounds(272, 282, 219, 28);
		add(comboCargoCadFunc);

		btnSalvarCadFunc = new JButton("SALVAR");
		btnSalvarCadFunc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvarCadFunc.setRolloverEnabled(false);
		btnSalvarCadFunc.setRequestFocusEnabled(false);
		btnSalvarCadFunc.setForeground(new Color(255, 255, 240));
		btnSalvarCadFunc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvarCadFunc.setBorderPainted(false);
		btnSalvarCadFunc.setBackground(new Color(255, 69, 0));
		btnSalvarCadFunc.setBounds(385, 382, 106, 28);
		add(btnSalvarCadFunc);

		lblMensErroNomeFunc = new JLabel("Mensagem erro nome");
		lblMensErroNomeFunc.setVisible(false);
		lblMensErroNomeFunc.setForeground(Color.RED);
		lblMensErroNomeFunc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroNomeFunc.setBounds(29, 166, 219, 14);
		add(lblMensErroNomeFunc);

		lblMensErroCpfFunc = new JLabel("Mensagem erro cpf");
		lblMensErroCpfFunc.setVisible(false);
		lblMensErroCpfFunc.setForeground(Color.RED);
		lblMensErroCpfFunc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroCpfFunc.setBounds(272, 166, 219, 14);
		add(lblMensErroCpfFunc);

		lblMensErroEnderecoFunc = new JLabel("Mensagem erro endereço");
		lblMensErroEnderecoFunc.setVisible(false);
		lblMensErroEnderecoFunc.setForeground(Color.RED);
		lblMensErroEnderecoFunc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroEnderecoFunc.setBounds(29, 239, 219, 14);
		add(lblMensErroEnderecoFunc);

		lblMensErroSalarioFunc = new JLabel("Mensagem erro salario");
		lblMensErroSalarioFunc.setVisible(false);
		lblMensErroSalarioFunc.setForeground(Color.RED);
		lblMensErroSalarioFunc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroSalarioFunc.setBounds(272, 239, 219, 14);
		add(lblMensErroSalarioFunc);

		lblMensErroTelefonesFunc = new JLabel("Mensagem erro telefones");
		lblMensErroTelefonesFunc.setVisible(false);
		lblMensErroTelefonesFunc.setForeground(Color.RED);
		lblMensErroTelefonesFunc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroTelefonesFunc.setBounds(29, 350, 219, 14);
		add(lblMensErroTelefonesFunc);

		lblMensErroCargoFunc = new JLabel("Mensagem erro cargo");
		lblMensErroCargoFunc.setVisible(false);
		lblMensErroCargoFunc.setForeground(Color.RED);
		lblMensErroCargoFunc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroCargoFunc.setBounds(272, 310, 219, 14);
		add(lblMensErroCargoFunc);

	}
	
	public void resetarCampos() {
		lblMensErroNomeFunc.setVisible(false);
		lblMensErroCpfFunc.setVisible(false);
		lblMensErroEnderecoFunc.setVisible(false);
		lblMensErroTelefonesFunc.setVisible(false);
		lblMensErroCargoFunc.setVisible(false);
		lblMensErroSalarioFunc.setVisible(false);
		
		textNomeCadFunc.setText("");
		textCpfCadFunc.setText("");
		textEnderecoCadFunc.setText("");
		textTelefone1CadFunc.setValue("");
		textTelefone2CadFunc.setValue("");
		textSalarioCadFunc.setValue(0.0);
	}

	public void tornarVisivel() {
		setVisible(true);
	}

	public void tornarInvisivel() {
		setVisible(false);
	}

	public void setEventoBtnSalvarFuncionario(ActionListener actionListener) {
		btnSalvarCadFunc.addActionListener(actionListener);
	}

	public void setComboCargos(List<String> cargos) {
		comboCargoCadFunc.setModel(new DefaultComboBoxModel<String>(cargos.toArray(new String[0])));
	}

	public String getTextNome() {
		return textNomeCadFunc.getText();
	}

	public String getTextCpf() {
		return textCpfCadFunc.getText();
	}

	public String getTextEndereco() {
		return textEnderecoCadFunc.getText();
	}

	public String getTextTelefone1() {
		return textTelefone1CadFunc.getText();
	}

	public String getTextTelefone2() {
		return textTelefone2CadFunc.getText();
	}

	public String getTextSalario() {
		return textSalarioCadFunc.getText();
	}

	public String getTextCargo() {
		return (String) comboCargoCadFunc.getSelectedItem();
	}

	public void exibirErroNome(String msg, boolean exibir) {
		lblMensErroNomeFunc.setText(msg);
		lblMensErroNomeFunc.setVisible(exibir);
	}

	public void exibirErroCpf(String msg, boolean exibir) {
		lblMensErroCpfFunc.setVisible(exibir);
		lblMensErroCpfFunc.setText(msg);
	}

	public void exibirErroEndereco(String msg, boolean exibir) {
		lblMensErroEnderecoFunc.setText(msg);
		lblMensErroEnderecoFunc.setVisible(exibir);
	}

	public void exibirErroTelefones(String msg, boolean exibir) {
		lblMensErroTelefonesFunc.setText(msg);
		lblMensErroTelefonesFunc.setVisible(exibir);
	}

	public void exibirErroSalario(String msg, boolean exibir) {
		lblMensErroSalarioFunc.setText(msg);
		lblMensErroSalarioFunc.setVisible(exibir);
	}

	public void exibirErroCargo(String msg, boolean exibir) {
		lblMensErroCargoFunc.setText(msg);
		lblMensErroCargoFunc.setVisible(exibir);
	}

	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}

}
