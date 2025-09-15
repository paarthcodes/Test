package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "20195-BackBlueAuto", group = "Autonomous")
public class BackBlueAuto extends LinearOpMode {

    // Declare motors
    private DcMotor leftFront, leftBack, rightFront, rightBack;
    private ElapsedTime runtime = new ElapsedTime();

    // Constants
    private static final double DRIVE_POWER = 0.5;
    private static final double STRAFE_POWER = 0.5;
    private static final double DIAG_POWER = 0.5;

    @Override
    public void runOpMode() {
        // Initialize hardware
        leftFront  = hardwareMap.get(DcMotor.class, "LeftFrontDrive");
        leftBack   = hardwareMap.get(DcMotor.class, "LeftBackDrive");
        rightFront = hardwareMap.get(DcMotor.class, "RightFrontDrive");
        rightBack  = hardwareMap.get(DcMotor.class, "RightBackDrive");

        // Set motor directions
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        if (opModeIsActive()) {
            // Example autonomous path
            moveForward(DRIVE_POWER, 2.0);
            strafeRight(STRAFE_POWER, 2.0);
            moveBackward(DRIVE_POWER, 1.5);
            strafeRight(STRAFE_POWER, 1.0);
            moveDiagonal(DIAG_POWER, 2.0, "NE");
            strafeRight(STRAFE_POWER, 0.5);
            moveForward(DRIVE_POWER, 1.0);
        }
    }

    // ----- Movement Methods -----

    private void moveForward(double power, double seconds) {
        setAllMotorsPower(-power, power, power, -power);
        timedDrive(seconds);
    }

    private void moveBackward(double power, double seconds) {
        setAllMotorsPower(power, -power, -power, power);
        timedDrive(seconds);
    }

    private void strafeRight(double power, double seconds) {
        setAllMotorsPower(-power, -power, power, power);
        timedDrive(seconds);
    }

    private void strafeLeft(double power, double seconds) {
        setAllMotorsPower(power, power, -power, -power);
        timedDrive(seconds);
    }

    private void moveDiagonal(double power, double seconds, String direction) {
        switch (direction) {
            case "NE":
                setAllMotorsPower(0, -power, power, 0);
                break;
            case "NW":
                setAllMotorsPower(-power, 0, 0, power);
                break;
            case "SE":
                setAllMotorsPower(power, 0, 0, -power);
                break;
            case "SW":
                setAllMotorsPower(0, power, -power, 0);
                break;
        }
        timedDrive(seconds);
    }

    // ----- Helper Methods -----

    private void timedDrive(double seconds) {
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < seconds) {
            telemetry.addData("Driving", "%.1f seconds elapsed", runtime.seconds());
            telemetry.update();
        }
        stopAllMotors();
    }

    private void setAllMotorsPower(double lf, double rf, double lb, double rb) {
        leftFront.setPower(lf);
        rightFront.setPower(rf);
        leftBack.setPower(lb);
        rightBack.setPower(rb);
    }

    private void stopAllMotors() {
        setAllMotorsPower(0, 0, 0, 0);
    }
}
