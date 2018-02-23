package Model;

public class Product {
    private String id;
    private String name;
    private Integer stockLevel;
    private Double price;
    private String promotion;
    private Order order;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public Product(String id, String name, Integer stockLevel,Double price, String promotion){
        this.id = id;
        this.name = name;
        this.stockLevel = stockLevel;
        this.price = price;
        this.promotion = promotion;
    }

    public Product(){

    }
}

