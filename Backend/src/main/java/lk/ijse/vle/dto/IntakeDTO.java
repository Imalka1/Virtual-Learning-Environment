package lk.ijse.vle.dto;

public class IntakeDTO {
    private int intakeId;
    private String intakeMonth;

    public IntakeDTO() {
    }

    public IntakeDTO(int intakeId, String intakeMonth) {
        this.intakeId = intakeId;
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
}
