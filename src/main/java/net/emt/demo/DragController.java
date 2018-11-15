package net.emt.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DragController {
    private QueenDAO dao;

    @Autowired
    public DragController(QueenDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/api/queens", method = RequestMethod.GET)
    public List<Queen> getQueens() {
        List<Queen> queens = dao.listAllQueens();
        return queens;
    }

    // TODO: metodi joka palauttaa random queenin
    @RequestMapping(value = "/api/randomQueen", method = RequestMethod.GET)
    public Queen getOneRandomQueen() {
        Queen queen = dao.oneRandomQueen();
        return queen;
    }

    // TODO: metodi joka palauttaa queenin faktat oikealla id:llä
}
