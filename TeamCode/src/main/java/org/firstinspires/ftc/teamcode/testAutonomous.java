package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "testAutonomous", group = "Team15034")

public class testAutonomous extends LinearOpMode {

    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;
    private Servo servo;

    @Override
    public void runOpMode() {

        leftFront = hardwareMap.get(DcMotor.class, "LF");
        leftBack = hardwareMap.get(DcMotor.class, "LB");
        rightBack = hardwareMap.get(DcMotor.class, "RB");
        rightFront = hardwareMap.get(DcMotor.class, "RF");
        servo = hardwareMap.get(Servo.class, "SERVO");

//        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
//        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
//        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
//        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addLine("I'm alive");
        telemetry.update();

        waitForStart();



        while (opModeIsActive()) {

            goForward(0.5, 5000);
            turn("right", 2000, 0.5);
            servo.setPosition(0.3);
            sleep(2000);
            telemetry.update();
            break;
        }
    }

    public void goForward(double power, long time) {

        leftFront.setPower(power);
        leftBack.setPower(power);
        rightFront.setPower(power);
        rightBack.setPower(power);

        sleep(time);
    }

    public void turn(String direction, long time, double power) {
        if (direction.equalsIgnoreCase("left")) {
            rightBack.setPower(power);
            rightFront.setPower(power);
            leftFront.setPower((-1 * power));
            leftBack.setPower((-1 * power));

        } else if (direction.equalsIgnoreCase("right")) {
            leftBack.setPower(power);
            leftFront.setPower(power);
            rightFront.setPower((-1 * power));
            rightBack.setPower((-1 * power));
        } else {
            System.out.println("error");
        }
    }
}

