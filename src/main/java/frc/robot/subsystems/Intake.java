package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.RobotMap.CAN_IDs;
import frc.robot.RobotMap.RobotType;
import harkerrobolib.util.Constants;

/**
 * Intakes the cargo into the robot.
 * 
 * @author Finn Frankis
 * @author Anirudh Kotamraju
 * @author Angela Jia
 * @since 1/11/19
 */
public class Intake extends SubsystemBase {
   public enum IntakeDirection {
      IN(1), OUT(-1), STOP(0);
      private int sign;

      private IntakeDirection(int sign) {
         this.sign = sign;
      }

      public int getSign() {
         return sign;
      }
   }

   private static Intake instance;
   private VictorSPX intakeVictor;
   private boolean isSpark;

   private final static int STALL_LIMIT = 40; // current limit (amps) when the robot is stopped
   private final static int FREE_LIMIT = 30; // current limit (amps) when the robot is moving freely

   private final static boolean SPARK_INVERTED;
   private final static boolean VICTOR_INVERTED;
   private final static NeutralMode VICTOR_NEUTRAL_MODE = NeutralMode.Brake;
  

   static {
      if (RobotMap.ROBOT_TYPE == RobotType.COMP) {
         SPARK_INVERTED = true;
         VICTOR_INVERTED = true;
      } else {
         SPARK_INVERTED = true;
         VICTOR_INVERTED = true;
      }

   }
   public final static double DEFAULT_INTAKE_MAGNITUDE = 0.5;
   public final static double SLOW_INTAKE_VELOCITY = 2500;
   public final static double DEFAULT_INTAKE_VELOCITY = 2500;

   public void setControllerOutput(double magnitude, IntakeDirection direction) {
      setControllerOutput(magnitude * direction.getSign());
   }

   public void setControllerOutput(double percentOutput) {
      intakeVictor.set(ControlMode.PercentOutput, percentOutput);
   }

   private Intake() {
      intakeVictor = new VictorSPX(CAN_IDs.BALL_INTAKE_MASTER_VICTOR);
   }

   public void controllerInit() {
      intakeVictor.setInverted(VICTOR_INVERTED);
      intakeVictor.setNeutralMode(VICTOR_NEUTRAL_MODE);
   }

   public static Intake getInstance() {
      if (instance == null) {
         instance = new Intake();
      }
      return instance;
   }
   // public double getEncoderPosition () {
   // return Intake.getInstance().getController().getEncoder().getPosition();
   // }

   // public double getEncoderVelocity () {
   // return Intake.getInstance().getController().getEncoder().getVelocity();
   // }

   public VictorSPX getVictor() {
      return intakeVictor;
   }
}