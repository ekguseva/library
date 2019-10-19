package national.library.domain;

import javax.persistence.*;

@Entity
@Table
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer libraryCardID;
    private String fullName;
    private String phone;

    public Integer getLibraryCardID() {
        return libraryCardID;
    }

    public void setLibraryCardID(Integer libraryCardID) {
        this.libraryCardID = libraryCardID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
