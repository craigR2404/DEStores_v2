package DataYo;

import Model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderData {
    private static final List<Order> orderList = new ArrayList();

    private OrderData(){

    }
    static{
        orderList.add(new Order("1", new Date(),420.00, "1", 4.20, false,"Box of Screws"));
        orderList.add(new Order("2", new Date(),666.00, "2", 4.20, false,"Crabtree 17th Edition Fuseboard"));
        orderList.add(new Order("3", new Date(),2000.00, "3", 0.00, true, "Box of Screws"));
        orderList.add(new Order("4", new Date(),420.00, "1", 4.20, false,"Box of Screws"));
        orderList.add(new Order("5", new Date(),666.00, "2", 4.20, false,"Widden Pallet"));
        orderList.add(new Order("6", new Date(),2000.00, "3", 0.00, true, "Kitchen Sink"));
        orderList.add(new Order("7", new Date(),420.00, "1", 4.20, false,"RAWL Plugs"));
        orderList.add(new Order("8", new Date(),666.00, "2", 4.20, false,"Cat5e Cable"));
        orderList.add(new Order("9", new Date(),2000.00, "3", 0.00, true, "Box of Screws"));
    }

    public  static  List<Order> getInstance() {return orderList;}
}

