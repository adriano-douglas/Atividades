package Trabalho_Etapa3_POO_AdrianoRosa.views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Utilitario {
	
	public static void centralizarEmRelacaoTela(Component component) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int panelWidth = component.getSize().width;
        int panelHeight = component.getSize().height;

        int panelX = (screenWidth - panelWidth) / 2;
        int panelY = (screenHeight - panelHeight) / 2;
        
        component.setLocation(panelX, panelY);
	}
	
	public static void centralizarEmRelacaoFrame(JFrame frame, Component component) {
		int parentX = frame.getX();
		int parentY = frame.getY();
		int parentWidth = frame.getWidth();
		int parentHeight = frame.getHeight();

		int dialogWidth = component.getWidth();
		int dialogHeight = component.getHeight();

		int dialogX = parentX + (parentWidth - dialogWidth) / 2;
		int dialogY = parentY + (parentHeight - dialogHeight) / 2;

		component.setLocation(dialogX, dialogY);
	}

}
