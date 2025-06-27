package io.sanctusfides.todojavafx.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import io.sanctusfides.todojavafx.Database.DatabaseHandler;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton signupBtn;

    @FXML
    private JFXTextField signupFirstNameFld;

    @FXML
    private JFXTextField signupLastNameFld;

    @FXML
    private JFXTextField signupLocationFld;

    @FXML
    private JFXCheckBox signupMaleCheckBox;

    @FXML
    private JFXCheckBox signupFemaleCheckBox;

    @FXML
    private JFXPasswordField signupPasswordFld;

    @FXML
    private JFXTextField signupUsernameFld;

    @FXML
    void initialize() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        signupBtn.setOnAction(event -> {
            JFXCheckBox selectedGender = signupMaleCheckBox.isSelected() ? signupMaleCheckBox : signupFemaleCheckBox;

            databaseHandler.signUpUser(signupFirstNameFld.getText(), signupLastNameFld.getText(), signupUsernameFld.getText(),
                    signupPasswordFld.getText(),signupLocationFld.getText(), selectedGender.getText());
        });
    }
}
