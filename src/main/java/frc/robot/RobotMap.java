/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static VictorSPX moterLift;
	public static VictorSPX motorLeftFront;
	public static VictorSPX motorLeftBack;
	public static VictorSPX motorRightFront;
	public static VictorSPX motorRightBack;


	public static final int leftFrontID = 9;
	public static final int leftBackID = 10;
	public static final int rightFrontID = 11;
	public static final int rightBackID = 12;
	public static final int joystickController = 0;
	// public static final int LeftSrickYAxis = 1;
	// public static final int RightSrickYAxis = 5;
	public static final int motorLiftID = 8;
	public static final int liftUpButton = 4;
	public static final int liftDownButton = 2;
	public static final int liftAxis = 1;
	public static final int liftUpLimit = 4;
	public static final double liftRange = 0.02;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static void init(){
		moterLift = new VictorSPX(RobotMap.motorLiftID);
		motorLeftFront = new VictorSPX(RobotMap.leftFrontID);
		motorLeftFront = new VictorSPX(RobotMap.leftBackID);
		motorLeftFront = new VictorSPX(RobotMap.rightFrontID);
		motorLeftFront = new VictorSPX(RobotMap.rightBackID);
  	}
}
