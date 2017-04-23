package sample.tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by creat on 23.04.2017.
 */
public class Thread {
    private IntegerProperty id;
    private IntegerProperty sectionId;
    private IntegerProperty userId;
    private StringProperty title;

    public Thread(){
        this(0,0,0,"");
    }

    public Thread(int id,int sectionId, int userId, String title) {
        this.id = new SimpleIntegerProperty(id);
        this.sectionId = new SimpleIntegerProperty(sectionId);
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

    public int getSectionId() {
        return sectionId.get();
    }

    public IntegerProperty sectionIdProperty() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId.set(sectionId);
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
