package Source;

public class Intake extends Mechanism implements Loggable {
    private Motor motor;
    boolean hasGamePiece;
    String hGP;    

    public Intake() {
        super("intake");
        motor = new Motor("Intake Spinner");
        hasGamePiece = false;
    }

    public void collect() {
        motor.setSpeed(50);
        hasGamePiece = true;
    }
    public void eject() {
        motor.setSpeed(-50); 
        hasGamePiece = false;
    }
    public void stop() { motor.stop(); }

    @Override
    public void setPosition(double position) {
        if (position >= 0 && position <= 90) {
            super.updatePosition(position);
        } else {
            System.out.println("ERROR! Please input an angle in between zero (0) and 90.");
        }
    }

    public void deploy() {
        setPosition(90);
    }

    public void retract() {
        setPosition(90);
    }

    if (hasGamePiece == true) {
        hGP = "does";
    } else {
        hGP = "does not";
    }

    @Override 
    public void printStatus(){
        System.out.println("Intake is at " + position);
        System.out.println(motor.getName() + " is at " + motor.getSpeed() + "% speed");
        System.out.println("Intake " + hGP + " have a game piece");
    }
}
