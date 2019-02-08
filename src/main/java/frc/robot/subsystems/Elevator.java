/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorMoveCommand;

/**
 * Elevator Subsystem Code
 */
public class Elevator extends Subsystem {
  
  private final double[] ENCODER_INCREMENTS = {30, 10};
  private final double MAX_HEIGHT = 300;
  private int state = 0;

  // Hardware Inits
  private WPI_TalonSRX pulleyMotor;

  public Elevator() {
    this.pulleyMotor = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR);

    pulleyMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		pulleyMotor.setSensorPhase(true);
    pulleyMotor.setSelectedSensorPosition(0, 0, 10);
  }

  public void increment() {
    //increments the distance by either 30 or 10, depending on even or odd.
    double encoderValue = getEncoderDistance() + ENCODER_INCREMENTS[state % 2];
    if(encoderValue > MAX_HEIGHT) {
      encoderValue = MAX_HEIGHT;
    } else {
      state++;
    }

    setMotorPosition(encoderValue);
  }

  public void decrement() {
    //increments the distance by either 30 or 10, depending on even or odd.
    double encoderValue = getEncoderDistance() - ENCODER_INCREMENTS[state % 2];
    if(encoderValue < 0) {
      encoderValue = 0;
    } else {
      state--;
    }

    setMotorPosition(encoderValue);
  }

  public double getEncoderDistance() { return pulleyMotor.getSelectedSensorPosition(); }

  public void setMotorPosition(double position) { pulleyMotor.set(ControlMode.Position, position); }

  public void setMotorSpeed(double speed) { pulleyMotor.set(ControlMode.Velocity, speed); }

  public void stopMotor() { pulleyMotor.set(ControlMode.Current, 0); }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ElevatorMoveCommand());
  }
}
