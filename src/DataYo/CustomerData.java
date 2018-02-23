package DataYo;

import Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerData {
    private static final List<Customer> customerList = new ArrayList();

    private CustomerData(){

    }

    static{
        customerList.add(new Customer("1", "Bawbag","Russell", "avon@avon.com",500.00));
        customerList.add(new Customer("2", "Neil", "Earlam", "lovestheboab@boabydaft.com",1000.50));
        customerList.add(new Customer("3", "Andy", "Morrison", "boiledeggs@4lyfe.com", 0.00));
        customerList.add(new Customer("4", "Xiaodong", "Liu", "bossman@theboss.com", 2000.00));
        customerList.add(new Customer("5", "YerDa", "Sellsthe", "avonboss@avon.com", 1500.00));
    }

    public static List<Customer> getInstance()
    {
        return customerList;
    }
}
