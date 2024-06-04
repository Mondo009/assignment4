package assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CSVParser {
    public Student[] parseCSV(String csvFile) {
       // List<Student> students = new ArrayList<>(); // Array [5]
    	Student[] students = new Student[110];
    	int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String studentId = data[0];
                String studentName = data[1];
                String course = data[2];
                String grade = data[3]; // Modified to String
                students[i] = new Student(studentId, studentName, course, grade);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Arrays.copyOf(students, i); 
        }

        public void processAndWriteCSV(Student[] students, String csvFileName, String course) {
            Arrays.sort(students, Comparator.comparing(Student::getGrade).reversed());
            writeCSVFiles(students, csvFileName, course);
        }

        private void writeCSVFiles(Student[] students, String csvFileName, String course) {
            System.out.println(Arrays.toString(students));
            System.out.println("Creating file:" + csvFileName);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileName))) {
                writer.write("Student ID,Student Name,Course,Grade\n");
                int studentCount = 0;
                for (Student student : students) {
                    if (student.getCourse().contains(course)) {
                        writer.write(student.getStudentId() + "," + student.getStudentName() + "," +
                                student.getCourse() + "," + student.getGrade() + "\n");
                        studentCount++;
                    }
                }
                System.out.println("Number of Students written for " + course + ": " + studentCount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String[] getCourses(Student[] students) {
            return Arrays.stream(students)
                    .map(Student::getCourse)
                    .distinct()
                    .toArray(String[]::new);
        }
    }

//        return students;
//    }
//
//    public void processAndWriteCSV(List<Student> students, String csvFileName, String course) {
//        Collections.sort(students, Comparator.comparing(Student::getGrade).reversed());
//        writeCSVFiles(students, csvFileName, course);
//    }
//
//    private void writeCSVFiles(List<Student> students, String csvFileName, String course) {
//    	System.out.println(students);
////            String csvFileName = course.toLowerCase().replaceAll("\\s", "") + ".csv";
//            System.out.println("Creating file:" + csvFileName);
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileName))) {
//                writer.write("Student ID,Student Name,Course,Grade\n");
//                int studentCount = 0;
//                for (Student student : students) {
//                	System.out.println(student.getCourse());
//                    if (student.getCourse().contains(course)) {
//                        writer.write(student.getStudentId() + "," + student.getStudentName() + "," +
//                                student.getCourse() + "," + student.getGrade() + "\n");
//                        studentCount++;
//                    }
//                }
//                System.out.println("Number of Students written for"+ course +":" + studentCount);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//    }
//
//    private List<String> getCourses(List<Student> students) {
//        return students.stream()
//                .map(Student::getCourse)
//                .distinct()
//                .collect(Collectors.toList());
//    }
//}
//	public List<Student> parseCSV(String csvFile) {
//	  List<Student> students = new ArrayList<>();
//
//      try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//          String line;
//          br.readLine();
//          while ((line = br.readLine()) != null) {
//              // Parse each line and create a student object
//              Student student = parseStudent(line);
//              if (student != null) {
//                  students.add(student);
//              }
//          }
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//
//      return students;
//  }
//
//  private Student parseStudent(String line) {
//	  String[] fields = line.split(",");
//	  if (fields.length <4 || fields [0].equals("Student ID" )) {
//	return null;
//	  }
//	  String studentId = fields[0];
//	  String studentName = fields[1];
//	  String course = fields [2];
//	  String grade = fields [3];
//	   
//	  return new Student(studentId, studentName, course, grade);
//  }
//	  
      // Implement logic to parse each line and create a student object
      // You'll need to split the line into fields and extract student attributes
      // Create a new Student object with the extracted attributes and return it
      // Return null if the line cannot be parsed or if it's a header line
  


