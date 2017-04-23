package sample.tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by creat on 23.04.2017.
 */
public class Post {
    private IntegerProperty id;
    private IntegerProperty threadId;
    private IntegerProperty userId;
    private StringProperty content;

    public Post(){
        this(0,0,0,"");
    }

    public Post(int id,int threadId, int userId, String content) {
        this.id = new SimpleIntegerProperty(id);
        this.threadId = new SimpleIntegerProperty(threadId);
        this.userId = new SimpleIntegerProperty(userId);
        this.content = new SimpleStringProperty(content);
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

    public int getThreadId() {
        return threadId.get();
    }

    public IntegerProperty threadIdProperty() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId.set(threadId);
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

    public String getContent() {
        return content.get();
    }

    public StringProperty contentProperty() {
        return content;
    }

    public void setContent(String content) {
        this.content.set(content);
    }
}
