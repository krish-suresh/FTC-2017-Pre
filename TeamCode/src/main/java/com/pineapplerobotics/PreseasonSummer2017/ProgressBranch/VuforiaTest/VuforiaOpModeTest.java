
package com.pineapplerobotics.PreseasonSummer2017.ProgressBranch.VuforiaTest;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

/**
 * Created by Brandon on 3/31/2017.
 */

@TeleOp(name = "Vuforia", group = "Linear Opmode")

public class VuforiaOpModeTest extends com.qualcomm.robotcore.eventloop.opmode.LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();



    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();



        waitForStart();
        runtime.reset();
        while (opModeIsActive()) {
            telemetry.addData("Status", "Run : " + runtime.toString());
            telemetry.update();



        }
    }

}

