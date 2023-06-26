package com.example.imtahan2.reporsitory;

import com.example.imtahan2.entıty.Parent;

import java.util.List;

public interface Reporsitory {
    public List<Parent> getAllParent();
    public List<Parent> getParentById(int id);
    public Parent creatTeacher(Parent parent);
    public Parent deleteGetById(int id);
    public Parent updateById(Parent parent, int id);
}
