package Servlets;

import Model.Customer;
import Model.Loyalty;
import Services.CustomerService;
import Services.LoyaltyService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet{
    CustomerService cs = new CustomerService();

    LoyaltyService ls = new LoyaltyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String action = request.getParameter("searchAction");
        if(action != null)
        {
            switch (action){
                case "searchByName":
                    searchCustName(request, response);
                    break;
                case "editCustPage":
                    editCustPopulate(request, response);
                    break;
                case "displayInfo":
                    displayYo(request, response);
                    break;
            }
        }
        else{
            List<Customer> result = cs.getCustomerList();
            forwardCustomers(request, response, result);
        }
    }

    private void displayYo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String id = request.getParameter("idCustomer");
        Customer cunt = null;
        Loyalty loyalCunt = null;
        cunt = cs.findByID(id);
        if(ls.searchLoyaltyid(id) != null){
            cunt.setLoyalty(ls.searchLoyaltyid(cunt.getId()));
        } else {
            cunt.setLoyalty(null);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/JSP/Customer/displayCustomer.jsp");
        request.setAttribute("customer",cunt);
        rd.forward(request, response);
    }

    private void searchCustName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String custName = request.getParameter("customerName");
        List<Customer> result = cs.searchCustomerYo(custName);
        forwardCustomers(request,response,result);

    }

    private void editCustPopulate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String id = request.getParameter("idCustomer");
        String jsp = "/JSP/Customer/amendCustomer.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        Customer cust = cs.findByID(id);
        request.setAttribute("customer", cust);
        rd.forward(request, response);
    }

    private void forwardCustomers(HttpServletRequest request, HttpServletResponse response, List<Customer> csListYo) throws ServletException, IOException{
        String jsp = "/JSP/Customer/customerdetails.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
        request.setAttribute("customerList", csListYo);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String action = request.getParameter("action");
        switch (action) {
            case "addCustomer":
                addCustomer(request, response);
                break;
            case "editCustomer":
                editCustomer(request,response);
                break;
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String firstName = request.getParameter("firstNameYo");
        String surname = request.getParameter("surnameYo");
        String email = request.getParameter("emailYo");
        String credit = request.getParameter("creditYo");
        Double checkYo = 0.0;
        try {
            checkYo = Double.parseDouble(credit);
        }catch (NumberFormatException e){

        }

        Customer createCust = new Customer(getNextId(), firstName, surname, email, checkYo);
        cs.addCustomer(createCust);
        forwardCustomers(request, response,cs.getCustomerList());

    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String id = request.getParameter("idCustomer");
        String firstName = request.getParameter("firstNameYo");
        String surname = request.getParameter("surnameYo");
        String email = request.getParameter("emailYo");
        Double credit = Double.parseDouble(request.getParameter("creditYo"));


        Customer cust = new Customer(id, firstName, surname, email,credit);
        cs.editCustomer(cust);

        forwardCustomers(request, response, cs.getCustomerList());
    }

    private String getNextId(){
        int num = cs.getCustomerList().size() +1 ;
        String id = String.valueOf(num);
        return id;
    }

}
