/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 *
 * @author oteee
 */
public class addOrder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addOrder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addOrder at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("shoping-cart.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OwnerDatabase foodDAO = new OwnerDatabase();
        DatabaseConnector dc = new DatabaseConnector();
        Customer cu = (Customer) request.getSession().getAttribute("accout");
        List<orderDetail> cartList = dc.getCusID(cu.getCustomerID());
        List<Integer> noShop = null;
        try {
            noShop = foodDAO.getShopIDs(cu.getCustomerID());
        } catch (SQLException ex) {
            request.setAttribute("MSG", ex + "1");
            request.getRequestDispatcher("fail.jsp").forward(request, response);
            Logger.getLogger(addOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
//            Order or = dc.insertOrder(cu.getCustomerID());
            List<orderShop> orderShopList = foodDAO.processOrderDetails(noShop, cu.getCustomerID());

            String quantityParam1 = "quantity" + 0;
            int quantity1 = Integer.parseInt(request.getParameter(quantityParam1));
            for (orderShop shop : orderShopList) {
                for (orderDetail detail : cartList) {
                    if (detail.getShopID() == shop.getShopID()) {
                        String quantityParam = "quantity" + cartList.indexOf(detail);
                        int quantity = Integer.parseInt(request.getParameter(quantityParam));
                        dc.updateOrder(quantity, detail.getOrderDetailID(), shop.getOrderShopID());
                    }
                }
            }
            response.sendRedirect("browsing");
        } catch (SQLException ex) {
            request.setAttribute("MSG", ex);
            request.getRequestDispatcher("fail.jsp").forward(request, response);
        }

    }

    public addOrder() {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
