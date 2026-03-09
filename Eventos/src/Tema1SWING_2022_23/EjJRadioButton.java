package Tema1SWING_2022_23;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class EjJRadioButton {
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ejemplo JRadioButton");
		
		JLabel titulo = new JLabel("Elige tu color favorito");
		JLabel valorS = new JLabel("Etiqueta color Seleccionado ");
		JLabel valorD = new JLabel("Etiqueta color Deseleccionado ");
		
		JRadioButton rojo = new JRadioButton("Rojo");
		JRadioButton amarillo = new JRadioButton("Amarillo");
		JRadioButton verde = new JRadioButton("Verde");
		
		JPanel colores = new JPanel();
		
		colores.setLayout(new BoxLayout(colores, BoxLayout.Y_AXIS));
		
		ventana.setContentPane(colores);
		
		colores.add(titulo);
		
		//Crear grupo para los tres Radio Button
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(rojo);
		grupoBotones.add(amarillo);
		grupoBotones.add(verde);
		
		colores.add(rojo);
		colores.add(amarillo);
		colores.add(verde);
		colores.add(valorS);
		colores.add(valorD);
		
		ventana.setSize(400,250);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		ItemListener escuchador;
		
		rojo.addItemListener(escuchador = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				JRadioButton boton = (JRadioButton) e.getItemSelectable();
				
				String comando = boton.getActionCommand();
				switch(e.getStateChange()) {
				case ItemEvent.SELECTED:
					System.out.println("Seleccionado el color " + comando);
					valorS.setText("Etiqueta color Seleccionado: " + comando);
					break;
				case ItemEvent.DESELECTED:
					System.out.println("Deseleccionado el color "  + comando);
					valorD.setText("Etiqueta color Deseleccionado: " + comando);
					break;
				}
			}			
		});
		
		amarillo.addItemListener(escuchador);
		verde.addItemListener(escuchador);
	}
}
