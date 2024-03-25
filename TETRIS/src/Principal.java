
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JoanMR
 */
public class Principal {
    
    JPanel panelBotones;
    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton boton4;
    JButton boton5;
    public static void main(String[] args){
    
        new Principal().metodoprincipal();
    }
    
    public void metodoprincipal(){
        //Declaracion de la ventana y el panel de contenidos
        JFrame ventana = new JFrame("PROYECTO FINAL 2023/2024");
        Container contenidos = ventana.getContentPane();
        contenidos.setLayout(new BorderLayout());
        
        //Creamos el panel de botones 
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5,1));
        contenidos.add(panelBotones,BorderLayout.WEST);
        
        //Creamos los botones, le damos color y lo añadimos al panel de botones
        boton1 = new JButton("NUEVA PARTIDA");
        boton2 = new JButton("CONFIGURACIÓN");
        boton3 = new JButton("HISTORIAL");
        boton4 = new JButton("INFORMACIÓN");
        boton5 = new JButton("SALIR");
        
        boton1.setBackground(Color.black);
        boton2.setBackground(Color.black);
        boton3.setBackground(Color.black);
        boton4.setBackground(Color.black);
        boton5.setBackground(Color.black);
        
        boton1.setForeground(Color.white);
        boton2.setForeground(Color.white);
        boton3.setForeground(Color.white);
        boton4.setForeground(Color.white);
        boton5.setForeground(Color.white);
        
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(boton4);
        panelBotones.add(boton5);
        
        //Creamos los separadores de la ventana
        JSplitPane separadorNorte = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorSur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorOeste = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        
        separadorOeste.add(panelBotones);
        contenidos.add(separadorOeste,BorderLayout.WEST);
        
        contenidos.add(separadorNorte, BorderLayout.NORTH);
        
        contenidos.add(separadorSur,BorderLayout.SOUTH);
        
        //Añado los menus
        
        
        
        
        
        //Detalles de la ventana
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
    
}
