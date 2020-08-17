package com.example.demo.Repository;

import com.example.demo.Model.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepo extends DbInteraction {

    public List<Category> fetchAll(){
        String query = "SELECT * FROM Catergory";
        RowMapper<Category> rowMapper = new BeanPropertyRowMapper<>(Category.class);
        return template.query(query, rowMapper);
    }
}
