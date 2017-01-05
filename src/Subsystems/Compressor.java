//Authors: MRT Programming Team
package Subsystems;

import Robot2014.RobotPorts;
import edu.wpi.first.wpilibj.Relay;

public class Compressor implements RobotPorts {
    
    public String state = "Off";
    
    private final Relay compressor;

    public Compressor() {
        compressor = new Relay(COMPRESSOR);
    }
    
    public void compressorOn() {
        compressor.set(Relay.Value.kOn);
        compressor.set(Relay.Value.kForward);
        state = "On";
    }

    public void compressorOff() {
        compressor.set(Relay.Value.kOff);
        state = "Off";
    }
}
