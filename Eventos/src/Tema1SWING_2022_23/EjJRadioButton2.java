package Tema1SWING_2022_23;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EjJRadioButton2 {

	public static void main(String[] args) 
	{
		JFrame ventana = new JFrame("Ejemplo JRadioButton 2");
		
		JRadioButton rojo = new JRadioButton("Rojo");
		JRadioButton amarillo = new JRadioButton("Amarillo");
		JRadioButton verde = new JRadioButton("Verde");
		
		JPanel colores = new JPanel();
		colores.setLayout(new BoxLayout(colores, BoxLayout.PAGE_AXIS));
		ventana.setContentPane(colores);
		
		colores.add(new JLabel("Elige tu color favorito: "));
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rojo);
		grupo.add(amarillo);
		grupo.add(verde);
		
		colores.add(rojo);
		colores.add(amarillo);
		colores.add(verde);
		
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Texto inicial en JLabel");
		ventana.getContentPane().add(etiqueta);
		
		//ventana.pack();
		ventana.setSize(300,200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		EscuchadorJRButton escuchador = new EscuchadorJRButton(etiqueta);
		EscuchadorJRButtonVerde escuchadorVerde = new EscuchadorJRButtonVerde(etiqueta);
		
		rojo.addItemListener(escuchador);
		amarillo.addItemListener(escuchador);
		verde.addItemListener(escuchadorVerde);
		
	}
}
