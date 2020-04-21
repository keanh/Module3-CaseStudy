package service;

import model.Account;

import javax.servlet.http.HttpSession;
import java.sql.*;

public class AccountServiceImpl implements AccountService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/quan_ly_dien_thoai?useSSL=false";
    private String jdbcUser = "root";
    private String jdbcPassword = "123456";

    public AccountServiceImpl() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public void insertAccount(Account account) {
        String query = "{Call createAccount(?,?,?,?,?,?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setString(1,account.getName());
            callableStatement.setString(2,account.getPhoneNumber());
            callableStatement.setString(3,account.getAddress());
            callableStatement.setString(4,account.getEmail());
            callableStatement.setString(5,account.getUsername());
            callableStatement.setString(6,account.getPassword());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean deleteAccount(int id) {
        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        boolean update = false;
        String query = "{Call updateAccount(?,?,?,?,?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setString(1,account.getName());
            callableStatement.setString(2,account.getPhoneNumber());
            callableStatement.setString(3,account.getAddress());
            callableStatement.setString(4,account.getEmail());
            callableStatement.setInt(5,account.getId());
            update = callableStatement.executeUpdate() >0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return update;
    }

    public boolean updatePassword(Account account){
        boolean update = false;
        String query = "Call updatePassword(?,?)";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1,account.getId());
            callableStatement.setString(2,account.getPassword());
            update = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return update;
    }

    @Override
    public Account selectAccount(int id) {
        Account account = null;
        String query = "{Call selectAccountById(?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                account = new Account(name, phoneNumber, address, email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return account;
    }

    @Override
    public boolean checkLoginWebsite(String userName, String passWord) {
        Account account = null;
        String query = "{Call selectAccount(?,?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1, userName);
            callableStatement.setString(2, passWord);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                if (username.equals(userName) && password.equals(passWord)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }

    public Account selectInformationOfAccount(String userName, String passWord) {
        Account account = null;
        String query = "{Call selectAccount(?,?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1, userName);
            callableStatement.setString(2, passWord);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                account = new Account(id,name, phoneNumber, address, email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return account;
    }

    public Account checkUser(String userName) {
        Account account = null;
        String query = "{Call checkUsername(?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1, userName);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phoneNumber");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                account = new Account(id,name, phoneNumber, address, email,username);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return account;
    }
}
