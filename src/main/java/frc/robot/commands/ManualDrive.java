package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;
import harkerrobolib.commands.IndefiniteCommand;

public class ManualDrive extends IndefiniteCommand {
    public double desiredSpeed;
    public double desiredTurn;

    public ManualDrive()
    {
        addRequirements(Drivetrain.getInstance());
    }
    public void execute()
    {
        double speed  = OI.getInstance().getDriver().getLeftY();
        double turn = OI.getInstance().getDriver().getLeftX();
        Drivetrain.getInstance().setArcadeDrive(speed, turn);
    }

    public void end(boolean interupted) {
        Drivetrain.getInstance().setArcadeDrive(0, 0);
    }
}
