//Authors: MRT Programming Team
package Robot2014;

public interface RobotPorts {

    //PWM Ports
    public static final int MOTOR_LEFT_ONE = 1;
    public static final int MOTOR_LEFT_TWO = 2;
    public static final int MOTOR_RIGHT_ONE = 3;
    public static final int MOTOR_RIGHT_TWO = 4;
    public static final int CLAW_VICTOR = 5;

    //Relay (Spike) Ports
    public static final int COMPRESSOR = 2;
    public static final int CLAW_SOLENOID = 3;
    public static final int CATAPULT_PORT = 8;

    //Digital I/O
    public final static int CLAW_UP_SWITCH = 1;
    public final static int CLAW_DOWN_SWITCH = 2;

    //Gamepad Declaration
    public static final int GAMEPAD = 1;

}
