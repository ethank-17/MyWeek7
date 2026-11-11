package Source;

public interface Resettable {

    public void reset();
    
//1. Create an interface named `Resettable` that requires a `void reset()` method.
//2. Have **at least three different robot component classes** implement `Resettable`.
//3. One of these classes must be `BatteryMonitor`. Modify `BatteryMonitor.java` so that its `reset()` method resets `lowestVoltage` to the current `voltage`, without changing the current voltage.
//4. Choose at least **two additional classes** to implement `Resettable`. Decide what resetting means for each component and implement that behavior.
//
//For example, resetting a drivetrain might stop all its motors, while resetting an arm might return its simulated position to zero. Make sensible choices for your components rather than giving every `reset()` method identical code.
//
//**Think about:** Why does resetting a `BatteryMonitor` mean something different from resetting an arm or elevator? How can the same interface work for classes that aren't related through inheritance?

}
