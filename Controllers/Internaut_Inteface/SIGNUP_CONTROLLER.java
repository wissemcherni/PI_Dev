package production.x_change.Controllers.Internaut_Inteface;

import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import javafx.fxml.Initializable;
import production.x_change.Controllers.Main.Main_Controller;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import production.x_change.Main.Main;
import production.x_change.Models.User;
import production.x_change.Tasks.Authentication_Task;
import production.x_change.Tasks.Signup_Task;
import production.x_change.Utils.LoadingSpinner;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SIGNUP_CONTROLLER implements Initializable {

    private Main_Controller main_controller;

    public void setParent(Main_Controller main_controller) {
        this.main_controller = main_controller;
    }
    @FXML
    private VBox BODY;

    @FXML
    private Label email_error;

    @FXML
    private TextField email_field;

    @FXML
    private VBox email_status;

    @FXML
    private Label password_error;

    @FXML
    private Label password_error1;

    @FXML
    private PasswordField password_field;

    @FXML
    private PasswordField password_field1;

    @FXML
    private VBox password_status;

    @FXML
    private VBox password_status1;

    @FXML
    private FontAwesomeIconView pwd_missing;

    @FXML
    private FontAwesomeIconView pwd_missing1;

    @FXML
    private Button signup_btn;

    @FXML
    void LOGIN(ActionEvent event) {
        main_controller.SwitchView(1);
    }

    @FXML
    void SIGNUP(ActionEvent event) {
        signup_btn.setDisable(true);
        email_field.setDisable(true);
        password_field.setDisable(true);
        LoadingSpinner spinner = new LoadingSpinner();
        RotateTransition rotateTransition = spinner.LoadingSpinner();
        rotateTransition.play();
        signup_btn.setGraphic(rotateTransition.getNode());
        Signup_Task signup = new Signup_Task(new User(email_field.getText(),password_field.getText()));
        Thread thread = new Thread(signup);
        signup.valueProperty().addListener((observableValue, aLong, t1) -> {
            if(t1 == 1){
                signup_btn.setGraphic(ICON());
                signup_btn.setDisable(false);
                email_field.setDisable(false);
                password_field.setDisable(false);
                main_controller.Navigate("Home");
            }else if(t1 == 666){
                signup_btn.setGraphic(ICON());
                signup_btn.setDisable(false);
                email_field.setDisable(false);
                password_field.setDisable(false);
                errors.put("Email","Email is already taken!");
                email_error.setText("Email is already in use!");
                email_status.setVisible(true);
                email_error.setVisible(true);
            }
        });
        thread.start();
    }
    private FontAwesomeIconView ICON(){
        FontAwesomeIconView icon = new FontAwesomeIconView();
        icon.setGlyphName("SIGN_IN");
        icon.getStyleClass().add("primary_icon");
        icon.setSize("24");
        return icon;
    }
    private static final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    private final Pattern pattern = Pattern.compile(regex);
    ObservableMap<String,String> errors;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errors = FXCollections.observableHashMap();
        errors.put("Email","Empty");
        errors.put("Password","Empty");
        errors.addListener((MapChangeListener<? super String, ? super String>) change -> {
            if(errors.isEmpty()){
                signup_btn.setDisable(false);
            }
            else{
                signup_btn.setDisable(true);
                signup_btn.setGraphic(ICON());
            }
        });
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
        password_field.textProperty().addListener((observableValue, s, t1) -> {
            if(t1.length() == 0) {
                password_status.setVisible(true);
                password_error.setText("Password Field is required!");
                errors.put("Password","Empty");
            }
            else if(t1.length() < 8){
                password_status.setVisible(true);
                password_error.setText("Password must be at least 8 chars!");
                errors.put("Password","Ivalid");

            }
            else {
                password_status.setVisible(false);
                password_error.setText("");
                errors.remove("Password");
                password_status1.setVisible(false);
                password_error1.setText("");
            }
            if(!(t1.equals(password_field1.getText()))){
                password_status.setVisible(true);
                password_error.setText("Password confirmation doesn't match!");
                errors.put("Password","Not Match");
                password_status1.setVisible(true);
                password_error1.setText("Password confirmation doesn't match!");
            }

        });
        password_field1.textProperty().addListener((observableValue, s, t1) -> {
            if(t1.length() == 0) {
                password_status1.setVisible(true);
                password_error1.setText("Password Field is required!");
                errors.put("Password","Empty");
            }
            else if(t1.length() < 8){
                password_status1.setVisible(true);
                password_error1.setText("Password must be at least 8 chars!");
                errors.put("Password","Ivalid");

            }

            else {
                password_status.setVisible(false);
                password_error.setText("");
                errors.remove("Password");
                password_status1.setVisible(false);
                password_error1.setText("");
            }
            if(!(t1.equals(password_field.getText()))){
                password_status.setVisible(true);
                password_error.setText("Password confirmation doesn't match!");
                errors.put("Password","Not Match");
                password_status1.setVisible(true);
                password_error1.setText("Password confirmation doesn't match!");
            }
        });
    }

    public void exit(ActionEvent actionEvent) {
        Main.CLOSE();
    }
}
