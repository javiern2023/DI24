package Tema1SWING_2022_23;

import java.awt. *;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EjemploGridBagLayout1 {

    public static void añadirComponentes(Container pane) {

    JButton boton;
	pane.setLayout(new GridBagLayout());
	GridBagConstraints restricciones = new GridBagConstraints();

	restricciones.fill = GridBagConstraints.HORIZONTAL;

	boton = new JButton("Boton 1");
	restricciones.weightx = 0.5;
	restricciones.fill = GridBagConstraints.HORIZONTAL;
	restricciones.gridx = 0;
	restricciones.gridy = 0;
	pane.add(boton, restricciones);

	boton = new JButton("Boton 2");
	restricciones.fill = GridBagConstraints.HORIZONTAL;
	restricciones.weightx = 0.5;
	restricciones.gridx = 1;
	restricciones.gridy = 0;
	pane.add(boton, restricciones);

	boton = new JButton("Boton 3");
	restricciones.fill = GridBagConstraints.HORIZONTAL;
	restricciones.weightx = 0.5;
	restricciones.gridx = 2;
	restricciones.gridy = 0;
	pane.add(boton, restricciones);

	boton = new JButton("Nombre Usuario");
	restricciones.fill = GridBagConstraints.HORIZONTAL;
	restricciones.ipady = 40;
	restricciones.weightx = 0.0;
	restricciones.gridwidth = 3;
	restricciones.gridx = 0;
	restricciones.gridy = 1;
	pane.add(boton, restricciones);

	boton = new JButton("5");
	//restricciones.fill = GridBagConstraints.HORIZONTAL;
	//restricciones.fill = GridBagConstraints.BOTH;
	restricciones.ipady = 0;       //reseteo del valor de ipady al valor por defecto
	restricciones.weighty = 1.0;   //Crecimiento vertical al ampliar la ventana
	restricciones.anchor = GridBagConstraints.PAGE_END; //Espacio inferior
	restricciones.insets = new Insets(10,0,0,0);  //Padding superior
	restricciones.gridx = 1;       //Alineado con bot�n 2
	restricciones.gridwidth = 2;   //2 Columnas de ancho
	restricciones.gridy = 2;       //3 Filas de ancho
	pane.add(boton, restricciones);
    }

    private static void crearFrame() {
        JFrame frame = new JFrame("Demo GridBagLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        añadirComponentes(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearFrame();
            }
        });
    	//crearFrame();
    }
}
