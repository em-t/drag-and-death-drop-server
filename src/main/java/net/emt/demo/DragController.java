package net.emt.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DragController {
    private DragDao dao;

    @Autowired
    public DragController(DragDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value="/api/queens", method= RequestMethod.GET)
    public List<Queen> getQueens() {
        List<Queen> queens = dao.listAllQueens();
        return queens;
    }
}
