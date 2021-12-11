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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ApproveDeny extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox appDenPermissions = new VBox();
        HBox buttonAppDen = new HBox();
        HBox buttonForBack = new HBox();

        Label appDenServ = new Label("Approve or Deny Student Applications");
        Button appDenCheck = new Button("VIEW APPLICATION");
        // if number of outstanding apps >= 1
        // appDenCheck = "Outstanding Applications Exist!" -- red
        //else
        // appDenCheck = "No outstanding Applications" -- green
        Label errorCheckingApp = new Label("");
        Label studentApp = new Label("[PLACEHOLDER NAME] " + " [PLACEHOLDER ID] " + " [PLACEHOLDER ROOM REQUEST] ");
        // set action
        // if no new applications exist
        // errorCheckingApp = "No applications to view!"
        // set to empty
        // else
        // set label to name, id, and request of student from database

        List<Label> studentAppList = new List<Label>() {
            @Override
            public int size() {
                // return size of application query
                return 0;
            }

            @Override
            public boolean isEmpty() {
                // if no results exist within query
                return false;
                // if results from query >= 1
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
                // List will assign array index to list values
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
        // set on action
        // if value of current index = array length
        // do not continue
        Button viewApp = new Button("Next Application");
        // set on action
        // if value of current index is 0
        // do not continue
        Button viewPreApp = new Button("Previous Application");

        // set on action
        // if no application is present to approve / deny
        // errorCheckingApp = "No application present!"
        // else
        // continue
        Button approveStu = new Button("APPROVE");
        Button denyStu = new Button("DENY");

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
}
