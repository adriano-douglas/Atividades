package Biblioteca.MVC;

import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadastroView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JTextField textIdLivro, textNomeLivro, textAutorLivro, textAnoLivro;
	JTextField textIdCategoria, textNomeCategoria;
	
	JButton botaoLivro, botaoCategoria, botaoLC;
	
	JComboBox<LivroModel> comboLivros = new JComboBox<>();
	JComboBox<CategoriaModel> comboCategorias = new JComboBox<>();
	
	public CadastroView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout((LayoutManager) new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	    setLocation(50, 50);
	    
	    JLabel label = new JLabel("Cadastro do Livro");
	    add(label);
	    add(new JLabel(" "));
	    
	    label = new JLabel("Id do livro");
	    add(label);
	    textIdLivro = new JTextField(8);
	    add(textIdLivro);
	    
	    label = new JLabel("Nome do livro");
	    add(label);
	    textNomeLivro = new JTextField(8);
	    add(textNomeLivro);
	    
	    label = new JLabel("Autor do livro");
	    add(label);
	    textAutorLivro = new JTextField(8);
	    add(textAutorLivro);
	    
	    label = new JLabel("Ano publicação do livro");
	    add(label);
	    textAnoLivro = new JTextField(8);
	    add(textAnoLivro);
	    
	    botaoLivro = new JButton("Salvar");
	    add(new JLabel(" "));
	    add(botaoLivro);
	    add(new JLabel(" "));
	    
	    label = new JLabel("Cadastro da Categoria");
	    add(label);
	    add(new JLabel(" "));
	    
	    label = new JLabel("Id da categoria");
	    add(label);
	    textIdCategoria = new JTextField(8);
	    add(textIdCategoria);
	    
	    label = new JLabel("Nome da categoria");
	    add(label);
	    textNomeCategoria = new JTextField(8);
	    add(textNomeCategoria);

	    botaoCategoria = new JButton("Salvar");
	    add(new JLabel(" "));
	    add(botaoCategoria);
	    add(new JLabel(" "));
	    
	    label = new JLabel("Relacionar Livro e Categoria");
	    add(label);
	    add(new JLabel(" "));
	    
	    JLabel labelLivros = new JLabel("Nenhum livro selecionado");
        add(labelLivros);
        
        comboLivros.addActionListener(e -> {
            LivroModel itemSelecionado = (LivroModel) comboLivros.getSelectedItem();
            if(itemSelecionado != null)
            	labelLivros.setText("Selecionado: " + itemSelecionado.getNome());
        });
        
        add(comboLivros);
	    
	    JLabel labelCategorias = new JLabel("Nenhuma categoria selecionada");
        add(labelCategorias);
        
        comboCategorias.addActionListener(e -> {
            CategoriaModel itemSelecionado = (CategoriaModel) comboCategorias.getSelectedItem();
            if(itemSelecionado != null)
            	labelCategorias.setText("Selecionada: " + itemSelecionado.getNome());
        });
        
        add(comboCategorias);
	    
	    botaoLC = new JButton("Salvar");
	    add(new JLabel(" "));
	    add(botaoLC);
	    add(new JLabel(" "));
	    
	    pack();
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
	
	public String getTextIdCategoria() {
		return textIdCategoria.getText();
	}
	
	public String getTextNomeCategoria() {
		return textNomeCategoria.getText();
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
	
	public void setBotaoLivro(ActionListener bLivro){
	    botaoLivro.addActionListener(bLivro);
	}
	
	public void setBotaoCategoria(ActionListener bCategoria){
	    botaoCategoria.addActionListener(bCategoria);
	}
	
	public void setBotaoLC(ActionListener bLC){
	    botaoLC.addActionListener(bLC);
	}
	
	public void limparCamposLivro() {
		textIdLivro.setText("");
		textNomeLivro.setText("");
		textAutorLivro.setText("");
		textAnoLivro.setText("");
	}

	public void limparCamposCategoria() {
		textIdCategoria.setText("");
		textNomeCategoria.setText("");
	}
	
}
