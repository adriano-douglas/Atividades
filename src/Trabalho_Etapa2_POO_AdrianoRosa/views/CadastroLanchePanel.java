package Trabalho_Etapa2_POO_AdrianoRosa.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class CadastroLanchePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblTituloCadLanche;
	private JLabel lblNomeCadlanche;
	private JLabel lblDValidadeCadlanche;
	private JLabel lblPrecoCadlanche;
	private JLabel lblPesoCadLanche;
	private JLabel lblRecheioCadLanche;
	private JLabel lblPaoCadLanche;
	private JLabel lblMolhoCadLanche;

	private JLabel lblMensErroNomelanche;
	private JLabel lblMensErroDValidlanche;
	private JLabel lblMensErroPrecolanche;
	private JLabel lblMensErroPesoLanche;
	private JLabel lblMensErroRecheioLanche;
	private JLabel lblMensErroPaoLanche;
	private JLabel lblMensErroMolhoLanche;

	private JTextField textNomeCadlanche;
	private JTextField textRecheioCadLanche;
	private JTextField textPaoCadLanche;
	private JTextField textMolhoCadLanche;
	private JFormattedTextField textDValidCadlanche;
	private JFormattedTextField textPrecoCadlanche;
	private JFormattedTextField textPesoCadLanche;

	private JButton btnSalvarCadlanche;

	public CadastroLanchePanel() {
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
		mascaraDinheiro.setMaximum(50.0);
		mascaraDinheiro.setAllowsInvalid(false);
		mascaraDinheiro.setCommitsOnValidEdit(false);

		DecimalFormat pesoKg = new DecimalFormat("###0.000 kg");
		pesoKg.setMinimumFractionDigits(3);
		pesoKg.setMaximumFractionDigits(3);

		NumberFormatter mascaraPeso = new NumberFormatter(pesoKg);
		mascaraPeso.setValueClass(Double.class);
		mascaraPeso.setMinimum(0.0);
		mascaraPeso.setMaximum(5.0);
		mascaraPeso.setAllowsInvalid(false);
		mascaraPeso.setCommitsOnValidEdit(false);

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		lblTituloCadLanche = new JLabel("CADASTRO DE LANCHES");
		lblTituloCadLanche.setForeground(new Color(47, 79, 79));
		lblTituloCadLanche.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTituloCadLanche.setBounds(29, 30, 233, 21);
		add(lblTituloCadLanche);

		lblNomeCadlanche = new JLabel("Nome:");
		lblNomeCadlanche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeCadlanche.setBounds(29, 117, 219, 19);
		add(lblNomeCadlanche);

		textNomeCadlanche = new JTextField();
		textNomeCadlanche.setBounds(29, 138, 219, 28);
		add(textNomeCadlanche);
		textNomeCadlanche.setColumns(10);

		lblDValidadeCadlanche = new JLabel("Data de Validade:");
		lblDValidadeCadlanche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDValidadeCadlanche.setBounds(272, 117, 219, 19);
		add(lblDValidadeCadlanche);

		textDValidCadlanche = new JFormattedTextField(mascaraData);
		textDValidCadlanche.setColumns(10);
		textDValidCadlanche.setBounds(272, 138, 219, 28);
		add(textDValidCadlanche);

		lblPrecoCadlanche = new JLabel("Preço de Venda:");
		lblPrecoCadlanche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecoCadlanche.setBounds(29, 194, 219, 19);
		add(lblPrecoCadlanche);

		textPrecoCadlanche = new JFormattedTextField(mascaraDinheiro);
		textPrecoCadlanche.setValue(0.0);
		textPrecoCadlanche.setBounds(29, 216, 219, 28);
		add(textPrecoCadlanche);

		lblPesoCadLanche = new JLabel("Peso:");
		lblPesoCadLanche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPesoCadLanche.setBounds(272, 194, 219, 19);
		add(lblPesoCadLanche);

		textPesoCadLanche = new JFormattedTextField(mascaraPeso);
		textPesoCadLanche.setValue(0.0);
		textPesoCadLanche.setBounds(272, 216, 219, 28);
		add(textPesoCadLanche);

		lblRecheioCadLanche = new JLabel("Recheio:");
		lblRecheioCadLanche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRecheioCadLanche.setBounds(29, 277, 219, 19);
		add(lblRecheioCadLanche);

		textRecheioCadLanche = new JTextField();
		textRecheioCadLanche.setColumns(10);
		textRecheioCadLanche.setBounds(29, 298, 219, 28);
		add(textRecheioCadLanche);

		lblPaoCadLanche = new JLabel("Pão:");
		lblPaoCadLanche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPaoCadLanche.setBounds(272, 277, 219, 19);
		add(lblPaoCadLanche);

		textPaoCadLanche = new JTextField();
		textPaoCadLanche.setColumns(10);
		textPaoCadLanche.setBounds(272, 298, 219, 28);
		add(textPaoCadLanche);

		lblMolhoCadLanche = new JLabel("Molho:");
		lblMolhoCadLanche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMolhoCadLanche.setBounds(29, 350, 219, 19);
		add(lblMolhoCadLanche);

		textMolhoCadLanche = new JTextField();
		textMolhoCadLanche.setColumns(10);
		textMolhoCadLanche.setBounds(29, 371, 219, 28);
		add(textMolhoCadLanche);

		btnSalvarCadlanche = new JButton("SALVAR");
		btnSalvarCadlanche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvarCadlanche.setBorderPainted(false);
		btnSalvarCadlanche.setRolloverEnabled(false);
		btnSalvarCadlanche.setRequestFocusEnabled(false);
		btnSalvarCadlanche.setBackground(new Color(255, 69, 0));
		btnSalvarCadlanche.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvarCadlanche.setForeground(new Color(255, 255, 240));
		btnSalvarCadlanche.setBounds(385, 371, 106, 28);
		add(btnSalvarCadlanche);

		lblMensErroNomelanche = new JLabel("Mensagem erro nome");
		lblMensErroNomelanche.setVisible(false);
		lblMensErroNomelanche.setForeground(new Color(255, 0, 0));
		lblMensErroNomelanche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroNomelanche.setBounds(29, 166, 219, 14);
		add(lblMensErroNomelanche);

		lblMensErroDValidlanche = new JLabel("Mensagem data validade lanche");
		lblMensErroDValidlanche.setVisible(false);
		lblMensErroDValidlanche.setForeground(Color.RED);
		lblMensErroDValidlanche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroDValidlanche.setBounds(272, 166, 219, 14);
		add(lblMensErroDValidlanche);

		lblMensErroPrecolanche = new JLabel("Mensagem preco venda lanche");
		lblMensErroPrecolanche.setVisible(false);
		lblMensErroPrecolanche.setForeground(Color.RED);
		lblMensErroPrecolanche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroPrecolanche.setBounds(29, 244, 219, 14);
		add(lblMensErroPrecolanche);

		lblMensErroPesoLanche = new JLabel("Mensagem peso lanche");
		lblMensErroPesoLanche.setVisible(false);
		lblMensErroPesoLanche.setForeground(Color.RED);
		lblMensErroPesoLanche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroPesoLanche.setBounds(272, 244, 219, 14);
		add(lblMensErroPesoLanche);

		lblMensErroRecheioLanche = new JLabel("Mensagem recheio lanche");
		lblMensErroRecheioLanche.setVisible(false);
		lblMensErroRecheioLanche.setForeground(Color.RED);
		lblMensErroRecheioLanche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroRecheioLanche.setBounds(29, 325, 219, 14);
		add(lblMensErroRecheioLanche);

		lblMensErroPaoLanche = new JLabel("Mensagem pão lanche");
		lblMensErroPaoLanche.setVisible(false);
		lblMensErroPaoLanche.setForeground(Color.RED);
		lblMensErroPaoLanche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroPaoLanche.setBounds(272, 325, 219, 14);
		add(lblMensErroPaoLanche);

		lblMensErroMolhoLanche = new JLabel("Mensagem molho lanche");
		lblMensErroMolhoLanche.setVisible(false);
		lblMensErroMolhoLanche.setForeground(Color.RED);
		lblMensErroMolhoLanche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroMolhoLanche.setBounds(29, 398, 219, 14);
		add(lblMensErroMolhoLanche);

	}

	public void resetarCampos() {
		lblMensErroNomelanche.setVisible(false);
		lblMensErroDValidlanche.setVisible(false);
		lblMensErroMolhoLanche.setVisible(false);
		lblMensErroPaoLanche.setVisible(false);
		lblMensErroPesoLanche.setVisible(false);
		lblMensErroPrecolanche.setVisible(false);
		lblMensErroRecheioLanche.setVisible(false);
		
		textDValidCadlanche.setValue("");
		textMolhoCadLanche.setText("");
		textNomeCadlanche.setText("");
		textPaoCadLanche.setText("");
		textPesoCadLanche.setValue(0.0);
		textPrecoCadlanche.setValue(0.0);
		textRecheioCadLanche.setText("");
	}

	public void tornarVisivel() {
		setVisible(true);
	}

	public void tornarInvisivel() {
		setVisible(false);
	}

	public void setEventoBtnSalvarLanche(ActionListener actionListener) {
		btnSalvarCadlanche.addActionListener(actionListener);
	}

	public String getTextNome() {
		return textNomeCadlanche.getText();
	}

	public String getTextDataValidade() {
		return textDValidCadlanche.getText();
	}

	public String getTextPrecoVenda() {
		return textPrecoCadlanche.getText();
	}

	public String getTextPeso() {
		return textPesoCadLanche.getText();
	}

	public String getTextPao() {
		return textPaoCadLanche.getText();
	}

	public String getTextRecheio() {
		return textRecheioCadLanche.getText();
	}

	public String getTextMolho() {
		return textMolhoCadLanche.getText();
	}

	public void exibirErroNome(String msg, boolean exibir) {
		lblMensErroNomelanche.setText(msg);
		lblMensErroNomelanche.setVisible(exibir);
	}

	public void exibirErroDValidade(String msg, boolean exibir) {
		lblMensErroDValidlanche.setText(msg);
		lblMensErroDValidlanche.setVisible(exibir);
	}

	public void exibirErroPreco(String msg, boolean exibir) {
		lblMensErroPrecolanche.setText(msg);
		lblMensErroPrecolanche.setVisible(exibir);
	}

	public void exibirErroPeso(String msg, boolean exibir) {
		lblMensErroPesoLanche.setText(msg);
		lblMensErroPesoLanche.setVisible(exibir);
	}

	public void exibirErroPao(String msg, boolean exibir) {
		lblMensErroPaoLanche.setText(msg);
		lblMensErroPaoLanche.setVisible(exibir);
	}

	public void exibirErroRecheio(String msg, boolean exibir) {
		lblMensErroRecheioLanche.setText(msg);
		lblMensErroRecheioLanche.setVisible(exibir);
	}

	public void exibirErroMolho(String msg, boolean exibir) {
		lblMensErroMolhoLanche.setText(msg);
		lblMensErroMolhoLanche.setVisible(exibir);
	}

	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}

}
