package Source;
// GUIDED IN CLASS: Use this starter to demonstrate extends, super, and @Override.
public class Arm extends Mechanism implements Loggable{
    public Arm() {
        super("Arm");
    }

    // TODO (together): Override setPosition(double position).
    @Override
    public void setPosition(double position) {
        if (position >= 0 && position <= 180) {
            super.updatePosition(position);
        } else {
            System.out.println("ERROR! Please input an angle in between zero (0) and 180.");
        }
    }

    @Override 
    public void printStatus(){
        System.out.println("Arm is at " + position);
    }
    // Arm angles must stay between 0 and 180 degrees.
    // For valid positions, call super.setPosition(position).
    // For invalid positions, print an error and leave position unchanged.
}