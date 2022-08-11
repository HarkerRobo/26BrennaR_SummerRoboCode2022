package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase{
    private static Elevator instance;
    
    private HSTalon master;
    private HSTalon follower1;
    private VictorSPX follower2;
    private VictorSPX follower3;

    private static final int MOTOR_ID_MASTER = 0;
    private static final int MOTOR_ID_FOLLOWER1 = 1;
    private static final int MOTOR_ID_FOLLOWER2 = 2;
    private static final int MOTOR_ID_FOLLOWER3 = 3;

    private static final boolean MASTER_INVERTED = false;
    private static final boolean FOLLOWER1_INVERTED = false;
    private static final boolean FOLLOWER2_INVERTED = false;
    private static final boolean FOLLOWER3_INVERTED = false;


    private Elevator() {
        master = new HSTalon(MOTOR_ID_MASTER);
        follower1 = new HSTalon(MOTOR_ID_FOLLOWER1);
        follower2 = new VictorSPX(MOTOR_ID_FOLLOWER2);
        follower3 = new VictorSPX(MOTOR_ID_FOLLOWER3);
        follower1.follow(master);
        follower2.follow(master);
        follower3.follow(master);
        master.setInverted(MASTER_INVERTED);
        follower1.setInverted(FOLLOWER1_INVERTED);
        follower2.setInverted(FOLLOWER2_INVERTED);
        follower3.setInverted(FOLLOWER3_INVERTED);
    }

    public static Elevator getInstance() {
        if (instance == null){
            instance = new Elevator();
        }
        return instance;
    }

    public HSTalon getMaster() {
        return master;
    }

    public HSTalon getFollower1() {
        return follower1;
    }

    public VictorSPX getFollower2() {
        return follower2;
    }

    public VictorSPX getFollower3() {
        return follower3;
    }

    public void setPercentOutput(double output){
        master.set(ControlMode.PercentOutput, output);
    }

}
