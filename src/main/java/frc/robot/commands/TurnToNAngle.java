// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainEpicGrok;
import edu.wpi.first.math.MathUtil;

public class TurnToNAngle extends CommandBase {
  /** Creates a new TurnToNAngle. */
  private double targetAngle;
  private final DriveTrainEpicGrok m_driveTrainEpicGrok;
  private double currentAngle;

  public TurnToNAngle(double targetAngle, DriveTrainEpicGrok subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.targetAngle = targetAngle;
    m_driveTrainEpicGrok = subsystem;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    currentAngle = m_driveTrainEpicGrok.getAngle();

    double error = targetAngle - currentAngle;
    modAngle(error);

    double outputSpeed = m_driveTrainEpicGrok.kP * error;
    outputSpeed = MathUtil.clamp(outputSpeed, -0.5, 0.5);

    m_driveTrainEpicGrok.setMotors(-outputSpeed, outputSpeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (currentAngle >= targetAngle) {
      return true;
    }
    return false;
  }

  public double modAngle(double value) {
    return ((value + 180) % 360) - 180;
  }
}
