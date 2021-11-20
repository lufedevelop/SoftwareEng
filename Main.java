// Author: Jacob Lavoie 1108243
// This is a prototype GUI implementation for myResidence
package sample;

// importing javafx libraries
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

// public class Main extends Application
public class Main extends Application {

    // overriding start void function
    @Override
    // function start houses all available assets
    public void start(Stage primaryStage) throws Exception{
        // title for window
        primaryStage.setTitle("myResidence");
        // window width
        primaryStage.setWidth(600);
        // window height
        primaryStage.setHeight(500);

        // Declaring HBoxes and VBoxes for use when necessary
        HBox displayLogin = new HBox();
        VBox loginCredentials = new VBox();
        VBox studentPermissions = new VBox();
        VBox managerPermissions = new VBox();

        // Declaring text field for entering credentials on main screen
        TextField displayUserName = new TextField();
        TextField displayPassWord = new TextField();

        // Declaring Labels for naming attributes on screen
        Label errorMessageField = new Label(""); // error message window displayable
        errorMessageField.setTextFill(Color.RED); // all error text is red to stand out
        Label user = new Label("Username:"); // labeling username text field
        Label pass = new Label("Password:"); // labeling password text field

        // Declaring button for checking credentials once user is ready to enter credentials
        Button login = new Button("LOGIN");

        // main screen consists of one HBox housing two different attributes
        displayLogin.getChildren().addAll(loginCredentials);
        // spacing for each is 10
        displayLogin.setSpacing(10);

        // the loginCredentials VBox consists of the username field, password field, and login button mainly
        loginCredentials.getChildren().addAll(user, displayUserName, pass, displayPassWord, errorMessageField, login);
        // spacing is also 10
        loginCredentials.setSpacing(10);

        // Title for final product concerning student permissions
        // Declaring label placeholders for final product
        Label studentPerm = new Label("List of Available Permissions for Student:");
        Label stuPermX = new Label("Searching for Residencies");
        Label stuPermY = new Label("Registering for Residencies");
        // VBox for student permissions once entrance is granted
        studentPermissions.getChildren().addAll(studentPerm,stuPermX,stuPermY);
        // spacing between attributes is 5
        studentPermissions.setSpacing(5);

        // Titles for final product concerning manager permissions
        // Declaring label placeholders for final product
        Label managerPerm = new Label("List of Available Permissions for Manager");
        Label manPermA = new Label("Searching for Residencies");
        Label manPermB = new Label("Registering for Residencies");
        Label manPermC = new Label("Adding / Subtracting Rooms to / from the Registry");
        Label manPermD = new Label("Modifying Rooms");
        Label manPermE = new Label("Approving / Denying Application Requests");
        // VBox for manager permissions once entrance is granted
        managerPermissions.getChildren().addAll(managerPerm,manPermA,manPermB,manPermC,manPermD,manPermE);
        // spacing between attributes is 5
        managerPermissions.setSpacing(5);

        FlowPane studentRoot = new FlowPane();
        studentRoot.getChildren().addAll(studentPermissions);

        FlowPane managerRoot = new FlowPane();
        managerRoot.getChildren().addAll(managerPermissions);

        // flow pane for main login screen organization of attributes
        FlowPane loginRoot = new FlowPane();
        // adding all attributes for the main login screen
        loginRoot.getChildren().addAll(displayLogin,loginCredentials);
        // alignment is set for the center of the window
        loginRoot.setAlignment(Pos.CENTER);

        // declaring the login screen scene
        Scene loginScene = new Scene(loginRoot, 300, 250);
        // setting scene for login
        primaryStage.setScene(loginScene);
        // show this stage / scene
        primaryStage.show();

        // on clicking the login button
        login.setOnAction(e -> {
            // if both text fields are empty
            if ((displayUserName.getText().equals("")) && (displayPassWord.getText().equals(""))) {
                // displays that both requirements are missing to the user
                errorMessageField.setText("Missing Username & Password");
            } // end if
            // if the username is missing
            if ((displayUserName.getText().equals("")) && (displayPassWord.getText() != "")) {
                // displays the username is missing to the user
                errorMessageField.setText("Missing Username");
            } // end if
            // if the password is missing
            if ((displayUserName.getText() != "") && (displayPassWord.getText().equals(""))) {
                // displays the password is missing to the user
                errorMessageField.setText("Missing Password");
            } // end if
            // if both of the fields are not empty
            if ((displayUserName.getText() != "") && (displayPassWord.getText() != "")) {
                    // if entered credentials equal some credentials in database
                        // complete login (function call)
                        // if student, setStudent()
                        // USE THIS FUNCTION CALL FOR SUCCESSFUL STUDENT LOGIN -> setStudent(studentRoot,primaryStage);
                        // if manager, setManager()
                        // USE THIS FUNCTION CALL FOR SUCCESSFUL MANAGER LOGIN -> setManager(managerRoot,primaryStage);
                // if entered credentials DO NOT equal some credentials in database
                    // errorMessageField.setText("Incorrect Credentials");
            } // end if
        }); // end setOnAction
    } // end function start

    // function void setStudent includes the flow pane and stage arguments
    public void setStudent(FlowPane studentPane, Stage studentStage) {
        // title for window
        studentStage.setTitle("myResidence: STUDENT");
        // window width
        studentStage.setWidth(600);
        // window height
        studentStage.setHeight(500);
        // student scene declaration
        Scene studentScene = new Scene(studentPane, 300, 300);
        // setting scene for student instance
        studentStage.setScene(studentScene);
        // showing student scene
        studentStage.show();
    } // end of function setStudent

    // function void setManager includes the flow pane and stage arguments
    public void setManager(FlowPane managerPane, Stage managerStage) {
        // title for window
        managerStage.setTitle("myResidence: MANAGER");
        // window width
        managerStage.setWidth(600);
        // window height
        managerStage.setHeight(500);
        // manager scene declaration
        Scene managerScene = new Scene(managerPane, 300, 250);
        // setting scene for manager instance
        managerStage.setScene(managerScene);
        // showing manager scene
        managerStage.show();
    } // end of function setManager

    // static function main launches arguments
    public static void main(String[] args) {
        // calling for argument call
        launch(args);
    } // end of static function main
} // end of class Main