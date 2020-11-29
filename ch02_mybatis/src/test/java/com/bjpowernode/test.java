package com.bjpowernode;

import com.bjpowernode.bean.Student;
import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.impl.StudentDaoImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author free
 * @version 1.0
 */
public class test {
    @Test
    public void test01(){
        StudentDao dao=new StudentDaoImpl();
        List<Student> students = dao.selectStudents();
        for(Student s:students){
            System.out.println(s);
        }

    }

}
