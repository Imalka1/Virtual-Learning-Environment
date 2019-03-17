package lk.ijse.vle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lecturer {
    @Id
    private int lecId;
    private String lecName;
}
