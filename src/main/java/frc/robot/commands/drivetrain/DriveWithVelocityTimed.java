package frc.robot.commands.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Drivetrain;

public class DriveWithVelocityTimed extends WaitCommand {
   private double velocity = 0;

   public DriveWithVelocityTimed(double time, double velocity) {
      super(time);
      this.velocity = velocity;
   }

   /**
    * {@inheritDoc}
    */
   public void execute() {
      super.execute();
      Drivetrain.getInstance().getLeftMaster().set(ControlMode.PercentOutput, velocity);
      Drivetrain.getInstance().getRightMaster().set(ControlMode.PercentOutput, velocity);
   }

}