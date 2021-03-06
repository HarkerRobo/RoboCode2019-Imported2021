package frc.robot.commands.intake;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Intake.IntakeDirection;
import harkerrobolib.commands.IndefiniteCommand;

/**
 * Controls ball intake.
 * 
 * @author Dawson Chen
 * @author Shahzeb Lakhani
 * @author Anirudh Kotamraju
 * @since 1/11/19
 */

public class SpinIntakeManual extends IndefiniteCommand {

   public SpinIntakeManual() {
      addRequirements(Intake.getInstance());
      Robot.log("SpinIntakeManual constructed.");
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void execute() {
      // double driverBallIntakeOutput =
      // MathUtil.mapJoystickOutput(OI.getInstance().getDriverGamepad().getRightY(),
      // OI.DRIVER_DEADBAND);
      // Intake.getInstance().setControllerOutput(driverBallIntakeOutput);
      // if (Math.signum(driverBallIntakeOutput) == IntakeDirection.IN.getSign()) { //
      // only actuate if pulling cargo in
      // //Intake.getInstance().setControllerOutput(operatorBallIntakeOutput);
      // }
      if (OI.getInstance().getDriverGamepad().getButtonYState() && OI.getInstance().getRunRollersAndIntake()) {
         Intake.getInstance().setControllerOutput(Intake.DEFAULT_INTAKE_MAGNITUDE, IntakeDirection.IN);
      } else {
         Intake.getInstance().setControllerOutput(0.0, IntakeDirection.IN);
      }
   }
}