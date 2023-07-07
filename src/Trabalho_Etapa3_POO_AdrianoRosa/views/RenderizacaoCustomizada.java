package Trabalho_Etapa3_POO_AdrianoRosa.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import Trabalho_Etapa3_POO_AdrianoRosa.models.Molho;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Recheio;

public class RenderizacaoCustomizada implements ListCellRenderer<Object> {

	@Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(245, 245, 245));
        panel.setPreferredSize(new Dimension(0, 50));

        JPanel container = new JPanel(null);
        container.setBackground(new Color(255, 255, 255));
        container.setBounds(4, 2, 152, 45);

        JPanel borda = new JPanel(null);
        borda.setBackground(new Color(255, 220, 130));
        borda.setBounds(0, 43, 152, 2);

        JLabel label1 = new JLabel();
        label1.setText(value != null ? value.toString() : "");
        label1.setForeground(new Color(0, 0, 50));
        label1.setFont(new Font("Tahoma", Font.BOLD, 12));
        label1.setBounds(3, 2, 152, 20);

        JLabel label2 = new JLabel();
        if(value != null && value.getClass().getSimpleName().equalsIgnoreCase("Molho"))
        	label2.setText("R$" + ((Molho) value).getValor());
        else if(value != null)
        	label2.setText("R$" + ((Recheio) value).getValor());
        label2.setForeground(new Color(0, 0, 70));
        label2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        label2.setBounds(3, 21, 152, 20);

        container.add(label1);
        container.add(label2);
        container.add(borda);
        panel.add(container);

        if (isSelected) {
            container.setBackground(new Color(255, 255, 200));
        }

        return panel;
    }

}
