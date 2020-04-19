package controller;

import model.Account;
import service.AccountServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AccountServlet" , urlPatterns = "/login")
public class AccountServlet extends HttpServlet {
    private AccountServiceImpl accountService = new AccountServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                loginWebsite(request, response);
                break;
            case "update":
                updateAccount(request, response);
                break;
            case "create":
                createAccount(request, response);
                break;
            case "password":
                updatePassword(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "logout":
                logout(request, response);
                break;
            case "view":
                showInformationAccount(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "create":
                showCreateForm(request, response);
                break;
            case "password":
                showUpdatePasswordForm(request,response);
                break;
            default:
                showLoginForm(request, response);
                break;
        }
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/login.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            showLoginForm(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showInformationAccount(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Account existingAccount = accountService.selectAccount(id);
            request.setAttribute("account", existingAccount);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("account/view.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            int id = account.getId();
//            int id = Integer.parseInt(request.getParameter("id"));
            Account existingAccount = accountService.selectAccount(id);
            request.setAttribute("account", existingAccount);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("account/update.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loginWebsite(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Account check = accountService.selectInformationOfAccount(username, password);
            if (check != null) {
                HttpSession session = request.getSession();
                session.setAttribute("account", check);
                response.sendRedirect("/home");
            } else {
                RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("login/login.jsp");
                request.setAttribute("message", "Tài khoản hoặc mật khẩu không đúng");
                requestDispatcher1.forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/registration.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdatePasswordForm(HttpServletRequest request,HttpServletResponse response){
        try{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("account/updatePassword.jsp");
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateAccount(HttpServletRequest request, HttpServletResponse response) {
        try {
            Account account = null;
            HttpSession session = request.getSession();
            String name = request.getParameter("name");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            int id = Integer.parseInt(request.getParameter("id"));
            account = new Account(id, name, phoneNumber, address, email);
            session.removeAttribute("account");
            accountService.updateAccount(account);
            session.setAttribute("account", account);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("account/update.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updatePassword(HttpServletRequest request,HttpServletResponse response){
        try{
            Account account = null;
            int id = Integer.parseInt(request.getParameter("id"));
            String password = request.getParameter("password");
            account = new Account(id,password);
            accountService.updatePassword(account);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("account/updatePassword.jsp");
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createAccount(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Account account = new Account(name, phoneNumber, address, email, username, password);
            accountService.insertAccount(account);
            String userName = request.getParameter("username");
            String passWord = request.getParameter("password");
            Account check = accountService.selectInformationOfAccount(userName, passWord);
            if (check != null) {
                HttpSession session = request.getSession();
                session.setAttribute("account", check);
                response.sendRedirect("/home");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
