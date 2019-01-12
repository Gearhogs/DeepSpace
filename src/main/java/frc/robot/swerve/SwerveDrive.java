package frc.robot.swerve;

import frc.robot.RobotMap;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SwerveDrive extends Subsystem {
	
	public SwerveModule frontLeft;
	public SwerveModule frontRight;
	public SwerveModule backLeft;
	public SwerveModule backRight;
	
	PigeonIMU gyro;
	
	private SwerveProfile currentSwerveProfile;
	
	public SwerveDrive() {
		frontLeft = new SwerveModule(RobotMap.frontLeftDriveMotor, RobotMap.frontLeftRotateMotor, 1159, SwervePosition.FRONTLEFT);
		frontRight = new SwerveModule(RobotMap.frontRightDriveMotor, RobotMap.frontRightRotateMotor, 5921, SwervePosition.FRONTRIGHT);
		backLeft = new SwerveModule(RobotMap.backLeftDriveMotor, RobotMap.backLeftRotateMotor, 5049, SwervePosition.BACKLEFT);
		backRight = new SwerveModule(RobotMap.backRightDriveMotor, RobotMap.backRightRotateMotor, 1629, SwervePosition.BACKRIGHT);
		gyro = new PigeonIMU(RobotMap.gyro);
	}
	
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void SetAllModules(double FLRotation, double FRRotation, double BLRotation, double BRRotation) {
		frontLeft.Rotate(FLRotation);
		frontRight.Rotate(FRRotation);
		backLeft.Rotate(BLRotation);
		backRight.Rotate(BRRotation);
	}
	public void CrabDrive(double degrees, double power) {
		
		frontLeft.Rotate(degrees);
		frontRight.Rotate(degrees);
		backLeft.Rotate(degrees);
		backRight.Rotate(degrees);
		
		frontLeft.Speed(power);
		frontRight.Speed(power);
		backLeft.Speed(power);
		backRight.Speed(power);
	}
	public void SwingDrive(double degrees, double power) {
		
		frontLeft.Rotate(degrees);
		frontRight.Rotate(degrees);
		backLeft.Rotate(degrees);
		backRight.Rotate(degrees);
		
		frontLeft.Speed(power);
		frontRight.Speed(power);
		backLeft.Speed(power);
		backRight.Speed(power);
	}
	public void RotateDrive(double degrees, double power) {
		
		frontLeft.Rotate(degrees);
		frontRight.Rotate(degrees);
		backLeft.Rotate(degrees);
		backRight.Rotate(degrees);
		
		frontLeft.Speed(power);
		frontRight.Speed(power);
		backLeft.Speed(power);
		backRight.Speed(power);
	}
	public void TankDrive(double leftPower, double rightPower) {
		
		frontLeft.Speed(leftPower);
		frontRight.Speed(rightPower);
		backLeft.Speed(leftPower);
		backRight.Speed(rightPower);
	}
	public void setDriveX() {
		frontLeft.Rotate(45);
		frontRight.Rotate(-45);
		backLeft.Rotate(-45);
		backRight.Rotate(45);
	}
	public void setDriveToTurn() {
		frontLeft.Rotate(45);
		frontRight.Rotate(-45);
		backLeft.Rotate(45);
		backRight.Rotate(-45);
	}
	public void resetDrive() {
		frontLeft.Rotate(0);
		backLeft.Rotate(0);
		frontRight.Rotate(0);
		backRight.Rotate(0);
	}
	public void setDriveSpeed(double power) {
		frontLeft.Speed(power);
		frontRight.Speed(power);
		backLeft.Speed(power);
		backRight.Speed(power);
		
	}
	public void stopDrive() {
		frontLeft.Speed(0);
		frontRight.Speed(0);
		backLeft.Speed(0);
		backRight.Speed(0);
	}
	public void setHeadlessCrabDrive(double degrees, double power) {
		gyro.setCompassAngle(0);		
		frontLeft.Rotate(degrees);
		frontRight.Rotate(degrees);
		backLeft.Rotate(degrees);
		backRight.Rotate(degrees);
		
		frontLeft.Speed(power);
		frontRight.Speed(power);
		backLeft.Speed(power);
		backRight.Speed(power);
		
	}
	
	public void rotateSwerveModule(SwerveModule myModule, double degrees) {
		myModule.Rotate(degrees);
	}
	public SwerveProfile getCurrentSwerveProfile() {
		return currentSwerveProfile;
	}
	public void setCurrentSwerveProfile(SwerveProfile currentSwerveProfile) {
		this.currentSwerveProfile = currentSwerveProfile;
	}
	public void Debug() {
		frontLeft.Debug();
		frontRight.Debug();
		backLeft.Debug();
		backRight.Debug();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new frc.robot.swerve.commands.CrabDrive());
    }
	
}

