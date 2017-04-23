package sample.tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by creat on 23.04.2017.
 */
public class User {

    private IntegerProperty id;
    private SimpleStringProperty nick;
    private SimpleStringProperty email;
    private IntegerProperty isAdmin ;

    public User() {
        this(0, "unk", "unk", 0);
    }

    public User(int id, String nick, String email, int isAdmin) {
        this.id = new SimpleIntegerProperty(id);
        this.nick = new SimpleStringProperty(nick);
        this.email = new SimpleStringProperty(email);
        this.isAdmin = new SimpleIntegerProperty(isAdmin);
    }


    public IntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty nickProperty() {
        return nick;
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public IntegerProperty isAdminProperty() {
        return isAdmin;
    }


    public int getId() {
        return id.get();
    }


    public void setId(int id) {
        this.id.set(id);
    }

    public int getIsAdmin() {
        return isAdmin.get();
    }


    public void setIsAdmin(int isAdmin) {
        this.isAdmin.set(isAdmin);
    }


    public String getNick() {
        return nick.get();
    }

    public void setNick(String nick) {
        this.nick.set(nick);
    }


    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

}
