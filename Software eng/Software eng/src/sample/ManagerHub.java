package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class ManagerHub extends Application {
    static SearchRoom searchRoom = new SearchRoom();
    static RegisterRoom registerRoom = new RegisterRoom();
    static ApproveDeny approveDenyRoom = new ApproveDeny();
    static AddRoom addRoom = new AddRoom();

    Image logo = new Image("file:logo.png");

    @Override
    public void start(Stage primaryStage) throws Exception{
        // title for window
        primaryStage.setTitle("myResidence: MANAGER");
        // window width
        primaryStage.setWidth(600);
        // window height
        primaryStage.setHeight(500);

        VBox managerPermissions = new VBox();
        VBox stageSet = new VBox();

        Label welcome = new Label("\t            Welcome" + "     [PLACEHOLDER]"); // Add first name of manager from database
        welcome.setFont(new Font("Helvetica", 12));
        Label selectMServ = new Label("\tSelect a Feature:");
        selectMServ.setFont(new Font("Helvetica", 24));

        // set on action brings them to search screen
        Button searchMRoomButton = new Button("Search for a Room");
        searchMRoomButton.setOnAction(e -> {
            try {
                searchRoom.start(primaryStage);
            }
            catch (Exception err) {
                System.out.println(err);
            }
        });

        // set on action brings them to register screen
        Button registerMRoomButton = new Button("Register for a Room");
        registerMRoomButton.setOnAction(e -> {
            try {
                registerRoom.start(primaryStage);
            }
            catch (Exception err) {
                System.out.println(err);
            }
        });

        // set on action brings them to add / sub screen
        Button addSubRoomButton = new Button("Add / Subtract Room to / from Database");
        addSubRoomButton.setOnAction(e -> {
            try {
                addRoom.start(primaryStage);
            }
            catch (Exception err) {
                System.out.println(err);
            }
        });

        // set on action brings them to mod screen
        Button modRoomButton = new Button("Modify a Room");
        modRoomButton.setOnAction(e -> {
            // Can't find modify room class,
            // don't know what it's called,
            // will add once coby gets back to me -sam
            /*
            try {
                modifyRoom.start(primaryStage);
            }
            catch (Exception err) {
                System.out.println(err);
            }
             */
        });

        // set on action brings them to app / deny screen
        Button appDenReqButton = new Button("Approve / Deny Applicant");
        appDenReqButton.setOnAction(e -> {
            try {
                approveDenyRoom.start(primaryStage);
            }
            catch (Exception err) {
                System.out.println(err);
            }
        });

        ImageView showLogo = new ImageView();
        showLogo.setImage(logo);

        managerPermissions.getChildren().addAll(selectMServ, searchMRoomButton, registerMRoomButton, addSubRoomButton, modRoomButton, appDenReqButton);
        managerPermissions.setSpacing(15);

        stageSet.getChildren().addAll(welcome, managerPermissions, showLogo);
        stageSet.setSpacing(5);

        FlowPane managerHub = new FlowPane();
        managerHub.getChildren().addAll(stageSet);
        managerHub.setAlignment(Pos.CENTER);

        Scene manHubScreen = new Scene(managerHub, 300, 250);
        primaryStage.setScene(manHubScreen);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
