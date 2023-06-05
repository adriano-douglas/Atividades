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

public class CadastroSalgadinhoPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblTituloCadSalgadinho;
	private JLabel lblNomeCadSalgadinho;
	private JLabel lblDValidadeCadSalgadinho;
	private JLabel lblPrecoCadSalgadinho;
	private JLabel lblPesoCadSalgadinho;
	private JLabel lblRecheioCadSalgadinho;
	private JLabel lblMassaCadSalgadinho;
	private JLabel lblTipoCadSalgadinho;

	private JLabel lblMensErroNomeSalgadinho;
	private JLabel lblMensErroDValidSalgadinho;
	private JLabel lblMensErroPrecoSalgadinho;
	private JLabel lblMensErroPesoSalgadinho;
	private JLabel lblMensErroRecheioSalgadinho;
	private JLabel lblMensErroMassaSalgadinho;
	private JLabel lblMensErroTipoSalgadinho;

	private JTextField textNomeCadSalgadinho;
	private JTextField textRecheioCadSalgadinho;
	private JTextField textMassaCadSalgadinho;
	private JTextField textTipoCadSalgadinho;
	private JFormattedTextField textDValidCadSalgadinho;
	private JFormattedTextField textPrecoCadSalgadinho;
	private JFormattedTextField textPesoCadSalgadinho;

	private JButton btnSalvarCadSalgadinho;

	public CadastroSalgadinhoPanel() {
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

		lblTituloCadSalgadinho = new JLabel("CADASTRO DE SALGADINHOS");
		lblTituloCadSalgadinho.setForeground(new Color(47, 79, 79));
		lblTituloCadSalgadinho.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTituloCadSalgadinho.setBounds(29, 30, 233, 21);
		add(lblTituloCadSalgadinho);

		lblNomeCadSalgadinho = new JLabel("Nome:");
		lblNomeCadSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeCadSalgadinho.setBounds(29, 117, 219, 19);
		add(lblNomeCadSalgadinho);

		textNomeCadSalgadinho = new JTextField();
		textNomeCadSalgadinho.setBounds(29, 138, 219, 28);
		add(textNomeCadSalgadinho);
		textNomeCadSalgadinho.setColumns(10);

		lblDValidadeCadSalgadinho = new JLabel("Data de Validade:");
		lblDValidadeCadSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDValidadeCadSalgadinho.setBounds(272, 117, 219, 19);
		add(lblDValidadeCadSalgadinho);

		textDValidCadSalgadinho = new JFormattedTextField(mascaraData);
		textDValidCadSalgadinho.setColumns(10);
		textDValidCadSalgadinho.setBounds(272, 138, 219, 28);
		add(textDValidCadSalgadinho);

		lblPrecoCadSalgadinho = new JLabel("Preço de Venda:");
		lblPrecoCadSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecoCadSalgadinho.setBounds(29, 194, 219, 19);
		add(lblPrecoCadSalgadinho);

		textPrecoCadSalgadinho = new JFormattedTextField(mascaraDinheiro);
		textPrecoCadSalgadinho.setValue(0.0);
		textPrecoCadSalgadinho.setBounds(29, 216, 219, 28);
		add(textPrecoCadSalgadinho);

		lblPesoCadSalgadinho = new JLabel("Peso:");
		lblPesoCadSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPesoCadSalgadinho.setBounds(272, 194, 219, 19);
		add(lblPesoCadSalgadinho);

		textPesoCadSalgadinho = new JFormattedTextField(mascaraPeso);
		textPesoCadSalgadinho.setValue(0.0);
		textPesoCadSalgadinho.setBounds(272, 216, 219, 28);
		add(textPesoCadSalgadinho);

		lblRecheioCadSalgadinho = new JLabel("Recheio:");
		lblRecheioCadSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRecheioCadSalgadinho.setBounds(29, 277, 219, 19);
		add(lblRecheioCadSalgadinho);

		textRecheioCadSalgadinho = new JTextField();
		textRecheioCadSalgadinho.setColumns(10);
		textRecheioCadSalgadinho.setBounds(29, 298, 219, 28);
		add(textRecheioCadSalgadinho);

		lblMassaCadSalgadinho = new JLabel("Massa:");
		lblMassaCadSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMassaCadSalgadinho.setBounds(272, 277, 219, 19);
		add(lblMassaCadSalgadinho);

		textMassaCadSalgadinho = new JTextField();
		textMassaCadSalgadinho.setColumns(10);
		textMassaCadSalgadinho.setBounds(272, 298, 219, 28);
		add(textMassaCadSalgadinho);

		lblTipoCadSalgadinho = new JLabel("Tipo:");
		lblTipoCadSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoCadSalgadinho.setBounds(29, 350, 219, 19);
		add(lblTipoCadSalgadinho);

		textTipoCadSalgadinho = new JTextField();
		textTipoCadSalgadinho.setColumns(10);
		textTipoCadSalgadinho.setBounds(29, 371, 219, 28);
		add(textTipoCadSalgadinho);

		btnSalvarCadSalgadinho = new JButton("SALVAR");
		btnSalvarCadSalgadinho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvarCadSalgadinho.setBorderPainted(false);
		btnSalvarCadSalgadinho.setRolloverEnabled(false);
		btnSalvarCadSalgadinho.setRequestFocusEnabled(false);
		btnSalvarCadSalgadinho.setBackground(new Color(255, 69, 0));
		btnSalvarCadSalgadinho.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvarCadSalgadinho.setForeground(new Color(255, 255, 240));
		btnSalvarCadSalgadinho.setBounds(385, 371, 106, 28);
		add(btnSalvarCadSalgadinho);

		lblMensErroNomeSalgadinho = new JLabel("Mensagem erro nome");
		lblMensErroNomeSalgadinho.setVisible(false);
		lblMensErroNomeSalgadinho.setForeground(new Color(255, 0, 0));
		lblMensErroNomeSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroNomeSalgadinho.setBounds(29, 166, 219, 14);
		add(lblMensErroNomeSalgadinho);

		lblMensErroDValidSalgadinho = new JLabel("Mensagem data validade salgadinho");
		lblMensErroDValidSalgadinho.setVisible(false);
		lblMensErroDValidSalgadinho.setForeground(Color.RED);
		lblMensErroDValidSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroDValidSalgadinho.setBounds(272, 166, 219, 14);
		add(lblMensErroDValidSalgadinho);

		lblMensErroPrecoSalgadinho = new JLabel("Mensagem preco venda salgadinho");
		lblMensErroPrecoSalgadinho.setVisible(false);
		lblMensErroPrecoSalgadinho.setForeground(Color.RED);
		lblMensErroPrecoSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroPrecoSalgadinho.setBounds(29, 244, 219, 14);
		add(lblMensErroPrecoSalgadinho);

		lblMensErroPesoSalgadinho = new JLabel("Mensagem peso salgadinho");
		lblMensErroPesoSalgadinho.setVisible(false);
		lblMensErroPesoSalgadinho.setForeground(Color.RED);
		lblMensErroPesoSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroPesoSalgadinho.setBounds(272, 244, 219, 14);
		add(lblMensErroPesoSalgadinho);

		lblMensErroRecheioSalgadinho = new JLabel("Mensagem recheio salgadinho");
		lblMensErroRecheioSalgadinho.setVisible(false);
		lblMensErroRecheioSalgadinho.setForeground(Color.RED);
		lblMensErroRecheioSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroRecheioSalgadinho.setBounds(29, 325, 219, 14);
		add(lblMensErroRecheioSalgadinho);

		lblMensErroMassaSalgadinho = new JLabel("Mensagem massa salgadinho");
		lblMensErroMassaSalgadinho.setVisible(false);
		lblMensErroMassaSalgadinho.setForeground(Color.RED);
		lblMensErroMassaSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroMassaSalgadinho.setBounds(272, 325, 219, 14);
		add(lblMensErroMassaSalgadinho);

		lblMensErroTipoSalgadinho = new JLabel("Mensagem tipo salgadinho");
		lblMensErroTipoSalgadinho.setVisible(false);
		lblMensErroTipoSalgadinho.setForeground(Color.RED);
		lblMensErroTipoSalgadinho.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMensErroTipoSalgadinho.setBounds(29, 398, 219, 14);
		add(lblMensErroTipoSalgadinho);

	}

	public void resetarCampos() {
		lblMensErroNomeSalgadinho.setVisible(false);
		lblMensErroDValidSalgadinho.setVisible(false);
		lblMensErroMassaSalgadinho.setVisible(false);
		lblMensErroTipoSalgadinho.setVisible(false);
		lblMensErroPesoSalgadinho.setVisible(false);
		lblMensErroPrecoSalgadinho.setVisible(false);
		lblMensErroRecheioSalgadinho.setVisible(false);

		textDValidCadSalgadinho.setValue("");
		textMassaCadSalgadinho.setText("");
		textNomeCadSalgadinho.setText("");
		textTipoCadSalgadinho.setText("");
		textPesoCadSalgadinho.setValue(0.0);
		textPrecoCadSalgadinho.setValue(0.0);
		textRecheioCadSalgadinho.setText("");
	}

	public void tornarVisivel() {
		setVisible(true);
	}

	public void tornarInvisivel() {
		setVisible(false);
	}

	public void setEventoBtnSalvarSalgadinho(ActionListener actionListener) {
		btnSalvarCadSalgadinho.addActionListener(actionListener);
	}

	public String getTextNome() {
		return textNomeCadSalgadinho.getText();
	}

	public String getTextDataValidade() {
		return textDValidCadSalgadinho.getText();
	}

	public String getTextPrecoVenda() {
		return textPrecoCadSalgadinho.getText();
	}

	public String getTextPeso() {
		return textPesoCadSalgadinho.getText();
	}

	public String getTextMassa() {
		return textMassaCadSalgadinho.getText();
	}

	public String getTextRecheio() {
		return textRecheioCadSalgadinho.getText();
	}

	public String getTextTipo() {
		return textTipoCadSalgadinho.getText();
	}

	public void exibirErroNome(String msg, boolean exibir) {
		lblMensErroNomeSalgadinho.setText(msg);
		lblMensErroNomeSalgadinho.setVisible(exibir);
	}

	public void exibirErroDValidade(String msg, boolean exibir) {
		lblMensErroDValidSalgadinho.setText(msg);
		lblMensErroDValidSalgadinho.setVisible(exibir);
	}

	public void exibirErroPreco(String msg, boolean exibir) {
		lblMensErroPrecoSalgadinho.setText(msg);
		lblMensErroPrecoSalgadinho.setVisible(exibir);
	}

	public void exibirErroPeso(String msg, boolean exibir) {
		lblMensErroPesoSalgadinho.setText(msg);
		lblMensErroPesoSalgadinho.setVisible(exibir);
	}

	public void exibirErroMassa(String msg, boolean exibir) {
		lblMensErroMassaSalgadinho.setText(msg);
		lblMensErroMassaSalgadinho.setVisible(exibir);
	}

	public void exibirErroRecheio(String msg, boolean exibir) {
		lblMensErroRecheioSalgadinho.setText(msg);
		lblMensErroRecheioSalgadinho.setVisible(exibir);
	}

	public void exibirErroTipo(String msg, boolean exibir) {
		lblMensErroTipoSalgadinho.setText(msg);
		lblMensErroTipoSalgadinho.setVisible(exibir);
	}

	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}

}
