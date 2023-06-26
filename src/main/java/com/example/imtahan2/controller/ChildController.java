package com.example.imtahan2.controller;

import com.example.imtahan2.entıty.Child;
import com.example.imtahan2.servise.ChildServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("child")
public class ChildController {
    @Autowired
    private ChildServise servise;
@GetMapping
public List<Child> getAllChild(){
    return servise.getAllChild();
}
@GetMapping("getChildById,{id}")
    public List<Child> getChildById(int id){
    return servise.getChildById(id);
    }
    @PostMapping("createChild")
    public Child creatChild(Child child){
    return servise.creatChild(child);
    }
    @DeleteMapping("deleteChild,{id}")
    public Child deleteGetById(int id){
    return servise.deleteGetById(id);
    }
    @PutMapping("updateChild,{id}")
    public Child updateById(Child child, int id){
    return servise.updateById(child,id);
    }

}
