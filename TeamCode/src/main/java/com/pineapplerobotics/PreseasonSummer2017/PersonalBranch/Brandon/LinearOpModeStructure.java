package com.pineapplerobotics.PreseasonSummer2017.PersonalBranch.Brandon;

import com.pineapplerobotics.PreseasonSummer2017.ProgressBranch.CustomDrive.RobotDrive;
import com.pineapplerobotics.PreseasonSummer2017.ProgressBranch.CustomDrive.TankDrive;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Brandon on 3/31/2017.
 */

public class LinearOpModeStructure {
    @TeleOp(name = "Tele", group = "Linear Opmode")
    @Disabled
    public class Abstract_Drive_Test extends LinearOpMode {

        private ElapsedTime runtime = new ElapsedTime();
        DcMotor LeftMotor;
        DcMotor RightMotor;

        RobotDrive r = new TankDrive();

        @Override
        public void runOpMode() throws InterruptedException {
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            LeftMotor = hardwareMap.dcMotor.get("Left");
            RightMotor = hardwareMap.dcMotor.get("right");

            waitForStart();
            runtime.reset();

            while (opModeIsActive()) {
                telemetry.addData("Status", "Run : " + runtime.toString());
                telemetry.update();
                r.gamepadDrive(new DcMotor[]{LeftMotor, RightMotor},gamepad1);
            }
        }

    }
}
