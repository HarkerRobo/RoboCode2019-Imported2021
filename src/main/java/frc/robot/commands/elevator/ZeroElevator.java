package frc.robot.commands.elevator;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotMap.RobotType;
import frc.robot.subsystems.Elevator;

/**
 * Brings the elevator to the bottom and zeros that position. The command is
 * checked for completion by monitoring the current.
 * 
 * @author Angela Jia
 * @author Arun Sundaresan
 * @author Finn Frankis
 * @since 1/14/19
 */
public class ZeroElevator extends CommandBase {

   private static final double ZERO_SPEED;
   static {
      if (RobotMap.ROBOT_TYPE == RobotType.COMP) {
         ZERO_SPEED = -0.34;
      } else {
         ZERO_SPEED = -0.25;
      }
   }
   private static final double CURRENT_SPIKE = 2.8;
   private static final double TIMEOUT = 5000;

   private ArrayList<Double> currentVals;
   private int VALUES_TO_SAMPLE = 10;
   private int startTime = 0;

   public ZeroElevator() {
      addRequirements(Elevator.getInstance());
      currentVals = new ArrayList<Double>();
   }

   public void initialize() {
      Robot.log("ZeroElevator initialized.");
      startTime = Robot.getTime();
   }

   @Override
   public void execute() {
      Elevator.getInstance().setElevator(ControlMode.PercentOutput, ZERO_SPEED);
   }

   /**
    * @return true if wrist has hit hard limit on front side
    */
   @Override
   public boolean isFinished() {
      if (Robot.getTime() - startTime > TIMEOUT) {
         return true;
      }

      return Elevator.getInstance().getMasterTalon().getSensorCollection().isRevLimitSwitchClosed();
   }

   public void end(boolean interrupted) {
      Elevator.getInstance().getMasterTalon().set(ControlMode.Disabled, 0);
      Elevator.getInstance().getMasterTalon().setSelectedSensorPosition(0);
      ((MoveElevatorManual) Elevator.getInstance().getDefaultCommand()).setLastPosition(0);
      Robot.log("ZeroElevator over");
   }
}