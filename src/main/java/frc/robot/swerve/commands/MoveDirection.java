package frc.robot.swerve.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class MoveDirection extends TimedCommand {

	int direction;
	
    public MoveDirection(int direction, float time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super(time);
    	this.direction = direction;
    	requires(Robot.swerveDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.swerveDrive.SetAllModules(direction, direction, direction, direction);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.swerveDrive.setDriveSpeed(.8);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.swerveDrive.setDriveSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.swerveDrive.setDriveSpeed(0);
    }
}
