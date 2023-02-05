package ru.shikhov.lesson5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class StudentDao {
    private EntityManagerFactory emFactory;

    public StudentDao(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public Optional<Student> findById(long id) {
        return executeForEntityManager(entityManager -> Optional.ofNullable(entityManager.find(Student.class, id)));
    }

    public List<Student> findAll() {
        return executeForEntityManager(entityManager ->
                entityManager.createNamedQuery("findAllStudents", Student.class).getResultList());
    }

    public void delete(long id) {
        executeInTransactional(entityManager -> entityManager.createNamedQuery("deleteStudentById").
                setParameter("id", id)
                .executeUpdate());
    }

    public void save(Student student) {
        executeInTransactional(entityManager -> {
            if(student.getId() == null) {
                entityManager.persist(student);
            } else {
                entityManager.merge(student);
            }
        });
    }

    private <E> E executeForEntityManager(Function<EntityManager, E> function) {
        EntityManager em = emFactory.createEntityManager();
        return function.apply(em);
    }

    private void executeInTransactional(Consumer<EntityManager> consumer) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        consumer.accept(em);
        em.getTransaction().commit();
        em.close();
    }
}
