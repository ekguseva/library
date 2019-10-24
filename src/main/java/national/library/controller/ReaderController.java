package national.library.controller;

import national.library.domain.Reader;
import national.library.repository.ReaderRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reader")
public class ReaderController {

    private final ReaderRepo readerRepo;

    @Autowired
    public ReaderController(ReaderRepo readerRepo) {
        this.readerRepo = readerRepo;
    }

    @GetMapping
    public List list() {
        return readerRepo.findAll();
    }

    @GetMapping("{libraryCardID}")
    public Reader getOne(@PathVariable("libraryCardID") Reader reader) {
        return reader;
    }

    @PostMapping
    public Reader create(@RequestBody Reader reader) {
        return readerRepo.save(reader);
    }

    @PutMapping ("{libraryCardID}")
    public Reader update(
            @PathVariable("libraryCardID") Reader readerFromBD,
            @RequestBody Reader reader) {
        BeanUtils.copyProperties(reader,readerFromBD,"libraryCardID");
        return readerRepo.save(reader);
    }

    @DeleteMapping ("{libraryCardID}")
    public void delete( @PathVariable("libraryCardID") Reader reader) {
        readerRepo.delete(reader);
    }
}
