
package org.usfirst.frc319.backOnTrack;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc319.backOnTrack.Robot;
import org.usfirst.frc319.backOnTrack.commands.*;
import org.usfirst.frc319.backOnTrack.subsystems.*;
//import java.util.logging.*;

public class Robot extends IterativeRobot {

    Command autonomousCommand;
    
    public static OI oi;
    
    public static driveTrain driveTrain;
    
    public static shooter shooter;
    
    public static trigger trigger;

   
    public void robotInit() {
    RobotMap.init();
    
    	
        driveTrain = new driveTrain();
        shooter= new shooter();
        
        trigger = new trigger();
        
      
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
        oi = new OI();
        autonomousCommand = new AutonomousCommand();

    }


    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
       
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Top Shooter Speed", Robot.shooter.topshooterSpeed());
        SmartDashboard.putNumber("Bottom Shooter Speed", Robot.shooter.shooterSpeed());
    }
// handles all communications and protocols automatically. (does everything)
    public void testPeriodic() {
        LiveWindow.run();
    }
}
