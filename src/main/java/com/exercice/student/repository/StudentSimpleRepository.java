package com.exercice.student.repository;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.exercice.student.ConnectionDB;
import com.exercice.student.modele.Student;

public class StudentSimpleRepository implements Serializable{

    //select * from student
    public static List<Student> findAll(){
        List<Student> results = new ArrayList<>();
        try {
            ConnectionDB co = ConnectionDB.getConnection();
            Statement stm = co.getStm();
            ResultSet rs = stm.executeQuery("SELECT * FROM student");

            while(rs.next()){
                results.add(new Student(
                    rs.getString("id_student"),
                    rs.getString("name"),
                    rs.getBoolean("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }   

    // insert
    public static Student save(Student s){

        try {
            ConnectionDB co = ConnectionDB.getConnection();
            Statement stm = co.getStm();
            stm.executeUpdate("INSERT INTO student VALUES('"+s.getId_student()+",'"+s.getName()+"',"+s.getStatus()+")");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    };    

    public static Optional<Student> findById(String id){
        Optional<Student> st = null;
        try {
            ConnectionDB co = ConnectionDB.getConnection();
            Statement stm = co.getStm();
            ResultSet rs = stm.executeQuery("SELECT * FROM student WHERE id_student = '"+id+"'");

            Student student = new Student(
                rs.getString("id_student"),
                rs.getString("name"),
                rs.getBoolean("status")
            );

            st = Optional.ofNullable(student);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    };    

    // delete
    public static void deleteById(String id){
        try {
            ConnectionDB co = ConnectionDB.getConnection();
            Statement stm = co.getStm();
            stm.executeQuery("DELETE FROM student WHERE id_student = '"+id+"'");
            System.out.println("Delete Successfull");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   

    //select * from student where name like '%query%'
    public static List<Student> findWhereNameLike(String query){
        List<Student> results = new ArrayList<>();
        try {
            ConnectionDB co = ConnectionDB.getConnection();
            Statement stm = co.getStm();
            ResultSet rs = stm.executeQuery("SELECT * FROM student WHERE name like '%"+query+"%'");

            while(rs.next()){
                results.add(new Student(
                    rs.getString("id_student"),
                    rs.getString("name"),
                    rs.getBoolean("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
    
}
