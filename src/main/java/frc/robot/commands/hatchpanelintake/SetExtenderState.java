package frc.robot.commands.hatchpanelintake;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.HatchLatcher;
import frc.robot.subsystems.HatchLatcher.ExtenderDirection;

/**
 * Sets the extender's state.
 * 
 * @author Shahzeb Lakhani
 * @since 1/29/19
 */
public class SetExtenderState extends InstantCommand {
   private ExtenderDirection direction;

   public SetExtenderState(ExtenderDirection direction) {
      addRequirements(HatchLatcher.getInstance());

      this.direction = direction;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void initialize() {
      Robot.log("Extender moved " + (direction == ExtenderDirection.OUT ? "out" : "in") + ".");
      HatchLatcher.getInstance().setExtenderState(direction);
   }
}