package sample.tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by creat on 23.04.2017.
 */
public class Section {
    private IntegerProperty id;
    private IntegerProperty userId;
    private StringProperty title;

    public Section(){
        this(0,0,"");
    }

    public Section(int id, int userId, String title) {
        this.id = new SimpleIntegerProperty(id);
        this.userId = new SimpleIntegerProperty(userId);
        this.title = new SimpleStringProperty(title);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getUserId() {
        return userId.get();
    }

    public IntegerProperty userIdProperty() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId.set(userId);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }
}
