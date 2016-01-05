package org.usfirst.frc319.backOnTrack.subsystems;
import org.usfirst.frc319.backOnTrack.Robot;
import org.usfirst.frc319.backOnTrack.RobotMap;
import org.usfirst.frc319.backOnTrack.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class driveTrain extends Subsystem {
	//this is where you link the objects in your subsystem to your robot map
    CANTalon cANTalonLeftLead = RobotMap.driveTrainCANTalonLeftLead;
    CANTalon cANTalonLeftFollow = RobotMap.driveTrainCANTalonLeftFollow;
    CANTalon cANTalonRightLead = RobotMap.driveTrainCANTalonRightLead;
    CANTalon cANTalonRightFollow = RobotMap.driveTrainCANTalonRightFollow; 
    RobotDrive robotDrive = RobotMap.driveTrainRobotDrive; 
    
  public driveTrain(){
	  //this is where you can configure the mode of thte motor controllers
    	cANTalonRightLead.changeControlMode(ControlMode.PercentVbus);
    	cANTalonRightFollow.changeControlMode(CANTalon.ControlMode.Follower);
    	cANTalonRightFollow.set(cANTalonRightLead.getDeviceID());
    	cANTalonLeftLead.changeControlMode(ControlMode.PercentVbus);
    	cANTalonLeftFollow.changeControlMode(ControlMode.Follower);
    	cANTalonLeftFollow.set(cANTalonLeftLead.getDeviceID()); 	
  } 
    // Put methods for controlling this subsystem here. Call these from Commands.
    public void initDefaultCommand() {
        setDefaultCommand(new JoyStickDrive());
    }
    public void arcadeDrive(double moveValue, double rotateValue){
    	
    	double scaledMoveValue = 0;
    	double scaledRotateValue = 0;
    	
    	if (moveValue < 0) {
    		scaledMoveValue = -(moveValue * moveValue);    		
    	} else {
    		scaledMoveValue = (moveValue * moveValue);}
    	if (rotateValue < 0) {
    		scaledRotateValue = -(rotateValue * rotateValue);
    	} else {
    		scaledRotateValue = (rotateValue * rotateValue);}
    	
    	robotDrive.arcadeDrive(scaledMoveValue* -0.75 , scaledRotateValue* -0.75);// goes to robot drive and finds arcadeDrive to us
    }
    	
    
//this make it a square function instead a linear function to operate under low voltages

    public void tankDrive(double leftValue, double rightValue){
    	
    	
    	double scaledleftValue = 0;
    	double scaledrightValue = 0;
    	
    	if (leftValue < 0) {
    		scaledleftValue = -(leftValue * leftValue);    		
    	} else {
    		scaledleftValue = (leftValue * leftValue);
    	}
    	if (rightValue < 0) {
    		scaledrightValue = -(rightValue * rightValue);
    	} else {
    		scaledrightValue = (rightValue * rightValue);
  
    	}
    	robotDrive.tankDrive(scaledleftValue* 0.75 , scaledrightValue* 0.75);// goes to robot drive and finds arcadeDrive to us
    }
    	
    public int leftSpeed(){
    	return Robot.driveTrain.cANTalonLeftLead.getEncVelocity();
    }
    
    
    
	}

