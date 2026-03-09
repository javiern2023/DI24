package Tema1SWING_2022_23;

import java.awt.Container;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//import Tema1AWT_2022_23.BorderLayoutAWT;

public class EjJSlider {

	public static void main(String[] args) {
		//Ejemplo JSlider
		JFrame ventana = new JFrame("Ejemplo JSlider");
		
		Container contenedor = ventana.getContentPane();
		//Creación slider con un valor mínimo y máximmo
		JSlider slider = new JSlider(0,100);
		//Espacio entre los números
		slider.setMajorTickSpacing(20);
		//Espacio entre las líneas que separan los números
		slider.setMinorTickSpacing(5);
		//Muestra los números debajo de las líneas
		slider.setPaintLabels(true);
		//Hace que se vean las línea entre los números
		slider.setPaintTicks(true);
		/*Si ponemos el ratón encima del elemento muestra el mensaje*/
		slider.setToolTipText("Establecer Valor");
		
		JSlider slider2 = new JSlider(0,100);
		slider2.setMajorTickSpacing(20);
		slider2.setMinorTickSpacing(5);
		slider2.setPaintLabels(true);
		slider2.setPaintTicks(true);
		/*Si ponemos el ratón encima del elemento muestra el mensaje*/
		slider2.setToolTipText("Establecer Valor");
		
		contenedor.add(slider, BorderLayout.NORTH);
		contenedor.add(slider2, BorderLayout.CENTER);
		
		ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		ChangeListener prueba;
		
		slider.addChangeListener(prueba = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider sliderIn = (JSlider) e.getSource();
				if(sliderIn.getValueIsAdjusting())
					//Muestra por consola
					System.out.println(slider.getValue());
					//Asigna el valor al ToolTip del Slider
					slider.setToolTipText(String.valueOf(sliderIn.getValue()));
			}
		});
		
		slider2.addChangeListener(prueba);
	}
}
