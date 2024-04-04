package me.felipe.ac1.model;

import jakarta.persistence.Query;
import me.felipe.ac1.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final SessionFactory sessionFactory;

    public TaskRepositoryImpl() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Task> findAll() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        List<Task> tasks = session.createQuery("FROM Task", Task.class).getResultList();

        transaction.commit();
        return tasks;
    }

    @Override
    public Task findById(Long id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Task task = session.find(Task.class, id);
        transaction.commit();
        return task;
    }

    @Override
    public Task save(Task task) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(task);
        transaction.commit();
        return task;
    }

    @Override
    public Task delete(int id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        Task task = session.get(Task.class, id);
        if (task != null) {
            session.delete(task);
            transaction.commit();
            return task;
        } else {
            transaction.rollback();
            return null;
        }
    }
}
