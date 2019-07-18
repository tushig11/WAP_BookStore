package controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import dao.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

@WebServlet(name = "Search", value="/search")
public class Search extends HttpServlet {

    Gson mapper = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> resultList = new ArrayList<>();
        List<Product> productList = ProductDAO.getAllProducts();
        String jsonString = request.getParameter("categories");
        String strArray[] = jsonString.substring(1,jsonString.length()-1).split(",");
        List<Boolean> cats = Arrays.stream(strArray).map(p->Boolean.parseBoolean(p)).collect(Collectors.toList());

        if(cats.get(0))
            resultList.addAll(productList.stream().filter(p->p.getCategory() == Category.BIOGRAPHY).collect(Collectors.toList()));

        if(cats.get(1))
            resultList.addAll(productList.stream().filter(p->p.getCategory() == Category.BUSINESS).collect(Collectors.toList()));

        if(cats.get(2))
            resultList.addAll(productList.stream().filter(p->p.getCategory() == Category.HISTORY).collect(Collectors.toList()));

        if(cats.get(3))
            resultList.addAll(productList.stream().filter(p->p.getCategory() == Category.MYSTERY).collect(Collectors.toList()));

        if(!(cats.contains(true)))
            resultList.addAll(productList);

        PrintWriter out = response.getWriter();
        out.print(mapper.toJson(resultList));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> prodList = ProductDAO.getAllProducts();
        Double priceValue = parseDouble(request.getParameter("price"));
        prodList = prodList.stream().filter(p->p.getPrice()<priceValue).collect(Collectors.toList());
        PrintWriter out = response.getWriter();
        out.print(mapper.toJson(prodList));
    }
}
