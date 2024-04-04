
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

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
    JMenuItem boton11;
    JMenuItem boton21;
    JMenuItem boton31;
    JMenuItem boton41;
    JMenuItem boton51;
    JButton icono1;
    JButton icono2;
    JButton icono3;
    JButton icono4;
    JButton icono5;
    JPanel panelNorte;        
    panelImagen visualizador;
    JToolBar barraHerramientas;
    JMenuBar barraMenu;
    JMenu menu;
    boolean info;
    public static void main(String[] args){
    
        new Principal().metodoprincipal();
    }
    
    public void metodoprincipal(){
        //Declaracion de la ventana y el panel de contenidos
        JFrame ventana = new JFrame("PROYECTO FINAL 2023/2024");
        Container contenidos = ventana.getContentPane();
        contenidos.setLayout(new BorderLayout());
        
        //Añado la foto del menu principal
         visualizador= new panelImagen("TETRIS_UIB.jpg");
        contenidos.add(visualizador,BorderLayout.CENTER);
        
        //Creamos el panel de botones 
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5,1));
        contenidos.add(panelBotones,BorderLayout.WEST);
        
        //Creamos el panel que llevara los contenidos puestos en el norte
        panelNorte = new JPanel();
        panelNorte.setLayout(new BorderLayout());
        panelNorte.setBackground(Color.black);
        
        
        //Creamos los botones, le damos color y lo añadimos al panel de botones
        boton1 = new JButton("NUEVA PARTIDA");
        boton2 = new JButton("CONFIGURACIÓN");
        boton3 = new JButton("HISTORIAL");
        boton4 = new JButton("INFORMACION");
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
        
        boton1.addActionListener(new gestorEventos());
        boton2.addActionListener(new gestorEventos());
        boton3.addActionListener(new gestorEventos());
        boton4.addActionListener(new gestorEventos());
        boton5.addActionListener(new gestorEventos());
        
        
        
        
        //Añado los menus de arriba
        barraMenu = new JMenuBar();
        barraMenu.setBackground(Color.black);
        ventana.setJMenuBar(barraMenu);
        menu = new JMenu("MENÚ");
        menu.setForeground(Color.white);
        barraMenu.add(menu);
        
        boton11= new JMenuItem("NUEVA PARTIDA");
        boton21= new JMenuItem("CONFIGURACION");
        boton31= new JMenuItem("HISTORIAL");
        boton41= new JMenuItem("INFORMACION");
        boton51= new JMenuItem("SALIR");
        
        menu.add(boton11);
        menu.add(boton21);
        menu.add(boton31);
        menu.add(boton41);
        menu.add(boton51);
        
        boton11.setBackground(Color.black);
        boton21.setBackground(Color.black);
        boton31.setBackground(Color.black);
        boton41.setBackground(Color.black);
        boton51.setBackground(Color.black);
        
        boton11.setForeground(Color.white);
        boton21.setForeground(Color.white);
        boton31.setForeground(Color.white);
        boton41.setForeground(Color.white);
        boton51.setForeground(Color.white);
        
        boton11.addActionListener(new gestorEventos());
        boton21.addActionListener(new gestorEventos());
        boton31.addActionListener(new gestorEventos());
        boton41.addActionListener(new gestorEventos());
        boton51.addActionListener(new gestorEventos());
        
       
       //Añado el JToolBar 
        barraHerramientas= new JToolBar();
        barraHerramientas.setFloatable(false);
        barraHerramientas.setBackground(Color.black);
        
        
        icono1= new JButton(new ImageIcon("iconoNuevaPartida.jpg"));
        icono2= new JButton(new ImageIcon("iconoConfiguracion.jpg"));
        icono3= new JButton(new ImageIcon("iconoHistorial.jpg"));
        icono4= new JButton(new ImageIcon("iconoInformacion.jpg"));
        icono5= new JButton(new ImageIcon("iconoSalir.jpg"));
        
        barraHerramientas.add(icono1);
        barraHerramientas.add(icono2);
        barraHerramientas.add(icono3);
        barraHerramientas.add(icono4);
        barraHerramientas.add(icono5);
        
        icono1.setBackground(Color.black);
        icono2.setBackground(Color.black);
        icono3.setBackground(Color.black);
        icono4.setBackground(Color.black);
        icono5.setBackground(Color.black);
        
        icono1.addActionListener(new gestorEventos());
        icono2.addActionListener(new gestorEventos());
        icono3.addActionListener(new gestorEventos());
        icono4.addActionListener(new gestorEventos());
        icono5.addActionListener(new gestorEventos());
        
        panelNorte.add(barraHerramientas,BorderLayout.WEST);
        
        
        //Creamos los separadores de la ventana
        JSplitPane separadorNorte = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorSur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorOeste = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        
        
        
        separadorOeste.add(panelBotones);
        contenidos.add(separadorOeste,BorderLayout.WEST);
        
        separadorNorte.add(panelNorte);
        contenidos.add(separadorNorte, BorderLayout.NORTH);
        
        contenidos.add(separadorSur,BorderLayout.SOUTH);
        
        
        //Detalles de la ventana
        ventana.setResizable(false);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
    
    private class panelImagen extends JComponent {
        private BufferedImage imagen=null;

        public panelImagen(String nombre) {
            try {
                imagen = ImageIO.read(new File(nombre));
            } catch (IOException e) {
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            if(!info){
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(imagen,0,0,this);
             
            }else{
            
                g.setFont(new Font("Arial",Font.BOLD,10));
                    g.setColor(Color.black);
                    g.drawString("ESTA APLICACION HA SIDO REALIZADA EN EL CONTEXTO DE LA ASIGNATURA DE PROGRAMACION II \n"
                            + "DEL PRIMER CURSO DE LOS ESTUDIOS DE INGENIERIA INFORMATICA DE LA UNIVERSITAT DE LES \n"
                            + "ILLES BALEARS PARA EL CURSO ACADEMICO 2023-24. \n"
                            + "REPRESENTA LA PRACTICA QUE HAN DE REALIZAR LOS ESTUDIANTES DE LA ASIGNATURA MENCIONADA.\n"
                            + "LOS OBJETIVOS ESTA PRACTICA PASAN POR TRABAJR CON UN ENTORNO GRAFICO E INTERACTIVO \n"
                            + "UTILIZANDO LAS PRESENTACIONES QUE OFRECEN LAS LIBRERIAS GRAFICAS DE JAVA Y LA APLICACION \n"
                            + "DE LOS CONCEPTOS DE OBJETOS Y TIPOS DE DATOS ABSTRACTOS CORRESPONDIENTES A LA \n"
                            + "PROGRAMACION ORIENTADA A OBJETOS.",0,40);
            }
        }
        
        
        
        @Override
        public Dimension getPreferredSize() {
            if (imagen == null) {
                return new Dimension(200, 200);
            } else {
                return new Dimension(imagen.getWidth(), imagen.getHeight());
            }
        }

        
        
    } 
    
    private class gestorEventos implements ActionListener{
    
        @Override
        public void actionPerformed (ActionEvent evento){
        
            switch(evento.getActionCommand()){
            
                case "NUEVA PARTIDA":
                    JFrame nombre_juego = new JFrame("INTRODUCCION DE DATOS");
                    Container contenidos_nombre= nombre_juego.getContentPane();
                    contenidos_nombre.setLayout(new BorderLayout());
                    
                    JLabel etiqueta1 = new JLabel("NOMBRE JUGADOR    ");
                    etiqueta1.setOpaque(true);
                    etiqueta1.setBackground(Color.BLACK);
                    etiqueta1.setForeground(Color.white);
                    etiqueta1.setFont(new Font("Arial",Font.BOLD,20));
                    contenidos_nombre.add(etiqueta1,BorderLayout.WEST);
                    
                    JTextField texto_nombre= new JTextField(15);
                    contenidos_nombre.add(texto_nombre,BorderLayout.EAST);
                    
                    JButton confirmar = new JButton("CONFIRMAR");
                    contenidos_nombre.add(confirmar,BorderLayout.SOUTH);
                    
                    
                    
                    nombre_juego.setVisible(true);
                    nombre_juego.setResizable(false);
                    nombre_juego.setLocationRelativeTo(null);
                    nombre_juego.pack();
                    break;
                case "CONFIGURACION":
                    break;
                case "HISTORIAL":
                    break;
                case "INFORMACION":
                    info= true;
                    visualizador.repaint();
                    break;
                case "SALIR":
                    System.exit(0);
                    break;
                
            }
            if(evento.getSource()==icono1){
            
                JFrame nombre_juego = new JFrame("INTRODUCCION DE DATOS");
                    Container contenidos_nombre= nombre_juego.getContentPane();
                    contenidos_nombre.setLayout(new BorderLayout());
                    
                    JLabel etiqueta1 = new JLabel("NOMBRE JUGADOR    ");
                    etiqueta1.setOpaque(true);
                    etiqueta1.setBackground(Color.BLACK);
                    etiqueta1.setForeground(Color.white);
                    etiqueta1.setFont(new Font("Arial",Font.BOLD,20));
                    contenidos_nombre.add(etiqueta1,BorderLayout.WEST);
                    
                    JTextField texto_nombre= new JTextField(15);
                    contenidos_nombre.add(texto_nombre,BorderLayout.EAST);
                    
                    JButton confirmar = new JButton("CONFIRMAR");
                    contenidos_nombre.add(confirmar,BorderLayout.SOUTH);
                    
                    
                    
                    nombre_juego.setVisible(true);
                    nombre_juego.setResizable(false);
                    nombre_juego.setLocationRelativeTo(null);
                    nombre_juego.pack();
            }
            if(evento.getSource()==icono2){
            
                
            }
            if(evento.getSource()==icono3){
            
                
            }
            if(evento.getSource()==icono4){
            
                info= true;
                visualizador.repaint();
            }
            if(evento.getSource()==icono5){
            
                System.exit(0);
            }
            
            
        }
    }
}
    

