package lk.ijse.vle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Intake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intakeId;
    private String intakeMonth;

    public Intake() {
    }

    public Intake(String intakeMonth) {
        this.intakeMonth = intakeMonth;
    }

    public int getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(int intakeId) {
        this.intakeId = intakeId;
    }

    public String getIntakeMonth() {
        return intakeMonth;
    }

    public void setIntakeMonth(String intakeMonth) {
        this.intakeMonth = intakeMonth;
    }

    @Override
    public String toString() {
        return "Intake{" +
                "intakeId=" + intakeId +
                ", intakeMonth='" + intakeMonth + '\'' +
                '}';
    }
}
