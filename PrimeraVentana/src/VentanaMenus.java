import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMenus extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem miEditar;
	private JMenuItem miAbrir;
	private panelAbrir panelAbrir_;
	private panelBuscar panelBuscar_;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenus frame = new VentanaMenus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMenus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 436, 22);
		contentPane.add(menuBar);
		
		JMenu mnArchivo = new JMenu("ARCHIVO");
		menuBar.add(mnArchivo);
		
		miAbrir = new JMenuItem("ABRIR");
		miAbrir.addActionListener(this);
		mnArchivo.add(miAbrir);
		
		miEditar = new JMenuItem("EDITAR");
		mnArchivo.add(miEditar);
		
		panelAbrir_ = new panelAbrir();
		panelAbrir_.setBounds(0, 27, 436, 236);
		contentPane.add(panelAbrir_);
		
		panelBuscar_ = new panelBuscar();
		panelBuscar_.setBounds(0, 27, 436, 236);
		contentPane.add(panelBuscar_);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object objeto = e.getSource();
		if(objeto == miAbrir) {
			panelAbrir_.setVisible(true);
			panelBuscar_.setVisible(false);
		}
		
	}
}
