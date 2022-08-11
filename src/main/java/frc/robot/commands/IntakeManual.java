package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Intake;
import harkerrobolib.commands.IndefiniteCommand;

public class IntakeManual extends IndefiniteCommand{
    public IntakeManual() {
        addRequirements(Intake.getInstance());
    }

    public void execute() {
        double output = OI.getInstance().getDriver().getRightTrigger();
        if (output > 0.5)
        {
            output = 0.3;
        }
        else 
        {
            output = 0;
        }
        Intake.getInstance().setMotor(output);
    }

    public void end(boolean interupted) {
        Intake.getInstance().setMotor(0);
    }
}
