package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RedRockLib.SmartDashboardNumber;

import com.revrobotics.spark.SparkMax;

public class TankDrive extends SubsystemBase {
    private MotorObject tLeft = new MotorObject(12, true, SparkMax.MotorType.kBrushed);
    private MotorObject tRight = new MotorObject(11, false, SparkMax.MotorType.kBrushed);
    private MotorObject bLeft = new MotorObject(10, true, SparkMax.MotorType.kBrushed);
    private MotorObject bRight = new MotorObject(13, false, SparkMax.MotorType.kBrushed);

    private SmartDashboardNumber turnSpeed = new SmartDashboardNumber("Turn Speed", 0.4);
    private SmartDashboardNumber driveSpeed = new SmartDashboardNumber("Drive Speed", 0.5);

    public void resting() {
        tLeft.set(0);
        bLeft.set(0);
        tRight.set(0);
        bRight.set(0);
    }

    public void moving(double leftStick, double rightStick) {
        double leftVal = leftStick * driveSpeed.getNumber();
        double rightVal = rightStick * turnSpeed.getNumber();

        tLeft.set(leftVal + rightVal);
        bLeft.set(leftVal + rightVal);
        tRight.set(leftVal - rightVal);
        bRight.set(leftVal - rightVal);
    }
}