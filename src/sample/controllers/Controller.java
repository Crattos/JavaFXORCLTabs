package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.converter.BooleanStringConverter;
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


    private Connector connector;

    @FXML
    private TableView<User> userTable;
    @FXML
    public TableColumn<User, Number> userID;
    @FXML
    private TableColumn<User, String> userNick;
    @FXML
    private TableColumn<User, String> userEmail;
    @FXML
    private TableColumn<User, Boolean> userIsAdmin;


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


    private void connectTableColumns() {
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
        this.connector = connector;
    }


    public void refresh() throws SQLException {
        userTable.setItems(connector.findAllUsers());
        sectionTable.setItems(connector.findAllSections());
        threadTable.setItems(connector.findAllThreads());
        postTable.setItems(connector.findAllPosts());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectTableColumns();
        setEditableCells();
    }

    private void setEditableCells() {
        userNick.       setCellFactory(TextFieldTableCell.forTableColumn());
        userEmail.      setCellFactory(TextFieldTableCell.forTableColumn());
        userIsAdmin.    setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));

        sectionUserId.  setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        sectionTitle.   setCellFactory(TextFieldTableCell.forTableColumn());

        threadUserId.   setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        threadSectionId.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        threadTitle.    setCellFactory(TextFieldTableCell.forTableColumn());


        postThreadId.   setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        postUserID.     setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        postContent.    setCellFactory(TextFieldTableCell.forTableColumn());
    }


    /**
     *
     * UZYTKOWNICY
     *
     */

    public void editUserNick(CellEditEvent<User, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("UZYTKOWNICY","NICK","ID_UZYTKOWNIKA",cell.getNewValue(),id);
    }

    public void editUserEmail(CellEditEvent<User, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("UZYTKOWNICY","EMAIL","ID_UZYTKOWNIKA",cell.getNewValue(),id);
    }


    public void editUserIsAdmin(CellEditEvent<User, Boolean> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("UZYTKOWNICY","ADMIN","ID_UZYTKOWNIKA",cell.getNewValue().toString(),id);
    }


    /**
     *
     * DZIALY
     *
     */

    public void editSectionUserID(CellEditEvent<Section, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("DZIALY","ID_UZYTKOWNIKA","ID_DZIALU",cell.getNewValue().toString(),id);
    }


    public void editSectionTitle(CellEditEvent<Section, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("DZIALY","NAZWA","ID_DZIALU", cell.getNewValue(),id);
    }


    /**
     *
     * WĄTKI
     *
     */


    public void editThreadTitle(CellEditEvent<Thread, String>cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("WATEK","TYTUL","ID_WATKU", cell.getNewValue(),id);
    }

    public void editThreadUserId(CellEditEvent<Thread, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("WATEK","ID_UZYTKOWNIKA","ID_WATKU", cell.getNewValue().toString(),id);
    }

    public void editThreadSectionId(CellEditEvent<Thread, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("WATEK","ID_DZIALU","ID_WATKU", cell.getNewValue().toString(),id);
    }

    /**
     *
     * KOMENTARZE
     *
     */



    public void editPostThreadID(CellEditEvent<Post, Number>  cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("KOMENTARZE","ID_WATKU","ID_KOMENTARZA", cell.getNewValue().toString(),id);
    }

    public void editPostUserID(CellEditEvent<Post, Number> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("KOMENTARZE","ID_UZYTKOWNIKA","ID_KOMENTARZA", cell.getNewValue().toString(),id);
    }

    public void editPostContent(CellEditEvent<Post, String> cell) throws SQLException {
        int id = cell.getTableView().getItems().get(cell.getTablePosition().getRow()).getId();
        connector.updateCell("KOMENTARZE","TRESC","ID_KOMENTARZA", cell.getNewValue(),id);
    }

    /**
     *
     *
     * Deleting
     *
     *
     */

    public void modifyThreadRow(KeyEvent keyEvent) throws SQLException {
        if ( keyEvent.getCode().equals( KeyCode.DELETE ) ){
            Thread thread =  threadTable.getSelectionModel().getTableView().getSelectionModel().getSelectedItem();
            connector.deleteRow("WATEK","ID_WATKU",  thread.getId());
            refresh();
        }else if(keyEvent.getCode().equals( KeyCode.INSERT ) ){
            connector.insertNewThread();
            refresh();
        }

    }

    public void modifySectionRow(KeyEvent keyEvent) throws SQLException {
        if ( keyEvent.getCode().equals( KeyCode.DELETE ) ){
            Section section =  sectionTable.getSelectionModel().getTableView().getSelectionModel().getSelectedItem();
            connector.deleteRow("DZIALY","ID_DZIALU",  section.getId());
            refresh();
        }else if(keyEvent.getCode().equals( KeyCode.INSERT ) ){
            connector.insertNewSection();
            refresh();
        }
    }

    public void modifyUserRow(KeyEvent keyEvent) throws SQLException {
        if ( keyEvent.getCode().equals( KeyCode.DELETE ) ){
            User user =  userTable.getSelectionModel().getTableView().getSelectionModel().getSelectedItem();
            connector.deleteRow("UZYTKOWNICY","ID_UZYTKOWNIKA",  user.getId());
            refresh();
        }else if(keyEvent.getCode().equals( KeyCode.INSERT ) ){
            connector.insertNewUser();
            refresh();
        }
    }

    public void modifyPostRow(KeyEvent keyEvent) throws SQLException {
        if ( keyEvent.getCode().equals( KeyCode.DELETE ) ){
            Post post =  postTable.getSelectionModel().getTableView().getSelectionModel().getSelectedItem();
            connector.deleteRow("KOMENTARZE","ID_KOMENTARZA",  post.getId());
            refresh();
        }else if(keyEvent.getCode().equals( KeyCode.INSERT ) ){
            connector.insertNewPost();
            refresh();
        }
    }
}

