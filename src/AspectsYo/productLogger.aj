package AspectsYo;

import Model.Product;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public aspect productLogger {
    pointcut callProdAdd(): call(* Services.ProductService.*());

    after() returning(Product product) : callProdAdd(){
        System.out.println(product.getName());

        Logger logger = Logger.getLogger("LogYo");

        FileHandler fileHandler;
        try{
            fileHandler = new FileHandler("C:/temp/test/ProductLogFile.log");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.info("New product has been added " + product.getName() + " stock is now at " + product.getStockLevel());

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
