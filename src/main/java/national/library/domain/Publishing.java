package national.library.domain;

import javax.persistence.*;

@Entity
@Table
public class Publishing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer publishingID;
    private String name;

    public Integer getPublishingID() {
        return publishingID;
    }

    public void setPublishingID(Integer publishingID) {
        this.publishingID = publishingID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
