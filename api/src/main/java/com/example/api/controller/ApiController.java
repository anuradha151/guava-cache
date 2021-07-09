package com.example.api.controller;

import com.example.api.datacache.CacheStore;
import com.example.api.entities.Student;
import com.example.api.entities.Parent;
import com.example.api.services.StudentService;
import com.example.api.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author - Anuradha Ranasinghe on 2021-07-07
 * @project - GuavaCache
 **/
@RestController
public class ApiController {

    @Autowired
    StudentService studentService;

    @Autowired
    CacheStore<Student> studentCache;

    @Autowired
    ParentService parentService;

    @Autowired
    CacheStore<String> parentNameCache;


    @GetMapping("/student/{id}")
    public Student searchStudentByID(@PathVariable String id) {
        System.out.println("Searching Student by ID  : " + id);

        Student cachedStudRecord = studentCache.get(id);
        if(cachedStudRecord != null) {
            System.out.println("Student record found in cache : " + cachedStudRecord.getName());
            return cachedStudRecord;
        }

        Student studRecordFromBackendService = studentService.getStudentByID(id);

        studentCache.add(id, studRecordFromBackendService);

        return studRecordFromBackendService;
    }

    @GetMapping("/parent/{id}")
    public String searchParentNameByID(@PathVariable String id) {
        System.out.println("Searching Parent Name by ID  : " + id);

        String cachedParentName = parentNameCache.get(id);
        if(cachedParentName != null) {
            System.out.println("Parent name found in cache : " + cachedParentName);
            return cachedParentName;
        }

        Parent parentFromBackendService = parentService.getParentByID(id);

        parentNameCache.add(id, parentFromBackendService.getName());

        return parentFromBackendService.getName();
    }

}
