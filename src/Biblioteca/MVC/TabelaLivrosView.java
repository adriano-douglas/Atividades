package Biblioteca.MVC;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TabelaLivrosView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTable tabela;
    private DefaultTableModel modeloTabela;

	public TabelaLivrosView() {
		
		setTitle("Tabela de livros");
		setLocation(350, 50);
		
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("ID");
		modeloTabela.addColumn("Nome");
		modeloTabela.addColumn("Autor");
		modeloTabela.addColumn("Ano Publicação");
		modeloTabela.addColumn("Categorias");
		
		tabela = new JTable(modeloTabela);
		tabela.setPreferredScrollableViewportSize(new Dimension(600, 200));
		tabela.getColumnModel().getColumn(4).setCellRenderer(new MultiLineTableCellRenderer());
		tabela.setRowHeight(tabela.getRowHeight() * 3);
		
		JScrollPane scrollPane = new JScrollPane(tabela); 
		
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pack();
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
