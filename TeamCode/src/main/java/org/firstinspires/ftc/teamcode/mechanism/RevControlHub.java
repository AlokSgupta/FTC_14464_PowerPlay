package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class RevControlHub {
    private DcMotor armMotor;
    private Servo capServo;
    private Servo handleServo;
    private double ticksPerRotation;


    public void init (HardwareMap hwMap){
        armMotor = (DcMotor) hwMap.get("armEx");
        capServo = (Servo) hwMap.get("grab1");
        handleServo = (Servo) hwMap.get("grab2");
        armMotor.setDirection(DcMotor.Direction.REVERSE);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


    public void setArmMotorSpeed(double speed) {
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armMotor.setPower(speed);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public double getArmMotorRotations() {
        return armMotor.getCurrentPosition();
    }



    public void armRuntoPosition(int position, double power){
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setTargetPosition(position);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(power);
       // armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setServoPosition (double postion){
        capServo.setPosition(postion);

    }

    public void setHServoPosition (double postion){
        handleServo.setPosition(postion);

    }
}
