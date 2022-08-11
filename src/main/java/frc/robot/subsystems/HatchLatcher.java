package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HatchLatcher extends SubsystemBase{
    private static HatchLatcher instance;
    private DoubleSolenoid flower;
    private DoubleSolenoid extender;
    private static final int FORWARD_ID_FLOWER = 0;
    private static final int REVERSE_ID_FLOWER = 1;
    private static final int FORWARD_ID_EXTENDER = 0;
    private static final int REVERSE_ID_EXTENDER = 1;

    private HatchLatcher() {
        flower = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FORWARD_ID_FLOWER, REVERSE_ID_FLOWER);
        extender = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FORWARD_ID_EXTENDER, REVERSE_ID_EXTENDER);
    }

    public static HatchLatcher getInstance() {
        if (instance == null) {
            instance = new HatchLatcher();
        }
        return instance;
    }

    public void toggleFlower() {
        if (flower.get() == DoubleSolenoid.Value.kOff) {
            flower.set(DoubleSolenoid.Value.kReverse);
        }
        else if (flower.get() == DoubleSolenoid.Value.kReverse) {
            flower.set(DoubleSolenoid.Value.kForward);
        }
        else if (flower.get() == DoubleSolenoid.Value.kForward) {
            flower.set(DoubleSolenoid.Value.kReverse);
        }
    }

    public void toggleExtender() {
        if (extender.get() == DoubleSolenoid.Value.kOff) {
            extender.set(DoubleSolenoid.Value.kReverse);
        }
        else if (extender.get() == DoubleSolenoid.Value.kReverse) {
            extender.set(DoubleSolenoid.Value.kForward);
        }
        else if (extender.get() == DoubleSolenoid.Value.kForward) {
            extender.set(DoubleSolenoid.Value.kReverse);
        }
    }
}
