package com.example.imtahan2.controller;

import com.example.imtahan2.entıty.Parent;
import com.example.imtahan2.servise.ParentServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")
public class ParentController {
    @Autowired
    private ParentServise servise;

    @GetMapping
    public List<Parent> getAllParent(){
      return servise.getAllParent();
    }
    @GetMapping("/Parent,{id}")
    public List<Parent> getParentById(@PathVariable int id){
        return servise.getParentById(id);
    }
    @PostMapping("/createparent")
    public Parent creatTeacher(@RequestBody Parent parent){
        return servise.creatTeacher(parent);
    }
    @DeleteMapping("deleteParent,{id}")
    public  Parent deleteGetById(@PathVariable int id){
        return servise.deleteGetById(id);
    }
    @PutMapping("/updateParent,{id}")
    public Parent updateById(@RequestBody Parent parent, @PathVariable int id){
        return servise.updateById(parent,id);
    }

}
