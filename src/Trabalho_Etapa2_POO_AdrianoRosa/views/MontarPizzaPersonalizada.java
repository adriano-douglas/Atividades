package Trabalho_Etapa2_POO_AdrianoRosa.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;

import Trabalho_Etapa2_POO_AdrianoRosa.controllers.PizzaPersonalizadaController;
import Trabalho_Etapa2_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Molho;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Recheio;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

public class MontarPizzaPersonalizada extends JDialog {

	private static final long serialVersionUID = 1L;

	private JButton botaoOk;
	private JButton botaoCancelar;

	private JLabel lblRecheios;
	private JLabel lblMolhos;
	private JLabel lblRecheioDaBorda;
	private JLabel lblBorda;

	private JPanel painelConteudo;
	private static JPanel painelConteudoRecheios;

	private JScrollPane scrollPaneRecheios;

	private JComboBox<Molho> comboMolho;
	private JComboBox<Recheio> comboBorda;

	private ButtonGroup grupoRecheioBorda;

	private JRadioButton rdbtnTradicional;
	private JRadioButton rdbtnRecheada;
	
	private static String tipoBorda = "Tradicional";

	public MontarPizzaPersonalizada(JFrame parent) {
		super(parent, "Formulário", true); // Define o diálogo como modal
		setTitle("Pizza Personalizada");
		setSize(423, 400);
		setResizable(false);

		// Criação do painel para o conteúdo do diálogo
		painelConteudo = new JPanel();
		painelConteudo.setBackground(new Color(255, 255, 240));
		painelConteudo.setLayout(null);
		painelConteudo.setBounds(0, 0, 600, 500);
		getContentPane().add(painelConteudo);

		lblRecheios = new JLabel("Recheios");
		lblRecheios.setBounds(10, 11, 196, 14);
		painelConteudo.add(lblRecheios);

		scrollPaneRecheios = new JScrollPane();
		scrollPaneRecheios.setBounds(10, 36, 196, 317);
		scrollPaneRecheios.getVerticalScrollBar().setPreferredSize(new Dimension(10, HEIGHT));
		painelConteudo.add(scrollPaneRecheios);

		painelConteudoRecheios = new JPanel();
		painelConteudoRecheios.setBackground(new Color(245, 245, 245));
		painelConteudoRecheios.setLayout(null);

		carregarPainelRecheios(DB.recheiosPizza);

		scrollPaneRecheios.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneRecheios.setViewportView(painelConteudoRecheios);

		lblMolhos = new JLabel("Molho");
		lblMolhos.setBounds(216, 11, 136, 14);
		painelConteudo.add(lblMolhos);

		comboMolho = new JComboBox<>();
		comboMolho.setFocusable(false);
		comboMolho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboMolho.setBorder(null);
		comboMolho.setBackground(new Color(255, 255, 255));
		comboMolho.setMaximumRowCount(4);
		comboMolho.setVerifyInputWhenFocusTarget(false);
		comboMolho.setBounds(216, 36, 180, 51);
		comboMolho.setRenderer(new RenderizacaoCustomizada());
		painelConteudo.add(comboMolho);

		lblBorda = new JLabel("Borda");
		lblBorda.setBounds(216, 110, 136, 14);
		painelConteudo.add(lblBorda);

		grupoRecheioBorda = new ButtonGroup();

		rdbtnTradicional = new JRadioButton("Tradicional");
		rdbtnTradicional.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnTradicional.setFocusable(false);
		rdbtnTradicional.setContentAreaFilled(false);
		rdbtnTradicional.setBounds(216, 131, 97, 23);
		rdbtnTradicional.setSelected(true);
		painelConteudo.add(rdbtnTradicional);
		grupoRecheioBorda.add(rdbtnTradicional);

		rdbtnRecheada = new JRadioButton("Recheada");
		rdbtnRecheada.setFocusable(false);
		rdbtnRecheada.setContentAreaFilled(false);
		rdbtnRecheada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnRecheada.setBounds(216, 157, 97, 23);
		painelConteudo.add(rdbtnRecheada);
		grupoRecheioBorda.add(rdbtnRecheada);

		// Criar o ActionListener para os botões de rádio
		ActionListener radioListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnTradicional.isSelected()) {
					lblRecheioDaBorda.setVisible(false);
					comboBorda.setVisible(false);
					tipoBorda = "Tradicional";
				} else if (rdbtnRecheada.isSelected()) {
					lblRecheioDaBorda.setVisible(true);
					comboBorda.setVisible(true);
					tipoBorda = "Recheada";
				}
			}
		};

		rdbtnRecheada.addActionListener(radioListener);
		rdbtnTradicional.addActionListener(radioListener);

		lblRecheioDaBorda = new JLabel("Recheio da Borda");
		lblRecheioDaBorda.setBounds(216, 199, 136, 14);
		lblRecheioDaBorda.setVisible(false);
		painelConteudo.add(lblRecheioDaBorda);

		comboBorda = new JComboBox<Recheio>();
		comboBorda.setBounds(216, 224, 180, 51);
		comboBorda.setFocusable(false);
		comboBorda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBorda.setBorder(null);
		comboBorda.setBackground(new Color(255, 255, 255));
		comboBorda.setMaximumRowCount(4);
		comboBorda.setVerifyInputWhenFocusTarget(false);
		comboBorda.setVisible(false);
		comboBorda.setRenderer(new RenderizacaoCustomizada());
		painelConteudo.add(comboBorda);

		botaoOk = new JButton("OK");
		botaoOk.setBounds(216, 330, 85, 23);
		painelConteudo.add(botaoOk);

		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(311, 330, 85, 23);
		painelConteudo.add(botaoCancelar);

	}

	private static JPanel criarPainelItem(Recheio recheio) {

		JPanel panelItem = new JPanel();
		panelItem.setBackground(new Color(255, 255, 255));
		panelItem.setLayout(null);

		JPanel borda = new JPanel();
		borda.setBackground(new Color(255, 220, 130));
		borda.setBounds(0, 50, 172, 3);
		panelItem.add(borda);

		JCheckBox checkBox = new JCheckBox();
		JLabel lblNome = new JLabel(recheio.getNome());
		JLabel lblValor = new JLabel("R$" + recheio.getValor().toString());

		lblValor.setForeground(new Color(0, 0, 70));
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 13));

		checkBox.setBorder(null);
		checkBox.setContentAreaFilled(false);
		checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblNome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNome.setForeground(new Color(0, 0, 50));

		checkBox.addItemListener(e -> {
			boolean isSelected = checkBox.isSelected();
			if (!isSelected) {
				PizzaPersonalizadaController.recheiosUsados.remove(recheio);
				borda.setBackground(new Color(255, 220, 130));
			} else {
				PizzaPersonalizadaController.recheiosUsados.add(recheio);
				borda.setBackground(new Color(255, 90, 90));
			}
		});

		lblNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkBox.setSelected(!checkBox.isSelected());
			}
		});

		checkBox.setBounds(7, 5, 20, 20);
		lblNome.setBounds(25, 0, 170, 30);
		lblValor.setBounds(7, 27, 95, 19);

		panelItem.add(checkBox);
		panelItem.add(lblNome);
		panelItem.add(lblValor);

		return panelItem;

	}

	public void carregarPainelRecheios(ArrayList<Recheio> recheios) {
		painelConteudoRecheios.removeAll();
		int i = 0;
		for (Recheio r : recheios) {
			JPanel panelItem = criarPainelItem(r);
			panelItem.setBounds(5, 5 + (i++ * 58), 172, 53);
			painelConteudoRecheios.add(panelItem);
		}
	}

	public void setPainelConteudoRecheiosSize(Integer totalRecheios) {
		painelConteudoRecheios.setPreferredSize(new Dimension(0, totalRecheios * 59));
	}

	public void setEventoBotaoOk(ActionListener actionListener) {
		botaoOk.addActionListener(actionListener);
	}

	public void setEventoBotaoCancelar(ActionListener actionListener) {
		botaoCancelar.addActionListener(actionListener);
	}

	public void setComboMolhoModel(ArrayList<Molho> molhos) {
		comboMolho.setModel(new DefaultComboBoxModel<Molho>(molhos.toArray(new Molho[0])));
	}

	public void setComboRecheiosBordaModel(ArrayList<Recheio> recheios) {
		comboBorda.setModel(new DefaultComboBoxModel<Recheio>(recheios.toArray(new Recheio[0])));
	}

	public Molho getMolhoSelecionado() {
		return (Molho) comboMolho.getSelectedItem();
	}

	public Recheio getRecheioBordaSelecionado() {
		return (Recheio) comboBorda.getSelectedItem();
	}
	
	public String getTipoBorda() {
		return tipoBorda;
	}
	
	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}
}
