package assignment4;

public class Main {

	 public static void main(String[] args) {
		  String csvFile = "master_list.csv";
	        
	        CSVParser csvParser = new CSVParser();
	        
	        // Parse the CSV file to obtain a list of Student objects
	        Student[] students = csvParser.parseCSV(csvFile);
	        
	        // Process and write the sorted data into separate CSV files
	        csvParser.processAndWriteCSV(students, "course1.csv", "COMPSCI");
	        csvParser.processAndWriteCSV(students, "course2.csv", "STAT");
	        csvParser.processAndWriteCSV(students, "course3.csv", "APMTH");
	        
	        System.out.println("CSV files have been generated successfully.");
	    }
	}
	


