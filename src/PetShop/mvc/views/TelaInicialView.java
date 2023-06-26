package PetShop.mvc.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TelaInicialView extends JFrame {

	private static final long serialVersionUID = 1L;

	public TelaInicialView(CadastroProprietarioView cpv, CadastroAnimalView cav, TabelaAnimaisView tav,
			TabelaProprietariosView tpv) {
		super("Sistema PetShop");

		// Cria o JTabbedPane
		JTabbedPane tabbedPane = new JTabbedPane();

		// Cria as restrições para centralizar o componente verticalmente
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.CENTER;

		// Cria o primeiro painel da aba
		JPanel panel1 = new JPanel(new GridBagLayout());
		panel1.add(cpv, constraints);
		tabbedPane.addTab("Cadastrar Proprietário", panel1);

		// Cria o segundo painel da aba
		JPanel panel2 = new JPanel(new GridBagLayout());
		panel2.add(cav, constraints);
		tabbedPane.addTab("Cadastrar Animal", panel2);

		// Cria o terceiro painel da aba
		JPanel panel3 = new JPanel(new GridBagLayout());
		panel3.add(tpv, constraints);
		tabbedPane.addTab("Proprietários", panel3);

		// Cria o quarto painel da aba
		JPanel panel4 = new JPanel(new GridBagLayout());
		panel4.add(tav, constraints);
		tabbedPane.addTab("Animais", panel4);

		// Adiciona o JTabbedPane ao JFrame
		add(tabbedPane);

		// Configura o JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(370, 150);
		setResizable(false);
		pack();
		setVisible(true);

	}

}
