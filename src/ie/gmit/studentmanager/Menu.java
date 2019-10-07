package ie.gmit.studentmanager;

import java.util.Scanner;

public class Menu {
	private Scanner userInput;
	private StudentManager studentManagerObject;
	private boolean keepRunning;
	
	// Constructor Method
	public Menu() {
		// Create new scanner object to capture input from the user
		userInput = new Scanner(System.in);
		studentManagerObject = new StudentManager(); // Create a new StudentManager object
		keepRunning = true; // Initialise loop checker
	}

	public void display() {
		while (keepRunning) {
			// Display Menu to user
			showOptions();

			// Save user Menu option selection
			int userMenuOption = userInput.nextInt();

			// Execute option
			selectOption(userMenuOption);
		}
	}

	private void showOptions() {
		System.out.println("###################################");
		System.out.println("#         Student Manager         #");
		System.out.println("###################################");
		System.out.println("(1) Load Student DB");
		System.out.println("(2) Add a Student.");
		System.out.println("(3) Delete a Student.");
		System.out.println("(4) Search for a Student by ID.");
		System.out.println("(5) Search for Students by Firt Name.");
		System.out.println("(6) Show total Number of Students.");
		System.out.println("(7) Save DB.");
		System.out.println("(8) Quit.");
		System.out.println("Select an option [1-6]>");
	}

	private void selectOption(int userSelection) {
		if (userSelection == 1) { // Load Students DB
			System.out.println("User Selected 1");
			keepRunning = false;
		} else if (userSelection == 2) { // Add Student
			System.out.println("Enter Student ID>");
			String studentId = userInput.next();
			Student newStudentObject = new Student(studentId);
			
			boolean result = studentManagerObject.addStudent(newStudentObject);

			if (result) {
				System.out.println("Student " + studentId + " has been added successfully.");
			} else {
				
				System.out.println("ERROR: Student " + studentId +"  was not added!");
			}
		}
	}

	private void addStudent() {
	}

	private void deleteStudent() {
	}

	private void searchByID() {
	}

	private void searchByName() {
	}

	private void findTotal() {
		System.out.println("Total number of students = " + studentManagerObject.findTotalStudents());
	}

}
