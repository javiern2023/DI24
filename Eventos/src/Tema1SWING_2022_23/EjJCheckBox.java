package Tema1SWING_2022_23;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class EjJCheckBox {

	public static void main(String[] args) 
	{
		JFrame ventana = new JFrame("Ejemplo JCheckBox");
		
		JLabel titulo = new JLabel("Elige tu color favorito");
		JLabel valorS = new JLabel("Etiqueta Seleccionada");
		JLabel valorD = new JLabel("Etiqueta Deseleccionada");
		
		JCheckBox rojo = new JCheckBox("Rojo");
		JCheckBox amarillo = new JCheckBox("Amarillo");
		JCheckBox verde = new JCheckBox("Verde");
		
		JPanel colores = new JPanel();
		
		//BoxLayout para que vaya alienando los componenges verticalmente
		colores.setLayout(new BoxLayout(colores, BoxLayout.Y_AXIS));
		
		//Panel colores como contenedor del Frame 
		ventana.setContentPane(colores);
		
		colores.add(titulo);
		
		colores.add(rojo);
		colores.add(amarillo);
		colores.add(verde);
		colores.add(valorS);
		colores.add(valorD);
		
		//Adapta el tama�o de la ventana a los componentes a�adidos
		ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		ItemListener escuchador;
		
		rojo.addItemListener(escuchador = new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox boton = (JCheckBox) e.getItemSelectable();
				
				String comando = boton.getActionCommand();
				
				switch(e.getStateChange()) {
				case ItemEvent.SELECTED:
					System.out.println("Seleccionado el color " + comando);
					valorS.setText("Etiqueta Seleccionada " + comando);
					break;
				case ItemEvent.DESELECTED:
					System.out.println("Deseleccionado el color " + comando);
					valorD.setText("Etiqueta Deseleccionada " + comando);
					break;
				}
			}
			
		});
		
		amarillo.addItemListener(escuchador);
		verde.addItemListener(escuchador);
	}

}
