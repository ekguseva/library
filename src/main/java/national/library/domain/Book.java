package national.library.domain;

import javax.persistence.*;
import java.time.Year;

@Entity
@Table
public class Book {
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

    private Year yearOfPublication;
    private Integer numberOfAvailable;

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
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

    public Year getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Year yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Integer getNumberOfAvailable() {
        return numberOfAvailable;
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

    public void setNumberOfAvailable(Integer numberOfAvailable) {
        this.numberOfAvailable = numberOfAvailable;
    }
}
