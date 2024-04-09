/*
CLASE Tablero de casillas

realización: Juan Montes de Oca
*/

package Principal;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Tablero extends JPanel {
    //DECLARACIÓN DE ATRIBUTOS
    private static final int NUMCASILLAS=50;
    private static final Color BLANCO = Color.WHITE;
    private static final Color NEGRO = Color.BLACK;
    private Casilla [][] casillas=new Casilla[NUMCASILLAS][NUMCASILLAS];

    //MÉTODO CONSTRUCTOR
    public Tablero() {
        for (int fila=0; fila <NUMCASILLAS; fila++) {
            int x=0;
            int y=fila*20;
            for (int columna=0;columna<NUMCASILLAS;columna++) {
                casillas[fila][columna]=new Casilla(x,y);
                x=x+20;
            }
        }
    }

    //MÉTODO QUE DEVUELVE EL TAMAÑO QUE DEBERÍA TENER EL TABLERO PARA UNA VISUALIZACIÓN
    //TOTAL DE SUS COMPONENTES
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(990, 990);
    }

    //MÉTODO Paint
    @Override
    public void paintComponent(Graphics g) {
        //declaración objeto Graphics2D
        Graphics2D g2=(Graphics2D) g;
        //dibujo de todas las casillas del tablero
        for (int fila=0; fila <NUMCASILLAS; fila++) {
            for (int columna=0;columna<NUMCASILLAS;columna++) {
                if (casillas[fila][columna].estado()) {
                    g2.setColor(NEGRO);
                }
                else {
                    g2.setColor(BLANCO);
                }
                g2.fillRect((int)casillas[fila][columna].getX(),
                        (int)casillas[fila][columna].getY(),
                        (int)casillas[fila][columna].getX()+20,
                        (int)casillas[fila][columna].getY()+20);
            }
        }

        g2.setColor(NEGRO);
        for (int fila=0; fila <NUMCASILLAS; fila++) {
            g2.drawLine(0, (int)casillas[fila][0].getY()
                    ,1000, (int)casillas[fila][0].getY());
        }
        g2.drawLine((int)0, (int)casillas[NUMCASILLAS-1][0].getY()+20
                ,1000, (int)casillas[NUMCASILLAS-1][0].getY()+20);

        for (int columna=0;columna<NUMCASILLAS;columna++) {
            g2.drawLine((int)casillas[0][columna].getX(), 0
                    ,(int)casillas[0][columna].getX(), 1000);
        }
        g2.drawLine((int)casillas[0][NUMCASILLAS-1].getX()+20, 0
                , (int)casillas[0][NUMCASILLAS-1].getX()+20,1000);

    }

    //Método de acceso a la coordenada X de la casilla correspondiente a la fila y
    //columna dadas por parámetro
    public int getX(int fila,int columna) {
        return (int) casillas[fila][columna].getX();
    }

    //Método de acceso a la coordenada Y de la casilla correspondiente a la fila y
    //columna dadas por parámetro
    public int getY(int fila,int columna) {
        return (int) casillas[fila][columna].getY();
    }

    //Método de acceso al número de filas o columnas del tablero
    public int getNumCasillas() {
        return NUMCASILLAS;
    }
    //Método que cambia el estado de la casilla correspondiente a la fila y
    //columna dadas por parámetro
    public void cambiarEstadoCasilla(int fila,int columna) {
        casillas[fila][columna].cambiarEstado();
    }

    //Método que devuelve el estado de la casilla correspondiente a la fila y
    //columna dadas por parámetro
    public boolean getEstadoCasilla(int fila,int columna) {
        return casillas[fila][columna].estado();
    }

    //Método que libera a todas las casillas del tablero.
    public void borrar() {
        for (int fila=0; fila <NUMCASILLAS; fila++) {
            for (int columna=0;columna<NUMCASILLAS;columna++) {
                casillas[fila][columna].setLiberada();
            }
        }
    }


}
