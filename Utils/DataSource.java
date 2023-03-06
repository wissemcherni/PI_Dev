package production.x_change.Utils;

import javafx.application.Platform;
import production.x_change.Main.Main;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
    private Connection cnx;
    private DataSource(){
        try {
            String USERNAME = "root";
            String db_name = "x-change";
            String url = "jdbc:mysql://localhost:3306/" + db_name + "?characterEncoding=latin1&useConfigs=maxPerformance";
            String MY_PASS = PASSWORDGETTER.pwdGetter().PASSWORDGETTER();
            cnx = DriverManager.getConnection(url, USERNAME, MY_PASS);
//            System.out.println("JDBC CONNECTED TO "+db_name.toUpperCase());
        }catch (Exception ex ) {
            Platform.runLater(Main::CLOSE);
//            System.out.println(ex.getMessage());
        }
    }
    public static DataSource getInstance() {
        return new DataSource();
    }

    public Connection getCnx() {
        return cnx;
    }
    /*
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
     */
    private static class PASSWORDGETTER {
        public static PASSWORDGETTER pwdGetter() {
            return new PASSWORDGETTER();
        }
        private String pwd;
        private PASSWORDGETTER(){
            this.pwd = "not today";
        }
        protected String PASSWORDGETTER(){
            return this.pwd;
        }

    }
}

