package frc.robot.util;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.hatchpanelintake.SetExtenderState;
import frc.robot.commands.intake.SpinIntakeVelocity;
import frc.robot.commands.wrist.MoveWristMotionMagic;
import harkerrobolib.commands.CallMethodCommand;

/**
 * Represents a conditional command that uses a lambda to produce conditional values.
 * 
 * @author Chirag Kaushik
 * @since February 12, 2019
 */
public class ConditionalCommand extends edu.wpi.first.wpilibj2.command.ConditionalCommand {
    private BooleanSupplier condition;

    public ConditionalCommand(BooleanSupplier condition, Command conditionalCommand) {
        super(conditionalCommand, new CallMethodCommand(() -> {}),condition);
    }

    public ConditionalCommand(BooleanSupplier condition, Command trueCommand, Command falseCommand) {
        super(trueCommand, falseCommand, condition);
    }
}