package ru.shikhov.lesson5;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "students")
@NamedQueries({
        @NamedQuery(name = "findAllStudents", query = "Select st from Student st"),
        @NamedQuery(name = "deleteStudentById", query = "delete from Student st where st.id = :id")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private int mark;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }
}
