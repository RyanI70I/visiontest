/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.Limelghtsub;

import frc.robot.helpers.trajectoryHelper;
public class Pathfind extends CommandBase {
  /**
   * Creates a new Pathfind.
   */
  private final Limelghtsub limelight;
  private final DrivingSubsystem drivingSubsystem;
  private String place = "";
  public Trajectory trajectory;
  private int i = 0;
  public int loaded = 0;
  public double distence = 0;
  public Pathfind(Limelghtsub subsystem, DrivingSubsystem subsystem2, String Place) {
    drivingSubsystem = subsystem2;
    limelight = subsystem;
    addRequirements(limelight);
    place = Place;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    i = 0;
    loaded = 0;
    distence = limelight.getDistence();
    
    if("loadDock" == place){
      System.out.println("ran1");
      trajectory = trajectoryHelper.testing();
      System.out.println("ran2");
  }

  

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    
        

      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
