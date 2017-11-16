package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.respository.StudentRepository;
import com.example.demo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Jerry on 2017/8/16 0016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {


    @Autowired
    private StudentService studentService;

  /*  @Test
    public void findOneByid() throws Exception {
        int id = 2;
        studentRepository.findById(id);
    }
*/
 /* @Test
  public void deletebyid() throws Exception{
      String id = "8";
      studentService.delstu(id);
  }*/
  @Test
    public void deleteBatchid() throws Exception {
       List<Integer> ids = new ArrayList<>();
       ids.add(10);
       ids.add(12);
        studentService.deleteBatchid(ids);
    }

    @Autowired
    private MockMvc mvc;

    @Test
    public void studentList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/stu"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}