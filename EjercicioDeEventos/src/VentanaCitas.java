import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentanaCitas {
    public static void main(String[] args) {
        // Crear ventana principal
        JFrame frame = new JFrame("Agendar Cita Médica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Panel superior para el formulario
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Campos de texto y etiquetas
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblApellido = new JLabel("Apellido:");
        JTextField txtApellido = new JTextField();
        JLabel lblTelefono = new JLabel("Teléfono:");
        JTextField txtTelefono = new JTextField();
        JLabel lblFecha = new JLabel("Fecha de la cita:");
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");

        panelFormulario.add(lblNombre);
        panelFormulario.add(txtNombre);
        panelFormulario.add(lblApellido);
        panelFormulario.add(txtApellido);
        panelFormulario.add(lblTelefono);
        panelFormulario.add(txtTelefono);
        panelFormulario.add(lblFecha);
        panelFormulario.add(dateChooser);

        // Tabla para mostrar las citas
        String[] columnas = {"Nombre", "Apellido", "Teléfono", "Fecha de Cita"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Panel inferior para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAgregar = new JButton("Agregar Cita");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnSalir = new JButton("Salir");
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);

        // Añadir componentes a la ventana
        frame.add(panelFormulario, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panelBotones, BorderLayout.SOUTH);

        // Método para gestionar todos los eventos
        ActionListener manejadorEventos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnAgregar) {
                    // Acción del botón Agregar
                    String nombre = txtNombre.getText().trim();
                    String apellido = txtApellido.getText().trim();
                    String telefono = txtTelefono.getText().trim();
                    Date fechaSeleccionada = dateChooser.getDate();

                    // Validar campos vacíos
                    if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || fechaSeleccionada == null) {
                        JOptionPane.showMessageDialog(frame, "Todos los campos deben estar completos.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Validar la fecha seleccionada
                    Date fechaActual = new Date();
                    if (fechaSeleccionada.before(fechaActual)) {
                        JOptionPane.showMessageDialog(frame, "La fecha no puede ser anterior a la fecha actual.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Formatear la fecha y agregar a la tabla
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaTexto = sdf.format(fechaSeleccionada);
                    modeloTabla.addRow(new Object[]{nombre, apellido, telefono, fechaTexto});
                    JOptionPane.showMessageDialog(frame, "Cita agregada exitosamente.");
                } else if (e.getSource() == btnEliminar) {
                    // Acción del botón Eliminar
                    int filaSeleccionada = tabla.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        modeloTabla.removeRow(filaSeleccionada);
                        JOptionPane.showMessageDialog(frame, "Cita eliminada exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (e.getSource() == btnLimpiar) {
                    // Acción del botón Limpiar
                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtTelefono.setText("");
                    dateChooser.setDate(null);
                } else if (e.getSource() == btnSalir) {
                    // Acción del botón Salir
                    System.exit(0);
                }
            }
        };

        // Asignar el manejador de eventos a los botones
        btnAgregar.addActionListener(manejadorEventos);
        btnEliminar.addActionListener(manejadorEventos);
        btnLimpiar.addActionListener(manejadorEventos);
        btnSalir.addActionListener(manejadorEventos);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}

