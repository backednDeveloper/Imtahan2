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
    private  RowMapper<Parent> rowMapper = (rs, rowNum) -> {
        Parent parent = new Parent();
        parent.setId(BigInteger.valueOf(rs.getInt(1)));
        parent.setName(rs.getString(2));
        parent.setSurname(rs.getString(3));
        parent.setBirth_date(rs.getDate(4));
        parent.setJob_name(rs.getString(5));
        return parent;
    };

    @Override
    public List<Parent> getAllParent() {
        String sql = "select * from Parent";
       return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<Parent> getParentById(int id) {
        String sql = "SELECT * FROM Parent WHERE id = ?";
         jdbcTemplate.query(sql, new Object[]{id}, rowMapper);
        return null;
    }

    @Override
    public Parent creatTeacher(Parent parent) {
        String sql = "INSERT INTO Parent(name,surname,birth_date,job_name) VALUES(?,?,?,?)";
         jdbcTemplate.update(sql, parent.getName(), parent.getSurname(),parent.getBirth_date()
        ,parent.getJob_name());
         return parent;
    }

    @Override
    public  Parent deleteGetById(int id) {
        String sql = "delete from parent where id=?";
        jdbcTemplate.update(sql,id);
        return null;
    };

    @Override
    public Parent updateById(Parent parent, int id) {
        String sql = "UPDATE teacher SET name=?,surname=?, birth_date=?,job_name=? WHERE id=?";
        int update = jdbcTemplate.update(sql, id);
        return parent;
    }
}
