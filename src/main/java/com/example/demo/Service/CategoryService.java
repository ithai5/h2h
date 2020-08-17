package com.example.demo.Service;

import com.example.demo.Model.Category;
import com.example.demo.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> fetchAll(){
        return categoryRepo.fetchAll();
    }
}
