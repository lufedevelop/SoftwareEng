package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

public class SearchRoom extends Application {
    int index = 0;
    ArrayList<DBResidence> rooms;
    Label[] searchOutput = {new Label(""), new Label(""), new Label("")};

    @Override
    public void start(Stage primaryStage) throws Exception{

        VBox searchRoomPermissions = new VBox();
        HBox nextRet = new HBox();

        Label searchServ = new Label("Enter a keyword / RoomID / etc");

        TextField inputSearch = new TextField();
        // set on action for search
        // if term does not exist within database
        // return message = "Search does not match any results!"
        // inputSearchCheck
        // else
        // return tuple of desired room within constraints of array
        // list converts number of results to array
        // ex. show 0-2, 3-5, 6-8, etc.
        Button searchInputButton = new Button("SEARCH");
        searchInputButton.setOnAction(e -> {
            System.out.println("Search pressed");
            String keyword = inputSearch.getText();

            // Get search results from database as object
            try {
                rooms = Driver.isResidence(keyword);
                updateDisplay();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        });

        Button next = new Button("NEXT SEARCH");
        next.setOnAction(e -> {
            index++;
            if (index > rooms.size() - 3) {
                index = rooms.size() - 3;
                if (index < 0)
                    index = 0;
            }
            updateDisplay();
        });
        Button previous = new Button("PREVIOUS SEARCH");
        previous.setOnAction(e -> {
            index--;
            if (index < 0) {
                index = 0;
            }
            updateDisplay();
        });

        Button goBackButton = new Button("BACK TO HUB");
        goBackButton.setOnAction(e -> {
            if (Utils.privilege == "Student") {
                try {
                    Utils.studentHub.start(primaryStage);
                } catch (Exception err) {
                    System.out.println(err);
                }
            }
            else {
                try {
                    Utils.managerHub.start(primaryStage);
                } catch (Exception err) {
                    System.out.println(err);
                }
            }
        });

        nextRet.getChildren().addAll(next, previous);
        searchRoomPermissions.getChildren().addAll(searchServ,inputSearch, searchOutput[0], searchOutput[1], searchOutput[2], searchInputButton, nextRet, goBackButton);
        searchRoomPermissions.setSpacing(15);

        FlowPane searchHub = new FlowPane();
        searchHub.getChildren().addAll(searchRoomPermissions);
        searchHub.setAlignment(Pos.CENTER);

        Scene searchHubScreen = new Scene(searchHub);
        primaryStage.setScene(searchHubScreen);
        primaryStage.show();
    }

    private void updateDisplay() {
        DBResidence room;

        for (var i = 0; i < 3; ++i) {
            try {
                room = rooms.get(index + i);
            }
            catch (Exception ex) {
                searchOutput[i].setText("");
                return;
            }
            searchOutput[i].setText(
                    "Room ID: " + room.getID() +
                            "\nStyle: " + room.getStyle() +
                            "\nPrice: " + room.getPrice() +
                            "\n" + (room.getMealplan() ? "Includes meal plan." : "Does not include meal plan.")
            );
        }
    }
}
