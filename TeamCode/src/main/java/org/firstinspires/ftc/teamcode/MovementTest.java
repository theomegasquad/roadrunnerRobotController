package org.firstinspires.ftc.teamcode;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
@TeleOp(name = "MovementTest")

public class MovementTest extends LinearOpMode {
  @Override
  public void runOpMode() {
    SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

    Pose2d startPose = new Pose2d(-36, 60, 0);

    drive.setPoseEstimate(startPose);

    Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d())
            .forward(30)

            .build();

    waitForStart();

    if(isStopRequested()) return;

    drive.followTrajectory(myTrajectory);
  }
}