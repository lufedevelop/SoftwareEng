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
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox modPermissions = new VBox();

        Label addServ = new Label("Add a Room");

        Label addSpec = new Label("Enter New Room ID:");
        TextField addIDInput = new TextField();
        Label addMessage = new Label("");
        // set on action
        Button addRoom = new Button("ADD ROOM");
        addRoom.setOnAction(e -> {
            Integer addId = Integer.parseInt(addIDInput.getText());
            Utils.driver.addRoom(addId,
                    "Residence Hall",
                    "Basic Single",
                    11196,
                    "Bartley Residence Bartley Cir",
                    true,
                    null);
            try {
                boolean isAdded = true;
                if (isAdded){
                    addMessage.setText("Room added successfully!");
                }
                else {
                    addMessage.setText("Problem adding room. Check information and try again.");
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        });

        Label subServ = new Label("Remove a Room");
        Label subSpec = new Label("Enter a Valid Room ID:");
        TextField subIDInput = new TextField();
        Label subMessage = new Label("");

        // set on action
        Button subRoom = new Button("REMOVE ROOM");
        subRoom.setOnAction(e -> {
            int removeId = Integer.parseInt(subIDInput.getText());
            try {
                boolean isRemoved = Utils.driver.deleteRoom(removeId);
                if (isRemoved){
                    subMessage.setText("Room removed successfully");
                }
                else {
                    subMessage.setText("Error removing room");
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
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

        modPermissions.getChildren().addAll(addServ, addSpec, addIDInput, addMessage, addRoom, subServ, subSpec, subIDInput, subMessage, subRoom, goBackButton);
        modPermissions.setSpacing(15);

        FlowPane modHub = new FlowPane();
        modHub.getChildren().addAll(modPermissions);
        modHub.setAlignment(Pos.CENTER);

        Scene modHubScreen = new Scene(modHub);
        primaryStage.setScene(modHubScreen);
        primaryStage.show();
    }
}
