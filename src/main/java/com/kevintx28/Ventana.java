package com.kevintx28;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Color;
import java.awt.GridLayout;
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
        Comida primer_comida = new Comida(); 
        primer_comida.modificarNombre("1/4 de pollo");
        primer_comida.insertarPrecio(10);
        primer_comida.insertarCodigo(111);

        Comida segunda_comida = new Comida(); 
        segunda_comida.modificarNombre("Pollo a la plancha con tosino");
        segunda_comida.insertarPrecio(40);
        segunda_comida.insertarCodigo(222);

        Comida tercera_comida = new Comida(); 
        tercera_comida.modificarNombre("1/2 de pollo");
        tercera_comida.insertarPrecio(40);
        tercera_comida.insertarCodigo(333);

        Comida cuarta_comida = new Comida(); 
        cuarta_comida.modificarNombre("1/8 de pollo");
        cuarta_comida.insertarPrecio(40);
        cuarta_comida.insertarCodigo(444);

        Comida[] carta =  {primer_comida, segunda_comida, tercera_comida, cuarta_comida} ;
            int tam_fila =  carta.length;
            int tam_col = 1;

       

         if(evento.getSource() == boton_opciones) {
            System.out.println("Hola boton opciones seleccionado");
         }
         
         if(evento.getSource() == item_carta) {
            JPanel panel_contenido = new JPanel();
            panel_contenido.setBackground(Color.GREEN);
            this.getContentPane().add(panel_contenido);     

           


            

            panel_contenido.setLayout(new GridLayout(tam_fila, tam_col));
            
            boton_casilla = new JButton[tam_fila][tam_col];
            for (int i = 0; i < tam_fila; i++) {
                for (int j = 0; j < tam_col; j++) {
                    boton_casilla[i][j] = new JButton(carta[i].recuperarNombre()+": "+ carta[i].recuperarPrecio() );
                    
                    boton_casilla[i][j].putClientProperty("id", carta[i].recuperarCodigo());
                    boton_casilla[i][j].addActionListener(this);
                    panel_contenido.add(boton_casilla[i][j]);        
                }   
            }

            
            
         }

         for (int i = 0; i < tam_fila; i++) {
            for (int j = 0; j < tam_col; j++) {
                if(evento.getSource() == boton_casilla[i][j]) {
                    int codigo_seleccionado = (int) boton_casilla[i][j].getClientProperty("id");   

                    for(int cc=0; cc<carta.length; cc++){
                        if(codigo_seleccionado == carta[cc].recuperarCodigo()) {
                            System.out.println(carta[cc].recuperarNombre());
                        }
                    }
                    
                    

                    
                 }
            }   
        }
    }
}
