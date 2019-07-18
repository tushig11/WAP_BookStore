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

@WebServlet(name = "Add", value="/addToCart")
public class Add extends HttpServlet {
    private Cart cart;
    Gson mapper = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(session.getAttribute("cart") == null){
            cart = new Cart();
        }else {
            cart = (Cart)session.getAttribute("cart");
        }
        int id = parseInt(request.getParameter("id"));
        List<Product> selected = ProductDAO.getAllProducts().stream().filter(p->p.getId()==id).collect(Collectors.toList());
        cart.addToCart(selected.get(0));

        session.setAttribute("cart", cart);

        int cardSize = cart.getSize();
        PrintWriter out = response.getWriter();
        out.print(cardSize);
    }
}
