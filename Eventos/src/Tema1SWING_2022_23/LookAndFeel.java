package Tema1SWING_2022_23;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeel
{
	public static void main(String[] args) 
	{
		//Visualizaci�n de los diferentes Look And Feel disponibles en el sistema
		LookAndFeelInfo info[] = UIManager.getInstalledLookAndFeels();
		for(LookAndFeelInfo look:info)
			System.out.println(look.getClassName());
	}
}
