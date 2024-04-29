/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JoanMR
 */

package tetrisb;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;



public class Nuevo_juego extends JFrame implements MouseMotionListener,MouseListener  {
    
    private boolean DESPLAZAMIENTO=false;
    private Tablero tablero;  
    //Este desfase es para pillar la imagen
    private static final int DESFASE_X=200,DESFASE_Y=200;
    private static final int COORDENADA_X_INICIAL=1000,COORDENADA_Y_INICIAL=300;
    
    public Nuevo_juego(){
        super("Juego jugable");
        inicializacion();
        setVisible(true);
        
    }
    
    private void inicializacion(){
        
        tablero = new Tablero();
        addMouseListener(this);
        addMouseMotionListener(this);
        //adición en el JFrame del tablero de casillas
        getContentPane().add(tablero);
        setSize(1500,1065);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    @Override
    public void mouseDragged(MouseEvent evento) {
        if (DESPLAZAMIENTO) {
            tablero.setCoordX(evento.getX());
            tablero.setCoordY(evento.getY());
            repaint();
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent evento) {
    }   
    
    @Override
    public void mouseClicked(MouseEvent evento) {}
    
    @Override
    public void mousePressed(MouseEvent evento) {  
        //obtención coordenadas cursor del ratón
        int x=evento.getX();                  
        int y=evento.getY(); 
        if ((!DESPLAZAMIENTO)&&(x+DESFASE_X>=COORDENADA_X_INICIAL)
                             &&(x+DESFASE_X<=COORDENADA_X_INICIAL+tablero.getDimensionCasilla())
                             &&(y+DESFASE_Y>=COORDENADA_Y_INICIAL)
                             &&(y+DESFASE_Y<=COORDENADA_Y_INICIAL+tablero.getDimensionCasilla())) {
            DESPLAZAMIENTO=true;
            tablero.setInsercion(false);
            tablero.setCoordX(COORDENADA_X_INICIAL);
            tablero.setCoordY(COORDENADA_Y_INICIAL);                
            repaint(); 
        }
        else {
            tablero.setCoordX(evento.getX());
            tablero.setCoordY(evento.getY()); 
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent evento) {
        if (DESPLAZAMIENTO) {
            //obtención coordenadas cursor del ratón
            int x=evento.getX();                  
            int y=evento.getY(); 
            DESPLAZAMIENTO=false;
            //Verifica si se encuentra en el interior del tablero
            if (x+tablero.getDesfaseX()<=tablero.getX(0, tablero.getNumCasillas()-1)+tablero.getDimensionCasilla()) {
                //bucle para identificar casilla del tablero sobre la que se ha soltado
                //el ratón y verificar si está libre o no para insertar o no la imagen
                for (int fila=0; fila <tablero.getNumCasillas(); fila++) {                     
                    for (int columna=0;columna<tablero.getNumCasillas();columna++) {                        
                        if ((x+tablero.getDesfaseX()>=tablero.getX(fila, columna))&&                   
                                (x+tablero.getDesfaseX()<=tablero.getX(fila, columna)+tablero.getDimensionCasilla())&&                
                                (y+tablero.getDesfaseY()>=tablero.getY(fila, columna))&&                
                                (y+tablero.getDesfaseY()<=tablero.getY(fila, columna)+tablero.getDimensionCasilla())) { 

                            //verificar si la casilla está ocupada o no
                            if (!tablero.getEstadoCasilla(fila, columna)) {
                                //actualizar casilla del tablero al ser ocupada
                                //por la imagen
                                tablero.cambiarEstadoCasilla(fila,columna);
                                tablero.cambiarImagenCasilla(fila, columna);
                                tablero.setInsercion(true);
                                tablero.seleccionAleatoriaImagen();
                            }
                        }                                                      
                    }   
                }
            } 
            tablero.setCoordX(COORDENADA_X_INICIAL);
            tablero.setCoordY(COORDENADA_Y_INICIAL);
            repaint();  
        }
    }

    @Override
    public void mouseEntered(MouseEvent evento) {}

    @Override
    public void mouseExited(MouseEvent evento) {}
    
    public static void main(String[] args) {
        Nuevo_juego taller = new Nuevo_juego();
    }

}
