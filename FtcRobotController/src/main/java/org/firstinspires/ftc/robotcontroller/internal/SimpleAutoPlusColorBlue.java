package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by CJames on 11/28/17.
 */
@Autonomous (name = "simpleAutoPlusColorBlue")
public class SimpleAutoPlusColorBlue extends LinearOpMode {
    DcMotor motorLeftFront;
    DcMotor motorLeftBack;
    DcMotor motorRightFront;
    DcMotor motorRightBack;
    ColorSensor csJewel;
    Servo servoJewel;
    int mRFPosition = motorRightFront.getCurrentPosition();
    // IMPORTANT 1440 POSITIONS IN ROTATION
    // ONE ROTATION IS 12.5663706144 INCHES


    public void runOpMode(){
        motorLeftBack = hardwareMap.dcMotor.get("mLB");
        motorLeftFront = hardwareMap.dcMotor.get("mLF");
        motorRightBack = hardwareMap.dcMotor.get("mRB");
        motorRightFront = hardwareMap.dcMotor.get("mRF");
        csJewel = hardwareMap.colorSensor.get("csJ");
        servoJewel = hardwareMap.servo.get("sJ");
        waitForStart();
        telemetry.addData("Red amount", csJewel.red());
        telemetry.addData("Blue amount", csJewel.blue());
        servoJewel.setPosition(1); // will probably need to be changed because I'm not testing rn
        if(csJewel.red() >= 11){ // these color sensor values are placeholders I'm still finding the actual values
            rotateRight();
        }
        else if(csJewel.red()<= 2){
            rotateLeft();
        }
        else{
            telemetry.addData("Wait, how did you even get here?", null); // a little easter egg just in case you break logic
        }

        servoJewel.setPosition(0); // will probably need to be changed because I'm not testing rn

        telemetry.addData("encoder position", mRFPosition);
        if(mRFPosition <= 850){
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

    private void rotateRight(){
        motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftBack.setPower(.5);
        motorRightBack.setPower(.5);
        motorLeftFront.setPower(.5);
        motorRightFront.setPower(.5);
    }

    private void rotateLeft(){
        motorLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLeftBack.setPower(.5);
        motorRightBack.setPower(.5);
        motorLeftFront.setPower(.5);
        motorRightFront.setPower(.5);
    }


}
