package production.x_change.Models;

import production.x_change.Services.Product_Module.Product_Service;
import production.x_change.Services.Sales_Module.Command_Service;
import production.x_change.Services.User_Module.*;

import java.util.HashMap;

public class User {
    private String id;
    private String email;
    private String password;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public User(String id, String email, String password) {
        this.id = id;
        this.email = email.toLowerCase();
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email.toLowerCase();
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString(){
        return this.id;
    }
    public boolean isGranted(Role role){
        return new Role_Service().READALL(this).containsValue(role);
    }
    public Profile getProfile() {
        return new Profile_Service().READONE(this);
    }
    public HashMap<Integer,Role> getRoles(){
        return new Role_Service().READALL(this);
    }
    public Balance getBalance(){
        return new Balance_Service().READONE(this);
    }
    public HashMap<Integer,Access_Token> getTokens(){
        return new Access_Token_Service().READALL(this);
    }
    public HashMap<Integer,Product> getProducts(){
        return new Product_Service().READALL(this);
    }
    public Command getCart(){
        return new Command_Service().READONE(this);
    }
    public HashMap<Integer,Command> getCommands(){
        return new Command_Service().READALL(this);
    }

    public HashMap<Integer,Password_Reset> getPassword_Resets() {
        return new Password_Reset_Service().READALL(this);
    }
}
