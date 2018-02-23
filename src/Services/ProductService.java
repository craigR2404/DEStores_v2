package Services;

import DAL.ProductDAL;
import DataYo.ProductData;
import Model.Product;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> productList = ProductData.getInstance();
    private ProductDAL proDAL = new ProductDAL();
    private Product prodAspect = new Product();



    public List<Product> getProductList() {

        return proDAL.getAllProducts();
    }

    public List<Product> searchProduct(String name){
        List<Product> result = productList
                .stream()
                .filter(Product -> Product.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        return result;
    }

    public void addProd(Product product)
    {
        if(proDAL.addProduct(product))
        {
            prodAspect = product;
            productAdded();
        }

    }

    public Product productAdded(){
        System.out.println("Product has been added");
        return prodAspect;
    }

    public void getReportYo(String productID){
        Optional<Product> reslut = productList
                .stream()
                .findAny();


    }

    public void editProduct(Product product)
    {
        int captureIndex = 0;
        Optional<Product> capture = productList
                .stream()
                .filter(Product -> Product.getId().equals(product.getId()))
                .findFirst();
        if(capture.isPresent()){
            captureIndex = productList.indexOf(capture.get());
            productList.set(captureIndex, product);
        }
    }
    public Product findByID(String ID){
        Optional<Product> reslut = productList.stream().filter(product -> product.getId().equals(ID)).findFirst();
        return reslut.get();
    }
}
