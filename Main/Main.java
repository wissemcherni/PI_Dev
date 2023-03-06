package production.x_change.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import production.x_change.Controllers.Main.Main_Controller;
import production.x_change.Models.User;
import production.x_change.Utils.Auth;

import java.io.IOException;

public class Main extends Application {
    private static String token_time;
    private static float f;

    public static String getAccess_Token() {
        return token;
    }
    private static String token = null;

    public static void setAccessToken(String token) {
        Main.token = token;
    }

    public static void setAccessTokenTime(String format) {
        token_time = format;
    }
    public static String getToken_time(){
        return token_time;
    }

    private static AnchorPane app;
    private  static Main_Controller app_controller;

    public static void cancelDrag() {
        app.setLayoutX(535);
        app.setLayoutY(77);
        app.setOnMouseDragged(e -> {
        });
    }
    private static Stage stage;
    private static User u;
    public static void setUser(User t1) {
        u = t1;
    }
    public static User getUser(){
        return u;
    }
    @Override
    public void start(Stage stage) throws IOException {
            Main.stage = stage;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/production/x_change/Main_Interface/Main.fxml"));
            app = loader.load();
            app.setStyle("-fx-background-color:transparent;");
            app_controller = loader.getController();
            app.setOnMouseDragged(e -> {
                app.setLayoutY(e.getScreenY()- 5 );
                app.setLayoutX(e.getSceneX() - (app.getChildren().get(0)).getBoundsInParent().getWidth()/2 + 10);
            });
            app.setLayoutX(1000);
            app.setLayoutY(200);
            Scene scene = new Scene(app);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
    }

    public static void Logout(){
        try{
            Auth.logout();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/production/x_change/Main_Interface/Main.fxml"));
            AnchorPane p = loader.load();
            p.setStyle("-fx-background-color:transparent;");
            p.setOnMouseDragged(e -> {
                p.setLayoutY(e.getScreenY()- 5 );
                p.setLayoutX(e.getSceneX() - (p.getChildren().get(0)).getBoundsInParent().getWidth()/2 + 10);
            });
            p.setLayoutX(1000);
            p.setLayoutY(200);
            Scene scene = new Scene(p);
            scene.setFill(Color.TRANSPARENT);
            app=p;
            Main.stage.setScene(scene);
        }catch (Exception ignored){
            System.out.println(ignored.getMessage());
        }
    }
    public static void CLOSE(){
        stage.close();
    }
    public static void MINIMIZE(){
        stage.setIconified(true);
    }

    public static void main(String[] args) {
        launch();
//       try {
//
//           System.out.println(new Date().getTime());
//           new User_Service().LOGIN(new User("ZAHER.amri@esprit.tn", "not today"));
//           System.out.println(new Date().getTime());
//           System.out.println(Auth.Provider().user());
//           System.out.println(new Date().getTime());
//           Command c = Auth.Provider().user().getCart();
//           System.out.println(c);
//           System.out.println(new Command_Service().VALIDATE(c));
//           System.out.println(c);
//           Auth.logout();
//           System.out.println(Auth.Provider().user());
//           System.out.println(new Date().getTime());
//       }catch (Exception e){
//           System.out.println("User is not logged in");
//           System.out.println(new Date().getTime());
//       }
//        System.out.println(new Command_Service().READALL(new User("8c8153c5-f54e-430b-8f28-a4633e2f7258","dsgfhkdj","kjdfghdfkj")));
    }
}