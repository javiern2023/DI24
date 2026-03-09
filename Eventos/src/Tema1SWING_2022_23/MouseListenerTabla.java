package Tema1SWING_2022_23;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
import javax.swing.JTable;
 
public class MouseListenerTabla extends MouseAdapter {
     
    private JTable table;
     
    public MouseListenerTabla(JTable table) {
        this.table = table;
    }
     
    @Override
    public void mousePressed(MouseEvent event) {
        // Selecciona la fila en la que se hace click con el rat�n
    	//Coordenadas x e y con la clase 'Point'
        Point point = event.getPoint();
        int filaActual = table.rowAtPoint(point);
        table.setRowSelectionInterval(filaActual, filaActual);
    }
}
