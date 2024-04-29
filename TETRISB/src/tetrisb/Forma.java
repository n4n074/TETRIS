/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetrisb;

import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author JoanMR
 */
public class Forma {
    private static Image textura = Toolkit.getDefaultToolkit().getImage("CHOCOLATE.jpg");
     private static Image imagenLibre = Toolkit.getDefaultToolkit().getImage("LIBRE.jpg");
     Image [][] forma = new Image[3][3];
    public Forma(){

    generarForma();
    }
    private void generarForma(){

        
        for(int fila =0;fila<3;fila++){
        
            for(int columna=0;columna<3;columna++){
            
                Random generador = new Random();
                int indice = generador.nextInt(2);
                if(indice==1){
                forma[fila][columna] = textura;
                }else{
                forma[fila][columna]=imagenLibre;
                }
            }
        }
    }
    /*
        public static void main(String[] args) {
        Nuevo_juego taller = new Nuevo_juego();
        JFrame ventana = new JFrame("Prueba");
        Container contenidos = ventana.getContentPane();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel ver = new JLabel(new Image(forma));
        contenidos.add(forma);
    }
    */

    /*
    * El error "Non-static field 'forma' cannot be referenced from a static context" se produce porque estás intentando
    * acceder a la variable de instancia forma desde un método estático (main). En Java, los métodos estáticos pertenecen
    * a la clase, no a una instancia de la clase. Por lo tanto, no pueden acceder directamente a las variables de instancia
    * o a los métodos no estáticos.  Para solucionar este problema, puedes crear una instancia de la clase Forma en tu método
    * main y luego acceder a la variable forma a través de esa instancia. Aquí te dejo un ejemplo de cómo podrías hacerlo:
    *
    * Por favor, ten en cuenta que JLabel necesita un ImageIcon, no un Image, por lo que he convertido la imagen a ImageIcon
    * en el código anterior. Además, he asumido que quieres mostrar la primera imagen de la matriz forma, si quieres mostrar
    * otra imagen, cambia los índices correspondientemente.
    */

    public static void main(String[] args) {
    Forma formaInstance = new Forma();
    Image[][] forma = formaInstance.forma;

    Nuevo_juego taller = new Nuevo_juego();
    JFrame ventana = new JFrame("Prueba");
    Container contenidos = ventana.getContentPane();
    ventana.setVisible(true);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel ver = new JLabel(new ImageIcon(forma[0][0])); // Aquí necesitas convertir la imagen a ImageIcon
    contenidos.add(ver);
}
}

