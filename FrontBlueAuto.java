package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "20195-FrontRedAuto", group = "Autonomous")
public class FrontBlueAuto extends LinearOpMode {

    // Declare motors and servos
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor LeftFrontDrive = null;
    private DcMotor LeftBackDrive = null;
    private DcMotor RightFrontDrive = null;
    private DcMotor RightBackDrive = null;

    private static final int ROTATIONS = 5; // Set the number of rotations here

    @Override
    public void runOpMode() {
    
        // Initialize the hardware map
        LeftFrontDrive = hardwareMap.get(DcMotor.class, "LeftFrontDrive");
        LeftBackDrive = hardwareMap.get(DcMotor.class, "LeftBackDrive");
        RightFrontDrive = hardwareMap.get(DcMotor.class, "RightFrontDrive");
        RightBackDrive = hardwareMap.get(DcMotor.class, "RightBackDrive");

        LeftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        LeftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        RightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        RightBackDrive.setDirection(DcMotor.Direction.FORWARD);
        
   
        // Set initial position

        telemetry.addData("Status", "Initialized");
        telemetry.update();
    
        waitForStart();
        runtime.reset();
    
        // Movement for parking
        moveWest(0.15);
        sleep(1000);
    }
    
    // Functions for Movement
    private void moveWest(double seconds) {
        setAllMotorsPower(1, 1, 1, 1);
        sleep((long)(seconds * 1000));
        stopAllMotors();
    }
    
    private void moveEast(double seconds) {
        setAllMotorsPower(-1, -1, -1, -1);
        sleep((long)(seconds * 1000));
        stopAllMotors();
    }
    
    private void moveNorth(double seconds) {
        setAllMotorsPower(-1, 1, 1, -1);
        sleep((long)(seconds * 1000));
        stopAllMotors();
    }
    
    private void moveSouth(double seconds) {
        setAllMotorsPower(1, -1, -1, 1);
        sleep((long)(seconds * 1000));
        stopAllMotors();
    }
    
    private void moveNortheast(double seconds) {
        setAllMotorsPower(0.5, 0.0, 0.5, 0.0);
        sleep((long)(seconds * 1000));
        stopAllMotors();
    }
    
    private void moveNorthwest(double seconds) {
        setAllMotorsPower(0.0, 0.5, 0.0, 0.5);
        sleep((long)(seconds * 1000));
        stopAllMotors();
    }
    
    private void moveSoutheast(double seconds) {
        setAllMotorsPower(0.0, -0.5, 0.0, -0.5);
        sleep((long)(seconds * 1000));
        stopAllMotors();
    }
    
    private void moveSouthwest(double seconds) {
        setAllMotorsPower(-0.5, 0.0, -0.5, 0.0);
        sleep((long)(seconds * 1000));
        stopAllMotors();
    }
    
    // Functions for SHOTS FIRED!!! (WIP)
  
    
    // Extra Functions
    private void setAllMotorsPower(double leftFront, double rightFront, double leftBack, double rightBack) {
        LeftFrontDrive.setPower(leftFront);
        RightFrontDrive.setPower(rightFront);
        LeftBackDrive.setPower(leftBack);
        RightBackDrive.setPower(rightBack);
    }
    
    private void stopAllMotors() {
        setAllMotorsPower(0.0, 0.0, 0.0, 0.0);
    }
}
