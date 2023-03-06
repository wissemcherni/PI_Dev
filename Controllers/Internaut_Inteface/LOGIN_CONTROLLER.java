package production.x_change.Controllers.Internaut_Inteface;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import production.x_change.Controllers.Internaut_Inteface.RESET_PASSWORD.RESET_REQUEST_Controller;
import production.x_change.Controllers.Main.Main_Controller;
import production.x_change.Main.Main;
import production.x_change.Models.User;
import production.x_change.Tasks.Authentication_Task;
import production.x_change.Tasks.Session_Task;
import production.x_change.Utils.Auth;
import production.x_change.Utils.LoadingSpinner;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LOGIN_CONTROLLER implements Initializable {
    @FXML
    private VBox BODY;
    @FXML
    private VBox LOGIN_FORM;

    @FXML
    private Label global_error;

    @FXML
    private Label email_error;

    @FXML
    private TextField email_field;

    @FXML
    private VBox email_status;

    @FXML
    private Button login_btn;

    @FXML
    private Label password_error;

    @FXML
    private PasswordField password_field;

    @FXML
    private VBox password_status;

    @FXML
    private FontAwesomeIconView pwd_missing;
    @FXML
    void LOGIN(ActionEvent event) {
        login_btn.setDisable(true);
        email_field.setDisable(true);
        password_field.setDisable(true);
        LoadingSpinner spinner = new LoadingSpinner();
        RotateTransition rotateTransition = spinner.LoadingSpinner();
        rotateTransition.play();
        login_btn.setGraphic(rotateTransition.getNode());
        Authentication_Task auth = new Authentication_Task(new User(email_field.getText(),password_field.getText()));
        Thread thread = new Thread(auth);
        auth.valueProperty().addListener((observableValue, aLong, t1) -> {
            if(t1 == 1){
                login_btn.setGraphic(LoginIcon());
                login_btn.setDisable(false);
                email_field.setDisable(false);
                password_field.setDisable(false);
                main_controller.Navigate("Home");
            }else if(t1 == 666){
                login_btn.setGraphic(LoginIcon());
                login_btn.setDisable(false);
                email_field.setDisable(false);
                password_field.setDisable(false);
                errors.put("Credentials","Invalid Credentials");
                global_error.setText("Invalid Credentials!");
            }
        });
        thread.start();
    }
    @FXML
    public void PASSWORD_RESET(MouseEvent mouseEvent) {
        try{
            FXMLLoader reset_request_component = new FXMLLoader(getClass().getResource("/production/x_change/Internaut_Inteface/RESET_PASSWORD/RESET_REQUEST.fxml"));
            AnchorPane reset_comp = reset_request_component.load();
            RESET_REQUEST_Controller reset_request_controller = reset_request_component.getController();
            reset_request_controller.setParent(this);
            BODY.getChildren().setAll(reset_comp);
        }catch (Exception ignored){

        }
    }
    public void LoginInterface(){
        BODY.getChildren().setAll(LOGIN_FORM);
    }
    private FontAwesomeIconView LoginIcon(){
        FontAwesomeIconView icon = new FontAwesomeIconView();
        icon.setGlyphName("SIGN_IN");
        icon.getStyleClass().add("primary_icon");
        icon.setSize("24");
        return icon;
    }
    @FXML
    public void SIGNUP(ActionEvent actionEvent) {
        main_controller.SwitchView(2);
        login_btn.setGraphic(LoginIcon());
        email_error.setText("");
        email_status.setVisible(false);
        email_field.clear();
        password_error.setText("");
        password_status.setVisible(false);
        password_field.clear();
    }
    private Main_Controller main_controller;

    public void setParent(Main_Controller main_controller) {
        this.main_controller = main_controller;
    }

    private static final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    private final Pattern pattern = Pattern.compile(regex);
    ObservableMap<String,String> errors;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errors = FXCollections.observableHashMap();
        errors.addListener((MapChangeListener<? super String, ? super String>) change -> {
            if(errors.isEmpty()){
                login_btn.setDisable(false);
            }
            else{
                login_btn.setDisable(true);
                login_btn.setGraphic(LoginIcon());
            }
        });

        errors.put("Email","Empty");
        errors.put("Password","Empty");
        email_field.textProperty().addListener((observableValue, s, t1) -> {
            errors.remove("Credentials");
            global_error.setText("");
            Matcher matcher = pattern.matcher(t1);
            if(t1.isBlank()){
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
            errors.remove("Credentials");
            global_error.setText("");
            if(t1.length() == 0) {
                password_status.setVisible(true);
                password_error.setText("Password Field is required!");
                errors.put("Password","Empty");
            }
            else if(t1.length() < 8 && t1.length() > 0){
                password_status.setVisible(true);
                password_error.setText("Password must be at least 8 chars!");
                errors.put("Password","Ivalid");

            }
            else {
                password_status.setVisible(false);
                password_error.setText("");
                errors.remove("Password");

            }
        });
    }

    public void exit(ActionEvent actionEvent) {
        Main.CLOSE();
    }
}
