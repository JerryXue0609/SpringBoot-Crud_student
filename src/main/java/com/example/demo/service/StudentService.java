package com.example.demo.service;

import com.example.demo.exception.StuException;
import com.example.demo.respository.StudentRepository;
import com.example.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Jerry on 2017/8/14 0014.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void insertTwo(){
        Student s1 = new Student();
        s1.setName("骑士");
        s1.setAge(22);
        studentRepository.save(s1);

        Student s2 = new Student();
        s2.setName("狂战士");
        s2.setAge(22);
        studentRepository.save(s2);
    }

    public void getAge(Integer id) throws Exception{
        Student student = studentRepository.findOne(id);
        Integer age = student.getAge();
        if (age<10){
            throw new StuException(100,"你是小孩子。。");
        }else if (age>10 && age<18){
            throw new StuException(101,"你是小青年。。");
        }
    }

/*    public void delstu(String id){
        studentRepository.delete(Integer.valueOf(id));
    }*/

    public Student findOne(Integer id){
        return studentRepository.findOne(id);
    }

    @Transactional
    public void deleteBatchid(List<Integer> ids) throws Exception{
        studentRepository.deleteAllBy(ids);
    }

/*
    @Transactional
    public Student findbyid(Integer id){
        return studentRepository.findById(id);
    }
*/


}
