package frc.robot.swerve.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CrabDrive extends Command {

    public CrabDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.swerveDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.getMagnitude(Robot.oi.getLeftJoystick()) < .1) {
    		Robot.swerveDrive.SetAllModules(0, 0, 0, 0);
    		Robot.swerveDrive.stopDrive();
    	}
    	else {
    		Robot.swerveDrive.CrabDrive(Robot.oi.getAngle(Robot.oi.getLeftJoystick()), Robot.oi.getMagnitude(Robot.oi.getLeftJoystick()));
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
