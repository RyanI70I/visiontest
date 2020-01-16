package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DirectDriveCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.Limelghtsub;



public class RobotContainer {

    //public XboxController1 controller1;
    XboxController controller2 = new XboxController(Constants.XBOX_CONTROLLER_2_PORT);
    XboxController controller1 = new XboxController(Constants.XBOX_CONTROLLER_1_PORT);

   

    DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
    Limelghtsub limelight = new Limelghtsub();
    public RobotContainer(){
        configureButtonBindings();
        

        drivingSubsystem.setDefaultCommand(
            new DirectDriveCommand(
                drivingSubsystem,
                () -> getDrive(),
                () -> getTurn()));
    }
  
    public double getTurn() {
		double n = controller1.getX(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.1 ? 0 : n;
    }
    public double getDrive() {
		double n = controller1.getTriggerAxis(GenericHID.Hand.kRight) - controller1.getTriggerAxis(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.1 ? 0 : n;
	}
    private void configureButtonBindings() {
        //final JoystickButton encoderButton = new JoystickButton(controller2, XboxController.Button.kY.value);
        final JoystickButton test = new JoystickButton(controller1, XboxController.Button.kX.value);
        test.whenHeld(new Pathfind(limelight, drivingSubsystem, "loadDock"));
        
        //encoderButton.whenPressed(new SetEncoderCommand(encoderSubsystem));
        //encoderButton.whenReleased(new TurnoffEncoderCommand(encoderSubsystem));
    }
  
  
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
//     public Command getAutonomousCommand() {
//       // An ExampleCommand will run in autonomous
//      // return m_autoCommand;
//     }
 }