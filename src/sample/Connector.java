package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.pool.OracleDataSource;
import sample.tables.Post;
import sample.tables.Section;
import sample.tables.Thread;
import sample.tables.User;

import java.sql.*;


public class Connector {

    private String username = "";
    private String password = "";
    private Connection connection;

    Connector(String username, String password) {
        this.username = username;
        this.password = password;
    }


    private void getDBConnection()  throws SQLException{
        OracleDataSource dataSource;
        dataSource = new OracleDataSource();
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
        dataSource.setURL(jdbcUrl);
        connection = dataSource.getConnection(username,password);
    }


    /**
     *
     *
     * Finders
     *
     */

    public ObservableList<User> findAllUsers() throws SQLException {

        getDBConnection();

        ObservableList<User> userData = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM Uzytkownicy ORDER BY ID_UZYTKOWNIKA";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
                userData.add(createUserData(resultSet));
        }
        return userData;
    }

    public ObservableList<Section> findAllSections() throws SQLException {

        getDBConnection();

        ObservableList<Section> sectionData = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM Dzialy ORDER BY ID_DZIALU";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            sectionData.add(createSectionData(resultSet));
        }
        return sectionData;
    }

    public ObservableList<Thread> findAllThreads() throws SQLException {
        getDBConnection();

        ObservableList<Thread> threadData = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM Watek ORDER BY ID_WATKU";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            threadData.add(createThreadData(resultSet));
        }
        return threadData;
    }



    public ObservableList<Post> findAllPosts() throws SQLException {
        getDBConnection();

        ObservableList<Post> postData = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM Komentarze ORDER BY ID_KOMENTARZA";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            postData.add(createPostData(resultSet));
        }
        return postData;
    }



    /**
     *
     *  Creators
     *
     */

    private User createUserData(ResultSet resultSet) throws SQLException {
        User userData = new User();
        userData.setId(resultSet.getInt("ID_UZYTKOWNIKA"));
        userData.setNick(resultSet.getString("NICK"));
        userData.setEmail(resultSet.getString("EMAIL"));
        userData.setIsAdmin(resultSet.getInt("ADMIN"));
        System.out.println(userData.toString());
        return userData;
    }

    private Section createSectionData(ResultSet resultSet) throws SQLException {
        Section sectionData = new Section();
        sectionData.setId(resultSet.getInt("ID_DZIALU"));
        sectionData.setUserId(resultSet.getInt("ID_UZYTKOWNIKA"));
        sectionData.setTitle(resultSet.getString("NAZWA"));
        System.out.println(sectionData.toString());
        return sectionData;
    }

    private Thread createThreadData(ResultSet resultSet) throws SQLException {
        Thread threadData = new Thread();
        threadData.setId(resultSet.getInt("ID_WATKU"));
        threadData.setSectionId(resultSet.getInt("ID_DZIALU"));
        threadData.setUserId(resultSet.getInt("ID_UZYTKOWNIKA"));
        threadData.setTitle(resultSet.getString("TYTUL"));
        System.out.println(threadData.toString());
        return threadData;
    }


    private Post createPostData(ResultSet resultSet)throws SQLException {
        Post threadData = new Post();
        threadData.setId(resultSet.getInt("ID_KOMENTARZA"));
        threadData.setThreadId(resultSet.getInt("ID_WATKU"));
        threadData.setUserId(resultSet.getInt("ID_UZYTKOWNIKA"));
        threadData.setContent(resultSet.getString("TRESC"));
        System.out.println(threadData.toString());
        return threadData;
    }

    public void updateCell(String nameOfTable, String nameOfColumn, String nameOfIDColumn, String newValue, int id) throws SQLException {
        getDBConnection();

        String selectQuery = "UPDATE "+nameOfTable+" SET "+nameOfColumn+" = '"+ newValue +"' WHERE "+nameOfIDColumn+" = "+id;

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.executeUpdate();
    }

}
