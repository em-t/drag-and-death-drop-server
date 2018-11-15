package net.emt.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DragController {
    private QueenDAO queenDAO;
    private FactDAO factDAO;

    @Autowired
    public DragController(QueenDAO queenDAO, FactDAO factDAO) {
        this.queenDAO = queenDAO;
        this.factDAO = factDAO;
    }

    @RequestMapping(value = "/api/queens", method = RequestMethod.GET)
    public List<Queen> getQueens() {
        List<Queen> queens = queenDAO.listAllQueens();
        return queens;
    }

    @RequestMapping(value = "/api/randomQueen", method = RequestMethod.GET)
    public Queen getOneRandomQueen() {
        Queen queen = queenDAO.oneRandomQueen();
        return queen;
    }

    @RequestMapping(value = "/api/factsOfQueen/{id}", method = RequestMethod.GET)
    public List<Fact> getFactsofQueenWithId(@PathVariable("id") int id, @RequestParam(value="amount", required = false) Integer amount) {
        List<Fact> facts;
        if (amount == null) {
            facts = factDAO.getFactsForQueen(id);
            return facts;
        }
        facts = factDAO.getFactsForQueen(id, amount);
        return facts;
    }
}
