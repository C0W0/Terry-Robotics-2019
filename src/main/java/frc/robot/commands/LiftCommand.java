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

public class LiftCommand extends Command {
  private boolean isGoingUp;
  private boolean isGoingDown;
  private boolean isUpLimitHit;
  //private boolean isDownLimitHit;

  public LiftCommand() {
    requires(Robot.liftSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    isGoingUp = Robot.m_oi.getLiftUpButton();
    isGoingDown = Robot.m_oi.getLiftDownButton();
    isUpLimitHit = Robot.m_oi.getUpLimitStatus();
    if (isGoingUp && !isUpLimitHit){
      Robot.liftSubsystem.liftMove(RobotMap.liftRange);
    } else if (isGoingDown){
      Robot.liftSubsystem.liftMove(-1*(RobotMap.liftRange));
    } else{
      double liftStickY = Robot.m_oi.getLifterRawAxis(RobotMap.liftAxis);
      Robot.liftSubsystem.liftMove(liftStickY);
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
    Robot.liftSubsystem.liftMove(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}
