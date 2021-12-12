package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
        Label livingStyleLab = new Label("Select Living Style: ");
        ComboBox cbLivingStyle = new ComboBox();
        cbLivingStyle.getItems().addAll(
                "Residence Hall",
                "Townhouse",
                "Apartment"
        );
        Label roomTypeLab = new Label("Select Room Type: ");
        ComboBox cbRoomType = new ComboBox();
        cbRoomType.getItems().addAll(
                "Basic Single",
                "Single",
                "Double"
        );


        Label addMessage = new Label("");
        // we also need int residence_ID, String living_style, String room_type,
        //                                  int residence_price,String residence_address,
        //                                  boolean has_mealplan, String student_usernames
        // set on action
        // if new room ID matches another existing room ID
        // addMessage = "Room already exists!" -- red text
        // if ID input is NULL
        // addMessage = "please enter an ID to assign to room!"
        // else
        // addMessage = "Room successfully added" -- green text
        Button addRoom = new Button("ADD ROOM");
        addRoom.setOnAction(e -> {
            Integer addId = Integer.parseInt(addIDInput.getText());
            String livingStyle = cbLivingStyle.getValue().toString();
            String roomType = cbRoomType.getValue().toString();
            Boolean hasMealplan = false;
            int price = 8000;
            String address = "";

            if (livingStyle == "Residence Hall") {
                address = "Bartley Residence Bartley Cir";
                hasMealplan = true;
                if (roomType == "Basic Single") {
                    price = 11196;
                }
                else if (roomType == "Single") {
                    price = 12395;
                }
                else {
                    price = 10235;
                }
            }
            else if (livingStyle == "Townhouse") {
                address = "Deer Lake Rd";
                price = 7982;
            }
            else if (livingStyle == "Apartment") {
                address = "North Spirit Rd";
                price = 7571;
            }

            System.out.println("ID: " + addId + "\nLiving Style: " + livingStyle + "\nroomType: " + roomType + "\nprice: " + price + "\naddress: " + address + "\nMealplan: " + hasMealplan);

            boolean isAdded = Utils.driver.addRoom(addId,
                    livingStyle,
                    roomType,
                    price,
                    address,
                    hasMealplan,
                    null);
            if (isAdded){
                addMessage.setText("Room added successfully!");
            }
            else {
                addMessage.setText("Problem adding room. Check information and try again.");
            }
        });

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

        modPermissions.getChildren().addAll(addServ, addSpec, addIDInput, livingStyleLab, cbLivingStyle, roomTypeLab, cbRoomType, addMessage, addRoom, subServ, subSpec, subIDInput, subMessage, subRoom, goBackButton);
        modPermissions.setSpacing(15);

        FlowPane modHub = new FlowPane();
        modHub.getChildren().addAll(modPermissions);
        modHub.setAlignment(Pos.CENTER);

        Scene modHubScreen = new Scene(modHub);
        primaryStage.setScene(modHubScreen);
        primaryStage.show();
    }
}
