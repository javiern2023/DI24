package ventanasComponentes;

import java.awt.EventQueue;

public class principal {

	public static void main(String[] args) {
		/* El procesamiento completo de Swing se realiza en un hilo llamado EDT 
		 * (Event Dispatching Thread). Por lo que de la forma tradiconal podría bloquear este hilo, 
		 * ya el programa implicitamente lo está usando (con Swing).
		 * Por ese motivo la manera de asegurar que la GUI no sea bloqueada es usarla*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal frame = new ventanaPrincipal();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();// Muestra el mensaje de error de salida estándar.
				}
			}
		});
	}

}
