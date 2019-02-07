/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class IntakeArm extends Subsystem {
  private WPI_TalonSRX armMotor;
  private WPI_TalonSRX wheelMotor;
  private DigitalInput armDown;
  private DigitalInput armUp;

  public IntakeArm(){
    armMotor = new WPI_TalonSRX(RobotMap.INTAKE_LIFT_MOTOR);
    wheelMotor = new WPI_TalonSRX(RobotMap.INTAKE_MOTOR);
    armDown = new DigitalInput(RobotMap.INTAKE_DOWN_LIMIT);
    armUp = new DigitalInput(RobotMap.INTAKE_UP_LIMIT);
  }

  public void setArmMotor(Double speed){
    armMotor.set(speed);
  }

  public void setWheelMotor(Double speed){
    wheelMotor.set(speed);
  }

  public boolean up(){
    boolean hit = armUp.get();
    return hit;
  }

  public boolean down(){
    boolean hit = armDown.get();
    return hit;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
