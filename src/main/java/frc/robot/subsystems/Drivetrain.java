package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase{
    //singleton variable
    private static Drivetrain instance;
    
    //constant for motor device id
    private static final int MOTOR_ID_LM = 0;
    private static final int MOTOR_ID_RM = 1;
    private static final int MOTOR_ID_LF = 2;
    private static final int MOTOR_ID_RF = 3;

    //instance variable for the motor
    private HSTalon LM;
    private HSTalon RM;
    private VictorSPX LF;
    private VictorSPX RF;

    //constant for inverted motor
    private static final boolean LM_INVERTED = false;
    private static final boolean RM_INVERTED = false;
    private static final boolean LF_INVERTED = false;
    private static final boolean RF_INVERTED = false;

    private Drivetrain() {
        LM = new HSTalon(MOTOR_ID_LM);
        RM = new HSTalon(MOTOR_ID_RM);
        LF = new VictorSPX(MOTOR_ID_LF);
        RF = new VictorSPX(MOTOR_ID_RF);
        LF.follow(LM);
        RF.follow(RM);
        LM.setInverted(LM_INVERTED);
        RM.setInverted(RM_INVERTED);
        LF.setInverted(LF_INVERTED);
        RF.setInverted(RF_INVERTED);
    }  

    //getter method for the motors
    public HSTalon getMotorLM() {
        return LM;
    }

    public HSTalon getMotorRM() {
        return RM;
    }

    public VictorSPX getMotorLF() {
        return LF;
    }

    public VictorSPX getMotorRF() {
        return RF;
    }
    
    public void setArcadeDrive(double speed, double turn){
        LM.set(ControlMode.PercentOutput, speed+turn);
        RM.set(ControlMode.PercentOutput, speed-turn);
    }


    //returns the Drivetrain instance
    public static Drivetrain getInstance() {
        if (instance == null) {
            instance = new Drivetrain();
        }
        return instance;
    }
}
