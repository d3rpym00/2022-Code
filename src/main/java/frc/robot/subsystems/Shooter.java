// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.SparkMaxPIDController.ArbFFUnits;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
  // Spark Max Motor Controller Object
  CANSparkMax m_shooterMotorLeader =
      new CANSparkMax(ShooterConstants.kShooterMotorLeaderPort, MotorType.kBrushless);
  CANSparkMax m_shooterMotorFollower =
      new CANSparkMax(ShooterConstants.kShooterMotorFollowerPort, MotorType.kBrushless);

  // Spark Max PID Controller Object
  private SparkMaxPIDController m_shooterController = m_shooterMotorLeader.getPIDController();

  // Feed Forward Calculator
  private SimpleMotorFeedforward m_flywheelFeedforward =
      new SimpleMotorFeedforward(ShooterConstants.kS, ShooterConstants.kV, ShooterConstants.kA);

  // Stores Target RPM
  private double targetRPM = 0;

  /** Creates a new Shooter */
  public Shooter() {
    m_shooterMotorLeader.setInverted(true);
    m_shooterMotorFollower.follow(m_shooterMotorLeader, true);
    m_shooterController.setP(ShooterConstants.kP);
  }

  // Sets the RPM to the specified parameter
  public void setRPM(int RPM) {
    targetRPM = RPM;
  }

  // Checks if the shooter motors have reached their target velocity
  public boolean atTargetRPM() {
    double actualRPM = m_shooterMotorLeader.getEncoder().getVelocity();
    return Math.abs(actualRPM - targetRPM) < ShooterConstants.kShooterRPMThreshold;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter RPM", m_shooterMotorLeader.getEncoder().getVelocity());
    double feedForward = m_flywheelFeedforward.calculate(targetRPM / 60);
    m_shooterController.setReference(
        targetRPM, ControlType.kVelocity, 0, feedForward, ArbFFUnits.kVoltage);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
