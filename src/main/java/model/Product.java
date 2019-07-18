package model;

public class Product {
    private int id;
    private String name;
    private String author;
    private String description;
    private double price;
    private String picturePath;
    private Category category;

    //constructors

    public Product(String name, String author, Category category, double price){
        this.name = name;
        this.author = author;
        this.description = name;
        this.price = price;
        this.picturePath = "/books/book"+id+".jpg";
        this.category = category;
    }

    public Product(int id, String name, String author, Category category, double price){
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = name;
        this.price = price;
        this.picturePath = "/books/book"+id+".jpg";
        this.category = category;
    }

    //getter methods

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public String getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    //setter methods

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        Product prod = (Product) obj;

        return (prod.name == this.name && prod.id == this.id);
    }

    @Override
    public int hashCode()
    {
        return this.id;
    }

    @Override
    public String toString() {
        return "Product [ id:"+getId()+
                ",name:"+getName()+
                ",author:"+getAuthor()+
                ",description:"+getDescription()+
                ",img:"+getPicturePath()+
                ",price:"+getPrice()+
                ",category:"+getCategory()+" ]";
    }
}
