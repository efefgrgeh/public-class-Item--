``java
import java.util.ArrayList;
import java.util.List;

interface Store {
    void addProduct(Product product);
    void sellProduct(Product product);
    void editProduct(Product product, String newName, double newPrice);
}

class Product {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}

class Newspaper extends Product {
    private int issueNumber;
    
    public Newspaper(String name, double price, int issueNumber) {
        super(name, price);
        this.issueNumber = issueNumber;
    }
    
    public int getIssueNumber() {
        return issueNumber;
    }
    
    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
}

class Magazine extends Product {
    private String category;
    
    public Magazine(String name, double price, String category) {
        super(name, price);
        this.category = category;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
}

class Book extends Product {
    private String author;
    
    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
}

class NewspaperKiosk implements Store {
    private List<Product> products;
    
    public NewspaperKiosk() {
        this.products = new ArrayList<>();
    }
    
    @Override
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }
    
    @Override
    public void sellProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
            System.out.println("Product sold: " + product.getName());
        } else {
            System.out.println("Product not found");
        }
    }
    
    @Override
    public void editProduct(Product product, String newName, double newPrice) {
        if (products.contains(product)) {
            product.setName(newName);
            product.setPrice(newPrice);
            System.out.println("Product edited: " + product.getName());
        } else {
            System.out.println("Product not found");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NewspaperKiosk kiosk = new NewspaperKiosk();
        
        Newspaper newspaper1 = new Newspaper("Newspaper 1", 2.5, 1);
        Magazine magazine1 = new Magazine("Magazine 1", 5.0, "Fashion");
        Book book1 = new Book("Book 1", 10.0, "Author 1");
        
        kiosk.addProduct(newspaper1);
        kiosk.addProduct(magazine1);
        kiosk.addProduct(book1);
        
        kiosk.sellProduct(newspaper1);
        
        kiosk.editProduct(magazine1, "New Magazine", 7.5);
    }
}
```

