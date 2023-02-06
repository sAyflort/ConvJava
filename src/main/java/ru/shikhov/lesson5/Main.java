package ru.shikhov.lesson5;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        StudentDao studentDao = new StudentDao(entityManagerFactory);

        /*for (int i = 1; i <= 1000; i++) {
            Student st = new Student();
            st.setName("Name"+i);
            st.setMark((int)(Math.random()*5+1));
            studentDao.save(st);
        }*/

        List<Student> studentList = studentDao.findAll();
        System.out.println(studentList.size());
        //studentDao.delete(101);
        Optional<Student> student = studentDao.findById(200);
        System.out.println(student.get().getName());
        studentDao.save(new Student("Nobody", 4));
    }
}
