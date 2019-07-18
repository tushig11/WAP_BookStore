package controller;

import com.google.gson.Gson;
import dao.ProductDAO;
import model.Cart;
import model.Product;

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

@WebServlet(name = "All", value = "/ajax_all")
public class All extends HttpServlet {
    Gson mapper = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> prodList = ProductDAO.getAllProducts();
        PrintWriter out = response.getWriter();
        out.print(mapper.toJson(prodList));
    }
}
