package service;

import model.Account;
import model.SmartPhone;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SmartPhoneServiceImpl implements SmartPhoneService{
    private String jdbcURL = "jdbc:mysql://localhost:3306/quan_ly_dien_thoai?useSSL=false";
    private String jdbcUser = "root";
    private String jdbcPassword = "123456";

    public SmartPhoneServiceImpl() {
    }

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUser,jdbcPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    private void printSQLException(SQLException ex){
        for (Throwable e:ex){
            if (e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null){
                    System.out.println("Cause: " + t);
                    t=t.getCause();
                }
            }
        }
    }

    @Override
    public List<SmartPhone> findAllSmartPhone() {
        List<SmartPhone> list = new ArrayList<>();
        String query ="{Call selectAll()}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String link = resultSet.getString("pictureLink");
                list.add(new SmartPhone(id,name,price,link));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return list;
    }

    @Override
    public void insertSmartPhone(SmartPhone smartPhone) {
        String query = "{Call createSmartPhone(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
                callableStatement.setString(1,smartPhone.getName());
                callableStatement.setInt(2,smartPhone.getPrice());
                callableStatement.setString(3,smartPhone.getOrigin());
                callableStatement.setString(4,smartPhone.getOperatingSystem());
                callableStatement.setString(5,smartPhone.getLanguage());
                callableStatement.setString(6,smartPhone.getScreenType());
                callableStatement.setString(7,smartPhone.getResolution());
                callableStatement.setString(8,smartPhone.getWideScreen());
                callableStatement.setString(9,smartPhone.getRearCamera());
                callableStatement.setString(10,smartPhone.getFrontCamera());
                callableStatement.setString(11,smartPhone.getROM());
                callableStatement.setString(12,smartPhone.getRAM());
                callableStatement.setString(13,smartPhone.getWeight());
                callableStatement.setString(14,smartPhone.getSize());
                callableStatement.setString(15,smartPhone.getBatteryType());
                callableStatement.setString(16,smartPhone.getBatteryCapacity());
                callableStatement.setString(17,smartPhone.getPictureLink());
                callableStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public boolean deleteSmartPhone(int id) {
        boolean rowDelelte = false;
        String query = "{Call deleteSmartPhone(?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1,id);
            rowDelelte = callableStatement.executeUpdate() > 0;
        }catch (SQLException e){
            printSQLException(e);
        }
        return rowDelelte;
    }

    @Override
    public boolean updateSmartPhone(SmartPhone smartPhone) {
        boolean rowUpdate = false;
        String query = "{Call updateSmartPhone(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setString(1,smartPhone.getName());
            callableStatement.setInt(2,smartPhone.getPrice());
            callableStatement.setString(3,smartPhone.getOrigin());
            callableStatement.setString(4,smartPhone.getOperatingSystem());
            callableStatement.setString(5,smartPhone.getLanguage());
            callableStatement.setString(6,smartPhone.getScreenType());
            callableStatement.setString(7,smartPhone.getResolution());
            callableStatement.setString(8,smartPhone.getWideScreen());
            callableStatement.setString(9,smartPhone.getRearCamera());
            callableStatement.setString(10,smartPhone.getFrontCamera());
            callableStatement.setString(11,smartPhone.getROM());
            callableStatement.setString(12,smartPhone.getRAM());
            callableStatement.setString(13,smartPhone.getWeight());
            callableStatement.setString(14,smartPhone.getSize());
            callableStatement.setString(15,smartPhone.getBatteryType());
            callableStatement.setString(16,smartPhone.getBatteryCapacity());
            callableStatement.setString(17,smartPhone.getPictureLink());
            callableStatement.setInt(18,smartPhone.getId());
            rowUpdate =callableStatement.executeUpdate()>0;
        }catch (SQLException e){
            printSQLException(e);
        }
        return rowUpdate;
    }

    @Override
    public SmartPhone selectSmartPhone(int id) {
        SmartPhone smartPhone = null;
        String query = "{Call selectSmartPhoneById(?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
                callableStatement.setInt(1,id);
                ResultSet resultSet = callableStatement.executeQuery();
                while (resultSet.next()){
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    String origin = resultSet.getString("origin");
                    String operatingSystem = resultSet.getString("operatingSystem");
                    String language = resultSet.getString("language");
                    String screenType = resultSet.getString("screenType");
                    String resolution = resultSet.getString("resolution");
                    String wideScreen = resultSet.getString("wideScreen");
                    String rearCamera = resultSet.getString("rearCamera");
                    String frontCamera = resultSet.getString("frontCamera");
                    String ROM = resultSet.getString("ROM");
                    String RAM = resultSet.getString("RAM");
                    String weight = resultSet.getString("weight");
                    String size = resultSet.getString("size");
                    String batteryType = resultSet.getString("batteryType");
                    String batteryCapacity = resultSet.getString("batteryCapacity");
                    String pictureLink = resultSet.getString("pictureLink");
                    smartPhone = new SmartPhone(id,name,price,origin,operatingSystem,language,screenType,resolution,wideScreen,
                            rearCamera,frontCamera,ROM,RAM,weight,size,batteryType,batteryCapacity,pictureLink);
                }
        }catch (SQLException e){
            printSQLException(e);
        }
        return smartPhone;
    }

    @Override
    public SmartPhone selectSmartPhoneByName(String name) {
        String query = "{Call selectSmartPhoneByName(?)}";
        SmartPhone smartPhone = null;
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setString(1,name);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int price = resultSet.getInt("price");
                String origin = resultSet.getString("origin");
                String operatingSystem = resultSet.getString("operatingSystem");
                String language = resultSet.getString("language");
                String screenType = resultSet.getString("screenType");
                String resolution = resultSet.getString("resolution");
                String wideScreen = resultSet.getString("wideScreen");
                String rearCamera = resultSet.getString("rearCamera");
                String frontCamera = resultSet.getString("frontCamera");
                String ROM = resultSet.getString("ROM");
                String RAM = resultSet.getString("RAM");
                String weight = resultSet.getString("weight");
                String size = resultSet.getString("size");
                String batteryType = resultSet.getString("batteryType");
                String batteryCapacity = resultSet.getString("batteryCapacity");
                String pictureLink = resultSet.getString("pictureLink");
                smartPhone = new SmartPhone(id,name,price,origin,operatingSystem,language,screenType,resolution,wideScreen,
                        rearCamera,frontCamera,ROM,RAM,weight,size,batteryType,batteryCapacity,pictureLink);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return smartPhone;
    }

}
