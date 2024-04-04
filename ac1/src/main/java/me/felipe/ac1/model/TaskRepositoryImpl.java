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
        session.remove(task);
        transaction.commit();
        return task;
    }

    @Override
    public Task delete(int id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();


        String hqlQuery = "DELETE FROM Task WHERE id = :taskId";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("taskId", id);

        int deletedCount = query.executeUpdate();
        transaction.commit();

        if (deletedCount > 0) {

            return new Task();
        } else {
            return null;
        }
    }
}
