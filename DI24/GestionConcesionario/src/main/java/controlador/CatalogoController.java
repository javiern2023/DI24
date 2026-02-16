package controlador;

import dao.CocheDAO;
import modelo.Coche;
import vista.Catalogo;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CatalogoController {
    private Catalogo vista;
    private CocheDAO dao;

    public CatalogoController(Catalogo vista) {
        this.vista = vista;
        this.dao = new CocheDAO();
        cargarCoches();
    }

    private void cargarCoches() {
        List<Coche> coches = dao.getCochesDisponibles();
        DefaultTableModel modelo = vista.getModelo();

        // Limpiar tabla antes de cargar
        modelo.setRowCount(0);

        for (Coche c : coches) {
            Object[] fila = {c.getId(), c.getMarca(), c.getModelo(), c.getPrecio()};
            modelo.addRow(fila);
        }
    }
}
