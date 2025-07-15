public class Mimo extends Animal {
    int power = 3;
    @Override
    public void fight(Animal animal) {

    }
    @Override
    public void interact(SerVivo serVivo) {
        if (serVivo instanceof Mimo){
            fight(Animal.class.cast(serVivo));
        }
    }

    @Override
    public void breed() {

    }

    @Override
    public String emoji() {
        return "\uD83D\uDC3B";
    }
}