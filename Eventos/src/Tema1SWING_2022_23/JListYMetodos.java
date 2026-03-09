package Tema1SWING_2022_23;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JListYMetodos {
	public static void main(String[] args) {
        
		//Creaci�n de la ventana
		JFrame ventana = new JFrame("Ejemplo JList con Scroll");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setBounds(200, 250, 230, 250);
		ventana.setLayout(new GridLayout());

        //Creaci�n del panel, que contendra JList
		JPanel panel = new JPanel();
		panel.setLayout(null);

        //creaci�n de los elememtos que componen la lista
		String[] nombres = { "Sebas", "Miguel A", "Miguel D", "Marco", "Juan", "David", "Daniel", "Javi T" };
       
		//Creaci�n lista de nombres
		JList lista = new JList(nombres);
       
		//Selecci�n
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);     
		
		//JLabel
		JLabel etiq = new JLabel();
		etiq.setBounds(10,10,200,20);
		etiq.setForeground(new Color(255,0,0));
		//Scroll
		JScrollPane barraDesplazamiento = new JScrollPane(lista);
		barraDesplazamiento.setBounds(10, 40, 200, 110);
		
		JButton boton = new JButton("Selecci�n");
		boton.setBounds(55,160,100,20);

		lista.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				int[] indices = lista.getSelectedIndices();
				//System.out.println("N�mero de elementos: " + indices.length);
				for(int i=0; i<indices.length;i++)
				{
					String valor = lista.getModel().getElementAt(indices[i]).toString();
					etiq.setForeground(new Color(0,0,0));
					etiq.setText(valor);
					System.out.println(lista.getModel().getElementAt(indices[i]));
				}
			}
		});
		
		
		
		/*boton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int[] indices = lista.getSelectedIndices();
				System.out.println("N�mero de elementos: " + indices.length);
				
				if(indices.length == 0) 
				{
					etiq.setForeground(new Color(255,0,0));
					etiq.setText("Ho hay elementos seleccionados");   
					//System.out.println("Ho hay elementos seleccionados");
				}else
				{
					for(int i=0; i<indices.length;i++)
					{
						String valor = lista.getModel().getElementAt(indices[i]).toString();
						//System.out.println(lista.getModel().getElementAt(indices[i]));
						etiq.setForeground(new Color(0,0,0));
						etiq.setText(valor);
					}
				}
			}
		});*/
        
		//Agregar la barra de desplazamiento al panel
		panel.add(etiq);
		panel.add(barraDesplazamiento);
		panel.add(boton);

		ventana.add(panel);
		ventana.setVisible(true);

	}
}
