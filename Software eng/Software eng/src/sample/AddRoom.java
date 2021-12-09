package sample;

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

import java.util.concurrent.Flow;

public class AddRoom extends Application {
    static ManagerHub managerHub = new ManagerHub();

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox modPermissions = new VBox();

        Label addServ = new Label("Add a Room");

        Label addSpec = new Label("Enter New Room ID:");
        TextField addIDInput = new TextField();
        Label addMessage = new Label("");
        // set on action
        // if new room ID matches another existing room ID
        // addMessage = "Room already exists!" -- red text
        // if ID input is NULL
        // addMessage = "please enter an ID to assign to room!"
        // else
        // addMessage = "Room successfully added" -- green text
        Button addRoom = new Button("ADD ROOM");
        Label subServ = new Label("Remove a Room");
        Label subSpec = new Label("Enter a Valid Room ID:");
        TextField subIDInput = new TextField();
        Label subMessage = new Label("");

        // set on action
        // if input is NULL or incorrect
        // subMessage = "Wrong or Missing Room ID!" -- red text
        // if room is occupied
        // subMessage = "Room cannot be removed until it is empty!" -- red text
        // else
        // subMessage = "Room successfully removed" -- green text
        Button subRoom = new Button("REMOVE ROOM");

        Button goBackButton = new Button("BACK TO HUB");
        goBackButton.setOnAction(e -> {
            try {
                managerHub.start(primaryStage);
            }
            catch (Exception err) {
                System.out.println(err);
            }
        });

        modPermissions.getChildren().addAll(addServ, addSpec, addIDInput, addMessage, addRoom, subServ, subSpec, subIDInput, subMessage, subRoom, goBackButton);
        modPermissions.setSpacing(15);

        FlowPane modHub = new FlowPane();
        modHub.getChildren().addAll(modPermissions);
        modHub.setAlignment(Pos.CENTER);

        Scene modHubScreen = new Scene(modHub);
        primaryStage.setScene(modHubScreen);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
