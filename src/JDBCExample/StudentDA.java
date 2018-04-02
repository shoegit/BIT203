/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCExample;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author ngsm
 */
public class StudentDA {
    
    private Connection conn;
    
    /**
     * method to save a Student info into the database
     * @param s a Student object
     * @return true if the database is connected succesffuly and student detailed entered
     */
    public boolean save(Student s) 
    {
        Statement stmt = null;
        try {
            conn = MySQLDBConnection.getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO student VALUES ('" +
                    s.getStudentID() + "','"+s.getName() 
                    + "',"+s.getScore() +")";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            return true;
        }
        catch(SQLException se)
        {
            se.printStackTrace();
            return false;
        }
        finally 
        {
            try {
                if (stmt!=null) stmt.close();
                if (conn!=null) conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
                return false;
            }
        }
    }
    
    /**
     * A method to return a Student object from data in
     * the database
     * @param studentID
     * @return Student object if the studentID is found
     * 
     */
    public Student getStudent(String studentID)
    {
        Statement stmt = null;
        Student s = null;
        try {
            conn = MySQLDBConnection.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT studentName, score ";
            sql += "FROM student WHERE studentID = '";
            sql += studentID +"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next())
            {    // retrieve by column name 
                String studentName = rs.getString("studentName");
                double score = rs.getDouble("score");
                s = new Student(studentID, studentName, score);
            }
            rs.close();
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        finally {
            try {
                if (stmt!=null) stmt.close();
                if (conn!=null) conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }
        return s;
    }
}
