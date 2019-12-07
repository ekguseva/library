package national.library.controller;

import national.library.domain.Book;
import national.library.domain.Employee;
import national.library.domain.IssuedBook;
import national.library.domain.Reader;
import national.library.repository.BookRepo;
import national.library.repository.EmployeeRepo;
import national.library.repository.IssuedBookRepo;
import national.library.repository.ReaderRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class IssuedBookController {
    private final IssuedBookRepo issuedBookRepo;
    private final BookRepo bookRepo;
    private final ReaderRepo readerRepo;
    private final EmployeeRepo employeeRepo;
    private final DataSource dataSource;

    @Autowired
    public IssuedBookController(IssuedBookRepo issuedBookRepo, DataSource dataSource, BookRepo bookRepo, ReaderRepo readerRepo, EmployeeRepo employeeRepo) {
        this.issuedBookRepo = issuedBookRepo;
        this.dataSource = dataSource;
        this.bookRepo = bookRepo;
        this.employeeRepo = employeeRepo;
        this.readerRepo = readerRepo;
    }

    @GetMapping("/issuedBooks")
    public String issuedBookList(@RequestParam(required = false) String libraryCardFilter,
                            Model model)
    {
        StringBuilder selectQuery = new StringBuilder();
        selectQuery.append("SELECT * FROM issued_book WHERE is_returned = false");
        if (libraryCardFilter != null && !libraryCardFilter.isEmpty())
        {
            selectQuery.append(" AND library_cardID = '");
            selectQuery.append(libraryCardFilter);
            selectQuery.append("'");
        }

        String finalQuery = selectQuery.toString();

        JdbcTemplate j = new JdbcTemplate(dataSource);
        List<IssuedBook> issuedBooks = j.query(finalQuery, (rs, rowNum) -> {
            Book book = bookRepo.findByBookID(rs.getInt("bookID"));
            Reader reader = readerRepo.findByLibraryCardID(rs.getInt("library_cardID"));
            Employee employee = employeeRepo.findByEmployeeID(rs.getInt("employeeID"));
            return new IssuedBook(rs.getDate("date"), book, reader, employee,rs.getInt("issueID"));
        });


        model.addAttribute("issuedBooks", issuedBooks);
        return "issuedBookList";
    }

    @GetMapping("/issuedBooks/{issueID}")
    public IssuedBook getOne(@PathVariable("issueID") IssuedBook issuedBook) {
        return issuedBook;
    }

    /*PostMapping
    public IssuedBook create(@RequestBody IssuedBook issuedBook) {
        return issuedBookRepo.save(issuedBook);
    }*/

    @GetMapping("/bookBack")
    public String bookBack (@RequestParam Integer issueID, Model model)
    {
        IssuedBook issuedBook = issuedBookRepo.findByIssueID(issueID);
        issuedBook.setReturned(true);
        issuedBookRepo.save(issuedBook);
        List<IssuedBook> issuedBooks = issuedBookRepo.findByIsReturnedFalse();
        model.addAttribute("issuedBooks", issuedBooks);
        return "issuedBookList";
    }

    @PutMapping ("/issuedBooks/{issueID}")
    public IssuedBook update(
            @PathVariable("issueID") IssuedBook issuedBookFromDB,
            @RequestBody IssuedBook issuedBook) {
        BeanUtils.copyProperties(issuedBook, issuedBookFromDB,"issueID");
        return issuedBookRepo.save(issuedBook);
    }

    @DeleteMapping ("/issuedBooks/{issueID}")
    public void delete( @PathVariable("issueID") IssuedBook issuedBook) {
        issuedBookRepo.delete(issuedBook);
    }
}
