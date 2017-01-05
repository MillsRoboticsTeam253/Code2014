//Authors: MRT Programming Team
package Subsystems;

import Robot2014.RobotPorts;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;

public class ClawMotor implements RobotPorts {

    private final Victor claw_victor;

    public static DigitalInput up_switch;
    private static DigitalInput down_switch;

    public ClawMotor() {
        claw_victor = new Victor(CLAW_VICTOR);

        up_switch = new DigitalInput(CLAW_UP_SWITCH);
        down_switch = new DigitalInput(CLAW_DOWN_SWITCH);
    }

    public void motorUp() {
        if (up_switch.get() == true) {     //I don't know why but this value has to be true. True = Not clicked. False = Clicked. - Shane Kent 1/25/14
            claw_victor.set(-0.5);
        } else if (up_switch.get() == false) {
            stopMotor();
        }
    }

    public void motorDown() {
        if (down_switch.get() == true) {
            claw_victor.set(0.2);
        } else if (down_switch.get() == false) {
            stopMotor();
        }
    }

    public void stopMotor() {
        claw_victor.set(0.0);
    }

}
