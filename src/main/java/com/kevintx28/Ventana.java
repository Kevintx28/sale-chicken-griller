package com.kevintx28;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
/*
 * @author kevintx28!
 *
 */
public class Ventana extends JFrame implements ActionListener {
    JMenuBar menu_principal;
    JMenu accion_carta;
    JPanel panelFoot;
    JButton boton_opciones;

    public Ventana(){
    
        
        this.setTitle("Pollería");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension tamano_pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(tamano_pantalla.width-1500, tamano_pantalla.height-500));

        menu_principal = new JMenuBar();
        accion_carta = new JMenu("Carta");

        menu_principal.add(accion_carta);
        boton_opciones = new JButton("OPCIONES");

        panelFoot = new JPanel();

  

        boton_opciones.addActionListener(this);
        panelFoot.add(boton_opciones);

        this.getContentPane().add(BorderLayout.SOUTH, panelFoot);
        this.getContentPane().add(BorderLayout.NORTH, menu_principal);        
        this.setVisible(true);
    }


    @Override //decorador
    public void actionPerformed(ActionEvent evento) {

         if(evento.getSource() == boton_opciones) {
            System.out.println("Hola boton opciones seleccionado");
         }
    }
}
