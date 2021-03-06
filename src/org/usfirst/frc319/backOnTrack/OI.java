// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc319.backOnTrack;


import org.usfirst.frc319.backOnTrack.commands.*;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;



public class OI {
      

    public Joystick joystick;
	public Joystick xboxController1;
	public JoystickButton bButton;
	public JoystickButton aButton;
	public JoystickButton xButton;
	public JoystickButton yButton;
	public JoystickButton leftBumper;
	public JoystickButton rightBumper;


    public OI() {
     
        xboxController1 = new Joystick (0);
       
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

        SmartDashboard.putData("JoyStickDrive", new JoyStickDrive());
        
        aButton = new JoystickButton(xboxController1,1);
        aButton.whenPressed(new ShooterGoConstant());
        
        bButton = new JoystickButton(xboxController1, 2);
        bButton.whenPressed(new ShooterStop());
        
        xButton = new JoystickButton(xboxController1,3);
        xButton.whenPressed(new TopShooterGoConstant());
        
        yButton = new JoystickButton(xboxController1,4);
        yButton.whenPressed(new TopShooterStop());
        
        rightBumper = new JoystickButton (xboxController1,5);
        rightBumper.whenPressed(new TriggerMotorGo());
        
    }
    
    public Joystick getxBoxController1() {// what your controller is
    	return xboxController1;
    }



}

