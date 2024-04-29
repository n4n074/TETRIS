package tetrisb;

/*
CLASE Tablero de casillas

realización: Juan Montes de Oca
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JComponent {

    //DECLARACIÓN DE ATRIBUTOS
    private static final int NUMCASILLAS = 20;
    private static final int DIMCASILLA = 30;
    //Deteccion del cambio de casillas
    private static final int DESFASE_X = 0, DESFASE_Y = 0;
    //Este desfase es donde se me coloca la imagen
    private static final int DESFASE_CURSOR_X = -30, DESFASE_CURSOR_Y = -30;
    private static final Color NEGRO = new Color(0, 0, 0);
    private static Image imagenNoOcupada = Toolkit.getDefaultToolkit().getImage("NO_OCUPADA_" + DIMCASILLA + ".jpg");
    private static Image imagenOcupada = Toolkit.getDefaultToolkit().getImage("OCUPADA_" + DIMCASILLA + ".jpg");
    private static Image imagenLibre = Toolkit.getDefaultToolkit().getImage("LIBRE_" + DIMCASILLA + ".jpg");
    private static final Image imagenes = (Toolkit.getDefaultToolkit().getImage("CHOCOLATE.jpg"));

    private Image imagen = imagenes;

    private Casilla[][] casillas = new Casilla[NUMCASILLAS][NUMCASILLAS];
    private int coordX = 1000, coordY = 300;
    private boolean INSERCION = false;

    //MÉTODO CONSTRUCTOR
    public Tablero() {
        for (int fila = 0; fila < NUMCASILLAS; fila++) {
            int x = 30;
            int y = fila * DIMCASILLA+30;
            for (int columna = 0; columna < NUMCASILLAS; columna++) {
                casillas[fila][columna] = new Casilla(x, y, null, "SIN_IMAGEN");
                x = x + DIMCASILLA;
            }
        }
    }

    //MÉTODO paintComponent asociada al objeto Tablero
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //visualización de la imagen de todas las casillas del tablero y de la casilla en la que
        //el cursor del ratón está
        for (int fila = 0; fila < NUMCASILLAS; fila++) {
            for (int columna = 0; columna < NUMCASILLAS; columna++) {
                if (casillas[fila][columna].estado()) {
                    if (((coordX + DESFASE_X >= casillas[fila][columna].getX()) && (coordX + DESFASE_X <= casillas[fila][columna].getX() + 30)
                            && (coordY + DESFASE_Y >= casillas[fila][columna].getY()) && (coordY + DESFASE_Y <= casillas[fila][columna].getY() + 30)) && (!INSERCION)) {
                        g2.drawImage(imagenOcupada, (int) casillas[fila][columna].getX(), (int) casillas[fila][columna].getY(), this);
                    } else {
                        g2.drawImage(casillas[fila][columna].getImagen(), (int) casillas[fila][columna].getX(), (int) casillas[fila][columna].getY(), this);
                    }
                } else {
                    if (((coordX + DESFASE_X >= casillas[fila][columna].getX()) && (coordX + DESFASE_X <= casillas[fila][columna].getX() + 30)
                            && (coordY + DESFASE_Y >= casillas[fila][columna].getY()) && (coordY + DESFASE_Y <= casillas[fila][columna].getY() + 30)) && (!INSERCION)) {
                        g2.drawImage(imagenLibre, (int) casillas[fila][columna].getX(), (int) casillas[fila][columna].getY(), this);
                    } else {
                        g2.drawImage(imagenNoOcupada, (int) casillas[fila][columna].getX(), (int) casillas[fila][columna].getY(), this);
                    }
                }
            }
        }
        //dibujo de las lineas del tablero
        g2.setColor(NEGRO);
        for (int fila = 0; fila < NUMCASILLAS; fila++) {
            g2.drawLine(30, (int) casillas[fila][0].getY(),
                     630, (int) casillas[fila][0].getY());
        }
        g2.drawLine((int) 30, (int) casillas[NUMCASILLAS - 1][0].getY() + DIMCASILLA,
                 630, (int) casillas[NUMCASILLAS - 1][0].getY() + DIMCASILLA);

        for (int columna = 0; columna < NUMCASILLAS; columna++) {
            g2.drawLine((int) casillas[0][columna].getX(), 30,
                     (int) casillas[0][columna].getX(), 630);
        }
        g2.drawLine((int) casillas[0][NUMCASILLAS - 1].getX() + DIMCASILLA, 30,
                 (int) casillas[0][NUMCASILLAS - 1].getX() + DIMCASILLA, 630);

        //Visualización imagen a colocar
        g2.drawImage(imagen, coordX , coordY , this);

    }

    //Método de acceso a la coordenada X de la casilla correspondiente a la fila y
    //columna dadas por parámetro
    public int getX(int fila, int columna) {
        return (int) casillas[fila][columna].getX();
    }

    //Método de acceso a la coordenada Y de la casilla correspondiente a la fila y
    //columna dadas por parámetro    
    public int getY(int fila, int columna) {
        return (int) casillas[fila][columna].getY();
    }

    //cambiar el atrubuto imagen
    public void setImagen(Image valor) {
        imagen = valor;
    }

    //obtener el atributo imagen
    public Image getImagen() {
        return imagen;
    }

    //selección imagen aleatoria
    public void seleccionAleatoriaImagen() {
        Random generador = new Random();
        int indice = generador.nextInt(8);
        imagen = imagenes;
    }

    //Método de acceso al número de filas o columnas del tablero   
    public int getNumCasillas() {
        return NUMCASILLAS;
    }

    //Método que cambia el estado de la casilla correspondiente a la fila y
    //columna dadas por parámetro    
    public void cambiarEstadoCasilla(int fila, int columna) {
        casillas[fila][columna].cambiarEstado();
    }

    public void cambiarImagenCasilla(int fila, int columna) {
        casillas[fila][columna].setImagen(imagen);
    }

    //Método que devuelve el estado de la casilla correspondiente a la fila y
    //columna dadas por parámetro    
    public boolean getEstadoCasilla(int fila, int columna) {
        return casillas[fila][columna].estado();
    }

    //Método que libera a todas las casillas del tablero.
    public void borrar() {
        for (int fila = 0; fila < NUMCASILLAS; fila++) {
            for (int columna = 0; columna < NUMCASILLAS; columna++) {
                casillas[fila][columna].setLiberada();
            }
        }
    }

    //obtener desfase en accisas
    public int getDesfaseX() {
        return DESFASE_X;
    }

    //obtener desfase en ordenadas
    public int getDesfaseY() {
        return DESFASE_Y;
    }

    //obtener dimensión casillas dek tablero
    public int getDimensionCasilla() {
        return DIMCASILLA;
    }

    //obtener coordenada X
    public int getCoordX() {
        return coordX;
    }

    //modificar coordenada X
    public void setCoordX(int valor) {
        coordX = valor;
    }

    //obtener coordenada Y
    public int getCoordY() {
        return coordY;
    }

    //modificar coordenada Y
    public void setCoordY(int valor) {
        coordY = valor;
    }

    //modificar estado INSERCION
    public void setInsercion(boolean valor) {
        INSERCION = valor;
    }
}
