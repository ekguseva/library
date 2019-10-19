package national.library.domain;

import javax.persistence.*;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer authorID;
    private String name;

    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
