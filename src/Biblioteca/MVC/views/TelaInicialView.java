package Biblioteca.MVC.views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TelaInicialView extends JFrame {

	private static final long serialVersionUID = 1L;

	public TelaInicialView(CadastroCategoriaView ccv, CadastroLivroView clv, LivroCategoriaView lcv, TabelaCategoriasView tcv,
			TabelaLivrosView tlv) {
		super("Sistema Biblioteca");

		// Cria o JTabbedPane
		JTabbedPane tabbedPane = new JTabbedPane();

		// Cria as restrições para centralizar o componente verticalmente
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.CENTER;

		// Cria o primeiro painel da aba
		JPanel panel1 = new JPanel(new GridBagLayout());
		panel1.setPreferredSize(new Dimension(610, 350));
		panel1.add(ccv, constraints);
		tabbedPane.addTab("Cadastrar Categoria", panel1);

		// Cria o segundo painel da aba
		JPanel panel2 = new JPanel(new GridBagLayout());
		panel2.add(clv, constraints);
		tabbedPane.addTab("Cadastrar Livro", panel2);

		// Cria o terceiro painel da aba
		JPanel panel3 = new JPanel(new GridBagLayout());
		panel3.add(lcv, constraints);
		tabbedPane.addTab("Relacionar Livro e Categoria", panel3);

		// Cria o quarto painel da aba
		JPanel panel4 = new JPanel(new GridBagLayout());
		panel4.add(tcv, constraints);
		tabbedPane.addTab("Categorias", panel4);

		// Cria o quinto painel da aba
		JPanel panel5 = new JPanel(new GridBagLayout());
		panel5.add(tlv, constraints);
		tabbedPane.addTab("Livros", panel5);

		// Adiciona o JTabbedPane ao JFrame
		getContentPane().add(tabbedPane);

		// Configura o JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(370, 150);
		setResizable(false);
		pack();
		setVisible(true);
	}

}
