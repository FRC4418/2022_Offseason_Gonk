// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

import com.stuypulse.stuylib.input.Gamepad;
import com.stuypulse.stuylib.streams.IStream;

public class climberUp extends CommandBase {
  private Climber climber;
  private double startTime;
 

  public climberUp(Climber climber) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.climber = climber;
    

    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    climber.servoRelease();
    startTime = Timer.getFPGATimestamp();
      
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (startTime + 0.2 < Timer.getFPGATimestamp()) {
      climber.armsDown();
      climber.ratchetRelease();
    }
    else {
      climber.armsUp();   
     }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climber.ending();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}