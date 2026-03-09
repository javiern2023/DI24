package Tema1SWING_2022_23;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class EspejoSwing {
	
	private JFrame frame;
	private PanelEspejo espejo, reflejo;
	
	public class PanelEspejo extends JPanel implements ActionListener, KeyListener, ChangeListener {
		
		/**
		 * 
		 */
		PanelEspejo reflejo;
		JTextField textField;
		JRadioButton rButton1, rButton2, rButton3;
		JCheckBox cBox1, cBox2, cBox3;
		JComboBox comboBox;
		JSpinner spinner;
		boolean activo;
		
		public void cambiarEstado() {
			Component[] componentes = this.getComponents();
			activo = !activo;
			for(int i = 0; i < componentes.length; i++) {
				componentes[i].setEnabled(activo);
			}
			
		}
		
		public void reflejar() {
			reflejo.getTextField().setText(textField.getText());
			reflejo.getrButton1().setSelected(rButton1.isSelected());
			reflejo.getrButton2().setSelected(rButton2.isSelected());
			reflejo.getrButton3().setSelected(rButton3.isSelected());
			reflejo.getcBox1().setSelected(cBox1.isSelected());
			reflejo.getcBox2().setSelected(cBox2.isSelected());
			reflejo.getcBox3().setSelected(cBox3.isSelected());
			reflejo.getSpinner().setValue(spinner.getValue());
			reflejo.comboBox.setSelectedIndex(comboBox.getSelectedIndex());
		}
		
	
		public PanelEspejo(boolean activo) {
			
			this.activo = activo;
			
			textField = new JTextField();
			textField.setBounds(263, 11, 236, 30);
			this.add(textField);
			textField.setColumns(10);
			
			rButton1 = new JRadioButton("Radio 1");
			rButton1.setBounds(6, 15, 109, 23);
			//this.add(rButton1);
			
			rButton2 = new JRadioButton("Radio 2");
			rButton2.setBounds(6, 56, 109, 23);
			//this.add(rButton2);
			
			rButton3 = new JRadioButton("Radio 3");
			rButton3.setBounds(6, 98, 109, 23);
			
		
			ButtonGroup grupo = new ButtonGroup();
			grupo.add(rButton1);
			grupo.add(rButton2);
			grupo.add(rButton3);
			this.add(rButton1);
			this.add(rButton2);
			this.add(rButton3);
			
			cBox1 = new JCheckBox("Check 1");
			cBox1.setBounds(138, 15, 97, 23);
			this.add(cBox1);
			
			cBox2 = new JCheckBox("Check 2");
			cBox2.setBounds(138, 56, 97, 23);
			this.add(cBox2);
			
			cBox3 = new JCheckBox("Check 3");
			cBox3.setBounds(138, 98, 97, 23);
			this.add(cBox3);
			
			comboBox = new JComboBox();
			comboBox.setBounds(263, 52, 236, 30);
			this.add(comboBox);
			comboBox.addItem("Elemento 1");
			comboBox.addItem("Elemento 2");
			comboBox.addItem("Elemento 3");
			comboBox.addItem("Elemento 4");
			comboBox.addItem("Elemento 5");
			comboBox.addItem("Elemento 6");
			
			
			spinner = new JSpinner();
			spinner.setBounds(263, 93, 236, 30);
			this.add(spinner);
			
			textField.addKeyListener(this);
			rButton1.addActionListener(this);
			rButton2.addActionListener(this);
			rButton3.addActionListener(this);
			cBox1.addActionListener(this);
			cBox2.addActionListener(this);
			cBox3.addActionListener(this);
			comboBox.addActionListener(this);
			spinner.addChangeListener(this);
			
			
			
			Component[] componentes = this.getComponents();
			for(int i = 0; i < componentes.length; i++) {
				componentes[i].setEnabled(activo);
			}
			
			
			
			
		}

		public JTextField getTextField() {
			return textField;
		}

		public JRadioButton getrButton1() {
			return rButton1;
		}

		public JRadioButton getrButton2() {
			return rButton2;
		}

		public JRadioButton getrButton3() {
			return rButton3;
		}

		public JCheckBox getcBox1() {
			return cBox1;
		}

		public JCheckBox getcBox2() {
			return cBox2;
		}

		public JCheckBox getcBox3() {
			return cBox3;
		}

		public JComboBox getComboBox() {
			return comboBox;
		}

		public JSpinner getSpinner() {
			return spinner;
		}

		public PanelEspejo getReflejo() {
			return reflejo;
		}
		
		

		public void setReflejo(PanelEspejo reflejo) {
			this.reflejo = reflejo;
		}

		public boolean isActivo() {
			return activo;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			reflejar();
			
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			reflejar();
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
			
		}

		@Override
		public void stateChanged(ChangeEvent arg0) {
			reflejar();
			
		}
		
		
	}

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspejoSwing window = new EspejoSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EspejoSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 545, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		espejo = new PanelEspejo(true);
		espejo.setBounds(10, 11, 509, 145);
		espejo.setLayout(null);
		frame.getContentPane().add(espejo);
		
		reflejo = new PanelEspejo(false);
		reflejo.setBounds(10, 220, 509, 145);
		reflejo.setLayout(null);
		frame.getContentPane().add(reflejo);
		
		espejo.setReflejo(reflejo);
		reflejo.setReflejo(espejo);
		
		JButton btnCambiar = new JButton("CAMBIAR");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				espejo.cambiarEstado();
				reflejo.cambiarEstado();
			}
		});
		btnCambiar.setBounds(182, 167, 153, 42);
		frame.getContentPane().add(btnCambiar);
		
		JSeparator separator_izq = new JSeparator();
		separator_izq.setBounds(10, 183, 186, 2);
		frame.getContentPane().add(separator_izq);
		
		JSeparator separator_drch = new JSeparator();
		separator_drch.setBounds(333, 183, 186, 2);
		frame.getContentPane().add(separator_drch);
		
		
	}
}


