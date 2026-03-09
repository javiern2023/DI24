package Tema1SWING_2022_23;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
 
public class EjemploShowMessageDialog {
 
    public static void main(String[] args) {
 
        JOptionPane.showMessageDialog(null, "Constructor con 2 par�metros");
 
        JOptionPane.showMessageDialog(null, "Mensaje de informaci�n",
                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
 
        JOptionPane.showMessageDialog(null, "Mensaje de advertencia",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
 
        JOptionPane.showMessageDialog(null, "Mensaje de Error",
                "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
 
        JOptionPane.showMessageDialog(null, "Mensaje de pregunta",
                "QUESTION_MESSAGE", JOptionPane.QUESTION_MESSAGE);
 
        ImageIcon icono = new ImageIcon("recursos/prog_p.jpg");
        JOptionPane.showMessageDialog(null, "Personalizando cuadro de di�logo",
                    "CES Fuencarral", JOptionPane.INFORMATION_MESSAGE, icono);
    }
}
