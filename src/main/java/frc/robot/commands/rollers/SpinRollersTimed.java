package frc.robot.commands.rollers;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Rollers;
import frc.robot.subsystems.Rollers.RollerDirection;

/**
 * Moves the rollers for a certain time.
 * 
 * @since 1/12/19
 */
public class SpinRollersTimed extends WaitCommand{
   private double magnitude;
   private RollerDirection direction;

   public SpinRollersTimed(double magnitude, double time, RollerDirection direction) {
      super(time);
      addRequirements(Rollers.getInstance());
      this.magnitude = magnitude;
      this.direction = direction;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void execute() {
      super.execute();
      Rollers.getInstance().moveRollers(magnitude, direction);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void end(boolean interrupted) {
      super.end(interrupted);
      Rollers.getInstance().stopRollers();
   }

}