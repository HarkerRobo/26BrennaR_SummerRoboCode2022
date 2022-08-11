package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Wrist;
import harkerrobolib.commands.IndefiniteCommand;

public class WristManual extends IndefiniteCommand{
    public WristManual() {
        addRequirements(Wrist.getInstance());
    }

    public void execute() {
        double output;
        if (OI.getInstance().getDriver().getUpDPadButton().get())
        {
            output = 0.7;
        }
        else if (OI.getInstance().getDriver().getDownDPadButton().get())
        {
            output = -0.7;
        }
        else
        {
            output = 0.2;
        }
        Wrist.getInstance().setPercentOutput(output);
    }

    public void end(boolean interupted) {
        Wrist.getInstance().setPercentOutput(0);
    }
}
