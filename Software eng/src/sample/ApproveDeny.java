package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.*;

public class ApproveDeny extends Application {
    ArrayList<DBStudent> students;
    Label studentApp = new Label("");
    int index = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox appDenPermissions = new VBox();
        HBox buttonAppDen = new HBox();
        HBox buttonForBack = new HBox();

        Label appDenServ = new Label("Approve or Deny Student Applications");
        Button appDenCheck = new Button("VIEW APPLICATION");
        appDenCheck.setOnAction(e -> {
            // Get search results from database as object
            try {
                students = Driver.getPendingStudents();
                updateDisplay();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        });

        // if number of outstanding apps >= 1
        // appDenCheck = "Outstanding Applications Exist!" -- red
        //else
        // appDenCheck = "No outstanding Applications" -- green
        Label errorCheckingApp = new Label("");

        // set action
        // if no new applications exist
        // errorCheckingApp = "No applications to view!"
        // set to empty
        // else
        // set label to name, id, and request of student from database

        Button viewApp = new Button("Next Application");
        viewApp.setOnAction(e -> {
            index++;
            if (index > students.size() - 1)
                index = students.size() - 1;
            updateDisplay();
        });

        Button viewPreApp = new Button("Previous Application");
        viewPreApp.setOnAction(e -> {
            index--;
            if (index < 0)
                index = 0;
            updateDisplay();
        });
        // set on action
        // if no application is present to approve / deny
        // errorCheckingApp = "No application present!"
        // else
        // continue
        Button approveStu = new Button("APPROVE");
        approveStu.setOnAction(e -> {
            Driver.approveStudent(students.get(index).getUser());
            studentApp.setText("");
            students.remove(index);
            if (index > students.size() - 1)
                index--;
            updateDisplay();
        });

        Button denyStu = new Button("DENY");
        denyStu.setOnAction(e -> {
            Driver.denyStudent(students.get(index).getUser(), students.get(index).getResID());
            studentApp.setText("");
            students.remove(index);
            if (index > students.size() - 1)
                index--;
            updateDisplay();
        });

        Button goBackButton = new Button("BACK TO HUB");
        goBackButton.setOnAction(e -> {
            try {
                Utils.managerHub.start(primaryStage);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        buttonAppDen.getChildren().addAll(approveStu, denyStu);
        buttonForBack.getChildren().addAll(viewApp, viewPreApp);
        appDenPermissions.getChildren().addAll(appDenServ, appDenCheck, errorCheckingApp, studentApp, buttonAppDen, buttonForBack, goBackButton);
        appDenPermissions.setSpacing(15);

        FlowPane appDenHub = new FlowPane();
        appDenHub.getChildren().addAll(appDenPermissions);
        appDenHub.setAlignment(Pos.CENTER);

        Scene appDenHubScreen = new Scene(appDenHub);
        primaryStage.setScene(appDenHubScreen);
        primaryStage.show();
    }

    private void updateDisplay() {
        int id = 0;
        String name = "name";
        try {
            id = students.get(index).getResID();
            name = students.get(index).getName();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        studentApp.setText("Name: " + name + " Room ID: " + id);
    }
}
