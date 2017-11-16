package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.properties.InfoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry on 2017/8/14 0014.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
   /* @Autowired
    private InfoRespository infoRespository;

    //@RequestMapping(value = "/say",method = RequestMethod.GET)
    @GetMapping("/say")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){
        return "id:"+myId;
    }
    @RequestMapping(value = "/sayParam",method = RequestMethod.GET)
    public String sayParam(){
        return infoRespository.getName();
    }*/

   @RequestMapping(value = "/demo",method = RequestMethod.GET)
   public String demo(){
       return "demo";
   }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        List<Student> list = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            Student s = new Student();
            s.setId(i+1);
            s.setName("我是"+i+"号");
            s.setAge(22+i);
            list.add(s);
        }
        model.addAttribute("list",list);
        model.addAttribute("name","Dear");
        return "index";
    }

/*    @RequestMapping(value = "/data",method = RequestMethod.POST)
    @ResponseBody
    public List<Student> data(Model model){
        List<Student> list = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            Student s = new Student();
            s.setId(i+1);
            s.setName("我是"+i+1+"号");
            s.setAge(22+i);
            list.add(s);
        }
        model.addAttribute("list",list);
        return list;
    }*/
}
