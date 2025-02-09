package com.example.demo.DB;
import java.util.List;

import com.example.demo.models.Bed;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.demo.models.Student;
import com.example.demo.utils.HibernateUtil;
public class StudentDaoHbnt {
    /**
     * Save Student
     *
     * @param student
     */
    public void saveStudent(Student student) {
        Transaction transaction = null;
        System.out.println("Wo a nyiii");
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(student);
            // commit transaction
            transaction.commit();

            System.out.println(" New student added using hibernate okey");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * save bed
     *
     * @param bed
     */
    public Long saveBed(Bed bed) {
        Transaction transaction = null;
        System.out.println("hello");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            Long bedId = (Long) session.save(bed);
            // save the student object
//            session.save(bed);
            // commit transaction
            transaction.commit();
            return bedId;
//            System.out.println(" New bed added using hibernate okey");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return bed.getId();
    }
    /**
     * Update Student
     *
     * @param student
     */
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * Delete Student
     *
     * @param id
     */
    public void deleteStudent(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a student object
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                System.out.println("student is deleted");
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * Get Student By ID
     *
     * @param id
     * @return
     */
    public Student getStudent(Long id) {
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an student object
            student = session.get(Student.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }
    /**
     * Get all Students
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Student> getAllStudent() {
        Transaction transaction = null;
        List<Student> listOfStudent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an student object
            listOfStudent = session.createQuery("from Student").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfStudent;
    }
}

