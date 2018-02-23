package Services;

import DAL.CustomerDAL;
import DataYo.CustomerData;
import Model.Customer;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



public class CustomerService {
    private List<Customer> customerList = CustomerData.getInstance();
    private CustomerDAL custDAl = new CustomerDAL();
    private Customer custAspect = new Customer();





    public List<Customer> getCustomerList() {

        return custDAl.getAllCustomers();
    }

    public List<Customer> searchCustomerYo(String name)
    {
        List<Customer> result = custDAl.getAllCustomers()
                .stream()
                .filter(customer -> customer.getNameYo().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        return result;
    }

    public void addCustomer(Customer customer){

        if(custDAl.addCustomer(customer))
        {
            custAspect = customer;
            customerAdded();
        }

    }

    public Customer customerAdded(){
        System.out.println("Customer has been saved");
        return custAspect;
    }

    public void editCustomer(Customer customer){
        int captureIndex = 0;
        Optional<Customer> capture = customerList
                .stream()
                .filter(customerid -> customerid.getId().equals(customer.getId()))
                .findFirst();
        if(capture.isPresent()){
            captureIndex = customerList.indexOf(capture.get());
            customerList.set(captureIndex, customer);
        }
    }

    public Customer findByID(String id){
        Optional<Customer> reslut = custDAl.getAllCustomers()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
        return reslut.get();
    }
}

