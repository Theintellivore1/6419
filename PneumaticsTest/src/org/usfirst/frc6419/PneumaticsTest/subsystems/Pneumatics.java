// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6419.PneumaticsTest.subsystems;

import org.usfirst.frc6419.PneumaticsTest.RobotMap;
import org.usfirst.frc6419.PneumaticsTest.commands.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Pneumatics extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Compressor compressor1 = RobotMap.pneumaticsCompressor1;
    private final DoubleSolenoid doubleSolenoid1 = RobotMap.pneumaticsDoubleSolenoid1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void stopAll(){
    	SmartDashboard.putBoolean("Foreward on:", false);
    	SmartDashboard.putBoolean("Backward on:", false);
    	doubleSolenoid1.set(DoubleSolenoid.Value.kOff);
    }
    public void goForward(){
    	SmartDashboard.putBoolean("Foreward on:", true);
    	SmartDashboard.putBoolean("Backward on:", false);
    	doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
    }
    public void goBackward(){
    	SmartDashboard.putBoolean("Foreward on:", false);
    	SmartDashboard.putBoolean("Backward on:", true);
    	doubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
    }
    public void init(){
    	compressor1.setClosedLoopControl(true);
    	stopAll();
    }
    public boolean isCompressing(){
    	return compressor1.enabled();
    }
}

