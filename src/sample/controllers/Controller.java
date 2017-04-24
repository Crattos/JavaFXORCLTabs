package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.NumberStringConverter;
import sample.Connector;
import sample.tables.Post;
import sample.tables.Section;
import sample.tables.Thread;
import sample.tables.User;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {




    @FXML
    private TableView<User> userTable;
    @FXML
    public TableColumn<User, Number> userID;
    @FXML
    private TableColumn<User, String> userNick;
    @FXML
    private TableColumn<User, String> userEmail;
    @FXML
    private TableColumn<User, Number> userIsAdmin;


    @FXML
    private TableView<Section>  sectionTable;
    @FXML
    public TableColumn<Section, Number> sectionUserId;
    @FXML
    public TableColumn<Section, Number>  sectionId;
    @FXML
    public TableColumn<Section, String> sectionTitle;

    @FXML
    public TableView<Thread> threadTable;
    @FXML
    public TableColumn<Thread, Number> threadID;
    @FXML
    public TableColumn<Thread, Number> threadUserId;
    @FXML
    public TableColumn<Thread, Number> threadSectionId;
    @FXML
    public TableColumn<Thread, String> threadTitle;

    @FXML
    public TableView<Post> postTable;
    @FXML
    public TableColumn<Post, Number> postID;
    @FXML
    public TableColumn<Post, Number> postThreadId;
    @FXML
    public TableColumn<Post, Number> postUserID;
    @FXML
    public TableColumn<Post, String> postContent;


    private void connectTableColumnsToUser() {
        userID.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        userNick.setCellValueFactory(cellData -> cellData.getValue().nickProperty());
        userEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        userIsAdmin.setCellValueFactory(cellData -> cellData.getValue().isAdminProperty());

        sectionId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        sectionUserId.setCellValueFactory(cellData -> cellData.getValue().userIdProperty());
        sectionTitle.setCellValueFactory(cellData -> cellData.getValue().titleProperty());

        threadID.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        threadUserId.setCellValueFactory(cellData -> cellData.getValue().userIdProperty());
        threadSectionId.setCellValueFactory(cellData -> cellData.getValue().sectionIdProperty());
        threadTitle.setCellValueFactory(cellData -> cellData.getValue().titleProperty());


        postID.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        postThreadId.setCellValueFactory(cellData -> cellData.getValue().threadIdProperty());
        postUserID.setCellValueFactory(cellData -> cellData.getValue().userIdProperty());
        postContent.setCellValueFactory(cellData -> cellData.getValue().contentProperty());

    }

    public void loadUpTheUsers(Connector connector) throws SQLException {
        userTable.setItems(connector.findAllUsers());
        sectionTable.setItems(connector.findAllSections());
        threadTable.setItems(connector.findAllThreads());
        postTable.setItems(connector.findAllPosts());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectTableColumnsToUser();
        setEditableCells();
    }

    private void setEditableCells() {
        userNick.       setCellFactory(TextFieldTableCell.forTableColumn());
        userEmail.      setCellFactory(TextFieldTableCell.forTableColumn());
        userIsAdmin.    setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));

        sectionUserId.  setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        sectionTitle.   setCellFactory(TextFieldTableCell.forTableColumn());

        threadUserId.   setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        threadSectionId.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        threadTitle.    setCellFactory(TextFieldTableCell.forTableColumn());


        postThreadId.   setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        postUserID.     setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        postContent.    setCellFactory(TextFieldTableCell.forTableColumn());
    }


    public void editUserNick(TableColumn.CellEditEvent<User, String> cell) {
        cell.getTableView().getItems().get(cell.getTablePosition().getRow()).setNick(cell.getNewValue());
        System.out.println(cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId());
    }
}
