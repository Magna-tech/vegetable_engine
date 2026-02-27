package VegetableClient;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VegetableServer.*;

// The @WebServlet annotation maps this class to a URL the HTML can call
@WebServlet("/VegetableServlet")
public class VegetableServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response type for the "mobile" client
        response.setContentType("text/plain");
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        
        try {
            //Add vegetable
            if ("add".equalsIgnoreCase(action)) {
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                out.println(VegetableComputeTaskRegistry.runTask(new VegetableServer.AddVegetablePrice(name, price)));
            } 
            //Calculate Cost
            else if ("calculateCost".equalsIgnoreCase(action)) {
                String name = request.getParameter("name");
                double qty = Double.parseDouble(request.getParameter("qty"));
                Double total = VegetableComputeTaskRegistry.runTask(new VegetableServer.CalVegetableCost(name, qty));
                out.println("Total Cost: " + total);
            }
            //Print Receipt
            else if ("receipt".equalsIgnoreCase(action)) {
                double total = Double.parseDouble(request.getParameter("total"));
                double paid = Double.parseDouble(request.getParameter("paid"));
                String cashier = request.getParameter("cashier");
                out.println(VegetableComputeTaskRegistry.runTask(new VegetableServer.CalculateCost(total, paid, cashier)));
            }
        } catch (Exception e) {
            out.println("Error processing task: " + e.getMessage());
        }
    }
}