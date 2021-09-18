package frc.robot.commands.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Intake.IntakeDirection;
import harkerrobolib.commands.IndefiniteCommand;

public class SpinIntakeVelocity extends IndefiniteCommand {

    private static final double kP = 0.00025;
    private static final double kF = 1/4000.0;
    private IntakeDirection direction;
    private double setpoint;

    public SpinIntakeVelocity(IntakeDirection direction, double setpoint) {
        addRequirements(Intake.getInstance());

        this.setpoint = setpoint;
        this.direction = direction;

    }

    public void execute() {
        Intake.getInstance().getVictor().set(ControlMode.PercentOutput, Intake.DEFAULT_INTAKE_MAGNITUDE * direction.getSign());
    }

       /**
    * {@inheritDoc}
    */
   public void end(boolean interrupted) {
      Intake.getInstance().setControllerOutput(0.0);
   }
}