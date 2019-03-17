package lk.ijse.vle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facultyId;
    private String facultyName;
    private String nameInShort;

    public Faculty() {
    }

    public Faculty(String facultyName, String nameInShort) {
        this.facultyName = facultyName;
        this.nameInShort = nameInShort;
    }

    public String getNameInShort() {
        return nameInShort;
    }

    public void setNameInShort(String nameInShort) {
        this.nameInShort = nameInShort;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", nameInShort='" + nameInShort + '\'' +
                '}';
    }
}
