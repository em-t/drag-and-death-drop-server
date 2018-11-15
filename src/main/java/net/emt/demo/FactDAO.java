package net.emt.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;

@Service
public class FactDAO {
    private JdbcTemplate jdbc;
    private RowMapper<Fact> mapper = (ResultSet rs, int index) -> {
        Fact fact = new Fact();
        fact.setId(rs.getInt("id"));
        fact.setQueenId(rs.getInt("queen_id"));
        String quote = rs.getString("quote");
        if (rs.wasNull()) {
            quote = null;
        }
        fact.setQuote(quote);
        return fact;
    };

    @Autowired
    public FactDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


}
