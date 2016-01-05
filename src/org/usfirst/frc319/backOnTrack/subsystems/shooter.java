package org.usfirst.frc319.backOnTrack.subsystems;

import org.usfirst.frc319.backOnTrack.Robot;
import org.usfirst.frc319.backOnTrack.RobotMap;
import org.usfirst.frc319.backOnTrack.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon shooter = RobotMap.shooter;
	CANTalon triggerMotor = RobotMap.triggerMotor;
	CANTalon topshooter = RobotMap.topshooter;
	//DigitalInput triggerSwitch = RobotMap.triggerSwitch;
	
	public shooter(){
		shooter.changeControlMode(ControlMode.Speed);
    	shooter.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	shooter.setPID(0.1 ,0, 0, 0,0, 0, 1);
    	
    	topshooter.changeControlMode(ControlMode.Speed);
    	topshooter.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	topshooter.setPID(0.1,0, 0, 0,0, 0, 1);
    	//0.2,0,0.005 
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ShooterDisplay());
    }
    
/*
    public boolean getTriggerLimitSwitch(){
    	return Robot.shooter.triggerSwitch.get();	
    }
    */
    
    public int shooterSpeed(){
    	return Robot.shooter.shooter.getEncVelocity();
    }
    
    public int shooterPosition(){
    	return Robot.shooter.shooter.getEncPosition();
    }
    
    public int topshooterSpeed(){
    	return Robot.shooter.topshooter.getEncVelocity();
    }
    
    public int topshooterPosition(){
    	return Robot.shooter.topshooter.getEncPosition();
    }
		
    public void shooterGo(){
    	Robot.shooter.shooter.set(.3);
    }
    
    public void topshooterGo(){
    	Robot.shooter.topshooter.set(-.3);
    }
    
    public void topshooterStop(){
    	Robot.shooter.topshooter.set(0);
    }
    
    public void shooterStop(){
    	Robot.shooter.shooter.set(0);
    	 }
    
    public void shooterGoConstant(){
    	Robot.shooter.shooter.set(2000); // was (-2000)
    }
    
    public void topshooterGoConstant(){
    	Robot.shooter.topshooter.set(-2000); // was (2000)
    }
}

