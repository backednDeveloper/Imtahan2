package com.example.imtahan2.reporsitory;

import com.example.imtahan2.entıty.Child;
import com.example.imtahan2.entıty.Parent;

import java.util.List;

public interface ChildReporsitory1 {
    List<Child> getAllChild();

    List<Child> getChildById(int id);


    Child creatChild(Child child);

    Child deleteGetById(int id);

    Child updateById(Child child, int id);
}
