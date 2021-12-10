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

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // title for window
        primaryStage.setTitle("Search for a Room");
        // window width
        primaryStage.setWidth(600);
        // window height
        primaryStage.setHeight(500);

        VBox searchRoomPermissions = new VBox();

        Label searchServ = new Label("Enter a keyword / RoomID / etc");

        TextField inputSearch = new TextField();

        Label inputSearchCheck = new Label("");
        // set on action
            // if term does not exist within database
                // return message = "Search does not match any results!"
                // inputSearchCheck
        // else
            // return tuple of desired room
        Button searchInput = new Button("SEARCH");

        searchRoomPermissions.getChildren().addAll(searchServ,inputSearch, inputSearchCheck, searchInput);
        searchRoomPermissions.setSpacing(15);

        FlowPane searchHub = new FlowPane();
        searchHub.getChildren().addAll(searchRoomPermissions);
        searchHub.setAlignment(Pos.CENTER);

        Scene searchHubScreen = new Scene(searchHub);
        primaryStage.setScene(searchHubScreen);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
