
package org.usfirst.frc319.backOnTrack.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc319.backOnTrack.Robot;

/**
 *
 */
public class  JoyStickDrive extends Command {

    public JoyStickDrive() {

        requires(Robot.driveTrain);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    double moveValue = Robot.oi.xboxController1.getRawAxis(1);
	double rotateValue = Robot.oi.xboxController1.getRawAxis(4);
	
	Robot.driveTrain.arcadeDrive(moveValue, rotateValue);
	System.out.println(+Robot.driveTrain.leftSpeed());
	//uses driveTrain and is combined with the analogs on the controller
    }
   
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
