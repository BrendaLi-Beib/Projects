public interface SerVivo extends Runnable {
    void vivir();
    void interactuar(SerVivo serVivo);
    int getEnergy();
    String emoji();
}
