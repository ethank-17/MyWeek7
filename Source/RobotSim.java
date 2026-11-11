package Source;
import java.util.Scanner;

// A simple terminal simulator. The command loop is already written for you.
// Focus on the OOP exercises in CLASSWORK.md and HOMEWORK.md.
public class RobotSim {
    public static void main(String[] args) {
        Drivetrain drivetrain = new Drivetrain();
        Intake intake = new Intake();
        Arm arm = new Arm();
        Climber climber = new Climber();

        // IN CLASS: After writing Elevator.java, replace null with new Elevator().
        Elevator elevator = new Elevator();

        BatteryMonitor battery = new BatteryMonitor(12.6);

        // IN CLASS: Try creating a generic Mechanism here. Later, when
        // Mechanism becomes abstract, that line should no longer compile.
        // Mechanism generic = new Mechanism("Generic Mechanism");

        Loggable[] loggable = {arm, elevator, battery, climber, intake};

        Scanner scanner = new Scanner(System.in);
        printHelp();

        boolean running = true;
        while (running) {
            System.out.print("\nrobot> ");
            if (!scanner.hasNextLine()) break;
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.isEmpty()) continue;
            String[] parts = input.split("\\s+");

            try {
                switch (parts[0]) {
                    case "drive":
                        // Example: drive 40 40, or drive -40 40 to turn.
                        if (parts.length != 3) {
                            System.out.println("Usage: drive <leftSpeed> <rightSpeed>");
                            break;
                        }
                        drivetrain.drive(Double.parseDouble(parts[1]),
                                         Double.parseDouble(parts[2]));
                        drivetrain.printStatus();
                        break;
                    case "stop":
                        drivetrain.stop();
                        System.out.println("Drivetrain stopped.");
                        break;
                    case "arm":
                        if (parts.length != 2) {
                            System.out.println("Usage: arm <angleInDegrees>");
                            break;
                        }
                        arm.setPosition(Double.parseDouble(parts[1]));
                        System.out.println("Arm position: " + arm.getPosition() + " degrees");
                        break;
                    case "climber":
                        if (parts.length != 2) {
                            System.out.println("Usage: climber <extensionInMeters>");
                            break;
                        }
                        climber.setPosition(Double.parseDouble(parts[1]));
                        System.out.println("Climber position: " + climber.getPosition() + " meters");
                        break;
                    case "extend":
                        climber.extend();
                        System.out.println("Climber position: " + climber.getPosition() + " meters");
                        break;
                    case "retract":
                        climber.retract();
                        System.out.println("Climber position: " + climber.getPosition() + " meters");
                        break;
                    case "elevator":
                        if (parts.length != 2) {
                            System.out.println("Usage: elevator <heightInMeters>");
                            break;
                        }
                        if (elevator == null) {
                            System.out.println("Elevator not created yet. Complete Elevator.java,");
                            System.out.println("then update the elevator variable in RobotSim.java.");
                            break;
                        }
                        elevator.setPosition(Double.parseDouble(parts[1]));
                        System.out.println("Elevator position: " + elevator.getPosition() + " meters");
                        break;
                    case "intake":
                        if (parts.length != 2) {
                            System.out.println("Usage: intake <deploymentInDegrees>");
                            break;
                        }
                        intake.setPosition(Double.parseDouble(parts[1]));
                        System.out.println("Intake position: " + intake.getPosition() + " degrees");
                        break;
                    case "collect":
                        intake.collect();
                        System.out.println("Running intake...");
                        System.out.println("Object collected");
                        break;
                    case "drop":
                        intake.eject();
                        System.out.println("Running intake...");
                        System.out.println("Object(s) dropped");
                        break;
                    case "deploy":
                        intake.deploy();
                        System.out.println("Deploying intake...");
                        System.out.println("Intake position: " + intake.getPosition() + " degrees");
                        break;
                    case "return":
                        intake.retract();
                        System.out.println("Retracting intake...");
                        System.out.println("Intake position: " + intake.getPosition() + " degrees");
                        break;
                    case "status":
                        drivetrain.printStatus();

                        for(int i = 0; i > loggable.length; i++) {
                            (loggable[i]).printStatus();
                        }
                        // IN CLASS: After adding Loggable, try replacing this
                        // section with a Loggable[] loop over the components.
                        break;
                    case "help":
                        printHelp();
                        break;
                    case "quit":
                        drivetrain.stop();
                        intake.stop();
                        running = false;
                        break;
                    default:
                        System.out.println("Unknown command. Type 'help' for options.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number (example: arm 90).");
            }
            // HOMEWORK: Add commands such as 'turret 90' or 'reset'.
        }
        scanner.close();
        System.out.println("Simulator closed.");
    }

    private static void printHelp() {
        System.out.println("=== ROBOT SIMULATOR ===");
        System.out.println("drive <left> <right>  Set tank-drive motor speeds (-100 to 100)");
        System.out.println("arm <degrees>         Set arm angle (0 to 180)");
        System.out.println("elevator <meters>     Set elevator height (after you write Elevator)");
        System.out.println("climber <meters>      Set climber extention meausurement (0 to 5 meters)");
        System.out.println("extend / retract      Fully extends or retracts climber");
        System.out.println("intake <degrees>      Set intake deployment angle (0 to 90)");
        System.out.println("collect / drop        Run intake motor");
        System.out.println("deploy / return       Deploys or retracts intake");
        System.out.println("stop                  Stop drivetrain");
        System.out.println("status                Print component status");
        System.out.println("help                  Show these commands");
        System.out.println("quit                  Exit the simulator");
    }
}
