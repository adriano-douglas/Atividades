package Trabalho_Etapa2_POO_AdrianoRosa.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListaPedidosPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblTitulo;
	private JTextArea textArea;

	public ListaPedidosPanel() {
		setVisible(false);
		setDoubleBuffered(false);
		setFocusable(false);
		setBackground(new Color(255, 255, 240));
		setBounds(0, 0, 819, 575);
		setLayout(null);

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

	}
	
	public void tornarVisivel() {
		setVisible(true);
	}

	public void tornarInvisivel() {
		setVisible(false);
	}
	
	public void setTextPedidos(String textPedidos) {
		textArea.setText(textPedidos);
	}

}
