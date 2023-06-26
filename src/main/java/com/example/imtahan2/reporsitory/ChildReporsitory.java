package com.example.imtahan2.reporsitory;

import com.example.imtahan2.entıty.Child;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChildReporsitory implements ChildReporsitory1 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private  RowMapper<Child> rowMapper = (rs, rowNum) -> (new Child(
            rs.getInt(1),
            rs.getString(2),
            rs.getDate(4)
    ));
    @Override
    public List<Child> getAllChild() {
        String sql = "select * from Child";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public List<Child> getChildById(int id) {
        String sql = "SELECT * FROM Child WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, rowMapper);

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
        String sql = "UPDATE teacher SET name=?,birth_date=? WHERE id=?";
        jdbcTemplate.update(sql, child.getName(), child.getBirth_date(), getChildById(id));
        return child;
    }
}
