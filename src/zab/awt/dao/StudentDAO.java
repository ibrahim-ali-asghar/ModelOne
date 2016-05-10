package zab.awt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import zab.awt.bean.Student;
import zab.awt.db.Database;

public class StudentDAO {
	public ArrayList<Student> getAllStudents(){
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			Statement stmt = Database.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");
			
			while(rs.next()){
				Student student = new Student();
				student.setRegno(rs.getInt("regno"));
				student.setStudentname(rs.getString("studentname"));
				
				students.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	
	public Student getStudentById(int regno){
		Student student = new Student();
		
		try {
			String sql = "SELECT * FROM student WHERE regno=?";
			PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
			pstmt.setInt(1, regno);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				student.setRegno(rs.getInt("regno"));
				student.setStudentname(rs.getString("studentname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
	}
	
	public int update(Student student){
		int result=0;
		try {
			String sql = "UPDATE student SET studentname=? WHERE regno=?";
			PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
			pstmt.setString(1, student.getStudentname());
			pstmt.setInt(2, student.getRegno());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
