package com.pineapplerobotics.PreseasonSummer2017.ProgressBranch;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

abstract class RobotDrive {
    //Gets Inforamtion
    abstract String driveType();

    abstract String driveError();

    abstract double getDriveScale();

    abstract boolean isDriveEnabled();

    abstract boolean isExponentialDrive();

    abstract double getMaxDriveValue();

    abstract double getMinDriveValue();

    //Main Drive Function
    //Input should be drive(new DcMotor[]{Left, Right},gamepad1);
    //or drive(new DcMotor[]{LeftFront, RightFront, LeftBack, RightBack},gamepad1);
    //returns true for sucess
    abstract Boolean gamepadDrive(DcMotor[] Motors, Gamepad gamepad);

    abstract Boolean drive(DcMotor[] Motors, double[] speeds);

    //Drive Settings
    abstract void driveScale(double scale);

    abstract void enableDrive(boolean onoff);

    abstract void exponentialDriving(boolean onoff);

    abstract void driveRange(double MinDriveValue, double MaxDriveValue);
}

class TankDrive extends RobotDrive {
    boolean exponentialDrive = true;
    boolean driveEnabled = true;
    double driveMultiplier = 1;
    double MaxValue = 1;
    double MinValue = -1;
    String lastError = "No Error Message Given!";

    //Drive Settings
    @Override
    void exponentialDriving(boolean onoff) {
        exponentialDrive = onoff;
    }

    @Override
    void driveRange(double MinDriveValue, double MaxDriveValue) {
        MinValue = MinDriveValue;
        MaxValue = MaxDriveValue;
    }

    @Override
    void driveScale(double scale) {
        driveMultiplier = scale;
    }

    @Override
    void enableDrive(boolean onoff) {
        driveEnabled = onoff;
    }

    //Main Drive Function
    @Override
    Boolean gamepadDrive(DcMotor[] Motors, Gamepad gamepad) {
        if (driveEnabled) {
            if (MinValue > MaxValue) {
                lastError = "Minimum Value is greater than Maximum value!";
                return false;
            } else {
                if (Motors.length == 2) {
                    double leftInput = gamepad.left_stick_y;
                    double rightInput = gamepad.right_stick_y;
                    Motors[0].setPower(motorPower(leftInput));
                    Motors[1].setPower(motorPower(rightInput));
                    return true;
                } else if (Motors.length == 4) {
                    double leftInput = gamepad.left_stick_y;
                    double rightInput = gamepad.right_stick_y;
                    Motors[0].setPower(motorPower(leftInput));
                    Motors[1].setPower(motorPower(rightInput));
                    Motors[2].setPower(motorPower(leftInput));
                    Motors[3].setPower(motorPower(rightInput));
                    return true;
                } else {
                    lastError = "Not the correct amount of motors!";
                    return false;
                }
            }
        } else {
            lastError = "Drive is not Enabled!";
            return false;
        }
    }

    @Override
    Boolean drive(DcMotor[] Motors, double[] speeds) {
        if (driveEnabled) {
            if (MinValue > MaxValue) {
                lastError = "Minimum Value is greater than Maximum value!";
                return false;
            } else {
                if (Motors.length == 2 && speeds.length == 2) {
                    Motors[0].setPower(customPower(speeds[0],false,false));
                    Motors[1].setPower(customPower(speeds[1],false,false));
                    return true;
                } else if (Motors.length == 4 && speeds.length == 4) {
                    Motors[0].setPower(customPower(speeds[0],false,false));
                    Motors[1].setPower(customPower(speeds[1],false,false));
                    Motors[2].setPower(customPower(speeds[2],false,false));
                    Motors[3].setPower(customPower(speeds[3],false,false));
                    return true;
                } else {
                    lastError = "Not the correct amount of motors!";
                    return false;
                }
            }
        } else {
            lastError = "Drive is not Enabled!";
            return false;
        }
    }

    //Calculate Motor Ouputs
    public double motorPower(double input) {
        double output;
        if (exponentialDrive) {
            if (input < 0.0) {
                output = input * input;
                output = -output;
            } else {
                output = input * input;
            }
        } else {
            output = input;
        }
        output = output * driveMultiplier;
        output = Range.clip(output, MinValue, MaxValue);
        return output;
    }

    //Calculate Custom Motor Ouputs
    public double customPower(double input, boolean doExponentialDrive, boolean doScale) {
        double output;
        if (doExponentialDrive) {
            if (input < 0.0) {
                output = input * input;
                output = -output;
            } else {
                output = input * input;
            }
        } else {
            output = input;
        }
        if (doScale) {
            output = output * driveMultiplier;
        }
        output = Range.clip(output, -1, 1);
        return output;
    }

    //Gets Last Error
    @Override
    String driveError() {
        return lastError;
    }

    //Get Information
    @Override
    String driveType() {
        String type = "TankDrive";
        return type;
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
        return MaxValue;
    }

    @Override
    double getMinDriveValue() {
        return MinValue;
    }
}















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

