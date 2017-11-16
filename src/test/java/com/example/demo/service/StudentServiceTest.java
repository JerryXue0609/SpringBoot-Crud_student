package com.example.demo.service;

import com.example.demo.domain.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Jerry on 2017/8/16 0016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;
    @Test
    public void findOne() throws Exception {
        Student student = studentService.findOne(1);
        Assert.assertEquals(new Integer(18),student.getAge());
    }
    @Test
    public void addTwo() throws Exception{

        studentService.insertTwo();
    }
   /* @Test
    public void deleteBatchid() throws Exception{
        String ids = "6,7";
        studentService.deleteBatchid(ids);
    }*/

}