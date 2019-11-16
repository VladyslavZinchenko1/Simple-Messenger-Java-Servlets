package db;

import entity.Dialog;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBManager {
    private static final String USER = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String PASS = "1234";
    private static final String SQL_ADD_USER = "insert into massangerbdkppap.user(username, email, password, name, surname) values (?,?,?,?,?)";
    private static final String SQL_GET_USER_BY_USERNAME_AND_PASSWORD = "select * from massangerbdkppap.user where username = ? and password  = ?";
    private static final String SQL_GET_USER_BY_ID = "select * from massangerbdkppap.user where id_user=?";
    private static final String SQL_CREATE_DIALOG = "INSERT into massangerbdkppap.dialog(create_at,user_id_to_user, user_id_from_user) VALUES (?,?,?)";
    private static final String SQL_GET_DIALOG = "SELECT dialog.content, dialog.create_at, dialog.user_id_to_user, dialog.user_id_from_user from massangerbdkppap.dialog where" +
            "(dialog.user_id_from_user = ? and dialog.user_id_to_user = ?) OR" +
            " (dialog.user_id_from_user = ? and dialog.user_id_to_user = ?)";
    private static final String SQL_UPDATE_DIALOG="INSERT into massangerbdkppap.dialog(content, create_at, user_id_to_user, user_id_from_user) VALUES (?,?,?,?)";
    private static final String SQL_DELETE_WHERE_NULL="delete from dialog where content is null";
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        con.setAutoCommit(true);
        System.out.println("Connection to database");
        return con;
    }
    public void AddUser(User user) {
        try (Connection connection = new DBManager().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_USER);
            int k = 0;
            statement.setString(++k, user.getUsername());
            statement.setString(++k, user.getEmail());
            statement.setString(++k, user.getPassword());
            statement.setString(++k, user.getName());
            statement.setString(++k, user.getSurname());
            statement.executeUpdate();
            statement.close();
            System.out.println("exucute sucses");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void deleteNull(){
        try (Connection connection = new DBManager().getConnection()) {
            CallableStatement callableStatement =connection.prepareCall(SQL_DELETE_WHERE_NULL);
            callableStatement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = null;
        try (Connection connection = new DBManager().getConnection()) {
            user = new User();
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USER_BY_USERNAME_AND_PASSWORD);
            int k = 0;
            statement.setString(++k, username);
            statement.setString(++k, password);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("ID_USER"));
            user.setUsername(resultSet.getString("USERNAME"));
            user.setEmail(resultSet.getString("EMAIL"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setName(resultSet.getString("NAME"));
            user.setSurname(resultSet.getString("SURNAME"));
            statement.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
    public User getUserById(int id){
        User user2 = null;
        try (Connection connection = new DBManager().getConnection()) {
            user2 = new User();
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USER_BY_ID);
            int k=0;
            statement.setInt(++k, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user2.setId(resultSet.getInt("ID_USER"));
            user2.setUsername(resultSet.getString("USERNAME"));
            user2.setEmail(resultSet.getString("EMAIL"));
            user2.setPassword(resultSet.getString("PASSWORD"));
            user2.setName(resultSet.getString("NAME"));
            user2.setSurname(resultSet.getString("SURNAME"));
            statement.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user2;
        }
        public Dialog CreateDialog(Dialog dialog) {
            try (Connection connection = new DBManager().getConnection()) {
                PreparedStatement statement = connection.prepareStatement(SQL_CREATE_DIALOG);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                int k=0;
                statement.setTimestamp(++k,timestamp);
                statement.setInt(++k,dialog.getId_from());
                statement.setInt(++k,dialog.getId_to());
                statement.executeUpdate();
                statement.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return dialog;
        }
        public List <Dialog> GetDialogContent( Dialog dialog) {
            List<Dialog> contentDialogs = new ArrayList<>();
            try (Connection connection = new DBManager().getConnection()) {
                PreparedStatement statement = connection.prepareStatement(SQL_GET_DIALOG);
                int k=0;
                statement.setInt(++k,dialog.getId_to());
                statement.setInt(++k,dialog.getId_from());
                statement.setInt(++k,dialog.getId_from());
                statement.setInt(++k,dialog.getId_to());
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()) {
                    contentDialogs.add(new Dialog(resultSet.getString("CONTENT"),Timestamp.valueOf(resultSet.getString("CREATE_AT")), Integer.parseInt(resultSet.getString("USER_ID_TO_USER")),
                            Integer.parseInt(resultSet.getString("USER_ID_FROM_USER"))));
                   // contentDialogs.add(new Dialog(resultSet.getString("CREATE_AT)")));
                }

                statement.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return contentDialogs;
        }
        public void InitContent(Dialog dialog) {
            try (Connection connection = new DBManager().getConnection()) {
                PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_DIALOG);
                int k=0;
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                statement.setString(++k,dialog.getContent());
                statement.setTimestamp(++k, timestamp);
                statement.setInt(++k,dialog.getId_from());
                statement.setInt(++k,dialog.getId_to());
                statement.executeUpdate();
                statement.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
}
