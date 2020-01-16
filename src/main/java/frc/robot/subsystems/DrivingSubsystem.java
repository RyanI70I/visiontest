/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Notifier;
import com.ctre.phoenix.motion.*;
import frc.robot.helpers.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import jaci.pathfinder.Trajectory.Segment;



public class DrivingSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */
	
  	public double baseDriveSpeed = 0.90;
	public static DifferentialDrive drive;
	public static WPI_TalonSRX leftFrontDriveTalon;
	public static WPI_TalonSRX leftBackDriveTalon;
	public static WPI_TalonSRX rightFrontDriveTalon;
	public static WPI_TalonSRX rightBackDriveTalon;

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void drive(double ySpeed, double rotation) {
		
		if(Math.abs(ySpeed) > 1)
			ySpeed = Math.abs(ySpeed) / ySpeed; // if the value given was too high, set it to the max
		ySpeed *= baseDriveSpeed; // scale down the speed
		
		
		if(Math.abs(rotation) > 1)
			rotation = Math.abs(rotation) / rotation; // if the value given was too high, set it to the max
		rotation *= baseDriveSpeed; // scale down the speed
		
		drive.arcadeDrive(ySpeed, rotation); // function provided by the  controls y and turn speed at the same time.
	}

  public static void initDrive() {
		leftFrontDriveTalon  = new WPI_TalonSRX(Constants.LEFT_FRONT_DRIVE_TALON_PORT);
		leftBackDriveTalon   = new WPI_TalonSRX(Constants.LEFT_BACK_DRIVE_TALON_PORT);
		rightFrontDriveTalon = new WPI_TalonSRX(Constants.RIGHT_FRONT_DRIVE_TALON_PORT);
		rightBackDriveTalon  = new WPI_TalonSRX(Constants.RIGHT_BACK_DRIVE_TALON_PORT);
		leftFrontDriveTalon.setExpiration(.1);
		leftBackDriveTalon.setExpiration(.1);
		rightBackDriveTalon.setExpiration(.1);
		rightFrontDriveTalon.setExpiration(.1);
		leftBackDriveTalon.follow(leftFrontDriveTalon);
		rightBackDriveTalon.follow(rightFrontDriveTalon);
		rightBackDriveTalon.setInverted(false);
		leftBackDriveTalon.setInverted(true);
		rightFrontDriveTalon.setInverted(false);
		drive = new DifferentialDrive(leftFrontDriveTalon, rightFrontDriveTalon);
		drive.setDeadband(0);
	}
	// Directly set the speed of the talons to 0. If a command that sets the speed is still running, this won't stop it.
	public void stop() {
		leftFrontDriveTalon.set(0);
		rightFrontDriveTalon.set(0);
	}
}