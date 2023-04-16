package Biblioteca.MVC.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroCategoriaView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	JTextField textIdCategoria, textNomeCategoria;
	
	JButton botaoCategoria;
	
	public CadastroCategoriaView() {
	    
	    JLabel label;
	    
	    label = new JLabel("Id da categoria:");
	    label.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
	    label.setFont(new Font("Arial", Font.BOLD, 15));
	    add(label);
	    textIdCategoria = new JTextField(8);
	    add(textIdCategoria);
	    
	    label = new JLabel("Nome da categoria:");
	    label.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
	    label.setFont(new Font("Arial", Font.BOLD, 15));
	    add(label);
	    textNomeCategoria = new JTextField(8);
	    add(textNomeCategoria);

	    botaoCategoria = new JButton("Salvar");
	    add(new JLabel(" "));
	    add(botaoCategoria);
	    add(new JLabel(" "));
	    
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    
	    textIdCategoria.setPreferredSize(new Dimension(Integer.MAX_VALUE, 25));
	    textNomeCategoria.setPreferredSize(new Dimension(Integer.MAX_VALUE, 25));
	    botaoCategoria.setBackground(Color.DARK_GRAY);
	    botaoCategoria.setForeground(Color.WHITE);
	    botaoCategoria.setFont(new Font("Arial", Font.BOLD, 15));
	    
	    setVisible(true);
	}

	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}
	
	public String getTextIdCategoria() {
		return textIdCategoria.getText();
	}
	
	public String getTextNomeCategoria() {
		return textNomeCategoria.getText();
	}
	
	public void setBotaoCategoria(ActionListener bCategoria){
	    botaoCategoria.addActionListener(bCategoria);
	}
	
	public void limparCamposCategoria() {
		textIdCategoria.setText("");
		textNomeCategoria.setText("");
	}

}
