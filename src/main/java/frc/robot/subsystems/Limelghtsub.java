/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import java.util.List;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.lang.module.ModuleDescriptor.Modifier;
import java.util.ArrayList;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import jaci.pathfinder.modifiers.TankModifier;

public class Limelghtsub extends SubsystemBase {
  /**
   * Creates a new Limelghtsub.
   */

  public Limelghtsub() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void getRawY(){
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry ty = table.getEntry("ty");
    double y = ty.getDouble(0.0);
    System.out.println(y);
  }
  public double getDistence(){
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry ty = table.getEntry("ty");
    double y = ty.getDouble(0.0);
    double distence = 23.2576688011 + Math.abs(y);
    distence = Math.toRadians(distence);
    distence = Math.tan(distence);
    distence = 41/distence;
    return distence;
  }
}
