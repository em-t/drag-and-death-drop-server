package net.emt.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class DragDao {
    private JdbcTemplate jdbc;
    private RowMapper<Queen> mapper = (ResultSet rs, int index) -> {
        Queen temp = new Queen();
        temp.setId(rs.getInt("id"));
        temp.setName(rs.getString("name"));
        String image = rs.getString("image");
        if (rs.wasNull()) {
            image = null;
        }
        temp.setImage(image);
        return temp;
    };

    @Autowired
    public DragDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Queen> listAllQueens() {
        String sql = "SELECT * FROM queen";
        List<Queen> queens = jdbc.query(sql, mapper);
        return queens;
    }


}
