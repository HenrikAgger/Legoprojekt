/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Henrik
 */
public class ViewOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        List<Order> orderList;
        if (customer.isAdmin()) {
            orderList = LogicFacade.getAllOrders(customer.getCustomer_id());
        } else {
            orderList = LogicFacade.getCustomerOrders(customer.getCustomer_id());
        }

        request.setAttribute("orderList", orderList);

        return "vieworders";
    }  
}   

