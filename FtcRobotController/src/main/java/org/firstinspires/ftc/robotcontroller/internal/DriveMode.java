package org.firstinspires.ftc.robotcontroller.internal;

import android.hardware.Sensor;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by CJames on 10/25/17.
 */
@com.qualcomm.robotcore.eventloop.opmode.TeleOp (name = "TeleOp")
public class DriveMode extends OpMode {
    DcMotor motorLeftFront;
    DcMotor motorLeftBack;
    DcMotor motorRightFront;
    DcMotor motorRightBack;
    DcMotor motorLift;
    Servo servoClaw;
    Servo servoFlipper;
    public void init(){
        gamepad1.reset();
        gamepad2.reset();
        motorLeftBack = hardwareMap.dcMotor.get("mLB");
        motorLeftFront = hardwareMap.dcMotor.get("mLF");
        motorLift = hardwareMap.dcMotor.get("mL");
        motorRightBack = hardwareMap.dcMotor.get("mRB");
        motorRightFront = hardwareMap.dcMotor.get("mRF");
        servoClaw = hardwareMap.servo.get("sC");
        //servoFlipper = hardwareMap.servo.get("sF");




    }

    public void loop(){

        // stop if no input is received
        motorLeftBack.setPower(0);
        motorRightBack.setPower(0);
        motorLeftFront.setPower(0);
        motorRightFront.setPower(0);



        // Forward
        if (gamepad1.dpad_down){
            motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setPower(.5);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(.5);
        }

        //Fast-Forward
        if (gamepad1.dpad_down && gamepad1.right_trigger >= 1){
            motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setPower(1);
            motorRightBack.setPower(1);
            motorLeftFront.setPower(1);
            motorRightFront.setPower(1);
        }

        // Backwards
        if (gamepad1.dpad_up){
            motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setPower(.5);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(.5);
        }
        //Fast-Back
        if (gamepad1.dpad_up && gamepad1.right_trigger >= 1){
            motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setPower(1);
            motorRightBack.setPower(1);
            motorLeftFront.setPower(1);
            motorRightFront.setPower(1);
        }


        // Left
        if (gamepad1.dpad_left){
            motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);

            motorLeftBack.setPower(.5);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(.5);

        }
        //Fast-Left
        if (gamepad1.dpad_left && gamepad1.right_trigger >= 1){
            motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);

            motorLeftBack.setPower(1);
            motorRightBack.setPower(1);
            motorLeftFront.setPower(1);
            motorRightFront.setPower(1);

        }

        // Right
        if (gamepad1.dpad_right){
            motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setPower(.5);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(.5);
        }
        //Fast-Right
        if (gamepad1.dpad_right && gamepad1.right_trigger >= 1){
            motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setPower(1);
            motorRightBack.setPower(1);
            motorLeftFront.setPower(1);
            motorRightFront.setPower(1);
        }

        // Rotate Right
        if (gamepad1.right_stick_x >= .5){
            motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setPower(.5);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(.5);

        }
        if (gamepad1.right_stick_x >= .5 && gamepad1.right_trigger >= 1){
            motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setPower(1);
            motorRightBack.setPower(1);
            motorLeftFront.setPower(1);
            motorRightFront.setPower(1);

        }

        // Rotate Left
        if (gamepad1.right_stick_x <= -.5){
            motorLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setPower(.5);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(.5);
        }
        if (gamepad1.right_stick_x <= -1 && gamepad1.right_trigger >= 1){
            motorLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setPower(1);
            motorRightBack.setPower(1);
            motorLeftFront.setPower(1);
            motorRightFront.setPower(1);
        }

        if (gamepad1.left_stick_y >= 0.5){
            motorLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setPower(0);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(0);
        }
        if (gamepad1.left_stick_y >= 1 && gamepad1.right_trigger >= 1){
            motorLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setPower(0);
            motorRightBack.setPower(1);
            motorLeftFront.setPower(1);
            motorRightFront.setPower(0);
        }
        if (gamepad1.left_stick_y <= -0.5){
            motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setPower(0);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(0);
        }
        if (gamepad1.left_stick_y <= -1 && gamepad1.right_trigger >= 1){
            motorLeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorRightBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setPower(0);
            motorRightBack.setPower(1);
            motorLeftFront.setPower(1);
            motorRightFront.setPower(0);
        }
        if (gamepad1.left_stick_x >= 0.5){
            motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setPower(0.5);
            motorRightBack.setPower(0);
            motorLeftFront.setPower(0);
            motorRightFront.setPower(0.5);

        }
        if (gamepad1.left_stick_x >= 1 && gamepad1.right_trigger >= 1){
            motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setPower(1);
            motorRightBack.setPower(0);
            motorLeftFront.setPower(0);
            motorRightFront.setPower(1);

        }
        if (gamepad1.left_stick_x <= -0.5){
            motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setPower(0.5);
            motorRightBack.setPower(0);
            motorLeftFront.setPower(0);
            motorRightFront.setPower(0.5);
        }
        if (gamepad1.left_stick_x <= -1 && gamepad1.right_trigger >= 1){
            motorRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftBack.setPower(1);
            motorRightBack.setPower(0);
            motorLeftFront.setPower(0);
            motorRightFront.setPower(1);
        }
        // Down
        if (gamepad2.a && gamepad2.right_trigger >= 1){
            motorLift.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLift.setPower(.5);

        }
        else if (gamepad2.a) {
            motorLift.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLift.setPower(.5);
            servoClaw.setPosition(.5);
        }
        else{
            motorLift.setPower(0);
        }

        if (gamepad2.b && gamepad2.right_trigger >= 1){
            motorLift.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLift.setPower(.5);

        }

        else if (gamepad2.b){
            motorLift.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLift.setPower(.5);
            servoClaw.setPosition(.5);
        }
        else {
            motorLift.setPower(0);
        }

        if (gamepad2.left_bumper){
            servoClaw.setPosition(.60);
        }
        if (gamepad2.right_bumper){
            servoClaw.setPosition(.5); // change this one if you need more space
        }
    }


}