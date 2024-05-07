package assignment4;

import java.util.List;

public class StudentPrinter {
	  public void printStudent(Student student) {
	        System.out.println("Student ID: " + student.getStudentId());
	        System.out.println("Student Name: " + student.getStudentName());
	        System.out.println("Course: " + student.getCourse());
	        System.out.println("Grade: " + student.getGrade());
	        System.out.println();
	    }

	    public void printStudents(List<Student> students) {
	        for (Student student : students) {
	            printStudent(student);
	        }
	    }
	}

