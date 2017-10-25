package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

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
        servoFlipper = hardwareMap.servo.get("sF");

    }

    public void loop(){

        if (gamepad1.left_stick_y >= 0.00001){
            motorRightFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
            motorRightBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftBack.setPower(.5);
            motorRightBack.setPower(.5);
            motorLeftFront.setPower(.5);
            motorRightFront.setPower(.5);
        }

    }
}
