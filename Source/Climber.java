package Source;

public class Climber extends Mechanism implements Loggable {
    public Climber() {
        super("Climber");
    }

    @Override
    public void setPosition(double position) {
        if (position >= 0 && position <= 5) {
            super.updatePosition(position);
        } else {
            System.out.println("ERROR! Please input a measurement in between zero (0) and five (5).");
        }
    }

    public void extend() {
        setPosition(5);
    }

    public void retract() {
        setPosition(0);
    }

    @Override
    public void printStatus(){
        System.out.println("Climber is at " + position);
    }
}