package org.usfirst.frc.team6419.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically it 
 * contains the code necessary to operate a robot with tank drive.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're inexperienced,
 * don't. Unless you know what you are doing, complex code will be much more difficult under
 * this system. Use IterativeRobot or Command-Based instead if you're new.
 */
public class Robot extends SampleRobot {
    RobotDrive myRobot;  // class that handles basic drive operations
    Joystick logitech;
    Talon shooterThing;
    double leftStick;
    double rightStick;
    double armPower;
    public Robot() {
        myRobot = new RobotDrive(2,1,4,3);
        myRobot.setExpiration(0.1);
        shooterThing = new Talon(7);
        logitech = new Joystick(0);
        leftStick = logitech.getRawAxis(1);
        rightStick = logitech.getRawAxis(5);
        //armPower = logitech.get

    }

    
    /**
     * Runs the motors with tank steering.
     */
    public void operatorControl() {
        myRobot.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
        	double rawL = logitech.getRawAxis(1);
        	double rawR = logitech.getRawAxis(5);
        	SmartDashboard.putString("Left value", String.valueOf(rawL));
        	SmartDashboard.putString("Right value", String.valueOf(rawR));
            leftStick = rawL>0?-Math.pow(rawL, 2)*36:Math.pow(rawL, 2)*36;
            rightStick = rawR>0?-Math.pow(rawR, 2)*36:Math.pow(rawR, 2)*36;
        	SmartDashboard.putString("Left corrected value", String.valueOf(leftStick));
        	SmartDashboard.putString("Right corrected value", String.valueOf(rightStick));
        	myRobot.tankDrive(leftStick, rightStick);
        	if(logitech.getRawButton(3)) shooterThing.set(1);
        	else if(logitech.getRawButton(1)) shooterThing.set(-.2);
        	else shooterThing.set(0);
            Timer.delay(0.005);		// wait for a motor update time
        }
    }

}
