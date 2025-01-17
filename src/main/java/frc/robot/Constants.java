// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class ShooterConstants {
    public static final int kShooterMotorLeaderPort = 1;
    public static final int kShooterMotorFollowerPort = 2;
    public static final int kShooterFenderRPM = 1950;
    public static final int kShooterRPMThreshold = 50;
    public static final double kPower = 0.6;
    public static final double kS = 0.23638;
    public static final double kV = 0.1292;
    public static final double kA = 0.0094019;
    public static final double kP = 0.0001;
  }

  public static final class ControllerConstants {
    public static final int kNavigatorPort = 0;
    public static final int kOperatorPort = 1;
  }

  public static final class IntakeConstants {
    public static final int kIntakeSolenoidPorts[] = {1, 0};
    public static final int kIntakeMotorPort = 10;
    public static final int kIntakeVoltage = 6;
  }

  public static final class IndexerConstants {
    public static final int kProximitySensorPort = 0;
    public static final int kBallElevatorPort = 20;
    public static final int kIndexerPort = 21;

    public static final double kPassivePower = 4;
    public static final double kFeedingPower = 5;
    public static final double kIndexerPower = 7;
    public static final int kIndexerShootingTimeout = 4;
  }

  public static final class DrivetrainConstants {
    public static final int kLeftSRXDrivePort = 1;
    public static final int kLeftSPXDrivePort = 2;
    public static final int kRightSRXDrivePort = 3;
    public static final int kRightSPXDrivePort = 4;

    public static final double kDriveForwardMultiplier = 0.8;
    public static final double kDriveTurnMultiplier = 0.8;
  }
}
