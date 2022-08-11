package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase {
    private static Intake instance;

    private HSTalon motor;
    private static final int MOTOR_ID = 0;
    private static final boolean MOTOR_INVERTED = false;
    private DoubleSolenoid DS;
    private static final int FORWARD_ID = 0;
    private static final int REVERSE_ID = 1;
    private boolean inTaking;

    private Intake() {
        motor = new HSTalon(MOTOR_ID);
        motor.setInverted(MOTOR_INVERTED);

        DS = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FORWARD_ID, REVERSE_ID);

        inTaking = false;
    }

    public static Intake getInstance() {
        if (instance == null) {
            instance = new Intake();
        }
        return instance;
    }

    public HSTalon getMotor() {
        return motor;
    }

    public void setMotor(double output) {
        if (output >= 0.3) {
            inTaking = true;
        }
        else {
            inTaking = false;
        }
        motor.set(ControlMode.PercentOutput, output);
    }

    public boolean getInTaking() {
        return inTaking;
    }

    public void toggle() {
        if (DS.get() == DoubleSolenoid.Value.kOff) {
            DS.set(DoubleSolenoid.Value.kReverse);
        }
        else if (DS.get() == DoubleSolenoid.Value.kReverse) {
            DS.set(DoubleSolenoid.Value.kForward);
        }
        else if (DS.get() == DoubleSolenoid.Value.kForward) {
            DS.set(DoubleSolenoid.Value.kReverse);
        }
    }

}
