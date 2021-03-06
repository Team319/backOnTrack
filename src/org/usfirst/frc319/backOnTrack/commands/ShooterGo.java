// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc319.backOnTrack.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc319.backOnTrack.Robot;

/**
 *
 */
public class  ShooterGo extends Command {

    public ShooterGo() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
        requires(Robot.shooter);
    }
    protected void initialize() {
    }
    
    protected void execute() {
    	//double moveValue = Robot.oi.xboxController1.getRawAxis(0);
    	Robot.shooter.shooterGo();
    	System.out.println("pulley speed ="+Robot.shooter.shooterSpeed());
    	//System.out.println("left speed ="+Robot.driveTrain.leftSpeed());
	//uses driveTrain and is combined with the analogs on the controller
    }
   
    protected boolean isFinished() {
        return false;//changed from false
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
