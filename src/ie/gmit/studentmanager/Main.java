package ie.gmit.studentmanager;

import java.io.File;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application implements Serializable {

	private static final long serialVersionUID = 1L; // Used for serialization
	StudentManager sm = new StudentManager(); // Used for managing students

	@Override
	public void start(Stage primaryStage) {
		// Create TextArea node for bottom of scene 1
		TextArea taMyOutput = new TextArea();
		taMyOutput.setPrefHeight(100); // sets height of the TextArea to 400 pixels
		taMyOutput.setPrefWidth(100); // sets width of the TextArea to 300 pixels

		// Show total number of students
		Button btnShowTotal = new Button("Show Total Students");
		TextField tfTotalNumberOfStudents = new TextField();

		tfTotalNumberOfStudents.setEditable(false); // This box is not editable. Only displays result.
		tfTotalNumberOfStudents.setPromptText("0");

		btnShowTotal.setOnAction(e -> {

			// Code to run when button is clicked
			tfTotalNumberOfStudents.setText(Integer.toString(sm.findTotalStudents()));

		});

		// Add Student arrangement
		Button btnAddStudent = new Button("Add Student");
		TextField tfStudentID = new TextField();

		tfStudentID.setPromptText("Enter Student ID");

		btnAddStudent.setOnAction(e -> {
			if (tfStudentID.getText().trim().equals("")) { // If text field is empty

				taMyOutput.setText("Invalid");
			} else {

				Student student = new Student(tfStudentID.getText());
				sm.addStudent(student); // Add student to student list
				tfStudentID.clear();
			}
		});

		// Delete Student arrangement
		TextField tfStudentDel = new TextField();
		Button btnDelStudent = new Button("Delete Student");

		tfStudentDel.setPromptText("Enter Student ID");

		btnDelStudent.setOnAction(e -> {

			sm.deleteStudentById(tfStudentDel.getText());

		});

        //Save to Database (file)
        Button btnSaveDB = new Button("Save Students to DB");
        //Attach event handle (assign action)
		btnSaveDB.setOnAction(e -> {

          //serialize students to manager
          if(sm.findTotalStudents() > 0 ) {
          try {
            File studentDB = new File("./resources/studentsDB.ser"); //where files will be serialized
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(studentDB));
            out.writeObject(sm);
            out.close();
            taMyOutput.setText("Student DataBase Saved"); //text area

          }catch (Exception exception) { //catches errors that can possibly happen
            System.out.println("Error cannot save to DB");
            exception.printStackTrace();
            taMyOutput.setText("ERROR: Failed to save students to DB!");

        }

    } else {

        taMyOutput.setText("No students in list!");
    }


		});

		// Adding and arranging all the nodes in the grid - add(node, column, row)
		GridPane gridPane1 = new GridPane();
		gridPane1.add(tfStudentID, 0, 0);
		gridPane1.add(btnAddStudent, 1, 0);
		gridPane1.add(btnShowTotal, 0, 1);
		gridPane1.add(tfTotalNumberOfStudents, 1, 1);
		gridPane1.add(tfStudentDel, 0, 2);
        gridPane1.add(btnDelStudent, 1, 2);
        gridPane1.add(btnSaveDB, 0, 3);
		gridPane1.add(taMyOutput, 0, 4, 2, 1);

		// Preparing the Stage (i.e. the container of any JavaFX application)
		// Create a Scene by passing the root group object, height and width
		Scene scene1 = new Scene(gridPane1, 400, 450);
        // Setting the title to Stage.
        
        if (getParameters().getRaw().size() == 0){
            primaryStage.setTitle("Student Manager App ");
        } else{
            primaryStage.setTitle(getParameters().getRaw().get(0));
        }
    
        // Setting the scene to Stage
		primaryStage.setScene(scene1);
		// Displaying the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
