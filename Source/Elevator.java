package Source;
public class Elevator extends Mechanism implements Loggable, Resettable {
    @Override
    public void reset() {
        setPosition(0);
    }

    public Elevator() {
        super("Elevator");
    }

    @Override
    public void setPosition(double position) {
        if (position >= 0 && position <= 2) {
            super.updatePosition(position);
        } else {
            System.out.println("ERROR! Please input a measurement in between zero (0) and two (2).");
        }
    }

    @Override
    public void printStatus(){
        System.out.println("Elevator is at " + position);
    }
}