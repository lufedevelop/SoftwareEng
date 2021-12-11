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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SearchRoom extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox searchRoomPermissions = new VBox();
        HBox nextRet = new HBox();

        Label searchServ = new Label("Enter a keyword / RoomID / etc");

        TextField inputSearch = new TextField();

        List<Label> searchQueue = new List<Label>() {
            @Override
            public int size() {
                return 0;
                // size equals to number of queries found
            }

            @Override
            public boolean isEmpty() {
                // if number of queries > 0
                return false;
                // if number of queries == 0
                // return true
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Label> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Label label) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Label> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Label> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Label get(int index) {
                // return alike variables within database
                return null;
            }

            @Override
            public Label set(int index, Label element) {
                return null;
            }

            @Override
            public void add(int index, Label element) {

            }

            @Override
            public Label remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Label> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Label> listIterator(int index) {
                return null;
            }

            @Override
            public List<Label> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        Label inputSearchCheckX = new Label("");
        Label inputSearchCheckY = new Label("");
        Label inputSearchCheckZ = new Label("");
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
            String keyword = inputSearch.getText();
            // Get search results from database as object
            try {
                //DBResidence new_residence = Utils.driver.isResidence(keyword);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        });

        Button next = new Button("NEXT SEARCH");
        // increments search indexes by next 3 inputs
        // if number of inputs is reached
        // stop
        Button previous = new Button("PREVIOUS SEARCH");
        // decrements search indexes by last 3 inputs
        // if input x = 0
        // stop
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
        searchRoomPermissions.getChildren().addAll(searchServ,inputSearch, inputSearchCheckX, inputSearchCheckY, inputSearchCheckZ, searchInputButton, nextRet, goBackButton);
        searchRoomPermissions.setSpacing(15);

        FlowPane searchHub = new FlowPane();
        searchHub.getChildren().addAll(searchRoomPermissions);
        searchHub.setAlignment(Pos.CENTER);

        Scene searchHubScreen = new Scene(searchHub);
        primaryStage.setScene(searchHubScreen);
        primaryStage.show();
    }
}
