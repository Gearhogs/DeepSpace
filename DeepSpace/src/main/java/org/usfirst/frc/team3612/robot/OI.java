/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3612.robot;

import org.usfirst.frc.team3612.robot.swerve.commands.SetSwerveModuleRotation;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick leftJoystick = new Joystick(0);
	Joystick rightJoystick = new Joystick(1);
	
	Button switchToCrab = new JoystickButton(leftJoystick, 1);
	Button setRotationTo90 = new JoystickButton(rightJoystick,2);
	Button setRotationTo0 = new JoystickButton(rightJoystick, 3);
	
	public OI() {
		//switchToCrab.whenPressed(new CrabDrive());
		setRotationTo90.whenPressed(new SetSwerveModuleRotation(4096*5));
		setRotationTo0.whenPressed(new SetSwerveModuleRotation(0));
	}
	
	public Joystick getLeftJoystick() {
		return leftJoystick;
	}
	public Joystick getRightJoystick() {
		return rightJoystick;
	}
	public double getAngle(Joystick joystick) {
		return joystick.getDirectionDegrees();
	}
	public double getMagnitude(Joystick joystick) {
		return Math.sqrt((joystick.getX() * joystick.getX()) + (joystick.getY() * joystick.getY()));
	}
	public void Debug() {
    	SmartDashboard.putNumber("Magnitude = ", getMagnitude(leftJoystick));
    	SmartDashboard.putNumber("Angle = ", getAngle(leftJoystick));
    	SmartDashboard.putNumber("x: ", leftJoystick.getX());
    	SmartDashboard.putNumber("y: ", leftJoystick.getY());
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
