package national.library.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class IssuedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer issueID;
    private Date date;

    @ManyToOne
    @JoinColumn (name= "ISBN")
    private Book book;

    @ManyToOne
    @JoinColumn (name= "readerID")
    private Reader reader ;


    @ManyToOne
    @JoinColumn (name= "employeeID")
    private Employee employee;

    public Integer getIssueID() {
        return issueID;
    }

    public void setIssueID(Integer issueID) {
        this.issueID = issueID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

