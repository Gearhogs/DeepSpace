package frc.robot.swerve;

import frc.robot.Conversion;

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
    }

    public void Rotate(double degrees) {
    	rotateMotor.set(ControlMode.Position, Conversion.DegreesToTicks(degrees) + offset);
    }
    
    public void Speed(double power) {
    	driveMotor.set(ControlMode.PercentOutput, power);	
    }
    
    public void Debug() {
    	
    }
    
	public SwervePosition getPosition() {
		return position;
	}
	public String getPositionString() {
		switch (position) {
		case FRONTLEFT:
			return "FrontLeft";
		case FRONTRIGHT:
			return "FrontRight";
		case BACKLEFT:
			return "BackLeft";
		case BACKRIGHT:
			return "BackRight";
		default:
			return "";
		}
	}
	public boolean getLimitSwitch() {
		return false;
	}
	public void setPosition(SwervePosition position) {
		this.position = position;
	}
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	}
}

