package com.example.demo.respository;

import com.example.demo.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jerry on 2017/8/14 0014.
 */
public interface StudentRepository extends JpaRepository<Student,Integer>{

    //通过年龄查询
    public List<Student> findByAge(Integer age);

  /*  public List<Student> findByAgeAndName(Integer age,String name);
*/
    @Query(value = "DELETE FROM student WHERE id IN (?1) ",nativeQuery = true)
    @Modifying
    public void deleteAllBy(List<Integer> ids);

    Page<Student> findByNameNot(String name, Pageable pageable);

/*    @Query(value = "SELECT * FROM student WHERE id = ?1",nativeQuery = true)
    @Modifying
    public Student findById(Integer id);*/


}
