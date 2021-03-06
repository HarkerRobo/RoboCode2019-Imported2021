package frc.robot.commands.drivetrain;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.util.Limelight;

/**
 * Toggles the Limelight LEDs between on and off.
 * 
 * @author Finn Frankis
 */
public class ToggleLimelightLEDMode extends InstantCommand {
   public void initialize() {
      int currentLEDValue = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").getNumber(0.0)
            .intValue();
      NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode")
            .setNumber(currentLEDValue == Limelight.LED_OFF ? Limelight.LED_ON : Limelight.LED_OFF);
   }
}