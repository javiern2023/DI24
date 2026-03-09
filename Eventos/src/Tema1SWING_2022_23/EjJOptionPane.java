package Tema1SWING_2022_23;

import javax.swing.JOptionPane;

public class EjJOptionPane {

	public static void main(String[] args) {
		String usuario = JOptionPane.showInputDialog(null, "Usuario", "LOGIN", 3);
		String contrasena = JOptionPane.showInputDialog(null, "Contraseña", "PASWWORD", 0);
		
		if("pepe".equals(usuario) && "pepe".equals(contrasena))
		{
			JOptionPane.showMessageDialog(null,"login ok","CORRECTO", JOptionPane.NO_OPTION);
		}else
		{
			JOptionPane.showMessageDialog(null,"login error","ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		int confirmado= JOptionPane.showConfirmDialog(null, "�Seguro?");
		if(confirmado == JOptionPane.OK_OPTION) {
			System.out.println("Confirmado");
		}
		else {
			System.out.println("No me sirve");
		}
		
		String[] botones = {"Bot�n A", "Bot�n B", "Bot�n C", "Bot�n D"};
		
		int ventana = JOptionPane.showOptionDialog(null, "Pulsa un bot�n", "PRUEBA", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
		
		if(ventana == 0)
			System.out.println("Pulsada Opci�n A");
		else if(ventana == 1)
			System.out.println("Pulsada Opci�n B");
		else if(ventana == 2)
			System.out.println("Pulsada Opci�n C");
		else if(ventana == 3)
			System.out.println("Pulsada Opci�n D");
	}
}
