package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by CJames on 1/23/18.
 */

public class MathewAutoVersion extends LinearOpMode {
    DcMotor motorLeftFront;
    DcMotor motorLeftBack;
    DcMotor motorRightFront;
    DcMotor motorRightBack;
    DcMotor motorLift;
    Servo servoClaw;

    public void runOpMode(){
        motorLeftBack = hardwareMap.dcMotor.get("mLB");
        motorLeftFront = hardwareMap.dcMotor.get("mLF");
        motorRightBack = hardwareMap.dcMotor.get("mRB");
        motorRightFront = hardwareMap.dcMotor.get("mRF");
        servoClaw = hardwareMap.servo.get("sC");
        motorLift = hardwareMap.dcMotor.get("mL");
        motorLeftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        clawControlUp(5000);

        right();

        rotateRight();

        clawControlDown(1000); //IMPORTANT: MAKE A DOWN VERSION AND PUT IT HERE

        forward();

        backward();



    }

    public void right(){
        motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        if(motorLeftFront.getCurrentPosition() <= 7000) {
            motorLeftBack.setPower(.5);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(.5);
        }

    }

    public void rotateRight(){
        motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        if(motorLeftFront.getCurrentPosition() <= 700) {
            motorLeftBack.setPower(.5);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(.5);
        }
    }

    public void forward(){
        motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        if(motorLeftFront.getCurrentPosition() < 1000) {
            motorLeftBack.setPower(.5);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(.5);
        }
    }

    public void backward(){
        motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        if(motorLeftFront.getCurrentPosition() < 500) {
            motorLeftBack.setPower(.5);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(.5);
        }
    }

    public void clawControlUp(int timeOut){
        motorLift.setDirection(DcMotorSimple.Direction.FORWARD);
        servoClaw.setPosition(.5);
        motorLift.setPower(.5);
        sleep(timeOut);
    }

    public void clawControlDown(int timeOut){
        motorLift.setDirection(DcMotorSimple.Direction.REVERSE);
        servoClaw.setPosition(.5);
        motorLift.setPower(.5);
        sleep(timeOut);
    }
}
