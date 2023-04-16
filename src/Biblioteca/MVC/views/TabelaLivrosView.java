package Biblioteca.MVC.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Biblioteca.MVC.models.CategoriaModel;
import Biblioteca.MVC.models.LivroModel;

public class TabelaLivrosView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTable tabela;
    private DefaultTableModel modeloTabela;

	public TabelaLivrosView() {
			
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("ID");
		modeloTabela.addColumn("Nome");
		modeloTabela.addColumn("Autor");
		modeloTabela.addColumn("Ano Publicação");
		modeloTabela.addColumn("Categorias");
		
		tabela = new JTable(modeloTabela);
		tabela.setPreferredScrollableViewportSize(new Dimension(600, 320));
		tabela.getColumnModel().getColumn(4).setCellRenderer(new MultiLineTableCellRenderer());
		tabela.setRowHeight(tabela.getRowHeight() * 3);
		
		JScrollPane scrollPane = new JScrollPane(tabela); 
		
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		
        setVisible(true);
        
	}
	
	public void renderizarLivros(ArrayList<LivroModel> livros) {
		modeloTabela.setRowCount(0);
	    for (LivroModel l : livros) {
	    	String categorias = "";
	    	for (CategoriaModel c : l.getCategorias()) {
	    	    categorias += c.getNome() + "\n";
	    	}
	    	if(!categorias.isBlank())
	    		categorias = categorias.substring(0, categorias.length() - 1);
	        modeloTabela.addRow(new Object[] { l.getID(), l.getNome(), l.getAutor(), l.getAnoPublicacao(), categorias });
	    }
	}
	
	public class MultiLineTableCellRenderer implements TableCellRenderer {
	    private JTextArea textArea;

	    public MultiLineTableCellRenderer() {
	        textArea = new JTextArea();
	    }

		@Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        textArea.setText((String) value);
	        int lineHeight = textArea.getFontMetrics(textArea.getFont()).getHeight();
	        int desiredHeight = (lineHeight * textArea.getLineCount()) + 3; // Define a altura mínima da célula
	        if (table.getRowHeight(row) != desiredHeight) {
	            table.setRowHeight(row, desiredHeight);
	        }
	        return textArea;
	    }
	}

}
