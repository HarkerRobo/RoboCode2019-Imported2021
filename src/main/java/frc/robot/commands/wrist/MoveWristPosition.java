package frc.robot.commands.wrist;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Wrist;

/**
 * Moves the wrist to a given position.
 * 
 * @author Finn Frankis
 * @author Jatin Kohli
 * @author Chirag Kaushik
 * 
 * @since 1/12/19
 */
public class MoveWristPosition extends CommandBase {
   private double position;

   public static final double KF = 0.0;
   public static final double KP = 0.5;
   public static final double KI = 0;
   public static final double KD = 1;
   public static final int IZONE = 0;

   public MoveWristPosition(double angle) {
      addRequirements(Wrist.getInstance());
      this.position = Wrist.getInstance().convertDegreesToEncoder(angle);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void initialize() {
      Wrist.getInstance().setupPositionPID();
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void execute() {
      SmartDashboard.putNumber("Wrist Error", Wrist.getInstance().getMasterTalon().getClosedLoopError());
      Wrist.getInstance().setWrist(ControlMode.Position, position);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public boolean isFinished() {
      return true;// return
                  // Math.abs(Wrist.getInstance().getMasterTalon().getClosedLoopError(Wrist.POSITION_SLOT))
                  // < Wrist.ALLOWABLE_ERROR;
   }
}