package tetrisb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.*;
import javax.swing.border.Border;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author JoanMR
 */
public class Principal {
    
    JFrame ventana = new JFrame("PROYECTO FINAL 2023/2024");
    Container contenidos = ventana.getContentPane();
    
    JTextArea infor;
    JPanel panelBotones;
    JButton botonNuevaPartida;
    JButton botonConfiguracion;
    JButton botonHistorial;
    JButton botonInformacion;
    JButton botonSalir;
    JMenuItem botonMenuNuevaPartida;
    JMenuItem botonMenuConfiguracion;
    JMenuItem botonMenuHistorial;
    JMenuItem botonMenuInformacion;
    JMenuItem botonMenuSalir;
    JButton iconoNuevaPartida;
    JButton iconoConfiguracion;
    JButton iconoHistorial;
    JButton iconoInformacion;
    JButton iconoSalir;
    JPanel panelNorte;
    panelImagen visualizador;
    JToolBar barraHerramientas;
    JMenuBar barraMenu;
    JMenu menu;
    boolean info;

    public static void main(String[] args) {

        new Principal().metodoprincipal();
    }

    public void metodoprincipal() {
        //Declaracion de la ventana y el panel de contenidos
        
        contenidos.setLayout(new BorderLayout());
        
        //
        

        //Añado la foto del menu principal
        visualizador = new panelImagen("TETRIS_UIB.jpg");
        contenidos.add(visualizador, BorderLayout.CENTER);

        //Creamos el panel de botones 
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 1));
        contenidos.add(panelBotones, BorderLayout.WEST);

        //Creamos el panel que llevara los contenidos puestos en el norte
        panelNorte = new JPanel();
        panelNorte.setLayout(new BorderLayout());
        panelNorte.setBackground(Color.black);


        //Creamos los botones, le damos color y lo añadimos al panel de botones
        botonNuevaPartida = new JButton("NUEVA PARTIDA");
        botonConfiguracion = new JButton("CONFIGURACION");
        botonHistorial = new JButton("HISTORIAL");
        botonInformacion = new JButton("INFORMACION");
        botonSalir = new JButton("SALIR");

        botonNuevaPartida.setBackground(Color.black);
        botonConfiguracion.setBackground(Color.black);
        botonHistorial.setBackground(Color.black);
        botonInformacion.setBackground(Color.black);
        botonSalir.setBackground(Color.black);

        botonNuevaPartida.setForeground(Color.white);
        botonConfiguracion.setForeground(Color.white);
        botonHistorial.setForeground(Color.white);
        botonInformacion.setForeground(Color.white);
        botonSalir.setForeground(Color.white);

        panelBotones.add(botonNuevaPartida);
        panelBotones.add(botonConfiguracion);
        panelBotones.add(botonHistorial);
        panelBotones.add(botonInformacion);
        panelBotones.add(botonSalir);

        botonNuevaPartida.addActionListener(new gestorEventos());
        botonConfiguracion.addActionListener(new gestorEventos());
        botonHistorial.addActionListener(new gestorEventos());
        botonInformacion.addActionListener(new gestorEventos());
        botonSalir.addActionListener(new gestorEventos());


        ///////////////////////////////////////////////////////////////////
        ////////////////////////// MENU SUPERIOR //////////////////////////
        ///////////////////////////////////////////////////////////////////
        //Añado los menus de arriba
        barraMenu = new JMenuBar();
        barraMenu.setBackground(Color.black);
        ventana.setJMenuBar(barraMenu);
        menu = new JMenu("MENÚ");
        menu.setForeground(Color.white);
        barraMenu.add(menu);

        botonMenuNuevaPartida = new JMenuItem("NUEVA PARTIDA");
        botonMenuConfiguracion = new JMenuItem("CONFIGURACION");
        botonMenuHistorial = new JMenuItem("HISTORIAL");
        botonMenuInformacion = new JMenuItem("INFORMACION");
        botonMenuSalir = new JMenuItem("SALIR");

        menu.add(botonMenuNuevaPartida);
        menu.add(botonMenuConfiguracion);
        menu.add(botonMenuHistorial);
        menu.add(botonMenuInformacion);
        menu.add(botonMenuSalir);

        botonMenuNuevaPartida.setBackground(Color.black);
        botonMenuConfiguracion.setBackground(Color.black);
        botonMenuHistorial.setBackground(Color.black);
        botonMenuInformacion.setBackground(Color.black);
        botonMenuSalir.setBackground(Color.black);

        botonMenuNuevaPartida.setForeground(Color.white);
        botonMenuConfiguracion.setForeground(Color.white);
        botonMenuHistorial.setForeground(Color.white);
        botonMenuInformacion.setForeground(Color.white);
        botonMenuSalir.setForeground(Color.white);

        botonMenuNuevaPartida.addActionListener(new gestorEventos());
        botonMenuConfiguracion.addActionListener(new gestorEventos());
        botonMenuHistorial.addActionListener(new gestorEventos());
        botonMenuInformacion.addActionListener(new gestorEventos());
        botonMenuSalir.addActionListener(new gestorEventos());


        //Añado el JToolBar
        barraHerramientas = new JToolBar();
        barraHerramientas.setFloatable(false);
        barraHerramientas.setBackground(Color.black);


        iconoNuevaPartida = new JButton(new ImageIcon("iconoNuevaPartida.jpg"));
        iconoConfiguracion = new JButton(new ImageIcon("iconoConfiguracion.jpg"));
        iconoHistorial = new JButton(new ImageIcon("iconoHistorial.jpg"));
        iconoInformacion = new JButton(new ImageIcon("iconoInformacion.jpg"));
        iconoSalir = new JButton(new ImageIcon("iconoSalir.jpg"));

        barraHerramientas.add(iconoNuevaPartida);
        barraHerramientas.add(iconoConfiguracion);
        barraHerramientas.add(iconoHistorial);
        barraHerramientas.add(iconoInformacion);
        barraHerramientas.add(iconoSalir);

        iconoNuevaPartida.setBackground(Color.black);
        iconoConfiguracion.setBackground(Color.black);
        iconoHistorial.setBackground(Color.black);
        iconoInformacion.setBackground(Color.black);
        iconoSalir.setBackground(Color.black);

        iconoNuevaPartida.addActionListener(new gestorEventos());
        iconoConfiguracion.addActionListener(new gestorEventos());
        iconoHistorial.addActionListener(new gestorEventos());
        iconoInformacion.addActionListener(new gestorEventos());
        iconoSalir.addActionListener(new gestorEventos());

        panelNorte.add(barraHerramientas, BorderLayout.WEST);


        ///////////////////////////////////////////////////////////////////
        ////////////////////////// SEPARADORES ////////////////////////////
        ///////////////////////////////////////////////////////////////////
        //Creamos los separadores de la ventana
        JSplitPane separadorNorte = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorSur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorOeste = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);


        separadorOeste.add(panelBotones);
        contenidos.add(separadorOeste, BorderLayout.WEST);

        separadorNorte.add(panelNorte);
        contenidos.add(separadorNorte, BorderLayout.NORTH);

        contenidos.add(separadorSur, BorderLayout.SOUTH);


        ///////////////////////////////////////////////////////////////////
        //////////////////////////// VENTANA //////////////////////////////
        ///////////////////////////////////////////////////////////////////
        //Detalles de la ventana
        ventana.setResizable(false);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

    }

    private class panelImagen extends JComponent {
        private BufferedImage imagen = null;

        public panelImagen(String nombre) {
            try {
                imagen = ImageIO.read(new File(nombre));
            } catch (IOException e) {
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            if (!info) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(imagen, 0, 0, this);

            } else {
                
                
                String texto="ESTA APLICACION HA SIDO REALIZADA EN EL CONTEXTO DE LA ASIGNATURA DE PROGRAMACION II \n"
                        + "DEL PRIMER CURSO DE LOS ESTUDIOS DE INGENIERIA INFORMATICA DE LA UNIVERSITAT DE LES \n"
                        + "ILLES BALEARS PARA EL CURSO ACADEMICO 2023-24. \n"
                        + "REPRESENTA LA PRACTICA QUE HAN DE REALIZAR LOS ESTUDIANTES DE LA ASIGNATURA MENCIONADA.\n"
                        + "LOS OBJETIVOS ESTA PRACTICA PASAN POR TRABAJR CON UN ENTORNO GRAFICO E INTERACTIVO \n"
                        + "UTILIZANDO LAS PRESENTACIONES QUE OFRECEN LAS LIBRERIAS GRAFICAS DE JAVA Y LA APLICACION \n"
                        + "DE LOS CONCEPTOS DE OBJETOS Y TIPOS DE DATOS ABSTRACTOS CORRESPONDIENTES A LA \n"
                        + "PROGRAMACION ORIENTADA A OBJETOS.";
                infor= new JTextArea(texto,10,15);
                infor.setBounds(10,10,300,300);
                infor.setEditable(false);
                infor.setBackground(Color.black);
                
                
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

    private class gestorEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {

            switch (evento.getActionCommand()) {

                case "NUEVA PARTIDA":
                    JFrame nombre_juego = new JFrame("INTRODUCCION DE DATOS");
                    Container contenidos_nombre = nombre_juego.getContentPane();
                    contenidos_nombre.setLayout(new BorderLayout());

                    JLabel etiqueta1 = new JLabel("NOMBRE JUGADOR    ");
                    etiqueta1.setOpaque(true);
                    etiqueta1.setBackground(Color.BLACK);
                    etiqueta1.setForeground(Color.white);
                    etiqueta1.setFont(new Font("Arial", Font.BOLD, 20));
                    contenidos_nombre.add(etiqueta1, BorderLayout.WEST);

                    JTextField texto_nombre = new JTextField(15);
                    contenidos_nombre.add(texto_nombre, BorderLayout.EAST);

                    JButton confirmar = new JButton("CONFIRMAR");
                    contenidos_nombre.add(confirmar, BorderLayout.SOUTH);
                    
                    info=false;
                    visualizador.repaint();
                    
                    nombre_juego.setVisible(true);
                    nombre_juego.setResizable(false);
                    nombre_juego.setLocationRelativeTo(null);
                    nombre_juego.pack();
                    break;
                case "CONFIGURACION":
                    final JFrame configuracion_partida = new JFrame("CONFIGURACION DE LA PARTIDA");
                    Container contenidos_configuracion = configuracion_partida.getContentPane();
                    contenidos_configuracion.setLayout(new BorderLayout());

                    // Crear un nuevo JPanel con un GridLayout.
                    JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // 1 fila, 3 columnas, 10 pixels de espacio horizontal y vertical
                    buttonPanel.setBackground(Color.BLACK);

                    // Crear los botones.
                    JButton botonConfiguracionEspecifica = new JButton("CONFIGURACIÓN ESPECIFICA JUEGO");
                    JButton botonModificarTiempo = new JButton("MODIFCAR TIEMPO PARTIDA");
                    JButton botonNada = new JButton("NADA");

                    // Añadir un ActionListener al botón "NADA" para cerrar la ventana emergente.
                    botonNada.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            configuracion_partida.dispose();
                        }
                    });

                    // Añadir los botones al panel.
                    buttonPanel.add(botonConfiguracionEspecifica);
                    buttonPanel.add(botonModificarTiempo);
                    buttonPanel.add(botonNada);

                    // Añadir un margen alrededor del panel de botones.
                    buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 10 pixels de margen en todos los lados
                    configuracion_partida.add(buttonPanel, BorderLayout.SOUTH);

                    // Crear el icono y la etiqueta.
                    ImageIcon icono = new ImageIcon("iconoInformacion.jpg"); // Asegúrate de que esta ruta de archivo es correcta.
                    JLabel etiquetaConIcono = new JLabel(" ¿ QUÉ DESEAS REALIZAR ? ", icono, JLabel.LEFT);

                    etiquetaConIcono.setOpaque(true);
                    etiquetaConIcono.setBackground(Color.BLACK);
                    etiquetaConIcono.setForeground(Color.YELLOW);
                    etiquetaConIcono.setFont(new Font("Arial", Font.BOLD, 14));
                    contenidos_configuracion.add(etiquetaConIcono, BorderLayout.NORTH);
                    
                    info= false;
                    visualizador.repaint();
                    configuracion_partida.setVisible(true);
                    configuracion_partida.setResizable(false);
                    configuracion_partida.setLocationRelativeTo(null);
                    configuracion_partida.pack();

                    break;
                case "HISTORIAL":
                    break;
                case "INFORMACION":
                    info = true;
                    visualizador.repaint();
                    break;
                case "SALIR":
                    System.exit(0);
                    break;

            }
            if (evento.getSource() == iconoNuevaPartida) {

                JFrame nombre_juego = new JFrame("INTRODUCCION DE DATOS");
                Container contenidos_nombre = nombre_juego.getContentPane();
                contenidos_nombre.setLayout(new BorderLayout());

                JLabel etiqueta1 = new JLabel("NOMBRE JUGADOR    ");
                etiqueta1.setOpaque(true);
                etiqueta1.setBackground(Color.BLACK);
                etiqueta1.setForeground(Color.white);
                etiqueta1.setFont(new Font("Arial", Font.BOLD, 20));
                contenidos_nombre.add(etiqueta1, BorderLayout.WEST);

                JTextField texto_nombre = new JTextField(15);
                contenidos_nombre.add(texto_nombre, BorderLayout.EAST);

                JButton confirmar = new JButton("CONFIRMAR");
                contenidos_nombre.add(confirmar, BorderLayout.SOUTH);


                nombre_juego.setVisible(true);
                nombre_juego.setResizable(false);
                nombre_juego.setLocationRelativeTo(null);
                nombre_juego.pack();
            }
            if (evento.getSource() == iconoConfiguracion) {


            }
            if (evento.getSource() == iconoHistorial) {


            }
            if (evento.getSource() == iconoInformacion) {

                info = true;
                visualizador.repaint();
            }
            if (evento.getSource() == iconoSalir) {

                System.exit(0);
            }


        }
    }
}
    

