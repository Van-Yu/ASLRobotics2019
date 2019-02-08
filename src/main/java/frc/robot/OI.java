/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public final Joystick DRIVER = new Joystick(RobotMap.DRIVER_CONTROL_PORT);
  public final Joystick OPERATOR = new Joystick(RobotMap.OPERATOR_CONTROL_PORT);

  private final JoystickButton CARGO_BUTTON = new JoystickButton(OPERATOR, RobotMap.CARGO_BUTTON_PORT);

  private final JoystickButton HATCH_BUTTON = new JoystickButton(OPERATOR, RobotMap.HATCH_BUTTON_PORT);

  private final JoystickButton ELEVATOR_UP_BUTTON = new JoystickButton(OPERATOR, RobotMap.ELEVATOR_UP_BUTTON_PORT);
  private final JoystickButton ELEVATOR_DOWN_BUTTON = new JoystickButton(OPERATOR, RobotMap.ELEVATOR_DOWN_BUTTON_PORT);

  public OI() {
    CARGO_BUTTON.whileHeld(new StartWheels());
    CARGO_BUTTON.whenPressed(new ArmUp());
    CARGO_BUTTON.whenReleased(new ArmDown());

    HATCH_BUTTON.whenPressed(new HatchCommand());

    // ELEVATOR_UP_BUTTON.whenPressed(new ElevatorIncrement());
    // ELEVATOR_DOWN_BUTTON.whenPressed(new ElevatorDecrement());
  }


}
