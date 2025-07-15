import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Tablero {
    private int filas;
    private int columnas;
    SerVivo[][] tablero = new SerVivo[filas][columnas];

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public void initBoard (){
        Random random = new Random();
        for (int i = 0; i< tablero.length; i++){
            for (int j =0; j<tablero[i].length; j++){
                int al = random.nextInt(10);
                switch (al){
                    case 0 -> tablero[i][j] = new Cicuta();
                    case 1 -> tablero[i][j] = new Mimo();
                    case 2 -> tablero[i][j] = new Mima();
                    case 3 -> tablero[i][j] = new Manzanilla();
                    case 4 -> tablero[i][j] = new Kiwi();
                    default -> tablero[i][j] = null;
                }
            }
        }
    }

    public void printBoard(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.println((tablero[i][j] != null) ? tablero[i][j].emoji() : "[.]");
            }
            System.out.println();

        }
    }

    public synchronized boolean esPosicionValida(int x, int y) {
        return x >= 0 && y >= 0 && x < filas && y < columnas && tablero[x][y] == null;
    }

    public synchronized void moverAnimal(Animal animal, int nuevoX, int nuevoY) {
        tablero[animal.x][animal.y] = null;
        tablero[nuevoX][nuevoY] = animal;
    }

    public synchronized void eliminarAnimal(Animal animal) {
        tablero[animal.x][animal.y] = null;
    }

    public synchronized void eliminarPlanta(int x, int y) {
        tablero[x][y] = null;
    }

    public SerVivo getElemento(int x, int y) {
        return tablero[x][y];
    }


}
