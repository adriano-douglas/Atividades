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

public class TabelaCategoriasView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTable tabela;
    private DefaultTableModel modeloTabela;

	public TabelaCategoriasView() {
		
		setTitle("Tabela de categorias");
		setLocation(350, 350);
		
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("ID");
		modeloTabela.addColumn("Nome");
		modeloTabela.addColumn("Livros");
		
		tabela = new JTable(modeloTabela);
		tabela.setPreferredScrollableViewportSize(new Dimension(500, 200));
		tabela.getColumnModel().getColumn(2).setCellRenderer(new MultiLineTableCellRenderer());
		tabela.setRowHeight(tabela.getRowHeight() * 3);
		
		JScrollPane scrollPane = new JScrollPane(tabela); 
		
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pack();
        setVisible(true);
        
	}
	
	public void renderizarCategorias(ArrayList<CategoriaModel> categorias) {
		modeloTabela.setRowCount(0);
	    for (CategoriaModel c : categorias) {
	    	String livros = "";
	    	for (LivroModel l : c.getLivros()) {
	    	    livros += l.getNome() + "\n";
	    	}
	    	if(!livros.isBlank())
	    		livros = livros.substring(0, livros.length() - 1);
	        modeloTabela.addRow(new Object[] { c.getID(), c.getNome(), livros });
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
