/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import model.*;

import model.DatabaseConnector;

/**
 *
 * @author oteee
 */
public class loginServlet extends HttpServlet {

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
            out.println("<title>Servlet loginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        OwnerDatabase ownerDAO = new OwnerDatabase();
        if ("Owner".equals(role)) {
            Owner ow;
            try {
                ow = ownerDAO.loginOwner(email, password);
                if (ow != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("accout", ow);
                    request.getRequestDispatcher("shop-grid.jsp").forward(request, response);
                } else {
                    request.setAttribute("errorMessage", "Invalid email or password. Please try again.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("MSG", ex);
                request.getRequestDispatcher("fail.jsp").forward(request, response);
            }

        } else if ("Customer".equals(role)) {
            if (email == null || email.isEmpty() || password == null || password.isEmpty() || role == null || role.isEmpty()) {
                request.setAttribute("errorMessage", "Invalid email or password. Please try again.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            try ( Connection connection = DatabaseConnector.getConnection()) {
                String insertQuery = "SELECT * FROM customer WHERE email=? AND password=?";
                try ( PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, password);
                    try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            Customer customer = new Customer();
                            customer.setCustomerID(resultSet.getInt("cusID"));
                            customer.setAddress(resultSet.getString("address"));
                            customer.setPhone(resultSet.getString("phone"));
                            customer.setPassWord(resultSet.getString("password"));
                            customer.setName(resultSet.getString("name"));
                            customer.setEmail(resultSet.getString("email"));

                            HttpSession session = request.getSession();
                            session.setAttribute("accout",customer);
                            request.getRequestDispatcher("shop-grid.jsp").forward(request, response);

                        } else {
                            request.setAttribute("errorMessage", "Invalid email or password. Please try again.");
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("login.jsp?error=Database error" + e);
            }
        }
//        else if ("Shipper".equals(role)) {
//            if (ShiperDB.loginShipper(email, password)) {
//                out.println("Shipper login successful!");
//            } else {
//                out.println("Shipper login failed.");
//            }
//        } else {
//            out.println("Invalid role.");
//        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
