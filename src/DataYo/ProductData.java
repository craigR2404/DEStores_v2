package DataYo;

import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
    private static final List<Product> productList = new ArrayList();

    private ProductData(){

    }

    static {
        productList.add(new Product("1","Mk Logic Sockets",200,22.50,"3 for 2"));
        productList.add((new Product("2", "Crabtree 17th Edition Fuseboard", 150, 45.00, "None")));
        productList.add((new Product("3","Box of Screws",5000, 6.66,"Buy one get one free")));
        productList.add(new Product("4","2.5mm T+E Cable",200,32.60,"3 for 2"));
        productList.add((new Product("5", "1.5mm T+E Cable", 150, 24.65, "None")));
        productList.add((new Product("6","Widden Pallet",5000, 6.66,"Buy one get one free")));
        productList.add(new Product("7","Kitchen Sink",200,22.50,"3 for 2"));
        productList.add((new Product("8", "Haler IP65 Lights", 150, 45.00, "None")));
        productList.add((new Product("9","Cat5e Cable",5000, 6.66,"Buy one get one free")));
        productList.add(new Product("10","RJ45 Connectors",200,22.50,"3 for 2"));
        productList.add((new Product("11", "Meatballs like Ikea", 150, 45.00, "None")));
        productList.add((new Product("12","Nails",5000, 6.66,"Buy one get one free")));
        productList.add(new Product("13","RAWL Plugs",200,22.50,"3 for 2"));
        productList.add((new Product("14", "Cable Clips", 150, 45.00, "None")));
        productList.add((new Product("15","Cable Ties",5000, 6.66,"Buy one get one free")));
    }

    public static List<Product> getInstance() {
        return productList;}
}
