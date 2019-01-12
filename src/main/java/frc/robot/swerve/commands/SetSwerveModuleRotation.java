package frc.robot.swerve.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetSwerveModuleRotation extends InstantCommand {
	
	double degrees;
    public SetSwerveModuleRotation(double degrees) {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.swerveDrive);
        this.degrees = degrees;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.swerveDrive.rotateSwerveModule(Robot.swerveDrive.backLeft, degrees);
    	SmartDashboard.putBoolean("Ran", true);
    }

}
