package org.usfirst.frc319.backOnTrack.subsystems;

import org.usfirst.frc319.backOnTrack.Robot;
import org.usfirst.frc319.backOnTrack.RobotMap;
import org.usfirst.frc319.backOnTrack.commands.TriggerMotorStop;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class trigger extends Subsystem {
	CANTalon triggerMotor = RobotMap.triggerMotor;
	DigitalInput triggerSwitch = RobotMap.triggerSwitch;
	
	public trigger (){
		 triggerMotor.changeControlMode(ControlMode.PercentVbus);
	}
		
	public void initDefaultCommand(){
		setDefaultCommand(new TriggerMotorStop());
	}
	
	public void triggerGo(){
		Robot.trigger.triggerMotor.set(-.3);
	}
	public void triggerStop(){
		Robot.trigger.triggerMotor.set(0);
	}
	public boolean tripedLimitSwitch(){ 
		return Robot.trigger.triggerSwitch.get();
	}
}
