package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Insert objek students
            Students newStudent = new Students();
            newStudent.setName("Omar");
            newStudent.setAge(18);
            newStudent.setMajor("IMT");
            session.save(newStudent);

            // Update objek students
            Students studentToUpdate = session.get(Students.class, 1);
            if (studentToUpdate != null) {
                studentToUpdate.setName("Deny Wahyudi");
                studentToUpdate.setAge(19);
                session.update(studentToUpdate);
            }

            // Delete objek students
            Students studentToDelete = session.get(Students.class, 2);
            if (studentToDelete != null) {
                session.delete(studentToDelete);
            }

            // Select objek students
            Students studentToFind = session.get(Students.class, 3);
            if (studentToFind != null) {
                System.out.println("Student Found: " + studentToFind.getName());
            }


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {  
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        HibernateUtil.shutdown();
    }
}
