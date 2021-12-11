package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class RegisterRoom extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{

        VBox registerPermissions = new VBox();

        Label registerServ = new Label("Enter Valid Room ID");
        TextField roomIdInput = new TextField();
        // Label is modifiable and will change to show errors, progression
        Label displayActions = new Label("");
        // set on action
        // if room does not exist
        // displayActions = "Room Does not Exist!" -- Red text
        // if room exists, but is occupied
        // displayActions = "Room is full!" -- Red text
        // else
        // displayActions = "Registration Successful / Complete" -- Green text
        Button registerIdInputButton = new Button("REGISTER");
        registerIdInputButton.setOnAction(e -> {
            int roomId = Integer.parseInt(roomIdInput.getText());
            try {
                boolean isAdded = Utils.driver.addStudentToRoom(Utils.username, roomId);
                if (isAdded){
                    //user is added

                }
                else {
                    //room not available

                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        });

        Button goBackButton = new Button("BACK TO HUB");
        goBackButton.setOnAction(e -> {
            try {
                if (Utils.privilege == "Student")
                    Utils.studentHub.start(primaryStage);
                else if (Utils.privilege == "Manager")
                    Utils.managerHub.start(primaryStage);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        registerPermissions.getChildren().addAll(registerServ,roomIdInput,registerIdInputButton, goBackButton, displayActions);
        registerPermissions.setSpacing(15);

        FlowPane registerHub = new FlowPane();
        registerHub.getChildren().addAll(registerPermissions);
        registerHub.setAlignment(Pos.CENTER);

        Scene regHubScreen = new Scene(registerHub, 300, 250);
        primaryStage.setScene(regHubScreen);
        primaryStage.show();
    }
}
