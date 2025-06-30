package io.sanctusfides.todojavafx.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ViewFactory {


    public void showSignupWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/signup.fxml"));
        createStage(loader);
    }

    public void showAddItemScreen() {
        FXMLLoader loader = new FXMLLoader();
        createStage(loader);
    }


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
