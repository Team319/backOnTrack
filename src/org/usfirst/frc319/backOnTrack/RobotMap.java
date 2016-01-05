package org.usfirst.frc319.backOnTrack;

    import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

public class RobotMap {
  
    public static CANTalon driveTrainCANTalonLeftLead;
    public static CANTalon driveTrainCANTalonLeftFollow;
    public static RobotDrive driveTrainRobotDrive; 
    public static CANTalon driveTrainCANTalonRightLead;
    public static CANTalon driveTrainCANTalonRightFollow;
	public static CANTalon shooter;
	public static CANTalon topshooter;
	public static CANTalon triggerMotor;
	public static DigitalInput triggerSwitch;
    //mapping to tell the Talons what they are.
   
    public static void init() {
       
        driveTrainCANTalonLeftLead = new CANTalon(0);       
        driveTrainCANTalonLeftFollow = new CANTalon(1);
        driveTrainCANTalonRightLead = new CANTalon(2);        
        driveTrainCANTalonRightFollow = new CANTalon(3);
        shooter = new CANTalon(4);
        topshooter = new CANTalon(5);
        //tells the rio what Talon each motor is assigned too.
        
        triggerMotor = new CANTalon(6);
        triggerSwitch = new DigitalInput(0);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainCANTalonLeftLead, driveTrainCANTalonRightLead);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);

        //driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        //driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
        
    }
}
