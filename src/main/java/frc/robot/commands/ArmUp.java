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

public class ArmUp extends Command {

  private boolean isUp;

  public ArmUp() {
    requires(Robot.INTAKE_ARM);
    isUp = false;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.INTAKE_ARM.setArmMotor(-RobotMap.INTAKE_LIFT_SPEED);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    isUp = Robot.INTAKE_ARM.up();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isUp;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.INTAKE_ARM.setArmMotor(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.INTAKE_ARM.setArmMotor(0.0);
  }
}
