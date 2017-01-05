//Authors: MRT Programming Team
package Subsystems;

import Robot2014.RobotPorts;

import edu.wpi.first.wpilibj.Relay;

public class Catapult implements RobotPorts {

    private final Relay catapult;

    public Catapult() {
        catapult = new Relay(CATAPULT_PORT);
    }

    public void catapultExtend() {
        if (ClawMotor.up_switch.get() == true) {
            catapult.set(Relay.Value.kOn);
            catapult.set(Relay.Value.kForward);
        }
    }

    public void catapultRetract() {
        if (ClawMotor.up_switch.get() == true) {
            catapult.set(Relay.Value.kReverse);
        }
    }
}
