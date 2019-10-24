package national.library.controller;

import national.library.domain.IssuedBook;
import national.library.repository.IssuedBookRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("issuedBook")
public class IssuedBookController {
    private final IssuedBookRepo issuedBookRepo;

    @Autowired
    public IssuedBookController(IssuedBookRepo issuedBookRepo) {
        this.issuedBookRepo = issuedBookRepo;
    }

    @GetMapping
    public List list() {
        return issuedBookRepo.findAll();
    }

    @GetMapping("{issueID}")
    public IssuedBook getOne(@PathVariable("issueID") IssuedBook issuedBook) {
        return issuedBook;
    }

    @PostMapping
    public IssuedBook create(@RequestBody IssuedBook issuedBook) {
        return issuedBookRepo.save(issuedBook);
    }

    @PutMapping ("{issueID}")
    public IssuedBook update(
            @PathVariable("issueID") IssuedBook issuedBookFromBD,
            @RequestBody IssuedBook issuedBook) {
        BeanUtils.copyProperties(issuedBook,issuedBookFromBD,"issueID");
        return issuedBookRepo.save(issuedBook);
    }

    @DeleteMapping ("{issueID}")
    public void delete( @PathVariable("issueID") IssuedBook issuedBook) {
        issuedBookRepo.delete(issuedBook);
    }
}
