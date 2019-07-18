package model;



public class User {

    private int id;
    private String username;
    private String password;
    private String address;
    private Cart card = new Cart();
    private Auth type;

    //constructors
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.type = Auth.CUSTOMER;
    }

    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password=password;
        this.type = Auth.CUSTOMER;
    }

    // getter methods
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Auth getType() {
        return type;
    }

    // setter methods
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCard(Cart card) {
        this.card = card;
    }

    public Cart getCard() {
        return card;
    }

    public void setType(Auth type) {
        this.type = type;
    }
}
