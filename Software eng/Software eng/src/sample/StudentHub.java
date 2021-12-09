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

public class StudentHub extends Application {
    Image logo = new Image("file:logo.png");
    static SearchRoom searchRoom = new SearchRoom();
    static RegisterRoom registerRoom = new RegisterRoom();

    @Override
    public void start(Stage primaryStage) throws Exception{
        // title for window
        primaryStage.setTitle("myResidence: STUDENT");

        VBox stageStuSet = new VBox();
        VBox studentPermissions = new VBox();

        Label welcomeStu = new Label("\t            Welcome" + "     [PLACEHOLDER]"); // Add first name of manager from database
        welcomeStu.setFont(new Font("Helvetica", 12));
        Label selectServ = new Label("\tSelect a Feature:");
        selectServ.setFont(new Font("Helvetica", 24));

        // set on action brings them to search screen
        Button searchRoomButton = new Button("Search for a Room");
        searchRoomButton.setOnAction(e -> {
            try {
                searchRoom.start(primaryStage);
            }
            catch (Exception err) {
                System.out.println(err);
            }
        });

        // set on action brings them to register screen
        Button registerRoomButton = new Button("Register for a Room");
        registerRoomButton.setOnAction(e -> {
            try {
                registerRoom.start(primaryStage);
            }
            catch (Exception err) {
                System.out.println(err);
            }
        });

        ImageView showLogo = new ImageView();
        showLogo.setImage(logo);

        studentPermissions.getChildren().addAll(selectServ, searchRoomButton, registerRoomButton);
        studentPermissions.setSpacing(15);

        stageStuSet.getChildren().addAll(welcomeStu, studentPermissions, showLogo);
        stageStuSet.setSpacing(5);

        FlowPane studentHub = new FlowPane();
        studentHub.getChildren().addAll(stageStuSet);
        studentHub.setAlignment(Pos.CENTER);

        Scene stuHubScreen = new Scene(studentHub, 300, 250);
        primaryStage.setScene(stuHubScreen);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
