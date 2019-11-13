package ie.gmit.studentmanager;

import java.io.Serializable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application implements Serializable {

	private static final long serialVersionUID = 1L; // Used for serialization
	StudentManager sm = new StudentManager(); // Used for managing students

	@Override
	public void start(Stage primaryStage) {

		// Show total number of students
		Button btnShowTotal = new Button("Show Total Students");
		TextField tfTotalNumberOfStudents = new TextField();

		tfTotalNumberOfStudents.setEditable(false); // This box is not editable. Only displays result.
		tfTotalNumberOfStudents.setPromptText("0");

		btnShowTotal.setOnAction(e -> {

			// Code to run when button is clicked
			tfTotalNumberOfStudents.setText(Integer.toString(sm.findTotalStudents()));

		});

		// Adding and arranging all the nodes in the grid - add(node, column, row)
		GridPane gridPane1 = new GridPane();
		gridPane1.add(btnShowTotal, 0, 0);
		gridPane1.add(tfTotalNumberOfStudents, 1, 0);

		// Preparing the Stage (i.e. the container of any JavaFX application)
		// Create a Scene by passing the root group object, height and width
		Scene scene1 = new Scene(gridPane1, 400, 450);
		// Setting the title to Stage.
		primaryStage.setTitle("Student Manager Application");
		// Setting the scene to Stage
		primaryStage.setScene(scene1);
		// Displaying the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
