package Servlets;

import Model.Loyalty;
import Services.LoyaltyService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "LoyaltyServlet", urlPatterns = {"/loyalty"})
public class LoyaltyServlet extends HttpServlet {
    LoyaltyService ls = new LoyaltyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        String action = request.getParameter("searchAction");
        if(action != null)
        {
            switch (action){
                case "searchByID":
                    break;
                case "editCard":
                    editCard(request, response);
                    break;

            }
        }
        else{
            List<Loyalty> result = ls.getLoyaltyList();
            forwardLoyalty(request, response, result);
        }
    }

    private void forwardLoyalty(HttpServletRequest request, HttpServletResponse response, List<Loyalty> lsListYo) throws ServletException, IOException{
        String jsp = "/JSP/Loyalty/loyaltyDetails.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
        request.setAttribute("loyaltyList", lsListYo);
        dispatcher.forward(request,response);
    }

    private void editCard(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String id = request.getParameter("cardId");
        Integer idParsed = Integer.parseInt(id);
        Loyalty loyalty = ls.searchByCard(idParsed);
        request.setAttribute("loyalty", loyalty);
        RequestDispatcher rd = request.getRequestDispatcher("/JSP/Loyalty/loyaltyEdit.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String action = request.getParameter("action");
        switch (action){
            case "editLoyalty":
                editLoyaltyAction(request,response);
                break;
        }
    }

    private void editLoyaltyAction(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        Integer cardID = Integer.parseInt(request.getParameter("idCard"));
        String discountValue = request.getParameter("discountYo");
        Loyalty loyalty = ls.searchLoyaltyidAgain(cardID);

        loyalty.setExtraDiscount(discountValue);
        ls.editCard(loyalty);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}

