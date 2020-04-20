package service;

import model.Order;

import javax.sound.midi.spi.MidiDeviceProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/quan_ly_dien_thoai?useSSL=false";
    private String jdbcUser = "root";
    private String jdbcPassword = "123456";

    public OrderServiceImpl() {
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
    public List<Order> selectOrder(int idAccount) {
        List<Order> list = new ArrayList<>();
        Order order = null;
        String query = "{Call selectSmartPhoneOrder(?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1,idAccount);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int idProduct = resultSet.getInt("smartphone.id");
                String productName = resultSet.getString("smartphone.name");
                int price = resultSet.getInt("smartphone.price");
                String pictureLink = resultSet.getString("smartphone.pictureLink");
                String accountName = resultSet.getString("account.name");
                String phoneNumber = resultSet.getString("account.phoneNumber");
                order = new Order(idProduct,productName,price,pictureLink);
                list.add(order);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public Order sumTotal(int idAccount){
        Order order = null;
        String query = "{Call sumOfPrice(?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1,idAccount);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ordersmartphone.id");
                int total = resultSet.getInt("total");
                int totalOrder = resultSet.getInt("dem");
                order = new Order(id,total,totalOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void insertOrder(int idProduct, int idAccount) {
        String query = "{call insertOrder(?,?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1,idProduct);
            callableStatement.setInt(2,idAccount);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean deleteOrder(int idProduct,int idAccount) {
        boolean delete = false;
        String query = "{Call deleteOrder(?,?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1, idProduct);
            callableStatement.setInt(2,idAccount);
            delete = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }
}
