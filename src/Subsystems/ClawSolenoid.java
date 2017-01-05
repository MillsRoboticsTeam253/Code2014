//Authors: MRT Programming Team
package Subsystems;

import Robot2014.RobotPorts;
import edu.wpi.first.wpilibj.Relay;

public class ClawSolenoid implements RobotPorts {
    
    public String state = "Closed";
    
    private final Relay clawSolenoid;
    
    public ClawSolenoid() {
        clawSolenoid = new Relay(CLAW_SOLENOID);
    }

    public void clawOpen() {
        clawSolenoid.set(Relay.Value.kForward);
        state = "Open";
    }

    public void clawClose() {
        clawSolenoid.set(Relay.Value.kOff);
        state = "Closed";
    }
}
