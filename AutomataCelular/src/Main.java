import java.util.Random;

public class Main {
    private static final int FILAS = 10; // Número de filas en la cuadrícula
    private static final int COLUMNAS = 10; // Número de columnas en la cuadrícula

    public static void main(String[] args) {

        boolean[][] tablero = new boolean[FILAS][COLUMNAS];
        Tablero tab = new Tablero(FILAS, COLUMNAS);
        tab.initBoard(); //inicializarTablero(tablero);
        tab.printBoard();  //imprimirTablero(tablero);

        // Simular 10 generaciones
        //for (int i = 0; i < 10; i++) {
        //    System.out.println("\nGeneración " + (i + 1) + ":");
        //}
          //  tablero = calcularSiguienteGeneracion(tablero);
           // imprimirTablero(tablero);
        }
    private static void inicializarTablero(boolean[][] tablero) {
        Random random = new Random();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = random.nextBoolean(); // Célula viva o muerta aleatoriamente
            }
        }
    }

    private static void imprimirTablero(boolean[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] ? "O " : "\uD83D\uDC36" ); // "O" para vivas, "." para muertas
            }
            System.out.println();

        }
    }

    private static boolean[][] calcularSiguienteGeneracion(boolean[][] tablero) {
        boolean[][] nuevoTablero = new boolean[FILAS][COLUMNAS];

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                int vecinosVivos = contarVecinosVivos(tablero, i, j);

                // Aplicar las reglas del Juego de la Vida
                if (tablero[i][j]) {
                    // Regla 1 y 3: Muere por soledad o sobrepoblación
                    nuevoTablero[i][j] = vecinosVivos == 2 || vecinosVivos == 3;
                } else {
                    // Regla 4: Revive si tiene exactamente 3 vecinos vivos
                    nuevoTablero[i][j] = vecinosVivos == 3;
                }
            }
        }

        return nuevoTablero;
    }

    private static int contarVecinosVivos(boolean[][] tablero, int fila, int col) {
        int vivos = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue; // Ignorar la célula actual
                }

                int filaVecino = fila + i;
                int colVecino = col + j;

                // Verificar que el vecino esté dentro de los límites
                if (filaVecino >= 0 && filaVecino < FILAS && colVecino >= 0 && colVecino < COLUMNAS) {
                    if (tablero[filaVecino][colVecino]) {
                        vivos++;
                    }
                }
            }
        }
        return vivos;
    }
}