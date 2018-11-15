package net.emt.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

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

    public List<Fact> getFactsForQueen(int queenId, int numberOfFactsWanted) {
        String sql = "SELECT * FROM fact WHERE queen_id=? ORDER BY random() LIMIT ?";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("queenId", queenId);
        parameters.addValue("limit", numberOfFactsWanted);

        List<Fact> facts = jdbc.query(sql, mapper, queenId, numberOfFactsWanted);
        return facts;
    }

    public List<Fact> getFactsForQueen(int queenId) {
        String sql = "SELECT * FROM fact WHERE queen_id=? ORDER BY random()";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("queenId", queenId);

        List<Fact> facts = jdbc.query(sql, mapper, queenId);
        return facts;
    }
}