import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panel2 extends JPanel implements ActionListener{

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField pfPass;
	private JButton btnMostrar;
	private JCheckBox chbPsp;
	private JCheckBox chbEmpresa;
	private JRadioButton rbBaseDatos;
	private JCheckBox chbDesarrollo;
	private JCheckBox chbAndroid;
	private JComboBox cbCicloFormativo;
	private JSpinner spCurso;
	
	public panel2() {
		setLayout(null);
		
		cbCicloFormativo = new JComboBox();
		cbCicloFormativo.setBounds(205, 62, 148, 21);
		cbCicloFormativo.addItem("Seleccione una opción");
		cbCicloFormativo.addItem("DAM");
		cbCicloFormativo.addItem("DAW");
		cbCicloFormativo.addItem("ASIR");
		add(cbCicloFormativo);
		
		JLabel lblCicloFormativo = new JLabel("CICLO FORMATIVO");
		lblCicloFormativo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCicloFormativo.setBounds(33, 57, 179, 27);
		add(lblCicloFormativo);
		
		chbDesarrollo = new JCheckBox("DESARROLLO");
		chbDesarrollo.setBounds(52, 130, 93, 21);
		add(chbDesarrollo);
		chbDesarrollo.setSelected(true);
		buttonGroup.add(chbDesarrollo);
		
		chbPsp = new JCheckBox("PSP");
		chbPsp.setBounds(52, 169, 93, 21);
		add(chbPsp);
		buttonGroup.add(chbPsp);
		
		chbAndroid = new JCheckBox("ANDROID");
		chbAndroid.setBounds(52, 208, 93, 21);
		add(chbAndroid);
		buttonGroup.add(chbAndroid);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 113, 347, 2);
		add(separator);
		
		spCurso = new JSpinner();
		spCurso.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		spCurso.setBounds(298, 131, 30, 20);
		add(spCurso);
		
		chbEmpresa = new JCheckBox("EMPRESA");
		chbEmpresa.setBounds(150, 130, 93, 21);
		add(chbEmpresa);
		
		rbBaseDatos = new JRadioButton("BASE DE DATOS");
		rbBaseDatos.setBounds(153, 169, 103, 21);
		add(rbBaseDatos);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(205, 30, 112, 19);
		add(pfPass);
		
		JLabel lbContraseña = new JLabel("CONTRASEÑA");
		lbContraseña.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbContraseña.setBounds(76, 26, 103, 27);
		add(lbContraseña);
		
		btnMostrar = new JButton("MOSTRAR");
		btnMostrar.addActionListener(this);
		btnMostrar.setBounds(243, 208, 85, 21);
		add(btnMostrar);

	}
	protected JButton getBtnMostrar() {
		return btnMostrar;
	}
	protected JCheckBox getChbPsp() {
		return chbPsp;
	}
	protected JCheckBox getChckbxNewCheckBox() {
		return chbEmpresa;
	}
	protected JPasswordField getPasswordField() {
		return pfPass;
	}
	protected JRadioButton getRdbtnNewRadioButton() {
		return rbBaseDatos;
	}
	protected JCheckBox getChbDesarrollo() {
		return chbDesarrollo;
	}
	protected JCheckBox getChckbxNewCheckBox_2() {
		return chbAndroid;
	}
	protected JComboBox getCbCicloFormativo() {
		return cbCicloFormativo;
	}
	protected JSpinner getSpCurso() {
		return spCurso;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnMostrar)) {
			JOptionPane.showMessageDialog(null, pfPass.getText());
			JOptionPane.showMessageDialog(null, spCurso.getValue());
			JOptionPane.showMessageDialog(null, cbCicloFormativo.getSelectedItem());
			if(rbBaseDatos.isSelected()) {
				//Hacemos lo que queramos
			}
			if(chbEmpresa.isSelected()) {
				
			}
		}
				
	}
}
