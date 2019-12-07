package national.library.controller;

import national.library.domain.Author;
import national.library.domain.Book;
import national.library.domain.Genre;
import national.library.domain.Publishing;
import national.library.repository.AuthorRepo;
import national.library.repository.BookRepo;
import national.library.repository.GenreRepo;
import national.library.repository.PublishingRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final GenreRepo genreRepo;
    private final PublishingRepo publishingRepo;
    private final DataSource dataSource;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/books")
    public String bookList( @RequestParam (required = false) String nameFilter, @RequestParam (required = false) String authorFilter, @RequestParam (required = false) String genreFilter,
            Model model
    ) {
        StringBuilder selectQuery = new StringBuilder();
        selectQuery.append("SELECT * FROM book WHERE ");
        boolean flagAnd  = false;
        if (nameFilter != null && !nameFilter.isEmpty())
        {
            flagAnd = true;
            selectQuery.append(" name = '");
            selectQuery.append(nameFilter);
            selectQuery.append("'");
        }
        if (authorFilter != null && !authorFilter.isEmpty())
        {
            if (flagAnd) selectQuery.append(" AND");
            else flagAnd=true;
            Author a = authorRepo.findByName(authorFilter);
            selectQuery.append(" authorID = ");
            selectQuery.append(a.getAuthorID());
        }
        if (genreFilter != null && !genreFilter.isEmpty())
        {
            if (flagAnd) selectQuery.append(" AND");
            else flagAnd=true;
            Genre g = genreRepo.findByName(genreFilter);
            selectQuery.append(" genreID = ");
            selectQuery.append(g.getGenreID());
        }
        if (!flagAnd)
        {
            List<Book> books =bookRepo.findAll();
            model.addAttribute("books", books);
            return "bookList";
        }

        String finalQuery = selectQuery.toString();

        JdbcTemplate j = new JdbcTemplate(dataSource);
        List<Book> books = j.query(finalQuery, (rs, rowNum) -> {
            Author a = authorRepo.findByAuthorID(rs.getInt("authorID"));
            Genre g = genreRepo.findByGenreID(rs.getInt("genreID"));
            Publishing p = publishingRepo.findByPublishingID(rs.getInt("publishingID"));
            return new Book(rs.getString("ISBN"), rs.getString("name"),a,g,p,
                    rs.getInt("year_of_publication"),rs.getInt("number_of_available"));
        });

        model.addAttribute("books", books);
        return "bookList";
    }

    @Autowired
    public BookController(BookRepo bookRepo, AuthorRepo authorRepo, GenreRepo genreRepo, PublishingRepo publishingRepo, DataSource dataSource) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.genreRepo = genreRepo;
        this.publishingRepo = publishingRepo;
        this.dataSource = dataSource;
    }

    @GetMapping("books/{bookID}")
    public Book getOne(@PathVariable("bookID") Book book) {
        return book;
    }

    /*@PostMapping
    public Book create(@RequestBody Book book) {
        return bookRepo.save(book);
    }*/

    @PutMapping ("books/{bookID}")
    public Book update(
            @PathVariable("bookID") Book bookFromDB,
            @RequestBody Book book) {
        BeanUtils.copyProperties(book, bookFromDB ,"bookID");
        return bookRepo.save(book);
    }

    @DeleteMapping ("books/{bookID}")
    public void delete( @PathVariable("bookID") Book book) {
        bookRepo.delete(book);
    }
}