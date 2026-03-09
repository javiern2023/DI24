package Tema1SWING_2022_23;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
 
public class EjercicioEventos extends JFrame {
 
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JComboBox<String> comboBox;
    private JRadioButton rdbtnOpcion;
    private JRadioButton rdbtnOpcion_1;
    private JRadioButton rdbtnOpcion_2;
    private JLabel lblEstasSobreLa;
    private JButton btnPrueba;
    private JButton btnAnadir;
    
 
    public static void main(String[] args) {
        /*El procesamiento completo de Swing se realiza en un hilo llamado EDT 
         * (Event Dispatching Thread). Por lo que de la forma tradiconal podría 
         * bloquear este hilo, ya que tu programa implicitamente lo está usando 
         * (con Swing).Por ese motivo la manera de asegurar que la GUI no sea 
         * bloqueada es usar esta clase Runnable*/
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EjercicioEventos frame = new EjercicioEventos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EjercicioEventos() {
        setTitle("Ventana de Eventos");
        setBounds(400, 200, 725, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
 
        //Creamos el panel y lo ctivamos como panel principal
        contentPane =new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
 
        //Componentes de la ventana
        //Etiquetas
        JLabel lblEscribeElNombre = new JLabel("Escribe el nombre de una persona sin digitos");
        lblEscribeElNombre.setBounds(369, 32, 350, 25);
        contentPane.add(lblEscribeElNombre);
 
        JLabel lblEligeUnaOpcion = new JLabel("Elige una opcion:");
        lblEligeUnaOpcion.setBounds(176, 32, 109, 14);
        contentPane.add(lblEligeUnaOpcion);
 
        JLabel lblPulsaElBoton = new JLabel("Pulsa el boton");
        lblPulsaElBoton.setBounds(47, 32, 85, 14);
        contentPane.add(lblPulsaElBoton);
 
        lblEstasSobreLa = new JLabel("Estas sobre la opcion");
        lblEstasSobreLa.setBounds(158, 224, 192, 14);
        contentPane.add(lblEstasSobreLa);
 
        JLabel lblSoloSePuede = new JLabel("Solo se pueden escribir digitos");
        lblSoloSePuede.setBounds(371, 208, 193, 14);
        contentPane.add(lblSoloSePuede);
 
        JLabel lblNombreElegido = new JLabel("Nombre Elegido");
        lblNombreElegido.setBounds(175, 124, 110, 14);
        contentPane.add(lblNombreElegido);
 
        //Campos de texto
        textField = new JTextField();
        textField.setBounds(371, 68, 193, 26);
        contentPane.add(textField);
 
        textField_1 = new JTextField();
        textField_1.setEditable(false);
        textField_1.setBounds(175, 150, 141, 20);
        contentPane.add(textField_1);
 
        textField_2 = new JTextField();
        textField_2.setBounds(371, 247, 126, 20);
        contentPane.add(textField_2);
 
        //Botones
        JButton btnPulsame = new JButton("Pulsame");
        btnPulsame.setBounds(43, 70, 89, 23);
        contentPane.add(btnPulsame);
 
        btnAnadir= new JButton("Añadir");
        btnAnadir.setBounds(371, 124, 89, 23);
        contentPane.add(btnAnadir);
 
        //RadioButtons de radio
        rdbtnOpcion= new JRadioButton("Opcion 1");
        rdbtnOpcion.setBounds(43, 194, 109, 23);
        contentPane.add(rdbtnOpcion);
 
        rdbtnOpcion_1 = new JRadioButton("Opcion 2");
        rdbtnOpcion_1.setBounds(43, 220, 109, 23);
        contentPane.add(rdbtnOpcion_1);
 
        rdbtnOpcion_2 = new JRadioButton("Opcion 3");
        rdbtnOpcion_2.setBounds(43, 246, 109, 23);
        contentPane.add(rdbtnOpcion_2);
 
        //Agrupamos los botnones de radio
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(rdbtnOpcion);
        bgroup.add(rdbtnOpcion_1);
        bgroup.add(rdbtnOpcion_2);
 
        //ComboBox con las opciones
        comboBox = new JComboBox<>();
        comboBox.setBounds(175, 70, 141, 22);
        contentPane.add(comboBox);
        comboBox.addItem("Fernando");
        comboBox.addItem("Alberto");
        comboBox.addItem("Arturo");
        comboBox.addItem("Luis");
        
        btnPrueba = new JButton("prueba");
        btnPrueba.setBounds(570, 149, 85, 21);
        contentPane.add(btnPrueba);
 
        //Eventos
        //Evento que se ejecuta cuando se pulsa el botón
        btnPulsame.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(contentPane, "Pulsado el boton 'Pulsame'");
            }
        });
 
        //En este caso hemos debido de convertir el componente en un atributo
        //Evevento que se produce cuando seleccionamos un elemento del comboBox
        comboBox.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                //Cargamos en el textField el contenido del comboBox
            	textField_1.setText(comboBox.getItemAt(comboBox.getSelectedIndex()));
            	//textField_1.setText(comboBox.getSelectedItem().toString());
            }
        });
 
        textField.addKeyListener(new KeyListener(){
            //Método que captura el evento al pulsar y soltar la tecla
        	public void keyTyped (KeyEvent e){
                //Si el caracter introducido es un digito...
            	System.out.println(e.getKeyChar());
                if (!Character.isAlphabetic(e.getKeyChar())){
                	//anula la tecla pulsada y no la escribe en el textField
                    e.consume();
                }
            }
            //Método que captura el evento al solar la tecla
        	public void keyReleased(KeyEvent e){
            }
            //Método que captura el evento al pulsar la tecla
        	public void keyPressed(KeyEvent e){
            }
        });
        //Método que captura el evento al pulsar el botón
        btnAnadir.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	String anadirNombre = textField.getText();
            	if(anadirNombre.compareTo("")!= 0) 	{
                   comboBox.addItem(anadirNombre);
                   JOptionPane.showMessageDialog(contentPane, "Nombre Añadido: " + anadirNombre);
                   textField.setText("");
            	}
            	else {
            		JOptionPane.showMessageDialog(contentPane, "No hay ningun nombre para añadir");
            	}
            }
        });
        //Métodos que capturan los eventos producidos por el ratón
        rdbtnOpcion.addMouseListener(new MouseListener(){
            //Método que captura al pulsar y soltar el botón del ratón
        	public void mouseClicked(MouseEvent e){
        		;
            }
            //Método que captura la entrada en un elemento por parte del ratón
        	public void mouseEntered(MouseEvent e){
                lblEstasSobreLa.setText(lblEstasSobreLa.getText()+rdbtnOpcion.getText());
            }
            public void mouseExited(MouseEvent e){
                lblEstasSobreLa.setText("Estas sobre la ");
            }
            public void mousePressed(MouseEvent e){
            	
            }
            public void mouseReleased(MouseEvent e){
            	
            }
        });
 
        rdbtnOpcion_1.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e){
            }
            public void mouseEntered(MouseEvent e){
                lblEstasSobreLa.setText(lblEstasSobreLa.getText()+rdbtnOpcion_1.getText());
            }
            public void mouseExited(MouseEvent e){
                lblEstasSobreLa.setText("Estas sobre la ");
            }
            public void mousePressed(MouseEvent e){
            }
            public void mouseReleased(MouseEvent e){
            }
        });
 
        rdbtnOpcion_2.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e){
            }
            public void mouseEntered(MouseEvent e){
                lblEstasSobreLa.setText(lblEstasSobreLa.getText()+rdbtnOpcion_2.getText());
            }
            public void mouseExited(MouseEvent e){
                lblEstasSobreLa.setText("Estas sobre la ");
            }
            public void mousePressed(MouseEvent e){
            }
            public void mouseReleased(MouseEvent e){
            }
        });
 
        textField_2.addKeyListener(new KeyListener(){
            public void keyTyped (KeyEvent e){
                //Si el caracter introducido no es un digito...
            	System.out.println("Codigo: " + e.getKeyCode());
                if (!Character.isDigit(e.getKeyChar())){
                    //anula la tecla pulsada y no la escribe
                    e.consume();
                }
              	System.out.println("Codigo: " + e.getKeyCode());
            	if(e.getKeyCode() == KeyEvent.VK_CONTROL && e.getKeyCode() == KeyEvent.VK_V)
            	{
            		System.out.println("Control pulsado");
            		e.consume();
            	}
            }
            public void keyReleased(KeyEvent e){
            	
            }
            public void keyPressed(KeyEvent e){
              	System.out.println("Codigo: " + e.getKeyCode());
              	String tecla = e.getKeyText(e.getKeyCode());
            	if(tecla == "Ctrl")
            	{
            		System.out.println(e.getKeyText(e.getKeyCode()));
            		System.out.println("Control pulsado");
            		e.consume();
            	}
            }
        });
        
        textField_2.addFocusListener(new FocusListener() 
        {
			public void focusGained(FocusEvent e) {
				textField_2.setText("Solo numeros");
			}
			public void focusLost(FocusEvent e) {
				textField_2.setText("");
			}
        }); 
    }
	protected JButton getBtnPrueba() {
		return btnPrueba;
	}
	protected JButton getBtnAnadir() {
		return btnAnadir;
	}
}
