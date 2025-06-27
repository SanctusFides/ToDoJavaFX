package io.sanctusfides.todojavafx.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXPasswordField loginPasswordFld;

    @FXML
    private JFXButton loginSignupBtn;

    @FXML
    private JFXTextField loginUserNameFld;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String loginName = loginUserNameFld.getText().trim();
        String loginPwd = loginPasswordFld.getText().trim();

        loginSignupBtn.setOnAction(event -> {
        // push user to sign up view
            loginSignupBtn.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/signup.fxml"));
            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        loginBtn.setOnAction(event -> {
            if (!loginName.isEmpty() || !loginPwd.isEmpty()) {
                loginUser(loginName,loginPwd);
            } else {
                System.out.println("Test Log - Error logging in user");
            }
        });
    }

    private void loginUser(String username, String password) {
    // check if user exists in DB, if true - push user to AddItem view


    }
}