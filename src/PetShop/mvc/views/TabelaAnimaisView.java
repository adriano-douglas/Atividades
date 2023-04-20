package PetShop.mvc.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import PetShop.mvc.models.Animal;
import PetShop.mvc.models.CaoModel;
import PetShop.mvc.models.GatoModel;
import PetShop.mvc.models.PassaroModel;

public class TabelaAnimaisView extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable tabela;
	private DefaultTableModel modeloTabela;
	
	public TabelaAnimaisView() {
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("ID");
		modeloTabela.addColumn("Nome");
		modeloTabela.addColumn("Idade");
		modeloTabela.addColumn("Raça");
		modeloTabela.addColumn("Cor");
		modeloTabela.addColumn("sexo");
		modeloTabela.addColumn("nº Anilha");
		modeloTabela.addColumn("Porte");
		modeloTabela.addColumn("Peso");
		modeloTabela.addColumn("Proprietário");
		
		tabela = new JTable(modeloTabela);
		tabela.setPreferredScrollableViewportSize(new Dimension(800, 400));
		
		JScrollPane scrollPane = new JScrollPane(tabela); 
		
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void renderizarAnimais(ArrayList<Animal> animais) {
		modeloTabela.setRowCount(0);
		Object[] linha;
	    for (Animal a : animais) {
	    	if(a.getClass().getSimpleName().equals("PassaroModel")) {
	    		linha = new Object[] { a.getID(), a.getNome(), a.getIdade(), a.getRaca(), a.getCor(), 
	    				a.getSexo(), ((PassaroModel) a).getNumeroAnilha(),  "", "", a.getProprietario().getNome()};
	    	} else if(a.getClass().getSimpleName().equals("CaoModel")) {
	    		linha = new Object[] { a.getID(), a.getNome(), a.getIdade(), a.getRaca(), a.getCor(), 
	    				a.getSexo(), "", ((CaoModel) a).getPorte(), ((CaoModel) a).getPeso(), a.getProprietario().getNome()};
	    	} else {
	    		linha = new Object[] { a.getID(), a.getNome(), a.getIdade(), a.getRaca(), a.getCor(), 
	    				a.getSexo(), "", ((GatoModel) a).getPorte(), ((GatoModel) a).getPeso(), a.getProprietario().getNome()};
	    	}
	    	modeloTabela.addRow(linha);
	    }
	}
	
}
