package national.library.controller;

import national.library.domain.Book;
import national.library.repository.BookRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    private final BookRepo bookRepo;

    @Autowired
    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public List list() {
        return bookRepo.findAll();
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
}