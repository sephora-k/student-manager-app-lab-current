package ie.gmit.studentmanager;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

	// Declare a List called students to hold the student objects
	private List<Student> studentList;

	// Constructor
	public StudentManager() {
		// Instantiating a new students ArrayList
		studentList = new ArrayList<Student>();
	}

	// Getters and Setters
	public List<Student> getStudents() {
		return studentList;
	}

	public void setStudents(List<Student> students) {
		this.studentList = students;
	}

	// Class Methods
	public boolean addStudent(Student student) {
		// Using Collections add method. It returns true if this collection
		// changed as a result of the call
		return studentList.add(student);
	}

	public boolean deleteStudent(Student student) {
		// Using Collections remove method. It returns true if this list
		// contained the specified element
		return studentList.remove(student);
	}

	public boolean deleteStudentById(String studentId) {
		// Search for the Student by ID
		Student student = findStudentById(studentId);
		// If a Student with given ID was found then delete the student
		if(student != null) { 
			deleteStudent(student);
			return true;
		}
		return false;
	}

	public Student findStudentById(String studentId) {
		return null;
	}

	// Find a list of student by first name
	public List<Student> findStudentsByFirstName(String firstName) {
		return null;
	}

	public int findTotalStudents() {
		// returns the current number of Students in the ArrayList
		return studentList.size();
	}

}