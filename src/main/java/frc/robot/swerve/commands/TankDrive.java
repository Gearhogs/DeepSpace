package frc.robot.swerve.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {

    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.swerveDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.swerveDrive.resetDrive();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.swerveDrive.TankDrive(Robot.oi.getLeftJoystick().getY(), Robot.oi.getRightJoystick().getY());
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
