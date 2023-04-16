package Biblioteca.MVC.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Biblioteca.MVC.models.CategoriaModel;
import Biblioteca.MVC.models.LivroModel;

public class LivroCategoriaView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JButton botaoLC;
	
	JComboBox<LivroModel> comboLivros = new JComboBox<>();
	JComboBox<CategoriaModel> comboCategorias = new JComboBox<>();
	
	public LivroCategoriaView() {
	    // Cria os componentes
	    JLabel labelLivros = new JLabel("Nenhum livro selecionado");
	    JLabel labelCategorias = new JLabel("Nenhuma categoria selecionada");
	    botaoLC = new JButton("Salvar");

	    // Cria os Boxes para cada par de JLabel e JComboBox
	    Box boxLivros = Box.createVerticalBox();
	    boxLivros.add(labelLivros);
	    boxLivros.add(Box.createRigidArea(new Dimension(0, 5)));
	    boxLivros.add(comboLivros);

	    Box boxCategorias = Box.createVerticalBox();
	    boxCategorias.add(labelCategorias);
	    boxCategorias.add(Box.createRigidArea(new Dimension(0, 5)));
	    boxCategorias.add(comboCategorias);
	    
	    // Personalização dos componentes
	    labelLivros.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
	    labelCategorias.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
	    labelLivros.setFont(new Font("Arial", Font.BOLD, 15));
	    labelLivros.setForeground(Color.DARK_GRAY);
	    labelCategorias.setFont(new Font("Arial", Font.BOLD, 15));
	    labelCategorias.setForeground(Color.DARK_GRAY);
	    
	    botaoLC.setBackground(Color.DARK_GRAY);
	    botaoLC.setForeground(Color.WHITE);
	    botaoLC.setFont(new Font("Arial", Font.BOLD, 15));
	    
	    comboCategorias.setAlignmentX(Component.LEFT_ALIGNMENT);
	    comboLivros.setAlignmentX(Component.LEFT_ALIGNMENT);
	    comboCategorias.setPreferredSize(new Dimension(200, 25));
	    comboLivros.setPreferredSize(new Dimension(200, 25));

	    // Adiciona os componentes ao container usando o BoxLayout
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    add(boxLivros);
	    add(Box.createRigidArea(new Dimension(0, 20)));
	    add(boxCategorias);
	    add(Box.createRigidArea(new Dimension(0, 20)));
	    add(botaoLC);

	    // Configura o ActionListener para atualizar as JLabels
	    comboLivros.addActionListener(e -> {
	        LivroModel itemSelecionado = (LivroModel) comboLivros.getSelectedItem();
	        if (itemSelecionado != null)
	            labelLivros.setText("Selecionado: " + itemSelecionado.getNome());
	    });

	    comboCategorias.addActionListener(e -> {
	        CategoriaModel itemSelecionado = (CategoriaModel) comboCategorias.getSelectedItem();
	        if (itemSelecionado != null)
	            labelCategorias.setText("Selecionada: " + itemSelecionado.getNome());
	    });

	    setVisible(true);
	}

	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}
	
	public LivroModel getLivroSelecionado() {
		if((LivroModel) comboLivros.getSelectedItem() instanceof LivroModel) {
			return (LivroModel) comboLivros.getSelectedItem();
		}
		return null;
	}
	
	public CategoriaModel getCategoriaSelecionada() {
		if((CategoriaModel) comboCategorias.getSelectedItem() instanceof CategoriaModel) {
			return (CategoriaModel) comboCategorias.getSelectedItem();
		}
		return null;
	}
	
	public void setComboLivros(ArrayList<LivroModel> livros) {
		comboLivros.removeAllItems();
		for(LivroModel l : livros) {
			comboLivros.addItem(l);
		}
	}
	
	public void setComboCategorias(ArrayList<CategoriaModel> categorias) {
		comboCategorias.removeAllItems();;
		for(CategoriaModel c : categorias) {
			comboCategorias.addItem(c);
		}
	}
	
	public void setBotaoLC(ActionListener bLC){
	    botaoLC.addActionListener(bLC);
	}

}
