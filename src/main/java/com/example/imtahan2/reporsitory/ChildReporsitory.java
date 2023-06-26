package com.example.imtahan2.reporsitory;

import com.example.imtahan2.entıty.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class ChildReporsitory implements ChildReporsitory1 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Child> rowMapper = (rs, rowNum) -> {
        Child child = new Child();
        child.setId(BigInteger.valueOf(rs.getInt(1)));
        child.setName(rs.getString(2));
        child.setBirth_date(rs.getDate(3));
        return child;
    };
    @Override
    public List<Child> getAllChild() {
        String sql = "select * from Child";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<Child> getChildById(int id) {
        String sql = "SELECT * FROM Child WHERE id = ?";
        jdbcTemplate.query(sql, new Object[]{id}, rowMapper);
        return null;
    }

    @Override
    public Child creatChild(Child child) {
        String sql = "INSERT INTO Parent(name,birth_date) VALUES(?,?)";
        jdbcTemplate.update(sql, child.getName(),child.getBirth_date());
        return child;
    }

    @Override
    public  Child deleteGetById(int id) {
        String sql = "delete from parent where id=?";
        jdbcTemplate.update(sql, id);
        return null;
    }
    ;

    @Override
    public Child updateById(Child child, int id) {
        String sql = "UPDATE teacher SET name=?,surname=?, birth_date=?,job_name=? WHERE id=?";
        int update = jdbcTemplate.update(sql, id);
        return child;
    }
}
