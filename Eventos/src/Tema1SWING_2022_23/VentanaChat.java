package Tema1SWING_2022_23;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaChat extends JFrame implements ActionListener {

	private JTextArea area;
	private JScrollPane scroll;
	private JTextField texto;
	private JButton boton;

	// Constructor del JFrame
	public VentanaChat() {
		super("GridBagLayout");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridBagLayout());

		// Instanciamos objeto de la clase GridBagConstraints, para establecer las
		// restricciones de cada
		// componente dentro de la ventana, su comportamiento
		GridBagConstraints gbc = new GridBagConstraints();

		// Instanciamos los componentes
		area = new JTextArea();
		scroll = new JScrollPane(area);
		texto = new JTextField(30);
		boton = new JButton("Enviar");

		// Creamos las restricciones de cada componente
		// En primer lugar, establecemos las caracter�sticas del primer componente, que
		// es el JScroll con el JTextArea
		// Columna en la que empezar� el componente
		gbc.gridx = 0;
		// Fila en la que empezar� el componente
		gbc.gridy = 0;
		// Ancho del componente, las columnas que ocupar� (Columnas 0 y 1)
		gbc.gridwidth = 2;
		// Alto del componente, las filas que ocupar� (Solo Fila 0)
		gbc.gridheight = 1;
		// Establecemos la forma en que se ampliar� el componente al agrandar la ventana
		// (1.0 - Proporcional ; 2.0 - El doble que la ampliaci�n de la ventana...)
		// Crecimiento del ancho
		gbc.weightx = 1.0;
		// Crecimiento del alto
		gbc.weighty = 1.0;
		// Se indica la forma en que rellenar� el componente el �rea de la/s celda/s que
		// ocupa.
		// HORIZONTAL = Ocupa todo el espacio de la celda horizontalmente
		// VERTICAL = Ocupa todo el espacio de la celda verticalmente
		// BOTH = Ocupa ambos espacios. NONE = Solo ocupa el tama�o del componente.
		// gbc.fill = GridBagConstrints.BOTH;
		// Se a�ade el componente scroll con el JTextArea
		add(scroll, gbc);

		// Elemento JTextField
		gbc.gridx = 0;
		gbc.gridy = 1;
		// Columna 1
		gbc.gridwidth = 1;
		// Solo Fila 1
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		// Que mantenga el mismo alto aunque crezca el alto de la ventana
		gbc.weighty = 0.0;
		// En este caso, ocupar� todo el espacio horizontalmente
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(texto, gbc);

		// Elemento JButton
		gbc.gridx = 1;
		gbc.gridy = 1;
		// Columna 1
		gbc.gridwidth = 1;
		// Solo Fila 1
		gbc.gridheight = 1;
		// Que mantenga el mismo ancho y alto aunque crezca la ventana
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		// En este caso, ocupar� todo el espacio horizontalmente
		gbc.fill = GridBagConstraints.NONE;
		add(boton, gbc);

		boton.addActionListener(this);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton) {
			area.append(texto.getText() + "\\");
			texto.setText("");
		}
	}
}
