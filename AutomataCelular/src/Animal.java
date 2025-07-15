public abstract class Animal {
    int energy = 5;
    int vida = 10;


    public void mover() {
        int nuevoX = x + (Math.random() < 0.5 ? -1 : 1);
        int nuevoY = y + (Math.random() < 0.5 ? -1 : 1);
        // Validar que no salga del tablero
        if (tablero.esPosicionValida(nuevoX, nuevoY)) {
            tablero.moverAnimal(this, nuevoX, nuevoY);
            this.x = nuevoX;
            this.y = nuevoY;
        }
    }



}
