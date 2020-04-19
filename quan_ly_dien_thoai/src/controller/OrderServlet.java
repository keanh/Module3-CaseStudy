package controller;

import model.Account;
import model.Order;
import service.OrderService;
import service.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.spi.MidiDeviceProvider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShoppingCartInterfaceServlet",urlPatterns = "/shopping")
public class OrderServlet extends HttpServlet {
    OrderServiceImpl orderService = new OrderServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try{
            switch (action){
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try{
            switch (action){
                case "order":
                    orderSmartPhone(request,response);
                    break;
                case "delete":
                    deleteOrder(request,response);
                    break;
                default:
                    showShoppingCartInterface(request,response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showShoppingCartInterface(HttpServletRequest request,HttpServletResponse response){
        try{
            Account account = (Account) request.getSession().getAttribute("account");
            if (account == null){
                response.sendRedirect("/login");
            }else{
                int idAccount = account.getId();
                List<Order> list = orderService.selectOrder(idAccount);
                request.setAttribute("order",list);
                Order total = orderService.sumTotal(idAccount);
                request.setAttribute("total",total);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("ShoppingCartInterface/Shopping.jsp");
                requestDispatcher.forward(request,response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void orderSmartPhone(HttpServletRequest request,HttpServletResponse response) {
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            if (account == null) {
                response.sendRedirect("/login");
            } else {
                int idProduct = Integer.parseInt(request.getParameter("idProduct"));
                int idAccount = account.getId();
                orderService.insertOrder(idProduct,idAccount);
                response.sendRedirect("/home");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteOrder(HttpServletRequest request,HttpServletResponse response){
        try{
            int idProduct = Integer.parseInt(request.getParameter("id"));
            Account account = (Account) request.getSession().getAttribute("account");
            int idAccount = account.getId();
            orderService.deleteOrder(idProduct,idAccount);
            response.sendRedirect("/shopping");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
