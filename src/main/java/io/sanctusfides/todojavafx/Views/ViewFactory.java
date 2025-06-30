package io.sanctusfides.todojavafx.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ViewFactory {

    // launches the login window which is the first thing that Main calls
    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }
    // loads the user signup window
    public void showSignupWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Signup.fxml"));
        createStage(loader);
    }
    // loads the AddItem view after user signs in or needs to add new
    public void showAddItemScreen() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/AddItem.fxml"));
        createStage(loader);
    }

    // reusable create stage
    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
           e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("ToDo");
        stage.showAndWait();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
