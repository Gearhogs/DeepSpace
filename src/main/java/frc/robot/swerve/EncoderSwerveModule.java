package frc.robot.swerve;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 *
 */
public class EncoderSwerveModule extends SwerveModule {

    public EncoderSwerveModule(int drive, int rotate, int encoderValue, SwervePosition pos) {
		super(drive, rotate, encoderValue, pos);
		// TODO Auto-generated constructor stub
	}

    public void SetVelocityControl(double speed) {
    	driveMotor.set(ControlMode.Velocity, speed);
    }
    
    public void SetPercentOutput(double speed) {
    	driveMotor.set(ControlMode.PercentOutput, speed);
    }
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

