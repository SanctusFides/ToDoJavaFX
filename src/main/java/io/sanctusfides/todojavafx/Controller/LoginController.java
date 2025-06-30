package io.sanctusfides.todojavafx.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import io.sanctusfides.todojavafx.Animations.Shaker;
import io.sanctusfides.todojavafx.Model.Model;
import io.sanctusfides.todojavafx.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private JFXButton loginBtn;
    @FXML
    private JFXButton loginSignupBtn;

    @FXML
    private JFXTextField loginUserNameFld;
    @FXML
    private JFXPasswordField loginPasswordFld;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addListeners();
    }

    private void loginUser() {
        String loginName = loginUserNameFld.getText().trim();
        String loginPwd = loginPasswordFld.getText().trim();
        User user = new User();
        user.setUserName(loginName);
        user.setPassword(loginPwd);

        ResultSet userResult = Model.getInstance().getDatabaseHandler().getUser(user);
        try {
            if (userResult != null && userResult.isBeforeFirst()) {
                System.out.println("login success");
                Model.getInstance().getViewFactory().closeStage((Stage) loginBtn.getScene().getWindow());
                Model.getInstance().getViewFactory().showAddItemScreen();
            } else {
                Shaker userNameShaker = new Shaker(loginUserNameFld);
                userNameShaker.shake();
                Shaker passwordShaker = new Shaker(loginPasswordFld);
                passwordShaker.shake();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addListeners() {
        loginSignupBtn.setOnAction(event -> {
            Model.getInstance().getViewFactory().closeStage((Stage) loginSignupBtn.getScene().getWindow());
            Model.getInstance().getViewFactory().showSignupWindow();
        });

        //
        loginBtn.setOnAction(event -> loginUser());
    }


}