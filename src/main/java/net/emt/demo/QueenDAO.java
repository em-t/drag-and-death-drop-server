package net.emt.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class QueenDAO {
    private JdbcTemplate jdbc;
    private RowMapper<Queen> mapper = (ResultSet rs, int index) -> {
        Queen queen = new Queen();
        queen.setId(rs.getInt("id"));
        queen.setName(rs.getString("name"));
        String image = rs.getString("image");
        if (rs.wasNull()) {
            image = null;
        }
        queen.setImage(image);
        return queen;
    };

    @Autowired
    public QueenDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Queen> listAllQueens() {
        String sql = "SELECT * FROM queen";
        List<Queen> queens = jdbc.query(sql, mapper);
        return queens;
    }

    public Queen oneRandomQueen() {
        // TODO muistele miten hakuehdot menee
        String sql = "SELECT * FROM queen ORDER BY random() LIMIT 1";
        List<Queen> queen = jdbc.query(sql, mapper);
        if (queen.size() == 1) {
            return queen.get(0);
        }
        return null;
    }
}
