package controller;

import com.google.gson.Gson;
import dao.ProductDAO;
import model.Cart;
import model.Product;

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

@WebServlet(name = "SearchTxt", value="/searchByText")
public class SearchTxt extends HttpServlet {

    private Cart cart;

    Gson mapper = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> prodList = ProductDAO.getAllProducts();
        String textValue = request.getParameter("text");
        if(!(textValue.equals(" ") || textValue == null)){
            prodList = prodList.stream().filter(p->p.getName().equals(textValue)).collect(Collectors.toList());
        }
        PrintWriter out = response.getWriter();
        out.print(mapper.toJson(prodList));
    }
}
