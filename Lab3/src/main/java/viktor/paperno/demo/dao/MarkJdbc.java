package viktor.paperno.demo.dao;

import viktor.paperno.demo.model.Mark_;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;


import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class MarkJdbc {
    private final JdbcTemplate jdbcTemplate;

    public MarkJdbc(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Mark_ get(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM mark WHERE id = ?",this::mapMark, id);
    }


    private Mark_ mapMark(ResultSet rs,int i) throws SQLException
    {
        Mark_ mark_c = new Mark_(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("value")
        );

        return mark_c;
    }
}
