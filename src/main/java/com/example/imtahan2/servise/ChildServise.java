package com.example.imtahan2.servise;

import com.example.imtahan2.entıty.Child;
import com.example.imtahan2.reporsitory.ChildReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildServise {
    @Autowired
    private ChildReporsitory reporsitory;
    public List<Child> getAllChild(){
        return reporsitory.getAllChild();
    }
    public List<Child> getChildById(int id){
        return  reporsitory.getChildById(id);
    }
    public Child creatChild(Child child){
        return reporsitory.creatChild(child);
    }
    public Child deleteGetById(int id){
       return reporsitory.deleteGetById(id);
    }
    public Child updateById(Child child, int id){
        return reporsitory.updateById(child,id);
    }

}
