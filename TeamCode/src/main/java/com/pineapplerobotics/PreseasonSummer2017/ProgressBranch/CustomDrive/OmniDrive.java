package com.pineapplerobotics.PreseasonSummer2017.ProgressBranch.CustomDrive;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by Brandon on 3/31/2017.
 */

class OmniDrive extends RobotDrive {


    @Override
    String driveType() {
        String type = "OmniDrive";
        return type;
    }

    @Override
    Boolean gamepadDrive(DcMotor[] Motors, Gamepad gamepad) {
        if (Motors.length == 4) {

            return true;
        } else {
            return false;
        }
    }

    @Override
    Boolean drive(DcMotor[] Motors, double[] speeds) {
        return null;
    }

    @Override
    void driveScale(double scale) {

    }

    @Override
    void enableDrive(boolean onoff) {

    }

    @Override
    void exponentialDriving(boolean onoff) {

    }

    @Override
    void driveRange(double MinDriveValue, double MaxDriveValue) {

    }

    @Override
    String driveError() {
        return null;
    }

    @Override
    double getDriveScale() {
        return 0;
    }

    @Override
    boolean isDriveEnabled() {
        return false;
    }

    @Override
    boolean isExponentialDrive() {
        return false;
    }

    @Override
    double getMaxDriveValue() {
        return 0;
    }

    @Override
    double getMinDriveValue() {
        return 0;
    }
}

