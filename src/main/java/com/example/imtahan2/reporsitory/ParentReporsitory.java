package com.example.imtahan2.reporsitory;

import com.example.imtahan2.entıty.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class ParentReporsitory implements Reporsitory{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private  RowMapper<Parent> rowMapper = (rs, rowNum) -> (new Parent(
       rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getDate(4),
            rs.getString(5)
        ));


    @Override
    public List<Parent> getAllParent() {
        String sql = "select * from Parent";
       return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public Parent getParentById(int id) {
        String sql = "SELECT * FROM Parent WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);

    }
    @Override
    public Parent creatTeacher(Parent parent) {
        String sql = "INSERT INTO Parent(name,surname,birth_date,job_name) VALUES(?,?,?,?)";
         jdbcTemplate.update(sql, parent.getName(), parent.getSurname(), parent.getBirth_date()
                , parent.getJob_name());
        return parent;
    }

    @Override
    public  Parent deleteGetById(int id) {
        String sql = "delete from Parent where id=?";
        jdbcTemplate.update(sql,id);
        return null;
    };

    @Override
    public Parent updateById(Parent parent, int id) {
        String sql = "UPDATE Parent SET  name=?,surname=?, birth_date=?,job_name=? WHERE id=?";
       jdbcTemplate.update(sql, parent.getName(), parent.getSurname(),parent.getBirth_date(),parent.getJob_name(), getParentById(id));
        return parent;
    }
}
