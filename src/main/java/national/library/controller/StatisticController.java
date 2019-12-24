package national.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class StatisticController {
    @Autowired
    private  DataSource dataSource;

    public List<Integer> returnCount(String query){
        JdbcTemplate j = new JdbcTemplate(dataSource);
        List<Integer> count = j.query(query, (rs, rowNum) -> rs.getInt(1));
        return count;
    }

    @GetMapping("/statistics")
    public String getStatistic(Model model)
    {
        model.addAttribute("book", returnCount("SELECT COUNT(*) FROM book"));
        model.addAttribute("bookCopies", returnCount("SELECT SUM(number_of_available) FROM book"));
        model.addAttribute("issuedBook", returnCount("SELECT COUNT(*) FROM issued_book"));
        model.addAttribute("reader", returnCount("SELECT COUNT(*) FROM reader"));
        model.addAttribute("employee", returnCount("SELECT COUNT(*) FROM employee"));
        model.addAttribute("issuedBookIsNotReturned", returnCount("SELECT COUNT(*) FROM issued_book WHERE is_returned = false"));
        return "statistics";
    }

}
