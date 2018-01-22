package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


/**
 * Created by CJames on 11/28/17.
 */
@Autonomous (name = "simpleAuto")

public class SimpleAuto extends LinearOpMode {
    DcMotor motorLeftFront;
    DcMotor motorLeftBack;
    DcMotor motorRightFront;
    DcMotor motorRightBack;

    // IMPORTANT 1440 POSITIONS IN ROTATION
    // ONE ROTATION IS 12.5663706144 INCHES

    public void runOpMode(){
        motorLeftBack = hardwareMap.dcMotor.get("mLB");
        motorLeftFront = hardwareMap.dcMotor.get("mLF");
        motorRightBack = hardwareMap.dcMotor.get("mRB");
        motorRightFront = hardwareMap.dcMotor.get("mRF");
        waitForStart();
        motorRightFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        motorRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telemetry.addData("encoder position", motorRightFront.getCurrentPosition());
        if (motorRightFront.getCurrentPosition() <= 850) {
            right();
        }
        sleep(890);
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
