package Model;

import java.util.Date;
import java.util.List;

public class Order {

    private String orderId;
    private Date date;
    private Double Total;
    private String customerID;
    private String firstname;
    private String surname;
    private Double deliverCost;
    private Boolean freedelivery;
    private String product;
    private Product proddy;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    //private List<Order> order;


    public Boolean getFreedelivery() {
        return freedelivery;
    }

    public void setFreedelivery(Boolean freedelivery) {
        this.freedelivery = freedelivery;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Double getDeliverCost() {
        return deliverCost;
    }

    public void setDeliverCost(Double deliverCost) {
        this.deliverCost = deliverCost;
    }

    public String getId() {
        return orderId;
    }

    public void setId(String id) {
        this.orderId = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }

    public Order(String orderId, Date date, Double Total, String customerID, Double deliverCost, Boolean freedelivery, String product){
        this.orderId = orderId;
        this.date = date;
        this.Total = Total;
        this.customerID = customerID;
        this.deliverCost = deliverCost;
        this.freedelivery = freedelivery;
        this.product = product;

    }




}
