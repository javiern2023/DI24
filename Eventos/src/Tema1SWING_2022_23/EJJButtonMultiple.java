package Tema1SWING_2022_23;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.*;

class EventosFrame extends JFrame
{
	public EventosFrame()
	{
		setTitle("Uso Eventos");
		setSize(400,250);
		addWindowListener(new VentanaPrincipalListener());
		Container contenido = getContentPane();
		contenido.add(new PanelBotones());
	}
}


class VentanaPrincipalListener extends WindowAdapter
{
	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}

public class EJJButtonMultiple 
{
	public static void main(String[] args) 
	{
		JFrame frame = new EventosFrame();
		frame.setVisible(true);
	}
}

class PanelBotones extends JPanel implements ActionListener
{
	private JButton JButtonRojo;
	private JButton JButtonVerde;
	private JButton JButtonAzul;
	
	public PanelBotones()
	{
		JButtonRojo = new JButton("Rojo");
		JButtonVerde = new JButton("Verde");
		JButtonAzul = new JButton("Azul");
		
		this.add(JButtonRojo);
		this.add(JButtonVerde);
		this.add(JButtonAzul);
		
		JButtonRojo.addActionListener(this);
		JButtonVerde.addActionListener(this);
		JButtonAzul.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		Color color = getBackground();
		
		if(source == JButtonRojo)
			color = Color.RED;
		else if (source == JButtonVerde)
			color = Color.GREEN;
		else if (source == JButtonAzul)
			color = Color.BLUE;
		
		setBackground(color);
	}
	
}
