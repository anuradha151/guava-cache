package com.example.api.services;

import com.example.api.entities.Student;
import org.springframework.stereotype.Service;

/**
 * @author - Anuradha Ranasinghe on 2021-07-07
 * @project - GuavaCache
 **/
@Service
public class StudentService {


    public Student getStudentByID(String id)
    {
        try
        {
            //Simulate backend service by forcing thread to sleep
            System.out.println("Going to sleep for 5 Secs... to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //Return dummy Student record
        return new Student(id,"Student Name " + id ,"Engineer");
    }
}
