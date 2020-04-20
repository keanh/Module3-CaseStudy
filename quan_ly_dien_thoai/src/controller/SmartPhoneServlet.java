package controller;

import model.Account;
import model.SmartPhone;
import service.AccountServiceImpl;
import service.SmartPhoneServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SmartPhoneServlet",urlPatterns = "/home")
public class SmartPhoneServlet extends HttpServlet {
    private SmartPhoneServiceImpl smartPhoneService = new SmartPhoneServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createSmartPhone(request, response);
                break;
            case "update":
                updateSmartPhone(request, response);
                break;
            case "delete":
                deleteSmartPhone(request, response);
                break;
            case "search":
                searchSmartPhoneSearchedByName(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                showInformation(request, response);
                break;
            default:
                showHome(request,response);
                break;
        }
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<SmartPhone> list = smartPhoneService.findAllSmartPhone();
            request.setAttribute("listSmartPhone", list);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/home.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            if (account == null) {
                response.sendRedirect("/login");
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("SmartPhone/create.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            if (account == null) {
                response.sendRedirect("/login");
            }else {
                int id = Integer.parseInt(request.getParameter("id"));
                SmartPhone existingSmartPhone = smartPhoneService.selectSmartPhone(id);
                request.setAttribute("smartPhone", existingSmartPhone);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("SmartPhone/update.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            if (account == null) {
                response.sendRedirect("/login");
            }else {
                int id = Integer.parseInt(request.getParameter("id"));
                SmartPhone existingSmartPhone = smartPhoneService.selectSmartPhone(id);
                request.setAttribute("smartPhone", existingSmartPhone);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("SmartPhone/delete.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showInformation(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            SmartPhone existingSmartPhone = smartPhoneService.selectSmartPhone(id);
            request.setAttribute("smartPhone", existingSmartPhone);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/view.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchSmartPhoneSearchedByName(HttpServletRequest request, HttpServletResponse response){
        try {
            String name = request.getParameter("search");
            SmartPhone smartPhone = smartPhoneService.selectSmartPhoneByName(name);
            List<SmartPhone> list = new ArrayList<>();
            list.add(smartPhone);
            request.setAttribute("listSmartPhone", list);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/home.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createSmartPhone(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            String origin = request.getParameter("origin");
            String operatingSystem = request.getParameter("operatingSystem");
            String language = request.getParameter("language");
            String screenType = request.getParameter("screenType");
            String resolution = request.getParameter("resolution");
            String wideScreen = request.getParameter("wideScreen");
            String rearCamera = request.getParameter("rearCamera");
            String frontCamera = request.getParameter("frontCamera");
            String ROM = request.getParameter("ROM");
            String RAM = request.getParameter("RAM");
            String weight = request.getParameter("weight");
            String size = request.getParameter("size");
            String batteryType = request.getParameter("batteryType");
            String batteryCapacity = request.getParameter("batteryCapacity");
            String pictureLink = request.getParameter("pictureLink");
            SmartPhone smartPhone = new SmartPhone(name, price, origin, operatingSystem, language, screenType, resolution, wideScreen,
                    rearCamera, frontCamera, ROM, RAM, weight, size, batteryType, batteryCapacity, pictureLink);
            smartPhoneService.insertSmartPhone(smartPhone);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("SmartPhone/create.jsp");
            requestDispatcher.forward(request, response);
        }catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateSmartPhone(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            String origin = request.getParameter("origin");
            String operatingSystem = request.getParameter("operatingSystem");
            String language = request.getParameter("language");
            String screenType = request.getParameter("screenType");
            String resolution = request.getParameter("resolution");
            String wideScreen = request.getParameter("wideScreen");
            String rearCamera = request.getParameter("rearCamera");
            String frontCamera = request.getParameter("frontCamera");
            String ROM = request.getParameter("ROM");
            String RAM = request.getParameter("RAM");
            String weight = request.getParameter("weight");
            String size = request.getParameter("size");
            String batteryType = request.getParameter("batteryType");
            String batteryCapacity = request.getParameter("batteryCapacity");
            String pictureLink = request.getParameter("pictureLink");
            SmartPhone smartPhone = new SmartPhone(id, name, price, origin, operatingSystem, language, screenType, resolution, wideScreen,
                    rearCamera, frontCamera, ROM, RAM, weight, size, batteryType, batteryCapacity, pictureLink);
            smartPhoneService.updateSmartPhone(smartPhone);
            response.sendRedirect("/home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteSmartPhone(HttpServletRequest request, HttpServletResponse response){
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            smartPhoneService.selectSmartPhone(id);
            smartPhoneService.deleteSmartPhone(id);
            showHome(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

