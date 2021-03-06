package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.commands.arm.SetArmState;
import frc.robot.commands.groups.SetScoringPosition.Location;
import frc.robot.commands.hatchpanelintake.SetExtenderState;
import frc.robot.commands.wrist.MoveWristMotionMagic;
import frc.robot.subsystems.Arm.ArmDirection;
import frc.robot.subsystems.HatchLatcher.ExtenderDirection;
import frc.robot.subsystems.Wrist;
import harkerrobolib.commands.CallMethodCommand;

/**
 * Brings all necessary subsystems inside the frame perimeter of the robot in
 * order to play defense legally.
 * 
 * @author Chirag Kaushik
 * @author Jatin Kohli
 * @since February 12, 2019
 */
public class StowHatchAndCargoIntake extends edu.wpi.first.wpilibj2.command.SequentialCommandGroup {

      public static final double ARM_WAIT_TIME = 0.5;
   public StowHatchAndCargoIntake() {
      super(new CallMethodCommand(() -> Robot.log("Entering defense mode.")),
            new SetExtenderState(ExtenderDirection.IN),
            new SetScoringPosition(Location.CARGO_INTAKE, () -> false),
            // new ConditionalCommand(
            //       () -> (Wrist.getInstance().getCurrentSide() == Side.FRONT
            //             && !Elevator.getInstance().isAbove(Elevator.RAIL_POSITION)),
            //       //new SetScoringPosition(Location.PARALLEL_FRONT), new SetScoringPosition(Location.PARALLEL_BACK)),
            // new CallMethodCommand(() -> System.out.println("Waiting for " + ARM_WAIT_TIME + "seconds")),
            new MoveWristMotionMagic(Wrist.MID_POSITION), new WaitCommand(ARM_WAIT_TIME), new SetArmState(ArmDirection.UP));
   }
}