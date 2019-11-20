package national.library.controller;

import national.library.domain.Book;
import national.library.repository.AuthorRepo;
import national.library.repository.BookRepo;
import national.library.repository.GenreRepo;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("books")
public class BookController {
    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final GenreRepo genreRepo;

    @GetMapping
    public String bookList(
            Map<String, Object> model
    ) {
        Iterable<Book> books= bookRepo.findAll();

        model.put("books", books);
        return "bookList";
    }

    @Autowired
    public BookController(BookRepo bookRepo, AuthorRepo authorRepo, GenreRepo genreRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.genreRepo = genreRepo;
    }

    @GetMapping("{bookID}")
    public Book getOne(@PathVariable("bookID") Book book) {
        return book;
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    @PutMapping ("{bookID}")
    public Book update(
            @PathVariable("bookID") Book bookFromDB,
            @RequestBody Book book) {
        BeanUtils.copyProperties(book, bookFromDB ,"bookID");
        return bookRepo.save(book);
    }

    @DeleteMapping ("{bookID}")
    public void delete( @PathVariable("bookID") Book book) {
        bookRepo.delete(book);
    }

    @PostMapping("filter")
    public String filter(@RequestParam String nameFilter, @RequestParam String authorFilter, @RequestParam String genreFilter, Map<String,Object> model)
    {
        //Iterable<Book> books;
        Integer author = authorRepo.findByName(authorFilter).getAuthorID();
        Integer genre = genreRepo.findByName(genreFilter).getGenreID();
        //Session session = HibernateUtil.getSessionFactory().openSession();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Filter filter = session.enableFilter("bookFilter");
        filter.setParameter("name", nameFilter);
        filter.setParameter("author", author);
        filter.setParameter("genre", genre);
        session.beginTransaction();
        List<Book> books = session.createQuery("FROM Book").list();
        /*if (nameFilter != null && !nameFilter.isEmpty())
        {
            books = bookRepo.findByNameAndAuthorAndGenre(nameFilter, author, genre);
        } else {
            books = bookRepo.findAll();
        }*/
        session.disableFilter("bookFilter");
        model.put("books", books);
        session.close();
        return "bookList";
    }
}