package national.library.domain;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.util.Date;

@Entity
@FilterDef(name="bookFilter", parameters={
        @ParamDef( name="name", type="String" ),
        @ParamDef( name="author", type="integer" ),
        @ParamDef( name="genre", type="integer")
})
@Table
public class Book {
    @Filter(name="bookFilter", condition=":name = name and :authorId = author and :genreId = genre")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookID;

    private String ISBN;
    private String name;

    @ManyToOne
    @JoinColumn (name= "authorID")
    private Author author;

    @ManyToOne
    @JoinColumn (name= "genreID")
    private Genre genre;

    @ManyToOne
    @JoinColumn (name= "publishingID")
    private Publishing publishing;

    private Date yearOfPublication;
    private Integer numberOfAvailable;

    public Book(){

    }

    public Book(String ISBN, String name, Author author, Genre genre, Publishing publishing, Date yearOfPublication, Integer numberOfAvailable) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.publishing = publishing;
        this.yearOfPublication = yearOfPublication;
        this.numberOfAvailable = numberOfAvailable;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Date yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publishing getPublishing() {
        return publishing;
    }

    public void setPublishing(Publishing publishing) {
        this.publishing = publishing;
    }

    public Integer getNumberOfAvailable() {
        return numberOfAvailable;
    }

    public void setNumberOfAvailable(Integer numberOfAvailable) {
        this.numberOfAvailable = numberOfAvailable;
    }
}
