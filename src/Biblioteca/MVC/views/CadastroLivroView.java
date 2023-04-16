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

public class CadastroLivroView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JTextField textIdLivro, textNomeLivro, textAutorLivro, textAnoLivro;
	
	JButton botaoLivro;
	
	public CadastroLivroView() {
	   
	    JLabel label;
	    
	    label = new JLabel("Id do livro:");
	    label.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
	    label.setFont(new Font("Arial", Font.BOLD, 15));
	    add(label);
	    textIdLivro = new JTextField(8);
	    add(textIdLivro);
	    
	    label = new JLabel("Nome do livro:");
	    label.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
	    label.setFont(new Font("Arial", Font.BOLD, 15));
	    add(label);
	    textNomeLivro = new JTextField(8);
	    add(textNomeLivro);
	    
	    label = new JLabel("Autor do livro:");
	    label.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
	    label.setFont(new Font("Arial", Font.BOLD, 15));
	    add(label);
	    textAutorLivro = new JTextField(8);
	    add(textAutorLivro);
	    
	    label = new JLabel("Ano publicação do livro:");
	    label.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
	    label.setFont(new Font("Arial", Font.BOLD, 15));
	    add(label);
	    textAnoLivro = new JTextField(8);
	    add(textAnoLivro);
	    
	    botaoLivro = new JButton("Salvar");
	    add(new JLabel(" "));
	    add(botaoLivro);
	    add(new JLabel(" "));
	    
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    
	    textIdLivro.setPreferredSize(new Dimension(Integer.MAX_VALUE, 25));
	    textNomeLivro.setPreferredSize(new Dimension(Integer.MAX_VALUE, 25));
	    textAutorLivro.setPreferredSize(new Dimension(Integer.MAX_VALUE, 25));
	    textAnoLivro.setPreferredSize(new Dimension(Integer.MAX_VALUE, 25));
	    
	    botaoLivro.setBackground(Color.DARK_GRAY);
	    botaoLivro.setForeground(Color.WHITE);
	    botaoLivro.setFont(new Font("Arial", Font.BOLD, 15));
	    
	    setVisible(true);
	}

	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}
	
	public String getTextIdLivro() {
		return textIdLivro.getText();
	}
	
	public String getTextNomeLivro() {
		return textNomeLivro.getText();
	}
	
	public String getTextAutorLivro() {
		return textAutorLivro.getText();
	}
	
	public String getTextAnoLivro() {
		return textAnoLivro.getText();
	}
	
	public void setBotaoLivro(ActionListener bLivro){
	    botaoLivro.addActionListener(bLivro);
	}
	
	public void limparCamposLivro() {
		textIdLivro.setText("");
		textNomeLivro.setText("");
		textAutorLivro.setText("");
		textAnoLivro.setText("");
	}

}
