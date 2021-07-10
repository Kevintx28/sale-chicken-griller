package com.kevintx28;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Label;
/*
 * @author kevintx28!
 *
 */
public class Ventana extends JFrame implements ActionListener {
    JMenuBar menu_principal;

    JMenu accion_cliente;
    JMenu accion_caja;
    // JMenu accion_pedido; //completar este menu para el cliente

    JMenuItem item_carta;


    
    JButton boton_opciones;


    JButton[][] boton_casilla;

    JScrollPane scrollPane = new JScrollPane();

    public Ventana() {
    
        
        this.setTitle("Pollería");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension tamano_pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(tamano_pantalla.width-1500, tamano_pantalla.height-500));
   
       // this.getContentPane().add(BorderLayout.SOUTH, pie_panel);
        
       iniciarPanelCabecera();
    }

    public void iniciarPanelCabecera() {

        menu_principal = new JMenuBar();

        accion_cliente = new JMenu("Cliente");
        
        item_carta = new JMenuItem("Carta");

        accion_cliente.add(item_carta);

        accion_caja = new JMenu("Caja");

        menu_principal.add(accion_cliente);
        menu_principal.add(accion_caja);
        boton_opciones = new JButton("OPCIONES");
  
        item_carta.addActionListener(this);
        boton_opciones.addActionListener(this);
       
        this.getContentPane().add(BorderLayout.NORTH, menu_principal);     
        

    }
    public void iniciarPanelContenido() {

    }


    @Override //decorador
    public void actionPerformed(ActionEvent evento) {

        Container contai=this.getContentPane();
        contai.remove(scrollPane);


         if(evento.getSource() == boton_opciones) {
            System.out.println("Hola boton opciones seleccionado");
         }
         
         if(evento.getSource() == item_carta) {
            JPanel panel_contenido = new JPanel();
            panel_contenido.setBackground(Color.GREEN);
            this.getContentPane().add(panel_contenido);     

            String[] lista =  {"1 pollo","1/2 pollo","1/4 pollo", "1/8 pollo", "Parrillas", "Pizza personal", "Coca cola 1L", "Coca cola 2L", "Helado personal", "Helado de S/. 5", "Pastel personal de frutas"} ;
            int tam_fila =  lista.length;
            int tam_col = 1;
            // contai.repaint();
            panel_contenido.setLayout(new GridLayout(tam_fila, tam_col));
         
           
            //Add panel_contenido to set up horizontal and vertical gaps

            
            

            boton_casilla = new JButton[tam_fila][tam_col];

            for (int i = 0; i < tam_fila; i++) {
                for (int j = 0; j < tam_col; j++) {
                    boton_casilla[i][j] = new JButton(lista[i]);
                    panel_contenido.add(boton_casilla[i][j]);        
                }   
            }
            
         }
    }
}
