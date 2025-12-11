package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RedRockLib.SmartDashboardNumber;

public class WoodConveyor extends SubsystemBase{
    private MotorObject conveyor = new MotorObject(29, true, SparkMax.MotorType.kBrushless);

    private SmartDashboardNumber speed = new SmartDashboardNumber("Conveyor Run Speed", 0.25);
    private SmartDashboardNumber retractSpeed = new SmartDashboardNumber("Conveyor Retract Speed", 0.15);

    public void off() {
        conveyor.set(0);
    }

    public void on() {
        conveyor.set(speed.getNumber());
    }

    public void retract() {
        conveyor.set(-retractSpeed.getNumber());
    }
}
