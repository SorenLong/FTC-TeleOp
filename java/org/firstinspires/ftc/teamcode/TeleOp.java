// Written By Soren Long on September 4th at 11:49PM, this is a basic teleop mode that will be used alongside the
// autonomous mode i will be posting to my github ( https://github.com/SorenLong ) for my robotics class.

package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp", group = "DriveModes")
public class TeleOp extends LinearOpMode
{

    private DcMotor motorLeftFront;
    private DcMotor motorLeftBack;
    private DcMotor motorRightFront;
    private DcMotor motorRightBack;

    private Servo armServo;

    private static final double ARM_RETRACTED_POSITION = 0.2;
    private static final double ARM_EXTENDED_POSITION = 0.8;


    @Override
    public void runOpMode() throws InterruptedException
    {

            armServo = hardwareMap.servo.get("armServo");

            motorLeftFront = hardwareMap.dcMotor.get("motorLeftFront");
            motorLeftBack = hardwareMap.dcMotor.get("motorLeftBack");
            motorRightFront = hardwareMap.dcMotor.get("motorRightFront");
            motorRightBack = hardwareMap.dcMotor.get("motorRightBack");

            motorLeftBack.setDirection(DcMotor.Direction.REVERSE);
            motorRightBack.setDirection(DcMotor.Direction.REVERSE);

            waitForStart();

            while(opModeIsActive())
            {

                motorLeftBack.setPower(-gamepad1.left_stick_y);
                motorLeftFront.setPower(-gamepad1.left_stick_y);
                motorRightBack.setPower(-gamepad1.right_stick_y);
                motorRightFront.setPower(-gamepad1.right_stick_y);

                if(gamepad2.a)
                {
                    armServo.setPosition(ARM_RETRACTED_POSITION);
                }

                if(gamepad2.b)
                {
                    armServo.setPosition(ARM_EXTENDED_POSITION);
                }


                idle();
            }



    }


}
