package production.x_change.Controllers.Main;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import production.x_change.Controllers.Internaut_Inteface.LOGIN_CONTROLLER;
import production.x_change.Controllers.Internaut_Inteface.SIGNUP_CONTROLLER;
import production.x_change.Controllers.User_Interface.Skeleton_Controller;
import production.x_change.Main.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class Main_Controller implements Initializable {
    private AnchorPane login_component;
    private AnchorPane sign_component;

    @FXML
    private AnchorPane BODY;
    public void SwitchView(int val){
        if (val == 2) {
            sign_component.setDisable(false);
            TranslateTransition t = new TranslateTransition(Duration.seconds(0.1),login_component);
            t.setToY(40);
            t.play();
            t.setOnFinished(e -> {
                TranslateTransition t1 =  new TranslateTransition(Duration.seconds(0.1),sign_component);
                t1.setToY(-20);
                t1.play();
                t1.setOnFinished(trans -> {
                    TranslateTransition t3 = new TranslateTransition(Duration.seconds(0.1),login_component);
                    t3.setToY(20);
                    t3.play();
                    sign_component.toFront();
                    login_component.setDisable(true);
                });
            });
        } else if(val == 1) {
            login_component.setDisable(false);
            TranslateTransition t = new TranslateTransition(Duration.seconds(0.1),sign_component);
            t.setToY(40);
            t.play();
            t.setOnFinished(e -> {
                TranslateTransition t2 = new TranslateTransition(Duration.seconds(0.1),sign_component);
                t2.setToY(0);
                t2.play();
                TranslateTransition t1 =  new TranslateTransition(Duration.seconds(0.1),login_component);
                t1.setToY(0);
                t1.play();
                t1.setOnFinished(trans -> {
                    login_component.toFront();
                    sign_component.setDisable(true);
                });
            });

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader login_loader = new FXMLLoader(getClass().getResource("/production/x_change/Internaut_Inteface/LOGIN.fxml"));
            login_component = login_loader.load();
            LOGIN_CONTROLLER login_controller = login_loader.getController();
            login_controller.setParent(this);
            FXMLLoader signup_loader = new FXMLLoader(getClass().getResource("/production/x_change/Internaut_Inteface/SIGNUP.fxml"));
            sign_component = signup_loader.load();
            SIGNUP_CONTROLLER signup_controller = signup_loader.getController();
            signup_controller.setParent(this);
            BODY.getChildren().setAll(login_component,sign_component);
            login_component.setLayoutY(0);
            sign_component.setDisable(true);
            sign_component.setLayoutY(20);
            login_component.toFront();
        }catch (Exception ignored){
        }
    }

    public void Navigate(String url) {
        try{
            Main.cancelDrag();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/production/x_change/User_Interface/Skeleton.fxml"));
            AnchorPane component = loader.load();
            Skeleton_Controller controller = loader.getController();
            controller.setParent(this);
            BODY.getChildren().setAll(component);
        }catch (Exception ignored){

        }
    }
}
