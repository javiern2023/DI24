import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAdministrador extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_2;
	private panelCerrar panelCerrar_;
	private panelAbrir panelAbrir_;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdministrador frame = new VentanaAdministrador();
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
	public VentanaAdministrador() {
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 399);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("ARCHIVO");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("ABRIR");
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("BUSCAR");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("CERRAR");
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("EDITAR");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("VER");
		menuBar.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelCerrar_ = new panelCerrar();
		panelCerrar_.setBounds(10, 0, 553, 326);
		contentPane.add(panelCerrar_);
		panelCerrar_.setLayout(null);
		
		panelAbrir_ = new panelAbrir();
		panelAbrir_.setBounds(10, 0, 553, 326);
		contentPane.add(panelAbrir_);
	}
	protected JMenuItem getMntmNewMenuItem() {
		return mntmNewMenuItem;
	}
	protected JMenuItem getMntmNewMenuItem_2() {
		return mntmNewMenuItem_2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(mntmNewMenuItem)) {
			panelAbrir_.setVisible(true);
			panelCerrar_.setVisible(false);
			
		}
		if(e.getSource().equals(mntmNewMenuItem_2)) {
			panelAbrir_.setVisible(false);
			panelCerrar_.setVisible(true);
		}
	}
}
