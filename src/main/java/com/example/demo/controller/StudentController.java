package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.respository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jerry on 2017/8/14 0014.
 */
@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;
    //private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    /**
     * 查询所有学生列表
     *
     * @return
     */
    @GetMapping("/stu")
    public String getStuList(Model model){
        List<Student> list = studentRepository.findAll();
        model.addAttribute("list",list);
        model.addAttribute("username","Jerry");
        return "stu";
    }

  /*  public List<Student> stud{entList() {
        return studentRepository.findAll();
    }
*/
    /**
     * 新增一个学生
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/stuadd.json")
    public Map addStu(@RequestBody Student student) {
        student.setName(student.getName());
        student.setAge(student.getAge());
        studentRepository.save(student);
        return new HashMap();
    }

    //查询
    @GetMapping(value = "/stu/{id}")
    public Student studentFindOne(@PathVariable("id") Integer id) {
        return studentRepository.findOne(id);
    }

    //更新信息
    @PutMapping(value = "/stu/{id}")
    public Student studentUpdate(@PathVariable("id") Integer id,
                                 @RequestParam("name") String name,
                                 @RequestParam("age") Integer age) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        return studentRepository.save(student);
    }

//    /**
//     * 根据ID删除一个学生
//     *
//     * @param id
//     */
//    @DeleteMapping(value = "delstu.json")
//    public void studentDelete(@PathVariable("id") Integer id) {
//        studentRepository.delete(id);
//    }

    /**
     * 根据年龄查询学生的list
     *
     * @param age
     * @return
     */
    @GetMapping("/stu/age/{age}")
    public List<Student> studentByAge(@PathVariable("age") Integer age) {
        return studentRepository.findByAge(age);
    }

    /**
     * 事务管理一次添加两名学生
     */
    @PostMapping("/stu/addtwo")
    public void studentTwo() {
        studentService.insertTwo();
    }

    @GetMapping(value = "/stu/getAge/{id}")
    public  void getAge(@PathVariable("id") Integer id) throws Exception{
               studentService.getAge(id);
    }


 /*   @ResponseBody
    @RequestMapping(value = "/delstu.json")
    public void delStu(
            @RequestParam(value = "id", required = false, defaultValue = "") String id){
        studentService.delstu(id);

    }*/
/*

    @ResponseBody
    @RequestMapping("/selectstu.json")
    public Student findOneByid(@RequestParam("id") Integer id) throws Exception {
        return studentService.findbyid(id);

    }*/
 @ResponseBody
 @RequestMapping(value = "delstu.json",method = RequestMethod.POST)
 public Map delStu(
         @RequestParam("ids") List<Integer> ids) throws Exception{
     studentService.deleteBatchid(ids);
     return  new HashMap();
 }


}
