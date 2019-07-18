package dao;

import model.Product;
import model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductDAO {
    static HashMap<Integer, Product> productsDB = new HashMap<>();

    public static void DefaultData(){
        //BIOGRAPHY
        productsDB.put(1, new Product(1,"educated a memoir", "Tara Westover", Category.BIOGRAPHY, 12.99));
        productsDB.put(2, new Product(2,"becoming", "Michelle Obama",Category.BIOGRAPHY, 45.99));
        productsDB.put(3, new Product(3,"America's Reluctant Prince", "Steven M. Gillon",Category.BIOGRAPHY, 11.99));
        productsDB.put(4, new Product(4,"The Boy Who Harnessed the Wind", "William Kamkwamba",Category.BIOGRAPHY,43.99));
        productsDB.put(5, new Product(5,"Dapper Dan: Made in Harlem", "Daniel R. Day",Category.BIOGRAPHY,10.99));
        productsDB.put(6, new Product(6,"Unsinkable", "Debbie Reynolds",Category.BIOGRAPHY,19.99));
        //BUSINESS

        productsDB.put(7, new Product(7,"The New Social Contract", "Joseph Dillon Davey", Category.BUSINESS,29.99));
        productsDB.put(8, new Product(8,"Who Built That", "Michelle Malkin",Category.BUSINESS,33.0));
        productsDB.put(9, new Product(9,"The Speed of Trust", "Stephen M. R. Covey",Category.BUSINESS,35.0));
        productsDB.put(10, new Product(10,"Winners Take All", "Anand Giridharadas",Category.BUSINESS,30.0));

        //HISTORY
        productsDB.put(11, new Product(11,"The Pioneers", "David McCullough",Category.HISTORY,18.99));
        productsDB.put(12, new Product(12,"Landing in Hell", "Peter Margaritis",Category.HISTORY,40.99));
        productsDB.put(13, new Product(13,"The British Are Coming", "Rick Atkinson",Category.HISTORY,15.99));
        //MYSTERY
        productsDB.put(14, new Product(14,"Knife (Harry Hole Series #12)", "Jo Nesbo",Category.MYSTERY,13.99));
        productsDB.put(15, new Product(15,"Unsolved", "James Patterson",Category.MYSTERY,14.99));
    }

    public static List<Product> getAllProducts(){
        return new ArrayList<>(productsDB.values());
    }

    public static Product getProductById(int productId){
        return productsDB.get(productId);
    }


}