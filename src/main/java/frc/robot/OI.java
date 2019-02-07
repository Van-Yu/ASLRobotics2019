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

  public final Joystick DRIVER = new Joystick(0);
  public final Joystick OPERATOR = new Joystick(1);

  private final JoystickButton DEPLOY_ARM = new JoystickButton(OPERATOR, 1);
  private final JoystickButton RETRACT_ARM = new JoystickButton(OPERATOR, 2);


  public OI() {
    DEPLOY_ARM.whileHeld(new BeginIntake());
    DEPLOY_ARM.whenPressed(new ArmUp());
    RETRACT_ARM.whenPressed(new ArmDown());
  }


}
