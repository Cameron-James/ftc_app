package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by CJames on 12/6/17.
 */
@Autonomous
public class AutoRunByTIme extends LinearOpMode {
    DcMotor motorLeftFront;
    DcMotor motorLeftBack;
    DcMotor motorRightFront;
    DcMotor motorRightBack;

    public void runOpMode(){
        motorLeftBack = hardwareMap.dcMotor.get("mLB");
        motorLeftFront = hardwareMap.dcMotor.get("mLF");
        motorRightBack = hardwareMap.dcMotor.get("mRB");
        motorRightFront = hardwareMap.dcMotor.get("mRF");
        waitForStart();
        right();
        backwards();

    }

    public void right(){
        motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftBack.setPower(.5);
        motorRightBack.setPower(.5);
        motorLeftFront.setPower(.5);
        motorRightFront.setPower(.5);
        sleep(500);
    }

    public void backwards(){
        motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftBack.setPower(.5);
        motorRightBack.setPower(.5);
        motorLeftFront.setPower(.5);
        motorRightFront.setPower(.5);
        sleep(500);
    }
}
