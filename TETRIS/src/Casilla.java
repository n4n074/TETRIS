/*
 * CLASE Casilla

realización: Juan Montes de Oca
*/

package Principal;

class Casilla {
    //DECLARACIÓN DE ATRIBUTOS
    private boolean ocupada;
    int x,y;

    //MÉTODOS CONSTRUCTORES
    public Casilla() {
        ocupada=false;
    }

    public Casilla(int x,int y) {
        ocupada=false;
        this.x=x;
        this.y=y;
    }

    //MÉTODO QUE LIBERA UNA CASILLA
    public void setLiberada() {
        ocupada=false;
    }

    //MÉTODO QUE DEVUELVE EL ESTADO DE UNA CASILLA
    public boolean estado() {
        return ocupada;
    }

    //MÉTODO QUE CAMBIA EL ESTADO A OCUPADA DE UNA CASILLA
    public void setOcupada() {
        ocupada=true;
    }

    //MÉTODO QUE CAMCIA EL ESTADO DE UNA CASILLA
    public void cambiarEstado() {
        ocupada=!ocupada;
    }

    //MÉTODO DE MODIFICA LA COORDENADA X DE UNA CASILLA
    public void setX(int x) {
        this.x=x;
    }

    //MÉTODO DE MODIFICA LA COORDENADA Y DE UNA CASILLA
    public void setY(int y) {
        this.y=y;
    }

    //MÉTODO DE DA ACCESO A LA COORDENADA X DE UNA CASILLA
    public int getX() {
        return x;
    }

    //MÉTODO DE DA ACCESO A LA COORDENADA Y DE UNA CASILLA
    public int getY() {
        return y;
    }

}
