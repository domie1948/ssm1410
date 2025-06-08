package com.design.framework.classes.service;

import java.util.List;

import com.design.framework.classes.model.Classes;

public interface ClassesService {
    int delete(Integer class_id);
    int add(Classes classes);
    Classes load(Integer class_id);
    int update(Classes classes);
    List<Classes> list();
    List<Classes> majorClassList(Integer class_major);
}
