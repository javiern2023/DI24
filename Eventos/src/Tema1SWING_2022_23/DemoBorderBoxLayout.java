package Tema1SWING_2022_23;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class DemoBorderBoxLayout {
    //variables y comtenedores
    private JLabel etiquetaSu;
    private JPanel panelIzquierdo, panelDerecho, panelInferior;
    private JButton botonIz1, botonIz2, botonIz3;
    private JButton botonDe1, botonDe2, botonDe3;
    private JButton    botonIn1, botonIn2;
    private JScrollPane scroll;

    public void contruyePanelIzquierdo(){
        panelIzquierdo = new JPanel();
        botonIz1=new JButton("Izq1");
        botonIz2=new JButton("Izq2");
        botonIz3=new JButton("Izq3");
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo,BoxLayout.Y_AXIS));
        panelIzquierdo.setBackground(Color.red);
        panelIzquierdo.add(botonIz1);
        panelIzquierdo.add(botonIz2);
        panelIzquierdo.add(botonIz3);
    }

    public void contruyePanelDerecho(){
        panelDerecho = new JPanel();
        botonDe1=new JButton("Der1");
        botonDe2=new JButton("Der2");
        botonDe3=new JButton("Der3");
        panelDerecho.setLayout(new BoxLayout(panelDerecho,BoxLayout.Y_AXIS));
        panelDerecho.setBackground(Color.blue);
        panelDerecho.add(botonDe1);
        panelDerecho.add(botonDe2);
        panelDerecho.add(botonDe3);
    }

    public void contruyePanelInferior(){
        panelInferior = new JPanel();
        botonIn1=new JButton("Aceptar");
        botonIn2=new JButton("Cancelar");
        panelInferior.setLayout(new FlowLayout());
        panelInferior.setBackground(Color.green);
        panelInferior.add(botonIn1);
        panelInferior.add(botonIn2);
    }

    public void contruyeVentana(){
        JFrame frame = new JFrame();
        scroll = new JScrollPane(new JTextArea("JTextArea",10,15));
        etiquetaSu = new JLabel("Border Layout");
        Font aux=etiquetaSu.getFont();
        etiquetaSu.setFont(new Font(aux.getFontName(), aux.getStyle(), 20));
        frame.setLayout(new BorderLayout());

        //agregamos los paneles al frame principal
        frame.add(etiquetaSu,BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(panelIzquierdo,BorderLayout.WEST);
        frame.add(panelDerecho,BorderLayout.EAST);
        frame.add(panelInferior,BorderLayout.SOUTH);
        //Configuramos el frame
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public DemoBorderBoxLayout(){
        contruyePanelInferior();
        contruyePanelIzquierdo();
        contruyePanelDerecho();
        contruyeVentana();
    }

    public static void main (String [] Demo){
        new DemoBorderBoxLayout();
    }
}
