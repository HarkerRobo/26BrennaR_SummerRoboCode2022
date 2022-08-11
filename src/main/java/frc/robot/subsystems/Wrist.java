package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Wrist extends SubsystemBase {
    private static Wrist instance;

    private HSTalon master;
    private VictorSPX follower;

    private static final int MOTOR_ID_MASTER = 0;
    private static final int MOTOR_ID_FOLLOWER = 1;

    private static final boolean MASTER_INVERTED = false;
    private static final boolean FOLLOWER_INVERTED = false;

    private Wrist() {
        master = new HSTalon(MOTOR_ID_MASTER);
        follower = new VictorSPX(MOTOR_ID_FOLLOWER);
        follower.follow(master);
        master.setInverted(MASTER_INVERTED);
        follower.setInverted(FOLLOWER_INVERTED);
    }

    public static Wrist getInstance() {
        if (instance == null){
            instance = new Wrist();
        }
        return instance;
    }
    
    public void setPercentOutput(double output){
        master.set(ControlMode.PercentOutput, output);
    }
}
