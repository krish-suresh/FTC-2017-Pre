package com.pineapplerobotics.PreseasonSummer2017.PersonalBranch.Brandon.AbstractTest;

import com.qualcomm.robotcore.hardware.DcMotor;

abstract class RobotDrive {
    abstract String driveType();
    abstract void drive(DcMotor[] Motors);
}

class TankDrive extends RobotDrive{


    @Override
    String driveType() {
        String type = "TankDrive";
        return type;
    }

    @Override
    void drive(DcMotor[] Motors) {
        if(Motors.length==2){

        }
        if(Motors.length==4){

        }else{

        }
    }
}

class OmniDrive extends RobotDrive{


    @Override
    String driveType() {
        String type = "OmniDrive";
        return type;
    }

    @Override
    void drive(DcMotor[] Motors) {
        if(Motors.length==2){

        }
        if(Motors.length==4){

        }else{

        }
    }
}

