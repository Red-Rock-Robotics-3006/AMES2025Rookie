package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class MotorObject extends SubsystemBase {

    // setup SparkMax Object
    SparkMax motor;

    // Constructor
    public MotorObject(int motorID, boolean inverted, SparkMax.MotorType motorType) {

        // Define the SparkMax with user ID
        this.motor = new SparkMax(motorID, motorType);

        // --- Motor Configurations ---
        // create config
        SparkMaxConfig config = new SparkMaxConfig();
        // set idle mode: when not moving Brake
        config.idleMode(IdleMode.kBrake);
        // do or do not invert the motor
        config.inverted(inverted);
        // push Configurations to the motor object
        motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void set(double speed) {
        motor.set(speed);
    }
}
