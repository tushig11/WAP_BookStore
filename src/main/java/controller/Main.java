package controller;

import com.google.gson.Gson;
import dao.ProductDAO;
import dao.UserDAO;
import model.Cart;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@WebServlet(name = "Main", value="")
public class Main extends HttpServlet {
    private Cart cart;

    Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
        ProductDAO.DefaultData();
        UserDAO.DefaultUsers();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getSession(false)==null){
            HttpSession session = request.getSession();
            session.setAttribute("username","Guest");
        }

        System.out.println(request.getSession().getAttribute("username"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
