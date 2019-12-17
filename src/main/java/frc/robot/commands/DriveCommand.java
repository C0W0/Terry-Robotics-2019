/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveCommand extends Command {
  private double leftStickY;
  private double rightStickX;

  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    leftStickY = Robot.m_oi.getDriverRawAxis(RobotMap.driverAxis);
    rightStickX = Robot.m_oi.getSteeringRawAxis(RobotMap.steeringAxis);
    if(rightStickX >= 0){
      Robot.driveSubsystem.setRightMotors(leftStickY-0.9*rightStickX);
      Robot.driveSubsystem.setLeftMotors(leftStickY);
    }
    if(rightStickX <= 0){
      Robot.driveSubsystem.setRightMotors(rightStickX+0.9*rightStickX);
      Robot.driveSubsystem.setLeftMotors(leftStickY);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveSubsystem.setLeftMotors(0);
    Robot.driveSubsystem.setRightMotors(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}
