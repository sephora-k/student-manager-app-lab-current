package ie.gmit.studentmanager;

public class Main {
    
    public static void main(String[] args){
        // Create a new menu object
 //   	Menu menuObject1 = new Menu();
    	// Run the start method of the Menu object 
 //   	menuObject1.display();
    	
    	// Test StudentManagerObject Class
    	StudentManager smObject1 = new StudentManager();
    	smObject1.loadStudentFile(".\\resources\\students.csv");
    	//System.out.println(    smObject1.findTotalStudents()   );
 //   	smObject1.findStudentById("G00654323");
    	System.out.println(   smObject1.findTotalStudents()    );
//    	Student student1 = new Student("G00123456");
//    	smObject1.addStudent(student1);
    	Student student = smObject1.findStudentById("G00654324");
    	System.out.println(student.getFirstName());
//    	System.out.println(student);
    	
    }
}
