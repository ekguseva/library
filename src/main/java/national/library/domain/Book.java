package national.library.domain;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

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

    private Integer yearOfPublication;
    private Integer numberOfAvailable;

    public Book(){

    }

    public Book(Integer bookID, String ISBN, String name, Author author, Genre genre, Publishing publishing, Integer yearOfPublication, Integer numberOfAvailable) {
        this.bookID = bookID;
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

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
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