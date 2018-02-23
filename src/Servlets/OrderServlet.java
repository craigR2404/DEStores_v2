package Servlets;

import Model.Customer;
import Model.Order;
import Model.Product;
import Services.CustomerService;
import Services.OrderService;
import Services.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
    OrderService os = new OrderService();
    ProductService ps = new ProductService();
    CustomerService cs = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("searchAction");
        if (action != null) {
            switch (action) {
                case "searchOrderById":
                    editOrderPopulate(request,response);
                    break;
                case "addOrder":
                    addOrderRoute(request, response);
                    break;

            }
        }else{
                List<Order> result = os.getOrderList();
                forwardorder(request,response,result);
        }
    }

    private void addOrderRoute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        List<Product> productListYo = ps.getProductList();
        List<Customer> customerListYo = cs.getCustomerList();
        request.setAttribute("customerList", customerListYo);
        request.setAttribute("proddyList", productListYo);
        RequestDispatcher rd = request.getRequestDispatcher("/JSP/Order/newOrder.jsp");
        rd.forward(request, response);

    }

    private void editOrderPopulate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String id = request.getParameter("idOrder");
        String jsp = "/JSP/Order/updateOrder.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        Order order = os.findByID(id);
        request.setAttribute("order", order);
        rd.forward(request,response);
    }

    private void forwardorder(HttpServletRequest request, HttpServletResponse response, List<Order> orderList) throws ServletException, IOException {
        String jsp = "/JSP/Order/orderdetails.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
        request.setAttribute("orderList", orderList);
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        {
            switch (action) {
                case "add":
                    addOrder(request, response);
                    break;

                case "edit":
                    editOrder(request,response);
                    break;
            }
        }
    }


    //doPost methods to be carried out

    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        String customerID = request.getParameter("customer");
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Date date = new Date();
        Boolean freedelivery = Boolean.parseBoolean(request.getParameter("freedelivery"));
        String orderId = UUID.randomUUID().toString();
        Double deliverCost = 4.20;

        if(freedelivery.equals(true))
        {
            deliverCost = 0.0;
        }
        Product proddy = ps.findByID(product);
        Double Total = proddy.getPrice()*quantity + deliverCost;

        try {
            deliverCost = Double.parseDouble("deliverCost");
            Total = Double.parseDouble("Total");
        } catch (NumberFormatException e) {


            Order order = new Order(orderId, date, Total, customerID, deliverCost, freedelivery, proddy.getName());
            os.addOrder(order);
            forwardorder(request, response, os.getOrderList());


        }
    }

    private void editOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        String customerID = request.getParameter("customerID");
        String orderId = request.getParameter("orderId");
        Date date = new Date();
        Boolean freedelivery = request.isRequestedSessionIdFromURL();
        Double deliverCost = 0.0;
        Double Total = 0.0;
        try {
            deliverCost = Double.parseDouble("deliverCost");
            Total = Double.parseDouble("Total");
        } catch (NumberFormatException e) {


            Order order = new Order(orderId, date, Total, customerID, deliverCost, freedelivery, product);
            os.editOrder(order);
            forwardorder(request, response, os.getOrderList());


        }
    }

}
