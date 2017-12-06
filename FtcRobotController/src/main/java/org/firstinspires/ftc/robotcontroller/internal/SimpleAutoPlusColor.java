package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


/**
 * Created by CJames on 11/28/17.
 */
@Autonomous (name = "simpleAutoPlusColor")
public class SimpleAutoPlusColor extends LinearOpMode {
    DcMotor motorLeftFront;
    DcMotor motorLeftBack;
    DcMotor motorRightFront;
    DcMotor motorRightBack;
    int mRFPosition = motorRightFront.getCurrentPosition();
    // IMPORTANT 1440 POSITIONS IN ROTATION
    // ONE ROTATION IS 12.5663706144 INCHES


    public void runOpMode(){
        telemetry.addData("encoder position", mRFPosition);
        if(mRFPosition <= 1440){
            right();
        }
        motorRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        if(mRFPosition <= 480){
            backwards();
        }
    }

    private void right(){
        motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);

        motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftBack.setPower(.5);
        motorRightBack.setPower(.5);
        motorLeftFront.setPower(.5);
        motorRightFront.setPower(.5);

    }

    private void backwards(){
        motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftBack.setPower(.5);
        motorRightBack.setPower(.5);
        motorLeftFront.setPower(.5);
        motorRightFront.setPower(.5);
    }


}
