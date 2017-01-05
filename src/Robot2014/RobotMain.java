//Authors: MRT Programming Team
package Robot2014;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import Subsystems.ClawMotor;
import Subsystems.Compressor;
import Subsystems.ClawSolenoid;
import Subsystems.Catapult;
import edu.wpi.first.wpilibj.Victor;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMain extends IterativeRobot implements RobotPorts, GamepadButtons {

    private boolean autonomousRunning = false;

    private static RobotDrive driveTrain;
    private static Joystick gamePad;

    private static ClawMotor claw;
    private static Compressor compressor;
    private static ClawSolenoid clawSolenoid;
    private static Catapult catapult;

    public void robotInit() {
        gamePad = new Joystick(GAMEPAD);
        driveTrain = new RobotDrive(MOTOR_LEFT_ONE, MOTOR_LEFT_TWO, MOTOR_RIGHT_ONE, MOTOR_RIGHT_TWO);

        driveTrain.setSafetyEnabled(false);

        claw = new ClawMotor();
        compressor = new Compressor();
        clawSolenoid = new ClawSolenoid();
        catapult = new Catapult();
    }

    public void autonomousInit() {   //Called the first time the robot is put into autonomous mode.
        autonomousRunning = false;
    }
    private final static double SPEED = -.1;
    private final static int TIME = 2;
    public void autonomousPeriodic() {
       getCatapult().catapultExtend();
       Timer.delay(2);
       for(int nums = 0; nums < 1000; nums++)
           getCatapult().catapultRetract();
       
    }

    public void teleopInit() {
        compressor.compressorOff();
    }

    public void teleopPeriodic() {
        driveTrain.tankDrive(gamePad, 4, gamePad, 2);
        checkClawMotor();
        checkCompressor();
        checkClawSolenoid();
        checkCatapult();
        displayValues();
    }

    public void checkClawMotor() {
        if (gamePad.getRawButton(Y_BUTTON)) {
            getClaw().motorUp();
        } else if (gamePad.getRawButton(A_BUTTON)) {
            getClaw().motorDown();
        } else {
            getClaw().stopMotor();
        }
    }

    public void checkCompressor() {
        if (gamePad.getRawButton(X_BUTTON)) {
            getCompressor().compressorOn();
        } else if (gamePad.getRawButton(B_BUTTON)) {
            getCompressor().compressorOff();
        }
    }

    public static void checkClawSolenoid() {
        if (gamePad.getRawButton(RB_BUTTON)) {
            getClawSolenoid().clawOpen();
        } else {
            getClawSolenoid().clawClose();
        }
    }

    public static void checkCatapult() {
        if (gamePad.getRawButton(LB_BUTTON)) {
            getCatapult().catapultExtend();
        } else {
            getCatapult().catapultRetract();
        }
    }

    public static ClawSolenoid getClawSolenoid() {
        return clawSolenoid;
    }

    public static ClawMotor getClaw() {
        return claw;
    }

    public static Compressor getCompressor() {
        return compressor;
    }

    public static Catapult getCatapult() {
        return catapult;
    }

    public void test() {
        
    }

    public void displayValues() {
        SmartDashboard.putString("The Compressor is ", compressor.state);
        SmartDashboard.putString("The Claw is ", clawSolenoid.state);
        SmartDashboard.putBoolean("Up switch is ", !ClawMotor.up_switch.get());
    }
}
