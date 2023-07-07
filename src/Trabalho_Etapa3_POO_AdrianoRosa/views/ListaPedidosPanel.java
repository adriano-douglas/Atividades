package Trabalho_Etapa3_POO_AdrianoRosa.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class ListaPedidosPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton btnGerarPdf;
	private JFormattedTextField textData1;
	private JFormattedTextField textData2;

	private JLabel lblTitulo;
	private JTextArea textArea;

	public ListaPedidosPanel() {
		setVisible(false);
		setDoubleBuffered(false);
		setFocusable(false);
		setBackground(new Color(255, 255, 240));
		setBounds(0, 0, 819, 575);
		setLayout(null);
		
		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		lblTitulo = new JLabel("LISTA DE PEDIDOS");
		lblTitulo.setForeground(new Color(47, 79, 79));
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTitulo.setBounds(29, 30, 227, 21);
		add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(365, 11, 444, 553);
		add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Calibri", Font.BOLD, 14));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JLabel lblRelatorio = new JLabel("RELATÓRIO DE FECHAMENTO DE CAIXA");
		lblRelatorio.setForeground(new Color(105, 105, 105));
		lblRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRelatorio.setBounds(29, 104, 237, 15);
		add(lblRelatorio);
		
		JLabel lblIntervalo = new JLabel("INFORME O INTERVALO DE DATAS:");
		lblIntervalo.setForeground(new Color(105, 105, 105));
		lblIntervalo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIntervalo.setBounds(29, 151, 227, 14);
		add(lblIntervalo);
		
		textData1 = new JFormattedTextField(mascaraData);
		textData1.setBounds(29, 209, 138, 28);
		
		add(textData1);
		
		textData2 = new JFormattedTextField(mascaraData);
		textData2.setBounds(203, 209, 138, 28);
		add(textData2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(175, 224, 19, 28);
		add(separator);
		
		btnGerarPdf = new JButton("Gerar PDF");
		btnGerarPdf.setBounds(29, 285, 138, 28);
		btnGerarPdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGerarPdf.setBorderPainted(false);
		btnGerarPdf.setRolloverEnabled(false);
		btnGerarPdf.setRequestFocusEnabled(false);
		btnGerarPdf.setBackground(new Color(255, 69, 0));
		btnGerarPdf.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGerarPdf.setForeground(new Color(255, 255, 240));
		add(btnGerarPdf);

	}
	
	public void tornarVisivel() {
		setVisible(true);
	}

	public void tornarInvisivel() {
		setVisible(false);
	}
	
	public void setEventoBtnGerarPdf(ActionListener actionListener) {
		btnGerarPdf.addActionListener(actionListener);
	}
	
	public String getTextData1() {
		return textData1.getText();
	}
	
	public String getTextData2() {
		return textData2.getText();
	}
	
	public void setTextPedidos(String textPedidos) {
		textArea.setText(textPedidos);
	}
	
	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}
}
