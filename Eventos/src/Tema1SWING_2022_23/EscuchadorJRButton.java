package Tema1SWING_2022_23;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class EscuchadorJRButton implements ItemListener {
	
	JLabel etiqueta;
	
	public EscuchadorJRButton(JLabel etiqueta) {
		this.etiqueta = etiqueta;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {	
		JRadioButton boton = (JRadioButton) e.getItemSelectable();
		String comando = boton.getActionCommand();
		System.out.println("Escuchador Amarillo-Rojo");
		switch(e.getStateChange()) {
		case ItemEvent.SELECTED:
			System.out.println("Seleccionado el color: " + comando);
			etiqueta.setText("Seleccionado el color: " + comando);
			break;
		case ItemEvent.DESELECTED:
			System.out.println("Deseleccionado el color: " + comando);
			etiqueta.setText("Deseleccionado el color: " + comando);
			break;
		}
	}
}

class EscuchadorJRButtonVerde implements ItemListener{
	
	JLabel etiqueta;
	
	EscuchadorJRButtonVerde(JLabel etiqueta)
	{
		this.etiqueta = etiqueta;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JRadioButton boton = (JRadioButton)e.getItemSelectable();
		String comando = boton.getActionCommand();
		System.out.println("Escuchador Verde");
		switch(e.getStateChange()) {
		case ItemEvent.SELECTED:
			System.out.println("Seleccionado el color: " + comando);
			etiqueta.setText("Seleccionado el color: " + comando);
			break;
		case ItemEvent.DESELECTED:
			System.out.println("Deseleccionado el color: " + comando);
			etiqueta.setText("Deseleccionado el color: " + comando);
			break;
		}	
	}
}
