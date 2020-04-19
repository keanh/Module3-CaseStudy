package service;

import model.Order;

import java.util.List;

public interface OrderService {
    List<Order> selectOrder(int idAccount);
    boolean deleteOrder(int idProduct, int idAccount);
    void insertOrder(int idProduct,int idAccount);
}
