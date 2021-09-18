package frc.robot.commands.intake;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Intake.IntakeDirection;
import edu.wpi.first.wpilibj2.command.WaitCommand;
/**
 * Intakes the ball into the robot.
 * 
 * @author Anirudh Kotamraju
 * @since 1/11/19
 */
public class SpinIntakeTimed extends WaitCommand {
   private double magnitude;
   private IntakeDirection direction;

   /**
    * Creates a new command that runs for a specific time.
    * 
    * @param time the time (in seconds) that the command should run for
    */
   public SpinIntakeTimed(double magnitude, double time, IntakeDirection direction) {
      super(time);
      addRequirements(Intake.getInstance());
      this.magnitude = magnitude;
      this.direction = direction;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void execute() {
      super.execute();
      Intake.getInstance().setControllerOutput(magnitude, direction);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void end(boolean interrupted) {
      super.end(interrupted);
      Intake.getInstance().setControllerOutput(0, IntakeDirection.STOP);
   }
}
