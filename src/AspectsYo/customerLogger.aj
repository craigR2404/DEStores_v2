package AspectsYo;

import Model.Customer;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public aspect customerLogger {



     pointcut  callCustAdd(): call(* Services.CustomerService.customerAdded());

    after() returning(Customer customer) : callCustAdd(){
        System.out.println(customer.getNameYo());



        Logger logger = Logger.getLogger("LogYo");

        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("C:/temp/test/CustomerLogFile.log");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.info("New user has been added " + customer.getNameYo() + customer.getSurnameYo());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

