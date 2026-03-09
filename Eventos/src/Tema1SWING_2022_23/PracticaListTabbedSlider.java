package Tema1SWING_2022_23;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;
import javax.swing.filechooser.*;

public class PracticaListTabbedSlider implements ActionListener {
	static String text;
	static JFileChooser fileC;
	public static void main(String[] args) {
		
		JFrame ventana = new JFrame();
		Container contenedor = ventana.getContentPane();
		JSlider slider = new JSlider(0,100);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		
		fileC = new JFileChooser();
		FileNameExtensionFilter fichText = new FileNameExtensionFilter("Fichero de texto", "txt","rtf");
		fileC.setFileFilter(fichText);
		
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider sliderIn = (JSlider) e.getSource();
				if(slider.getValueIsAdjusting()) {
					//System.out.println(slider.getValue());
					slider.setToolTipText(String.valueOf(slider.getValue()));
				}
			}
			
		});
		JButton anadir = new JButton("AÑADIR");
	
		JTextField texto = new JTextField("0");
		
		
		JList fich = new JList();
		DefaultListModel modelo = new DefaultListModel();
		fich.setModel(modelo);
		
		JButton sumar = new JButton ("SUMAR");
		ActionListener gestion;
		sumar.addActionListener(gestion=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==sumar) {
					int tx = slider.getValue(), cadena1;
					cadena1 = Integer.parseInt(texto.getText());
					String resultado = String.valueOf(tx+cadena1);
					texto.setText(resultado);
					
				}else if(e.getSource()==anadir) {
					
					text ="";
					fileC.showOpenDialog(ventana);
					File abre = fileC.getSelectedFile();
					text = abre.getName();
				
					modelo.addElement(text);
				}
			}
			
		});
		
		
		anadir.addActionListener(gestion);
	
		
		
		
		JPanel pesta1 = new JPanel();
		pesta1.setLayout(new BorderLayout());
		pesta1.add(fich,BorderLayout.CENTER);
		pesta1.add(anadir, BorderLayout.SOUTH);
		
		
		
		JPanel pesta2 = new JPanel();
		pesta2.setLayout(new GridLayout(3,1,2,2));
		pesta2.add(slider);
		pesta2.add(sumar);
		pesta2.add(texto);
		
		
		JTabbedPane grupo = new JTabbedPane();
		
		grupo.add("pestaña 1", pesta1);
		grupo.add("pestaña 2", pesta2);
		
		contenedor.add(grupo);
		
		ventana.setSize(400,400);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	

}
