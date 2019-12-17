/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public DriveCommand driveCommand;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(driveCommand = new DriveCommand());
  }

  public void setLeftFrontMotor(double range){
    RobotMap.motorLeftFront.set(ControlMode.PercentOutput,range);
  }
  public void setLeftBackMotor(double range){
    RobotMap.motorLeftBack.set(ControlMode.PercentOutput,range);
  }
  public void setRightFrontMotor(double range){
    RobotMap.motorRightFront.set(ControlMode.PercentOutput,range);
  }
  public void setRightBackMotor(double range){
    RobotMap.motorRightBack.set(ControlMode.PercentOutput,range);
  }

  public void setLeftMotors(double range){
    RobotMap.motorLeftFront.set(ControlMode.PercentOutput,range);
    RobotMap.motorLeftBack.set(ControlMode.PercentOutput, range);
  }
  public void setRightMotors(double range){
    RobotMap.motorRightFront.set(ControlMode.PercentOutput,range);
    RobotMap.motorRightBack.set(ControlMode.PercentOutput, range);
  }

}
