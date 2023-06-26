package com.example.imtahan2.servise;

import com.example.imtahan2.entıty.Parent;
import com.example.imtahan2.reporsitory.ParentReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServise {
    @Autowired
    private ParentReporsitory repository;
    public List<Parent> getAllParent(){
        return  repository.getAllParent();
    }
    public Parent getParentById(int id){
        return repository.getParentById(id);
    }
    public Parent creatTeacher(Parent parent){
        return repository.creatTeacher(parent);
    }
    public  Parent deleteGetById(int id){
        return repository.deleteGetById(id);
    }
    public Parent updateById(Parent parent, int id){
        return repository.updateById(parent,id);
    }
}
