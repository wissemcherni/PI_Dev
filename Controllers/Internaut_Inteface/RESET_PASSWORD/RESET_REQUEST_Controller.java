package production.x_change.Controllers.Internaut_Inteface.RESET_PASSWORD;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.RotateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import production.x_change.Controllers.Internaut_Inteface.LOGIN_CONTROLLER;
import production.x_change.Models.User;
import production.x_change.Tasks.Reset_Password_Task;
import production.x_change.Utils.LoadingSpinner;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RESET_REQUEST_Controller implements Initializable {
    @FXML
    private Label email_error;

    @FXML
    private TextField email_field;

    @FXML
    private VBox email_status;
    @FXML
    private Button reset_btn;
    private LOGIN_CONTROLLER login_controller;
    public void setParent(LOGIN_CONTROLLER login_controller) {
        this.login_controller = login_controller;
    }
    @FXML
    public void BACK(ActionEvent actionEvent) {
        this.login_controller.LoginInterface();
    }
    private static final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    private final Pattern pattern = Pattern.compile(regex);
    ObservableMap<String,String> errors;
    private FontAwesomeIconView ResetIcon(){
        FontAwesomeIconView icon = new FontAwesomeIconView();
        icon.setGlyphName("MAIL_FORWARD");
        icon.getStyleClass().add("primary_icon");
        icon.setSize("24");
        return icon;
    }
    @FXML
    void RESET(ActionEvent event) {
        reset_btn.setDisable(true);
        email_field.setDisable(true);
        LoadingSpinner spinner = new LoadingSpinner();
        RotateTransition rotateTransition = spinner.LoadingSpinner();
        rotateTransition.play();
        reset_btn.setGraphic(rotateTransition.getNode());
        Reset_Password_Task task = new Reset_Password_Task(new User(null,email_field.getText(),null));
        task.valueProperty().addListener((observableValue, aLong, t1) -> {
            if(t1 == 666){
                System.out.println("code sent to mail");
            }
            else if(t1 == 777){
                System.out.println("code generation failed");
            }
        });
        Thread t = new Thread(task);
        t.setDaemon(true);
        t.start();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errors = FXCollections.observableHashMap();
        errors.addListener((MapChangeListener<? super String, ? super String>) change -> {
            if(errors.isEmpty()){
                reset_btn.setDisable(false);
            }
            else{
                reset_btn.setDisable(true);
                reset_btn.setGraphic(ResetIcon());
            }
        });
        errors.put("Email","Empty");
        email_field.textProperty().addListener((observableValue, s, t1) -> {
            Matcher matcher = pattern.matcher(t1);
            if(t1.length() == 0){
                email_error.setText("Email field is required!");
                email_status.setVisible(true);
                errors.put("Email","Empty");
            }else
            {
                if(!matcher.matches()){
                    email_status.setVisible(true);
                    email_error.setText("Invalid email format!");
                    errors.put("Email","Invalid");

                }
                else{
                    email_status.setVisible(false);
                    email_error.setText("");
                    errors.remove("Email");

                }
            }
        });
    }
}
