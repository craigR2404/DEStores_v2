package Servlets;

import Model.Product;
import Services.ProductService;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
    ProductService ps = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{


        String action = request.getParameter("searchAction");
        if(action != null)
        {
            switch (action){
                case "searchByName":
                    searchProdName(request, response);
                    break;
                case "findProduct":
                    findProductYo(request,response);
                    break;
                case "editProduct":
                    editProductPopulate(request,response);
                    break;
                case "reportAction":
                    goIntoSearchReport(request,response);
            }
        }
        else{
            List<Product> result = ps.getProductList();
            forwardProducts(request, response, result);
        }
    }

    private void searchProdName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String prodName = request.getParameter("productName");
        List<Product> result = ps.searchProduct(prodName);
        forwardProducts(request,response,result);

    }

    private void searchReport(HttpServletRequest request, HttpServletResponse response, List<Product> csListYo)throws ServletException, IOException{
        String jsp = "/JSP/Report/reportDetails.jsp";
        String productID = "999";
        ps.getReportYo(productID);
        RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
        request.setAttribute("productList", csListYo);
        dispatcher.forward(request,response);
    }

    private void goIntoSearchReport(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        List<Product> reslut = ps.getProductList();

        searchReport(request,response,reslut);
    }

    private void findProductYo(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        String productID = request.getParameter("idProduct");
        Product result = ps.findByID(productID);
        RequestDispatcher rd = request.getRequestDispatcher("/JSP/Products/amendDetails.jsp");
        request.setAttribute("product", result);
        rd.forward(request, response);
    }

    private void editProductPopulate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String id = request.getParameter("idProduct");
        String jsp = "/JSP/Products/amendDetails.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        Product prod = ps.findByID(id);
        request.setAttribute("product", prod);
        rd.forward(request,response);
    }

    private void forwardProducts(HttpServletRequest request, HttpServletResponse response, List<Product> csListYo) throws ServletException, IOException{
        String jsp = "/JSP/Products/productdetails.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
        request.setAttribute("productList", csListYo);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String action = request.getParameter("action");
        switch (action) {
            case "addProduct":
                addProduct(request, response);
                break;
            case "editProductYo":
                editProductDetails(request,response);
                break;
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String name = request.getParameter("name");
        Integer stock = request.getIntHeader("stockLevel");
        String price = request.getParameter("price");
        String promotion = request.getParameter("promotion");
        Double priceYo = 0.0;
        try {
            priceYo = Double.parseDouble(price);
        }catch (NumberFormatException e){

        }

        Product createProd = new Product(getNextId(), name, stock, priceYo, promotion);
        ps.addProd(createProd);
        forwardProducts(request, response,ps.getProductList());

    }

    private void editProductDetails(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String id = request.getParameter("idProduct");
        String name = request.getParameter("name");
        Integer stockLevel = Integer.parseInt(request.getParameter("stockLevel"));
        Double price = Double.parseDouble(request.getParameter("price"));
        String promotion = request.getParameter("promotion");

        Product prod = new Product(id,name,stockLevel,price,promotion);
        ps.editProduct(prod);

        forwardProducts(request,response,ps.getProductList());

    }

    private String getNextId(){
        int num = ps.getProductList().size() +1 ;
        String id = String.valueOf(num);
        return id;
    }

}
