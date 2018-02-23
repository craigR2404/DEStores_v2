package Services;

import DataYo.OrderData;
import Model.Order;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orderList = OrderData.getInstance();


    public List<Order> getOrderList() {
        return orderList;
    }

    public  Order getOrderYo(String orderId) throws Exception {
        Optional<Order> reslut = orderList
                .stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst();
        if (reslut.isPresent()) {
            return reslut.get();
        }else{
            return null;
        }

    }

    public List<Order> searchOrder(String orderId)
    {
        List<Order> result = orderList
                .stream()
                .filter(order -> order.getOrderId().equalsIgnoreCase(orderId))
                .collect(Collectors.toList());
        return result;
    }

    public void addOrder(Order order){

        orderList.add(order);
    }

    public void editOrder(Order order)
    {
        int captureIndex = 0;
        Optional<Order> capture = orderList
                .stream()
                .filter(Product -> Product.getId().equals(order.getId()))
                .findFirst();
        if(capture.isPresent()){
            captureIndex = orderList.indexOf(capture.get());
            orderList.set(captureIndex, order);
        }
    }

    public Order findByID(String orderId){
        Optional<Order> reslut = orderList.stream().filter(order -> order.getId().equals(orderId)).findFirst();
        return reslut.get();
    }
}
