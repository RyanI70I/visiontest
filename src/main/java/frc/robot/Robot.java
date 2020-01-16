/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DrivingSubsystem;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  public static final DrivingSubsystem drivingSubsystem = new DrivingSubsystem();

  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  public static RobotContainer oi;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  WPI_TalonSRX leftMotors = new WPI_TalonSRX(2);
  WPI_TalonSRX rightMotors = new WPI_TalonSRX(3);
  RobotContainer OI = new RobotContainer();
  public DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    Robot.oi = new RobotContainer();
  
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    
		// Constants.rightEncoder.reset();
		// Constants.leftEncoder.reset();
     drivingSubsystem.initDrive();
     


	
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    
  }
	@Override
	public void disabledInit() {
	//	Robot.drivingSubsystem.stop();
	
	}
  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
	System.out.println("Auto selected: " + m_autoSelected);



  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  
	//    // Assuming no wheel slip, the difference in encoder distances is proportional to the heading error
	//    double error = Constants.leftEncoder.getDistance() - Constants.rightEncoder.getDistance();

	//    // Drives forward continuously at half speed, using the encoders to stabilize the heading
	//   System.out.println(Constants.leftEncoder.getDistance());
	//   System.out.println(Constants.rightEncoder.getDistance());

	//    if(Constants.leftEncoder.get() < 1000 && Constants.rightEncoder.get() < 1000 ) {
    //     drive.tankDrive(.5 + 1 * error, .5 - 1 * error);
    // } else {
    //     drive.tankDrive(0, 0);
    // }
    // switch (m_autoSelected) {
    //   case kCustomAuto:
    //     // Put custom auto code here
    //     break;
    //   case kDefaultAuto:
    //   default:
    //     // Put default auto code here
    //     break;
    }
  

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    
    
    String gameData;
gameData = DriverStation.getInstance().getGameSpecificMessage();
if(gameData.length() > 0)
{
  switch (gameData.charAt(0))
  {
    case 'B' :
      //Blue case code
      SmartDashboard.putString("Blue","B");
      break;
    case 'G' :
      //Green case code
      SmartDashboard.putString("Green","G");

      break;
    case 'R' :
      //Red case code
      SmartDashboard.putString("Red","R");

      break;
    case 'Y' :
      //Yellow case code
      SmartDashboard.putString("Yellow","Y");

      break;
    default :
      //This is corrupt data
      break;
  }
} else {
  //Code for no data received yet
}
CommandScheduler.getInstance().run();


  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
