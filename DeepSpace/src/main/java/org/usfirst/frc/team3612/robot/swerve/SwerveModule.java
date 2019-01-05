package org.usfirst.frc.team3612.robot.swerve;

import org.usfirst.frc.team3612.robot.Conversion;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwerveModule extends Subsystem {
	
	protected TalonSRX driveMotor;
	private TalonSRX rotateMotor;
	private SwervePosition position;
	private int offset;
	private int currentHeading;
	
	
    public SwerveModule(int drive, int rotate, int encoderValue, SwervePosition pos) {
    	driveMotor = new TalonSRX(drive);
    	rotateMotor = new TalonSRX(rotate);
    	
    	rotateMotor.configSelectedFeedbackSensor(FeedbackDevice.PulseWidthEncodedPosition, 0, 0);
    	rotateMotor.
    	//rotateMotor.configForwardSoftLimitThreshold((int) Conversion.DegreesToTicks(-180) + offset, 10);
    	//rotateMotor.configReverseSoftLimitThreshold((int) Conversion.DegreesToTicks(180) + offset, 10);
    	//rotateMotor.configForwardSoftLimitEnable(true);
    	//rotateMotor.configReverseSoftLimitEnable(true);
    	rotateMotor.set(ControlMode.Position, offset);
    	
    	
    	//offset = encoderValue;
    	offset = rotateMotor.getSensorCollection().getPulseWidthPosition();
    	setPosition(pos);
    }

    public void Rotate(double degrees) {
//    	double desiredTarget = 0;
//    	
//    	if (degrees > 0) {
//    		desiredTarget = Conversion.DegreesToTicks(degrees) + offset;
//    		
//    	}
//    	else if (degrees  < 0) {
//    		desiredTarget = offset - Conversion.DegreesToTicks(degrees);
//    	}
//    	else {
//    		desiredTarget = offset;
//    	}
    	rotateMotor.set(ControlMode.Position, Conversion.DegreesToTicks(degrees) + offset);
    }
    
    public void Speed(double power) {
    	driveMotor.set(ControlMode.PercentOutput, power);	
    }
    
    public void Debug() {
    	SmartDashboard.putNumber(getPositionString() + " rotation = ", rotateMotor.getSensorCollection().getPulseWidthPosition());
    	SmartDashboard.putNumber("Speed = ", driveMotor.getMotorOutputPercent());
    	SmartDashboard.putString("Position = ", getPositionString());
    	SmartDashboard.putNumber(getPositionString() + "Setpoint: ", rotateMotor.getClosedLoopTarget());
    	SmartDashboard.putNumber(getPositionString() + "Offset: ", offset);
    }
    
	public SwervePosition getPosition() {
		return position;
	}
	public String getPositionString() {
		switch (position) {
		case FRONTLEFT:
			return "frontLeft";
		case FRONTRIGHT:
			return "frontRight";
		case BACKLEFT:
			return "backLeft";
		case BACKRIGHT:
			return "backRight";
		default:
			return null;
		}
	}

	public void setPosition(SwervePosition position) {
		this.position = position;
	}
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}

