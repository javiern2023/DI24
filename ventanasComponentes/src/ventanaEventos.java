import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ventanaEventos extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane;
	private JButton btn2;
	private JButton btn1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaEventos frame = new ventanaEventos();
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
	public ventanaEventos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn1 = new JButton("New button");
		btn1.addMouseListener(this);
		btn1.addActionListener(this);
		btn1.setBounds(43, 62, 85, 21);
		contentPane.add(btn1);
		
		btn2 = new JButton("New button");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Introducir el código
			}
		});
		btn2.setBounds(43, 106, 85, 21);
		contentPane.add(btn2);
	}
	protected JButton getBtn2() {
		return btn2;
	}
	protected JButton getBtn1() {
		return btn1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btn1)) {
			//panel1.setVisible(false);
			//panel2.setVisible(true);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
